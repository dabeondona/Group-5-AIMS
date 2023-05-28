package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
/**
 *
 * 
 * 
 * 
 */

public class Japps extends JFrame {
    static JPanel cardPanel;
    static CardLayout cardLayout;

    public Japps() {
        this.setTitle(getGUIName());
        CardPanel();
        instantiateCards();

        this.add(cardPanel);
        cardLayout.show(cardPanel, "splash");
        this.setSize(getGUIWidth(), getGUIHeight());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        }
    
    /*
    *               *
    *     *       *      *      *     *
    *               *          ***        *       *       *
    *       *           *     *****           *       *
    *        *    *          *******          *           *
    *     *                 *********             *       *
    *           *      *   ***********     *  *       
    *    *   *   *        *************               *       *
    *                    ***************          *       *
    *     *      *             ***                *           *
    *                          ***  merry christmas
    *                    
    */

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Japps();
            }
        }); 
       }
    
    /*
    *
    * ---------------------------------------------------------------------------------------------------------------------------
    *
    */
    
    private void CardPanel() {
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        }

    private void instantiateCards() {
        cardPanel.add(new SplashPage(cardPanel, cardLayout), "splash");
        cardPanel.add(new LoginPage(cardPanel, cardLayout), "login");
        cardPanel.add(new ForgetPasswordGUI(cardPanel, cardLayout), "forget");
        cardPanel.add(new Registration(), "registerPnl");
        
        
        cardPanel.add(new NewsLetter(cardPanel, cardLayout), "newsLetterPnl");
        cardPanel.add(new AnnouncementGUI(cardPanel, cardLayout), "announcementPnl");
        cardPanel.add(new AccountGUI(cardPanel, cardLayout), "accountsPnl");
        cardPanel.add(new SupportPage(cardPanel, cardLayout), "supportPnl");
        
        
        cardPanel.add(new SupportPageSend(cardPanel, cardLayout), "supportSendPnl");
        cardPanel.add(new SupportPageView(cardPanel, cardLayout), "supportViewPnl");
        cardPanel.add(new Profile(cardPanel, cardLayout), "profilePnl");
        cardPanel.add(new SettingsScreen(cardPanel, cardLayout), "settingsPnl");
        cardPanel.add(new Calendar(cardPanel, cardLayout), "calendarPnl");
        cardPanel.add(new StudentCalendar(cardPanel, cardLayout), "studentCalendarPnl");
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
}
