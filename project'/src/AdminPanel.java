import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminPanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public AdminPanel(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        JPanel loginPanel = createLoginPanel();
        add(loginPanel);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel();
        JLabel idLabel = new JLabel("Enter your ID");
        JTextField idTextField = new JTextField();
        JLabel passwordLabel = new JLabel("Enter your password");
        JPasswordField passwordField = new JPasswordField();
        JButton loginButton = new JButton("Login");

        loginPanel.add(idLabel);
        loginPanel.add(idTextField);
        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);
        loginPanel.setLayout(new BoxLayout(loginPanel, BoxLayout.Y_AXIS));

        JLabel loginMessageLabel = new JLabel(" ");
        loginPanel.add(loginMessageLabel, BorderLayout.SOUTH);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = new String(passwordField.getPassword());
                if (!idTextField.getText().equals("12345678") || !password.equals("12345678")) {
                    loginMessageLabel.setText("The ID or the password is incorrect! Try again.");
                } else {
                    loginMessageLabel.setText("");
                    JPanel adminSpacePanel = createAdminSpace();
                    cardPanel.add(adminSpacePanel, "adminSpace");
                    cardLayout.show(cardPanel, "adminSpace");
                    ((Project) SwingUtilities.getWindowAncestor(AdminPanel.this)).setSize(550, 325);
                }
            }
        });

        return loginPanel;
    }

    private JPanel createAdminSpace() {
        JPanel adminSpacePanel = new JPanel();
        adminSpacePanel.setLayout(new CardLayout());

        JMenu pfeMenu = new JMenu("Memoire");
        JMenu profMenu = new JMenu("Professor");

        JMenuItem createPfe = new JMenuItem("Create");
        createPfe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel createPfePanel = createPfePanel();
                adminSpacePanel.add(createPfePanel, "createPfePanel");
                cardLayout.show(adminSpacePanel, "createPfePanel");
            }
        });

        JMenuItem listePfe = new JMenuItem("Liste");
        // Add ActionListener for listePfe if needed

        JMenuItem createProf = new JMenuItem("Create");
        // Add ActionListener for createProf if needed

        JMenuItem listeProf = new JMenuItem("Liste");
        // Add ActionListener for listeProf if needed

        pfeMenu.add(createPfe);
        pfeMenu.add(listePfe);
        profMenu.add(createProf);
        profMenu.add(listeProf);

        JMenuBar adminMenuBar = new JMenuBar();
        adminMenuBar.add(pfeMenu);
        adminMenuBar.add(profMenu);

        adminSpacePanel.add(adminMenuBar, BorderLayout.NORTH);

        return adminSpacePanel;
    }

    private JPanel createPfePanel() {
        JPanel createPfePanel = new JPanel();
        // Implement the creation of the Pfe panel components and layout
        return createPfePanel;
    }
}
