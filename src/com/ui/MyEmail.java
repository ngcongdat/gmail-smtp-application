/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ui;

import com.entity.SMTPServer;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author tiny
 */
public class MyEmail implements ActionListener {
    
    JLabel lFrom, lTo, lSubject, lServer, lUsername, lPassword, lMessage;
    JTextField tfFrom, tfTo, tfSubject, tfUsername;
    JComboBox<SMTPServer> cbServer;
    JPasswordField pfPassword;
    JTextArea taMessage;
    JPanel pnlTop;
    
    public void createAndShowGUI() {
        JFrame frame = new JFrame("Send E-Mail Client");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        addComponentsToPane(frame.getContentPane());
        
        frame.pack();
        frame.setVisible(true);
    }

    private void addComponentsToPane(Container frame) {
        lFrom = new JLabel("Hi");
        pnlTop = new JPanel();
        pnlTop.add(lFrom);
        frame.add(pnlTop);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
