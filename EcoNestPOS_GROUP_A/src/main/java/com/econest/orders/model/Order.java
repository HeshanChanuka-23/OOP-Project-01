package com.econest.orders.model;

import com.econest.catalog.model.Product;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/** The Task 5 domain entity specified in the FINAL class diagram. */
public class Order {
    private int orderId;
    private Integer clientId;
    private String clientNameAtOrder;
    private String clientEmailAtOrder;
    private String deliveryAddressAtOrder;
    private LocalDateTime createdAt;
    private LocalDateTime confirmedAt;
    private LocalDateTime cancelledAt;
    private OrderStatus status=OrderStatus.DRAFT;
    private BigDecimal totalAmount=BigDecimal.ZERO;
    private final List<OrderItem> items=new ArrayList<>();

    public Order() { }
    public int getOrderId(){return orderId;}
    public void setOrderId(int v){if(v<0)throw new IllegalArgumentException("Invalid order ID");orderId=v;}
    public Integer getClientId(){return clientId;}
    public void setClientId(Integer v){if(v!=null&&v<=0)throw new IllegalArgumentException("Invalid client ID");clientId=v;}
    public String getClientNameAtOrder(){return clientNameAtOrder;}
    public void setClientNameAtOrder(String v){clientNameAtOrder=v;}
    public String getClientEmailAtOrder(){return clientEmailAtOrder;}
    public void setClientEmailAtOrder(String v){clientEmailAtOrder=v;}
    public String getDeliveryAddressAtOrder(){return deliveryAddressAtOrder;}
    public void setDeliveryAddressAtOrder(String v){deliveryAddressAtOrder=v;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime v){createdAt=v;}
    public LocalDateTime getConfirmedAt(){return confirmedAt;}
    public void setConfirmedAt(LocalDateTime v){confirmedAt=v;}
    public LocalDateTime getCancelledAt(){return cancelledAt;}
    public void setCancelledAt(LocalDateTime v){cancelledAt=v;}
    public OrderStatus getStatus(){return status;}
    public void setStatus(OrderStatus v){if(v==null)throw new IllegalArgumentException("Status is required");status=v;}
    public BigDecimal getTotalAmount(){return totalAmount;}
    public void setTotalAmount(BigDecimal v){if(v==null||v.signum()<0)throw new IllegalArgumentException("Invalid total");totalAmount=v;}
    public List<OrderItem> getItems(){return Collections.unmodifiableList(items);}
    public void setItems(List<OrderItem> rows){items.clear();if(rows!=null)items.addAll(rows);}
    /** UML business method; persisted changes go through OrderService. */
    public void addItem(Product product,int qty){
        requireDraft();if(product==null||product.getProductId()<=0)throw new IllegalArgumentException("Product is required");
        if(qty<=0)throw new IllegalArgumentException("Quantity must be positive");
        for(OrderItem item:items)if(item.getProductIdAtOrder()==product.getProductId()){
            item.setQuantity(Math.addExact(item.getQuantity(),qty));totalAmount=calculateTotal();return;
        }
        items.add(new OrderItem(0,product.getProductId(),product.getProductId(),product.getName(),qty,product.getUnitPrice()));
        totalAmount=calculateTotal();
    }
    /** UML business method. */
    public void removeItem(int productId){requireDraft();items.removeIf(it->it.getProductIdAtOrder()==productId);totalAmount=calculateTotal();}
    /** UML business method. */
    public BigDecimal calculateTotal(){BigDecimal n=BigDecimal.ZERO;for(OrderItem i:items)n=n.add(i.calculateSubtotal());return n;}
    /** In-memory state transition; OrderService performs the real database transaction. */
    public void confirm(){requireDraft();if(items.isEmpty())throw new IllegalStateException("Order must contain items");status=OrderStatus.CONFIRMED;confirmedAt=LocalDateTime.now();totalAmount=calculateTotal();}
    /** In-memory state transition; database cancellation is transaction-based. */
    public void cancel(){if(status==OrderStatus.CANCELLED)throw new IllegalStateException("Already cancelled");status=OrderStatus.CANCELLED;cancelledAt=LocalDateTime.now();}
    private void requireDraft(){if(status!=OrderStatus.DRAFT)throw new IllegalStateException("Only a draft order may be edited");}
}
