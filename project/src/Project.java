import javax.swing.*;
import javax.swing.border.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Project extends JFrame {    
    CardLayout cardLayout;
    JPanel stdPan,admPan,studentPanel,adminPanel,homePanel,cardPanel,studentPan,adminPan,searchPanel;
    JPanel loginPan,adminSpace,adminSpacePan,createPfePan,createProfPan,listPfePan,listProfPan;
    JButton studentButton,adminButton,homeButton,searchBtn,loginBtn,addPfe,addProf,updatePfe,removePfe,updateProf,removeProf;
    JLabel stdLab,admLab,searchLab,idLab,passwordLab,loginLab,referenceLab,titleLab,authorLab,yearLab,supervisorLab;
    ImageIcon stdIcon,admIcon;
    JTextField searchTf,idTf,referenceTf,titleTf,authorTf,yearTf,supervisorTf;
    JLabel firstnameLab,lastnameLab,emailLab,specialityLab;
    JTextField firstnameTf,lastnameTf,emailTf,specialityTf;
    JPasswordField passwordTp;
    JMenu pfeMenu,profMenu;
    JMenuItem creatPfe,listePfe,creatProf,listeProf;
    JMenuBar adminMenu;
    Container ContentPane;
    String[] pfetab={"Reference","Title","Author","Year","Supervisor","  "};
    String[] proftab={"First Name","Last Name","Email","Speciality","  "};
    String[] pfedata,profdata;
    JTable pfetable,proftable;
    DefaultTableModel pfetablemodel,proftablemodel;
    public Project() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "");
                if (con.isValid(1))
                    System.out.println("Connected to the database!");
        } catch (Exception e) {
                System.out.println(e);
        }
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 325);
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
        studentButton = new JButton("                 GO To Student Space                  ");
        stdIcon=new ImageIcon(getClass().getResource("img/student.png"));
        stdLab=new JLabel(stdIcon);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "studentPanel");
                setTitle("Student Space");
            }
        });
        adminButton = new JButton("                  GO To Admin Space                      ");
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
                setSize(550, 325);
            }
        });
        panel.add(homeButton, BorderLayout.NORTH);
    }

    //create student space panel 
     public JPanel createStudentPanel() {
        studentPan=new JPanel(new BorderLayout());
        searchPanel=new JPanel();
        searchLab=new JLabel("search memoire");
        searchPanel.add(searchLab);
        searchTf=new JTextField(30);
        searchPanel.add(searchTf);
        searchBtn=new JButton("search");
        searchPanel.add(searchBtn);
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
                    setSize(470, 300);
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
            }
            });
            listePfe= new JMenuItem("Liste");
            listePfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listPfePan=displayPfe();
                adminSpacePan.add(listPfePan,"listPfePan");
                cardLayout.show(adminSpacePan, "listPfePan");
            }
            });
            creatProf= new JMenuItem("Create");
            creatProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProfPan=createProfPanel();
                adminSpacePan.add(createProfPan,"createProfPan");
                cardLayout.show(adminSpacePan, "createProfPan");
            }
            });
            listeProf= new JMenuItem("Liste");
            listeProf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                listProfPan=displayProf();
                adminSpacePan.add(listProfPan,"listProfPan");
                cardLayout.show(adminSpacePan, "listProfPan");
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
        addPfe=new JButton("Add");
        addPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // inserting in the database
                try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "")) {
                String query = "INSERT INTO memoire (referenceNbr, title, author, year, supervisor) VALUES (?, ?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                String reference = referenceTf.getText();
                String title = titleTf.getText();
                String author = authorTf.getText();
                int year = Integer.parseInt(yearTf.getText());
                String supervisor = supervisorTf.getText();
                pst.setString(1, reference);
                pst.setString(2, title);
                pst.setString(3, author);
                pst.setInt(4, year);
                pst.setString(5, supervisor);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(createPfePan, "Data inserted into Memoire table successfully.");
            }
        } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(createPfePan, "Error inserting data into Memoire table");
        }
            }
            });
        createPfePan.add(addPfe);
        EmptyBorder emptyBorder = new EmptyBorder(18, 18, 18, 18);
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
        pfetablemodel.addRow(pfetab);
        return listPfePan;
    }
    //create add prof form panel
    public JPanel createProfPanel(){
        createProfPan =new JPanel();
        lastnameLab=new JLabel("Last Name");
        lastnameTf=new JTextField();
        createProfPan.add(lastnameLab);
        createProfPan.add(lastnameTf);
        firstnameLab=new JLabel("First Name");
        firstnameTf=new JTextField();
        createProfPan.add(firstnameLab);
        createProfPan.add(firstnameTf);
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
                String query = "INSERT INTO teacher (last_name, first_name, email, specialty) VALUES (?, ?, ?, ?)";
                try (PreparedStatement pst = con.prepareStatement(query)) {
                String firstname = firstnameTf.getText();
                String lastname = lastnameTf.getText();
                String email = emailTf.getText();
                String speciality = specialityTf.getText();
                pst.setString(1, lastname);
                pst.setString(2, firstname);
                pst.setString(3, email);
                pst.setString(4, speciality);
                pst.executeUpdate();
                JOptionPane.showMessageDialog(createPfePan, "Data inserted into teacher table successfully.");
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
        profdata=new String[5];
        proftablemodel=new DefaultTableModel(proftab, 0);
        proftable= new JTable(proftablemodel);
        listProfPan=new JPanel();
        listProfPan.add(proftable);
        proftablemodel.addRow(proftab);
        return listProfPan;
    }

    public static void main(String[] args) {  
        new Project();
    }
}


