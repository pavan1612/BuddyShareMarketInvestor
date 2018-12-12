package Game;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.patriques.output.timeseries.data.StockData;

import Database.SqliteHelper;
import StockData.App;

public class Limit {
	
static String Name;
	public static void limitAt(String option,String option2) {
		
		try {
			Connection con=SqliteHelper.getConn();
		
			String user= DashboardProvider.getUser();
		
		
			PreparedStatement ps=con.prepareStatement("insert into "+user+"Limit (StockName,Price,Bought_Stock) values(?,?,?)");
			
			ps.setString(1, Name);
			
			ps.setFloat(2,Float.parseFloat(option));
			ps.setFloat(3, Float.parseFloat(option2));
			ps.executeUpdate();
			
			
		} catch (Exception e) {
		
			e.printStackTrace();
			
		}
	}
	public static void setStockName(String name) {
		
		Name=name;
	}
	
	public static void checklimit() {
		
		try {
			
			Connection con = SqliteHelper.getConn();
		  PreparedStatement ps;
			ResultSet rs=null;
			String user=GameApp.getUser();
			String sqlurl="select * from "+user+"Limit" ;
			//where username='"+getUser()+"';
		System.out.println(sqlurl);
				ps = con.prepareStatement(sqlurl);
				
				rs=ps.executeQuery();
				while(rs.next()) {
				String name=rs.getString(1);
				Float price=(rs.getFloat(2));
				Float numberofstocks=(rs.getFloat(3));
				System.out.println(name);
				tryLimit(name,price,numberofstocks);
						
						
					}
			} catch (Exception e) {
				e.printStackTrace();
			} 
	}
	private static void tryLimit(String name2, Float price, Float numberofstocks) {
		System.out.println(price);
		List<StockData> stockdata=App.getList(name2,3);
	    double CurrentPrice=0;
	    int i=1;
	    for (StockData stock : stockdata) {
	    	if(i==1){
	    		CurrentPrice=stock.getClose();
	    		System.out.println(CurrentPrice);
	    		i++;
	    	}
	    }
	    if(CurrentPrice<=price) {
	    	System.out.println("Inside the if ");
	    	GameApp.buy_shares(name2, CurrentPrice, numberofstocks);
	    	remove(name2);
	    }
		
	}
	private static void remove(String name2) {
		PreparedStatement ps;
		String user= DashboardProvider.getUser();
		try {
			Connection con=SqliteHelper.getConn(); 
			ps = con.prepareStatement("DELETE FROM "+user+"Limit WHERE StockName = '"+name2+"';");

			ps.execute();
		}
		catch(Exception e) {
			System.out.println(e);
			
		}
		
	}

}
