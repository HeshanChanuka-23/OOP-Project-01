package com.econest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * One JDBC factory for all modules. The lecturer can use a local MariaDB or
 * MySQL database without changing source files: set ECONEST_DB_URL / USER /
 * PASSWORD for that machine. XAMPP defaults remain supported for development.
 */
public final class DatabaseConnection {
    private DatabaseConnection() { }

    public static Connection getConnection() throws SQLException {
        String url = setting("ECONEST_DB_URL", "jdbc:mariadb://localhost:3306/econest");
        String user = setting("ECONEST_DB_USER", "root");
        String password = System.getenv().getOrDefault("ECONEST_DB_PASSWORD", "");
        if (!url.startsWith("jdbc:mariadb://"))
            throw new SQLException("ECONEST_DB_URL must start with jdbc:mariadb://");
        return DriverManager.getConnection(url, user, password);
    }

    private static String setting(String key, String fallback) {
        String value = System.getenv(key);
        return value == null || value.isBlank() ? fallback : value.trim();
    }
}
