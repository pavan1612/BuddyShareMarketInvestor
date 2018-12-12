   <%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
    <%@ page import="java.util.*" %>
    <%@ page import="com.google.gson.Gson"%>
    <%@ page import="com.google.gson.JsonObject"%>
     <%@page import="StockData.App"%>
     <%@page import="org.patriques.output.timeseries.data.*"%>
     <%@page import="Register.LoginBean"%>
     <%@page import="Game.DashboardProvider"%>
     <%@page import="Game.Limit"%>
   <jsp:useBean id="obj" class="Register.LoginBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
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
<title>Dashboard</title>
</head>
<body>
<% Limit.checklimit(); %>
<h1>Hello ! Welcome to Buddy Share Market Investor. 
<%out.println(DashboardProvider.getEmail());%></h1>
<h1>Your Balance is 
<%out.println(DashboardProvider.getBalance(DashboardProvider.getEmail()));
%></h1>
</br>
 <form action="Graph.jsp" method="Post" >
 <h3>Please select a stock u wish to buy
  <select name="StockName">
  <option value="TLS.AX">Telstra</option>
  <option value="ANZ.AX">ANZ</option>
  <option value="WOW.AX">Woolworths</option>
  <option value="CBA.AX">Commonwealth Bank</option>
  <option value="QAN.AX">Ouantas</option>
  <option value="MPL.AX">MediBank</option>
</select> 
</h3>
  <button type="submit" value="Buy">BuyStocks</button>
  
</form> 
</br>
<form action="sell.jsp" >
 
  <button type="submit" value="Sell">SellStocks</button>
  
</form> 

</br>
<form action="MyStocks.jsp" >
 
  <button type="submit" value="MyStocks">MyStocks</button>
  
</form> 

</br>
<form action="index.jsp">
  <input type="submit" value="logout">
  </form>
</body>
</html>