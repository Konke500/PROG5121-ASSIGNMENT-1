package com.mycompany.mainpage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPage extends JFrame {
    
    public MainPage() {
        setTitle("PROG5121 Assignment - Student Portal");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        
        // Create main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        mainPanel.setBackground(new Color(240, 240, 240));
        
        // Header
        JLabel headerLabel = new JLabel("The IIE - Student Portal", JLabel.CENTER);
        headerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        headerLabel.setForeground(new Color(0, 82, 136));
        headerLabel.setBorder(BorderFactory.createEmptyBorder(30, 0, 50, 0));
        mainPanel.add(headerLabel, BorderLayout.NORTH);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(50, 150, 50, 150));
        buttonPanel.setBackground(new Color(240, 240, 240));
        
        JButton registerButton = new JButton("Register New Account");
        styleButton(registerButton, new Color(0, 120, 215));
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainPage.this, 
                    "Registration feature would open here.\n\n" +
                    "Requirements:\n" +
                    "- Username must contain underscore and be ≤5 characters\n" +
                    "- Password must have 8+ chars, uppercase, number, and special character\n" +
                    "- Phone must be a valid SA number with +27 prefix", 
                    "Registration Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton loginButton = new JButton("Login");
        styleButton(loginButton, new Color(0, 153, 76));
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(MainPage.this, 
                    "Login feature would open here.", 
                    "Login Info", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        
        JButton exitButton = new JButton("Exit");
        styleButton(exitButton, new Color(204, 0, 0));
        exitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        buttonPanel.add(registerButton);
        buttonPanel.add(loginButton);
        buttonPanel.add(exitButton);
        
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        
        // Footer
        JLabel footerLabel = new JLabel("PROG5121 Assignment - Registration and Login System", JLabel.CENTER);
        footerLabel.setFont(new Font("Arial", Font.ITALIC, 12));
        footerLabel.setForeground(Color.GRAY);
        footerLabel.setBorder(BorderFactory.createEmptyBorder(20, 0, 0, 0));
        mainPanel.add(footerLabel, BorderLayout.SOUTH);
        
        add(mainPanel);
    }
    
    private void styleButton(JButton button, Color color) {
        button.setFont(new Font("Arial", Font.BOLD, 16));
        button.setBackground(color);
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
    }
    
    public static void main(String[] args) {
        // Set look and feel to system default for better appearance
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show the GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new MainPage().setVisible(true);
            }
        });
    }
}