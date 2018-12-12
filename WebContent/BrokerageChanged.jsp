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
<title>Done</title>
</head>
<body>
<%
String option= request.getParameter("option");
Admin.changeBrokerage(option);
%>
<p>Brokerage reduced to <%=option %></p>
<form action="Admin.jsp">
  <input type="submit" value="Home">
  </form>

</body>
</html>