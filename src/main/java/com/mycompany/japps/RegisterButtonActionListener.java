/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Admin
 */

public class RegisterButtonActionListener extends JFrame implements ActionListener{
    public JDialog confirm;
    public JButton btnOK;
    
    public void actionPerformed(ActionEvent event){
        confirm = new JDialog(this, "Confirm Submission");
        confirm.setLayout(new FlowLayout());
        confirm.add(new JLabel("Confirm"));
        confirm.setVisible(true);
        confirm.setSize(100, 100);
        
        btnOK = new JButton("OK");
        confirm.add(btnOK);
    }
}
