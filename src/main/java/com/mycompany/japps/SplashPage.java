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
public class SplashPage extends JFrame{
    static JPanel cardPnl;
    JPanel splashPagePnl;
    JButton iconButton;
    
    public SplashPage(){
     this.setTitle(Japps.getGUIName());
     JPanel cardPnl = new JPanel();
     cardPnl.setName("cardPanel");
     
     
     JPanel splashPagePnl = new JPanel();
     splashPagePnl.setLayout(new BorderLayout());
     
     JButton iconButton = new JButton(new ImageIcon("C://Users//ondon//Pictures//20210619_214454.jpg"));
     iconButton.setPreferredSize(new Dimension(100,50));
    
     
     splashPagePnl.add(iconButton, BorderLayout.CENTER);
     this.setLayout(new GridBagLayout()); 
          
     this.add(splashPagePnl, new GridBagConstraints()); 
     this.getContentPane().setBackground(Japps.getJFrameColor());
     this.setSize(Japps.getGUIWidth(), Japps.getGUIHeight());
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
    }
}
