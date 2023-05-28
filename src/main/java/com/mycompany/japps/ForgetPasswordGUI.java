package com.mycompany.japps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class ForgetPasswordGUI extends JPanel {

    private JTextField emailTextField;
    private JTextField phoneTextField;

    public ForgetPasswordGUI(JPanel cardPanel, CardLayout cardLayout) {

        setSize(400, 300);

        // 3 components
        JLabel titleLabel = new JLabel("Reset Your Password");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);
        JLabel emailLabel = new JLabel("Username:");
        emailTextField = new JTextField(20);
        JLabel phoneLabel = new JLabel("Email:");
        phoneTextField = new JTextField(20);
        JButton searchButton = new JButton("Search");
        JButton cancelButton = new JButton("Cancel");

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "login");
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String inputUsername = emailTextField.getText().trim();
                String inputEmail = phoneTextField.getText().trim();

                // Connect to the database
                try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "")) {
                    // Create a statement
                    PreparedStatement statement = connection.prepareStatement("SELECT email FROM tblsttudent as s, tblregister as r, tbluser as u WHERE r.register_id = s.register_id AND s.studentID = u.username AND  u.username = ?");
                    statement.setString(1,inputUsername);

                    // Execute the query
                    ResultSet resultSet = statement.executeQuery();

                    // Check if the username exists in the database
                    if (resultSet.next()) {
                        String fetchedEmail = resultSet.getString("email");

                        // Compare the fetched data with the inputted values
                        if (inputEmail.equals(fetchedEmail)) {
                            JOptionPane.showMessageDialog(null, "Email and phone matched!");
                            //cardLayout.show(cardPanel, )
                        } else {
                            JOptionPane.showMessageDialog(null, "Email and phone do not match!");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Username not found!");
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Error occurred while connecting to the database.");
                }
            }
        });

        // panel sa components
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        panel.setBackground(Color.decode("#a83332"));

        // para layout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.insets = new Insets(10, 0, 20, 0);
        panel.add(titleLabel, gbc);
        gbc.gridy++;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(emailLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        panel.add(emailTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.anchor = GridBagConstraints.LINE_END;
        gbc.insets = new Insets(0, 0, 10, 10);
        panel.add(phoneLabel, gbc);
        gbc.gridx++;
        gbc.anchor = GridBagConstraints.LINE_START;
        gbc.insets = new Insets(0, 0, 10, 0);
        panel.add(phoneTextField, gbc);
        gbc.gridx = 0;
        gbc.gridy++;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.insets = new Insets(20, 0, 0, 0);
        panel.add(searchButton, gbc);
        gbc.gridy++;
        gbc.insets = new Insets(10, 0, 0, 0);
        panel.add(cancelButton, gbc);

        // maroon box panel
        JPanel boxPanel = new JPanel();
        boxPanel.setLayout(new BorderLayout());
        boxPanel.setBackground(Color.decode("#fcca00"));
        int padding = 10;
        boxPanel.setBorder(BorderFactory.createEmptyBorder(padding, padding, padding, padding));
        boxPanel.add(panel, BorderLayout.CENTER);

        // frame bg color
        this.setBackground(Color.decode("#8c383e"));

        // Add the box panel to the frame
        this.setLayout(new BorderLayout());
        this.add(boxPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }
}


