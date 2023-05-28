package com.mycompany.japps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AdminSupportUpdate extends JPanel {
    private JTextField idField;
    private JCheckBox resolvedCheckBox;
    private JCheckBox unresolvedCheckBox;

    public AdminSupportUpdate(JPanel cardPanel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());

        this.add(new AdminTopPanelButton(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        this.add(createBottomPnl(cardPanel, cardLayout), BorderLayout.SOUTH);

        this.setSize(Japps.getGUIWidth(), Japps.getGUIHeight());
        this.setVisible(true);
    }

    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        JPanel oldPanel = new JPanel();
        oldPanel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.WEST; 

        JPanel idPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel idLabel = new JLabel("Support ID:");
        idField = new JTextField(10);
        idPanel.add(idLabel);
        idPanel.add(idField);

        resolvedCheckBox = new JCheckBox("Mark as Resolved");
        unresolvedCheckBox = new JCheckBox("Mark as Unresolved");

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 2;
        constraints.insets = new Insets(0, 0, 10, 0); 
        oldPanel.add(idPanel, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.insets = new Insets(0, 0, 0, 0); 
        oldPanel.add(resolvedCheckBox, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        oldPanel.add(unresolvedCheckBox, constraints);

        panel.add(oldPanel, BorderLayout.CENTER);

        return panel;
        }


    public JPanel createBottomPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0xfcca00)); 
        
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(0xfcca00)); 
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminsupportPnl");
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSupportStatus();
                cardLayout.show(cardPanel, "adminsupportPnl");
            }
        });

        panel.add(backButton);
        panel.add(updateButton);

        return panel;
    }

    private void updateSupportStatus() {
        String idText = idField.getText();
        int supportID;

        try {
            supportID = Integer.parseInt(idText);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid Support ID. Please enter a valid integer value.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        boolean isResolved = resolvedCheckBox.isSelected();
        boolean isUnresolved = unresolvedCheckBox.isSelected();

        if (isResolved && isUnresolved) {
            JOptionPane.showMessageDialog(this, "Please select only one checkbox.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        int supportIsSolved = -1; 

        if (isResolved) {
            supportIsSolved = 1; 
        } else if (isUnresolved) {
            supportIsSolved = 0; 
        }

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "UPDATE tblsupport SET support_IsSolved = ? WHERE support_ID = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, supportIsSolved);
            statement.setInt(2, supportID);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
