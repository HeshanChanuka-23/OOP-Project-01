package com.econest.emails.service;

import jakarta.mail.Authenticator;
import jakarta.mail.Message;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import java.nio.charset.StandardCharsets;
import java.util.Properties;

/**
 * Real SMTP transport. TLS only; configuration is read from environment variables,
 * not a committed config file. SMTP password can be a provider-specific app password.
 */
public final class SmtpEmailTransport implements EmailTransport {
    private static String env(String name){return System.getenv().getOrDefault(name, "").trim();}
    public static boolean isConfigured(){
        return !env("ECONEST_SMTP_HOST").isEmpty() && !env("ECONEST_SMTP_USER").isEmpty()
                && !env("ECONEST_SMTP_PASSWORD").isEmpty() && !env("ECONEST_SMTP_FROM").isEmpty();
    }
    @Override public void send(String to, String subject, String body) throws Exception {
        if(!isConfigured())throw new IllegalStateException("SMTP credentials are not configured");
        String host=env("ECONEST_SMTP_HOST");
        String user=env("ECONEST_SMTP_USER");
        String password=env("ECONEST_SMTP_PASSWORD");
        String from=env("ECONEST_SMTP_FROM");
        String portText=env("ECONEST_SMTP_PORT");
        int port=portText.isEmpty()?587:Integer.parseInt(portText);
        if(port!=587 && port!=465)throw new IllegalArgumentException("Only secure SMTP ports 587 or 465 are supported");
        Properties props=new Properties();
        props.put("mail.smtp.host",host);props.put("mail.smtp.port",Integer.toString(port));
        props.put("mail.smtp.auth","true");
        props.put("mail.smtp.connectiontimeout","9000");
        props.put("mail.smtp.timeout","9000");
        props.put("mail.smtp.writetimeout","9000");
        if(port==465)props.put("mail.smtp.ssl.enable","true");
        else {props.put("mail.smtp.starttls.enable","true");props.put("mail.smtp.starttls.required","true");}
        Session session=Session.getInstance(props,new Authenticator(){
            @Override protected PasswordAuthentication getPasswordAuthentication(){return new PasswordAuthentication(user,password);}
        });
        MimeMessage email=new MimeMessage(session);
        email.setFrom(new InternetAddress(from,true));
        email.setRecipient(Message.RecipientType.TO,new InternetAddress(to,true));
        email.setSubject(subject,StandardCharsets.UTF_8.name());
        email.setText(body,StandardCharsets.UTF_8.name());
        email.saveChanges();
        Transport.send(email); // provider acceptance; final delivery depends on mailbox/provider
    }
}
