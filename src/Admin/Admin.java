package Admin;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import Database.SqliteHelper;
import Game.GameApp;

public class Admin {
	static String User;
		
		public static void getTransactionAmount() {
float transaction;
try {
				
				Connection con = SqliteHelper.getConn();
			  PreparedStatement ps;
				ResultSet rs=null;
				String user=GameApp.getUser();
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
	}
		public static String getUserDetails() {
			String s = "Users";
			try {
			Connection con = SqliteHelper.getConn();
			  PreparedStatement ps;
				ResultSet rs=null;
				
				String sqlurl="select * from Users";
				
					ps = con.prepareStatement(sqlurl);
					
					int i=1;
					rs=ps.executeQuery();
					while(rs.next()) {
						
						s=s+":"+(i++)+":"+"</br>User"+"-"+rs.getString(1)
								+"</br>Email"+"-"+rs.getString(2)
								+"</br>brokerage"+"-"+String.valueOf(rs.getFloat(4))
								+"</br>balance"+"-"+String.valueOf(rs.getFloat(5))
								+"</br>Transaction"+"-"+String.valueOf(rs.getFloat(6))
								+"</br>";
					}
					
					
				} catch (Exception e) {
					e.printStackTrace();
				} 
			return s;
		}
		public static String getHighestTraders(){
			try {
				Connection con = SqliteHelper.getConn();
				  PreparedStatement ps;
					ResultSet rs=null;
					
					String sqlurl="select MAX(transactions),username from Users";
					
						ps = con.prepareStatement(sqlurl);
						rs=ps.executeQuery();
						String s="User with highest Transaction is "+rs.getString(2)+" with a transaction of "+rs.getDouble(1);
						
						return s;
						
					} catch (Exception e) {
						e.printStackTrace();
					} 
			return "error";
			
		}
		public static void changeBrokerage(String brokerage) {
			String user=GameApp.getUser();
			try {
				Connection con ;
				
					con = SqliteHelper.getConn();
				
			String updatebalance="UPDATE Users SET brokerage = "+brokerage+" WHERE username = '"+User+"';";
			
			PreparedStatement psupdate=con.prepareStatement(updatebalance);
			psupdate.executeUpdate();
		} catch (Exception e) {
		
			e.printStackTrace();
		}
		}
		public static void setUserTochange(String option){
			
			User=option;
		}
	}
