package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SplashPage extends JPanel {
    JPanel splashPagePnl;
    JButton iconButton;
    
    public SplashPage(JPanel cardPanel, CardLayout cardLayout){    
     
     JPanel splashPagePnl = new JPanel();
     splashPagePnl.setLayout(new BorderLayout());
     
     JButton iconButton = new JButton(new ImageIcon("C://Users//ondon//Pictures//blogo_icon.png"));
     iconButton.setUI(new javax.swing.plaf.basic.BasicButtonUI());
     iconButton.setBorder(BorderFactory.createEmptyBorder());
     iconButton.setBackground(Japps.getJFrameColor());
     iconButton.setPreferredSize(new Dimension(300,300));
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
    