
package com.mycompany.japps;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AdminAnnouncementGUI extends JFrame {

    public AdminAnnouncementGUI() {
        setTitle("Announcement System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel();
        mainPanel.setBackground(Color.decode("#8c383e"));
        mainPanel.setLayout(new BorderLayout());

        JPanel announcementsPanel = new JPanel();
        announcementsPanel.setLayout(new BoxLayout(announcementsPanel, BoxLayout.Y_AXIS));
        announcementsPanel.setBorder(new EmptyBorder(20, 20, 20, 20));
        announcementsPanel.setBackground(Color.WHITE);

        // Example announcements
        announcementsPanel.add(createAnnouncementPanel("Important Announcement", "May 26, 2023", "Update here"));
        announcementsPanel.add(createAnnouncementPanel("New Feature Release", "May 25, 2023", "Update here"));
        announcementsPanel.add(createAnnouncementPanel("Upcoming Maintenance", "May 24, 2023", "Update here"));

        JScrollPane scrollPane = new JScrollPane(announcementsPanel);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        setVisible(true);
    }

    private JPanel createAnnouncementPanel(String title, String date, String content) {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.decode("#F2F2F2"));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.BLACK);

        JLabel dateLabel = new JLabel(date);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        dateLabel.setForeground(Color.GRAY);

        JTextArea contentArea = new JTextArea(content);
        contentArea.setEditable(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setFont(new Font("Arial", Font.PLAIN, 14));
        contentArea.setBackground(Color.decode("#F2F2F2"));

        JButton updateButton = new JButton("Update Announcement");
        updateButton.setFont(new Font("Arial", Font.BOLD, 14));
        updateButton.setBackground(Color.WHITE);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(Color.decode("#F2F2F2"));
        buttonPanel.add(updateButton);

        panel.add(titleLabel, BorderLayout.NORTH);
        panel.add(dateLabel, BorderLayout.SOUTH);
        panel.add(new JScrollPane(contentArea), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        return panel;
    }

   
}