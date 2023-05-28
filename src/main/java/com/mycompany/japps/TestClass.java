package com.mycompany.japps;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestClass extends JFrame {

    public TestClass() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("Test Table");
        setSize(500, 400);

        // Create the table model
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Month");
        tableModel.addColumn("Day");
        tableModel.addColumn("Title");
        tableModel.addColumn("Status");

        // Create the table
        JTable table = new JTable(tableModel);

        // Set cell renderer for the "Status" column
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                if (value != null) {
                    int isSolved = (int) value;
                    if (isSolved == 1) {
                        setForeground(Color.GREEN);
                        setText("Solved");
                    } else if (isSolved == 0) {
                        setForeground(Color.ORANGE);
                        setText("Pending");
                    }
                }

                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        };
        table.getColumnModel().getColumn(4).setCellRenderer(cellRenderer);

        // Create the database connection and retrieve data
        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            Session.setSessionToken(4);
            int userID = Session.getSessionToken(); // Set the user ID here

            String query = "SELECT support_ID, support_Month, support_Day, support_Title, support_IsSolved FROM tblsupport WHERE user_ID = ?";

            PreparedStatement statement = conn.prepareStatement(query);
            statement.setInt(1, userID);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[5];
                rowData[0] = resultSet.getInt("support_ID");
                rowData[1] = resultSet.getString("support_Month");
                rowData[2] = resultSet.getInt("support_Day");
                rowData[3] = resultSet.getString("support_Title");
                rowData[4] = resultSet.getInt("support_IsSolved");
                tableModel.addRow(rowData);
            }

            // Set the table model again after populating data
            table.setModel(tableModel);

        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors
        }

        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);

        // Add the scroll pane to the frame's content pane
        getContentPane().add(scrollPane);

        setVisible(true);
    }
}

