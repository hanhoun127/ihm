package ihmProject;

import java.awt.*;
import javax.swing.*;

public class Searchpfe extends JFrame{
	JPanel pan1,pan2 ;
	JButton btn ;
	JTextField tf;
	
	public Searchpfe() {
		
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Search Pfe");
        pan1= new JPanel();
        pan2= new JPanel();
		btn= new JButton("Search");
		tf= new JTextField();
		pan1.add(tf);
		pan1.add(btn);
		pan1.setLayout(new BoxLayout(pan1, BoxLayout.X_AXIS));
        this.add(pan1,BorderLayout.NORTH);
        this.add(pan2,BorderLayout.SOUTH);
        this.setSize(300,300);
		this.setVisible(true);
		
	}
	
	public static void main (String[] args) {
		Searchpfe Frame =new Searchpfe();
	}
	}
