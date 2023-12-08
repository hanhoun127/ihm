import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame {
    CardLayout cardLayout;
    JPanel stdPan,admPan,studentPanel,adminPanel,homePanel,cardPanel,studentPan,adminPan,searchPanel;
    JPanel loginPan;
    JButton studentButton,adminButton,homeButton,searchBtn,loginBtn;
    JLabel stdLab,admLab,searchLab,idLab,passwordLab,loginLab;
    ImageIcon stdIcon,admIcon;
    JTextField searchTf,idTf;
    JPasswordField passwordTp;
    public Project() {
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
        loginBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent ev){
                String Password=new String (passwordTp.getPassword());
                if(!idTf.getText().equals("1HN2MR2004") || !Password.equals("a1s2d3f4")){
                    loginLab.setText("the id or the password incorrect! try agin");
                }else{
                    loginLab.setText("enter");
                }
            }
        });
        return adminPan;
    }
    
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

    public static void main(String[] args) {
        new Project();
    }
}
