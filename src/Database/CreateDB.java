package Database;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
 

public class CreateDB {
     /**
     * Connect to a sample database
     */
    public static void connect() {
        Connection conn = null;
        try {
            // db parameters
            String url = "jdbc:sqlite:C:/Users/Pavan BoreGowda/eclipse-workspace/LoginPage/Database/StockDB";
            // create a connection to the database
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }
    public static void createNewTable() {
        // SQLite connection string
        String url = "jdbc:sqlite:C:/Users/Pavan BoreGowda/eclipse-workspace/LoginPage/Database/StockDB";
        
        // SQL statement for creating a new tabl username,email,password,brokerage
       String sql = "CREATE TABLE IF NOT EXISTS Users (\n"
                + "	username text PRIMARY KEY,\n"
                + "	email text NOT NULL,\n"
                + "	password text,\n"
                + "	brokerage real,\n"
                + "	balance real,\n"
                + "	transactions real\n"
                + ");";
        
        String sqltabledrop ="Drop table Users;";
        String sqlDBdrop ="DETACH DATABASE StockDB";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        connect();
        createNewTable();
    }
}
