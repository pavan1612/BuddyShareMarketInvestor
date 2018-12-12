<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@page import="Admin.Admin"%>  
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
body { background-image:url("https://i.redd.it/67ebeb1ch3ex.png");  /* Full height */
    height: 50%; 

    /* Center and scale the image nicely */
    background-position: center;
    background-repeat: no-repeat;
    background-size: cover;}
</style>
<title>Admin Panel</title>
</head>
<body>
<p>Delist a memeber</p>
<form action="Delist.jsp">
<p>Enter an User number to Delist </p>
<input type="text" id="txtA" name="option" />
 <input type="submit" value="Delist">
  </form>
  
<p>  See the user with highest transactions</p>
  <form action="HighestTraders.jsp">
  <input type="submit" value="HighTransaction">
  </form>
  
  <p> Change User Brokerage cost</p>
  <form action="LowerBrokerage.jsp">
  <p>Enter an User name to change Brokerage cost </p>
<input type="text" id="txtA" name="option" />
  <input type="submit" value="ChangeBrokerage">
  </form>
<p>
<%out.print(Admin.getUserDetails());
%>
</p>
<form action="index.jsp">
  <input type="submit" value="logout">
  </form>
</body>
</html>