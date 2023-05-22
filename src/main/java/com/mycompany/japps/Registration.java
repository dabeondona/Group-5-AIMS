/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author keisamae
 */



import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.*;

public class Registration extends JFrame{
    
    static JPanel cardPanel;
    static CardLayout cardLayout;
    
        public Registration() {
            this.setTitle(getGUIName());

            cardPanel = new JPanel();
            cardLayout = new CardLayout();
            cardPanel.setLayout(cardLayout);

            /*SplashPage splashPnl = new SplashPage(cardPanel, cardLayout);    
            cardPanel.add(splashPnl, "splash");

            LoginPage loginPnl = new LoginPage();  
            cardPanel.add(loginPnl, "login");   */
            RegistrationType regType = new RegistrationType(cardPanel, cardLayout);
            cardPanel.add(regType, "regType"); 

            AdminRegistration adminRegPnl = new AdminRegistration(cardPanel, cardLayout);
            cardPanel.add(adminRegPnl, "adminReg"); 

            StudentRegistration studentRegPnl = new StudentRegistration(cardPanel, cardLayout);
            cardPanel.add(studentRegPnl, "studentReg"); 

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

}
