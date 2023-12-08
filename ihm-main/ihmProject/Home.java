package ihmProject;

import java.awt.*;
import javax.swing.*;


import javax.swing.JFrame;

public class Home extends JFrame{
	JPanel pan ;
	JButton btn1,btn2 ;
	
	public Home() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Home");
		btn1= new JButton("Student Space");
		btn2= new JButton("Admin Space");
        pan= new JPanel();
        pan.add(btn1);
        pan.add(btn2);
        pan.setLayout(new GridLayout( 1,2,20,50));
        this.add(pan,BorderLayout.CENTER);
        this.setSize(300,300);
		this.setVisible(true);
		
	}
	
	public static void main (String[] args) {
		Home Frame =new Home();
	}
	}
