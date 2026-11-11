
package com.econest.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String URL =
            "jdbc:mariadb://localhost:3306/econest";

    private static final String USER =
            System.getenv().getOrDefault("ECONEST_DB_USER", "root");

    private static final String PASSWORD =
            System.getenv().getOrDefault("ECONEST_DB_PASSWORD", "");

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
