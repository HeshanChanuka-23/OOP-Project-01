
package com.econest.catalog.service;

import com.econest.catalog.dao.ProductDAO;
import com.econest.catalog.model.Product;
import com.econest.config.DatabaseConnection;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductService {

    private static final BigDecimal MAX_PRICE =
            new BigDecimal("9999999999.99");

    private final ProductDAO productDAO = new ProductDAO();

    // 1. Add a product
    public int addProduct(Product product) throws SQLException {
        validateProduct(product);

        if (product.getProductId() != 0) {
            throw new IllegalArgumentException(
                    "A new product must not already have an ID.");
        }

        return productDAO.addProduct(product);
    }

    // 2. Update a product
    public void updateProduct(Product product) throws SQLException {
        validateProduct(product);
        validateId(product.getProductId());

        if (!productDAO.updateProduct(product)
                && productDAO.getProduct(product.getProductId()) == null) {
            throw new NoSuchElementException("Product not found.");
        }
    }

    // 3. Delete a product
    public void deleteProduct(int productId) throws SQLException {
        validateId(productId);

        try (Connection con = DatabaseConnection.getConnection()) {

            String stockSql =
                    "SELECT quantity_on_hand FROM inventory "
                    + "WHERE product_id = ?";

            try (PreparedStatement ps = con.prepareStatement(stockSql)) {
                ps.setInt(1, productId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next() && rs.getInt("quantity_on_hand") > 0) {
                        throw new IllegalStateException(
                                "Write off remaining stock before deleting "
                                + "this product.");
                    }
                }
            }

            String draftSql =
                    "SELECT 1 FROM order_items oi "
                    + "JOIN orders o ON o.order_id = oi.order_id "
                    + "WHERE oi.product_id = ? AND o.status = 'DRAFT' "
                    + "LIMIT 1";

            try (PreparedStatement ps = con.prepareStatement(draftSql)) {
                ps.setInt(1, productId);

                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        throw new IllegalStateException(
                                "This product is still used in a draft order.");
                    }
                }
            }
        }

        if (!productDAO.deleteProduct(productId)) {
            throw new NoSuchElementException("Product not found.");
        }
    }

    // 4. Get one product
    public Product getProduct(int productId) throws SQLException {
        validateId(productId);
        return productDAO.getProduct(productId);
    }

    // 5. Get all products
    public List<Product> listProducts() throws SQLException {
        return productDAO.listProducts();
    }

    // Supporting validation method
    private void validateId(int productId) {
        if (productId <= 0) {
            throw new IllegalArgumentException(
                    "Product ID must be greater than zero.");
        }
    }

    // Supporting validation method
    private void validateProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product is required.");
        }

        if (product.getName() == null
                || product.getName().isBlank()
                || product.getName().length() > 150) {
            throw new IllegalArgumentException(
                    "Product name must be 1 to 150 characters.");
        }

        if (product.getCategory() == null) {
            throw new IllegalArgumentException(
                    "Product category is required.");
        }

        BigDecimal price = product.getUnitPrice();

        if (price == null
                || price.signum() < 0
                || price.compareTo(MAX_PRICE) > 0
                || price.stripTrailingZeros().scale() > 2) {
            throw new IllegalArgumentException(
                    "Price must be between 0 and 9999999999.99 "
                    + "with at most two decimal places.");
        }

        if (product.getEcoRating() < 0
                || product.getEcoRating() > 255) {
            throw new IllegalArgumentException(
                    "Eco rating must be between 0 and 255.");
        }
    }
}
