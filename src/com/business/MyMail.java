/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import com.entity.MailMessage;
import com.entity.SMTPServer;
import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author tiny
 */
public class MyMail {

    public Session getMailSession(SMTPServer mailServer, String from, String password) {

        Properties props = new Properties();
        props.put("mail.smtp.host", mailServer.getServer());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", mailServer.getPort());
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");

        // Get the Session Object
        Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        });
        return session;

    }

    public boolean sendMail(MailMessage mm, Session session) throws Exception {
        // Create a default MimeMessenge object
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(mm.getFrom()));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mm.getTo()));

        // Set Subject: header field
        message.setSubject(mm.getSubject());

        // Now set the actual message
        message.setText(mm.getMessage());

        // Send message
        Transport.send(message);

        return true;
    }
}
