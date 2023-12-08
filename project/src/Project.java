import javax.swing.*;
import javax.swing.border.*;

import java.awt.*;
import java.awt.event.*;


public class Project extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public Project() {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(550, 325);

        // Create card panel with CardLayout
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create Student panel
        JPanel studentPanel = createPanel("Student Panel");
        addNavigationButton(studentPanel, "studentPanel");

        // Create Admin panel
        JPanel adminPanel = createPanel("Admin Panel");
        addNavigationButton(adminPanel, "adminPanel");

        // Create Home panel with buttons to switch between Student and Admin panels
        JPanel homePanel = createHomePanel();

        // Add panels to the card panel
        cardPanel.add(studentPanel, "studentPanel");
        cardPanel.add(adminPanel, "adminPanel");
        cardPanel.add(homePanel, "homePanel");

        // Add components to the main frame
        add(cardPanel, BorderLayout.CENTER);

        // Set default panel
        cardLayout.show(cardPanel, "homePanel");
        setResizable(false);
        setVisible(true);
    }

    private JPanel createPanel(String title) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createHomePanel() {
        JPanel homePanel = new JPanel(new BorderLayout());
        JButton studentButton = new JButton("                 GO To Student Space                  ");
        ImageIcon stdIcon=new ImageIcon(getClass().getResource("img/student.png"));
        JLabel stdLab=new JLabel(stdIcon);
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "studentPanel");
            }
        });

        JButton adminButton = new JButton("                  GO To Admin Space                      ");
        ImageIcon admIcon=new ImageIcon(getClass().getResource("img/admin.png"));
        JLabel admLab=new JLabel(admIcon);
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminPanel");
            }
        });
        JPanel stdPan=new JPanel();
        stdPan.add(stdLab);
        stdPan.add(studentButton); 
        stdPan.setBorder(new LineBorder(Color.BLACK, 2));
        stdPan.setLayout(new BoxLayout(stdPan,BoxLayout.Y_AXIS));
        JPanel admPan=new JPanel();
        admPan.add(admLab);
        admPan.add(adminButton);
        admPan.setBorder(new LineBorder(Color.BLACK, 2));
        admPan.setLayout(new BoxLayout(admPan,BoxLayout.Y_AXIS));
        homePanel.add(stdPan,BorderLayout.WEST);
        homePanel.add(admPan,BorderLayout.CENTER);

        return homePanel;
    }

    private void addNavigationButton(JPanel panel, String targetPanel) {
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "homePanel");
            }
        });

        panel.add(homeButton, BorderLayout.NORTH);
    }

    public static void main(String[] args) {
        new Project();
    }
}
