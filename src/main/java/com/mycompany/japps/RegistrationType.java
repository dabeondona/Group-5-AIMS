/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class RegistrationType extends JPanel {
    private int type;
    public JComboBox<String> cbbType;
    public JTextField tfLastName;
    public JTextField tfFirstName;
    public JTextField tfMiddleName;
    public JTextField tfSuffix;
    public JTextField tfHomeAddress;
    public JComboBox cbbRegion;
    public JComboBox cbbProvince;
    public JComboBox cbbMunicipality;
    public JComboBox cbbBarangay;
    public JTextField tfContactNumber;
   public JTextField tfDateOfBirth;
   public JTextField tfPlaceOfBirth;
    public JComboBox cbbMaritalStatus;
   public JTextField tfEmail;
    public JTextField tfReligion;
    public JTextField tfCitizenship;
    public JComboBox cbbBloodType;
    
    
    public void setType(int type){
        this.type = type;
    }
    
    public int getType(){
        return type;
    }
    
    public RegistrationType(JPanel cardPanel, CardLayout cardLayout){
        JPanel createTypePnl = createTypePnl();
        JPanel personalInfoLblPnl = personalInfoLblPnl();
        createTypePnl.add(personalInfoLblPnl, BorderLayout.NORTH);
        JPanel createNamePnl = createNamePnl();
        createTypePnl.add(createNamePnl, BorderLayout.CENTER);
        /*JPanel createAddressPnl = createAddressPnl();
        createTypePnl.add(createAddressPnl, BorderLayout.AFTER_LAST_LINE);*/
        
        JPanel panel = new JPanel();
        panel.setBackground(Japps.getJPanelColor());
        
        JButton btnNext = new JButton("Next");
        btnNext.setFocusPainted(false);
        btnNext.setBackground(new Color(0xfcca00));
        btnNext.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
        
        //for the button
        btnNext.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                Connection connection = null;
                if(isFormValid()){
                    try {
                    String url = "jdbc:mysql://localhost:3306/dbHelix";
                    String username = "root";
                    String password = "";

                    connection = DriverManager.getConnection(url, username, password);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Handle connection error
                        return;
                    }

                    // Prepare SQL statement
                    String sql = "INSERT INTO `tblregister` (`lastName`, `firstName`, `middleName`, `suffix`, `homeAddress`, `region`, `province`, `municipality`, `contactNumber`, `dateOfBirth`, `placeOfBirth`, `maritalStatus`, `email`, `religion`, `citizenship`,  `bloodType`) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

                    try (PreparedStatement statement = connection.prepareStatement(sql)) {
                        // Bind input values to the prepared statement
                        statement.setString(1, tfLastName.getText());
                        statement.setString(2, tfFirstName.getText());
                        statement.setString(3, tfMiddleName.getText());
                        statement.setString(4, tfSuffix.getText());
                        statement.setString(5, tfHomeAddress.getText());
                        statement.setString(6, cbbRegion.getSelectedItem().toString());
                        statement.setString(7, cbbProvince.getSelectedItem().toString());
                        statement.setString(8, cbbMunicipality.getSelectedItem().toString());
                        //statement.setString(9, cbbBarangay.getSelectedItem().toString());
                        statement.setString(9, tfContactNumber.getText());
                        statement.setString(10, tfDateOfBirth.getText());
                        statement.setString(11, tfPlaceOfBirth.getText());
                        statement.setString(12, cbbMaritalStatus.getSelectedItem().toString());
                        statement.setString(13, tfEmail.getText());
                        statement.setString(14, tfReligion.getText());
                        statement.setString(15, tfCitizenship.getText());
                        statement.setString(16, cbbBloodType.getSelectedItem().toString());

                        // Execute the SQL statement
                        statement.executeUpdate();

                        // Close the statement and connection
                        statement.close();
                        connection.close();

                        // Provide feedback to the user (e.g., success message)
                        JOptionPane.showMessageDialog(panel, "Data inserted successfully!");

                        // Perform any additional actions or navigate to the next card in the CardLayout
                        cardLayout.show(cardPanel, "adminReg"); 
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        // Handle SQL error
                    }
                    
                    if (cbbType.getSelectedIndex() != -1) {
                    String selectedOption = cbbType.getSelectedItem().toString();

                        if (selectedOption.equals("Student")) {
                            cardLayout.show(cardPanel, "studentReg");
                        } else if (selectedOption.equals("Admin")) {
                            cardLayout.show(cardPanel, "adminReg");
                        } else if(selectedOption.equals("")){
                            JOptionPane.showMessageDialog(panel, "Select type!");
                        }
                    }
                } else{
                                JOptionPane.showMessageDialog(panel, "Please fill in all required fields.");

                }
                
                
                
                
            }
        });

        panel.add(btnNext);
        
        createTypePnl.add(panel, BorderLayout.SOUTH);
        
        
        
        this.setBackground(Japps.getJFrameColor());
        this.setLayout(new GridBagLayout()); 
        this.add(createTypePnl, new GridBagConstraints());  
    }
    
    public JPanel createTypePnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        javax.swing.border.Border padding = BorderFactory.createEmptyBorder(20,20,20,20);
        javax.swing.border.Border line = BorderFactory.createLineBorder(Color.BLACK, 1);
        javax.swing.border.Border border = BorderFactory.createCompoundBorder(line, padding);
        panel.setBackground(Japps.getJFrameColor());
        panel.setBorder(border);
        return panel;
    }
    
    public JPanel createNamePnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 4));
        panel.setBackground(Japps.getJPanelColor());
        
        
        //type and combobox
        JLabel lblType = new JLabel("Type:");
        lblType.setForeground(Color.WHITE);
        panel.add(lblType);
        cbbType = new PillComboBox(strType());
        panel.add(cbbType);
        panel.add(new JLabel(""));
        panel.add(new JLabel(""));
        //labels
        JLabel lblLastName = new JLabel("Last Name:");
        lblLastName.setForeground(Color.WHITE);
        panel.add(lblLastName);
        JLabel lblFirstName = new JLabel("First Name:");
        lblFirstName.setForeground(Color.WHITE);
        panel.add(lblFirstName);
        JLabel lblMiddleName = new JLabel("Middle Name:");
        lblMiddleName.setForeground(Color.WHITE);
        panel.add(lblMiddleName);
        JLabel lblSuffix = new JLabel("Suffix:");
        lblSuffix.setForeground(Color.WHITE);
        panel.add(lblSuffix);
        
        //inputs
        tfLastName = new PillTextField(10);
        panel.add(tfLastName);
        tfFirstName = new PillTextField(10);
        panel.add(tfFirstName);
        tfMiddleName = new PillTextField(10);
        panel.add(tfMiddleName);
        tfSuffix = new PillTextField(10);
        panel.add(tfSuffix);
        
        JLabel lblHomeAddress = new JLabel("Home Address:");
        lblHomeAddress.setForeground(Color.WHITE);
        panel.add(lblHomeAddress);
        JLabel lblRegion = new JLabel("Region:");
        lblRegion.setForeground(Color.WHITE);
        panel.add(lblRegion);
        JLabel lblProvince = new JLabel("Province:");
        lblProvince.setForeground(Color.WHITE);
        panel.add(lblProvince);
        JLabel lblMunicipality = new JLabel("Municipality:");
        lblMunicipality.setForeground(Color.WHITE);
        panel.add(lblMunicipality);
        
        //inputs
        tfHomeAddress = new PillTextField(10);
        panel.add(tfHomeAddress);
        cbbRegion = new PillComboBox(strRegion());
        panel.add(cbbRegion);
        cbbProvince = new PillComboBox(strRegion());
        panel.add(cbbProvince);
        cbbMunicipality = new PillComboBox(strRegion());
        panel.add(cbbMunicipality);
        
        JLabel lblContactNumber = new JLabel("Contact Number: ");
        lblContactNumber.setForeground(Color.WHITE);
        panel.add(lblContactNumber);
        JLabel lblDateOfBirth = new JLabel("Date of Birth:");
        lblDateOfBirth.setForeground(Color.WHITE);
        panel.add(lblDateOfBirth);
        JLabel lblPlaceOfBirth = new JLabel("Place of Birth:");
        lblPlaceOfBirth.setForeground(Color.WHITE);
        panel.add(lblPlaceOfBirth);
        JLabel lblMaritalStatus = new JLabel("Marital Status: ");
        lblMaritalStatus.setForeground(Color.WHITE);
        panel.add(lblMaritalStatus);
        
        //row2
        tfContactNumber = new PillTextField(10);
        panel.add(tfContactNumber);
        tfDateOfBirth = new PillTextField(10);
        panel.add(tfDateOfBirth);
        tfPlaceOfBirth = new PillTextField(10);
        panel.add(tfPlaceOfBirth);
        cbbMaritalStatus = new PillComboBox(strMaritalStatus());
        panel.add(cbbMaritalStatus);
        
        //row3
        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setForeground(Color.WHITE);
        panel.add(lblEmail);
        JLabel lblReligion = new JLabel("Religion:");
        lblReligion.setForeground(Color.WHITE);
        panel.add(lblReligion);
        JLabel lblCitizenship = new JLabel("Citizenship");
        lblCitizenship.setForeground(Color.WHITE);
        panel.add(lblCitizenship);
        JLabel lblBloodType = new JLabel("Blood Type:");
        lblBloodType.setForeground(Color.WHITE);
        panel.add(lblBloodType);
        
        //row 4
        tfEmail = new PillTextField(10);
        panel.add(tfEmail);
        tfReligion = new PillTextField(10);
        panel.add(tfReligion);
        tfCitizenship = new PillTextField(10);
        panel.add(tfCitizenship);
        cbbBloodType = new PillComboBox(strBloodType());
        panel.add(cbbBloodType);
        
        
        
        
        return panel;
    }
    
    

    
    
    
    public JPanel personalInfoLblPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());   
        panel.setBackground(Japps.getJPanelColor());
        JLabel lblRegistration = new JLabel("Personal Information");
        lblRegistration.setForeground(Color.WHITE);
        Font font = lblRegistration.getFont();
        Font newFont = new Font(font.getName(), font.getStyle(), 15);
        lblRegistration.setFont(newFont);
        lblRegistration.setHorizontalAlignment(JLabel.CENTER);
        lblRegistration.setVerticalAlignment(JLabel.CENTER);
        panel.add(lblRegistration);
        
            
        return panel;
    }
    
    public String[] strType(){
        String type[] = {"","Student","Admin"};
        return type;
    }
    
    public String[] strRegion(){
        String[] regions = {
            "",
            "Region I",
            "Region II",
            "Region III",
            "Region IV‑A",
            "MIMAROPA Region",
            "Region V",
            "Region VI",
            "Region VII",
            "Region VIII",
            "Region IX",
            "Region X",
            "Region XI",
            "Region XII",
            "Region XIII",
            "NCR",
            "CAR",
            "BARMM"
        };
        return regions;
    }
    
    public String[] strMaritalStatus(){
        String[] maritalStatus = {
            "",
            "Single",
            "Married",
            "Divorced",
            "Separated",
            "Widowed",
            "Registered Partnership"
        };
        return maritalStatus;
    }
    
    public String[] strBloodType(){
        String[] blood = {
            "",
            "A",
            "A Negative",
            "A Positive",
            "AB",
            "AB Positive",
            "AB Negative",
            "B",
            "B Negative",
            "B Positive",
            "O",
            "O Negative",
            "O Positive"
        };
        return blood;
    }
    
    private boolean isFormValid() {
        if (tfLastName.getText().isEmpty() ||
                tfFirstName.getText().isEmpty() ||
                tfMiddleName.getText().isEmpty() ||
                tfSuffix.getText().isEmpty() ||
                tfHomeAddress.getText().isEmpty() ||
                cbbRegion.getSelectedIndex() == -1 || cbbRegion.getSelectedIndex() == 0 ||
                cbbProvince.getSelectedIndex() == -1 || cbbProvince.getSelectedIndex() == 0 ||
                cbbMunicipality.getSelectedIndex() == -1 || cbbMunicipality.getSelectedIndex() == 0 ||
                tfContactNumber.getText().isEmpty() ||
                tfDateOfBirth.getText().isEmpty() ||
                tfPlaceOfBirth.getText().isEmpty() ||
                cbbMaritalStatus.getSelectedIndex() == -1 || cbbMaritalStatus.getSelectedIndex() == 0 ||
                tfEmail.getText().isEmpty() ||
                tfReligion.getText().isEmpty() ||
                tfCitizenship.getText().isEmpty() ||
                cbbBloodType.getSelectedIndex() == -1 || cbbBloodType.getSelectedIndex() == 0) {
            return false;
        }
        return true;
    }
}
