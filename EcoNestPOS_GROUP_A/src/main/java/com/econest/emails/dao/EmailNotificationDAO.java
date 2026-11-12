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
    /** Task 8 sends only CLIENT_DISPATCHED; Task 9 will enable agent assignment sending. */
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
