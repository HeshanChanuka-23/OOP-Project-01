package com.econest.orders.dao;

import com.econest.orders.model.*;
import com.econest.config.DatabaseConnection;
import java.math.BigDecimal;
import java.sql.*;
import java.util.*;

/** All Task 5 SQL lives here; OrderService controls transaction boundaries. */
public class OrderDAO {
    public int createOrder(Connection c,int clientId) throws SQLException {
        String clientName,clientEmail,address;
        try(PreparedStatement ps=c.prepareStatement("SELECT name,email,address FROM clients WHERE client_id=? FOR UPDATE")){
            ps.setInt(1,clientId);
            try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())throw new IllegalArgumentException("Client no longer exists");
                clientName=rs.getString(1);clientEmail=rs.getString(2);address=rs.getString(3);
            }
        }
        String sql="INSERT INTO orders (client_id,client_name_at_order,client_email_at_order,delivery_address_at_order,status,total_amount) VALUES(?,?,?,?, 'DRAFT',0)";
        try(PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)){
            ps.setInt(1,clientId);ps.setString(2,clientName);ps.setString(3,clientEmail);ps.setString(4,address);
            if(ps.executeUpdate()!=1)throw new SQLException("Cannot create draft order");
            try(ResultSet rs=ps.getGeneratedKeys()){if(rs.next())return rs.getInt(1);}
        }
        throw new SQLException("Generated order ID was not returned");
    }

    public OrderStatus lockStatus(Connection c,int id) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT status FROM orders WHERE order_id=? FOR UPDATE")){
            ps.setInt(1,id);try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())throw new IllegalArgumentException("Order not found: "+id);
                return OrderStatus.valueOf(rs.getString(1));
            }
        }
    }
    public void requireDraft(Connection c,int orderId) throws SQLException {
        if(lockStatus(c,orderId)!=OrderStatus.DRAFT)throw new IllegalStateException("Only DRAFT orders can be edited");
    }
    public void addOrderItem(Connection c,int orderId,int productId,int quantity) throws SQLException {
        requireDraft(c,orderId);
        String name;BigDecimal price;
        try(PreparedStatement ps=c.prepareStatement("SELECT name,unit_price FROM products WHERE product_id=? FOR UPDATE")){
            ps.setInt(1,productId);try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())throw new IllegalArgumentException("Product no longer exists");
                name=rs.getString(1);price=rs.getBigDecimal(2);
            }
        }
        // A repeated product increases quantity while preserving its ORIGINAL price/name snapshot.
        try(PreparedStatement ps=c.prepareStatement("SELECT order_item_id,quantity FROM order_items WHERE order_id=? AND product_id_at_order=? FOR UPDATE")){
            ps.setInt(1,orderId);ps.setInt(2,productId);
            try(ResultSet rs=ps.executeQuery()){
                if(rs.next()){
                    int id=rs.getInt(1);int combined=Math.addExact(rs.getInt(2),quantity);
                    try(PreparedStatement up=c.prepareStatement("UPDATE order_items SET quantity=? WHERE order_item_id=?")){
                        up.setInt(1,combined);up.setInt(2,id);up.executeUpdate();
                    }
                    recalculateDraftTotal(c,orderId);return;
                }
            }
        }
        String sql="INSERT INTO order_items (order_id,product_id,product_id_at_order,product_name_at_order,quantity,unit_price_at_order) VALUES(?,?,?,?,?,?)";
        try(PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,orderId);ps.setInt(2,productId);ps.setInt(3,productId);
            ps.setString(4,name);ps.setInt(5,quantity);ps.setBigDecimal(6,price);ps.executeUpdate();
        }
        recalculateDraftTotal(c,orderId);
    }
    public void removeOrderItem(Connection c,int orderId,int productId) throws SQLException {
        requireDraft(c,orderId);
        try(PreparedStatement ps=c.prepareStatement("DELETE FROM order_items WHERE order_id=? AND product_id_at_order=?")){
            ps.setInt(1,orderId);ps.setInt(2,productId);
            if(ps.executeUpdate()!=1)throw new IllegalArgumentException("Item not found in order");
        }
        recalculateDraftTotal(c,orderId);
    }
    private void recalculateDraftTotal(Connection c,int orderId) throws SQLException {
        BigDecimal total=calculateTotal(c,orderId);
        try(PreparedStatement ps=c.prepareStatement("UPDATE orders SET total_amount=? WHERE order_id=? AND status='DRAFT'")){
            ps.setBigDecimal(1,total);ps.setInt(2,orderId);ps.executeUpdate();
        }
    }
    public BigDecimal calculateTotal(Connection c,int orderId) throws SQLException {
        String sql="SELECT COALESCE(SUM(quantity*unit_price_at_order),0) FROM order_items WHERE order_id=?";
        try(PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,orderId);try(ResultSet rs=ps.executeQuery()){rs.next();return rs.getBigDecimal(1);}
        }
    }
    public int countItems(Connection c,int orderId) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT COUNT(*) FROM order_items WHERE order_id=?")){
            ps.setInt(1,orderId);try(ResultSet rs=ps.executeQuery()){rs.next();return rs.getInt(1);}
        }
    }
    public void confirm(Connection c,int orderId,BigDecimal total) throws SQLException {
        String sql="UPDATE orders SET status='CONFIRMED', confirmed_at=GREATEST(created_at,NOW(6)), total_amount=? WHERE order_id=? AND status='DRAFT'";
        try(PreparedStatement ps=c.prepareStatement(sql)){
            ps.setBigDecimal(1,total);ps.setInt(2,orderId);
            if(ps.executeUpdate()!=1)throw new IllegalStateException("Order cannot be confirmed twice");
        }
    }
    public String lockDeliveryStatus(Connection c,int orderId) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT status FROM deliveries WHERE order_id=? FOR UPDATE")){
            ps.setInt(1,orderId);try(ResultSet rs=ps.executeQuery()){return rs.next()?rs.getString(1):null;}
        }
    }
    public void cancelLinkedUndispatchedDelivery(Connection c,int orderId) throws SQLException {
        String sql="UPDATE deliveries SET status='CANCELLED',cancelled_at=GREATEST(assigned_at,NOW(6)) WHERE order_id=? AND status IN ('ASSIGNED','SCHEDULED')";
        try(PreparedStatement ps=c.prepareStatement(sql)){ps.setInt(1,orderId);ps.executeUpdate();}
    }
    public void cancel(Connection c,int orderId) throws SQLException {
        String sql="UPDATE orders SET status='CANCELLED', cancelled_at=GREATEST(COALESCE(confirmed_at,created_at),NOW(6)) WHERE order_id=? AND status<>'CANCELLED'";
        try(PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,orderId);if(ps.executeUpdate()!=1)throw new IllegalStateException("Order already cancelled");
        }
    }
    public Order getOrder(int id) throws SQLException {
        try(Connection c=DatabaseConnection.getConnection()){return getOrder(c,id);}
    }
    public Order getOrder(Connection c,int id) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT * FROM orders WHERE order_id=?")){
            ps.setInt(1,id);try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())return null;
                Order order=mapOrder(rs);order.setItems(loadItems(c,id));return order;
            }
        }
    }
    public List<Order> listOrders() throws SQLException {
        try(Connection c=DatabaseConnection.getConnection()){
            List<Order> rows=new ArrayList<>();
            try(PreparedStatement ps=c.prepareStatement("SELECT * FROM orders ORDER BY order_id DESC");ResultSet rs=ps.executeQuery()){
                while(rs.next())rows.add(mapOrder(rs));
            }
            for(Order o:rows)o.setItems(loadItems(c,o.getOrderId()));
            return rows;
        }
    }
    public List<OrderItem> loadItems(Connection c,int id) throws SQLException {
        List<OrderItem> rows=new ArrayList<>();
        String sql="SELECT order_item_id,product_id,product_id_at_order,product_name_at_order,quantity,unit_price_at_order FROM order_items WHERE order_id=? ORDER BY order_item_id";
        try(PreparedStatement ps=c.prepareStatement(sql)){
            ps.setInt(1,id);try(ResultSet rs=ps.executeQuery()){
                while(rs.next()){
                    int pid=rs.getInt(2);Integer nullableId=rs.wasNull()?null:pid;
                    rows.add(new OrderItem(rs.getInt(1),nullableId,rs.getInt(3),rs.getString(4),rs.getInt(5),rs.getBigDecimal(6)));
                }
            }
        }
        return rows;
    }
    private Order mapOrder(ResultSet rs) throws SQLException {
        Order o=new Order();o.setOrderId(rs.getInt("order_id"));
        int cid=rs.getInt("client_id");o.setClientId(rs.wasNull()?null:cid);
        o.setClientNameAtOrder(rs.getString("client_name_at_order"));
        o.setClientEmailAtOrder(rs.getString("client_email_at_order"));
        o.setDeliveryAddressAtOrder(rs.getString("delivery_address_at_order"));
        Timestamp t=rs.getTimestamp("created_at");o.setCreatedAt(t==null?null:t.toLocalDateTime());
        t=rs.getTimestamp("confirmed_at");o.setConfirmedAt(t==null?null:t.toLocalDateTime());
        t=rs.getTimestamp("cancelled_at");o.setCancelledAt(t==null?null:t.toLocalDateTime());
        o.setStatus(OrderStatus.valueOf(rs.getString("status")));o.setTotalAmount(rs.getBigDecimal("total_amount"));return o;
    }
}
