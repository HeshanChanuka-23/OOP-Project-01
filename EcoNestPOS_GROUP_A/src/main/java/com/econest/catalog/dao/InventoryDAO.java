package com.econest.catalog.dao;

import com.econest.catalog.model.*;
import com.econest.config.DatabaseConnection;
import java.sql.*;
import java.util.*;

/** SQL only; methods receiving a Connection take part in the caller's transaction. */
public class InventoryDAO {

    public List<Inventory> listInventory() throws SQLException {
        List<Inventory> items = new ArrayList<>();
        String sql = "SELECT product_id, quantity_on_hand, reorder_level FROM inventory ORDER BY product_id";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) items.add(new Inventory(rs.getInt(1), rs.getInt(2), rs.getInt(3)));
        }
        return items;
    }

    public List<InventoryRow> listInventoryRows(boolean lowOnly) throws SQLException {
        List<InventoryRow> rows = new ArrayList<>();
        String sql = "SELECT p.product_id, p.name, p.category, i.quantity_on_hand, i.reorder_level "
                   + "FROM inventory i JOIN products p ON p.product_id=i.product_id "
                   + (lowOnly ? "WHERE i.quantity_on_hand <= i.reorder_level " : "")
                   + "ORDER BY p.name, p.product_id";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) rows.add(new InventoryRow(rs.getInt(1), rs.getString(2), rs.getString(3),
                                                         rs.getInt(4), rs.getInt(5)));
        }
        return rows;
    }

    public int getAvailableStock(int productId) throws SQLException {
        String sql = "SELECT quantity_on_hand FROM inventory WHERE product_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new SQLException("Inventory row missing for product #" + productId);
                return rs.getInt(1);
            }
        }
    }

    /** Lock this product's inventory balance until the transaction finishes. */
    public Inventory lockInventory(Connection con, int productId) throws SQLException {
        String sql = "SELECT product_id, quantity_on_hand, reorder_level FROM inventory "
                   + "WHERE product_id=? FOR UPDATE";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new SQLException("Product / inventory not found: #" + productId);
                return new Inventory(rs.getInt(1), rs.getInt(2), rs.getInt(3));
            }
        }
    }

    public String getProductName(Connection con, int productId) throws SQLException {
        String sql = "SELECT name FROM products WHERE product_id=?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new SQLException("Product not found: #" + productId);
                return rs.getString(1);
            }
        }
    }

    public void requireSupplier(Connection con, int supplierId) throws SQLException {
        try (PreparedStatement ps = con.prepareStatement("SELECT 1 FROM suppliers WHERE supplier_id=?")) {
            ps.setInt(1, supplierId);
            try (ResultSet rs = ps.executeQuery()) {
                if (!rs.next()) throw new SQLException("Supplier not found: #" + supplierId);
            }
        }
    }

    public void setQuantity(Connection con, int productId, int newQuantity) throws SQLException {
        if (newQuantity < 0) throw new SQLException("Negative inventory not allowed.");
        try (PreparedStatement ps = con.prepareStatement(
                "UPDATE inventory SET quantity_on_hand=? WHERE product_id=?")) {
            ps.setInt(1, newQuantity); ps.setInt(2, productId);
            if (ps.executeUpdate() != 1) throw new SQLException("Inventory update failed.");
        }
    }

    public void setReorderLevel(int productId, int level) throws SQLException {
        String sql = "UPDATE inventory SET reorder_level=? WHERE product_id=?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, level); ps.setInt(2, productId);
            if (ps.executeUpdate() != 1) throw new SQLException("Product inventory not found: #" + productId);
        }
    }

    public void insertMovement(Connection con, int productId, String name,
            Integer supplierId, Integer orderId, int quantity,
            StockMovementType type, String reason) throws SQLException {
        String sql = "INSERT INTO stock_movements "
          + "(product_id,product_id_at_movement,product_name_at_movement,supplier_id,order_id,"
          + "quantity,movement_type,reason) VALUES (?,?,?,?,?,?,?,?)";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, productId);
            ps.setInt(2, productId);
            ps.setString(3, name);
            if (supplierId == null) ps.setNull(4, Types.INTEGER); else ps.setInt(4, supplierId);
            if (orderId == null) ps.setNull(5, Types.INTEGER); else ps.setInt(5, orderId);
            ps.setInt(6, quantity);
            ps.setString(7, type.name());
            ps.setString(8, reason);
            if (ps.executeUpdate() != 1) throw new SQLException("Stock journal insert failed.");
        }
    }

    public List<StockMovement> listMovements(int maxRows) throws SQLException {
        List<StockMovement> rows = new ArrayList<>();
        String sql = "SELECT movement_id,product_id,product_id_at_movement,product_name_at_movement,"
             + "supplier_id,order_id,quantity,movement_type,occurred_at,reason "
             + "FROM stock_movements ORDER BY occurred_at DESC,movement_id DESC LIMIT ?";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, maxRows);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object p=rs.getObject("product_id"), s=rs.getObject("supplier_id"), o=rs.getObject("order_id");
                    Timestamp at = rs.getTimestamp("occurred_at");
                    rows.add(new StockMovement(rs.getInt("movement_id"), p==null?null:((Number)p).intValue(),
                         rs.getInt("product_id_at_movement"),rs.getString("product_name_at_movement"),
                         s==null?null:((Number)s).intValue(),o==null?null:((Number)o).intValue(),
                         rs.getInt("quantity"), StockMovementType.valueOf(rs.getString("movement_type")),
                         at.toLocalDateTime(),rs.getString("reason")));
                }
            }
        }
        return rows;
    }

    public boolean existsOrderMovement(Connection con, int orderId, int productId,
                                       StockMovementType type) throws SQLException {
        String sql = "SELECT 1 FROM stock_movements WHERE order_id=? "
                   + "AND product_id_at_movement=? AND movement_type=? LIMIT 1";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId); ps.setInt(2, productId); ps.setString(3, type.name());
            try (ResultSet rs = ps.executeQuery()) { return rs.next(); }
        }
    }
}
