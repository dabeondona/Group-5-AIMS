package com.mycompany.japps;
import static com.mycompany.japps.Japps.cardLayout;
import static com.mycompany.japps.Japps.cardPanel;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.border.EmptyBorder;

public class SupportPageView extends JPanel{
    
    public SupportPageView(JPanel cardPanel, CardLayout cardLayout) {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());
              
        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        this.add(createBottomPnl(cardPanel, cardLayout), BorderLayout.SOUTH);

        
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.addColumn("ID");
        tableModel.addColumn("Month");
        tableModel.addColumn("Day");
        tableModel.addColumn("Title");
        tableModel.addColumn("Status");
        
        JTable table = new JTable(tableModel);

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

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix"; 
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            int userID = Session.getSessionToken(); 
            
            String query = "SELECT support_ID, support_Month, support_Day, support_Title, support_IsSolved FROM tblsupport";

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
        } catch (SQLException e) {
            e.printStackTrace();
        }

        JScrollPane scrollPane = new JScrollPane(table);

        panel.add(scrollPane);
        
        return panel;
    }
    
    public JPanel createBottomPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();

        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0xfcca00));
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "supportPnl");
            }
        });

        panel.add(backButton);
        return panel;
    }
}
