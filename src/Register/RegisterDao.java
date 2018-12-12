package Register;

import java.sql.*;

import Database.SqliteHelper;  

public class RegisterDao {  
  
public static int register(User u){  
int status=0;  
try{  
	Connection con=SqliteHelper.getConn();
PreparedStatement ps=con.prepareStatement("insert into Users(username,email,password,brokerage,balance,transactions) values(?,?,?,?,?,?)");  
ps.setString(1,u.getUname());  
ps.setString(2,u.getUemail());  
ps.setString(3,u.getUpass());  
ps.setFloat(4, 5); 
ps.setFloat(5, 100000); 
ps.setFloat(6, 0); 
status=ps.executeUpdate(); 
String tablename=u.getUname();
PreparedStatement pscreate =con.prepareStatement("CREATE TABLE "+tablename+" (PurchaseID integer,Date_purchased text,StockName text,Price real,Bought_Stock real,Sold_Stock real,Amount_Spent real,Current_Balance real,Brokerage real);"); 

if(pscreate.executeUpdate()>0){
	System.out.println("success in creating transaction table");
	
} 
tablename=u.getUname()+"Limit";
PreparedStatement pslimit =con.prepareStatement("CREATE TABLE "+tablename+" (StockName text,Price real,Bought_Stock real);");
pslimit.executeUpdate();

tablename=u.getUname()+"StopLoss";
PreparedStatement psloss =con.prepareStatement("CREATE TABLE "+tablename+" (PurchaseID integer,StockName text,Price real);");

psloss.executeUpdate();

}catch(Exception e){System.out.println("Register problem");
	System.out.println(e);}  
      
return status;  
}  
  
}

