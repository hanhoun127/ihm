package project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import dbConnection.DbConnection;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class AdminPanel extends JPanel{
    private CardLayout cardLayout;
    private JPanel cardPanel,adminSpacePan,createPfePan,listPfePan,createProfPan,listProfPan;
    private JButton addPfe,removePfe,updatePfe,addProf,updateProf,removeProf;
    private JTextField referenceTf,titleTf,authorTf,yearTf,supervisorTf,nameTf,emailTf,specialityTf;
    private TextArea summaryTa;
    private DefaultTableModel pfetablemodel,proftablemodel;
    private JTable pfetable,proftable;
    private JComboBox<String> level;
    String[] pfetab={"Reference","Title","Author","Level","Year","Supervisor","Summary"};
    String[] proftab={" Name","Email","Speciality"};
    String[] options = {"Licence", "Master", "Ingéniorat"};
    public AdminPanel(CardLayout cardLayout, JPanel cardPanel) {
        setLayout(new BorderLayout());
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;
        createAdminPanel();
    }

    private void createAdminPanel() {
        JPanel adminPan = new JPanel(new BorderLayout());
        JPanel loginPan = createLoginPanel();
        adminPan.add(loginPan);

        JLabel loginLab = new JLabel(" ");
        adminPan.add(loginLab, BorderLayout.SOUTH);

        add(adminPan);
    }

    private JPanel createLoginPanel() {
        JPanel loginPan = new JPanel();
        loginPan.setLayout(new BoxLayout(loginPan, BoxLayout.Y_AXIS));

        JLabel idLab = new JLabel("Enter your ID");
        loginPan.add(idLab);

        JTextField idTf = new JTextField();  
        loginPan.add(idTf);

        JLabel passwordLab = new JLabel("Enter your password");
        loginPan.add(passwordLab);

        JPasswordField passwordTp = new JPasswordField();  
        loginPan.add(passwordTp);

        JButton loginBtn = new JButton("Login");
        loginPan.add(loginBtn);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String password = new String(passwordTp.getPassword());
                if (!idTf.getText().equals("12345678") || !password.equals("12345678")) {
                    JOptionPane.showMessageDialog(loginPan, "The ID or the password is incorrect! Try again.");
                } else {
                    JPanel adminSpace = createAdminSpace();
                    cardPanel.add(adminSpace, "adminSpace");
                    cardLayout.show(cardPanel, "adminSpace");
                    SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(500, 370);
                }
            }
        });

        return loginPan;
    }
    
        private JPanel createAdminSpace() {
        adminSpacePan = new JPanel();
        adminSpacePan.setLayout(cardLayout);
        JMenu pfeMenu = new JMenu("Memoire");
        JMenu profMenu = new JMenu("Professor");

        JMenuItem createPfe = new JMenuItem("Create");
        createPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPfePan = createPfePanel();
                adminSpacePan.add(createPfePan, "createPfePan");
                cardLayout.show(adminSpacePan, "createPfePan");
                SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(500, 390);
            }
        });

        JMenuItem listPfe = new JMenuItem("Liste");
        listPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPfePan = displayPfe();
                adminSpacePan.add(listPfePan, "listPfePan");
                cardLayout.show(adminSpacePan, "listPfePan");
                SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(480, 500);
            }
        });

        JMenuItem createProf = new JMenuItem("Create");
        createProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel createProfPan = createProfPanel();
                adminSpacePan.add(createProfPan, "createProfPan");
                cardLayout.show(adminSpacePan, "createProfPan");
                SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(400, 300);
            }
        });

        JMenuItem listProf = new JMenuItem("Liste");
        listProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel listProfPan = displayProf();
                adminSpacePan.add(listProfPan, "listProfPan");
                cardLayout.show(adminSpacePan, "listProfPan");
                SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(470, 500);
            }
        });

        pfeMenu.add(createPfe);
        pfeMenu.add(listPfe);
        profMenu.add(createProf);
        profMenu.add(listProf);

        JMenuBar adminMenu = new JMenuBar();
        adminMenu.add(pfeMenu);
        adminMenu.add(profMenu);

        SwingUtilities.getWindowAncestor(AdminPanel.this).add(adminMenu,BorderLayout.NORTH);

        return adminSpacePan;
    }

    private JPanel createPfePanel() {
        createPfePan = new JPanel();
        JLabel referenceLab=new JLabel("Reference");
        referenceTf=new JTextField();
        createPfePan.add(referenceLab);
        createPfePan.add(referenceTf);
        JLabel titleLab=new JLabel("Title");
        titleTf=new JTextField();
        createPfePan.add(titleLab);
        createPfePan.add(titleTf);
        JLabel authorLab=new JLabel("Author");
        authorTf=new JTextField();
        createPfePan.add(authorLab);
        createPfePan.add(authorTf);
        JLabel levelLab=new JLabel("Level");
        level=new JComboBox<>();
        level.setModel(new DefaultComboBoxModel<>(options));
        createPfePan.add(levelLab);
        createPfePan.add(level);
        JLabel yearLab=new JLabel("Year");
        yearTf=new JTextField();
        createPfePan.add(yearLab);
        createPfePan.add(yearTf);
        JLabel supervisorLab=new JLabel("Supervisor");
        supervisorTf=new JTextField();
        createPfePan.add(supervisorLab);
        createPfePan.add(supervisorTf);
        JLabel summaryLab=new JLabel("Summary");
        summaryTa=new TextArea(2,31);
        createPfePan.add(summaryLab);
        createPfePan.add(summaryTa);
        addPfe=new JButton("Add");
        addPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String reference = referenceTf.getText();
                String title = titleTf.getText();
                String author = authorTf.getText();
                String year = yearTf.getText();
                String Level =(String) level.getSelectedItem();
                String supervisor = supervisorTf.getText();
                String summary =summaryTa.getText();
                try (Connection con = DbConnection.connect()) {
                String query = "INSERT INTO memoire (referenceNbr,id_teacher, title, author,level, year, supervisor,summary) VALUES (?,(SELECT id FROM teacher WHERE name=?),?, ?, ?, ?, ?,?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                if (reference.isEmpty() || title.isEmpty() || author.isEmpty()|| Level.isEmpty() || year.isEmpty() || supervisor.isEmpty() || summary.isEmpty()) {
                JOptionPane.showMessageDialog(createPfePan, "All fields are required.");
                return;  
                }else{
                    int Year = Integer.parseInt(yearTf.getText());
                    pst.setString(1, reference);
                    pst.setString(2, supervisor);
                    pst.setString(3, title);
                    pst.setString(4, author);
                    pst.setString(5, Level);
                    pst.setInt(6, Year);
                    pst.setString(7, supervisor);
                    pst.setString(8, summary);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(createPfePan, "Data inserted into Memoire table successfully.");
                    referenceTf.setText("");
                    titleTf.setText("");
                    authorTf.setText("");
                    yearTf.setText("");
                    supervisorTf.setText("");
                    summaryTa.setText("");
                }   
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(createPfePan, "Error inserting data into Memoire table");
        }
            }
            });
        createPfePan.add(addPfe);
        EmptyBorder emptyBorder = new EmptyBorder(10, 10, 10, 10);
        createPfePan.setBorder(emptyBorder);
        createPfePan.setLayout(new BoxLayout(createPfePan,BoxLayout.Y_AXIS));
        return createPfePan;
    }

    private JPanel displayPfe() {
        listPfePan = new JPanel();
        removePfe=new JButton("Remove");
        updatePfe=new JButton("Update");
        JPanel btn=new JPanel();
        btn.add(updatePfe);
        btn.add(removePfe);
        listPfePan.add(btn);
        pfetablemodel=new DefaultTableModel(pfetab, 0);
        pfetable= new JTable(pfetablemodel);
        listPfePan.add(pfetable);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(pfetablemodel);
        pfetable.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(pfetable);
        listPfePan.add(scrollPane);
        try (Connection con = DbConnection.connect()) {
            String query = "SELECT referenceNbr, title, author,level, year, supervisor, summary FROM memoire";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Object[] rowData = {
                                rs.getString("referenceNbr"),
                                rs.getString("title"),
                                rs.getString("author"),
                                rs.getString("level"),
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
            JOptionPane.showMessageDialog(this, "Error retrieving data from Memoire table");
        }
        removePfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = pfetable.getSelectedRow();
                if (selectedRow != -1) {
                try (Connection con = DbConnection.connect()) {
                    String query = "DELETE FROM memoire WHERE referenceNbr=? AND title=? AND author=? AND level=? AND year=? AND supervisor=? AND summary=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                String reference = (String) pfetable.getValueAt(selectedRow, 0);
                String title = (String) pfetable.getValueAt(selectedRow, 1);
                String author = (String) pfetable.getValueAt(selectedRow, 2);
                String Level = (String) pfetable.getValueAt(selectedRow, 3);
                String year = pfetable.getValueAt(selectedRow, 4).toString();
                String supervisor = (String) pfetable.getValueAt(selectedRow, 5);
                String summary =(String) pfetable.getValueAt(selectedRow, 6);
                pst.setString(1, reference);
                pst.setString(2, title);
                pst.setString(3, author);
                pst.setString(4, Level);
                pst.setString(5, year);
                pst.setString(6, supervisor);
                pst.setString(7, summary);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(createPfePan, "Data deleted from Memoire table successfully.");
                pfetablemodel.removeRow(pfetable.getSelectedRow());
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(createPfePan, "Error deleting data into Memoire table");
        }} else {
            JOptionPane.showMessageDialog(createPfePan, "Please select a row to delete.");
        }
            }});
            updatePfe.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(500, 370);
                    int selectedRow = pfetable.getSelectedRow();
                    if (selectedRow != -1) {
                        createPfePan = createPfePanel();
                        adminSpacePan.add(createPfePan, "createPfePan");
                        cardLayout.show(adminSpacePan, "createPfePan");
                        referenceTf.setText((String) pfetable.getValueAt(selectedRow, 0));
                        titleTf.setText((String) pfetable.getValueAt(selectedRow, 1));
                        authorTf.setText((String) pfetable.getValueAt(selectedRow, 2));
                        level.setSelectedItem((String) pfetable.getValueAt(selectedRow, 3));
                        yearTf.setText(pfetable.getValueAt(selectedRow, 4).toString());
                        supervisorTf.setText((String) pfetable.getValueAt(selectedRow, 5));
                        summaryTa.setText((String) pfetable.getValueAt(selectedRow, 6));
                        createPfePan.remove(addPfe);
                        JButton save=new JButton("Save");
                        createPfePan.add(save);
                        setSize(470, 350);
                        save.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try (Connection con = DbConnection.connect()) {
                                    String query = "UPDATE memoire SET referenceNbr=?, id_teacher=(SELECT id FROM teacher WHERE name=?), title=?, author=?,level=?, year=?,supervisor=?, summary=? WHERE referenceNbr=? AND title=? AND author=? AND level=? AND year=? AND supervisor=? AND summary=?";
                                    try (PreparedStatement pst = con.prepareStatement(query)) {
                                        String reference = referenceTf.getText();
                                        String title = titleTf.getText();
                                        String author = authorTf.getText();
                                        String Level=(String) level.getSelectedItem();
                                        String year = yearTf.getText();
                                        String supervisor = supervisorTf.getText();
                                        String summary =summaryTa.getText();
                                        if(reference.isEmpty() || title.isEmpty() || author.isEmpty() ||Level.isEmpty() || year.isEmpty() || supervisor.isEmpty() || summary.isEmpty()){
                                            JOptionPane.showMessageDialog(createPfePan, "All fields are required.");
                                            return;
                                        } else {
                                            int Year = Integer.parseInt(yearTf.getText());
                                            pst.setString(1, reference);
                                            pst.setString(2, supervisor);
                                            pst.setString(3, title);
                                            pst.setString(4, author);
                                            pst.setString(5, Level);
                                            pst.setInt(6, Year);
                                            pst.setString(7, supervisor);
                                            pst.setString(8, summary);
                                            pst.setString(9, (String) pfetable.getValueAt(selectedRow, 0));
                                            pst.setString(10, (String) pfetable.getValueAt(selectedRow, 1));
                                            pst.setString(11, (String) pfetable.getValueAt(selectedRow, 2));
                                            pst.setString(12, (String) pfetable.getValueAt(selectedRow, 3));
                                            pst.setString(13, (String) pfetable.getValueAt(selectedRow, 4).toString());
                                            pst.setString(14, (String) pfetable.getValueAt(selectedRow, 5));
                                            pst.setString(15, (String) pfetable.getValueAt(selectedRow, 6));

                                            pst.executeUpdate();
                                            referenceTf.setText("");
                                            titleTf.setText("");
                                            authorTf.setText("");
                                            level.setSelectedItem("Licence");
                                            yearTf.setText("");
                                            supervisorTf.setText("");
                                            summaryTa.setText("");
        
                                            JOptionPane.showMessageDialog(createPfePan, "Data changed in memoire table successfully.");
                                        }
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(createPfePan, "Error updating data in memoire table");
                                }
                            }
                        });
                    } else {
                        JOptionPane.showMessageDialog(createPfePan, "Please select a row to update.");
                    }
                }
            });
        
        return listPfePan;
    }

    private JPanel createProfPanel() {
        JPanel createProfPan = new JPanel();
        JLabel nameLab=new JLabel(" Name");
        nameTf=new JTextField();
        createProfPan.add(nameLab);
        createProfPan.add(nameTf);
        JLabel emailLab=new JLabel("Email");
        emailTf=new JTextField();
        createProfPan.add(emailLab);
        createProfPan.add(emailTf);
        JLabel specialityLab=new JLabel("Speciality");
        specialityTf=new JTextField();
        createProfPan.add(specialityLab);
        createProfPan.add(specialityTf);
        addProf=new JButton("Add");
        addProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // inserting in the database
                try (Connection con = DbConnection.connect()) {
                String query = "INSERT INTO teacher (name, email, specialty) VALUES (?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                String name = nameTf.getText();
                String email = emailTf.getText();
                String speciality = specialityTf.getText();
                if ( name.isEmpty() || email.isEmpty() || speciality.isEmpty() ) {
                JOptionPane.showMessageDialog(createPfePan, "All fields are required.");
                return;  
                }else{
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, speciality);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(createProfPan, "Data inserted into teacher table successfully.");
                nameTf.setText("");
                emailTf.setText("");
                specialityTf.setText("");
                }
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(createPfePan, "Error inserting data into teacher table");
        }
            }
            });
        createProfPan.add(addProf);
        EmptyBorder emptyBorder = new EmptyBorder(25, 25, 25, 25);
        createProfPan.setBorder(emptyBorder);
        createProfPan.setLayout(new BoxLayout(createProfPan,BoxLayout.Y_AXIS));
        return createProfPan;
    }

    private JPanel displayProf() {
        listProfPan = new JPanel();
        removeProf=new JButton("Remove");
        updateProf=new JButton("Update");
        JPanel btn=new JPanel();
        btn.add(updateProf);
        btn.add(removeProf);
        listProfPan.add(btn);
        proftablemodel=new DefaultTableModel(proftab, 0);
        proftable= new JTable(proftablemodel);
        listProfPan.add(proftable);
        JScrollPane scrollPane = new JScrollPane(proftable);
        listProfPan.add(scrollPane);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(proftablemodel);
        proftable.setRowSorter(sorter);
        try (Connection con = DbConnection.connect()) {
            String query = "SELECT name,email,specialty FROM teacher";
            try (PreparedStatement pst = con.prepareStatement(query)) {
                try (ResultSet rs = pst.executeQuery()) {
                    while (rs.next()) {
                        Object[] rowData = {
                                rs.getString("name"),
                                rs.getString("email"),
                                rs.getString("specialty")
                        };
                        proftablemodel.addRow(rowData);
                    }
                }
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Error retrieving data from Teacher table");
        }
        
        removeProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = proftable.getSelectedRow();
                if (selectedRow != -1) {
                try (Connection con = DbConnection.connect()) {
                    String query = "DELETE FROM teacher WHERE name=? AND email=? AND specialty=?";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                String name = (String) proftable.getValueAt(selectedRow, 0);
                String email = (String) proftable.getValueAt(selectedRow, 1);
                String speciality = (String) proftable.getValueAt(selectedRow, 2);
                pst.setString(1, name);
                pst.setString(2, email);
                pst.setString(3, speciality);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(createProfPan, "Data deleted from teacher table successfully.");
                proftablemodel.removeRow(proftable.getSelectedRow());
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(createPfePan, "Error deleting data into teacher table");
        }} else {
            JOptionPane.showMessageDialog(createProfPan, "Please select a row to delete.");
        }
            }});
            updateProf.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SwingUtilities.getWindowAncestor(AdminPanel.this).setSize(400, 300);
                    int selectedRow = proftable.getSelectedRow();
                    if (selectedRow != -1) {
                        createProfPan = createProfPanel();
                        adminSpacePan.add(createProfPan, "createProfPan");
                        cardLayout.show(adminSpacePan, "createProfPan");
                        nameTf.setText((String) proftable.getValueAt(selectedRow, 0));
                        emailTf.setText((String) proftable.getValueAt(selectedRow, 1));
                        specialityTf.setText((String) proftable.getValueAt(selectedRow, 2));
                        createProfPan.remove(addProf);
                        JButton save=new JButton("Save");
                        createProfPan.add(save);
                        setSize(400, 300);
                        save.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent e) {
                                try (Connection con = DbConnection.connect()) {
                                    String query = "UPDATE teacher SET name=?, email=?, specialty=? WHERE name=? AND email=? AND specialty=?";
                                    try (PreparedStatement pst = con.prepareStatement(query)) {
                                        String name = nameTf.getText();
                                        String email = emailTf.getText();
                                        String speciality = specialityTf.getText();
                                        if (name.isEmpty() || email.isEmpty() || speciality.isEmpty()) {
                                            JOptionPane.showMessageDialog(createProfPan, "All fields are required.");
                                            return;
                                        } else {
                                            pst.setString(1, name);
                                            pst.setString(2, email);
                                            pst.setString(3, speciality);
                                            pst.setString(4, (String) proftable.getValueAt(selectedRow, 0));
                                            pst.setString(5, (String) proftable.getValueAt(selectedRow, 1));
                                            pst.setString(6, (String) proftable.getValueAt(selectedRow, 2));
                                            nameTf.setText("");
                                            emailTf.setText("");
                                            specialityTf.setText("");
                                            pst.executeUpdate();
        
                                            JOptionPane.showMessageDialog(createProfPan, "Data changed in teacher table successfully.");
                                        }
                                    }
                                } catch (SQLException ex) {
                                    ex.printStackTrace();
                                    JOptionPane.showMessageDialog(createProfPan, "Error updating data in teacher table");
                                }
                            }
                        });
                    } else {
                        JOptionPane.showMessageDialog(createProfPan, "Please select a row to update.");
                    }
                }
            });
        return listProfPan;
    }
}
