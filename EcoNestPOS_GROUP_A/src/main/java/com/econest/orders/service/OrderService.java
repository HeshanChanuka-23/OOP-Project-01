package com.econest.orders.service;

import com.econest.catalog.service.InventoryService;
import com.econest.config.DatabaseConnection;
import com.econest.orders.dao.OrderDAO;
import com.econest.orders.model.*;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/** Task 5 service: one SQL transaction for an order AND its inventory movements. */
public class OrderService {
    private final OrderDAO dao;
    private final InventoryService inventory;
    public OrderService(){this(new OrderDAO(),new InventoryService());}
    public OrderService(OrderDAO dao,InventoryService inv){
        if(dao==null||inv==null)throw new IllegalArgumentException("Services are required");
        this.dao=dao;this.inventory=inv;
    }
    @FunctionalInterface private interface Work<T>{T run(Connection c)throws SQLException;}
    private <T> T transaction(Work<T> work)throws SQLException{
        try(Connection c=DatabaseConnection.getConnection()){
            c.setAutoCommit(false);
            try{T result=work.run(c);c.commit();return result;}
            catch(SQLException|RuntimeException ex){c.rollback();throw ex;}
        }
    }
    /** UML exact method: client selected from existing household/office clients. */
    public Order createOrder(int clientId)throws SQLException{
        if(clientId<=0)throw new IllegalArgumentException("Select a client");
        return transaction(c->{int id=dao.createOrder(c,clientId);return dao.getOrder(c,id);});
    }
    public void addOrderItem(int orderId,int productId,int qty)throws SQLException{
        requireId(orderId);requireId(productId);if(qty<=0)throw new IllegalArgumentException("Quantity must be positive");
        transaction(c->{dao.addOrderItem(c,orderId,productId,qty);return null;});
    }
    public void removeOrderItem(int orderId,int productId)throws SQLException{
        requireId(orderId);requireId(productId);transaction(c->{dao.removeOrderItem(c,orderId,productId);return null;});
    }
    public Order getOrder(int orderId)throws SQLException{
        requireId(orderId);return dao.getOrder(orderId);
    }
    public List<Order> listOrders()throws SQLException{return dao.listOrders();}
    public BigDecimal calculateOrderTotal(int orderId)throws SQLException{
        requireId(orderId);try(Connection c=DatabaseConnection.getConnection()){
            if(dao.getOrder(c,orderId)==null)throw new IllegalArgumentException("Order does not exist");
            return dao.calculateTotal(c,orderId);
        }
    }
    public void confirmOrder(int orderId)throws SQLException{
        requireId(orderId);
        transaction(c->{
            dao.requireDraft(c,orderId);
            if(dao.countItems(c,orderId)==0)throw new IllegalStateException("Add at least one product before confirming");
            BigDecimal total=dao.calculateTotal(c,orderId);
            if(total.compareTo(new BigDecimal("9999999999.99"))>0)throw new IllegalArgumentException("Order total exceeds database limit");
            // Must use SAME JDBC connection. Inventory locks products in ascending ID order.
            inventory.deductStockForOrder(c,orderId);
            dao.confirm(c,orderId,total);return null;
        });
    }
    public void cancelOrder(int orderId)throws SQLException{
        requireId(orderId);
        transaction(c->{
            OrderStatus status=dao.lockStatus(c,orderId);
            if(status==OrderStatus.CANCELLED)throw new IllegalStateException("Order already cancelled");
            if(status==OrderStatus.CONFIRMED){
                String deliveryStatus=dao.lockDeliveryStatus(c,orderId);
                // Cancellation after dispatch/delivery is outside Task 5 scope.
                if(deliveryStatus!=null&&!deliveryStatus.equals("ASSIGNED")&&!deliveryStatus.equals("SCHEDULED")&&!deliveryStatus.equals("CANCELLED"))
                    throw new IllegalStateException("Cannot cancel a dispatched, failed or delivered order");
                inventory.restoreStock(c,orderId); // logs exactly one CANCEL_RESTOCK per SALE_OUT
                if(deliveryStatus!=null&&!deliveryStatus.equals("CANCELLED"))dao.cancelLinkedUndispatchedDelivery(c,orderId);
            }
            // Draft cancellation doesn't alter stock or create SALE_OUT/CANCEL_RESTOCK events.
            dao.cancel(c,orderId);return null;
        });
    }
    private static void requireId(int id){if(id<=0)throw new IllegalArgumentException("Select an order/product ID");}
}
