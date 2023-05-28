package com.mycompany.japps;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TestClass extends JFrame {

    public TestClass() {
         JFrame frame = new JFrame("GridBagLayout Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;
        constraints.weighty = 1.0;
        constraints.fill = GridBagConstraints.BOTH;

        JButton button1 = new JButton("Button 1");
        panel.add(button1, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        JButton button2 = new JButton("Button 2");
        panel.add(button2, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        JButton button3 = new JButton("Button 3");
        panel.add(button3, constraints);

        frame.getContentPane().add(panel);
        frame.pack();
        frame.setVisible(true);
    }
}

