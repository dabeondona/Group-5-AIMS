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

public class SupportPage extends JPanel {
    
    public SupportPage(JPanel cardPanel, CardLayout cardLayout) {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());
              
        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(cardPanel, cardLayout), BorderLayout.CENTER);
        
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(new Insets(150, 0, 0, 0)));
        
        JButton viewButton = new JButton("View Ticket(s)");
        viewButton.setBackground(new Color(0xfcca00));
        
        viewButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "supportViewPnl");    
            }
        });
        
        JButton sendButton = new JButton("Send Ticket");
        sendButton.setBackground(new Color(0xfcca00));
        
        sendButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "supportSendPnl");    
            }
        });
        
        panel.add(viewButton);
        panel.add(sendButton);
        return panel;
    }
}
