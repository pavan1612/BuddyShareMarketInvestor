package StockData;


import java.util.List;
import java.util.Map;
import com.google.gson.*;
import org.patriques.*;
import org.patriques.input.*;
import org.patriques.input.digitalcurrencies.*;
import org.patriques.output.AlphaVantageException;
import org.patriques.input.exchange.*;
import org.patriques.input.timeseries.*;
import org.patriques.output.*;
import org.patriques.output.digitalcurrencies.*;
import org.patriques.output.digitalcurrencies.data.*;
import org.patriques.output.exchange.*;
import org.patriques.output.exchange.data.*;
import org.patriques.output.quote.*;
import org.patriques.output.quote.data.*;
import org.patriques.output.sectorperformances.*;
import org.patriques.output.sectorperformances.data.*;
import org.patriques.output.technicalindicators.*;
import org.patriques.output.technicalindicators.data.*;
import org.patriques.output.timeseries.*;
import org.patriques.output.timeseries.Daily;
import org.patriques.output.timeseries.IntraDay;
import org.patriques.output.timeseries.Monthly;
import org.patriques.output.timeseries.Weekly;
import org.patriques.output.timeseries.data.*;

public class App {
	
	
	  public static String getStockDetails() {
	    String apiKey = "5K6L5HDTHM7VT4GH";
	    int timeout = 3000;
	    AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
	    TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
	    String datainfo=" ";
	    String data=" ";
	    try {
	    	
	      //IntraDay response = stockTimeSeries.intraDay("ANZ.AX", Interval.THIRTY_MIN, OutputSize.COMPACT);
	      Daily response = stockTimeSeries.daily("ANZ.AX");
	      Map<String, String> metaData = response.getMetaData();
	      System.out.println("Information: " + metaData.get("1. Information"));
	      System.out.println("Stock: " + metaData.get("2. Symbol"));
	      datainfo="Information: " + metaData.get("1. Information") +"<br />"+ "Stock: " + metaData.get("2. Symbol");
	    
	      List<StockData> stockData = response.getStockData();
	      for (StockData stock : stockData) {
	    	  data= data + "date:   " + stock.getDateTime()+"<br />"+"open:   " + stock.getOpen()+"<br />"+"high:   " + stock.getHigh()+"<br />"+"low:    " + stock.getLow()+"<br />"+"close:  " + stock.getClose()+"<br />"+"volume: " + stock.getVolume();
	    	}
	      stockData.forEach(stock -> {
	    	  
	        System.out.println("date:   " + stock.getDateTime());
	        System.out.println("open:   " + stock.getOpen());
	        System.out.println("high:   " + stock.getHigh());
	        System.out.println("low:    " + stock.getLow());
	        System.out.println("close:  " + stock.getClose());
	        System.out.println("volume: " + stock.getVolume());
	      });
	      
	      
	    } catch (AlphaVantageException e) {
	      System.out.println("something went wrong");
	      data=data+"something went wrong";
	    }
	    return datainfo+data;
	  }
	  public static List<StockData> getList(String StockId,int StockInterval) {
		  String apiKey = "5K6L5HDTHM7VT4GH";
		    int timeout = 3000;
		    AlphaVantageConnector apiConnector = new AlphaVantageConnector(apiKey, timeout);
		    TimeSeries stockTimeSeries = new TimeSeries(apiConnector);
		  try {
			  List<StockData> stockData;
		      if(StockInterval==0) {
		    	  IntraDay response = stockTimeSeries.intraDay(StockId, Interval.FIVE_MIN, OutputSize.COMPACT);
		    	  stockData = response.getStockData();
		      }
		    	
		      else if(StockInterval==1) {
		    	  Daily response = stockTimeSeries.daily(StockId);
		    	  stockData = response.getStockData();
		      }
		      else if(StockInterval==2) {
		    	  Weekly response = stockTimeSeries.weekly(StockId);
		    	  stockData = response.getStockData();
		      }
		      else  {
		    	  Monthly response = stockTimeSeries.monthly(StockId);
		    	  stockData = response.getStockData();
		      }
		      
		      
		     return stockData;
		      
		    } catch (AlphaVantageException e) {
		      System.out.println("something went wrong");
		      return null;
		    }
		  
	  }
	  
	}
