package com.mycompany.japps;
import static com.mycompany.japps.Japps.cardPanel;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
/**
 *
 * Codes to be used:
 * - Java JDBC
 * - https://stackoverflow.com/questions/13368103/jpanel-drop-shadow
 */
public class LoginPage extends JPanel{
    
    
    public LoginPage(JPanel cardPanel, CardLayout cardLayout) {
     JPanel loginPagePnl = createLoginPagePnl();   
     JPanel northPnl = createNorthPnl();
     loginPagePnl.add(northPnl, BorderLayout.NORTH);
     
     JPanel centerPnl = createCenterPnl(cardPanel, cardLayout);   
     loginPagePnl.add(centerPnl, BorderLayout.CENTER);
     
     JPanel southPnl = createSouthPnl(cardPanel, cardLayout);
     loginPagePnl.add(southPnl, BorderLayout.SOUTH);
     
     this.setBackground(Japps.getJFrameColor());
     this.setLayout(new GridBagLayout()); 
     this.add(loginPagePnl, new GridBagConstraints());  
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
    
    public JPanel createNorthPnl() {
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
    
    public JPanel createCenterPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(8,1));
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
        
        panel.add(Box.createRigidArea(new Dimension(0, 0)));
        
        JButton loginButton = new JButton("Login");
        loginButton.setFocusPainted(false);
        loginButton.setBackground(new Color(0xfcca00));
        loginButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
       
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameTextField.getText();
                String password = new String(usernamePWField.getPassword());
 
                if (login(username, password)) {
                   cardLayout.show(cardPanel, "newsLetterPnl");  
                } else {
                    JOptionPane.showMessageDialog(LoginPage.this, "Incorrect Username or Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        panel.add(loginButton);  
        
        return panel;
    }
    
    public JPanel createSouthPnl(JPanel cardPanel, CardLayout cardLayout) {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(2,1));
        
        JButton forgotButton = new JButton("<html><u>Forgot Password? Click me!</u></html>");
        forgotButton.setBackground(new Color(0, 0, 0, 0));
        forgotButton.setForeground(Color.WHITE);
        forgotButton.setOpaque(false);
        forgotButton.setBorder(BorderFactory.createEmptyBorder());
        panel.add(forgotButton);

        JPanel signUpPanel = new JPanel();
        signUpPanel.setBackground(Japps.getJPanelColor());
        signUpPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 0));

        JLabel signUpLabel = new JLabel("Don't have an account? ");
        signUpLabel.setForeground(Color.WHITE);
        signUpPanel.add(signUpLabel);

        JButton signUpButton = new JButton("<html><u>Sign Up</u></html>");
        signUpButton.setForeground(Color.WHITE);
        signUpButton.setBackground(new Color(0, 0, 0, 0));
        signUpButton.setOpaque(false);
        signUpButton.setBorder(BorderFactory.createEmptyBorder());
        signUpPanel.add(signUpButton);
        
        //added action listener to signUpButton to direct to registration
        signUpButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                cardLayout.show(cardPanel, "registerPnl");    
            }
        });

        panel.add(signUpPanel);
        panel.setBackground(Japps.getJPanelColor());
        
        return panel;
    }
    
    public boolean login(String username, String password) {
        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix"; // Replace dbname with your actual database name
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {
            String query = "SELECT * FROM tbluser WHERE username = ?";
            PreparedStatement statement = conn.prepareStatement(query);
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String storedPassword = resultSet.getString("password");
                if (password.equals(storedPassword)) {
                    // User is authenticated
                    return true;
                }
            }

            // Invalid username or password
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            // Handle any potential database errors
            return false;
        }
    }

    
    
}
