package com.loginapp;

import javax.swing.*;
import java.awt.*;

/**
 * SecureAuth Pro - Enterprise Authentication System
 */
public class LoginApp {
    
    public static void main(String[] args) {
        // Enable anti-aliasing for smooth graphics
        System.setProperty("awt.useSystemAAFontSettings", "on");
        System.setProperty("swing.aatext", "true");
        
        // Create and show the login form on EDT
        SwingUtilities.invokeLater(() -> {
            try {
                new LoginForm().setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, 
                    "Error initializing application: " + e.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}