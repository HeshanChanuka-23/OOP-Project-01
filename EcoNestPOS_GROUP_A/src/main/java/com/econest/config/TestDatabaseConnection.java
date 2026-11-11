
package com.econest.config;

import java.sql.Connection;
import java.sql.SQLException;

public class TestDatabaseConnection {

    public static void main(String[] args) {

        try (Connection con = DatabaseConnection.getConnection()) {

            System.out.println("Database connected successfully!");
            System.out.println("Connected to EcoNest MariaDB.");

        } catch (SQLException e) {

            System.out.println("Database connection failed!");
            System.out.println(e.getMessage());

        }
    }
}
