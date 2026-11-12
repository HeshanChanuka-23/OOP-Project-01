
package com.econest.catalog.service;

import com.econest.catalog.model.Product;
import com.econest.catalog.model.ProductCategory;

import java.math.BigDecimal;
import java.sql.SQLException;

public class TestProductService {

    public static void main(String[] args) {

        ProductService service = new ProductService();
        int testProductId = 0;

        try {
            // 1. ADD PRODUCT
            Product product = new Product(
                    "EcoNest TEST Plant",
                    ProductCategory.PLANT,
                    "Temporary product for testing",
                    new BigDecimal("1250.00"),
                    5
            );

            testProductId = service.addProduct(product);

            System.out.println("Product added successfully!");
            System.out.println("Product ID: " + testProductId);

            // 2. RETRIEVE PRODUCT
            Product savedProduct =
                    service.getProduct(testProductId);

            if (savedProduct == null) {
                throw new IllegalStateException(
                        "Inserted product could not be found.");
            }

            System.out.println("Retrieved: "
                    + savedProduct.getName());

            // 3. UPDATE PRODUCT
            savedProduct.updateDetails(
                    "EcoNest TEST Plant Updated",
                    ProductCategory.PLANT,
                    "Updated test description",
                    5
            );

            savedProduct.changePrice(
                    new BigDecimal("1500.00")
            );

            service.updateProduct(savedProduct);

            Product updatedProduct =
                    service.getProduct(testProductId);

            if (updatedProduct == null
                    || updatedProduct.getUnitPrice()
                        .compareTo(new BigDecimal("1500.00")) != 0) {
                throw new IllegalStateException(
                        "Product update verification failed.");
            }

            System.out.println("Updated: "
                    + updatedProduct.getName());

            System.out.println("New price: "
                    + updatedProduct.getUnitPrice());

            // 4. DELETE PRODUCT
            service.deleteProduct(testProductId);

            if (service.getProduct(testProductId) != null) {
                throw new IllegalStateException(
                        "Product was not deleted.");
            }

            System.out.println("Product deleted successfully!");
            testProductId = 0;

            System.out.println("ALL TESTS PASSED!");

        } catch (SQLException | RuntimeException e) {

            System.out.println("TEST FAILED!");
            e.printStackTrace();

        } finally {

            // Clean up the temporary product if a test failed.
            if (testProductId > 0) {
                try {
                    service.deleteProduct(testProductId);
                } catch (SQLException | RuntimeException e) {
                    System.out.println(
                            "Could not remove the test product: "
                            + e.getMessage());
                }
            }
        }
    }
}
