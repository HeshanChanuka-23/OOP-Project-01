package com.econest.catalog.model;

import java.time.LocalDateTime;

/** Append-only stock journal with historical product snapshots. */
public class StockMovement {
    private final int movementId;
    private final Integer productId; // Nullable after a permanent product removal.
    private final int productIdAtMovement;
    private final String productNameAtMovement;
    private final Integer supplierId;
    private final Integer orderId;
    private final int quantity; // Always positive, type determines direction.
    private final StockMovementType type;
    private final LocalDateTime occurredAt;
    private final String reason; // In SQL schema (not originally drawn in UML).

    public StockMovement(int movementId, Integer productId, int productIdAtMovement,
            String productNameAtMovement, Integer supplierId, Integer orderId,
            int quantity, StockMovementType type, LocalDateTime occurredAt, String reason) {
        this.movementId = movementId;
        this.productId = productId;
        this.productIdAtMovement = productIdAtMovement;
        this.productNameAtMovement = productNameAtMovement;
        this.supplierId = supplierId;
        this.orderId = orderId;
        this.quantity = quantity;
        this.type = type;
        this.occurredAt = occurredAt;
        this.reason = reason;
    }
    public int getMovementId() { return movementId; }
    public Integer getProductId() { return productId; }
    public int getProductIdAtMovement() { return productIdAtMovement; }
    public String getProductNameAtMovement() { return productNameAtMovement; }
    public Integer getSupplierId() { return supplierId; }
    public Integer getOrderId() { return orderId; }
    public int getQuantity() { return quantity; }
    public StockMovementType getType() { return type; }
    public LocalDateTime getOccurredAt() { return occurredAt; }
    public String getReason() { return reason; }
}
