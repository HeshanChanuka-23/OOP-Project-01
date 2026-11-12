package com.econest.emails.model;
import java.time.LocalDateTime;

/** Durable email outbox entity; one notification for one business event. */
public class EmailNotification {
    private int notificationId;
    private int deliveryId;
    private String eventKey;
    private String recipientEmail;
    private NotificationType type;
    private NotificationStatus status = NotificationStatus.PENDING;
    private int attemptCount;
    private String failureReason;
    private LocalDateTime createdAt;
    private LocalDateTime sentAt;

    public EmailNotification() { }
    public int getNotificationId(){return notificationId;}
    public void setNotificationId(int v){if(v<0)throw new IllegalArgumentException("Negative notification ID");notificationId=v;}
    public int getDeliveryId(){return deliveryId;}
    public void setDeliveryId(int v){if(v<0)throw new IllegalArgumentException("Negative delivery ID");deliveryId=v;}
    public String getEventKey(){return eventKey;}
    public void setEventKey(String v){eventKey=v;}
    public String getRecipientEmail(){return recipientEmail;}
    public void setRecipientEmail(String v){recipientEmail=v;}
    public NotificationType getType(){return type;}
    public void setType(NotificationType v){type=v;}
    public NotificationStatus getStatus(){return status;}
    public void setStatus(NotificationStatus v){if(v==null)throw new IllegalArgumentException("Status required");status=v;}
    public int getAttemptCount(){return attemptCount;}
    public void setAttemptCount(int v){if(v<0)throw new IllegalArgumentException("Negative attempts");attemptCount=v;}
    public String getFailureReason(){return failureReason;}
    public void setFailureReason(String v){failureReason=v;}
    public LocalDateTime getCreatedAt(){return createdAt;}
    public void setCreatedAt(LocalDateTime v){createdAt=v;}
    public LocalDateTime getSentAt(){return sentAt;}
    public void setSentAt(LocalDateTime v){sentAt=v;}
    public void markSent(){status=NotificationStatus.SENT;sentAt=LocalDateTime.now();failureReason=null;attemptCount++;}
    public void markFailed(String reason){if(reason==null||reason.isBlank())throw new IllegalArgumentException("Failure reason required");status=NotificationStatus.FAILED;sentAt=null;failureReason=reason;attemptCount++;}
}
