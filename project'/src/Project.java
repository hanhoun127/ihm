import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class Project extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public Project() {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "");
                if (con.isValid(5))  // Check if the connection is valid within 5 seconds
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

        StudentPanel studentPanel = new StudentPanel(cardLayout, cardPanel);
        AdminPanel adminPanel = new AdminPanel(cardLayout, cardPanel);
        HomePanel homePanel = new HomePanel(cardLayout, cardPanel);

        cardPanel.add(studentPanel, "studentPanel");
        cardPanel.add(adminPanel, "adminPanel");
        cardPanel.add(homePanel, "homePanel");

        add(cardPanel, BorderLayout.CENTER);

        cardLayout.show(cardPanel, "homePanel");
        setResizable(false);
        setVisible(true);
    }
    public static void main(String[] args) {  
        new Project();
    }
}
