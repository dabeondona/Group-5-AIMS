
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


public class AdminNewsletterInsert extends JPanel {
    
    private JTextField titleField;
    private JTextArea contentArea;
    
    public AdminNewsletterInsert(JPanel cardPanel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
        
        this.add(new AdminTopPanelButton(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        this.add(createBottomPnl(cardPanel, cardLayout), BorderLayout.SOUTH);
        
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
    JPanel panel = new JPanel();
    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

    JPanel titlePnl = new JPanel();
    titleField = new JTextField(25);

    titlePnl.add(new JLabel("Title: "));
    titlePnl.add(titleField);

    JPanel contentPnl = new JPanel();
    contentPnl.add(new JLabel("Set Content: "));

    contentArea = new JTextArea();
    contentArea.setColumns(25);
    contentArea.setRows(15);
    contentPnl.add(new JScrollPane(contentArea));

    panel.add(titlePnl);
    panel.add(contentPnl);

    return panel;
}
    
    public JPanel createBottomPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
       
        JButton backButton = new JButton("Back");
        JButton insertButton = new JButton("Insert");
        
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminnewsletterPnl"); 
            }
        });
        
        insertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String content = contentArea.getText();
                sendContent(title, content);
                cardLayout.show(cardPanel, "adminnewsletterPnl"); 
            }
        });
        
        panel.add(backButton);
        panel.add(insertButton);
  
        return panel;
    }
    
    public void sendContent(String title, String content) {
        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        LocalDate currentDate = LocalDate.now();
        String currentMonth = currentDate.getMonth().toString();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEEE");
        String currentDay = currentDate.format(formatter);
        int currentDayInt = currentDate.getDayOfMonth();

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "INSERT INTO tblnewsletter (news_Month, news_Day, news_DayInt, news_Title, news_Content) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, currentMonth);
            statement.setString(2, currentDay);
            statement.setInt(3, currentDayInt);
            statement.setString(4, title);
            statement.setString(5, content);

            int rowsInserted = statement.executeUpdate();

            if(rowsInserted > 0) {
                System.out.println("Content inserted successfully.");
            } else {
                System.out.println("Failed to insert Content.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Error: " + e.getMessage());
        }
    } 
}
