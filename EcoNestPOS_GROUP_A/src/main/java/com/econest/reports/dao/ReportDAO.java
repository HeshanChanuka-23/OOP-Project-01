package com.econest.reports.dao;

import com.econest.catalog.model.Product;
import com.econest.catalog.model.ProductCategory;
import com.econest.config.DatabaseConnection;
import com.econest.reports.model.InventoryReport;
import com.econest.reports.model.SalesReport;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/** Read-only report queries: never changes order totals, inventory, or journal entries. */
public class ReportDAO {
    private static final String IN_TYPES = "('OPENING_BALANCE','STOCK_IN','CANCEL_RESTOCK','ADJUSTMENT_IN')";
    private static final String OUT_TYPES = "('SALE_OUT','WRITE_OFF','ADJUSTMENT_OUT')";

    public SalesReport readSales(YearMonth month) throws SQLException {
        // Two event-time queries: statuses of orders today must not rewrite historical sales.
        String sql = "SELECT "
                + "COALESCE(SUM(CASE WHEN confirmed_at >= ? AND confirmed_at < ? THEN total_amount ELSE 0 END),0) gross, "
                + "COALESCE(SUM(CASE WHEN cancelled_at >= ? AND cancelled_at < ? AND confirmed_at IS NOT NULL "
                + "THEN total_amount ELSE 0 END),0) cancelled, "
                + "COALESCE(SUM(CASE WHEN confirmed_at >= ? AND confirmed_at < ? THEN 1 ELSE 0 END),0) confirmed_count, "
                + "COALESCE(SUM(CASE WHEN cancelled_at >= ? AND cancelled_at < ? THEN 1 ELSE 0 END),0) cancelled_count "
                + "FROM orders";
        Timestamp begin = start(month), end = end(month);
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 1; i <= 8; i += 2) { ps.setTimestamp(i, begin); ps.setTimestamp(i + 1, end); }
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return new SalesReport(month, rs.getBigDecimal("gross"), rs.getBigDecimal("cancelled"),
                        rs.getInt("confirmed_count"), rs.getInt("cancelled_count"), LocalDateTime.now());
            }
        }
    }

    public List<Product> readCurrentLowStock() throws SQLException {
        String sql = "SELECT p.product_id, p.name, p.category, p.description, p.unit_price, p.eco_rating "
                   + "FROM inventory i JOIN products p ON p.product_id=i.product_id "
                   + "WHERE i.quantity_on_hand <= i.reorder_level ORDER BY i.quantity_on_hand, p.name";
        List<Product> result = new ArrayList<>();
        try (Connection c=DatabaseConnection.getConnection();
             PreparedStatement ps=c.prepareStatement(sql); ResultSet rs=ps.executeQuery()) {
            while (rs.next()) {
                Product p=new Product();
                p.setProductId(rs.getInt("product_id"));
                p.setName(rs.getString("name"));
                p.setCategory(ProductCategory.valueOf(rs.getString("category")));
                p.setDescription(rs.getString("description"));
                p.setUnitPrice(rs.getBigDecimal("unit_price"));
                p.setEcoRating(rs.getInt("eco_rating"));
                result.add(p);
            }
        }
        return result;
    }

    public InventoryReport readInventory(YearMonth month) throws SQLException {
        // The whole movement history is authoritative, even when a product was hard-deleted.
        String sql = "SELECT "
                + "COALESCE(SUM(CASE WHEN movement_type IN " + IN_TYPES + " THEN quantity ELSE -quantity END),0) ending_units, "
                + "COALESCE(SUM(CASE WHEN occurred_at >= ? AND movement_type IN " + IN_TYPES + " THEN quantity ELSE 0 END),0) inbound, "
                + "COALESCE(SUM(CASE WHEN occurred_at >= ? AND movement_type IN " + OUT_TYPES + " THEN quantity ELSE 0 END),0) outbound "
                + "FROM stock_movements WHERE occurred_at < ?";
        int endUnits, inbound, outbound;
        try (Connection c=DatabaseConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setTimestamp(1,start(month)); ps.setTimestamp(2,start(month)); ps.setTimestamp(3,end(month));
            try (ResultSet rs=ps.executeQuery()) {
                rs.next();
                endUnits = Math.toIntExact(rs.getLong("ending_units"));
                inbound = Math.toIntExact(rs.getLong("inbound"));
                outbound = Math.toIntExact(rs.getLong("outbound"));
            }
        }
        return new InventoryReport(month, LocalDateTime.now(), endUnits, inbound, outbound, readCurrentLowStock());
    }

    /** Per-product journal totals, including deleted products with historical movements. */
    public List<Object[]> readMonthlyStockRows(YearMonth month) throws SQLException {
        String sql="SELECT m.product_id_at_movement id, "
            + "COALESCE(p.name, MAX(m.product_name_at_movement)) product_name, "
            + "COALESCE(SUM(CASE WHEN m.movement_type IN " + IN_TYPES + " THEN m.quantity ELSE -m.quantity END),0) ending_units, "
            + "COALESCE(SUM(CASE WHEN m.occurred_at >= ? AND m.movement_type IN " + IN_TYPES + " THEN m.quantity ELSE 0 END),0) inbound, "
            + "COALESCE(SUM(CASE WHEN m.occurred_at >= ? AND m.movement_type IN " + OUT_TYPES + " THEN m.quantity ELSE 0 END),0) outbound "
            + "FROM stock_movements m LEFT JOIN products p ON p.product_id=m.product_id_at_movement "
            + "WHERE m.occurred_at < ? GROUP BY m.product_id_at_movement, p.name ORDER BY m.product_id_at_movement";
        Map<Integer,Object[]> rows = new LinkedHashMap<>();
        try(Connection c=DatabaseConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setTimestamp(1,start(month)); ps.setTimestamp(2,start(month)); ps.setTimestamp(3,end(month));
            try(ResultSet rs=ps.executeQuery()) {
                while(rs.next()) {
                    int id=rs.getInt("id");
                    rows.put(id,new Object[]{id,rs.getString("product_name"),
                        Math.toIntExact(rs.getLong("inbound")),Math.toIntExact(rs.getLong("outbound")),
                        Math.toIntExact(rs.getLong("ending_units"))});
                }
            }
        }
        // Historical correctness: products.created_at does not exist in the schema.
        // An existing product with no journal events could have been created AFTER
        // the requested historical month. Never claim it existed back then.
        // For the current month only, show today's existing zero-movement products.
        if (includeCurrentZeroMovementProducts(month, YearMonth.now())) {
            try(Connection c=DatabaseConnection.getConnection(); PreparedStatement ps=c.prepareStatement(
                    "SELECT product_id,name FROM products ORDER BY product_id"); ResultSet rs=ps.executeQuery()) {
                while(rs.next()) {
                    int id=rs.getInt(1);
                    rows.putIfAbsent(id,new Object[]{id,rs.getString(2),0,0,0});
                }
            }
        }
        List<Object[]> result=new ArrayList<>(rows.values());
        result.sort(Comparator.comparingInt(v -> (Integer)v[0]));
        return result;
    }

    /**
     * Reporting policy: only current-month zero-journal products are provably
     * present now. Past/future reports require a journal entry before the
     * report cutoff to establish historical existence. Explicit clock argument
     * allows deterministic regression tests.
     */
    static boolean includeCurrentZeroMovementProducts(YearMonth reportMonth, YearMonth currentMonth) {
        return reportMonth != null && reportMonth.equals(currentMonth);
    }

    /** Current low-stock levels rather than the report month's ending levels. */
    public List<Object[]> readLowStockRows() throws SQLException {
        String sql="SELECT p.product_id,p.name,i.quantity_on_hand,i.reorder_level "
                + "FROM inventory i JOIN products p ON p.product_id=i.product_id "
                + "WHERE i.quantity_on_hand <= i.reorder_level ORDER BY i.quantity_on_hand,p.name";
        List<Object[]> result=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection(); PreparedStatement ps=c.prepareStatement(sql);
            ResultSet rs=ps.executeQuery()) {
            while(rs.next()) result.add(new Object[]{rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getInt(4)});
        }
        return result;
    }
    private static Timestamp start(YearMonth month) { return Timestamp.valueOf(month.atDay(1).atStartOfDay()); }
    private static Timestamp end(YearMonth month) { return Timestamp.valueOf(month.plusMonths(1).atDay(1).atStartOfDay()); }
}
