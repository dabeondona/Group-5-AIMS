package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
/**
 * Line 23:
 * filename directory needs to be changed to the appropriate icon
 * 
 * Line 24:
 * setPreferredSize according to the appropriate icon size
 * 
 * Codes to still be used:
 * - JSeparators
 * - Swing Offsets
 * - ImageIcons
 */
public class SplashPage extends JFrame{
    JPanel splashPagePnl;
    JButton iconButton;
    
    public SplashPage(){
     JPanel splashPagePnl = new JPanel();
     splashPagePnl.setLayout(new BorderLayout());
     
     JButton iconButton = new JButton(new ImageIcon("C://Users//ondon//Pictures//20210619_214454.jpg"));
     iconButton.setPreferredSize(new Dimension(100,50));
     splashPagePnl.add(iconButton, BorderLayout.CENTER);
     setLayout(new GridBagLayout()); 
          
     add(splashPagePnl, new GridBagConstraints()); 
     setSize(500,500);
     setVisible(true);
    }
}
