/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author keisamae
 */



public class Registration extends JFrame{
    JPanel pnlTopBanner, pnlCenter, pnlFirst, pnlFirstDept, pnllblName, pnlName, pnlSecond, pnllblHomeAddress, pnlHAAddress, pnlThird, pnllblCityAddress, pnlSame, pnlCAAddress, pnlFourth, pnlGender, pnlSouth;
    JLabel lblTopBanner, lblClassi, lblDep, lblProgram, lblYear, lblName, lblFamilyName, lblFirstName, lblMiddleName, lblSuffix, lblHomeAddress, lblRegion, lblProvince, lblMunicipality, lblNumber, lblCityAddress, lblDateofBirth, lblPlaceofBirth, lblAge, lblMaritalStatus, lblMobileNumber, lblEmail, lblReligion, lblCitizenship, lblGender;
    JComboBox cbClassification, cbDepartment, cbProgram, cbYear, cbHARegion, cbHAProvince, cbHAMunicipality, cbCARegion, cbCAProvince, cbCAMunicipality, cbMaritalStatus, cbReligion, cbCitizenship, cbGender;
    JTextField tfFirstName, tfFamilyName, tfMiddleName, tfSuffix, tfHomeAddress, tfHAContactNumber, tfCAContactNumber, tfCityAddress, tfDateofBirth, tfPlaceofBirth, tfAge, tfMobileNumber, tfEmail;
    JCheckBox chbSame;
    JButton btnRegister;
    
    
    public Registration(){
        setTitle("Student Registration");
        setSize(500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        pnlTopBanner = new JPanel();
        pnlTopBanner.setBackground(Color.RED);
        
            lblTopBanner = new JLabel("Personal Information");
        
        pnlTopBanner.add(lblTopBanner);
        
        add(pnlTopBanner, BorderLayout.NORTH);
        
        pnlCenter = new JPanel();
        pnlCenter.setLayout(new BoxLayout(pnlCenter, BoxLayout.Y_AXIS));
        pnlCenter.setBackground(Color.PINK);
        
            //firstpanel in the center
            pnlFirst = new JPanel();
            pnlFirst.setLayout(new BoxLayout(pnlFirst, BoxLayout.Y_AXIS));
            pnlFirst.setBackground(Color.YELLOW);

                pnlFirstDept = new JPanel(new GridLayout(2, 4));
                pnlFirstDept.setBackground(Color.BLUE);

                    lblClassi = new JLabel("Classification");
                    lblDep= new JLabel("Department");
                    lblProgram = new JLabel("Program");
                    lblYear = new JLabel("Year Label");
                    String classification[] = {"Freshman", "Sophomore", "Junior", "Senior"};
                    String department[] = {"Baccalaureate", "ETEAAP"};
                    String program[] = {"Bachelor of Science in Information Technology", "Bachelor of Science in Computer Science"};
                    String year[] = {"First Year", "Second Year", "Third Year", "F\");\n" +
"ourth Year", "Fifth Year"};

                    cbClassification = new JComboBox(classification);         
                    cbDepartment = new JComboBox(department);       
                    cbProgram = new JComboBox(program);        
                    cbYear = new JComboBox(year);


                    pnlFirstDept.add(lblClassi);
                    pnlFirstDept.add(lblDep);
                    pnlFirstDept.add(lblProgram);
                    pnlFirstDept.add(lblYear);

                    pnlFirstDept.add(cbClassification);
                    pnlFirstDept.add(cbDepartment);
                    pnlFirstDept.add(cbProgram);
                    pnlFirstDept.add(cbYear);

                pnllblName = new JPanel(new FlowLayout(FlowLayout.LEFT));
                    lblName = new JLabel("Name:");
                pnllblName.add(lblName);

                pnlName = new JPanel(new GridLayout(2, 4));
                pnlName.setBackground(Color.GRAY);

                   tfFamilyName = new JTextField();
                   tfFirstName = new JTextField();
                   tfMiddleName = new  JTextField();
                   tfSuffix = new JTextField();

                   lblFamilyName = new JLabel("Family Name");
                   lblFirstName = new JLabel("First Name");
                   lblMiddleName = new JLabel("Middle Name");
                   lblSuffix = new JLabel("Suffix");

                   pnlName.add(tfFamilyName);
                   pnlName.add(tfFirstName);
                   pnlName.add(tfMiddleName);
                   pnlName.add(tfSuffix);

                   pnlName.add(lblFamilyName);
                   pnlName.add(lblFirstName);
                   pnlName.add(lblMiddleName);
                   pnlName.add(lblSuffix);

            pnlFirst.add(pnlFirstDept);
            pnlFirst.add(pnllblName);
            pnlFirst.add(pnlName);
            
            //second panel in center
            pnlSecond = new JPanel();
            pnlSecond.setLayout(new BoxLayout(pnlSecond, BoxLayout.Y_AXIS));
            
                    pnllblHomeAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
                       lblHomeAddress = new JLabel("Home Address:");
                    pnllblHomeAddress.add(lblHomeAddress);

                    tfHomeAddress = new JTextField();

                    pnlHAAddress = new JPanel(new GridLayout(2, 4));
                    
                    String[] places = {"dxhbfk", "khsdfj", "fjhsdvbfujh"};
                    
                        cbHARegion = new JComboBox(places);
                        cbHAProvince = new JComboBox(places);
                        cbHAMunicipality = new JComboBox(places);
                        tfHAContactNumber = new JTextField();
                        
                        lblRegion = new JLabel("Region");
                        lblProvince = new JLabel("Province");
                        lblMunicipality = new JLabel("Municipality");
                        lblNumber = new JLabel("Tel No. / Mobile Number");
                    
                    pnlHAAddress.add(cbHARegion);
                    pnlHAAddress.add(cbHAProvince);
                    pnlHAAddress.add(cbHAMunicipality);
                    pnlHAAddress.add(tfHAContactNumber);
                    
                    pnlHAAddress.add(lblRegion);
                    pnlHAAddress.add(lblProvince);
                    pnlHAAddress.add(lblMunicipality);
                    pnlHAAddress.add(lblNumber);
             
            pnlSecond.add(pnllblHomeAddress);
            pnlSecond.add(tfHomeAddress);
            pnlSecond.add(pnlHAAddress);
         
            pnlThird = new JPanel();
            pnlThird.setLayout(new BoxLayout(pnlThird, BoxLayout.Y_AXIS));
            
                    pnllblCityAddress = new JPanel(new FlowLayout(FlowLayout.LEFT));
                       lblCityAddress = new JLabel("City Address:");
                    pnllblCityAddress.add(lblCityAddress);
                    
                    pnlSame = new JPanel(new FlowLayout(FlowLayout.LEFT));
                        chbSame = new JCheckBox("Same as Permanent Home Address");
                    pnlSame.add(chbSame);
                    
                    tfCityAddress = new JTextField();

                    pnlCAAddress = new JPanel(new GridLayout(2, 4));
                    
                        cbCARegion = new JComboBox(places);
                        cbCAProvince = new JComboBox(places);
                        cbCAMunicipality = new JComboBox(places);
                        tfCAContactNumber = new JTextField();
                        
                        lblRegion = new JLabel("Region");
                        lblProvince = new JLabel("Province");
                        lblMunicipality = new JLabel("Municipality");
                        lblNumber = new JLabel("Tel No. / Mobile Number");
                    
                    pnlCAAddress.add(cbCARegion);
                    pnlCAAddress.add(cbCAProvince);
                    pnlCAAddress.add(cbCAMunicipality);
                    pnlCAAddress.add(tfCAContactNumber);
                    
                    pnlCAAddress.add(lblRegion);
                    pnlCAAddress.add(lblProvince);
                    pnlCAAddress.add(lblMunicipality);
                    pnlCAAddress.add(lblNumber);
             
            pnlThird.add(pnllblCityAddress);
            pnlThird.add(pnlSame);
            pnlThird.add(tfCityAddress);
            pnlThird.add(pnlCAAddress);
        
            pnlFourth = new JPanel(new GridLayout(4,4));
            
                lblDateofBirth = new JLabel("Date of Birth");
                lblPlaceofBirth = new JLabel("Place of Birth");
                lblAge = new JLabel("Age");
                lblMaritalStatus = new  JLabel("Marital Status");
                tfDateofBirth = new JTextField();
                tfPlaceofBirth = new JTextField();
                tfAge = new JTextField();
                cbMaritalStatus = new JComboBox(places);
                lblMobileNumber = new JLabel("Mobile Number");
                lblEmail = new JLabel("Email");
                lblReligion = new JLabel("Religion");
                lblCitizenship = new JLabel("Citizenship");
                tfMobileNumber = new JTextField();
                tfEmail = new JTextField();
                cbReligion = new JComboBox(places);
                cbCitizenship = new JComboBox(places);
            
            pnlFourth.add(lblDateofBirth);
            pnlFourth.add(lblPlaceofBirth);
            pnlFourth.add(lblAge);
            pnlFourth.add(lblMaritalStatus);
            pnlFourth.add(tfDateofBirth);
            pnlFourth.add(tfPlaceofBirth);
            pnlFourth.add(tfAge);
            pnlFourth.add(cbMaritalStatus);
            pnlFourth.add(lblMobileNumber);
            pnlFourth.add(lblEmail);
            pnlFourth.add(lblReligion);
            pnlFourth.add(lblCitizenship);
            pnlFourth.add(tfMobileNumber);
            pnlFourth.add(tfEmail);
            pnlFourth.add(cbReligion);
            pnlFourth.add(cbCitizenship);
            
            pnlGender = new JPanel(new GridLayout(2, 1));
                lblGender = new JLabel("Gender");
                cbGender = new JComboBox(places);
            
            pnlGender.add(lblGender);
            pnlGender.add(cbGender);
                    
            
            
            
        pnlCenter.add(pnlFirst);
        pnlCenter.add(pnlSecond);
        pnlCenter.add(pnlThird);
        pnlCenter.add(pnlFourth);
        pnlCenter.add(pnlGender);
        
        add(pnlCenter, BorderLayout.CENTER);

        pnlSouth = new JPanel(new FlowLayout(FlowLayout.RIGHT));
            btnRegister = new JButton("Register");
            
            RegisterButtonActionListener registerButtonActionListener = new RegisterButtonActionListener();
            btnRegister.addActionListener(registerButtonActionListener);
     
        pnlSouth.add(btnRegister);
        
        add(pnlSouth, BorderLayout.SOUTH);
        
    }
}

