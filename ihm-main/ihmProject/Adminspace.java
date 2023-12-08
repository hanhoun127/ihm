package ihmProject;

import java.awt.*;
import javax.swing.*;


import javax.swing.JFrame;

public class Adminspace extends JFrame{
	JMenuBar menu ;
	JMenu menu1 ,menu2 ;
	JMenuItem itm1, itm2, itm3, itm4, itm5, itm6;
	Container ContentPane;
	
	public Adminspace() {
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setTitle("Admin");
		
		menu1 = new JMenu("Pfe");
		menu2 = new JMenu("Prof");
		itm1= new JMenuItem("Creat");
		itm2= new JMenuItem("Update");
		itm3= new JMenuItem("Delete");
		itm4= new JMenuItem("Creat");
		itm5= new JMenuItem("Update");
		itm6= new JMenuItem("Delete");
		
		menu1.add(itm1);
		menu1.add(itm2);
		menu1.add(itm3);
		menu2.add(itm4);
		menu2.add(itm5);
		menu2.add(itm6);
		
		menu = new JMenuBar() ;
		menu.add(menu1);
		menu.add(menu2);
		ContentPane = getContentPane();
		ContentPane.add(menu, BorderLayout.NORTH);
		this.setVisible(true);
		this.setSize(220,275);
	
	}
	public static void main (String[] args) {
		new Adminspace();
	}

}
