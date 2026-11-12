package com.econest.emails.service;
/** Mockable mail transport to keep business tests independent of live SMTP. */
@FunctionalInterface
public interface EmailTransport {
    void send(String to, String subject, String body) throws Exception;
}
