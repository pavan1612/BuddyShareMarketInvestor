<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@page import="StockData.App"%>    
  <%@page import="Game.GameApp"%>
   <%@page import="Game.DashboardProvider"%>
    

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
<title>Sell JSP</title>
</head>
<body>
Select the stock you want to Sell-(Please enter the number associated) 
<form action="SellDetails.jsp" method="Post">
    
    <input type="text" id="txtA" name="option" />
    
    
    <input type="submit" value='Select'>
    
</form> 
 <%
        	    String output= GameApp.getStockDetails(DashboardProvider.getUser());
        	    out.println(output);
        	    %>
        	    

<form action="Dashboard.jsp">
  <input type="submit" value="Home">
  </form>
</body>
</html>