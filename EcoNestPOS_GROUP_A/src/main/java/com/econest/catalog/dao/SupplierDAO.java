package com.econest.catalog.dao;

import com.econest.catalog.model.Supplier;
import com.econest.config.DatabaseConnection;
import java.sql.*;
import java.util.*;

/** Basic supplier persistence. No deletion: historical STOCK_IN rows require it. */
public class SupplierDAO {
    public int addSupplier(Supplier supplier) throws SQLException {
        String sql = "INSERT INTO suppliers (name, phone, email) VALUES (?, ?, ?)";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, supplier.getName());
            ps.setString(2, supplier.getPhone());
            ps.setString(3, supplier.getEmail());
            if (ps.executeUpdate() != 1) throw new SQLException("Supplier insert failed.");
            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (!keys.next()) throw new SQLException("Supplier ID was not returned.");
                int id = keys.getInt(1);
                supplier.setSupplierId(id);
                return id;
            }
        }
    }

    public List<Supplier> listSuppliers() throws SQLException {
        List<Supplier> suppliers = new ArrayList<>();
        String sql = "SELECT supplier_id, name, phone, email FROM suppliers ORDER BY name, supplier_id";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Supplier s = new Supplier(rs.getString("name"), rs.getString("phone"), rs.getString("email"));
                s.setSupplierId(rs.getInt("supplier_id"));
                suppliers.add(s);
            }
        }
        return suppliers;
    }
}
