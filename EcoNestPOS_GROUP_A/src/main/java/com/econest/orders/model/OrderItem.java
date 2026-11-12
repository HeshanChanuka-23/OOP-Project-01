package com.econest.orders.model;

import java.math.BigDecimal;
import java.util.Objects;

/** The historical product/price snapshot stored in order_items. */
public class OrderItem {
    private int orderItemId;
    private Integer productId; // nullable after product hard deletion
    private int productIdAtOrder;
    private String productNameAtOrder;
    private int quantity;
    private BigDecimal unitPriceAtOrder;

    public OrderItem() { }
    public OrderItem(int orderItemId, Integer productId, int productIdAtOrder,
                     String productNameAtOrder, int quantity, BigDecimal unitPriceAtOrder) {
        setOrderItemId(orderItemId); setProductId(productId);
        setProductIdAtOrder(productIdAtOrder); setProductNameAtOrder(productNameAtOrder);
        setQuantity(quantity); setUnitPriceAtOrder(unitPriceAtOrder);
    }
    public int getOrderItemId() { return orderItemId; }
    public void setOrderItemId(int id) { if (id < 0) throw new IllegalArgumentException("Invalid item ID"); orderItemId=id; }
    public Integer getProductId() { return productId; }
    public void setProductId(Integer id) { if(id!=null && id<=0) throw new IllegalArgumentException("Invalid product ID"); productId=id; }
    public int getProductIdAtOrder() { return productIdAtOrder; }
    public void setProductIdAtOrder(int id) { if(id<=0) throw new IllegalArgumentException("Invalid snapshot product ID"); productIdAtOrder=id; }
    public String getProductNameAtOrder() { return productNameAtOrder; }
    public void setProductNameAtOrder(String name) { if(name==null||name.isBlank()||name.length()>150) throw new IllegalArgumentException("Invalid product name"); productNameAtOrder=name; }
    public int getQuantity() { return quantity; }
    public void setQuantity(int qty) { if(qty<=0) throw new IllegalArgumentException("Quantity must be positive"); quantity=qty; }
    public BigDecimal getUnitPriceAtOrder() { return unitPriceAtOrder; }
    public void setUnitPriceAtOrder(BigDecimal price) { Objects.requireNonNull(price); if(price.signum()<0||price.scale()>2||price.precision()>12) throw new IllegalArgumentException("Invalid price"); unitPriceAtOrder=price; }
    /** UML business method: price at order time never depends on current product price. */
    public BigDecimal calculateSubtotal() { return unitPriceAtOrder.multiply(BigDecimal.valueOf(quantity)); }
}
