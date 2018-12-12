<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Game.SellStocks"%>
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
<title>Sold Details</title>
</head>
<body>
<%
String s=SellStocks.sell();

%>
Your stock is sold 
<form action="Dashboard.jsp">
  <input type="submit" value="Home">
  </form>
</body>
</html>