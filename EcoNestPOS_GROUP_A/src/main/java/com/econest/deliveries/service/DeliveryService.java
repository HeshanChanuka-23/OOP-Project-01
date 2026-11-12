package com.econest.deliveries.service;

import com.econest.agents.model.DeliveryAgent;
import com.econest.config.DatabaseConnection;
import com.econest.deliveries.dao.DeliveryDAO;
import com.econest.deliveries.model.Delivery;
import com.econest.deliveries.model.DeliveryStatus;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

/** Task 6: assignment, scheduling and delivery state-machine rules. */
public class DeliveryService {
    private final DeliveryDAO dao;
    public DeliveryService(){this(new DeliveryDAO());}
    public DeliveryService(DeliveryDAO dao){if(dao==null)throw new IllegalArgumentException("DAO required");this.dao=dao;}
    @FunctionalInterface private interface Work<T>{T run(Connection c)throws SQLException;}
    private <T> T transaction(Work<T> work)throws SQLException {
        try(Connection c=DatabaseConnection.getConnection()) {
            c.setAutoCommit(false);
            try {T value=work.run(c);c.commit();return value;}
            catch(SQLException|RuntimeException ex) {c.rollback();throw ex;}
        }
    }
    private static void id(int x,String label){if(x<=0)throw new IllegalArgumentException("Select a valid "+label);}
    private Delivery lock(Connection c,int deliveryId)throws SQLException {
        int oid=dao.orderIdForDelivery(c,deliveryId);
        String orderStatus=dao.lockOrderStatus(c,oid); // always parent Order first
        Delivery d=dao.lockById(c,deliveryId);
        if(d==null)throw new IllegalArgumentException("Delivery no longer exists");
        if(!"CONFIRMED".equals(orderStatus))throw new IllegalStateException("Only confirmed orders can have active deliveries");
        return d;
    }
    /** UML: at most one Delivery per Order; a different agent before dispatch updates the existing record. */
    public Delivery assignAgent(int orderId,int agentId)throws SQLException {
        id(orderId,"order");id(agentId,"agent");
        return transaction(c->{
            if(!"CONFIRMED".equals(dao.lockOrderStatus(c,orderId)))
                throw new IllegalStateException("Confirm the order before assigning a delivery");
            Delivery current=dao.lockByOrder(c,orderId);
            if(current!=null){
                if(current.getStatus()!=DeliveryStatus.ASSIGNED&&current.getStatus()!=DeliveryStatus.SCHEDULED)
                    throw new IllegalStateException("Agent reassignment is allowed only before dispatch");
                if(current.getAgentId()!=null&&current.getAgentId()==agentId)return current; // unchanged assignment: no duplicate email
            }
            DeliveryAgent agent=dao.lockAgent(c,agentId);
            int deliveryId;
            if(current==null){deliveryId=dao.insertAssignment(c,orderId,agent);}
            else{deliveryId=current.getDeliveryId();dao.reassign(c,deliveryId,agent);}
            dao.insertPendingNotification(c,deliveryId,agent.getEmail(),"AGENT_ASSIGNED");
            return dao.lockById(c,deliveryId);
        });
    }
    public void scheduleDelivery(int deliveryId,LocalDateTime date)throws SQLException {
        id(deliveryId,"delivery");if(date==null)throw new IllegalArgumentException("Set the delivery date/time");
        if(!date.isAfter(LocalDateTime.now()))throw new IllegalArgumentException("Schedule for a future date/time");
        transaction(c->{
            Delivery d=lock(c,deliveryId);
            if(d.getStatus()!=DeliveryStatus.ASSIGNED && d.getStatus()!=DeliveryStatus.SCHEDULED)
                throw new IllegalStateException("Only undispatched deliveries can be scheduled");
            if(d.getStatus()==DeliveryStatus.SCHEDULED&&date.equals(d.getScheduledFor()))return null;
            dao.schedule(c,deliveryId,date);return null;
        });
    }
    public void dispatchDelivery(int deliveryId)throws SQLException {
        id(deliveryId,"delivery");
        final Delivery dispatched = transaction(c->{
            Delivery d=lock(c,deliveryId);
            if(d.getStatus()!=DeliveryStatus.SCHEDULED||d.getAgentId()==null||d.getScheduledFor()==null)
                throw new IllegalStateException("Assign an agent and schedule the delivery before dispatch");
            dao.dispatch(c,deliveryId);
            dao.insertPendingNotification(c,deliveryId,dao.clientEmailAtOrder(c,d.getOrderId()),"CLIENT_DISPATCHED");
            return dao.lockById(c,deliveryId);
        });
        // The business transaction is COMMITTED before calling external SMTP.
        // The outbox survives a crash/network failure; retry is available from the Email page.
        Thread mailThread=new Thread(()->{
            try {
                com.econest.orders.model.Order order=
                        new com.econest.orders.service.OrderService().getOrder(dispatched.getOrderId());
                new com.econest.emails.service.EmailService().notifyClientDispatched(dispatched,order);
            }catch(Exception ex){java.util.logging.Logger.getLogger(DeliveryService.class.getName())
                    .log(java.util.logging.Level.WARNING,"Queued client-dispatch email could not be processed",ex);}
        },"EcoNest-client-dispatch-email");
        mailThread.setDaemon(true);mailThread.start();
    }
    public void completeDelivery(int deliveryId)throws SQLException {
        id(deliveryId,"delivery");transaction(c->{
            Delivery d=lock(c,deliveryId);
            if(d.getStatus()!=DeliveryStatus.DISPATCHED)throw new IllegalStateException("Only dispatched deliveries can be completed");
            dao.deliver(c,deliveryId);return null;
        });
    }
    public void failDelivery(int deliveryId,String reason)throws SQLException {
        id(deliveryId,"delivery");
        if(reason==null||reason.isBlank())throw new IllegalArgumentException("Describe why the delivery failed");
        if(reason.length()>3000)throw new IllegalArgumentException("Failure reason is too long");
        transaction(c->{
            Delivery d=lock(c,deliveryId);
            if(d.getStatus()!=DeliveryStatus.DISPATCHED)throw new IllegalStateException("Only dispatched deliveries can be marked failed");
            dao.fail(c,deliveryId,reason.trim());return null;
        });
    }
    /** Cancels the delivery assignment only; does not cancel Order or restore inventory. */
    public void cancelDelivery(int deliveryId)throws SQLException {
        id(deliveryId,"delivery");transaction(c->{
            Delivery d=lock(c,deliveryId);
            if(d.getStatus()!=DeliveryStatus.ASSIGNED && d.getStatus()!=DeliveryStatus.SCHEDULED)
                throw new IllegalStateException("Cannot cancel a dispatched or completed delivery");
            dao.cancel(c,deliveryId);return null;
        });
    }
    public Optional<Delivery> getDeliveryByOrder(int orderId)throws SQLException {
        id(orderId,"order");return Optional.ofNullable(dao.getDeliveryByOrder(orderId));
    }
    public Optional<DeliveryStatus> getDeliveryStatus(int orderId)throws SQLException {
        return getDeliveryByOrder(orderId).map(Delivery::getStatus);
    }
    /** Extra read-only listing for the JTable; no additional entity or DB table. */
    public List<Delivery> listDeliveries()throws SQLException {return dao.listDeliveries();}
}
