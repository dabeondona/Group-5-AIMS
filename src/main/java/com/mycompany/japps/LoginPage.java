package com.mycompany.japps;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
/**
 *
 * Codes to be used:
 * - Java JDBC
 * - https://stackoverflow.com/questions/13368103/jpanel-drop-shadow
 */
public class LoginPage extends JFrame{
    
    public LoginPage() {
     this.setTitle(Japps.getGUIName());
     JPanel loginPagePnl = createLoginPagePnl();   
     JPanel samPnl = createSamPnl();
     loginPagePnl.add(samPnl, BorderLayout.NORTH);
     JPanel innerPagePnl = createInnerPagePnl();   
     loginPagePnl.add(innerPagePnl, BorderLayout.CENTER);
     
     JButton forgotButton = new JButton("<html><u>Forgot Password? Click me!</u></html>");
     forgotButton.setBackground(new Color(0, 0, 0, 0));
     forgotButton.setForeground(Color.WHITE);
     forgotButton.setOpaque(false);
     forgotButton.setBorder(BorderFactory.createEmptyBorder());
     
     loginPagePnl.add(forgotButton, BorderLayout.SOUTH);
     this.setLayout(new GridBagLayout()); 
     
     this.add(loginPagePnl, new GridBagConstraints());
     this.setSize(Japps.getGUIWidth(),Japps.getGUIHeight());
     this.getContentPane().setBackground(Japps.getJFrameColor());
     this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
     this.setVisible(true);
    }
    
    public JPanel createLoginPagePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(20,20,20,20);
        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
        javax.swing.border.Border border = BorderFactory.createCompoundBorder(line, padding);
        panel.setBackground(Japps.getJPanelColor());
        panel.setBorder(border);
        return panel;
    }
    
    public JPanel createInnerPagePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7,1));
        panel.setBackground(Japps.getJPanelColor());
        
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setForeground(Color.WHITE);
        panel.add(usernameLabel);
        JTextField usernameTextField = new PillTextField(10);
        panel.add(usernameTextField);
        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setForeground(Color.WHITE);
        panel.add(passwordLabel);
        JPasswordField usernamePWField = new PillPasswordField(10);
        panel.add(usernamePWField);
        
        JLabel emptyLabel = new JLabel();
        panel.add(emptyLabel);
        
        JButton loginButton = new JButton("Login");
        loginButton.setFocusPainted(false);
        loginButton.setBackground(new Color(0xfcca00));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        panel.add(loginButton);
        
        return panel;
    }
    
    public JPanel createSamPnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());   
        panel.setBackground(Japps.getJPanelColor());
        JLabel studentaccessmoduleLabel = new JLabel("Student Access Module");
        studentaccessmoduleLabel.setForeground(Color.WHITE);
        Font font = studentaccessmoduleLabel.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), 15);
        studentaccessmoduleLabel.setFont(newFont);
        studentaccessmoduleLabel.setHorizontalAlignment(JLabel.CENTER);
        studentaccessmoduleLabel.setVerticalAlignment(JLabel.CENTER);
        panel.add(studentaccessmoduleLabel);
            
        return panel;
    }
}
