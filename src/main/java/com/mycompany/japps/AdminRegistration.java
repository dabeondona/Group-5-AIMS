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

public class AdminRegistration extends JPanel {
    private JTextField tfJobTitle;
    private JTextField tfPosition;
    private JTextField tfInstitutionalEmail;
    private Connection connection;

    public AdminRegistration(JPanel cardPanel, CardLayout cardLayout) {
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

        btnSubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String registerId = String.format("%d", retrieveRegisterIds());
                String lastName = retrieveLastName();
                String adminId = retrieveAdminId();

                try {
                    String url = "jdbc:mysql://localhost:3306/dbHelix";
                    String username = "root";
                    String password = "";

                    connection = DriverManager.getConnection(url, username, password);

                    // Prepare SQL statement
                    String sql = "INSERT INTO tbladmin (jobTitle, position, institutionalEmail, register_id) VALUES (?, ?, ?, ?)";

                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Bind input values to the prepared statement
                        statement.setString(1, tfJobTitle.getText());
                        statement.setString(2, tfPosition.getText());
                        statement.setString(3, tfInstitutionalEmail.getText());
                        statement.setString(4, registerId);

                        // Execute the SQL statement
                        statement.executeUpdate();

                        // Provide feedback to the user (e.g., success message)
                        JOptionPane.showMessageDialog(panel, "Data inserted successfully!");

                        insertIntoTblUser(lastName, adminId);

                        // Perform any additional actions or navigate to the next card in the CardLayout
                        cardLayout.show(cardPanel, "login");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    // Handle SQL error
                } finally {
                    try {
                        if (connection != null) {
                            connection.close();
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Handle connection closing error
                    }
                }
            }
        });

        panel.add(btnSubmit);

        adminRegPnl.add(panel, BorderLayout.SOUTH);

        this.setBackground(Japps.getJFrameColor());
        this.setLayout(new GridBagLayout());
        this.add(adminRegPnl, new GridBagConstraints());
    }

    AdminRegistration() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    private void insertIntoTblUser(String lastName, String adminId) {
        try {
            String url = "jdbc:mysql://localhost:3306/dbHelix";
            String username = "root";
            String password = "";

            Connection connection = DriverManager.getConnection(url, username, password);

            String sql = "INSERT INTO tbluser (password, username) VALUES (?, ?)";

            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, lastName);
                statement.setString(2, adminId);

                statement.executeUpdate();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        }
    }

    public JPanel adminRegPnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(20, 20, 20, 20);
        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
        javax.swing.border.Border border = BorderFactory.createCompoundBorder(line, padding);
        panel.setBackground(Japps.getJFrameColor());
        panel.setBorder(border);
        return panel;
    }

    public JPanel createAdminPnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(6, 1));
        panel.setBackground(Japps.getJPanelColor());

        JLabel lblJobTitle = new JLabel("Job Title:");
        lblJobTitle.setForeground(Color.WHITE);
        panel.add(lblJobTitle);
        tfJobTitle = new JTextField(20);
        panel.add(tfJobTitle);
        JLabel lblPosition = new JLabel("Position");
        lblPosition.setForeground(Color.WHITE);
        panel.add(lblPosition);
        tfPosition = new JTextField(20);
        panel.add(tfPosition);
        JLabel lblInstitutionalEmail = new JLabel("Institutional Email:");
        lblInstitutionalEmail.setForeground(Color.WHITE);
        panel.add(lblInstitutionalEmail);
        tfInstitutionalEmail = new JTextField(20);
        panel.add(tfInstitutionalEmail);

        return panel;
    }

    public JPanel adminRegLblPnl() {
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

    public int retrieveRegisterIds() {
        int regId = 0;

        try {
            String url = "jdbc:mysql://localhost:3306/dbhelix";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            // Create the SQL query
            String sql = "SELECT register_id FROM tblregister";

            // Create a statement object
            try (Statement statement = connection.createStatement()) {
                // Execute the query
                ResultSet resultSet = statement.executeQuery(sql);

                // Process the result set
                while (resultSet.next()) {
                    regId = resultSet.getInt("register_id");
                    // Do something with the registerId value
                }

                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle connection closing error
            }
        }
        return regId;
    }

    public String retrieveLastName() {
        String lastName = "";

        try {
            String url = "jdbc:mysql://localhost:3306/dbHelix";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT lastName FROM tblregister ORDER BY register_id DESC LIMIT 1";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    lastName = resultSet.getString("lastName");
                }

                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle connection closing error
            }
        }

        System.out.println(lastName);

        return lastName;
    }

    public String retrieveAdminId() {
        String adminId = "";

        try {
            String url = "jdbc:mysql://localhost:3306/dbHelix";
            String username = "root";
            String password = "";

            connection = DriverManager.getConnection(url, username, password);

            String sql = "SELECT adminID FROM tbladmin ORDER BY adminID DESC LIMIT 1";

            try (Statement statement = connection.createStatement()) {
                ResultSet resultSet = statement.executeQuery(sql);

                if (resultSet.next()) {
                    adminId = resultSet.getString("adminId");
                }

                resultSet.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            // Handle SQL error
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
                // Handle connection closing error
            }
        }

        System.out.println(adminId);

        int parNum = Integer.valueOf(adminId) + 1;
        String id = String.format("%d", parNum);

        return id;
    }
}
