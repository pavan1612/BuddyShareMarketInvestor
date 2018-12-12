<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%

String option= request.getParameter("uname");
String option2= request.getParameter("psw");
if(option.equals("admin") && option2.endsWith("admin")){  
String redirectURL = "http://localhost:8080/LoginPage/Admin.jsp";
response.sendRedirect(redirectURL); 
 
}  
else  
{  
	String redirectURL = "http://localhost:8080/LoginPage/AdminLogin.jsp";
	response.sendRedirect(redirectURL); 
}
%>


