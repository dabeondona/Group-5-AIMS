
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

public class AdminNewsletterUpdate extends JPanel {
    private JTextField idField;
    private JTextField titleField;
    private JTextArea contentArea;
    
    
    public AdminNewsletterUpdate(JPanel cardPanel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
        
        this.add(new AdminTopPanelButton(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(new JLabel("                                             "), BorderLayout.WEST);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        this.add(createBottomPnl(cardPanel, cardLayout), BorderLayout.SOUTH);
        
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
     public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
            JPanel panel = new JPanel();
            panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

                JPanel idPnl = new JPanel();
                idField = new JTextField(25);

                idPnl.add(new JLabel("ID: "));
                idPnl.add(idField);

                JPanel titlePnl = new JPanel();
                titleField = new JTextField(25);

                titlePnl.add(new JLabel("Title: "));
                titlePnl.add(titleField);

                JPanel contentPnl = new JPanel();

                contentArea = new JTextArea();
                contentArea.setColumns(25);
                contentArea.setRows(15);
                contentPnl.add(new JScrollPane(contentArea));

                panel.add(idPnl);
                panel.add(titlePnl);
                panel.add(contentPnl);

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
                cardLayout.show(cardPanel, "adminnewsletterPnl"); 
            }
        });
        
        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateNewsletter();
                cardLayout.show(cardPanel, "adminnewsletterPnl"); 
            }
        });
        
        panel.add(backButton);
        panel.add(updateButton);
  
        return panel;
    }
    
    public void updateNewsletter() {
        int newsID = Integer.parseInt(idField.getText());
        String title = titleField.getText();
        String content = contentArea.getText();

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String updateQuery = "UPDATE tblnewsletter SET news_Title = ?, news_Content = ? WHERE news_ID = ?";
            PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
            updateStatement.setString(1, title);
            updateStatement.setString(2, content);
            updateStatement.setInt(3, newsID);
            updateStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
