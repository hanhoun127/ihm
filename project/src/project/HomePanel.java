package project;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;

public class HomePanel extends JPanel {
    JButton studentButton,adminButton;
    ImageIcon stdIcon,admIcon;
    JLabel stdLabel,admLabel;
    JPanel stdPanel,admPanel;
    public HomePanel(CardLayout cardLayout, JPanel cardPanel) {     
        studentButton = new JButton("GO To Student Space");
        adminButton = new JButton("GO To Admin Space");

        stdIcon = new ImageIcon(getClass().getResource("img/student.png"));
        stdLabel = new JLabel(stdIcon);

        admIcon = new ImageIcon(getClass().getResource("img/admin.png"));
        admLabel = new JLabel(admIcon);

        studentButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "studentPanel");
                ((Project) SwingUtilities.getWindowAncestor(HomePanel.this)).setSize(470, 325);
            }
        });

        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "adminPanel");
                ((Project) SwingUtilities.getWindowAncestor(HomePanel.this)).setSize(350, 200);
            }
        });

        stdPanel = new JPanel();
        stdPanel.add(stdLabel);
        stdPanel.add(studentButton);
        stdPanel.setBorder(new LineBorder(Color.BLACK, 2));
        stdPanel.setLayout(new BoxLayout(stdPanel, BoxLayout.Y_AXIS));
        admPanel = new JPanel();
        admPanel.add(admLabel);
        admPanel.add(adminButton);
        admPanel.setBorder(new LineBorder(Color.BLACK, 2));
        admPanel.setLayout(new BoxLayout(admPanel, BoxLayout.Y_AXIS));
        
        setLayout(new BorderLayout());
        add(stdPanel, BorderLayout.WEST);
        add(admPanel, BorderLayout.EAST);
    }
    
}
