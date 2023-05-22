/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.*;

/**
 *
 * @author alest
 */
public class AdminRegistration extends JPanel{
    public JTextField tfJobTitle;
    public JTextField tfPosition;
    public JTextField tfInstitutionalEmail;
    
    public AdminRegistration(JPanel cardPanel, CardLayout cardLayout){
        JPanel adminRegPnl = adminRegPnl();
        
        JPanel adminRegLblPnl = adminRegLblPnl();
        adminRegPnl.add(adminRegLblPnl, BorderLayout.NORTH);
        
        JPanel createAdminPnl = createAdminPnl();
        adminRegPnl.add(createAdminPnl, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setBackground(Japps.getJPanelColor());
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFocusPainted(false);
        btnSubmit.setBackground(new Color(0xfcca00));
        btnSubmit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        btnSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection connection = null;
                try {
                    String url = "jdbc:mysql://localhost:3306/dbHelix";
                    String username = "root";
                    String password = "";

                    connection = DriverManager.getConnection(url, username, password);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle connection error
                    return;
                }

                // Prepare SQL statement
                String sql = "INSERT INTO `tbladmin` (jobTitle, position, institutionalEmail) VALUES(?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    // Bind input values to the prepared statement
                    statement.setString(1, tfJobTitle.getText());
                    statement.setString(2, tfPosition.getText());
                    statement.setString(3, tfInstitutionalEmail.getText());

                    // Execute the SQL statement
                    statement.executeUpdate();

                    // Close the statement and connection
                    statement.close();
                    connection.close();

                    // Provide feedback to the user (e.g., success message)
                    JOptionPane.showMessageDialog(panel, "Data inserted successfully!");

                    // Perform any additional actions or navigate to the next card in the CardLayout
                    cardLayout.show(cardPanel, "adminReg"); 
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle SQL error
                }
               
                
            }
        });
        
        panel.add(btnSubmit);
        
        adminRegPnl.add(panel, BorderLayout.SOUTH);
        
        this.setBackground(Japps.getJFrameColor());
        this.setLayout(new GridBagLayout()); 
        this.add(adminRegPnl, new GridBagConstraints());  
        
    }
    
    public JPanel adminRegPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(20,20,20,20);
        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
        javax.swing.border.Border border = BorderFactory.createCompoundBorder(line, padding);
        panel.setBackground(Japps.getJFrameColor());
        panel.setBorder(border);
        return panel;
    }
    
    public JPanel createAdminPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.setBackground(Japps.getJPanelColor());
        
        JLabel lblJobTitle = new JLabel("Job Title:");
        lblJobTitle.setForeground(Color.WHITE);
        panel.add(lblJobTitle);
        tfJobTitle = new PillTextField(20);
        panel.add(tfJobTitle);
        JLabel lblPosition = new JLabel("Position");
        lblPosition.setForeground(Color.WHITE);
        panel.add(lblPosition);
        tfPosition = new PillTextField(20);
        panel.add(tfPosition);
        JLabel lblInstitutionalEmail = new JLabel("Institutional Email:");
        lblInstitutionalEmail.setForeground(Color.WHITE);
        panel.add(lblInstitutionalEmail);
        tfInstitutionalEmail = new PillTextField(20);
        panel.add(tfInstitutionalEmail);
        
        return panel;
    }
    
    public JPanel adminRegLblPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());   
        panel.setBackground(Japps.getJPanelColor());
        JLabel lblRegistration = new JLabel("Admin Registration");
        lblRegistration.setForeground(Color.WHITE);
        Font font = lblRegistration.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), 15);
        lblRegistration.setFont(newFont);
        lblRegistration.setHorizontalAlignment(JLabel.CENTER);
        lblRegistration.setVerticalAlignment(JLabel.CENTER);
        panel.add(lblRegistration);
        
            
        return panel;
    }
}
