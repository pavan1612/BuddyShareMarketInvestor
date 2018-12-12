<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Admin.Admin"%> 
    <%@page import="Admin.Delist"%> 
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
</style>>

<meta charset="ISO-8859-1">
<title>Delisting</title>
</head>
<body>
<%String option= request.getParameter("option");

String users=Admin.getUserDetails();
String[] words= users.split(":");
out.print("Delisted user "+option);
Delist.DelistUser(option);

%>
 <form action="Admin.jsp">
  <input type="submit" value="Home">
  </form>
</body>
</html>