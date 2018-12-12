package Register;

import java.sql.*;

import Database.SqliteHelper;
import Game.DashboardProvider;  
public class LoginDao {  
  
public static boolean validate(LoginBean bean){  
boolean status=false;  
try{  

Connection con=SqliteHelper.getConn();
              
PreparedStatement ps=con.prepareStatement(  
    "select * from Users where email=? and password=?");  
  
ps.setString(1,bean.getEmail());  
ps.setString(2,bean.getPass());  
              System.out.println(bean.getEmail());
              System.out.println(bean.getPass());
              DashboardProvider.setEmail(bean.getEmail());
ResultSet rs=ps.executeQuery();  
status=rs.next();  
    

}catch(Exception e){
	System.out.println("Login");
	System.out.println(e);
}  
  
return status;  
  
}  
}  
