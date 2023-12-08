import javax.swing.*;
import java.awt.*;
public class student extends JFrame{
    JLabel lb;
    public student(){
        setTitle("Home");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        lb = new JLabel("hello im student ");
        add(lb,BorderLayout.CENTER);
        setVisible(true);
    }
    public static void main(String[] args) {
        new student();
    }
}
