package com.econest.deliveries.dao;

import com.econest.agents.model.DeliveryAgent;
import com.econest.config.DatabaseConnection;
import com.econest.deliveries.model.Delivery;
import com.econest.deliveries.model.DeliveryStatus;
import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/** All Task 6 SQL is isolated here. Transaction ownership belongs to DeliveryService. */
public class DeliveryDAO {
    public String lockOrderStatus(Connection c, int orderId) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT status FROM orders WHERE order_id=? FOR UPDATE")) {
            ps.setInt(1,orderId);
            try(ResultSet rs=ps.executeQuery()) {
                if(!rs.next())throw new IllegalArgumentException("Order does not exist: #"+orderId);
                return rs.getString(1);
            }
        }
    }
    /** Read order ID first, then lock the parent Order before the Delivery to match OrderService lock order. */
    public int orderIdForDelivery(Connection c, int deliveryId) throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT order_id FROM deliveries WHERE delivery_id=?")) {
            ps.setInt(1,deliveryId);
            try(ResultSet rs=ps.executeQuery()) {
                if(!rs.next())throw new IllegalArgumentException("Delivery does not exist: #"+deliveryId);
                return rs.getInt(1);
            }
        }
    }
    public Delivery lockByOrder(Connection c,int orderId)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT * FROM deliveries WHERE order_id=? FOR UPDATE")) {
            ps.setInt(1,orderId);try(ResultSet rs=ps.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    public Delivery lockById(Connection c,int deliveryId)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT * FROM deliveries WHERE delivery_id=? FOR UPDATE")) {
            ps.setInt(1,deliveryId);try(ResultSet rs=ps.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    public DeliveryAgent lockAgent(Connection c,int agentId)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT agent_id,name,email,phone,vehicle_type,vehicle_number FROM delivery_agents WHERE agent_id=? FOR UPDATE")) {
            ps.setInt(1,agentId);try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())throw new IllegalArgumentException("Delivery agent no longer exists: #"+agentId);
                return new DeliveryAgent(rs.getInt("agent_id"),rs.getString("name"),rs.getString("email"),rs.getString("phone"),rs.getString("vehicle_type"),rs.getString("vehicle_number"));
            }
        }
    }
    public int insertAssignment(Connection c,int orderId,DeliveryAgent a)throws SQLException {
        String sql="INSERT INTO deliveries (order_id,agent_id,agent_name_at_assignment,agent_email_at_assignment,"+
                   "vehicle_type_at_assignment,vehicle_number_at_assignment,status) VALUES(?,?,?,?,?,?,'ASSIGNED')";
        try(PreparedStatement ps=c.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1,orderId);ps.setInt(2,a.getAgentId());ps.setString(3,a.getName());ps.setString(4,a.getEmail());
            ps.setString(5,a.getVehicleType());ps.setString(6,a.getVehicleNumber());
            if(ps.executeUpdate()!=1)throw new SQLException("Delivery assignment was not created");
            try(ResultSet rs=ps.getGeneratedKeys()){if(rs.next())return rs.getInt(1);}
        }
        throw new SQLException("Delivery ID was not returned by MariaDB");
    }
    public void reassign(Connection c,int deliveryId,DeliveryAgent a)throws SQLException {
        String sql="UPDATE deliveries SET agent_id=?,agent_name_at_assignment=?,agent_email_at_assignment=?,"+
                   "vehicle_type_at_assignment=?,vehicle_number_at_assignment=?,assigned_at=NOW(6) " +
                   "WHERE delivery_id=? AND status IN ('ASSIGNED','SCHEDULED')";
        try(PreparedStatement ps=c.prepareStatement(sql)) {
            ps.setInt(1,a.getAgentId());ps.setString(2,a.getName());ps.setString(3,a.getEmail());
            ps.setString(4,a.getVehicleType());ps.setString(5,a.getVehicleNumber());ps.setInt(6,deliveryId);
            checkOne(ps.executeUpdate(),"Delivery cannot be reassigned after dispatch");
        }
    }
    public void schedule(Connection c,int deliveryId,LocalDateTime date)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement(
                "UPDATE deliveries SET scheduled_for=?,status='SCHEDULED' WHERE delivery_id=? AND status IN ('ASSIGNED','SCHEDULED')")) {
            ps.setTimestamp(1,Timestamp.valueOf(date));ps.setInt(2,deliveryId);
            checkOne(ps.executeUpdate(),"Delivery cannot be scheduled in this state");
        }
    }
    public void dispatch(Connection c,int deliveryId)throws SQLException {
        String sql="UPDATE deliveries SET status='DISPATCHED',dispatched_at=GREATEST(assigned_at,NOW(6)) "+
                   "WHERE delivery_id=? AND status='SCHEDULED' AND agent_id IS NOT NULL AND scheduled_for IS NOT NULL";
        try(PreparedStatement ps=c.prepareStatement(sql)){ps.setInt(1,deliveryId);checkOne(ps.executeUpdate(),"Assign and schedule before dispatch");}
    }
    public void deliver(Connection c,int deliveryId)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement(
                "UPDATE deliveries SET status='DELIVERED',delivered_at=GREATEST(dispatched_at,NOW(6)) WHERE delivery_id=? AND status='DISPATCHED'")) {
            ps.setInt(1,deliveryId);checkOne(ps.executeUpdate(),"Only dispatched deliveries can be completed");
        }
    }
    public void fail(Connection c,int deliveryId,String reason)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement(
                "UPDATE deliveries SET status='FAILED',failure_reason=? WHERE delivery_id=? AND status='DISPATCHED'")) {
            ps.setString(1,reason);ps.setInt(2,deliveryId);checkOne(ps.executeUpdate(),"Only dispatched deliveries can be marked failed");
        }
    }
    public void cancel(Connection c,int deliveryId)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement(
                "UPDATE deliveries SET status='CANCELLED',cancelled_at=GREATEST(assigned_at,NOW(6)) "+
                "WHERE delivery_id=? AND status IN ('ASSIGNED','SCHEDULED')")) {
            ps.setInt(1,deliveryId);checkOne(ps.executeUpdate(),"Only an undispatched delivery can be cancelled");
        }
    }
    public String clientEmailAtOrder(Connection c,int orderId)throws SQLException {
        try(PreparedStatement ps=c.prepareStatement("SELECT client_email_at_order FROM orders WHERE order_id=?")) {
            ps.setInt(1,orderId);try(ResultSet rs=ps.executeQuery()){
                if(!rs.next())throw new IllegalArgumentException("Order no longer exists");
                return rs.getString(1);
            }
        }
    }
    /** Transactional outbox: insert the PENDING event in the business transaction. */
    public void insertPendingNotification(Connection c,int deliveryId,String recipient,String type)throws SQLException {
        insertPendingNotificationReturningId(c,deliveryId,recipient,type);
    }
    /** Returns the exact new event ID for Task 9's after-commit agent-email callback. */
    public int insertPendingNotificationReturningId(Connection c,int deliveryId,String recipient,String type)throws SQLException {
        if(recipient==null||recipient.isBlank())throw new IllegalArgumentException("Notification recipient cannot be blank");
        String eventKey=type+"-"+deliveryId+"-"+UUID.randomUUID();
        try(PreparedStatement ps=c.prepareStatement(
                "INSERT INTO email_notifications (delivery_id,event_key,recipient_email,type,status) VALUES(?,?,?,?,'PENDING')",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setInt(1,deliveryId);ps.setString(2,eventKey);ps.setString(3,recipient);ps.setString(4,type);
            checkOne(ps.executeUpdate(),"Failed to record pending email notification");
            try(ResultSet keys=ps.getGeneratedKeys()) {
                if(keys.next())return keys.getInt(1);
            }
        }
        throw new SQLException("MariaDB did not return notification ID");
    }
    public Delivery getDeliveryByOrder(int orderId)throws SQLException {
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT * FROM deliveries WHERE order_id=?")) {
            ps.setInt(1,orderId);try(ResultSet rs=ps.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    public List<Delivery> listDeliveries()throws SQLException {
        List<Delivery> items=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement ps=c.prepareStatement("SELECT * FROM deliveries ORDER BY delivery_id DESC");
            ResultSet rs=ps.executeQuery()) {
            while(rs.next())items.add(map(rs));
        }
        return items;
    }
    private static void checkOne(int count,String message){if(count!=1)throw new IllegalStateException(message);}
    private Delivery map(ResultSet rs)throws SQLException {
        Delivery d=new Delivery();d.setDeliveryId(rs.getInt("delivery_id"));d.setOrderId(rs.getInt("order_id"));
        int agent=rs.getInt("agent_id");d.setAgentId(rs.wasNull()?null:agent);
        d.setAgentNameAtAssignment(rs.getString("agent_name_at_assignment"));
        d.setAgentEmailAtAssignment(rs.getString("agent_email_at_assignment"));
        d.setVehicleTypeAtAssignment(rs.getString("vehicle_type_at_assignment"));
        d.setVehicleNumberAtAssignment(rs.getString("vehicle_number_at_assignment"));
        Timestamp ts=rs.getTimestamp("assigned_at");d.setAssignedAt(ts==null?null:ts.toLocalDateTime());
        ts=rs.getTimestamp("scheduled_for");d.setScheduledFor(ts==null?null:ts.toLocalDateTime());
        ts=rs.getTimestamp("dispatched_at");d.setDispatchedAt(ts==null?null:ts.toLocalDateTime());
        ts=rs.getTimestamp("delivered_at");d.setDeliveredAt(ts==null?null:ts.toLocalDateTime());
        ts=rs.getTimestamp("cancelled_at");d.setCancelledAt(ts==null?null:ts.toLocalDateTime());
        d.setFailureReason(rs.getString("failure_reason"));d.setStatus(DeliveryStatus.valueOf(rs.getString("status")));
        return d;
    }
}
