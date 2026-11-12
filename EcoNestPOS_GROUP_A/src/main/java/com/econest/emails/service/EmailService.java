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

/** Task 8: durable client-dispatch email outbox, safe retry, and after-commit sending. */
public class EmailService {
    private static final Logger LOG=Logger.getLogger(EmailService.class.getName());
    private final EmailNotificationDAO dao;
    private final EmailTransport transport;
    public EmailService(){this(new EmailNotificationDAO(),new SmtpEmailTransport());}
    public EmailService(EmailNotificationDAO dao,EmailTransport transport){
        if(dao==null||transport==null)throw new IllegalArgumentException("DAO and email transport required");
        this.dao=dao;this.transport=transport;
    }
    /** Called only AFTER the dispatch DB transaction commits; does not enqueue another event. */
    public void notifyClientDispatched(Delivery delivery,Order order){
        if(delivery==null||order==null||delivery.getOrderId()!=order.getOrderId())
            throw new IllegalArgumentException("Delivery/order mismatch");
        try {
            EmailNotification n=dao.latestClientDispatch(delivery.getDeliveryId());
            if(n!=null)send(n);
        } catch(SQLException ex){LOG.log(Level.WARNING,"Client dispatch notification lookup failed",ex);}
    }
    /** Implemented in Task 9: route agent outbox events after assignment, not here. */
    public void notifyAgentAssigned(Delivery delivery){
        if(delivery==null)throw new IllegalArgumentException("Delivery required");
        // Task 6 already creates an AGENT_ASSIGNED PENDING event, but Task 8 does not send it.
    }
    /** SMTP configuration may be missing during development; leave event PENDING for later. */
    public static boolean isSmtpConfigured(){return SmtpEmailTransport.isConfigured();}
    public List<EmailNotification> listNotifications()throws SQLException{return dao.listNotifications();}

    /**
     * Locks one event row to prevent concurrent sends, then records SENT/FAILED atomically.
     * A crash after the mail provider accepts the message but before committing SENT can
     * still cause a duplicate on retry; SMTP does not provide exactly-once delivery.
     */
    public boolean send(EmailNotification selected){
        if(selected==null||selected.getNotificationId()<=0)throw new IllegalArgumentException("Notification required");
        if(!isSmtpConfigured() && transport instanceof SmtpEmailTransport)return false;
        try(Connection c=DatabaseConnection.getConnection()) {
            c.setAutoCommit(false);
            try {
                EmailNotification n=dao.lockById(c,selected.getNotificationId());
                if(n==null){c.rollback();return false;}
                if(n.getStatus()==NotificationStatus.SENT){c.commit();return true;}
                // Scope guard: agent emails are owned by Task 9.
                if(n.getType()!=NotificationType.CLIENT_DISPATCHED){c.commit();return false;}
                EmailNotificationDAO.DispatchDetails d=dao.dispatchDetails(c,n.getDeliveryId());
                try {
                    transport.send(n.getRecipientEmail(),"EcoNest — Your order #"+d.orderId+" has been dispatched",
                            clientDispatchMessage(d));
                    dao.markSent(c,n.getNotificationId());
                    c.commit();return true;
                } catch(Exception mailError){
                    // Keep original notification. Record one failed attempt; never roll back dispatch.
                    String safe=mailError.getClass().getSimpleName()+": "+String.valueOf(mailError.getMessage());
                    dao.markFailed(c,n.getNotificationId(),safe.replaceAll("[\\r\\n]"," "));
                    c.commit();LOG.log(Level.WARNING,"Mail provider rejected dispatch event #"+n.getNotificationId());
                    return false;
                }
            } catch(Exception ex) {c.rollback();throw ex;}
        } catch(Exception ex){LOG.log(Level.WARNING,"Client email outbox processing failed",ex);return false;}
    }
    public void retryUnsentNotifications(){
        if(!isSmtpConfigured() && transport instanceof SmtpEmailTransport)return;
        try {
            for(EmailNotification n:dao.listRetryableClientNotifications())send(n);
        } catch(SQLException ex){LOG.log(Level.WARNING,"Unable to load pending client emails",ex);}
    }
    public static String clientDispatchMessage(EmailNotificationDAO.DispatchDetails d){
        String name=d.clientName==null||d.clientName.isBlank()?"Customer":d.clientName.replaceAll("[\\r\\n]"," ");
        return "Hello "+name+",\n\nYour EcoNest order #"+d.orderId+" has been dispatched.\n"
             +"Dispatched at: "+d.dispatchedAt+"\n"
             +"Delivery agent: "+(d.agentName==null?"Assigned EcoNest agent":d.agentName.replaceAll("[\\r\\n]"," "))+"\n"
             +"Scheduled delivery: "+(d.scheduledFor==null?"Not specified":d.scheduledFor.toString())+"\n\n"
             +"Thank you for choosing EcoNest.\n";
    }
}
