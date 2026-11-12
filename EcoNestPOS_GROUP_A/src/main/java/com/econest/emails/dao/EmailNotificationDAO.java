package com.econest.emails.dao;

import com.econest.config.DatabaseConnection;
import com.econest.emails.model.EmailNotification;
import com.econest.emails.model.NotificationStatus;
import com.econest.emails.model.NotificationType;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/** All email outbox SQL; send status is updated without modifying delivery records. */
public class EmailNotificationDAO {
    public static final class DispatchDetails {
        public final int orderId;
        public final String clientName;
        public final String agentName;
        public final Timestamp dispatchedAt;
        public final Timestamp scheduledFor;
        public DispatchDetails(int id,String client,String agent,Timestamp dispatch,Timestamp scheduled){
            this.orderId=id;clientName=client;agentName=agent;dispatchedAt=dispatch;scheduledFor=scheduled;
        }
    }
    /** Snapshot of the CURRENT assignment; earlier superseded events are never sent. */
    public static final class AssignmentDetails {
        public final int orderId;
        public final String agentName, vehicleType, vehicleNumber;
        public final String agentEmail;
        public final Timestamp assignedAt, scheduledFor;
        public final boolean cancelled;
        public AssignmentDetails(int orderId, String agentName, String agentEmail,
                String vehicleType, String vehicleNumber, Timestamp assignedAt,
                Timestamp scheduledFor, boolean cancelled) {
            this.orderId=orderId;this.agentName=agentName;this.agentEmail=agentEmail;
            this.vehicleType=vehicleType;this.vehicleNumber=vehicleNumber;
            this.assignedAt=assignedAt;this.scheduledFor=scheduledFor;this.cancelled=cancelled;
        }
    }
    /** Used by the after-commit callback to process the EXACT new event, not a later reassignment event. */
    public EmailNotification findById(int id)throws SQLException {
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("SELECT * FROM email_notifications WHERE notification_id=?")) {
            p.setInt(1,id);try(ResultSet rs=p.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    public EmailNotification latestAgentAssignment(int deliveryId)throws SQLException {
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("SELECT * FROM email_notifications WHERE delivery_id=? AND type='AGENT_ASSIGNED' ORDER BY notification_id DESC LIMIT 1")) {
            p.setInt(1,deliveryId);try(ResultSet rs=p.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    /** Retry agent outbox events, excluding superseded/cancelled assignments. */
    public List<EmailNotification> listRetryableAgentNotifications()throws SQLException {
        List<EmailNotification> out=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();
            PreparedStatement p=c.prepareStatement("SELECT * FROM email_notifications " +
                    "WHERE type='AGENT_ASSIGNED' AND status IN ('PENDING','FAILED') " +
                    "AND (failure_reason IS NULL OR failure_reason NOT LIKE 'SUPERSEDED:%') " +
                    "ORDER BY notification_id LIMIT 100");ResultSet rs=p.executeQuery()) {
            while(rs.next())out.add(map(rs));
        }
        return out;
    }
    /** Uses the delivery's saved agent name, vehicle and assignment timestamp. */
    public AssignmentDetails assignmentDetails(Connection c, int deliveryId)throws SQLException {
        try(PreparedStatement p=c.prepareStatement(
                "SELECT order_id,agent_name_at_assignment,agent_email_at_assignment,"+
                "vehicle_type_at_assignment,vehicle_number_at_assignment,assigned_at,scheduled_for,status " +
                "FROM deliveries WHERE delivery_id=?")) {
            p.setInt(1,deliveryId);try(ResultSet rs=p.executeQuery()) {
                if(!rs.next())throw new SQLException("Delivery assignment snapshot not found");
                Timestamp assignedAt=rs.getTimestamp("assigned_at");
                if(assignedAt==null)throw new SQLException("Delivery has no assignment timestamp");
                return new AssignmentDetails(rs.getInt("order_id"),rs.getString("agent_name_at_assignment"),
                        rs.getString("agent_email_at_assignment"),rs.getString("vehicle_type_at_assignment"),
                        rs.getString("vehicle_number_at_assignment"),assignedAt,
                        rs.getTimestamp("scheduled_for"),"CANCELLED".equals(rs.getString("status")));
            }
        }
    }
    private static EmailNotification map(ResultSet rs)throws SQLException {
        EmailNotification n=new EmailNotification();
        n.setNotificationId(rs.getInt("notification_id"));n.setDeliveryId(rs.getInt("delivery_id"));
        n.setEventKey(rs.getString("event_key"));n.setRecipientEmail(rs.getString("recipient_email"));
        n.setType(NotificationType.valueOf(rs.getString("type")));
        n.setStatus(NotificationStatus.valueOf(rs.getString("status")));
        n.setAttemptCount(rs.getInt("attempt_count"));n.setFailureReason(rs.getString("failure_reason"));
        Timestamp ts=rs.getTimestamp("created_at");n.setCreatedAt(ts==null?null:ts.toLocalDateTime());
        ts=rs.getTimestamp("sent_at");n.setSentAt(ts==null?null:ts.toLocalDateTime());
        return n;
    }
    public EmailNotification lockById(Connection c,int id)throws SQLException {
        try(PreparedStatement p=c.prepareStatement("SELECT * FROM email_notifications WHERE notification_id=? FOR UPDATE")){
            p.setInt(1,id);try(ResultSet rs=p.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    /** The event already exists: DeliveryService inserts it during the dispatch transaction. */
    public EmailNotification latestClientDispatch(int deliveryId)throws SQLException {
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement(
                "SELECT * FROM email_notifications WHERE delivery_id=? AND type='CLIENT_DISPATCHED' ORDER BY notification_id DESC LIMIT 1")) {
            p.setInt(1,deliveryId);try(ResultSet rs=p.executeQuery()){return rs.next()?map(rs):null;}
        }
    }
    public List<EmailNotification> listNotifications()throws SQLException {
        List<EmailNotification> out=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement(
                "SELECT * FROM email_notifications ORDER BY notification_id DESC LIMIT 500");ResultSet rs=p.executeQuery()){
            while(rs.next())out.add(map(rs));
        }
        return out;
    }
    /** Client dispatch retry queue (Task 8). */
    public List<EmailNotification> listRetryableClientNotifications()throws SQLException {
        List<EmailNotification> out=new ArrayList<>();
        try(Connection c=DatabaseConnection.getConnection();PreparedStatement p=c.prepareStatement(
                "SELECT * FROM email_notifications WHERE type='CLIENT_DISPATCHED' AND status IN ('PENDING','FAILED') ORDER BY notification_id LIMIT 100");ResultSet rs=p.executeQuery()){
            while(rs.next())out.add(map(rs));
        }
        return out;
    }
    /** Historical order snapshot; client deletions/edits must not change email recipient/name. */
    public DispatchDetails dispatchDetails(Connection c,int deliveryId)throws SQLException {
        try(PreparedStatement p=c.prepareStatement(
                "SELECT d.order_id,o.client_name_at_order,d.agent_name_at_assignment,d.dispatched_at,d.scheduled_for "+
                "FROM deliveries d JOIN orders o ON o.order_id=d.order_id WHERE d.delivery_id=?")) {
            p.setInt(1,deliveryId);try(ResultSet rs=p.executeQuery()){
                if(!rs.next())throw new SQLException("Delivery snapshot not found");
                Timestamp when=rs.getTimestamp("dispatched_at");
                if(when==null)throw new SQLException("Delivery has not been dispatched");
                return new DispatchDetails(rs.getInt(1),rs.getString(2),rs.getString(3),when,rs.getTimestamp("scheduled_for"));
            }
        }
    }
    public void markSent(Connection c,int id)throws SQLException {
        try(PreparedStatement p=c.prepareStatement(
                "UPDATE email_notifications SET status='SENT',attempt_count=attempt_count+1,sent_at=NOW(6),failure_reason=NULL "+
                "WHERE notification_id=? AND status IN ('PENDING','FAILED')")) {
            p.setInt(1,id);if(p.executeUpdate()!=1)throw new SQLException("Could not mark email as SENT");
        }
    }
    public void markFailed(Connection c,int id,String reason)throws SQLException {
        try(PreparedStatement p=c.prepareStatement(
                "UPDATE email_notifications SET status='FAILED',attempt_count=attempt_count+1,sent_at=NULL,failure_reason=? "+
                "WHERE notification_id=? AND status IN ('PENDING','FAILED')")) {
            p.setString(1,reason.length()>2000?reason.substring(0,2000):reason);
            p.setInt(2,id);if(p.executeUpdate()!=1)throw new SQLException("Could not mark email as FAILED");
        }
    }
}
