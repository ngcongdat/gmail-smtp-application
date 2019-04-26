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
public class SMTPServer {

    // Declare instance
    private String authentication, port, server;

    // Contructors
    public SMTPServer() {

    }

    public SMTPServer(String authentication, String port, String server) {
        this.authentication = authentication;
        this.port = port;
        this.server = server;
    }

    // Setter - Getter
    public String getAuthentication() {
        return authentication;
    }

    public void setAuthentication(String authentication) {
        this.authentication = authentication;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

}
