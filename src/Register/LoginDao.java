package Register;

import java.sql.*;  
public class LoginDao {  
  
public static boolean validate(LoginBean bean){  
boolean status=false;  
try{  
Connection con=ConnectionProvider.getCon();  
              
PreparedStatement ps=con.prepareStatement(  
    "select * from Users where email=? and password=?");  
  
ps.setString(1,bean.getEmail());  
ps.setString(2,bean.getPass());  
              System.out.println(bean.getEmail());
              System.out.println(bean.getPass());
ResultSet rs=ps.executeQuery();  
status=rs.next();  
              
}catch(Exception e){
	System.out.println(e);
}  
  
return status;  
  
}  
}  
