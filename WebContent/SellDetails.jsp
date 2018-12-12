<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="StockData.App"%>    
  <%@page import="Game.*"%>
   <%@page import="Game.DashboardProvider"%>
   <%@ page import="java.util.*" %>
    <%@ page import="com.google.gson.Gson"%>
    <%@ page import="com.google.gson.JsonObject"%>
     <%@page import="StockData.App"%>
     <%@page import="org.patriques.output.timeseries.data.*"%>
<!DOCTYPE html>
<html>
<head>
<style>
body { background-image:url("https://i.redd.it/67ebeb1ch3ex.png");  /* Full height */
    height: 50%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;}
</style>

<meta charset="ISO-8859-1">
<title>Sell stock</title>
</head>
<body>
<p>Do you wish to sell this stock below??</p>
<%String option= request.getParameter("option");
String output= GameApp.getStockDetails(DashboardProvider.getUser());
String stockdetails=SellStocks.getDetails(output,option);
out.print(stockdetails);
String[] words=stockdetails.split("-");
String stockName = words[3].substring(0, Math.min(words[3].length(), 6));
float NumberofStocks = Float.parseFloat(words[5].substring(0, Math.min(words[5].length(), 4)));

List<StockData> stockdata=App.getList(stockName,3);
Double CurrentPrice=0.0;
int i=1;
for (StockData stock : stockdata) {
	if(i==1){
		CurrentPrice=stock.getClose();
		SellStocks.setStock(stockdetails);
		i++;
	}
	
}
double balance=NumberofStocks*CurrentPrice;
SellStocks.setStockValues(balance);
%>
<p>The current selling price is <%=CurrentPrice %></p>

<form action="sold.jsp">
  <input type="submit" value="SELL">
</form>
<p>Cut-Loss if you want to sell the stock below a certain price</p>
<form action="CutLoss.jsp" method="Post">
    
    <input type="text" id="txtA" name="option" />
    
    
    <input type="submit" value='Select'>
    
</form> 


<form action="Dashboard.jsp">
  <input type="submit" value="Home">
  </form>

</body>
</html>