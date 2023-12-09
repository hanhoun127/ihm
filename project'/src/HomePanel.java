import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePanel extends JPanel {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public HomePanel(CardLayout cardLayout, JPanel cardPanel) {
        this.cardLayout = cardLayout;
        this.cardPanel = cardPanel;

        JButton studentButton = new JButton("GO To Student Space");
        JButton adminButton = new JButton("GO To Admin Space");

        ImageIcon stdIcon = new ImageIcon(getClass().getResource("img/student.png"));
        JLabel stdLabel = new JLabel(stdIcon);

        ImageIcon admIcon = new ImageIcon(getClass().getResource("img/admin.png"));
        JLabel admLabel = new JLabel(admIcon);

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "studentPanel");
                ((Project) SwingUtilities.getWindowAncestor(HomePanel.this)).setTitle("Student Space");
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminPanel");
                ((Project) SwingUtilities.getWindowAncestor(HomePanel.this)).setTitle("Admin Space");
                ((Project) SwingUtilities.getWindowAncestor(HomePanel.this)).setSize(350, 200);
            }
        });

        JPanel stdPanel = new JPanel();
        stdPanel.add(stdLabel);
        stdPanel.add(studentButton);
        stdPanel.setBorder(new LineBorder(Color.BLACK, 2));
        stdPanel.setLayout(new BoxLayout(stdPanel, BoxLayout.Y_AXIS));

        JPanel admPanel = new JPanel();
        admPanel.add(admLabel);
        admPanel.add(adminButton);
        admPanel.setBorder(new LineBorder(Color.BLACK, 2));
        admPanel.setLayout(new BoxLayout(admPanel, BoxLayout.Y_AXIS));

        setLayout(new BorderLayout());
        add(stdPanel, BorderLayout.WEST);
        add(admPanel, BorderLayout.EAST);
    }

    // Additional methods if needed
}
