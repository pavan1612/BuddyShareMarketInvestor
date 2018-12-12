

    <%@page import="java.time.format.DateTimeFormatter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.google.gson.Gson"%>
    <%@ page import="com.google.gson.JsonObject"%>
     <%@page import="StockData.App"%>
     <%@page import="org.patriques.output.timeseries.data.*"%>
      <%@page import="Game.Limit"%>
    <%
    
    String stockName= request.getParameter("StockName");
    session.setAttribute("StockName", stockName); 
    Gson gsonObj = new Gson();
    Map<Object,Object> map = null;
    List<Map<Object,Object>> list = new ArrayList<Map<Object,Object>>();
    List<StockData> stockdata=App.getList(stockName,3);
    double CurrentPrice=0;
    int i=1;
    for (StockData stock : stockdata) {
    	if(i==1){
    		CurrentPrice=stock.getClose();
    		i++;
    	}
    	map = new HashMap<Object,Object>(); map.put("label", stock.getDateTime().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))); map.put("y", stock.getClose()); list.add(map);
  	}
    String dataPoints = gsonObj.toJson(list);
    String name=session.getAttribute("StockName").toString();
    Limit.setStockName(name);
    %>
     
    <!DOCTYPE HTML>
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

    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <script type="text/javascript">
    window.onload = function() { 
     
    var chart = new CanvasJS.Chart("chartContainer", {
    	theme: "light1",
    	title: {
    		text: "Stock price for <%=stockName%>"
    	},
    	axisX: {
    		title: "Time"
    	},
    	axisY: {
    		title: "$"
    	},
    	data: [{
    		type: "line",
    		yValueFormatString: "#,##0$",
    		dataPoints : <%out.print(dataPoints);%>
    	}]
    });
    chart.render();
     
    }
    </script>
    </head>
    <body>
    <div id="chartContainer" style="height: 370px; width: 100%;"></div>
    <script src="https://canvasjs.com/assets/script/canvasjs.min.js"></script>
    </body>
    Current price to buy is <%=CurrentPrice %>
    Do you wish to buy?
    <%session.setAttribute("CurrentPrice", CurrentPrice); %>
      <form action="buy.jsp">
  <input type="submit" value="BUY">
</form> 
<p>Limit at what price</p>
<form action="limit.jsp">
<input type="text" id="txtA" name="option" />
How many<input type="text" id="txtA" name="option2" />
  <input type="submit" value="BUY">
</form> 

<form action="Dashboard.jsp">
  <input type="submit" value="Home">
  </form>
    </html>                              

