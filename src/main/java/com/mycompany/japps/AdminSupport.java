
package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class AdminSupport extends JPanel {
    private DefaultTableModel tableModel;
    private JTable table;

    public AdminSupport(JPanel cardPanel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());

        this.add(new AdminTopPanelButton(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        this.add(createBottomPnl(cardPanel, cardLayout), BorderLayout.SOUTH);

        this.setSize(Japps.getGUIWidth(), Japps.getGUIHeight());
        this.setVisible(true);
    }

    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();

        tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Month");
        tableModel.addColumn("Day");
        tableModel.addColumn("Time");
        tableModel.addColumn("Title");
        tableModel.addColumn("Description");
        tableModel.addColumn("Status");

        table = new JTable(tableModel);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        };
        table.getColumnModel().getColumn(6).setCellRenderer(cellRenderer);

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "SELECT support_ID, support_Month, support_Day, support_Time, support_Title, support_Description, support_IsSolved FROM tblsupport";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[7];
                rowData[0] = resultSet.getInt("support_ID");
                rowData[1] = resultSet.getString("support_Month");
                rowData[2] = resultSet.getInt("support_Day");
                rowData[3] = resultSet.getTime("support_Time");
                rowData[4] = resultSet.getString("support_Title");
                rowData[5] = resultSet.getString("support_Description");
                int isSolved = resultSet.getInt("support_IsSolved");
                rowData[6] = (isSolved == 0) ? "Pending" : "Resolved";

                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

 
        DefaultTableCellRenderer statusCellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                setHorizontalAlignment(SwingConstants.CENTER);
                setText(value.toString());

                if (value.toString().equals("Pending")) {
                    setForeground(Color.ORANGE);
                } else if (value.toString().equals("Resolved")) {
                    setForeground(Color.GREEN);
                }

                return this;
            }
        };
        table.getColumnModel().getColumn(6).setCellRenderer(statusCellRenderer);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        table.getColumnModel().getColumn(2).setPreferredWidth(50);
        table.getColumnModel().getColumn(3).setPreferredWidth(80);
        table.getColumnModel().getColumn(4).setPreferredWidth(150);
        table.getColumnModel().getColumn(5).setPreferredWidth(200);
        table.getColumnModel().getColumn(6).setPreferredWidth(80);

        JScrollPane scrollPane = new JScrollPane(table);
        panel.add(scrollPane);

        return panel;
    }

    public JPanel createBottomPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        
        JButton updateButton = new JButton("Update");
        updateButton.setBackground(new Color(0xfcca00)); 
        
        JButton deleteButton = new JButton("Delete");
        deleteButton.setBackground(new Color(0xfcca00)); 
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminsupportupdatePnl");
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLatestEntry();
                refreshTable();
            }
        });

        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBackground(new Color(0xfcca00)); 
        
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        
        
        
        panel.add(updateButton);
        panel.add(deleteButton);
        panel.add(refreshButton);

        return panel;
    }

    private void refreshTable() {
        tableModel.setRowCount(0); 

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "SELECT support_ID, support_Month, support_Day, support_Time, support_Title, support_Description, support_IsSolved FROM tblsupport";
            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[7];
                rowData[0] = resultSet.getInt("support_ID");
                rowData[1] = resultSet.getString("support_Month");
                rowData[2] = resultSet.getInt("support_Day");
                rowData[3] = resultSet.getTime("support_Time");
                rowData[4] = resultSet.getString("support_Title");
                rowData[5] = resultSet.getString("support_Description");
                int isSolved = resultSet.getInt("support_IsSolved");
                rowData[6] = (isSolved == 0) ? "Pending" : "Resolved";

                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void deleteLatestEntry() {
    String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
    String dbUsername = "root";
    String dbPassword = "";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
        String deleteQuery = "DELETE FROM tblsupport WHERE support_ID = (SELECT MAX(support_ID) FROM tblsupport)";
        PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
        deleteStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}
