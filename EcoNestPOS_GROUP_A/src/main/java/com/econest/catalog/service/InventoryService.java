package com.econest.catalog.service;

import com.econest.catalog.dao.InventoryDAO;
import com.econest.catalog.dao.SupplierDAO;
import com.econest.catalog.model.*;
import com.econest.config.DatabaseConnection;
import com.econest.orders.model.Order;
import com.econest.orders.model.OrderStatus;
import com.econest.orders.service.OrderService;
import java.sql.*;
import java.util.*;

/**
 * Business operations for Requirement 3. All stock quantity changes are paired
 * with an append-only journal event in the SAME database transaction.
 */
public class InventoryService {
    private final InventoryDAO inventoryDAO = new InventoryDAO();
    private final SupplierDAO supplierDAO = new SupplierDAO();

    // ----- Exact business operations from the FINAL Master Class Diagram -----
    public int addSupplier(Supplier supplier) throws SQLException {
        if (supplier == null) throw new IllegalArgumentException("Supplier is required.");
        if (supplier.getName() == null || supplier.getName().isBlank())
            throw new IllegalArgumentException("Supplier name is required.");
        return supplierDAO.addSupplier(supplier);
    }
    public List<Supplier> listSuppliers() throws SQLException { return supplierDAO.listSuppliers(); }

    public void receiveStock(int productId, int supplierId, int qty) throws SQLException {
        requireId(productId, "Product"); requireId(supplierId, "Supplier"); requirePositive(qty);
        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false);
            try {
                Inventory stock = inventoryDAO.lockInventory(con, productId);
                inventoryDAO.requireSupplier(con, supplierId);
                String name = inventoryDAO.getProductName(con, productId);
                int newQty = Math.addExact(stock.getQuantityOnHand(), qty);
                inventoryDAO.setQuantity(con, productId, newQty);
                inventoryDAO.insertMovement(con, productId, name, supplierId, null,
                        qty, StockMovementType.STOCK_IN, null);
                con.commit();
            } catch (SQLException | RuntimeException ex) {
                con.rollback(); throw ex;
            }
        }
    }

    public void setReorderLevel(int productId, int level) throws SQLException {
        requireId(productId, "Product");
        if (level < 0) throw new IllegalArgumentException("Reorder level cannot be negative.");
        inventoryDAO.setReorderLevel(productId, level);
    }

    public int getAvailableStock(int productId) throws SQLException {
        requireId(productId, "Product");
        return inventoryDAO.getAvailableStock(productId);
    }
    public List<Inventory> listInventory() throws SQLException { return inventoryDAO.listInventory(); }
    public List<Inventory> getLowStockItems() throws SQLException {
        List<Inventory> result = new ArrayList<>();
        for (Inventory item : listInventory()) if (item.isLowStock()) result.add(item);
        return result;
    }

    /** Writes off ALL units; matches the two-parameter method in the UML. */
    public void writeOffStock(int productId, String reason) throws SQLException {
        requireReason(reason);
        requireId(productId, "Product");
        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false);
            try {
                Inventory stock = inventoryDAO.lockInventory(con, productId);
                int quantity = stock.getQuantityOnHand();
                if (quantity <= 0) throw new IllegalStateException("No stock to write off.");
                writeOffLocked(con, productId, quantity, reason);
                con.commit();
            } catch (SQLException | RuntimeException ex) {
                con.rollback(); throw ex;
            }
        }
    }

    // ----- Supporting operations for the GUI (no additional tables) -----
    /** Partial write-off; a useful overload of the UML method. */
    public void writeOffStock(int productId, int qty, String reason) throws SQLException {
        requireId(productId, "Product"); requirePositive(qty); requireReason(reason);
        try (Connection con = DatabaseConnection.getConnection()) {
            con.setAutoCommit(false);
            try {
                writeOffLocked(con, productId, qty, reason);
                con.commit();
            } catch (SQLException | RuntimeException ex) {
                con.rollback(); throw ex;
            }
        }
    }

    private void writeOffLocked(Connection con, int productId, int qty, String reason)
            throws SQLException {
        Inventory stock = inventoryDAO.lockInventory(con, productId);
        if (stock.getQuantityOnHand() < qty)
            throw new IllegalStateException("Cannot write off more than available stock.");
        String name = inventoryDAO.getProductName(con, productId);
        inventoryDAO.setQuantity(con, productId, stock.getQuantityOnHand() - qty);
        inventoryDAO.insertMovement(con, productId, name, null, null, qty,
                StockMovementType.WRITE_OFF, reason.trim());
    }

    public List<InventoryRow> listInventoryRows(boolean lowOnly) throws SQLException {
        return inventoryDAO.listInventoryRows(lowOnly);
    }
    public List<StockMovement> listStockMovements() throws SQLException {
        return inventoryDAO.listMovements(500);
    }

    // ----- UML-compliant Order overloads -----
    // These methods deliberately delegate to OrderService, which owns the entire
    // order + inventory transaction. A separate JDBC transaction here would make
    // stock and order statuses inconsistent if one half failed.

    /**
     * UML method. Confirming a persisted DRAFT order performs the stock deduction,
     * SALE_OUT journal inserts and order status change in ONE transaction.
     * For normal GUI use prefer OrderService.confirmOrder(orderId) directly.
     */
    public void deductStockForOrder(Order order) throws SQLException {
        int id = requirePersistedOrder(order);
        new OrderService().confirmOrder(id);
    }

    /**
     * UML method. Cancelling a CONFIRMED order restores stock exactly once and
     * journals CANCEL_RESTOCK in the SAME transaction as order cancellation.
     * It also cancels any associated undispatched delivery when applicable.
     * For normal GUI use prefer OrderService.cancelOrder(orderId) directly.
     */
    public void restoreStock(Order order) throws SQLException {
        int id = requirePersistedOrder(order);
        OrderService orders = new OrderService();
        Order persisted = orders.getOrder(id);
        if (persisted == null || persisted.getStatus() != OrderStatus.CONFIRMED)
            throw new IllegalStateException("Only a confirmed order can have stock restored.");
        // cancelOrder locks and re-checks the actual persisted status atomically;
        // a stale Order object cannot bypass duplicate-restock protection.
        orders.cancelOrder(id);
    }

    private static int requirePersistedOrder(Order order) {
        if (order == null || order.getOrderId() <= 0)
            throw new IllegalArgumentException("A saved order with a valid ID is required.");
        return order.getOrderId();
    }

    // ----- Transaction-aware integration hooks -----
    // OrderService calls these overloads with its ACTIVE JDBC Connection.
    // Never commit/rollback here: only OrderService owns the transaction.
    // These are implementation helpers in addition to the public UML methods.

    public void deductStockForOrder(Connection con, int orderId) throws SQLException {
        requireOrderTransaction(con, orderId);
        List<OrderLine> lines = loadOrderLines(con, orderId);
        if (lines.isEmpty()) throw new IllegalStateException("Order has no items.");
        for (OrderLine line : lines) {
            if (line.productId == null)
                throw new IllegalStateException("Product no longer exists for this order item.");
            Inventory stock = inventoryDAO.lockInventory(con, line.productId);
            if (inventoryDAO.existsOrderMovement(con, orderId, line.snapshotId, StockMovementType.SALE_OUT))
                throw new IllegalStateException("Stock already deducted for product #" + line.snapshotId);
            if (stock.getQuantityOnHand() < line.qty)
                throw new IllegalStateException("Insufficient stock for product #" + line.productId);
            inventoryDAO.setQuantity(con, line.productId, stock.getQuantityOnHand() - line.qty);
            inventoryDAO.insertMovement(con, line.productId, line.snapshotName, null, orderId,
                    line.qty, StockMovementType.SALE_OUT, null);
        }
    }

    public void restoreStock(Connection con, int orderId) throws SQLException {
        requireOrderTransaction(con, orderId);
        String sql = "SELECT product_id,product_id_at_movement,product_name_at_movement,quantity "
                   + "FROM stock_movements WHERE order_id=? AND movement_type='SALE_OUT' "
                   + "ORDER BY product_id_at_movement";
        List<OrderLine> sales = new ArrayList<>();
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object id = rs.getObject(1);
                    sales.add(new OrderLine(id == null ? null : ((Number) id).intValue(),
                            rs.getInt(2), rs.getString(3), rs.getInt(4)));
                }
            }
        }
        if (sales.isEmpty()) throw new IllegalStateException("No sale movements to reverse.");
        for (OrderLine line : sales) {
            if (line.productId == null)
                throw new IllegalStateException("Cannot restore a deleted product.");
            Inventory stock = inventoryDAO.lockInventory(con, line.productId);
            if (inventoryDAO.existsOrderMovement(con, orderId, line.snapshotId, StockMovementType.CANCEL_RESTOCK))
                throw new IllegalStateException("Stock already restored for product #" + line.snapshotId);
            int updated = Math.addExact(stock.getQuantityOnHand(), line.qty);
            inventoryDAO.setQuantity(con, line.productId, updated);
            inventoryDAO.insertMovement(con, line.productId, line.snapshotName, null, orderId,
                    line.qty, StockMovementType.CANCEL_RESTOCK, null);
        }
    }

    private List<OrderLine> loadOrderLines(Connection con, int orderId) throws SQLException {
        List<OrderLine> lines = new ArrayList<>();
        String sql = "SELECT product_id,product_id_at_order,product_name_at_order,quantity "
                   + "FROM order_items WHERE order_id=? ORDER BY product_id_at_order";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, orderId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    Object id = rs.getObject(1);
                    lines.add(new OrderLine(id == null ? null : ((Number) id).intValue(),
                            rs.getInt(2), rs.getString(3), rs.getInt(4)));
                }
            }
        }
        return lines;
    }
    private static final class OrderLine {
        final Integer productId; final int snapshotId; final String snapshotName; final int qty;
        OrderLine(Integer productId, int snapshotId, String snapshotName, int qty) {
            this.productId = productId; this.snapshotId = snapshotId;
            this.snapshotName = snapshotName; this.qty = qty;
        }
    }
    private void requireOrderTransaction(Connection con, int orderId) throws SQLException {
        requireId(orderId, "Order");
        if (con == null || con.isClosed() || con.getAutoCommit())
            throw new IllegalArgumentException("An active order transaction is required.");
    }
    private void requireId(int id, String label) {
        if (id <= 0) throw new IllegalArgumentException(label + " ID must be positive.");
    }
    private void requirePositive(int qty) {
        if (qty <= 0) throw new IllegalArgumentException("Quantity must be greater than zero.");
    }
    private void requireReason(String reason) {
        if (reason == null || reason.isBlank())
            throw new IllegalArgumentException("Write-off reason is required.");
    }
}
