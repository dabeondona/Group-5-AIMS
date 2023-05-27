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
        
        this.add(new TopPanelButtons(), BorderLayout.NORTH);
        this.add( createMiddlePnl(), BorderLayout.CENTER);
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createTitlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel titleLabel = new JLabel("The Technologian Newsletter");
        Font font = titleLabel.getFont();
        font = new Font(font.getName(), font.getStyle(), 35);
        titleLabel.setFont(font);
        panel.add(titleLabel);
        
        JPanel dateLabel = createLabelContent("May", "Friday", 13);
        dateLabel.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));
        dateLabel.setForeground(new Color(0xfcca00));
        dateLabel.setBackground(new Color(0xfcca00));
        
        panel.setBackground(new Color(0xfcca00));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        panel.add(dateLabel);
        
        return panel;     
    }
    
    public JPanel createMiddlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titlePnl = createTitlePnl();
        panel.add(titlePnl);
        
        panel.add(Box.createVerticalGlue()); 
        JLabel titleLabel = new JLabel("Default");
        Font font = titleLabel.getFont();
        font = new Font(font.getName(), font.getStyle(), 25);
        titleLabel.setFont(font);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(new Insets(25, 0, 0, 0)));
        panel.add(titleLabel);
        panel.add(Box.createVerticalGlue()); 

        String loremIpsumText = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum condimentum, odio nec interdum ullamcorper, enim odio finibus ex, vitae dignissim ligula sem sed sem. Morbi pharetra hendrerit rhoncus. Donec sodales orci eget mi convallis interdum. Duis volutpat nibh in est tristique, ac facilisis tortor imperdiet. Curabitur ac scelerisque mauris, vel ultricies massa. Integer accumsan nunc eget purus interdum, vitae pellentesque felis suscipit. Sed id lectus eget nulla porttitor commodo sed in urna. Nullam scelerisque facilisis augue, vitae pellentesque risus rutrum sed. Cras ac dui ac dui posuere pretium nec a metus. Nullam consectetur lacinia est sed gravida. Aliquam rutrum, mi a vestibulum bibendum, dui tortor rhoncus nulla, id venenatis odio felis non lorem. Vestibulum vitae lacinia lectus. Proin nec volutpat orci. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas.";

        JTextArea loremIpsumArea = new JTextArea(loremIpsumText);
        loremIpsumArea.setEditable(false);
        loremIpsumArea.setOpaque(false);
        loremIpsumArea.setLineWrap(true);
        loremIpsumArea.setWrapStyleWord(true);
        loremIpsumArea.setBorder(new EmptyBorder(new Insets(25, 70, 0, 70)));
        panel.add(loremIpsumArea);
        
        
        
        return panel;
    }
    
    public JPanel createLabelContent(String month, String day, int dayInt) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        
        JLabel label = new JLabel(new newsletterContent(month, day, dayInt).toString());
        Font font = label.getFont();
        font = new Font(font.getName(), font.getStyle(), 25);
        label.setFont(font);
        label.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));
        
        JLabel label2 = new JLabel(day);
        Font font2 = label2.getFont();
        font2 = new Font(font2.getName(), font2.getStyle(), 15);
        label2.setFont(font2);
        label2.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));
        
        panel.add(label);
        panel.add(label2);  
        return panel;
    }
    
    public JPanel createContent() {
        JPanel panel = new JPanel();
        
        // Admin Implementation
        return panel;
    }
    
}
