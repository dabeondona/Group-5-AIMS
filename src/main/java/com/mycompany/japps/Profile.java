/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.border.*;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author alest
 */
public class Profile extends JPanel{
    private JLabel nameLabel;
    private JLabel departmentLabel;
    private JLabel programLabel;
    private JLabel yearLabel;
    private JLabel photoLabel;
    private JButton uploadButton;
    private JLabel bloodType;
    
    public Profile(JPanel cardPanel, CardLayout cardLayout) {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());
        
        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add( createMiddlePnl(), BorderLayout.CENTER);
       
        this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
        this.setVisible(true);
    }
    
    public JPanel createTitlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));
        
        JLabel titleLabel = new JLabel("Profile");
        Font font = titleLabel.getFont();
        font = new Font(font.getName(), font.getStyle(), 35);
        titleLabel.setFont(font);
        panel.add(titleLabel);
        
        panel.setBackground(new Color(0xfcca00));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        
        return panel;     
    }
    
    public JPanel createMiddlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titlePnl = createTitlePnl();
        panel.add(titlePnl);
        
        panel.add(Box.createVerticalGlue()); 

        panel.add(profileDetPnl());
        
        
        
        
        return panel;
    }
    
    public JPanel profileDetPnl(){
        JPanel panel = new JPanel();
        
        nameLabel = new JLabel("Name: John Doe");
        departmentLabel = new JLabel("Department: Computer Science");
        programLabel = new JLabel("Program: Bachelor of Science in Computer Science");
        yearLabel = new JLabel("Year: 3rd Year");
        bloodType = new JLabel("Blood Type: O+");
        

        // Create label for photo
        photoLabel = new JLabel("No Photo Available", SwingConstants.CENTER);
        photoLabel.setPreferredSize(new Dimension(200, 200));
        photoLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        // Create upload button
        uploadButton = new JButton("Upload Photo");
        uploadButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("Images", "jpg", "jpeg", "png");
                fileChooser.setFileFilter(filter);

                int result = fileChooser.showOpenDialog(Profile.this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    String filePath = fileChooser.getSelectedFile().getAbsolutePath();
                    ImageIcon imageIcon = new ImageIcon(filePath);
                    photoLabel.setIcon(imageIcon);
                }
            }
        });

        // Add components to the frame
        panel.add(photoLabel, BorderLayout.WEST);

        JPanel detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5, 1));
        detailsPanel.add(nameLabel);
        detailsPanel.add(departmentLabel);
        detailsPanel.add(programLabel);
        detailsPanel.add(yearLabel);
        detailsPanel.add(bloodType);

        panel.add(detailsPanel, BorderLayout.CENTER);
        panel.add(uploadButton, BorderLayout.SOUTH);
        
        return panel;
    }
    
}
