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
    JPanel topBanner, topInfoPanel, centerPanel;
    JLabel lblTopBanner, lblClassification, lblDepartment, lblProgram, lblYear,lblName, lblLastName, lblFirstName, lblMiddleName, lblSuffix;
    GridBagConstraints gbc;
    JComboBox cbClassification, cbDepartment, cbProgram, cbYear;
    JTextField tfLastName, tfFirstName, tfMiddleName, tfSuffix;
    

    public Registration(){
        setTitle("Profile");
        setSize(500,500);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        topBanner = new JPanel(new FlowLayout());
        topBanner.setBackground(Color.red);
        lblTopBanner = new JLabel("Personal Information");
        topBanner.add(lblTopBanner);
        
        add(topBanner, BorderLayout.NORTH);
        
        //center na panel for all panels sa personal information part
        centerPanel = new JPanel();  
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        
        topInfoPanel = new JPanel(new GridBagLayout());
        gbc = new GridBagConstraints();
        
        //row1 topInfoPanel
        
        lblClassification = new JLabel("Classification");
        gbc.ipadx = 130;
        gbc.gridx = 0;
        gbc.gridy = 0;
        topInfoPanel.add(lblClassification, gbc);
        
        lblDepartment = new JLabel("Department");
        gbc.ipadx = 150;
        gbc.gridx = 1;
        gbc.gridy = 0;
        topInfoPanel.add(lblDepartment, gbc);
        
        lblProgram = new JLabel("Program");
        gbc.ipadx = 340;
        gbc.gridx = 2;
        gbc.gridy = 0;
        topInfoPanel.add(lblProgram, gbc);
        
        lblYear = new JLabel("Year");
        gbc.ipadx = 150;
        gbc.gridx = 3;
        gbc.gridy = 0;
        topInfoPanel.add(lblYear, gbc);

        //row 2 topInfoPanel
 
        String classification[] = {"Freshman", "Sophomore", "Junior", "Senior"};
        String department[] = {"Baccalaureate", "ETEAAP"};
        String program[] = {"Bachelor of Science in Information Technology", "Bachelor of Science in Computer Science"};
        String year[] = {"First Year", "Second Year", "Third Year", "Fourth Year", "Fifth Year"};
        
        cbClassification = new JComboBox(classification);
        gbc.ipadx = 100;
        gbc.gridx = 0;
        gbc.gridy = 1;
        topInfoPanel.add(cbClassification, gbc);
        
        cbDepartment = new JComboBox(department);
        gbc.ipadx = 100;
        gbc.gridx = 1;
        gbc.gridy = 1;
        topInfoPanel.add(cbDepartment, gbc);
        
        cbProgram = new JComboBox(program);
        gbc.ipadx = 100;
        gbc.gridx = 2;
        gbc.gridy = 1;
        topInfoPanel.add(cbProgram, gbc);
        
        cbYear = new JComboBox(year);
        gbc.ipadx = 100;
        gbc.gridx = 3;
        gbc.gridy = 1;
        topInfoPanel.add(cbYear, gbc);
        
        //row 3 topInfoPanel
        lblName = new JLabel("Name:");
        gbc.ipadx = 170;
        gbc.gridx = 0;
        gbc.gridy = 2;
        topInfoPanel.add(lblName, gbc);
        
        //row 4 topInfoPanel
        tfLastName = new JTextField();
        gbc.ipadx = 200;
        gbc.gridx = 0;
        gbc.gridy = 3;
        topInfoPanel.add(tfLastName, gbc);
        
        tfFirstName = new JTextField();
        gbc.ipadx = 200;
        gbc.gridx = 1;
        gbc.gridy = 3;
        topInfoPanel.add(tfFirstName, gbc);
        
        tfMiddleName = new JTextField();
        gbc.ipadx = 200;
        gbc.gridx = 2;
        gbc.gridy = 3;
        topInfoPanel.add(tfMiddleName, gbc);
        
        tfSuffix = new JTextField();
        gbc.ipadx = 200;
        gbc.gridx = 3;
        gbc.gridy = 3;
        topInfoPanel.add(tfSuffix, gbc);
                
        //row 5 topInfoPanel
        lblLastName = new JLabel("Last Name");
        gbc.ipadx = 150;
        gbc.gridx = 0;
        gbc.gridy = 4;
        topInfoPanel.add(lblLastName, gbc);
        
        lblFirstName = new JLabel("First Name");
        gbc.ipadx = 150;
        gbc.gridx = 1;
        gbc.gridy = 4;
        topInfoPanel.add(lblFirstName, gbc);
        
        lblMiddleName = new JLabel("Middle Name");
        gbc.ipadx = 150;
        gbc.gridx = 2;
        gbc.gridy = 4;
        topInfoPanel.add(lblMiddleName, gbc);
        
        lblSuffix = new JLabel("Suffix");
        gbc.ipadx = 150;
        gbc.gridx = 3;
        gbc.gridy = 4;
        topInfoPanel.add(lblSuffix, gbc);
        
        centerPanel.add(topInfoPanel);
        add(centerPanel, BorderLayout.CENTER);
    }
}
