package project;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
public class Project extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;
    public Project(){
        this.setBackground(new Color(124, 252, 0));
		this.getContentPane().setBackground(Color.GRAY);
		this.getContentPane().setFont(new Font("Tahoma", Font.BOLD, 22));
		this.getContentPane().setBounds(new Rectangle(10, 11, 623, 68));
		this.setBounds(100, 100, 540, 325);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        StudentPanel studentPanel = new StudentPanel();
        addNavigationButton(studentPanel, "studentPanel");
        cardPanel.add(studentPanel, "studentPanel");

        AdminPanel adminPanel = new AdminPanel(cardLayout, cardPanel);
        addNavigationButton(adminPanel, "adminPanel");
        cardPanel.add(adminPanel, "adminPanel");

        HomePanel homePanel = new HomePanel(cardLayout, cardPanel);
        cardPanel.add(homePanel, "homePanel");

        add(cardPanel, BorderLayout.CENTER);

        cardLayout.show(cardPanel, "homePanel");
        setResizable(false);
        setVisible(true);
    }
    // button to home
    public void addNavigationButton(JPanel panel, String targetPanel) {
        JButton homeButton = new JButton("Home");
        homeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "homePanel");
                setSize(540, 325);
                
            }
        });
        panel.add(homeButton, BorderLayout.NORTH);
    }
    
    public static void main(String[] args) {  
        new Project();
    }
    
}
