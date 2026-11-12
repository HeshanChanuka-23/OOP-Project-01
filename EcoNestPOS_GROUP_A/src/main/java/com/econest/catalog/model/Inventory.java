package com.econest.catalog.model;

/** One current balance for each product (inventory.product_id is its PK/FK). */
public class Inventory {
    private int productId;
    private int quantityOnHand;
    private int reorderLevel;

    public Inventory() { }

    public Inventory(int productId, int quantityOnHand, int reorderLevel) {
        if (productId <= 0) throw new IllegalArgumentException("Product ID is required.");
        if (quantityOnHand < 0 || reorderLevel < 0)
            throw new IllegalArgumentException("Stock and reorder level cannot be negative.");
        this.productId = productId;
        this.quantityOnHand = quantityOnHand;
        this.reorderLevel = reorderLevel;
    }

    public int getProductId() { return productId; }
    public void setProductId(int productId) {
        if (productId <= 0) throw new IllegalArgumentException("Product ID is required.");
        this.productId = productId;
    }
    public int getQuantityOnHand() { return quantityOnHand; }
    public void setQuantityOnHand(int quantityOnHand) {
        if (quantityOnHand < 0) throw new IllegalArgumentException("Quantity cannot be negative.");
        this.quantityOnHand = quantityOnHand;
    }
    public int getReorderLevel() { return reorderLevel; }
    public void setReorderLevel(int reorderLevel) {
        if (reorderLevel < 0) throw new IllegalArgumentException("Reorder level cannot be negative.");
        this.reorderLevel = reorderLevel;
    }

    /** Method required by FINAL UML. Persist through InventoryService, not this method. */
    public void increase(int quantity) {
        if (quantity <= 0) throw new IllegalArgumentException("Increase must be positive.");
        quantityOnHand = Math.addExact(quantityOnHand, quantity);
    }
    /** Method required by FINAL UML. Persist through InventoryService, not this method. */
    public void decrease(int quantity) {
        if (quantity <= 0 || quantity > quantityOnHand)
            throw new IllegalArgumentException("Insufficient stock or invalid quantity.");
        quantityOnHand -= quantity;
    }
    /** Zero stock is low stock when the reorder level is also zero. */
    public boolean isLowStock() { return quantityOnHand <= reorderLevel; }
}
