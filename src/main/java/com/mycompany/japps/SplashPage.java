package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * Line 23:
 * filename directory needs to be changed to the appropriate icon
 * 
 * Line 24:
 * setPreferredSize according to the appropriate icon size
 * 
 * Codes to be used:
 * - JSeparators
 * - Swing Offsets
 * - ImageIcons
 */
public class SplashPage extends JPanel {
    JPanel splashPagePnl;
    JButton iconButton;
    
    public SplashPage(JPanel cardPanel, CardLayout cardLayout){    
     
     JPanel splashPagePnl = new JPanel();
     splashPagePnl.setLayout(new BorderLayout());
     
     JButton iconButton = new JButton(new ImageIcon("C://Users//ondon//Pictures//20210619_214454.jpg"));
     iconButton.setPreferredSize(new Dimension(100,50));
     iconButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {  
               
               cardLayout.show(cardPanel, "login");        
            }
    
     }); 
     splashPagePnl.add(iconButton, BorderLayout.CENTER);
     this.setLayout(new GridBagLayout()); 
     this.setBackground(Japps.getJFrameColor());
     this.add(splashPagePnl, new GridBagConstraints()); 
    }
}
    