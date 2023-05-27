/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import javax.swing.*;

public class StudentRegistration extends JPanel{
    JComboBox cbbDepartment;
    JComboBox cbbProgram;
    JComboBox cbbYearLevel;
    Connection connection;
    
    public StudentRegistration(JPanel cardPanel, CardLayout cardLayout){
        JPanel studentRegPnl = studentRegPnl();
        
        JPanel studentRegLblPnl = studentRegLblPnl();
        studentRegPnl.add(studentRegLblPnl, BorderLayout.NORTH);
        
        JPanel createStudPnl = createStudPnl();
        studentRegPnl.add(createStudPnl, BorderLayout.CENTER);
        
        JPanel panel = new JPanel();
        panel.setBackground(Japps.getJPanelColor());
        
        JButton btnSubmit = new JButton("Submit");
        btnSubmit.setFocusPainted(false);
        btnSubmit.setBackground(new Color(0xfcca00));
        btnSubmit.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        btnSubmit.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String register_id = String.format("%d", retrieveRegisterIds());

                // Retrieve the last name from the tblregister table
                String lastName = retrieveLastName();
                String studentId = retrieveStudentId();


                
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
                String sql = "INSERT INTO `tblsttudent` (department, program, yearLevel, register_id) VALUES(?, ?, ?, ?)";

                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    // Bind input values to the prepared statement
                    statement.setString(1, cbbDepartment.getSelectedItem().toString());
                    statement.setString(2, cbbProgram.getSelectedItem().toString());
                    statement.setString(3, cbbYearLevel.getSelectedItem().toString());
                    statement.setString(4, register_id);

                    // Execute the SQL statement
                    statement.executeUpdate();

                    // Close the statement and connection
                    statement.close();
                    connection.close();

                    // Provide feedback to the user (e.g., success message)
                    JOptionPane.showMessageDialog(panel, "Data inserted successfully!");

                    // Insert the last name and student ID into tbluser
                    insertIntoTblUser(lastName, studentId);

                    // Perform any additional actions or navigate to the next card in the CardLayout
                    cardLayout.show(cardPanel, "login");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle SQL error
                }
            }
        });
        
        panel.add(btnSubmit);
        
        studentRegPnl.add(panel, BorderLayout.SOUTH);
        
        this.setBackground(Japps.getJFrameColor());
        this.setLayout(new GridBagLayout()); 
        this.add(studentRegPnl, new GridBagConstraints());  
    }
    
    private void insertIntoTblUser(String lastName, String studentId) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbHelix", "root", "");

            String sql = "INSERT INTO `tbluser` (password, username) VALUES (?, ?)";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, lastName);
            statement.setString(2, studentId);

            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        }
    }
    
    public JPanel createStudPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6,1));
        panel.setBackground(Japps.getJPanelColor());
        
        JLabel lblDepartment = new JLabel("Department:");
        lblDepartment.setForeground(Color.WHITE);
        panel.add(lblDepartment);
        cbbDepartment = new JComboBox(strDepartment());
        panel.add(cbbDepartment);
        JLabel lblProgram = new JLabel("Program:");
        lblProgram.setForeground(Color.WHITE);
        panel.add(lblProgram);
        cbbProgram = new JComboBox(strProgram());
        panel.add(cbbProgram);
        JLabel lblYearLevel = new JLabel("Year Level:");
        lblYearLevel.setForeground(Color.WHITE);
        panel.add(lblYearLevel);
        cbbYearLevel = new JComboBox(strYearLevel());
        panel.add(cbbYearLevel);
        
        
        return panel;
    }
    
    public JPanel studentRegPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(20,20,20,20);
        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
        javax.swing.border.Border border = BorderFactory.createCompoundBorder(line, padding);
        panel.setBackground(Japps.getJFrameColor());
        panel.setBorder(border);
        return panel;
    }
    
    public JPanel studentRegLblPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());   
        panel.setBackground(Japps.getJPanelColor());
        JLabel lblRegistration = new JLabel("Student Registration");
        lblRegistration.setForeground(Color.WHITE);
        Font font = lblRegistration.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), 15);
        lblRegistration.setFont(newFont);
        lblRegistration.setHorizontalAlignment(JLabel.CENTER);
        lblRegistration.setVerticalAlignment(JLabel.CENTER);
        panel.add(lblRegistration);
        
            
        return panel;
    }
    
    public String[] strDepartment(){
        String[] department = {
            "",
            "College of Computer Studies"
        };
        return department;
    }
    
    public String[] strProgram(){
        String[] program = {
            "",
            "Bachelor of Science in Information Technology",
            "Bachelor of Science in Computer Science"
        };
        return program;
    }
    
    public String[] strYearLevel(){
        String[] yearLevel = {
            "",
            "First Year",
            "Second Year",
            "Third Year",
            "Fourth Year"
        };
        return yearLevel;
    }
    
    public int retrieveRegisterIds() {
        int reg_id=0;
        
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            // Create the SQL query
            String sql = "SELECT register_id FROM tblregister";

            // Create a statement object
            Statement statement = connection.createStatement();

            // Execute the query
            ResultSet resultSet = statement.executeQuery(sql);

            // Process the result set
            while (resultSet.next()) {
                reg_id = resultSet.getInt("register_id");

                // Do something with the registerId value

                
            }

            // Close the statement and result set
            statement.close();
            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        }
        return reg_id;
    }
    
    public String retrieveLastName() {
        String lastName = "";

        try {
            String url = "jdbc:mysql://localhost:3306/dbHelix";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT lastName FROM tblregister ORDER BY register_id DESC LIMIT 1";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                lastName = resultSet.getString("lastName");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        }

        System.out.println(lastName);

        return lastName;
        }
    
    
    public String retrieveStudentId() {
        String studentId = "";

        try {
            String url = "jdbc:mysql://localhost:3306/dbHelix";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT studentID FROM tblsttudent ORDER BY studentID DESC LIMIT 1";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);

            if (resultSet.next()) {
                studentId = resultSet.getString("studentId");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        }

        System.out.println(studentId);

        int parNum = Integer.valueOf(studentId)+1;
        String id = String.format("%d", parNum);

        return id;
    }


    
    
}
