package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class AdminTopPanelButton extends JPanel {
    
    public AdminTopPanelButton(JPanel cardPanel, CardLayout cardLayout) {
        setLayout(new BorderLayout());
        
        // CENTER
        JPanel middlePnl = createMiddlePnl(cardPanel, cardLayout);
        middlePnl.setBackground(Japps.getJFrameColor());
        
        // WEST
        JLabel placeholder = new JLabel("Admin View");
        placeholder.setForeground(new Color(0xfcca00));
        
        this.add(middlePnl, BorderLayout.CENTER);
        this.add(placeholder, BorderLayout.WEST);
        this.setBackground(Japps.getJFrameColor());
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));

      /*  JButton announcementsButton = new JButton("Announcements");
        announcementsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "announcementPnl");   
            }
        });
        announcementsButton.setBackground(new Color(0xfcca00)); */

        JButton newsLetterButton = new JButton("Newsletter");
        newsLetterButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "adminnewsletterPnl");    
            }
        });
        newsLetterButton.setBackground(new Color(0xfcca00));
        
       /* JButton accountsButton = new JButton("Accounts");
        accountsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "accountsPnl");    
            }
        });
        accountsButton.setBackground(new Color(0xfcca00));

        JButton calendarButton = new JButton("Calendar");
        calendarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "CalendarPnl");    
            }
        });
        calendarButton.setBackground(new Color(0xfcca00)); */

        JButton supportButton = new JButton("Support");
        supportButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "adminsupportPnl");    
            }
        }); 
        supportButton.setBackground(new Color(0xfcca00)); 

      //  panel.add(announcementsButton);
        panel.add(newsLetterButton);
     //   panel.add(accountsButton);
     //   panel.add(calendarButton);
        panel.add(supportButton);
        return panel;
    }
}