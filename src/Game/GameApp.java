package Game;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import Database.SqliteHelper;



public class GameApp {
	static String user;
	
	public static double balance,share, share_price , updated_shares, updated_sold_shares;
	public static boolean buy_shares(String StockName,double StockValue,double purchased_share)
	{
		Random rand = new Random();

		int  n = rand.nextInt(100000) + 1;
		share_price=StockValue;
		balance=getBalance(DashboardProvider.getUser());
		float brokerage=getbrokerage();
		user= DashboardProvider.getUser();
		if(balance>=(purchased_share*share_price))
		{
			double Spent=purchased_share * share_price;
			try {
				Connection con=SqliteHelper.getConn();
			balance = balance - (purchased_share * share_price);
			System.out.println(brokerage);
			balance= balance-((purchased_share * share_price)*brokerage/100);
			
			
			
				PreparedStatement ps=con.prepareStatement("insert into "+user+" (PurchaseID,Date_purchased,StockName,Price,Bought_Stock,Sold_Stock,Amount_Spent,Current_Balance,Brokerage) values(?,?,?,?,?,?,?,?,?)");
				ps.setInt(1, n);
				ps.setString(2, "26/10/2018");
				ps.setString(3, StockName);
				ps.setFloat(4, (float)StockValue);
				ps.setFloat(5,(float) purchased_share);
				ps.setFloat(6, 0);
				ps.setFloat(7,(float)Spent);
				ps.setFloat(8, (float)balance);
				ps.setFloat(9, brokerage);
				ps.executeUpdate();
				
				
			} catch (Exception e) {
			
				e.printStackTrace();
				return false;
			}
			try {
				Connection con=SqliteHelper.getConn();
			String updatebalance="UPDATE Users SET balance = "+balance+" WHERE username = '"+user+"';";
			
			
			PreparedStatement psupdate=con.prepareStatement(updatebalance);
			psupdate.executeUpdate();
			}catch (Exception e) {
			
				e.printStackTrace();
				return false;
			}
			double transaction = 0;
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
					transaction = rs.getFloat("transactions");
					System.out.println(transaction);
					
				} catch (Exception e) {
					e.printStackTrace();
				} 

			transaction=transaction+Spent;
			
			try {
				Connection con=SqliteHelper.getConn();
			String updatebalance="UPDATE Users SET transactions = "+transaction+" WHERE username = '"+user+"';";
			
			
			PreparedStatement psupdate=con.prepareStatement(updatebalance);
			psupdate.executeUpdate();
			}catch (Exception e) {
			
				e.printStackTrace();
				return false;
			}
			
			
			
			
			return true;
		}
		else
		{
			System.out.println("");
			System.out.println("Insufficient Balance!");
			System.out.println("");
			return false;
		}
	}
	private static float getbrokerage() {
		
		float brokerage = 5; 
		try {
			Connection con=SqliteHelper.getConn();
		  PreparedStatement ps;
			ResultSet rs=null;
			user= DashboardProvider.getUser();
			
			String sqlurl="select * from Users where username='"+user+"'";
			//where username='"+getUser()+"';
		System.out.println(sqlurl);
				ps = con.prepareStatement(sqlurl);
				
				rs=ps.executeQuery();
				System.out.println("Hello");
				 brokerage = rs.getFloat("brokerage");
				System.out.println(brokerage);
				
			} catch (Exception e) {
				e.printStackTrace();
			} 
			
			
			
			return brokerage;
	}
	public static String getStockDetails(String userName) {
		
		
		
			PreparedStatement ps;
			try {
				Connection con=SqliteHelper.getConn(); 
				ps = con.prepareStatement("Select * from "+user);
				//ps.setString(1, userName);
				
				ResultSet rs=ps.executeQuery();
				
				System.out.println("works");
				String s="Displaying all stocks you currently own</br>";
				int i=1;
				while(rs.next()) {
					
				//String number=String.valueOf(rs.getInt(1));
					String formatted = String.format("%06d", rs.getInt(1));
					s=s+":"+(i++)+":"+"</br>PurchaseID"+"-"+formatted
					+"</br>Date_purchased"+"-"+rs.getString(2)
					+"</br>StockName"+"-"+rs.getString(3)
					+"</br>Price of Stock"+"-"+String.valueOf(rs.getFloat(4))
					+"</br>Bought_StocK at"+"-"+String.valueOf(rs.getFloat(5))
					+"</br>Sold_Stock at"+"-"+String.valueOf(rs.getFloat(6))
					+"</br>Amount spent"+"-"+String.valueOf(rs.getFloat(7))
					+"</br>Balance"+"-"+String.valueOf(rs.getFloat(8)+"</br>");
					
				}
				
				
				return s;
			} catch (Exception e) {
				
				e.printStackTrace();
				return "error";
			}
			
	}
	private static double getBalance(String userName) {
		
		double balance=100000;
			try {
				Connection con=SqliteHelper.getConn(); 
				PreparedStatement ps=con.prepareStatement("Select * from "+userName+"");
				//ps.setString(1, userName);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					
					balance=rs.getFloat(8);
				}
				return balance;
				
				} catch (Exception e) {
					e.printStackTrace();
					return balance;
				
			}
		
	}
	public static void sell_shares(int ID)
	//DELETE FROM COMPANY WHERE ID = 7;
	{
		PreparedStatement ps;
	
		try {
			Connection con=SqliteHelper.getConn(); 
			ps = con.prepareStatement("DELETE FROM "+user+" WHERE PurchaseID = "+ID+";");

			ps.execute();
		}
		catch(Exception e) {
			
			
		}
	}
		

	public static void setUser(String u) {
		
		user=u;
	}
	public static String getUser() {
		
		return user;
	}
	
	

}
