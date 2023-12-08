import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class project extends JFrame {
    JPanel jp1,jpc1,jpc2,jp2,jpc3,jpc4,jp3,jp4,jpc5,jpc6,jp5,jpc7,jpc8,bPanel1,bpanel2,bpanel3,panel,buttonPanel;
    JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7,lb8,lb9,lb10,lb11;
    JTextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9,tf10,tf11,tf12;
    JButton btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;
    JMenu menu1,menu2;
    JMenuItem itm1,itm2,itm3,itm4,itm5,itm6,itm7,itm8;
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
    panel=new JPanel();
    buttonPanel=new JPanel();
    panel.setLayout(cardLayout);

    btn1=new JButton("Student Space");
    btn1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(panel,"1");
        }
    });

    btn2=new JButton("Admin Space");
    btn2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(panel,"2");
        }
    });

    buttonPanel.add(btn1);
    buttonPanel.add(btn2);
    buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
    panel.add(buttonPanel,BorderLayout.CENTER);

    // search......................................................
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
    panel.add(jp1,"1");

    // logein.....................................................
    jp2=new JPanel();
    jp2.setLayout(cardLayout);
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
    btn4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(jp2,"3");
        }
    });
    jpc4.add(btn4);
    jpc4.setLayout(new BoxLayout(jpc4, BoxLayout.Y_AXIS));
    // jp2.add(jpc3,BorderLayout.NORTH);
    jp2.add(jpc4,BorderLayout.SOUTH);
    panel.add(jp2,"2");


    // CRUD..............................................................
    jp3=new JPanel();
    jp3.setLayout(cardLayout);
    menu1 = new JMenu("Pfe");
    menu2 = new JMenu("Prof");
    itm1= new JMenuItem("Creat");
    itm1.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(jp3,"4");
        }
    });
    itm2= new JMenuItem("Update");
    itm2.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(jp3,"4");
        }
    });
    itm3= new JMenuItem("Delete");
    itm4= new JMenuItem("Creat");
    itm4.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(jp3,"5");
        }
    });
    itm5= new JMenuItem("Update");
    itm5.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent e){
            cardLayout.show(jp3,"5");
        }
    });
    itm6= new JMenuItem("Delete");
    itm7= new JMenuItem("Listing");
    itm8= new JMenuItem("Listing");
    menu1.add(itm1);
    menu1.add(itm2);
    menu1.add(itm3);
    menu1.add(itm7);
    menu2.add(itm4);
    menu2.add(itm5);
    menu2.add(itm6);
    menu2.add(itm8);
    menu = new JMenuBar() ;
    menu.add(menu1);
    menu.add(menu2);
    // ContentPane = getContentPane();
    // ContentPane.add(menu, BorderLayout.NORTH);
    jp3.add(menu, BorderLayout.NORTH);
    jp2.add(jp3,"3");


    // PFE................................................................
        jp4=new JPanel();
        jpc5= new JPanel();
        jpc6= new JPanel();
        
        lb3= new JLabel ("Referece");
        lb4= new JLabel ("Title");
        lb5= new JLabel ("Author");
        lb6= new JLabel ("Year");
        lb7= new JLabel ("Framer");
        tf4= new JTextField();
        tf5= new JTextField();
        tf6= new JTextField();
        tf7= new JTextField();
        tf8= new JTextField();
        jpc5.add (lb3);
        jpc5.add (tf4);
        jpc5.add (lb4);
        jpc5.add (tf5);
        jpc5.add (lb5);
        jpc5.add (tf6);
        jpc5.add (lb6);
        jpc5.add (tf7);
        jpc5.add (lb7);
        jpc5.add (tf8);
        jpc5.setLayout(new BoxLayout(jpc5, BoxLayout.Y_AXIS));
        
        btn5= new JButton("Add");
        btn6= new JButton("Save");
        jpc6.add(btn5);
        jpc6.add(btn6);
        jpc6.setLayout(new FlowLayout());
        jp4.add(jpc5,BorderLayout.NORTH);
        jp4.add(jpc6,BorderLayout.SOUTH);
        jp3.add(jp4,"4");


        // PROF................................................................
        jp5=new JPanel();
        jpc7= new JPanel();
        jpc8= new JPanel();
        
        lb8= new JLabel ("First Name");
        lb9= new JLabel ("Last Name");
        lb10= new JLabel ("Email");
        lb11= new JLabel ("Sepcialite");
        tf9= new JTextField();
        tf10= new JTextField();
        tf11= new JTextField();
        tf12= new JTextField();
        jpc7.add (lb8);
        jpc7.add (tf9);
        jpc7.add (lb9);
        jpc7.add (tf10);
        jpc7.add (lb10);
        jpc7.add (tf11);
        jpc7.add (lb11);
        jpc7.add (tf12);
        jpc7.setLayout(new BoxLayout(jpc7, BoxLayout.Y_AXIS));
        
        btn7= new JButton("Add");
        btn8= new JButton("Save");
        jpc8.add(btn7);
        jpc8.add(btn8);
        jpc8.setLayout(new FlowLayout());
        jp5.add(jpc7,BorderLayout.NORTH);
        jp5.add(jpc8,BorderLayout.SOUTH);
        jp3.add(jp5,"5");



    this.add(panel);
    setVisible(true);
}   
public static void main(String[]args){
    new project();

}
}
