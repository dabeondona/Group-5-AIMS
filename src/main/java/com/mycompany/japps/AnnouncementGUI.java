
package com.mycompany.japps;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class AnnouncementGUI extends JFrame {

    public AnnouncementGUI() {
        setTitle("Announcement");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        // bg color sa frame
        getContentPane().setBackground(Color.decode("#8c383e"));

        JTabbedPane tabbedPane = new JTabbedPane();

        // panels for announcement
        JPanel announcementPanel1 = createAnnouncementPanel("SELF ENROLLMENT", "*can still enroll in the school campus", "STEPS:\n" +
"\n" +
"1. Log-in in HELIX student portal: https://helix.com.ph/helix/students/\n" +
"\n" +
"2. Go to Registration tab and register all your courses.\n" +
"\n" +
"              *Enroll your courses in block sections to avoid problems with your schedule of classes.\n" +
"\n" +
"\n" +
"                  \n" +
"\n" +
"                    *Components of section name:\n" +
"\n" +
"                                      Sample section name #1:  A1-AP3\n" +
"\n" +
"                                                   A1 – BS Accountancy 1st section      \n" +
"\n" +
"                                                   AP3 –Approach 3 (at least 70% online-synchronous)\n" +
"\n" +
" \n" +
"\n" +
"\n" +
"                                       Sample section name #2:   A1/M5-AP4\n" +
"\n" +
"                                                  A1/M5 – Fused section name (BS Accountancy 1st section is fused with BS Civil Engineering 5thsection)\n" +
"\n" +
"                                                  AP4 –Approach 4 (Full face to face)\n" +
"\n" +
"                    \n" +
"\n" +
"                      *General Education Elective/ Program Elective/Foreign Language - refer to your curriculum in AIMS (Go to GRADES tab, \n" +
"\n" +
"                                        click Curriculum/Evaluation link, click print preview)\n" +
"\n" +
" \n" +
"\n" +
"\n" +
"\n" +
"3. Set the Mode of Payment.\n" +
"\n" +
"4. Submit your registered courses. \n" +
"\n" +
"5. Payment of Activation Fee*. \n" +
"\n" +
"             *Continuing students need not pay the Activation Fee. \n" +
"\n" +
"             *No need to wait for a confirmation email. \n" +
"\n" +
"             *Returnees will receive their message and HELIX account credentials from HELIX once payment is posted.\n" +
"\n" +
" \n" +
"\n" +
"\n" +
"SELF-ENROLLMENT tutorial video:     https://youtu.be/adadado\n" +
"\n" +
" \n" +
"\n" +
"\n" +
"\n" +
"\n" +
"SCHEDULE OF ENROLLMENT\n" +
"\n" +
"\n" +
"Date                        Year level\n" +
"\n" +
"Jan. 4-5, 2023\n" +
"\n" +
"4th year, 5th year, Graduating students\n" +
"\n" +
"Jan. 6-11\n" +
"\n" +
"1st year students \n" +
"\n" +
"Jan. 12-15\n" +
"\n" +
"2nd year students\n" +
"\n" +
"Jan. 16-18\n" +
"\n" +
"3rd year students\n" +
"\n" +
"Jan. 19-22\n" +
"\n" +
"All Students\n" +
"\n" +
"Start of Classes:  January 23, 2023\n" +
"");
        JPanel announcementPanel2 = createAnnouncementPanel("EASY ACCESS LINKS", "2023-05-05", "QUICK LINKS:\n" +
"\n" +
" \n" +
"\n" +
"\n" +
"Self-Enrollment Tutorial Video:   youtube.com \n" +
"\n" +
" \n" +
"\n" +
"Shifting to another program:  https://bit.ly/REQUEST-ShiftingProgram\n" +
"\n" +
" \n" +
"\n" +
"Changing/Adding/Dropping of courses: https://bit.ly/ETO-REQUEST-ChangingCourses\n" +
"\n" +
" \n" +
"\n" +
"Request to overload units: https://bit.ly/REQUEST-OverloadingUnits\n" +
"\n" +
"\n" +
"\n" +
"Proof of PAYMENT: bit.ly/SendPaymentProof \n" +
"\n" +
"  \n" +
"\n" +
"Request of documents from the University Registrar:   bit.ly/REQUEST-URO-Docus \n" +
"\n" +
"Certificate of Enrollment\n" +
"Certificate of Graduation\n" +
"Diploma\n" +
"Transcript of Records\n" +
"Certificate of Transfer Credentials/HD\n" +
"Course Accreditation:  bit.ly/CourseAccreditation\n" +
"\n" +
" \n" +
"\n" +
"Request for Good Moral Certificate: bit.ly/REQUEST-SAO-GMC\n" +
"\n" +
" \n" +
"\n" +
"ID CARD PRINTING LINK: https://bit.ly/IDPrinting-College\n" +
"\n" +
"   \n" +
"\n" +
"  \n" +
"\n" +
"FOR YOUR CONCERNS and INQUIRY, ASK HELIX!\n" +
"\n" +
"This is the link to access TINA: https://bit.ly/ASKHELIX\n" +
"\n" +
" \n" +
"\n" +
"Contact details for online enrollment:\n" +
"\n" +
"Office of Admissions and Scholarships (email: oas@helix.edu) \n" +
"\n" +
"Enrollment Technical Office (email:eto@helix.edu)\n" +
"\n" +
"Finance and Accounting Office (email:accounting@helix.edu)\n" +
"\n" +
"University Registrars Office (email:registrar@helix.edu)\n" +
"\n" +
"Student Affairs Office (email:sao@helix.edu)");
        JPanel announcementPanel3 = createAnnouncementPanel("PAY ONLINE", "*over the counter payment is also an option", "To initiate the online payment process, just click this link https://helixonlinepayment.powerappsportals.com/Payment-Portal/ \n" +
"\n" +
" \n" +
"\n" +
"Dragonpay Invoice Number = STUDENT ID NUMBER  (Ex. 22-XXXX-XXX) \n" +
"\n" +
"    \n" +
"\n" +
"   \n" +
"\n" +
"Please send your proof of payment here: bit.ly/SendPaymentProof  \n" +
"\n" +
" \n" +
"\n" +
"\n" +
"Pay ANYTIME, ANYWHERE through Palawan Pawnshops, Bayad Center, 7-Eleven Stores, RD Pawnshops, Cebuana Lhuillier,LBC, SM BILLS PAYMENT or through the other 15,000 physical partner locations of all BANKS AND NON-BANKS AFFILIATED PAYMENT CENTERS of Dragonpay. \n" +
"\n" +
" \n" +
"\n" +
"Successful payments made on or before 5:00 p.m., through our official payment centers, will be posted in your online account (HELIX) on the same day. \n" +
"\n" +
" \n" +
"\n" +
"For the payment options and the detailed instructions on how to pay online, download here https://bit.ly/citupaymentoptions \n" +
"\n" +
" ");
        JPanel announcementPanel4 = createAnnouncementPanel("SCHEDULE OF ENROLLMENT", "2023-05-10", "SCHEDULE OF ENROLLMENT\n" +
"\n" +
"FOR\n" +
"\n" +
"MIDYEAR 2023 and ACADEMIC YEAR 2023 – 2024\n" +
"\n" +
"SCHEDULE OF ENROLLMENT FOR COLLEGE\n" +
"\n" +
"I.      MIDYEAR TERM 2023\n" +
"\n" +
"June 7 – June 19, 2023\n" +
"\n" +
"For students with final grades in the 2nd semester AY 2022-2023\n" +
"\n" +
"June 19, 2023\n" +
"\n" +
"Start of MIDYEAR Classes\n" +
"\n" +
"II.    FIRST SEMESTER, AY 2023-2024\n" +
"\n" +
"April 19 - August 19, 2023\n" +
"\n" +
"May 8 - August 19, 2023\n" +
"\n" +
"New students (Freshmen)\n" +
"\n" +
"Transferee\n" +
"\n" +
"June 21 - August 19, 2023\n" +
"\n" +
"Continuing/Old Students(self-enrollment) with Final Grades in the 2nd semester AY 2022-2023\n" +
"\n" +
" \n" +
"\n" +
"·   Students who will enroll in MIDYEAR 2023 must wait for further announcement when to enroll for the First Semester, AY 2023-2024.\n" +
"\n" +
"     April 24 - August 19, 2023\n" +
"\n" +
"     August 23, 2023                                           \n" +
"\n" +
"For CIT Grade 12 graduates who will enroll in College (Express enrollment on April 24-25, 2023)\n" +
"\n" +
"Start of Classes\n" +
"\n" +
"SCHEDULE OF ENROLLMENT FOR SENIOR HIGH SCHOOL\n" +
"\n" +
"I.      MIDYEAR TERM 2023\n" +
"\n" +
"June 7 – June 19, 2023\n" +
"\n" +
"Grade 11 & Grade 12\n" +
"\n" +
"June 19, 2023\n" +
"\n" +
"Start of MIDYEAR Classes\n" +
"\n" +
"II.    FIRST SEMESTER, AY 2023-2024\n" +
"\n" +
"April 19 - August 19, 2023\n" +
"\n" +
"New students/transferees for Grade 11 & Grade 12\n" +
"\n" +
"June 15 - August 19, 2023\n" +
"\n" +
" \n" +
"\n" +
"For CIT Grade 10 completers who will enroll in\n" +
"\n" +
"Grade 11 (Express enrollment on June 15-16, 2023)\n" +
"\n" +
" \n" +
"\n" +
"June 19 - August 19, 2023\n" +
"\n" +
"For CIT Grade 11 students who will enroll in Grade 12\n" +
"\n" +
"August 23, 2023\n" +
"\n" +
"Start of Classes\n" +
"\n" +
"SCHEDULE OF ENROLLMENT FOR JUNIOR HIGH SCHOOL\n" +
"\n" +
"I.      MIDYEAR (Remedial Class) 2023\n" +
"\n" +
"June 19 - June 26, 2023\n" +
"\n" +
"Grade 7 to 10\n" +
"\n" +
" \n" +
"\n" +
" \n" +
"\n" +
"      June 26, 2023\n" +
"\n" +
"Start of MIDYEAR Classes\n" +
"\n" +
"II.    SCHOOL YEAR 2023-2024\n" +
"\n" +
"April 19 – August 19, 2023\n" +
"\n" +
"New students/transferees for Grades 7 to 10\n" +
"\n" +
" \n" +
"\n" +
"June 14 – August 19, 2023                          \n" +
"\n" +
"For CIT Grade 6 graduates who will enroll in Grade 7\n" +
"\n" +
"(Express enrollment on June 14, 2023)\n" +
"\n" +
" \n" +
"\n" +
"June 19 – August 19, 2023\n" +
"\n" +
"For continuing/old SCHOOL students (Grade 8 to 10)\n" +
"\n" +
" \n" +
"\n" +
" \n" +
"\n" +
"August 23, 2023\n" +
"\n" +
"Start of Classes\n" +
"\n" +
"SCHEDULE OF ENROLLMENT FOR ELEMENTARY\n" +
"\n" +
"I.      MIDYEAR 2023\n" +
"\n" +
"May 2, 2023   \n" +
"\n" +
" \n" +
"\n" +
"June 26, 2023\n" +
"\n" +
"Start of Enrollment\n" +
"\n" +
"Start of MIDYEAR Classes\n" +
"\n" +
"II.    SCHOOL YEAR 2023-2024\n" +
"\n" +
"April 19 – August 19, 2023\n" +
"\n" +
"New students/transferees for Preschool & Grades 1 to 6\n" +
"\n" +
" \n" +
"\n" +
"June 19 – August 19, 2023\n" +
"\n" +
"For continuing/old SCHOOL students\n" +
"\n" +
" \n" +
"\n" +
"August 23, 2023\n" +
"\n" +
"Start of Classes");

        // header tabs for the announcement
        tabbedPane.addTab("HOW TO SELF ENROLL", announcementPanel1);
        tabbedPane.addTab("QUICK LINKS", announcementPanel2);
        tabbedPane.addTab("ONLINE PAYMENTS", announcementPanel3);
        tabbedPane.addTab("ENROLLMENT SCHEDULES", announcementPanel4);

        // Add the tabbed pane to the content pane
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        container.add(tabbedPane, BorderLayout.CENTER);
        
        this.setVisible(true);
    }

    private JPanel createAnnouncementPanel(String title, String date, String content) {
        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        titleLabel.setForeground(Color.WHITE);

        JLabel dateLabel = new JLabel(date);
        dateLabel.setFont(new Font("Arial", Font.PLAIN, 16));
        dateLabel.setForeground(Color.WHITE);

        JTextArea contentTextArea = new JTextArea(content);
        contentTextArea.setEditable(false);
        contentTextArea.setLineWrap(true);
        contentTextArea.setForeground(Color.WHITE);
        contentTextArea.setBackground(Color.GRAY); // Set background color to gray

        JScrollPane scrollPane = new JScrollPane(contentTextArea);
        scrollPane.setPreferredSize(new Dimension(600, 400));

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));
        panel.setBackground(Color.decode("#8c383e"));
        panel.add(titleLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(dateLabel);
        panel.add(Box.createRigidArea(new Dimension(0, 20)));
        panel.add(scrollPane);

        return panel;
    }
}