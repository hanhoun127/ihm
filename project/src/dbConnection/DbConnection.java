package dbConnection;
import java.sql.*;

import javax.swing.JOptionPane;
public class DbConnection {
    private static Connection con;
    private static String URL="jdbc:mysql://localhost:3306/ihm";
    private static String USER="root";
    private static String PASSWORD="";
    // methode to etablish connection to database
    public static Connection connect() {
    
    try {
			Class.forName("com.mysql.cj.jdbc.Driver"); 
			con= DriverManager.getConnection(URL,USER,PASSWORD);
			
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e);
		}
		catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e);
		}
    return con;
    }


}
