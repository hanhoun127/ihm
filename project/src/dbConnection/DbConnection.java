package dbConnection;
import java.sql.*;
public class DbConnection {
    private static Connection con;
    private static String URL="jdbc:mysql://localhost:3306/ihm";
    private static String USER="root";
    private static String PASSWORD="";
    // methode to etablish connection to database
    public static Connection connect() throws SQLException {
    return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    // methode to close the connection
    public static void close() throws SQLException {
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }


}
