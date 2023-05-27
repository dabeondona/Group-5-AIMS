package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 * TODO:
 * - Logo (BorderLayout.WEST)
 * 
 */

public class TopPanelButtons extends JPanel {
        JButton profileIconButton;
        
        
    public TopPanelButtons() {
        setLayout(new BorderLayout());
        // EAST
        JButton profileIconButton = new JButton(new ImageIcon("C://Users//ondon//Pictures//20210619_214454.jpg"));
        profileIconButton.setPreferredSize(new Dimension(50,50));
        
        // CENTER
        JPanel middlePnl = createMiddlePnl();
        middlePnl.setBackground(Japps.getJFrameColor());
        
        // WEST
        JLabel placeholder = new JLabel("Logo Here");
        placeholder.setForeground(new Color(0xfcca00));
        
        
        this.add(profileIconButton, BorderLayout.EAST);
        this.add(middlePnl, BorderLayout.CENTER);
        this.add(placeholder, BorderLayout.WEST);
        this.setBackground(Japps.getJFrameColor());
    }
    
    public JPanel createMiddlePnl() {
        JPanel panel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));

        JButton placeHolderButton1 = new JButton("Placeholder_1");
        placeHolderButton1.setBackground(new Color(0xfcca00));

        JButton placeHolderButton2 = new JButton("Placeholder_2");
        placeHolderButton2.setBackground(new Color(0xfcca00));

        JButton placeHolderButton3 = new JButton("Placeholder_3");
        placeHolderButton3.setBackground(new Color(0xfcca00));

        JButton placeHolderButton4 = new JButton("Placeholder_4");
        placeHolderButton4.setBackground(new Color(0xfcca00));

        JButton placeHolderButton5 = new JButton("Placeholder_5");
        placeHolderButton5.setBackground(new Color(0xfcca00));

        panel.add(placeHolderButton1);
        panel.add(placeHolderButton2);
        panel.add(placeHolderButton3);
        panel.add(placeHolderButton4);
        panel.add(placeHolderButton5);
        return panel;
    }
}
