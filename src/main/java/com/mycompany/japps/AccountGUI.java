/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.mycompany.japps;

/**
 *
 * @author Anfheirne
 */
import static com.mycompany.japps.Japps.cardLayout;
import static com.mycompany.japps.Japps.cardPanel;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import java.awt.*;

public class AccountGUI extends JPanel {

    private JTextField nameTextField;
    private JTextField studentNumberTextField;
    private JTable accountTable;

    public AccountGUI(JPanel cardPanel, CardLayout cardLayout) {


        setSize(800, 600);
  

        // bg color
        this.setBackground(Color.decode("#a83332"));

        // create all the components
        nameTextField = new JTextField("Anfheirne T. Cañizares", 20);
        nameTextField.setEditable(false);
        studentNumberTextField = new JTextField("17-0070-327", 12);
        studentNumberTextField.setEditable(false);
        
        
        //row and column
        String[] columnNames = {"School Year", "Semester", "Year Level", "Payment Date", "Payment Location","Payment","Balance"};
        Object[][] data = {
                {"2022", "First Semester", "1", "02/02/2022","M.Lhuillier, Cebu City","500.00","29,274.00"},
                {"", "", "1", "03/04/2022","M.Lhuillier, Cebu City","7,243.00","22,031.30"},
                {"", "", "1", "04/06/2022","M.Lhuillier, Cebu City","7,243.00","14,788.30"},
                {"", "", "1", "05/06/2022","M.Lhuillier, Cebu City","7,300.00","7,488.30"},
                {"", "", "1", "06/06/2022","M.Lhuillier, Cebu City","7,500.00","-11.70"},
                {"2022", "Second Semester", "1", "07/02/2022","M.Lhuillier, Cebu City","800.00","19,444.14"},
                {"", "", "1", "08/02/2022","M.Lhuillier, Cebu City","4,150.00","15,294.14"},
                {"", "", "1", "09/03/2022","M.Lhuillier, Cebu City","1,350.00","13,944.14"},
                {"", "", "1", "010/05/2022","M.Lhuillier, Cebu City","14,000.00	","-55.86"},
                {"", "", "1", "011/05/2022","M.Lhuillier, Cebu City","25,910.00	","-25,965.86"},
                {"2023", "First Semester", "2", "01/02/2023","M.Lhuillier, Cebu City","800.00","25,854.77"},
                {"", "", "2", "02/05/2023","M.Lhuillier, Cebu City","4,150.00","15,294.14"},
                {"", "", "2", "03/05/2023","M.Lhuillier, Cebu City","1,350.00","13,944.14"},
                
                
                
               
        };

        DefaultTableModel tableModel = new DefaultTableModel(data, columnNames) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        accountTable = new JTable(tableModel);

        // bg color table rows and columns
        DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer();
        cellRenderer.setBackground(Color.decode("#fcca00"));
        accountTable.setDefaultRenderer(Object.class, cellRenderer);

        // bg color for table header
        JTableHeader header = accountTable.getTableHeader();
        header.setBackground(Color.decode("#aa8f0b"));
        header.setForeground(Color.WHITE);
        
        // set the font of the table header to bold
        Font headerFont = header.getFont();
        Font boldHeaderFont = new Font(headerFont.getName(), Font.BOLD, headerFont.getSize());
        header.setFont(boldHeaderFont);

        // panel para sa components
        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());
        JLabel nameLabel = new JLabel("Student Name:");
        nameLabel.setForeground(Color.WHITE);
        panel.add(nameLabel);
        panel.add(nameTextField);
        JLabel studentNumberLabel = new JLabel("Student Number:");
        studentNumberLabel.setForeground(Color.WHITE);
        panel.add(studentNumberLabel);
        panel.add(studentNumberTextField);

        // bg color of panel
        panel.setBackground(Color.decode("#8c383e"));

        // add panel and content pane
        add(new TopPanelButtons(cardPanel, cardLayout), BorderLayout.NORTH);
        add(panel, BorderLayout.CENTER);
        add(new JScrollPane(accountTable), BorderLayout.SOUTH);
        this.setVisible(true);
    }

    
}
