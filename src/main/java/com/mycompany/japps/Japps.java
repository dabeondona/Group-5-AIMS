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
        
        SplashPage splashPnl = new SplashPage(cardPanel, cardLayout);    
        cardPanel.add(splashPnl, "splash");
        
        LoginPage loginPnl = new LoginPage();  
        cardPanel.add(loginPnl, "login");   
        
        this.add(cardPanel);
        cardLayout.show(cardPanel, "splash");
        this.setSize(getGUIWidth(), getGUIHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
     //new NewsLetter();
    }
}
