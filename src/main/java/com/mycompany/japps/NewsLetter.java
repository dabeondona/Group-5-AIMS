package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
/**
 *
 * 
 */
public class NewsLetter extends JPanel{
    TopPanelButtons topPnlButtons;
    
    public NewsLetter() {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());
        
        JPanel middlePnl = createMiddlePnl();
        
        TopPanelButtons topPnlButtons = new TopPanelButtons();
        this.add(topPnlButtons, BorderLayout.NORTH);

        this.add(middlePnl, BorderLayout.CENTER);
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createMiddlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel title = new JLabel("The Technologian Newsletter");
        Font font = title.getFont();
        font = new Font(font.getName(), font.getStyle(), 30);
        title.setFont(font);
        title.setBorder(new EmptyBorder(new Insets(40, 200, 0, 0)));
        panel.add(title);
        
        panel.add(createLabelContent("May", "Saturday", 13));
        panel.add(createButtonsContent("Placeholder1"));
        panel.add(createButtonsContent("Placeholder2"));
        panel.add(createButtonsContent("Placeholder3"));
        
        panel.add(createLabelContent("May", "Sunday", 14));
        panel.add(createButtonsContent("Placeholder4")); 
        return panel;
    }
    
    public JPanel createLabelContent(String month, String day, int dayInt) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel(new newsletterContent(month, day, dayInt).toString());
        Font font = label.getFont();
        font = new Font(font.getName(), font.getStyle(), 25);
        label.setFont(font);
        label.setBorder(new EmptyBorder(new Insets(25, 200, 0, 0)));
        
        JLabel label2 = new JLabel(day);
        Font font2 = label2.getFont();
        font2 = new Font(font2.getName(), font2.getStyle(), 15);
        label2.setFont(font2);
        label2.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));
        
        panel.add(label);
        panel.add(label2);  
        return panel;
    }
    
    public JPanel createButtonsContent(String description) {
        JPanel panel = new JPanel();
        JButton btnTest = new JButton(description);
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS)); 
        panel.add(Box.createHorizontalGlue());
        btnTest.setPreferredSize(new Dimension(300, 100)); 
        panel.add(btnTest);
        panel.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        panel.add(Box.createHorizontalGlue());
        return panel;
    }
    
}
