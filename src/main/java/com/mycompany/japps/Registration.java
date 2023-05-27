/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;


/**
 *
 * @author keisamae
 */



import java.awt.CardLayout;
import java.awt.Color;
import javax.swing.*;

public class Registration extends JPanel{
    
    static JPanel cardPanel;
    static CardLayout cardLayout;
    
        public Registration() {
            //this.setTitle(getGUIName());

            cardPanel = new JPanel();
            cardLayout = new CardLayout();
            cardPanel.setLayout(cardLayout);
            this.setBackground(Japps.getJFrameColor());

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
            //this.setSize(getGUIWidth(), getGUIHeight());
            //this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            this.setVisible(true);
        
    }
    
    

}
