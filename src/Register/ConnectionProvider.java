package Register;

import java.sql.*;  
import static Register.Provider.*;  
  
public class ConnectionProvider {  
private static Connection con=null;  
static{  
try{  
Class.forName(DRIVER);  
con=DriverManager.getConnection(CONNECTION_URL,USERNAME,PASSWORD);  
}catch(Exception t){ 
System.out.println(t);
}  
}
public static Connection getCon(){  
    return con;  
}  
  
} 