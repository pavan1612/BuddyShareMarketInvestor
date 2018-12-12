package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.SqliteHelper;

public class SellStocks {
	static double Balance;
	static String StockDetails;
	public static String getDetails(String output,String option) {
		
		String words[]=output.split(":");
		System.out.println(words.length);

		int i=1;
		while(i<words.length) {
			if(words[i].equals(option)) {
				
				return words[i+1];
			}
			
			
			
			i=i+2;
		}
		return "error";
	}
	
	
	public static void setStock(String stockdetails) {
		
		StockDetails=stockdetails;
	}
	
	public static String sell() {
		
		
		
		String[] words=StockDetails.split("-");
		String id = words[1].substring(0, Math.min(words[1].length(), 6));
		
		int TranID=Integer.parseInt(id);
		System.out.println(TranID);
		double Oldbalance=DashboardProvider.getBalance(DashboardProvider.getUser());
		double Newbalance=Oldbalance+Balance;
		String user=GameApp.getUser();
		try {
			Connection con ;
			
				con = SqliteHelper.getConn();
			
		String updatebalance="UPDATE Users SET balance = "+Newbalance+" WHERE username = '"+user+"';";
		
		PreparedStatement psupdate=con.prepareStatement(updatebalance);
		psupdate.executeUpdate();
	} catch (Exception e) {
	
		e.printStackTrace();
	}
		
		double transaction = 0;
		try {
			
			Connection con = SqliteHelper.getConn();
		  PreparedStatement ps;
			ResultSet rs=null;
			//String user1=getUser();
			String sqlurl="select * from Users where username='"+user+"'";
			//where username='"+getUser()+"';
		System.out.println(sqlurl);
				ps = con.prepareStatement(sqlurl);
				
				rs=ps.executeQuery();
				System.out.println("Hello");
				transaction = rs.getFloat("transactions");
				System.out.println(transaction);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 

		transaction=transaction+Balance;
		
		try {
			Connection con=SqliteHelper.getConn();
		String updatebalance="UPDATE Users SET transactions = "+transaction+" WHERE username = '"+user+"';";
		
		
		PreparedStatement psupdate=con.prepareStatement(updatebalance);
		psupdate.executeUpdate();
		}catch (Exception e) {
		
			e.printStackTrace();
			
		}
		
		
		
		
		
		
		GameApp.sell_shares(TranID);
		return id;
	}
	public static void setStockValues(double balance) {
		
		Balance=balance;
	}

}
