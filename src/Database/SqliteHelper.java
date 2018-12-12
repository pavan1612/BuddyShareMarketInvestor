package Database;

import java.sql.Connection;
import java.sql.DriverManager;

public class SqliteHelper {
private static Connection c = null;
public static Connection getConn() throws Exception {
    if(c == null){
    String url = "jdbc:sqlite:C:/Users/Pavan BoreGowda/eclipse-workspace/LoginPage/Database/StockDB";
    Class.forName("org.sqlite.JDBC");
    c = DriverManager.getConnection(url);
    }
    return c;
    }
}
