package Game;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Database.SqliteHelper;
import Register.LoginBean;


public class DashboardProvider {
	
		private static String Email,Username;
		private static float balance;
		public static String getUser(){  
		int status=0;  
		
		
		try{  
			Connection con=SqliteHelper.getConn();
		   
		PreparedStatement ps=con.prepareStatement("select * from Users where email='"+Email+"'");  
		  
		  
		ResultSet rs=ps.executeQuery(); 
		Username=rs.getString(1);
		
		return Username;
		
		}catch(Exception e){System.out.println(e);}  
		      
		return "pav";  
		}  
	public static double getBalance(String email) {
		GameApp.setUser(getUser());
		
		
       
	try {
		
		Connection con = SqliteHelper.getConn();
	  PreparedStatement ps;
		ResultSet rs=null;
		String user=getUser();
		String sqlurl="select * from Users where username='"+user+"'";
		//where username='"+getUser()+"';
	System.out.println(sqlurl);
			ps = con.prepareStatement(sqlurl);
			
			rs=ps.executeQuery();
			System.out.println("Hello");
			balance = rs.getFloat("balance");
			System.out.println(balance);
			
		} catch (Exception e) {
			e.printStackTrace();
		} 
		
		
		
		return balance;
	}
	public static String getEmail()
	{
		
		return Email;
		
	}
	public static void setEmail(String email) {
		Email=email;
		
	}
	
		  
		}
