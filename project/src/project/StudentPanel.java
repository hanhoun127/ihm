package project;

import javax.swing.*;
import javax.swing.table.*;
import dbConnection.DbConnection;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class StudentPanel extends JPanel{
    private JPanel studentPan, searchPanel;
    private JLabel searchLab;
    private JTextField searchTf;
    private JButton searchBtn;
    private DefaultTableModel pfetablemodel;
    private JTable pfetable;
    private String[] pfetab = {"Reference", "Title", "Author", "Year", "Supervisor", "Summary"};

    public StudentPanel() {
        setLayout(new BorderLayout());
        createStudentPanel();
    }

    // create student space panel
    private void createStudentPanel() {
        studentPan = new JPanel(new BorderLayout());
        searchPanel = new JPanel();
        searchLab = new JLabel("Search memoire by reference or title or supervisor name");
        searchPanel.add(searchLab);
        searchTf = new JTextField(18);
        searchPanel.add(searchTf);
        searchBtn = new JButton("Search");
        searchPanel.add(searchBtn);

        pfetablemodel = new DefaultTableModel(pfetab, 0);
        pfetable = new JTable(pfetablemodel);
        searchPanel.add(pfetable);

        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(pfetablemodel);
        pfetable.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(pfetable);
        searchPanel.add(scrollPane);

        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String searchText = searchTf.getText();
                if (!searchText.isEmpty()) {
                    pfetablemodel.setRowCount(0);
                    try (Connection con = DbConnection.connect()) {
                        String query = "SELECT * FROM memoire WHERE referenceNbr LIKE ? OR title LIKE ? OR supervisor LIKE ?";
                        try (PreparedStatement pst = con.prepareStatement(query)) {
                            pst.setString(1, "%" + searchText + "%");
                            pst.setString(2, "%" + searchText + "%");
                            pst.setString(3, "%" + searchText + "%");
                            try (ResultSet rs = pst.executeQuery()) {
                                while (rs.next()) {
                                    Object[] rowData = {
                                            rs.getString("referenceNbr"),
                                            rs.getString("title"),
                                            rs.getString("author"),
                                            rs.getInt("year"),
                                            rs.getString("supervisor"),
                                            rs.getString("summary")
                                    };
                                    pfetablemodel.addRow(rowData);
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(searchPanel, "Error retrieving data from Memoire table");
                    }
                }

            }
        });

        studentPan.add(searchPanel);
        add(studentPan);
    }
}
