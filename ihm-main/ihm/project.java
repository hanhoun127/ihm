import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame {
    JPanel jp1,jpc1,jpc2,jp2,jpc3,jpc4,jp3,jp4,jp5,bPanel1,bpanel2,bpanel3,cardpanel;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    JMenu menu1,menu2;
    JMenuItem itm1,itm2,itm3,itm4,itm5,itm6;
    JMenuBar menu;
    CardLayout cardLayout=new CardLayout();
    Container ContentPane;

/**
 * 
 */
public project(){
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setTitle("Home");
    setBounds(450, 200, 400, 300);

    cardpanel=new JPanel();
    cardpanel.setLayout(cardLayout);

    btn1=new JButton("Student Space");
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardpanel,"1");
        }
    });

    btn2=new JButton("Admin Space");
    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(cardpanel,"2");
        }
    });

    cardpanel.add(btn1);
    cardpanel.add(btn2);

    jp1=new JPanel();
    tf1=new JTextField();
    btn3=new JButton("Search");
    jpc1=new JPanel();
    jpc2=new JPanel();
    jpc1.add(tf1);
    jpc1.add(btn3);
    jpc1.setLayout(new BoxLayout(jpc1,BoxLayout.X_AXIS));
    jp1.add(jpc1);
    jp1.add(jpc2);
    jp1.add(jpc1,BorderLayout.NORTH);
    jp1.add(jpc2,BorderLayout.SOUTH);
    cardpanel.add(jp1,"1");

    jp2=new JPanel();
    jpc3= new JPanel();
    jpc4= new JPanel();
        
    lb1= new JLabel ("Your ID");
    lb2= new JLabel ("Password");
    tf2= new JTextField();
    tf3= new JPasswordField();
    jpc3.add (lb1);
    jpc3.add (tf2);
    jpc3.add (lb2);
    jpc3.add (tf3);
    jpc3.setLayout(new BoxLayout(jpc3, BoxLayout.Y_AXIS));
    btn4= new JButton("Login");
    jpc4.add(btn4);
    jpc4.setLayout(new FlowLayout());
    jp2.add(jpc3,BorderLayout.NORTH);
    jp2.add(jpc4,BorderLayout.SOUTH);
    cardpanel.add(jp2,"2");



    this.add(cardpanel,BorderLayout.CENTER);
    setVisible(true);
}   
public static void main(String[]args){
    project frame =new project();

}
}
