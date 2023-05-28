package com.mycompany.japps;
import static com.mycompany.japps.Japps.cardLayout;
import static com.mycompany.japps.Japps.cardPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * TODO:
 * - Logo (BorderLayout.WEST)
 * 
 */

public class TopPanelButtons extends JPanel {
        JButton profileIconButton;
        
        
    public TopPanelButtons(JPanel cardPanel, CardLayout cardLayout) {
      
        setLayout(new BorderLayout());
        // EAST
        JButton profileIconButton = new JButton(new ImageIcon("C://Users//ondon//Pictures//default_icon.png"));
        profileIconButton.setFocusPainted(false);
        profileIconButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
        profileIconButton.setBorder(BorderFactory.createEmptyBorder());
        profileIconButton.setBackground(Japps.getJFrameColor());
        profileIconButton.setPreferredSize(new Dimension(50,50));
        profileIconButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "profilePnl");    
            }
        });
        
        // CENTER
        JPanel middlePnl = createMiddlePnl(cardPanel, cardLayout);
        middlePnl.setBackground(Japps.getJFrameColor());
        
        // WEST
        JLabel placeholder = new JLabel("Logo Here");
        placeholder.setForeground(new Color(0xfcca00));
        
        
        this.add(profileIconButton, BorderLayout.EAST);
        this.add(middlePnl, BorderLayout.CENTER);
        this.add(placeholder, BorderLayout.WEST);
        this.setBackground(Japps.getJFrameColor());
    }
    
    public JPanel createMiddlePnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));

        JButton announcementsButton = new JButton("Announcements");
        announcementsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "announcementPnl");   
            }
        });

        announcementsButton.setBackground(new Color(0xfcca00));

        JButton newsLetterButton = new JButton("Newsletter");
        newsLetterButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "newsLetterPnl");    
            }
        });

        newsLetterButton.setBackground(new Color(0xfcca00));
        
        JButton accountsButton = new JButton("Accounts");
        accountsButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "accountsPnl");    
            }
        });
        accountsButton.setBackground(new Color(0xfcca00));

        JButton calendarButton = new JButton("Calendar");
        calendarButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int id = Integer.parseInt(Username.getUsernameToken());
                    cardLayout.show(cardPanel, "calendarPnl");
  
            }
        });
        calendarButton.setBackground(new Color(0xfcca00));

        JButton supportButton = new JButton("Support");
        supportButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "supportPnl");    
            }

        }); 
        supportButton.setBackground(new Color(0xfcca00));

        panel.add(announcementsButton);
        panel.add(newsLetterButton);
        panel.add(accountsButton);
        panel.add(calendarButton);
        panel.add(supportButton);
        return panel;
    }
}
