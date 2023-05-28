package com.mycompany.japps;
import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.border.*;

public class NewsLetter extends JPanel {
    TopPanelButtons topPnlButtons;

    public NewsLetter(JPanel cardPanel, CardLayout cardLayout) {
        this.setName(Japps.getGUIName());
        this.setLayout(new BorderLayout());

        this.add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        this.add(createMiddlePnl(), BorderLayout.CENTER);

        this.setSize(Japps.getGUIWidth(), Japps.getGUIHeight());
        this.setVisible(true);
    }

    public JPanel createTitlePnl(String month, String day, int dayInt) {
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout(FlowLayout.LEFT));

        JLabel titleLabel = new JLabel("The Technologian Newsletter");
        Font font = titleLabel.getFont();
        font = new Font(font.getName(), font.getStyle(), 35);
        titleLabel.setFont(font);
        panel.add(titleLabel);

        JPanel dateLabel = createLabelContent(month, day, dayInt);
        dateLabel.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));
        dateLabel.setForeground(new Color(0xfcca00));
        dateLabel.setBackground(new Color(0xfcca00));

        panel.setBackground(new Color(0xfcca00));
        panel.setBorder(BorderFactory.createMatteBorder(0, 0, 2, 0, Color.BLACK));
        panel.add(dateLabel);

        return panel;
    }

    public JPanel createMiddlePnl(String month, String day, int dayInt, String title, String content) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        JPanel titlePnl = createTitlePnl(month, day, dayInt);
        panel.add(titlePnl);

        panel.add(Box.createVerticalGlue());
        JLabel titleLabel = new JLabel(title);
        Font font = titleLabel.getFont();
        font = new Font(font.getName(), font.getStyle(), 25);
        titleLabel.setFont(font);
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        titleLabel.setBorder(new EmptyBorder(new Insets(25, 0, 0, 0)));
        panel.add(titleLabel);
        panel.add(Box.createVerticalGlue());

        JTextArea contentArea = new JTextArea(content);
        contentArea.setEditable(false);
        contentArea.setOpaque(false);
        contentArea.setLineWrap(true);
        contentArea.setWrapStyleWord(true);
        contentArea.setBorder(new EmptyBorder(new Insets(25, 70, 0, 70)));
        panel.add(contentArea);

        return panel;
    }

    public JPanel createLabelContent(String month, String day, int dayInt) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel label = new JLabel(new newsletterContent(month, day, dayInt).toString());
        Font font = label.getFont();
        font = new Font(font.getName(), font.getStyle(), 25);
        label.setFont(font);
        label.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));

        JLabel label2 = new JLabel(day);
        Font font2 = label2.getFont();
        font2 = new Font(font2.getName(), font2.getStyle(), 15);
        label2.setFont(font2);
        label2.setBorder(new EmptyBorder(new Insets(0, 200, 0, 0)));

        panel.add(label);
        panel.add(label2);

        return panel;
    }

    public JPanel createMiddlePnl() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        String dbUrl = "jdbc:mysql://localhost:3306/dbhelix";
        String dbUsername = "root";
        String dbPassword = "";

        try (Connection conn = DriverManager.getConnection(dbUrl, dbUsername, dbPassword)) {

            String query = "SELECT news_Month, news_Day, news_DayInt, news_Title, news_Content FROM tblnewsletter ORDER BY news_ID DESC LIMIT 1";

            PreparedStatement statement = conn.prepareStatement(query);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String month = resultSet.getString("news_Month");
                String day = resultSet.getString("news_Day");
                int dayInt = resultSet.getInt("news_DayInt");
                String title = resultSet.getString("news_Title");
                String content = resultSet.getString("news_Content");

                panel = createMiddlePnl(month, day, dayInt, title, content);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return panel;
    }
}

