package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;

import Database.SqliteHelper;

public class Delist {
	
	public static void DelistUser(String user){
		try {
			PreparedStatement ps;
			Connection con=SqliteHelper.getConn(); 
			ps = con.prepareStatement("DELETE FROM Users WHERE username = '"+user+"';");

			ps.execute();
			System.out.println("Delisted");
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
	
		try {
			PreparedStatement ps;
			Connection con=SqliteHelper.getConn(); 
			ps = con.prepareStatement("DROP TABLE "+user+";");

			ps.execute();
			System.out.println("Delisted");
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		try {
			PreparedStatement ps;
			Connection con=SqliteHelper.getConn(); 
			ps = con.prepareStatement("DROP TABLE "+user+"Limit;");

			ps.execute();
			System.out.println("Delisted");
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
		
	}
	
	

}
