package com.econest.config;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

/**
 * Read-only preflight check for installing EcoNest on another computer.
 * Right-click this file in NetBeans -> Run File, AFTER importing econest.sql.
 * No inserts, updates, DDL, or data deletion are performed.
 */
public final class DatabaseHealthCheck {
    private static final Set<String> TABLES = Set.of(
        "products", "inventory", "suppliers", "clients", "delivery_agents",
        "orders", "order_items", "deliveries", "stock_movements", "email_notifications");
    private static final Set<String> TRIGGERS = Set.of(
        "trg_product_create_inventory", "trg_product_guard_delete",
        "trg_inventory_guard_delete", "trg_agent_guard_delete",
        "trg_stock_movement_no_update", "trg_stock_movement_no_delete");

    private DatabaseHealthCheck() { }

    public static void main(String[] args) {
        try (Connection connection = DatabaseConnection.getConnection()) {
            String schema = connection.getCatalog();
            if (!"econest".equalsIgnoreCase(schema))
                throw new SQLException("Wrong database selected: " + schema + ". Expected econest.");
            System.out.println("Connected: " + connection.getMetaData().getDatabaseProductName()
                    + " " + connection.getMetaData().getDatabaseProductVersion());
            Set<String> tableNames = readNames(connection,
                    "SELECT TABLE_NAME FROM information_schema.TABLES "
                    + "WHERE TABLE_SCHEMA=? AND TABLE_TYPE='BASE TABLE'", schema);
            Set<String> triggerNames = readNames(connection,
                    "SELECT TRIGGER_NAME FROM information_schema.TRIGGERS WHERE TRIGGER_SCHEMA=?", schema);
            int foreignKeys = count(connection,
                    "SELECT COUNT(*) FROM information_schema.TABLE_CONSTRAINTS "
                    + "WHERE CONSTRAINT_SCHEMA=? AND CONSTRAINT_TYPE='FOREIGN KEY'", schema);
            System.out.println("Tables: " + tableNames.size() + " (expected 10)");
            System.out.println("Foreign keys: " + foreignKeys + " (expected 10)");
            System.out.println("Triggers: " + triggerNames.size() + " (expected 6)");
            if (!tableNames.containsAll(TABLES))
                throw new SQLException("Missing tables: " + difference(TABLES, tableNames));
            if (!triggerNames.containsAll(TRIGGERS))
                throw new SQLException("Missing triggers: " + difference(TRIGGERS, triggerNames));
            if (foreignKeys != 10)
                throw new SQLException("Expected 10 foreign keys, found " + foreignKeys);
            System.out.println("DATABASE PREFLIGHT PASSED (read-only).");
            System.out.println("Note: this does not test SMTP, business transactions, or journal balances.");
        } catch (SQLException ex) {
            System.err.println("DATABASE PREFLIGHT FAILED: " + ex.getMessage());
            System.err.println("Check database import, port, and ECONEST_DB_URL/USER/PASSWORD.");
            System.exit(1);
        }
    }

    private static Set<String> readNames(Connection c, String sql, String schema) throws SQLException {
        Set<String> names = new HashSet<>();
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, schema);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) names.add(rs.getString(1));
            }
        }
        return names;
    }
    private static int count(Connection c, String sql, String schema) throws SQLException {
        try (PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, schema);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next(); return rs.getInt(1);
            }
        }
    }
    private static Set<String> difference(Set<String> required, Set<String> actual) {
        Set<String> missing = new HashSet<>(required);
        missing.removeAll(actual);
        return missing;
    }
}
