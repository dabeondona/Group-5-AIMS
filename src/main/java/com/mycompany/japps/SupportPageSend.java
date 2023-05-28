package com.mycompany.japps;
import static com.mycompany.japps.Japps.cardLayout;
import static com.mycompany.japps.Japps.cardPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import java.util.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import javax.swing.border.EmptyBorder;
import java.time.format.TextStyle;

public class SupportPageSend extends JPanel{
    
    static int jumbo = 0;
    
    public SupportPageSend(JPanel cardPanel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
       
       
        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        
      
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5,1));
        
        
        JLabel titleLabel = new JLabel("Inquiry Title: ");
        JTextField titleField = new JTextField(30);    
        
        JLabel descriptionLabel = new JLabel("Please Be Concise with your Inquiry:");
        JTextArea descriptionArea = new JTextArea();
        descriptionArea.setPreferredSize(new Dimension(200, 100));
        
        JPanel panelButtons = new JPanel();
        JButton backButton = new JButton("Back");
        backButton.setBackground(new Color(0xfcca00));
        
        backButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "supportPnl");    
            }
        });
        
        JButton sendButton = new JButton("Send");
        sendButton.setBackground(new Color(0xfcca00));
        
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                String title = titleField.getText();
                String description = descriptionArea.getText();
                sendTicket(title, description);
                
                cardLayout.show(cardPanel, "supportPnl");  
            }
        });
        
        panelButtons.add(backButton);
        panelButtons.add(sendButton);
        
        panel.add(titleLabel);
        panel.add(titleField);
        panel.add(descriptionLabel);
        panel.add(descriptionArea);
        panel.add(panelButtons);
      
        return panel;
    }
    
    public void sendTicket(String title, String description) {
    String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
    String dbUsername = "root";
    String dbPassword = "";

    LocalDate currentDate = LocalDate.now();
    String currentMonth = currentDate.getMonth().toString();
    int currentDay = currentDate.getDayOfMonth();

    LocalTime currentTime = LocalTime.now();
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
    String formattedTime = currentTime.format(formatter);

    boolean isSolved = false;

    try(Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
        String query = "INSERT INTO tblsupport (support_Month, support_Day, support_Time, support_Title, support_Description, support_IsSolved, user_ID) VALUES (?, ?, ?, ?, ?, ?, ?)";
        jumbo = Session.getSessionToken();
        PreparedStatement statement = conn.prepareStatement(query);
        statement.setString(1, currentMonth);
        statement.setInt(2, currentDay);
        statement.setString(3, formattedTime);
        statement.setString(4, title);
        statement.setString(5, description);
        statement.setBoolean(6, isSolved);
        statement.setInt(7, Session.getSessionToken());

        int rowsInserted = statement.executeUpdate();

        if(rowsInserted > 0) {
            System.out.println("Ticket inserted successfully.");
        } else {
            System.out.println("Failed to insert ticket.");
        }
    } catch(SQLException e) {
        e.printStackTrace();
        System.out.println("Error: " + e.getMessage());
    }
    }
}
