import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Project extends JFrame {    
    CardLayout cardLayout;
    JPanel stdPan,admPan,studentPanel,adminPanel,homePanel,cardPanel,studentPan,adminPan,searchPanel;
    JPanel loginPan,adminSpace,adminSpacePan,createPfePan,createProfPan,listPfePan,listProfPan;
    JButton studentButton,adminButton,homeButton,searchBtn,loginBtn,addPfe,addProf,updatePfe,removePfe,updateProf,removeProf;
    JLabel stdLab,admLab,searchLab,idLab,passwordLab,loginLab,referenceLab,titleLab,authorLab,yearLab,supervisorLab;
    ImageIcon stdIcon,admIcon;
    JTextField searchTf,idTf,referenceTf,titleTf,authorTf,yearTf,supervisorTf;
    JLabel nameLab,emailLab,specialityLab,summaryLab;
    JTextField nameTf,emailTf,specialityTf;
    JPasswordField passwordTp;
    JMenu pfeMenu,profMenu;
    JMenuItem creatPfe,listePfe,creatProf,listeProf;
    JMenuBar adminMenu;
    Container ContentPane;
    String[] pfetab={"Reference","Title","Author","Year","Supervisor","Summary"};
    String[] proftab={" Name","Email","Speciality"};
    String[] pfedata,profdata;
    JTable pfetable,proftable;
    DefaultTableModel pfetablemodel,proftablemodel;
    TextArea summaryTa;
    public Project() {
        
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(540, 325);
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);
        studentPanel = createStudentPanel();
        addNavigationButton(studentPanel, "studentPanel");
        adminPanel = createAdmintPanel();
        addNavigationButton(adminPanel, "adminPanel");
        homePanel = createHomePanel();
        cardPanel.add(studentPanel, "studentPanel");
        cardPanel.add(adminPanel, "adminPanel");
        cardPanel.add(homePanel, "homePanel");
        add(cardPanel, BorderLayout.CENTER);
        cardLayout.show(cardPanel, "homePanel");
        setResizable(false);
        setVisible(true);
    }

    //create home panel 
        public JPanel createHomePanel() {
        homePanel  = new JPanel(new BorderLayout());
        studentButton = new JButton("GO To Student Space");
        stdIcon=new ImageIcon(getClass().getResource("img/student.png"));
        stdLab=new JLabel(stdIcon);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "studentPanel");
                setTitle("Student Space");
                setSize(490, 325);
            }
        });
        adminButton = new JButton("GO To Admin Space");
        admIcon=new ImageIcon(getClass().getResource("img/admin.png"));
        admLab=new JLabel(admIcon);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminPanel");
                setTitle("Admin Space");
                setSize(350, 200);
            }
        });
        stdPan=new JPanel();
        stdPan.add(stdLab);
        stdPan.add(studentButton); 
        stdPan.setBorder(new LineBorder(Color.BLACK, 2));
        stdPan.setLayout(new BoxLayout(stdPan,BoxLayout.Y_AXIS));
        admPan=new JPanel();
        admPan.add(admLab);
        admPan.add(adminButton);
        admPan.setBorder(new LineBorder(Color.BLACK, 2));
        admPan.setLayout(new BoxLayout(admPan,BoxLayout.Y_AXIS));
        homePanel.add(stdPan,BorderLayout.WEST);
        homePanel.add(admPan,BorderLayout.EAST);
        return homePanel;
    }

    public void addNavigationButton(JPanel panel, String targetPanel) {
        homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "homePanel");
                setSize(540, 325);
                
            }
        });
        panel.add(homeButton, BorderLayout.NORTH);
    }

    //create student space panel 
     public JPanel createStudentPanel() {
        studentPan=new JPanel(new BorderLayout());
        searchPanel=new JPanel();
        searchLab=new JLabel("search memoire by reference or title or supervisor name");
        searchPanel.add(searchLab);
        searchTf=new JTextField(18);
        searchPanel.add(searchTf);
        searchBtn=new JButton("search");
        searchPanel.add(searchBtn);
        pfedata=new String[6];
        pfetablemodel=new DefaultTableModel(pfetab, 0);
        pfetable= new JTable(pfetablemodel);
        searchPanel.add(pfetable);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(pfetablemodel);
        pfetable.setRowSorter(sorter);
        JScrollPane scrollPane = new JScrollPane(pfetable);
        searchPanel.add(scrollPane);
        searchBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String searchText = searchTf.getText();
                if(!searchText.isEmpty()){
                pfetablemodel.setRowCount(0);
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
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
        return studentPan;
    }

    //create login ademin panel 
    public JPanel createAdmintPanel() {
        adminPan=new JPanel(new BorderLayout());
        loginPan=new JPanel();
        idLab=new JLabel("Enter your ID");
        loginPan.add(idLab);
        idTf=new JTextField();
        loginPan.add(idTf);
        passwordLab=new JLabel("Enter your password");
        loginPan.add(passwordLab);
        passwordTp=new JPasswordField();
        loginPan.add(passwordTp);
        loginBtn=new JButton("Login");        
        loginPan.add(loginBtn);
        loginPan.setLayout(new BoxLayout(loginPan,BoxLayout.Y_AXIS));
        adminPan.add(loginPan);
        loginLab=new JLabel(" ");
        adminPan.add(loginLab,BorderLayout.SOUTH);
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ev) {
                String password = new String(passwordTp.getPassword());
                if (!idTf.getText().equals("12345678") || !password.equals("12345678")) {
                    loginLab.setText("The ID or the password is incorrect! Try again.");
                } else {
                    loginLab.setText("");
                    adminSpace = createAdminSpace();
                    cardPanel.add(adminSpace, "adminSpace"); 
                    cardLayout.show(cardPanel, "adminSpace"); 
                    setSize(470, 350);
                }
            }
        });   
        return adminPan;
    }
//create the admin space panel
    public JPanel createAdminSpace(){
            adminSpacePan=new JPanel();
            adminSpacePan.setLayout(cardLayout);
            pfeMenu = new JMenu("Memoire");
            profMenu = new JMenu("Professor");
            creatPfe= new JMenuItem("Create");
            creatPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createPfePan=createPfePanel();
                adminSpacePan.add(createPfePan,"createPfePan");
                cardLayout.show(adminSpacePan, "createPfePan");
                setSize(470, 350);
            }
            });
            listePfe= new JMenuItem("Liste");
            listePfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPfePan=displayPfe();
                adminSpacePan.add(listPfePan,"listPfePan");
                cardLayout.show(adminSpacePan, "listPfePan");
                setSize(550, 500);
            }
            });
            creatProf= new JMenuItem("Create");
            creatProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProfPan=createProfPanel();
                adminSpacePan.add(createProfPan,"createProfPan");
                cardLayout.show(adminSpacePan, "createProfPan");
                setSize(400, 300);
            }
            });
            listeProf= new JMenuItem("Liste");
            listeProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listProfPan=displayProf();
                adminSpacePan.add(listProfPan,"listProfPan");
                cardLayout.show(adminSpacePan, "listProfPan");
                setSize(470, 500);
            }
            });
            pfeMenu.add(creatPfe);
            pfeMenu.add(listePfe);
            profMenu.add(creatProf);
            profMenu.add(listeProf);
            adminMenu = new JMenuBar() ;
            adminMenu.add(pfeMenu);
            adminMenu.add(profMenu);
            ContentPane=getContentPane();
            ContentPane.add(adminMenu,BorderLayout.NORTH);
            return adminSpacePan;
    }
//create add pfe form panel
    public JPanel createPfePanel(){
        createPfePan =new JPanel();
        referenceLab=new JLabel("Reference");
        referenceTf=new JTextField();
        createPfePan.add(referenceLab);
        createPfePan.add(referenceTf);
        titleLab=new JLabel("Title");
        titleTf=new JTextField();
        createPfePan.add(titleLab);
        createPfePan.add(titleTf);
        authorLab=new JLabel("Author");
        authorTf=new JTextField();
        createPfePan.add(authorLab);
        createPfePan.add(authorTf);
        yearLab=new JLabel("Year");
        yearTf=new JTextField();
        createPfePan.add(yearLab);
        createPfePan.add(yearTf);
        supervisorLab=new JLabel("Supervisor");
        supervisorTf=new JTextField();
        createPfePan.add(supervisorLab);
        createPfePan.add(supervisorTf);
        summaryLab=new JLabel("Summary");
        summaryTa=new TextArea(2,31);
        createPfePan.add(summaryLab);
        createPfePan.add(summaryTa);
        addPfe=new JButton("Add");
        addPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setSize(470, 350);
                String reference = referenceTf.getText();
                String title = titleTf.getText();
                String author = authorTf.getText();
                String year = yearTf.getText();
                String supervisor = supervisorTf.getText();
                String summary =summaryTa.getText();
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
                String query = "INSERT INTO memoire (referenceNbr, title, author, year, supervisor,summary) VALUES (?, ?, ?, ?, ?,?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                if (reference.isEmpty() || title.isEmpty() || author.isEmpty() || year.isEmpty() || supervisor.isEmpty() || summary.isEmpty()) {
                JOptionPane.showMessageDialog(createPfePan, "All fields are required.");
                return;  
                }else{
                    int Year = Integer.parseInt(yearTf.getText());
                    pst.setString(1, reference);
                    pst.setString(2, title);
                    pst.setString(3, author);
                    pst.setInt(4, Year);
                    pst.setString(5, supervisor);
                    pst.setString(6, summary);
                    pst.executeUpdate();
                    JOptionPane.showMessageDialog(createPfePan, "Data inserted into Memoire table successfully.");
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
    //display pfe list
    public JPanel displayPfe(){
        pfedata=new String[6];
        pfetablemodel=new DefaultTableModel(pfetab, 0);
        pfetable= new JTable(pfetablemodel);
        listPfePan=new JPanel();
        listPfePan.add(pfetable);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(pfetablemodel);
        pfetable.setRowSorter(sorter);
        listPfePan = new JPanel(new BorderLayout());
        JScrollPane scrollPane = new JScrollPane(pfetable);
        listPfePan.add(scrollPane, BorderLayout.CENTER);
        removePfe=new JButton("Remove");
        updatePfe=new JButton("Update");
        JPanel btn=new JPanel();
        btn.add(updatePfe);
        btn.add(removePfe);

        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
            String query = "SELECT referenceNbr, title, author, year, supervisor, summary FROM memoire";
            try (PreparedStatement pst = con.prepareStatement(query)) {
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
            JOptionPane.showMessageDialog(this, "Error retrieving data from Memoire table");
        }
        
        listPfePan.add(btn,BorderLayout.NORTH);
        return listPfePan;
    }
    //create add prof form panel
    public JPanel createProfPanel(){
        createProfPan =new JPanel();
        nameLab=new JLabel(" Name");
        nameTf=new JTextField();
        createProfPan.add(nameLab);
        createProfPan.add(nameTf);
        emailLab=new JLabel("Email");
        emailTf=new JTextField();
        createProfPan.add(emailLab);
        createProfPan.add(emailTf);
        specialityLab=new JLabel("Speciality");
        specialityTf=new JTextField();
        createProfPan.add(specialityLab);
        createProfPan.add(specialityTf);
        addProf=new JButton("Add");
        addProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // inserting in the database
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
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
//display prof list
    public JPanel displayProf(){
        listProfPan=new JPanel();
        removeProf=new JButton("Remove");
        updateProf=new JButton("Update");
        JPanel btn=new JPanel();
        btn.add(updateProf);
        btn.add(removeProf);
        listProfPan.add(btn);
        profdata=new String[3];
        proftablemodel=new DefaultTableModel(proftab, 0);
        proftable= new JTable(proftablemodel);
        listProfPan.add(proftable);
        JScrollPane scrollPane = new JScrollPane(proftable);
        listProfPan.add(scrollPane);
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(proftablemodel);
        proftable.setRowSorter(sorter);
        try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
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
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
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
                                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
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

    public static void main(String[] args) {  
        new Project();
    }
}