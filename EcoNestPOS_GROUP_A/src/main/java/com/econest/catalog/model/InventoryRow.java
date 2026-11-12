package com.econest.catalog.model;

/** Read-only DTO for the inventory GUI; not an extra database entity/table. */
public class InventoryRow {
    private final int productId;
    private final String productName;
    private final String category;
    private final int quantityOnHand;
    private final int reorderLevel;

    public InventoryRow(int productId, String productName, String category,
                        int quantityOnHand, int reorderLevel) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
        this.quantityOnHand = quantityOnHand;
        this.reorderLevel = reorderLevel;
    }
    public int getProductId() { return productId; }
    public String getProductName() { return productName; }
    public String getCategory() { return category; }
    public int getQuantityOnHand() { return quantityOnHand; }
    public int getReorderLevel() { return reorderLevel; }
    public boolean isLowStock() { return quantityOnHand <= reorderLevel; }
    @Override public String toString() {
        return productName + " (#" + productId + ")";
    }
}
