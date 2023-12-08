package ihmProject;

import java.awt.*;
import javax.swing.*;


import javax.swing.JFrame;

public class Login extends JFrame{
	JPanel pan1 , pan2;
	JLabel lab1 , lab2;
	JTextField tf1 ;
	JPasswordField tf2 ;
	JButton btn1;
	
	public Login() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Login");
		this.setBounds( 300, 150 , 300, 150);
		
        pan1= new JPanel();
        pan2= new JPanel();
        
        lab1= new JLabel ("Your ID");
        lab2= new JLabel ("Password");
        tf1= new JTextField();
        tf2= new JPasswordField();
        pan1.add (lab1);
        pan1.add (tf1);
        pan1.add (lab2);
        pan1.add (tf2);
        pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
        
        btn1= new JButton("Login");
        pan2.add(btn1);
        pan2.setLayout(new FlowLayout());
        this.add(pan1,BorderLayout.NORTH);
        this.add(pan2,BorderLayout.SOUTH);
        
		this.setVisible(true);
		
	}
	
	public static void main (String[] args) {
		Login Frame =new Login();
	}
	}
