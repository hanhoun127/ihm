import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Project extends JFrame {
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public Project() {
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);

        // Create card panel with CardLayout
        cardPanel = new JPanel();
        cardLayout = new CardLayout();
        cardPanel.setLayout(cardLayout);

        // Create Student panel
        JPanel studentPanel = createPanel("Student Panel", Color.GREEN);
        addNavigationButton(studentPanel, "studentPanel");

        // Create Admin panel
        JPanel adminPanel = createPanel("Admin Panel", Color.BLUE);
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

        setVisible(true);
    }

    private JPanel createPanel(String title, Color color) {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBackground(color);

        JLabel label = new JLabel(title, SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 24));
        panel.add(label, BorderLayout.CENTER);

        return panel;
    }

    private JPanel createHomePanel() {
        JPanel homePanel = new JPanel(new BorderLayout());

        JButton studentButton = new JButton("Student");
        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "studentPanel");
            }
        });

        JButton adminButton = new JButton("Admin");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminPanel");
            }
        });

        homePanel.add(studentButton, BorderLayout.WEST);
        homePanel.add(adminButton, BorderLayout.EAST);

        // Content for the Home panel
        JLabel homeContentLabel = new JLabel("Welcome to the Home Page!", SwingConstants.CENTER);
        homeContentLabel.setFont(new Font("Arial", Font.BOLD, 24));
        homePanel.add(homeContentLabel, BorderLayout.CENTER);

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
        SwingUtilities.invokeLater(() -> new Project());
    }
}
