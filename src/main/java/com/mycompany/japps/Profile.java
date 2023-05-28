/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;
import static com.mycompany.japps.Japps.cardLayout;
import static com.mycompany.japps.Japps.cardPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author alest
 */
public class Profile extends JPanel{
    private JButton editButton;
    private JButton settingsButton;
    private JTextArea displayArea;

    private String nameText;
    private String departmentText;
    private String programText;
    private String yearText;
    private String bloodText;
    private String emailText;
    private String contactNumberText;
    private String maritalStatusText;
    
    public Profile(JPanel cardPanel, CardLayout cardLayout) {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());
        
        
        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add( createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
       
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createTitlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel titleLabel = new JLabel("Profile");
        Font font = titleLabel.getFont();
        font = new Font(font.getName(), font.getStyle(), 35);
        titleLabel.setFont(font);
        panel.add(titleLabel);
        
        panel.setBackground(new Color(0xfcca00));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        
        return panel;     
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titlePnl = createTitlePnl();
        panel.add(titlePnl);
        
        panel.add(Box.createVerticalGlue()); 

        panel.add(profileDetPnl(cardPanel, cardLayout));
        
        
        
        
        return panel;
    }
    
    public JPanel profileDetPnl(JPanel cardPanel, CardLayout cardLayout){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
 
        int username;
        username = Username.getUsernameToken();
        
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 2));
        
       
        editButton = new JButton("Customize Profile");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showCustomizeDialog();
            }
        });
        
        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "settingsPnl");
            }
        });


        
        buttons.add(editButton);
        buttons.add(settingsButton);

        // TextArea setup
        displayArea = new JTextArea(10, 30);
        displayArea.setEditable(false);



        panel.add(displayArea, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void showCustomizeDialog() {
        JDialog dialog = new JDialog((JFrame) SwingUtilities.getWindowAncestor(this), "Customize Profile", true);
        dialog.setSize(300, 200);
        dialog.setLayout(new GridLayout(0, 1));

        JCheckBox nameCheckbox = new JCheckBox("Name", true);
        JCheckBox departmentCheckbox = new JCheckBox("Department", true);
        JCheckBox programCheckbox = new JCheckBox("Program", true);
        JCheckBox yearLevelCheckbox = new JCheckBox("Year Level", true);
        JCheckBox emailCheckbox = new JCheckBox("Email", true);
        JCheckBox contactNumberCheckbox = new JCheckBox("Contact Number", true);
        JCheckBox bloodTypeCheckbox = new JCheckBox("Blood Type", true);
        JCheckBox maritalStatusCheckbox = new JCheckBox("Marital Status", true);

        dialog.add(nameCheckbox);
        dialog.add(departmentCheckbox);
        dialog.add(programCheckbox);
        dialog.add(yearLevelCheckbox);
        dialog.add(emailCheckbox);
        dialog.add(contactNumberCheckbox);
        dialog.add(bloodTypeCheckbox);
        dialog.add(maritalStatusCheckbox);
        
        fetchData();


        JButton applyButton = new JButton("Apply");
        applyButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                updateDisplay(nameCheckbox.isSelected(), departmentCheckbox.isSelected(),
                        programCheckbox.isSelected(), yearLevelCheckbox.isSelected(),
                        emailCheckbox.isSelected(), contactNumberCheckbox.isSelected(),
                        bloodTypeCheckbox.isSelected(), maritalStatusCheckbox.isSelected());
                dialog.dispose();
            }
        });

        dialog.add(applyButton);
        dialog.setVisible(true);
    }
    
    private void updateDisplay(boolean showName, boolean showDepartment, boolean showProgram,
                               boolean showYearLevel, boolean showEmail, boolean showContactNumber,
                               boolean showBloodType, boolean showMaritalStatus) {
        StringBuilder displayText = new StringBuilder();

        if (showName) {
            displayText.append("Last Name: ").append(nameText).append("\n");
        }
        if (showDepartment) {
            displayText.append("Department: ").append(departmentText).append("\n");
        }
        if (showProgram) {
            displayText.append("Program: ").append(programText).append("\n");
        }
        if (showYearLevel) {
            displayText.append("Year Level: ").append(yearText).append("\n");
        }
        if (showEmail) {
            displayText.append("Email: ").append(emailText).append("\n");
        }
        if (showContactNumber) {
            displayText.append("Contact Number: ").append(contactNumberText).append("\n");
        }
        if (showBloodType) {
            displayText.append("Blood Type: ").append(bloodText).append("\n");
        }
        if (showMaritalStatus) {
            displayText.append("Marital Status: ").append(maritalStatusText).append("\n");
        }

        displayArea.setText(displayText.toString());
    }
    
    public void fetchData() {
        try {
            // Establish a database connection
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            System.out.println("cxvdsf"+Username.getUsernameToken());
            // Create a statement
            PreparedStatement statement = connection.prepareStatement("SELECT lastName, department, program,yearLevel, bloodType,email, contactNumber, maritalStatus FROM tblsttudent as s, tblregister as r, tbluser as u WHERE r.register_id = s.register_id AND s.studentID = u.username AND  u.username = ?");
            statement.setInt(1, Username.getUsernameToken());

            // Execute a query to fetch the data
            ResultSet resultSet = statement.executeQuery();

            // Check if there is a result
            if (resultSet.next()) {
                // Retrieve the values from the result set
                nameText = resultSet.getString("lastName");
                departmentText = resultSet.getString("department");
                programText = resultSet.getString("program");
                yearText = resultSet.getString("yearLevel");
                bloodText = resultSet.getString("bloodType");
                emailText = resultSet.getString("email");
                contactNumberText = resultSet.getString("contactNumber");
                maritalStatusText = resultSet.getString("maritalStatus");
            }

            // Close the resources
            resultSet.close();
            statement.close();
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }





    
}
