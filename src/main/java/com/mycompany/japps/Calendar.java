/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

/**
 *
 * @author alest
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Calendar extends JPanel{
    private JLabel monthLabel;
    private JButton[] dayButtons;
    private int currentMonth;
    private int currentYear;
    
    public Calendar(JPanel cardPanel, CardLayout cardLayout){
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
        
        JLabel titleLabel = new JLabel("Calendar of Events");
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

        panel.add(calendarDetPnl());
        
        setCurrentDate();
        
        
        
        
        return panel;
    }
    
    public JPanel calendarDetPnl(){
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        // Create the month label
        monthLabel = new JLabel("", JLabel.CENTER);
        updateMonthLabel();

        // Create the panel for the day buttons
        JPanel dayPanel = new JPanel(new GridLayout(0, 7));
        dayButtons = new JButton[31]; // Assuming maximum of 31 days in a month
        for (int i = 0; i < dayButtons.length; i++) {
            dayButtons[i] = new JButton("");
            dayButtons[i].addActionListener(new DayButtonListener(i + 1));
            dayPanel.add(dayButtons[i]);
        }

        // Create the panel for month navigation buttons
        JPanel navPanel = new JPanel(new FlowLayout());
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentMonth == 0) {
                    currentMonth = 11;
                    currentYear--;
                } else {
                    currentMonth--;
                }
                updateMonthLabel();
                updateDayButtons();
            }
        });
        navPanel.add(prevButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (currentMonth == 11) {
                    currentMonth = 0;
                    currentYear++;
                } else {
                    currentMonth++;
                }
                updateMonthLabel();
                updateDayButtons();
            }
        });
        navPanel.add(nextButton);

        // Add components to the frame
        panel.add(monthLabel, BorderLayout.NORTH);
        panel.add(dayPanel, BorderLayout.CENTER);
        panel.add(navPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private void setCurrentDate() {
        // Get current month and year
        currentMonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        // Update the month label and day buttons
        updateMonthLabel();
        updateDayButtons();
    }

    private void updateMonthLabel() {
        java.text.DateFormat dateFormat = new java.text.SimpleDateFormat("MMMM yyyy");
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(currentYear, currentMonth, 1);
        monthLabel.setText(dateFormat.format(cal.getTime()));
    }

    private void updateDayButtons() {
        java.util.Calendar cal = java.util.Calendar.getInstance();
        cal.set(currentYear, currentMonth, 1);
        int maxDay = cal.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);

        for (int i = 0; i < dayButtons.length; i++) {
            if (i < maxDay) {
                dayButtons[i].setText(String.valueOf(i + 1));
                dayButtons[i].setEnabled(true);
            } else {
                dayButtons[i].setText("");
                dayButtons[i].setEnabled(false);
            }
        }
    }

    private class DayButtonListener implements ActionListener {
        private int day;

        public DayButtonListener(int day) {
            this.day = day;
        }

        public void actionPerformed(ActionEvent e) {
            // Open a dialog to add an event for the selected day
            String event = JOptionPane.showInputDialog(Calendar.this, "Add event for day " + day + ":");
            if (event != null && !event.isEmpty()) {
                // Add the event to the database
                addEventToDatabase(day, event);
                JOptionPane.showMessageDialog(Calendar.this, "Event added: " + event);
                updateDayButtons(); // Refresh the calendar view
            }
        }
    }
    
    private void addEventToDatabase(int day, String event) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            String query = "INSERT INTO tblcalendar (day, month, year, event) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, day);
            statement.setInt(2, currentMonth + 1); // Month in Calendar starts from 0, so add 1
            statement.setInt(3, currentYear);
            statement.setString(4, event);
            statement.executeUpdate();

            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    



}
