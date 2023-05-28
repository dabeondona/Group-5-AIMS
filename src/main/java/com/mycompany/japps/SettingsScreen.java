
package com.mycompany.japps;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SettingsScreen extends JPanel {

    public SettingsScreen(JPanel cardPanel, CardLayout cardLayout) {
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
        
        JLabel titleLabel = new JLabel("Settigns");
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

        panel.add(settingsPnl());
        
        
        
        
        return panel;
    }
    
    public JPanel settingsPnl(){
        JPanel panel = new JPanel();
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(Color.decode("#8c383e"));

        //settings components
        JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.LEFT); // Set tab placement to the left

        JPanel generalSettingsPanel = new JPanel(new BorderLayout());
        generalSettingsPanel.setBackground(Color.WHITE);
        generalSettingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        //theme selection components
        JLabel themeLabel = new JLabel("Theme:");
        JCheckBox darkModeCheckbox = new JCheckBox("Dark Mode");
        JCheckBox lightModeCheckbox = new JCheckBox("Light Mode");

        //button group for mutually exclusive selection
        ButtonGroup themeButtonGroup = new ButtonGroup();
        themeButtonGroup.add(darkModeCheckbox);
        themeButtonGroup.add(lightModeCheckbox);

        JPanel themePanel = new JPanel();
        themePanel.add(themeLabel);
        themePanel.add(darkModeCheckbox);
        themePanel.add(lightModeCheckbox);

        generalSettingsPanel.add(themePanel, BorderLayout.NORTH);
        generalSettingsPanel.add(new JLabel("This is the general settings tab content"), BorderLayout.CENTER);

        // add language selection components
        JLabel languageLabel = new JLabel("Language:");
        String[] languages = {"English", "Spanish", "French", "German", "Italian"};
        JComboBox<String> languageComboBox = new JComboBox<>(languages);

        JPanel languagePanel = new JPanel();
        languagePanel.add(languageLabel);
        languagePanel.add(languageComboBox);

        generalSettingsPanel.add(languagePanel, BorderLayout.CENTER);

        // add email notification checkbox
        JCheckBox emailNotificationCheckbox = new JCheckBox("Send notification to email");
        generalSettingsPanel.add(emailNotificationCheckbox, BorderLayout.SOUTH);

        tabbedPane.addTab("General", generalSettingsPanel);

        JPanel privacySettingsPanel = new JPanel(new BorderLayout());
        privacySettingsPanel.setBackground(Color.WHITE);
        privacySettingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // add privacy settings content
        JPanel privacyContentPanel = new JPanel(new BorderLayout());
        

        JPanel privacyTextPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel privacyTextLabel = new JLabel("Who can lookup your school email address?");
        JButton editButton = new JButton("Edit");

        privacyTextPanel.add(privacyTextLabel);
        privacyTextPanel.add(editButton);

        privacyContentPanel.add(privacyTextPanel, BorderLayout.CENTER);
        privacySettingsPanel.add(privacyContentPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Privacy", privacySettingsPanel);

        JPanel accountSettingsPanel = new JPanel(new BorderLayout());
        accountSettingsPanel.setBackground(Color.WHITE);
        accountSettingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // add account settings buttons
        JButton changePasswordButton = new JButton("Change Password");
        JButton editInformationButton = new JButton("Edit Information");
        JButton saveLoginButton = new JButton("Save Login");
        JButton changeEmailButton = new JButton("Change Email");

        JPanel accountButtonsPanel = new JPanel(new GridLayout(4, 1, 0, 10));
        accountButtonsPanel.add(changePasswordButton);
        accountButtonsPanel.add(editInformationButton);
        accountButtonsPanel.add(saveLoginButton);
        accountButtonsPanel.add(changeEmailButton);

        accountSettingsPanel.add(accountButtonsPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Account", accountSettingsPanel);

        JPanel securitySettingsPanel = new JPanel(new BorderLayout());
        securitySettingsPanel.setBackground(Color.WHITE);
        securitySettingsPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        // add security settings buttons
        JButton loginAlertsButton = new JButton("Login Alerts");
        JButton whereYoureLoggedInButton = new JButton("Where You're Logged In");
        JButton recentEmailsButton = new JButton("Recent Emails");

        JPanel securityButtonsPanel = new JPanel(new GridLayout(3, 1, 0, 10));
        securityButtonsPanel.add(loginAlertsButton);
        securityButtonsPanel.add(whereYoureLoggedInButton);
        securityButtonsPanel.add(recentEmailsButton);

        securitySettingsPanel.add(securityButtonsPanel, BorderLayout.CENTER);

        tabbedPane.addTab("Security", securitySettingsPanel);

        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        // add main panel to the frames content pane
        //setContentPane(mainPanel);
        //this.setVisible(true);
        
        panel.add(mainPanel);
        return panel;
    }

}
