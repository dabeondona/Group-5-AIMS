/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
/**
 *
 * @author ondon
 * JLabel test = new JLabel();
 * JSeparator sep = new JSeparator();  
 * Swing Offset
 */
public class Japps extends JFrame{
    JPanel pnl;
    JLabel test, test2;
    
    public Japps(){
     JPanel pnl = new JPanel();
     pnl.setLayout(new BorderLayout());
     
    // ImageIcon water = new ImageIcon("C://Users//ondon//Pictures//20210619_214454.jpg");
     JButton button = new JButton(new ImageIcon("C://Users//ondon//Pictures//20210619_214454.jpg"));
     button.setPreferredSize(new Dimension(100,50));
    
     
   //  pnl.add(sep, BorderLayout.NORTH);
     pnl.add(button, BorderLayout.CENTER);
     setLayout(new GridBagLayout()); // Set the layout manager to GridBagLayout
      
        
        
        JLabel test2 = new JLabel();
    
        add(test2, new GridBagConstraints()); // Add test2 with default constraints
        add(pnl, new GridBagConstraints()); // Add pnl with default constraints

        
        setSize(500,500);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Japps();
    }
}
