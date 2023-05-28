package com.mycompany.japps;
import com.mycompany.japps.Session;
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
    table.getColumnModel().getColumn(4).setCellRenderer(new DefaultTableCellRenderer() {
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
    });

    String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
    String dbUsername = "root";
    String dbPassword = "";

    try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
        int id = Session.getSessionToken();
        String query = "SELECT support_ID, support_Month, support_Day, support_Title, support_IsSolved FROM tblsupport WHERE user_ID = ?";

        PreparedStatement statement = conn.prepareStatement(query);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();

        while (resultSet.next()) {
            int supportID = resultSet.getInt("support_ID");
            String supportMonth = resultSet.getString("support_Month");
            int supportDay = resultSet.getInt("support_Day");
            String supportTitle = resultSet.getString("support_Title");
            int supportIsSolved = resultSet.getInt("support_IsSolved");

            Object[] rowData = {supportID, supportMonth, supportDay, supportTitle, supportIsSolved};
            tableModel.addRow(rowData);
        }
    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "An error occurred while retrieving support data.", "Error", JOptionPane.ERROR_MESSAGE);
    }

    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(400, 200));

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
