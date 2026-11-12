package com.econest.deliveries.model;

import com.econest.agents.model.DeliveryAgent;
import java.time.LocalDateTime;

/** Domain entity from the final Master Class Diagram (Task 6). */
public class Delivery {
    private int deliveryId;
    private int orderId;
    private Integer agentId;
    private String agentNameAtAssignment;
    private String agentEmailAtAssignment;
    private String vehicleTypeAtAssignment;
    private String vehicleNumberAtAssignment;
    private LocalDateTime scheduledFor;
    private LocalDateTime assignedAt;
    private LocalDateTime dispatchedAt;
    private LocalDateTime deliveredAt;
    private LocalDateTime cancelledAt;
    private String failureReason;
    private DeliveryStatus status = DeliveryStatus.ASSIGNED;

    public Delivery() { }
    public int getDeliveryId(){return deliveryId;}
    public void setDeliveryId(int v){if(v<0)throw new IllegalArgumentException("Invalid delivery ID");deliveryId=v;}
    public int getOrderId(){return orderId;}
    public void setOrderId(int v){if(v<0)throw new IllegalArgumentException("Invalid order ID");orderId=v;}
    public Integer getAgentId(){return agentId;}
    public void setAgentId(Integer v){agentId=v;}
    public String getAgentNameAtAssignment(){return agentNameAtAssignment;}
    public void setAgentNameAtAssignment(String v){agentNameAtAssignment=v;}
    public String getAgentEmailAtAssignment(){return agentEmailAtAssignment;}
    public void setAgentEmailAtAssignment(String v){agentEmailAtAssignment=v;}
    public String getVehicleTypeAtAssignment(){return vehicleTypeAtAssignment;}
    public void setVehicleTypeAtAssignment(String v){vehicleTypeAtAssignment=v;}
    public String getVehicleNumberAtAssignment(){return vehicleNumberAtAssignment;}
    public void setVehicleNumberAtAssignment(String v){vehicleNumberAtAssignment=v;}
    public LocalDateTime getScheduledFor(){return scheduledFor;}
    public void setScheduledFor(LocalDateTime v){scheduledFor=v;}
    public LocalDateTime getAssignedAt(){return assignedAt;}
    public void setAssignedAt(LocalDateTime v){assignedAt=v;}
    public LocalDateTime getDispatchedAt(){return dispatchedAt;}
    public void setDispatchedAt(LocalDateTime v){dispatchedAt=v;}
    public LocalDateTime getDeliveredAt(){return deliveredAt;}
    public void setDeliveredAt(LocalDateTime v){deliveredAt=v;}
    public LocalDateTime getCancelledAt(){return cancelledAt;}
    public void setCancelledAt(LocalDateTime v){cancelledAt=v;}
    public String getFailureReason(){return failureReason;}
    public void setFailureReason(String v){failureReason=v;}
    public DeliveryStatus getStatus(){return status;}
    public void setStatus(DeliveryStatus v){if(v==null)throw new IllegalArgumentException("Delivery status required");status=v;}

    /** Update the current agent and its historical assignment snapshot. */
    public void assignAgent(DeliveryAgent agent){
        if(agent==null||agent.getAgentId()<=0)throw new IllegalArgumentException("Select an existing delivery agent");
        if(status!=DeliveryStatus.ASSIGNED && status!=DeliveryStatus.SCHEDULED)
            throw new IllegalStateException("Reassignment is allowed only before dispatch");
        agentId=agent.getAgentId();
        agentNameAtAssignment=agent.getName();
        agentEmailAtAssignment=agent.getEmail();
        vehicleTypeAtAssignment=agent.getVehicleType();
        vehicleNumberAtAssignment=agent.getVehicleNumber();
        assignedAt=LocalDateTime.now();
    }
    public void schedule(LocalDateTime date){
        if(status!=DeliveryStatus.ASSIGNED && status!=DeliveryStatus.SCHEDULED)
            throw new IllegalStateException("Only assigned, undispatched deliveries can be scheduled");
        if(date==null)throw new IllegalArgumentException("Scheduled date is required");
        scheduledFor=date;status=DeliveryStatus.SCHEDULED;
    }
    public void markDispatched(){
        if(status!=DeliveryStatus.SCHEDULED||agentId==null||scheduledFor==null)
            throw new IllegalStateException("Schedule and assign an agent before dispatch");
        dispatchedAt=LocalDateTime.now();status=DeliveryStatus.DISPATCHED;
    }
    public void markDelivered(){
        if(status!=DeliveryStatus.DISPATCHED)throw new IllegalStateException("Only dispatched deliveries can be delivered");
        deliveredAt=LocalDateTime.now();status=DeliveryStatus.DELIVERED;
    }
    public void markFailed(String reason){
        if(status!=DeliveryStatus.DISPATCHED)throw new IllegalStateException("Only dispatched deliveries can be marked failed");
        if(reason==null||reason.isBlank())throw new IllegalArgumentException("Failure reason required");
        failureReason=reason.trim();status=DeliveryStatus.FAILED;
    }
    public void cancel(){
        if(status!=DeliveryStatus.ASSIGNED && status!=DeliveryStatus.SCHEDULED)
            throw new IllegalStateException("Only an undispatched assignment can be cancelled");
        cancelledAt=LocalDateTime.now();status=DeliveryStatus.CANCELLED;
    }
}
