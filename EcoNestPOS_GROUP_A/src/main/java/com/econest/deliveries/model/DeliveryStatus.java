package com.econest.deliveries.model;

/** Values match the database's deliveries.status ENUM. */
public enum DeliveryStatus {
    ASSIGNED, SCHEDULED, DISPATCHED, DELIVERED, FAILED, CANCELLED
}
