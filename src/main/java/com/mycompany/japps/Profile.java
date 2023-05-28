/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

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
    private JLabel nameLabel;
    private JLabel departmentLabel;
    private JLabel programLabel;
    private JLabel yearLabel;
    private JLabel photoLabel;
    private JButton uploadButton;
    private JLabel bloodType;
    private JButton editButton;
    private JButton settingsButton;
    
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
        nameLabel = new JLabel("Name: John Doe");
        departmentLabel = new JLabel("Department: Computer Science");
        programLabel = new JLabel("Program: Bachelor of Science in Computer Science");
        yearLabel = new JLabel("Year: 3rd Year");
        bloodType = new JLabel("Blood Type: O+");
        String username = "";
        username = Username.getUsernameToken();

        // Create label for photo
        photoLabel = new JLabel("No Photo Available", SwingConstants.CENTER);
        photoLabel.setPreferredSize(new Dimension(200, 200));
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Save the username to the database
                try {
                    // Establish a connection to the database
                    Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");

                    
                    // Check if the username already exists in the database
                    String searchQuery = "SELECT * FROM tblprofile WHERE username = ?";
                    PreparedStatement searchStmt = conn.prepareStatement(searchQuery);
                    searchStmt.setString(1, username);
                    
                    ResultSet resultSet = searchStmt.executeQuery();

                    if (resultSet.next()) {
                        // The username already exists in the database
                        System.out.println("Username already exists");

                        // Retrieve the photo path from the result set
                        String photoPath = resultSet.getString("photo_path");
                        if (photoPath != null && !photoPath.isEmpty()) {
                            ImageIcon imageIcon = new ImageIcon(photoPath);
                            photoLabel.setIcon(imageIcon);
                            System.out.println("Success");
                        }
                    } else {
                        // Prepare the SQL statement to insert the username
                        String insertQuery = "INSERT INTO tblprofile (username) VALUES (?)";
                        PreparedStatement insertStmt = conn.prepareStatement(insertQuery);

                        // Set the username value
                        insertStmt.setString(1, Username.getUsernameToken());

                        // Execute the INSERT statement
                        insertStmt.executeUpdate();

                        System.out.println("Username added successfully");
                    }

                    // Close the result set, statements, and connection
                    resultSet.close();
                    searchStmt.close();
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                
                // Add components to the frame
        panel.add(photoLabel, BorderLayout.WEST);

                
        JPanel buttons = new JPanel();
        buttons.setLayout(new GridLayout(1, 3));
        // Create upload button
        uploadButton = new JButton("Upload Photo");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(Profile.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();

                    // Update the code below to handle photo upload and storage in your database
                    // Update the code below to handle photo upload and storage in your database
                    String username = Username.getUsernameToken(); // Replace with the actual username

                    if (username != null && !username.isEmpty()) {
                        try {
                            // Establish a connection to the database
                            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");

                            // Prepare the UPDATE statement
                            String query = "UPDATE tblprofile SET photo_path = ? WHERE username = ?";
                            PreparedStatement statement = connection.prepareStatement(query);
                            statement.setString(1, filePath);
                            statement.setString(2, username);

                            // Execute the UPDATE statement
                            int rowsUpdated = statement.executeUpdate();
                            if (rowsUpdated > 0) {
                                System.out.println("Photo path updated successfully.");
                            } else {
                                System.out.println("Failed to update photo path.");
                            }

                            // Close the statement and connection
                            statement.close();
                            connection.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }

                        ImageIcon imageIcon = new ImageIcon(filePath);
                        photoLabel.setIcon(imageIcon);
                    } else {
                        System.out.println("Invalid username.");
                    }

                }}

        });
       
        editButton = new JButton("Customize Profile");
        editButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                
                // Show the checkboxes
                String[] options = {"Name", "Department", "Program", "Year Level", "Email", "Contact Number", "Blood Type", "Marital Status"};

                // Create an array of JCheckBox components
                JCheckBox[] checkBoxes = new JCheckBox[options.length];
                for (int i = 0; i < options.length; i++) {
                    checkBoxes[i] = new JCheckBox(options[i]);
                }

                // Create a panel to hold the checkboxes
                JPanel checkBoxPanel = new JPanel(new GridLayout(0, 1));
                for (JCheckBox checkBox : checkBoxes) {
                    checkBoxPanel.add(checkBox);
                }

                // Retrieve the checkbox values from the database and set initial selection
                Map<String, Boolean> optionMap = retrieveCheckboxValuesFromDatabase();
                for (JCheckBox checkBox : checkBoxes) {
                    boolean isSelected = optionMap.getOrDefault(checkBox.getText(), false);
                    checkBox.setSelected(isSelected);
                }

                // Show the dialog with checkboxes
                int result = JOptionPane.showConfirmDialog(null, checkBoxPanel, "Customize Profile", JOptionPane.OK_CANCEL_OPTION);
                if (result == JOptionPane.OK_OPTION) {
                    // Process the selected checkboxes
                    StringBuilder selectedOptions = new StringBuilder();
                    optionMap.clear(); // Clear the previous values

                    for (JCheckBox checkBox : checkBoxes) {
                        boolean isSelected = checkBox.isSelected();
                        optionMap.put(checkBox.getText(), isSelected);
                        if (isSelected) {
                            selectedOptions.append(checkBox.getText()).append("\n");
                        }
                    }

                    // Display the selected options
                    JOptionPane.showMessageDialog(null, "Selected options:\n" + selectedOptions.toString());

                    // Save username and selected options to the database
                    try {
                        // Establish a connection to the database
                        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");

                        // Prepare the SQL statement
                        String sql = "INSERT INTO tblprofile (Name, Department, Program, YearLevel, Email, ContactNumber, BloodType, MaritalStatus) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
                        PreparedStatement stmt = conn.prepareStatement(sql);

                        // Set the values for each column
                        stmt.setString(1, optionMap.getOrDefault("Name", false) ? "Selected" : "Not Selected");
                        stmt.setString(2, optionMap.getOrDefault("Department", false) ? "Selected" : "Not Selected");
                        stmt.setString(3, optionMap.getOrDefault("Program", false) ? "Selected" : "Not Selected");
                        stmt.setString(4, optionMap.getOrDefault("Year Level", false) ? "Selected" : "Not Selected");
                        stmt.setString(5, optionMap.getOrDefault("Email", false) ? "Selected" : "Not Selected");
                        stmt.setString(6, optionMap.getOrDefault("Contact Number", false) ? "Selected" : "Not Selected");
                        stmt.setString(7, optionMap.getOrDefault("Blood Type", false) ? "Selected" : "Not Selected");
                        stmt.setString(8, optionMap.getOrDefault("Marital Status", false) ? "Selected" : "Not Selected");

                        // Execute the INSERT statement
                        stmt.executeUpdate();

                        // Close the statement and connection
                        stmt.close();
                        conn.close();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        
        settingsButton = new JButton("Settings");
        settingsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "settingsPnl");
            }
        });


        
        buttons.add(uploadButton);
        buttons.add(editButton);
        buttons.add(settingsButton);

        
        

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5, 1));
        detailsPanel.add(nameLabel);
        detailsPanel.add(departmentLabel);
        detailsPanel.add(programLabel);
        detailsPanel.add(yearLabel);
        detailsPanel.add(bloodType);

        panel.add(detailsPanel, BorderLayout.CENTER);
        panel.add(buttons, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private Map<String, Boolean> retrieveCheckboxValuesFromDatabase() {
        Map<String, Boolean> optionMap = new HashMap<>();

        try {
            // Establish a connection to the database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");

            // Prepare the SQL statement
            String sql = "SELECT * FROM tblprofile WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, Username.getUsernameToken()); // Replace getUsername() with the method to retrieve the username

            // Execute the SELECT query
            ResultSet resultSet = stmt.executeQuery();

            // Process the result set
            if (resultSet.next()) {
                optionMap.put("Name", "Selected".equals(resultSet.getString("Name")));
                optionMap.put("Department", "Selected".equals(resultSet.getString("Department")));
                optionMap.put("Program", "Selected".equals(resultSet.getString("Program")));
                optionMap.put("Year Level", "Selected".equals(resultSet.getString("YearLevel")));
                optionMap.put("Email", "Selected".equals(resultSet.getString("Email")));
                optionMap.put("Contact Number", "Selected".equals(resultSet.getString("ContactNumber")));
                optionMap.put("Blood Type", "Selected".equals(resultSet.getString("BloodType")));
                optionMap.put("Marital Status", "Selected".equals(resultSet.getString("MaritalStatus")));
            }

            // Close the result set, statement, and connection
            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return optionMap;
    }




    
}
