/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entity;

/**
 *
 * @author tiny
 */
public class MailMessage {

    // Declare instance
    private String from, message, subject, to;

    // Contructors
    public MailMessage() {

    }

    public MailMessage(String from, String message, String subject, String to) {
        this.from = from;
        this.message = message;
        this.subject = subject;
        this.to = to;
    }

    // Setter - Getter
    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

}
