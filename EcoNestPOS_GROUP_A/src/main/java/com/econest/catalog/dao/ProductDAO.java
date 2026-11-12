
package com.econest.catalog.dao;

import com.econest.catalog.model.Product;
import com.econest.catalog.model.ProductCategory;
import com.econest.config.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    // Add a new product
    public int addProduct(Product product) throws SQLException {

        String sql = "INSERT INTO products "
                + "(name, category, description, unit_price, eco_rating) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(
                     sql, Statement.RETURN_GENERATED_KEYS)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory().name());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getUnitPrice());
            ps.setInt(5, product.getEcoRating());

            if (ps.executeUpdate() != 1) {
                throw new SQLException("Product insertion failed.");
            }

            try (ResultSet keys = ps.getGeneratedKeys()) {
                if (keys.next()) {
                    int id = keys.getInt(1);
                    product.setProductId(id);
                    return id;
                }
            }

            throw new SQLException(
                    "Product inserted but ID not returned.");
        }
    }

    // Update an existing product
    public boolean updateProduct(Product product)
            throws SQLException {

        String sql = "UPDATE products SET name = ?, "
                + "category = ?, description = ?, "
                + "unit_price = ?, eco_rating = ? "
                + "WHERE product_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, product.getName());
            ps.setString(2, product.getCategory().name());
            ps.setString(3, product.getDescription());
            ps.setBigDecimal(4, product.getUnitPrice());
            ps.setInt(5, product.getEcoRating());
            ps.setInt(6, product.getProductId());

            return ps.executeUpdate() > 0;
        }
    }

    // Delete a product (ProductService must check business rules)
    public boolean deleteProduct(int productId)
            throws SQLException {

        String sql = "DELETE FROM products WHERE product_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);

            return ps.executeUpdate() > 0;
        }
    }

    // Find a product by ID
    public Product getProduct(int productId)
            throws SQLException {

        String sql = "SELECT product_id, name, category, "
                + "description, unit_price, eco_rating "
                + "FROM products WHERE product_id = ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, productId);

            try (ResultSet rs = ps.executeQuery()) {
                return rs.next() ? mapProduct(rs) : null;
            }
        }
    }

    // Retrieve all products
    public List<Product> listProducts()
            throws SQLException {

        String sql = "SELECT product_id, name, category, "
                + "description, unit_price, eco_rating "
                + "FROM products ORDER BY product_id";

        List<Product> products = new ArrayList<>();

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                products.add(mapProduct(rs));
            }
        }

        return products;
    }

    // Convert database row into a Product object
    private Product mapProduct(ResultSet rs)
            throws SQLException {

        Product product = new Product(
                rs.getString("name"),
                ProductCategory.valueOf(rs.getString("category")),
                rs.getString("description"),
                rs.getBigDecimal("unit_price"),
                rs.getInt("eco_rating")
        );

        product.setProductId(rs.getInt("product_id"));

        return product;
    }
}
