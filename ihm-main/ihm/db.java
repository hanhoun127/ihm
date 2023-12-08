import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class db {

    private static final Logger logger = Logger.getLogger(db.class.getName());

    public static void main(String[] args) {
        db pro = new db();
        pro.createConnection();
    }

    public void createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            try (Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/ihm", "root", "");
                 Statement stmt = con.createStatement()) {
                System.out.println("Database connection success");
            } catch (SQLException ex) {
                logger.log(Level.SEVERE, "SQL error occurred", ex);
                // Take appropriate action or display an error message to the user
            }
        } catch (ClassNotFoundException ex) {
            logger.log(Level.SEVERE, "Driver not found", ex);
            // Take appropriate action or display an error message to the user
        }
    }
}
