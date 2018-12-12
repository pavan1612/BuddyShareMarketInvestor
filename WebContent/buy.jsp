<%@page import="Game.DashboardProvider"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
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
</head>
<body>
<script>
        function Multiply() {
            var a = document.getElementById("txtA").value;
            var b = <%=Price%>
            var result = parseInt(a) * parseInt(b);
            
            document.getElementById("result").innerHTML= result;
            
           
        }
        
        	
        
        
    </script>
    <form action="PurchaseDetails.jsp" method="Post">
    Please enter number of stocks you wish to buy at <% out.println(Price); %> 
    <input type="text" id="txtA" name="txtA" />
    
    <input type="button" name="btnMultiply" value="Submit" onclick="Multiply()" />
    
    <p>The Total cost of the stock will be </p>
    <p id="result"></p>
    <input type="submit" value="BuyAtCurrentPrice">
    
</form> 

<form action="Dashboard.jsp">
  <input type="submit" value="Home">
  </form>
    
    
</body>
</html>