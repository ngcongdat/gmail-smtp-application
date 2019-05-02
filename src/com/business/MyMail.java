/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.business;

import com.entity.MailMessage;
import com.entity.SMTPServer;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author tiny
 */
public class MyMail {

    public MyMail() {

    }

    public Session getMailSession(SMTPServer mailServer, String from, String password) {
        Properties props = new Properties();
        props.put("mail.smtp.host", mailServer.getServer());
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.socketFactory.port", mailServer.getPort());
        props.put("mail.smtp.auth", "true");

        // Get the Session Object
        Session session = Session.getDefaultInstance(props,
                new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password); //vpgwmvfbtolyrslr
            }
        });
        return session;

    }

    public boolean sendMail(MailMessage mm, Session session, String filePath) throws Exception {
        // Create a default MimeMessenge object
        Message message = new MimeMessage(session);

        // Set From: header field of the header.
        message.setFrom(new InternetAddress(mm.getFrom()));

        // Set To: header field of the header.
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(mm.getTo()));

        // Set Subject: header field
        message.setSubject(mm.getSubject());

        // Creates message part
        MimeBodyPart messageBodyPart = new MimeBodyPart();
        messageBodyPart.setContent(mm.getMessage(), "text/html");

        // Creates multi-part
        Multipart multipart = new MimeMultipart();
        multipart.addBodyPart(messageBodyPart);

        // Adds attachments
        MimeBodyPart attachPart = new MimeBodyPart();
        attachPart.attachFile(filePath);
        multipart.addBodyPart(attachPart);

        // sets the multi-part as e-mail's content
        message.setContent(multipart);

        // Now set the actual message
//        message.setText(mm.getMessage());
        // Send message
        Transport.send(message);

        return true;
    }
}
