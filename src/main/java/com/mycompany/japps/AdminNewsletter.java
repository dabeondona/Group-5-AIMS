
package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;


public class AdminNewsletter extends JPanel {
    
    public AdminNewsletter(JPanel cardPanel, CardLayout cardLayout) {
        this.setLayout(new BorderLayout());
        
        this.add(new AdminTopPanelButton(cardPanel, cardLayout), BorderLayout.NORTH);
       
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createMiddlePnl() {
        JPanel panel = new JPanel();
        
        
        
        return panel;
    }
}
