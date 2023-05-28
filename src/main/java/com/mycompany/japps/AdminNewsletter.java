
package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import javax.swing.border.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;


public class AdminNewsletter extends JPanel {

    private DefaultTableModel tableModel;
    private JTable table;

    public AdminNewsletter(JPanel cardPanel, CardLayout cardLayout) {
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
        tableModel.addColumn("Title");

        table = new JTable(tableModel);

        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

                setHorizontalAlignment(SwingConstants.CENTER);
                return this;
            }
        };
        table.getColumnModel().getColumn(3).setCellRenderer(cellRenderer);

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {

            String query = "SELECT news_ID, news_Month, news_Day, news_DayInt, news_Title FROM tblnewsletter";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[4];
                rowData[0] = resultSet.getInt("news_ID");
                rowData[1] = resultSet.getString("news_Month");
                rowData[2] = resultSet.getInt("news_DayInt") + "    -    " + resultSet.getString("news_Day");
                rowData[3] = resultSet.getString("news_Title");
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane);

        return panel;
    }

    public JPanel createBottomPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();

        JButton createButton = new JButton("Insert");
        JButton updateButton = new JButton("Update");
        JButton deleteButton = new JButton("Delete");

        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminnewsletterinsertPnl");
            }
        });
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminsnewsletterupdatePnl");
            }
        });
        
        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteLatestEntry();
                refreshTable();
            }
        });

        panel.add(createButton);
        panel.add(updateButton);
        panel.add(deleteButton);

        // Refresh button
        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                refreshTable();
            }
        });
        panel.add(refreshButton);

        return panel;
    }

    public void refreshTable() {
        tableModel.setRowCount(0);

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "SELECT news_ID, news_Month, news_Day, news_DayInt, news_Title FROM tblnewsletter";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Object[] rowData = new Object[4];
                rowData[0] = resultSet.getInt("news_ID");
                rowData[1] = resultSet.getString("news_Month");
                rowData[2] = resultSet.getInt("news_DayInt") + "    -    " + resultSet.getString("news_Day");
                rowData[3] = resultSet.getString("news_Title");
                tableModel.addRow(rowData);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        tableModel.fireTableDataChanged();
        table.repaint();
    }
    
    public void deleteLatestEntry() {
    String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
    String dbUsername = "root";
    String dbPassword = "";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
        String deleteQuery = "DELETE FROM tblnewsletter WHERE news_ID = (SELECT MAX(news_ID) FROM tblnewsletter)";
        PreparedStatement deleteStatement = conn.prepareStatement(deleteQuery);
        deleteStatement.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
    }
}

