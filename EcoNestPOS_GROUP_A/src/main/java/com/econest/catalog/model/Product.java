
package com.econest.catalog.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Product {

    // Attributes
    private int productId;
    private String name;
    private ProductCategory category;
    private String description;
    private BigDecimal unitPrice;
    private int ecoRating;

    // Default constructor
    public Product() {
    }

    // Constructor for creating a new product
    public Product(String name, ProductCategory category,
                   String description, BigDecimal unitPrice,
                   int ecoRating) {

        updateDetails(name, category, description, ecoRating);
        changePrice(unitPrice);
    }

    // Getters and Setters

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        if (productId < 0) {
            throw new IllegalArgumentException(
                "Product ID cannot be negative.");
        }

        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()
                || name.length() > 150) {

            throw new IllegalArgumentException(
                "Product name must be between 1 and 150 characters.");
        }

        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = Objects.requireNonNull(
            category, "Product category is required.");
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(BigDecimal unitPrice) {
        if (unitPrice == null || unitPrice.signum() < 0) {
            throw new IllegalArgumentException(
                "Product price must be zero or greater.");
        }

        this.unitPrice = unitPrice;
    }

    public int getEcoRating() {
        return ecoRating;
    }

    public void setEcoRating(int ecoRating) {
        if (ecoRating < 0 || ecoRating > 255) {
            throw new IllegalArgumentException(
                "Eco rating must be between 0 and 255.");
        }

        this.ecoRating = ecoRating;
    }

    // Business Methods from the Class Diagram

    public void updateDetails(String name,
                              ProductCategory category,
                              String description,
                              int ecoRating) {

        setName(name);
        setCategory(category);
        setDescription(description);
        setEcoRating(ecoRating);
    }

    public void changePrice(BigDecimal price) {
        setUnitPrice(price);
    }
}
