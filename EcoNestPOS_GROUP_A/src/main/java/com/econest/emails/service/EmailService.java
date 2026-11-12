package com.econest.emails.service;

import com.econest.config.DatabaseConnection;
import com.econest.deliveries.model.Delivery;
import com.econest.emails.dao.EmailNotificationDAO;
import com.econest.emails.model.EmailNotification;
import com.econest.emails.model.NotificationStatus;
import com.econest.emails.model.NotificationType;
import com.econest.orders.model.Order;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/** Tasks 8 and 9: durable client-dispatch and agent-assignment email outbox. */
public class EmailService {
    private static final Logger LOG=Logger.getLogger(EmailService.class.getName());
    private static final String SUPERSEDED="SUPERSEDED: Agent assignment changed or was cancelled before mail was sent";
    private final EmailNotificationDAO dao;
    private final EmailTransport transport;
    public EmailService(){this(new EmailNotificationDAO(),new SmtpEmailTransport());}
    public EmailService(EmailNotificationDAO dao,EmailTransport transport){
        if(dao==null||transport==null)throw new IllegalArgumentException("DAO and email transport required");
        this.dao=dao;this.transport=transport;
    }
    /** Task 8: called after the dispatch transaction; never inserts a duplicate event. */
    public void notifyClientDispatched(Delivery delivery,Order order){
        if(delivery==null||order==null||delivery.getOrderId()!=order.getOrderId())
            throw new IllegalArgumentException("Delivery/order mismatch");
        try {
            EmailNotification n=dao.latestClientDispatch(delivery.getDeliveryId());
            if(n!=null)send(n);
        }catch(SQLException ex){LOG.log(Level.WARNING,"Client dispatch notification lookup failed",ex);}
    }
    /** Required UML signature, for manual replay of the latest assignment event. */
    public void notifyAgentAssigned(Delivery delivery){
        if(delivery==null)throw new IllegalArgumentException("Delivery required");
        try {
            EmailNotification n=dao.latestAgentAssignment(delivery.getDeliveryId());
            if(n!=null)send(n);
        }catch(SQLException ex){LOG.log(Level.WARNING,"Agent assignment notification lookup failed",ex);}
    }
    /** Exact-event overload used by DeliveryService to avoid a reassignment lookup race. */
    public void notifyAgentAssigned(Delivery delivery,int notificationId){
        if(delivery==null||notificationId<=0)throw new IllegalArgumentException("Delivery and event required");
        try {
            EmailNotification n=dao.findById(notificationId);
            if(n!=null && n.getDeliveryId()==delivery.getDeliveryId()
                    && n.getType()==NotificationType.AGENT_ASSIGNED)send(n);
        }catch(SQLException ex){LOG.log(Level.WARNING,"Agent event lookup failed",ex);}
    }
    public static boolean isSmtpConfigured(){return SmtpEmailTransport.isConfigured();}
    public List<EmailNotification> listNotifications()throws SQLException{return dao.listNotifications();}

    /**
     * Process a persisted notification under an outbox row lock. No new event is created here.
     * A provider may accept SMTP but process can crash before SENT commit; retries can duplicate
     * real mail in that rare case (SMTP itself cannot guarantee exactly-once delivery).
     */
    public boolean send(EmailNotification selected){
        if(selected==null||selected.getNotificationId()<=0)
            throw new IllegalArgumentException("Notification required");
        if(!isSmtpConfigured() && transport instanceof SmtpEmailTransport)return false;
        try(Connection c=DatabaseConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                EmailNotification n=dao.lockById(c,selected.getNotificationId());
                if(n==null){c.rollback();return false;}
                if(n.getStatus()==NotificationStatus.SENT){c.commit();return true;}
                // A superseded assignment must never be resent, even if manually selected.
                if(n.getType()==NotificationType.AGENT_ASSIGNED && n.getFailureReason()!=null
                        && n.getFailureReason().startsWith("SUPERSEDED:")) {c.commit();return false;}
                String subject,body;
                if(n.getType()==NotificationType.CLIENT_DISPATCHED) {
                    EmailNotificationDAO.DispatchDetails d=dao.dispatchDetails(c,n.getDeliveryId());
                    subject="EcoNest — Your order #"+d.orderId+" has been dispatched";
                    body=clientDispatchMessage(d);
                }else if(n.getType()==NotificationType.AGENT_ASSIGNED) {
                    EmailNotificationDAO.AssignmentDetails d=dao.assignmentDetails(c,n.getDeliveryId());
                    // The delivery row stores the CURRENT agent snapshot. A previous event
                    // for a different agent is historical and must not be sent as if current.
                    if(d.cancelled || d.agentEmail==null
                            || !d.agentEmail.equalsIgnoreCase(n.getRecipientEmail())) {
                        dao.markFailed(c,n.getNotificationId(),SUPERSEDED);
                        c.commit();return false;
                    }
                    subject="EcoNest — New delivery assignment for order #"+d.orderId;
                    body=agentAssignmentMessage(d);
                }else{c.commit();return false;}
                try {
                    transport.send(n.getRecipientEmail(),subject,body);
                    dao.markSent(c,n.getNotificationId());
                    c.commit();return true;
                }catch(Exception mailError){
                    String safe=mailError.getClass().getSimpleName()+": "+String.valueOf(mailError.getMessage());
                    dao.markFailed(c,n.getNotificationId(),safe.replaceAll("[\r\n]"," "));
                    c.commit();LOG.log(Level.WARNING,"SMTP rejected notification #"+n.getNotificationId());
                    return false;
                }
            }catch(Exception ex){c.rollback();throw ex;}
        }catch(Exception ex){LOG.log(Level.WARNING,"Email outbox processing failed",ex);return false;}
    }
    /** Required UML API: retry BOTH client and agent notifications. */
    public void retryUnsentNotifications(){
        retryUnsentClientNotifications();
        retryUnsentAgentNotifications();
    }
    /** Separate GUI actions preserve Task 8 and allow isolated Task 9 demonstrations. */
    public void retryUnsentClientNotifications(){
        if(!isSmtpConfigured() && transport instanceof SmtpEmailTransport)return;
        try {for(EmailNotification n:dao.listRetryableClientNotifications())send(n);}
        catch(SQLException ex){LOG.log(Level.WARNING,"Cannot load pending client emails",ex);}
    }
    public void retryUnsentAgentNotifications(){
        if(!isSmtpConfigured() && transport instanceof SmtpEmailTransport)return;
        try {for(EmailNotification n:dao.listRetryableAgentNotifications())send(n);}
        catch(SQLException ex){LOG.log(Level.WARNING,"Cannot load pending agent emails",ex);}
    }
    private static String safe(String text,String fallback){
        return text==null||text.isBlank()?fallback:text.replaceAll("[\r\n]"," ").trim();
    }
    public static String clientDispatchMessage(EmailNotificationDAO.DispatchDetails d){
        String name=safe(d.clientName,"Customer");
        return "Hello "+name+",\n\nYour EcoNest order #"+d.orderId+" has been dispatched.\n"
             +"Dispatched at: "+d.dispatchedAt+"\n"
             +"Delivery agent: "+safe(d.agentName,"Assigned EcoNest agent")+"\n"
             +"Scheduled delivery: "+(d.scheduledFor==null?"Not specified":d.scheduledFor.toString())+"\n\n"
             +"Thank you for choosing EcoNest.\n";
    }
    /** Uses saved assignment snapshot; never queries current delivery_agents master record. */
    public static String agentAssignmentMessage(EmailNotificationDAO.AssignmentDetails d){
        return "Hello "+safe(d.agentName,"Delivery Partner")+",\n\n"
             +"A new EcoNest delivery has been assigned to you.\n"
             +"Order: #"+d.orderId+"\n"
             +"Assigned at: "+d.assignedAt+"\n"
             +"Vehicle: "+safe(d.vehicleType,"Not recorded")+" / "+safe(d.vehicleNumber,"Not recorded")+"\n"
             +"Scheduled delivery: "+(d.scheduledFor==null?"Not scheduled yet":d.scheduledFor.toString())+"\n\n"
             +"Please check your current assignment details in EcoNest before dispatch.\n";
    }
}
