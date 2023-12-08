package ihmProject;

import java.awt.*;
import javax.swing.*;


import javax.swing.JFrame;

public class Pfe extends JFrame{
	JPanel pan1 , pan2;
	JLabel lab1 , lab2 , lab3 , lab4 ,lab5;
	JTextField tf1 ,tf2 ,tf3 ,tf4 ,tf5 ;
	JButton btn1 ,btn2;
	
	public Pfe() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("PFE Card");
		this.setBounds( 300, 200, 300, 300);
		
        pan1= new JPanel();
        pan2= new JPanel();
        
        lab1= new JLabel ("Referece");
        lab2= new JLabel ("Title");
        lab3= new JLabel ("Author");
        lab4= new JLabel ("Year");
        lab5= new JLabel ("Framer");
        tf1= new JTextField();
        tf2= new JTextField();
        tf3= new JTextField();
        tf4= new JTextField();
        tf5= new JTextField();
        pan1.add (lab1);
        pan1.add (tf1);
        pan1.add (lab2);
        pan1.add (tf2);
        pan1.add (lab3);
        pan1.add (tf3);
        pan1.add (lab4);
        pan1.add (tf4);
        pan1.add (lab5);
        pan1.add (tf5);
        pan1.setLayout(new BoxLayout(pan1, BoxLayout.Y_AXIS));
        
        btn1= new JButton("Add");
        btn2= new JButton("Save");
        pan2.add(btn1);
        pan2.add(btn2);
        pan2.setLayout(new FlowLayout());
        this.add(pan1,BorderLayout.NORTH);
        this.add(pan2,BorderLayout.SOUTH);
        
		this.setVisible(true);
		
	}
	
	public static void main (String[] args) {
		Pfe Frame =new Pfe();
	}
	}
