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
            String[] options = {"View Events", "Add Event", "Update Event", "Delete Event"};
            int choice = JOptionPane.showOptionDialog(Calendar.this, "Select an action for day " + day + ":", "Options",
                    JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

            switch (choice) {
                case 0:
                    viewEvents(day);
                    break;
                case 1:
                    String event = JOptionPane.showInputDialog(Calendar.this, "Add event for day " + day + ":");
                    if (event != null && !event.isEmpty()) {
                        addEventToDatabase(day, event);
                        JOptionPane.showMessageDialog(Calendar.this, "Event added: " + event);
                        updateDayButtons();
                    }
                    break;
                case 2:
                    updateEvent(day);
                    break;
                case 3:
                    deleteEvent(day);
                    break;
                default:
                    break;
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

    
    private void viewEvents(int day) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            String query = "SELECT event FROM tblcalendar WHERE day = ? AND month = ? AND year = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, day);
            statement.setInt(2, currentMonth + 1); // Month in Calendar starts from 0, so add 1
            statement.setInt(3, currentYear);
            ResultSet resultSet = statement.executeQuery();

            StringBuilder events = new StringBuilder();
            while (resultSet.next()) {
                String event = resultSet.getString("event");
                events.append(event).append("\n");
            }

            if (events.length() > 0) {
                JOptionPane.showMessageDialog(Calendar.this, "Events for day " + day + ":\n" + events.toString());
            } else {
                JOptionPane.showMessageDialog(Calendar.this, "No events found for day " + day);
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void updateEvent(int day) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            String query = "SELECT event FROM tblcalendar WHERE day = ? AND month = ? AND year = ?";
            PreparedStatement selectStatement = connection.prepareStatement(query);
            selectStatement.setInt(1, day);
            selectStatement.setInt(2, currentMonth + 1); // Month in Calendar starts from 0, so add 1
            selectStatement.setInt(3, currentYear);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String currentEvent = resultSet.getString("event");
                String newEvent = JOptionPane.showInputDialog(Calendar.this, "Update event for day " + day + ":", currentEvent);

                if (newEvent != null && !newEvent.isEmpty()) {
                    String updateQuery = "UPDATE tblcalendar SET event = ? WHERE day = ? AND month = ? AND year = ?";
                    PreparedStatement updateStatement = connection.prepareStatement(updateQuery);
                    updateStatement.setString(1, newEvent);
                    updateStatement.setInt(2, day);
                    updateStatement.setInt(3, currentMonth + 1); // Month in Calendar starts from 0, so add 1
                    updateStatement.setInt(4, currentYear);
                    updateStatement.executeUpdate();
                    updateStatement.close();

                    JOptionPane.showMessageDialog(Calendar.this, "Event updated: " + newEvent);
                }
            } else {
                JOptionPane.showMessageDialog(Calendar.this, "No event found for day " + day);
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
    private void deleteEvent(int day) {
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            String query = "SELECT event FROM tblcalendar WHERE day = ? AND month = ? AND year = ?";
            PreparedStatement selectStatement = connection.prepareStatement(query);
            selectStatement.setInt(1, day);
            selectStatement.setInt(2, currentMonth + 1); // Month in Calendar starts from 0, so add 1
            selectStatement.setInt(3, currentYear);
            ResultSet resultSet = selectStatement.executeQuery();

            if (resultSet.next()) {
                String event = resultSet.getString("event");
                int choice = JOptionPane.showConfirmDialog(Calendar.this, "Delete event:\n" + event, "Confirmation", JOptionPane.YES_NO_OPTION);

                if (choice == JOptionPane.YES_OPTION) {
                    String deleteQuery = "DELETE FROM tblcalendar WHERE day = ? AND month = ? AND year = ?";
                    PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery);
                    deleteStatement.setInt(1, day);
                    deleteStatement.setInt(2, currentMonth + 1); // Month in Calendar starts from 0, so add 1
                    deleteStatement.setInt(3, currentYear);
                    deleteStatement.executeUpdate();
                    deleteStatement.close();

                    JOptionPane.showMessageDialog(Calendar.this, "Event deleted: " + event);
                }
            } else {
                JOptionPane.showMessageDialog(Calendar.this, "No event found for day " + day);
            }

            resultSet.close();
            selectStatement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }






}
