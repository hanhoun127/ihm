import java.sql.*;
public class db {
    public static void main(String[] args) throws Exception {
        try {
                Class.forName("com.mysql.cj.jdbc.Driver");
                Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "");
                if (con.isValid(5))  // Check if the connection is valid within 5 seconds
                    System.out.println("Connected to the database!");
        } catch (Exception e) {
                System.out.println(e);
        }
    }
}
