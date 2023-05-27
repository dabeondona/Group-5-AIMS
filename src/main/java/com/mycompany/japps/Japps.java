package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
/**
 *
 * 
 * 
 * 
 */
public class Japps extends JFrame{
    static JPanel cardPanel;
    static CardLayout cardLayout;
    
    public Japps() {
        this.setTitle(getGUIName());
    
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        
        TopPanelButtons topbuttonsPnl = new TopPanelButtons(cardPanel, cardLayout);
        
        SplashPage splashPnl = new SplashPage(cardPanel, cardLayout);    
        cardPanel.add(splashPnl, "splash");
        
        LoginPage loginPnl = new LoginPage(cardPanel, cardLayout);  
        cardPanel.add(loginPnl, "login");   
        
        Registration registerPnl = new Registration();
        cardPanel.add(registerPnl, "registerPnl");
        
        NewsLetter newsLetterPnl = new NewsLetter(cardPanel, cardLayout);
        cardPanel.add(newsLetterPnl, "newsLetterPnl");
        
        AnnouncementGUI announcementPnl = new AnnouncementGUI(cardPanel, cardLayout);
        cardPanel.add(announcementPnl, "announcementPnl");
        
        SupportPage supportPnl = new SupportPage(cardPanel, cardLayout);
        cardPanel.add(supportPnl, "supportPnl"); 
        
        SupportPageSend supportSendPnl = new SupportPageSend(cardPanel, cardLayout);
        cardPanel.add(supportSendPnl, "supportSendPnl"); 
        
        SupportPageView supportViewPnl = new SupportPageView(cardPanel, cardLayout);
        cardPanel.add(supportViewPnl, "supportViewPnl"); 
        
        Profile profilePnl = new Profile(cardPanel, cardLayout);
        cardPanel.add(profilePnl,"profilePnl");
        
        Calendar calendarPnl = new Calendar(cardPanel, cardLayout);
        cardPanel.add(calendarPnl, "calendarPnl");
        
        
        this.add(cardPanel);
        cardLayout.show(cardPanel, "splash");
        this.setSize(getGUIWidth(), getGUIHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        
    }
    
    public static String getGUIName() {
        return "Helix";
    }
    
    public static int getGUIWidth() {
        return 1000;
    }
    
    public static int getGUIHeight() {
        return 500;
    }
    
    public static Color getJFrameColor() {
        return new Color(0x8a252c);
    }
    
    public static Color getJPanelColor() {
        return new Color(0xa83332);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Japps();
            }
        });  
       
    }
}
