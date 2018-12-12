<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Game.DashboardProvider"%>
    <%@page import="Game.GameApp"%>
   
    <% double Price= (double)session.getAttribute("CurrentPrice");
    %>
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
<title>Purchase Details of <%=session.getAttribute("StockName").toString() %> </title>
</head>
<body>
Purchase successful of 


<%
out.println(session.getAttribute("StockName").toString());
out.println("</br>");
out.println("with current price of");
out.println( Price);
out.println("</br>");
out.println("and bought ");
out.println(Double.parseDouble(request.getParameter("txtA")));
out.println("  stocks");
out.println("</br>");
out.println("</br>");out.println("</br>");

GameApp.buy_shares(session.getAttribute("StockName").toString(), Price,Double.parseDouble(request.getParameter("txtA")));

        	    %>
        	    
        	    
        	    <%
        	    String output= GameApp.getStockDetails(DashboardProvider.getUser());
        	    out.println(output);
        	    %>
        	    
        	    <form action="Dashboard.jsp">
  <input type="submit" value="Home">
  </form>
</body>
</html>