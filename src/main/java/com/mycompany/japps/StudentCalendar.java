/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.japps;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class StudentCalendar extends JPanel {
    private JLabel monthLabel;
    private JTextArea eventTextArea;
    private int currentMonth;
    private int currentYear;

    public StudentCalendar(JPanel cardPanel, CardLayout cardLayout) {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());

        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(), BorderLayout.CENTER);

        this.setSize(Japps.getGUIWidth(), Japps.getGUIHeight());
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
        panel.setLayout(new BorderLayout());
        JPanel titlePnl = createTitlePnl();
        panel.add(titlePnl, BorderLayout.NORTH);

        panel.add(createCalendarPanel(), BorderLayout.CENTER);

        setCurrentDate();

        return panel;
    }

    public JPanel createCalendarPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Create the month label
        monthLabel = new JLabel("", JLabel.CENTER);
        updateMonthLabel();

        // Create the text area for displaying events
        eventTextArea = new JTextArea();
        eventTextArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(eventTextArea);

        // Create the panel for month navigation buttons
        JPanel navPanel = new JPanel(new FlowLayout());
        JButton prevButton = new JButton("Previous");
        prevButton.addActionListener(e -> {
            if (currentMonth == 0) {
                currentMonth = 11;
                currentYear--;
            } else {
                currentMonth--;
            }
            updateMonthLabel();
            updateEventTextArea();
        });
        navPanel.add(prevButton);

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(e -> {
            if (currentMonth == 11) {
                currentMonth = 0;
                currentYear++;
            } else {
                currentMonth++;
            }
            updateMonthLabel();
            updateEventTextArea();
        });
        navPanel.add(nextButton);

        // Add components to the panel
        panel.add(monthLabel, BorderLayout.NORTH);
        panel.add(scrollPane, BorderLayout.CENTER);
        panel.add(navPanel, BorderLayout.SOUTH);

        return panel;
    }

    private void setCurrentDate() {
        // Get current month and year
        currentMonth = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        currentYear = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);

        // Update the month label and event text area
        updateMonthLabel();
        updateEventTextArea();
    }

    private void updateMonthLabel() {
        DateFormat dateFormat = new SimpleDateFormat("MMMM yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set(currentYear, currentMonth, 1);
        monthLabel.setText(dateFormat.format(cal.getTime()));
    }

    private void updateEventTextArea() {
        // Clear the event text area
        eventTextArea.setText("");

        // Retrieve events from the database for the current month and year
        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbhelix", "root", "");
            String query = "SELECT * FROM tblcalendar WHERE month = ? AND year = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, currentMonth + 1); // Month in Calendar starts from 0, so add 1
            statement.setInt(2, currentYear);
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                int day = resultSet.getInt("day");
                String event = resultSet.getString("event");
                eventTextArea.append(day + ": " + event + "\n");
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }



}
