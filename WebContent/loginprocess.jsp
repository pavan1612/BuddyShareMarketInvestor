<%@page import="Register.LoginDao"%> 

<jsp:useBean id="obj" class="Register.LoginBean"/>  
  
<jsp:setProperty property="*" name="obj"/>  
  
<%  
boolean status=LoginDao.validate(obj);  
if(status){  
String redirectURL = "http://localhost:8080/LoginPage/Dashboard.jsp";
response.sendRedirect(redirectURL); 
session.setAttribute("session","TRUE");  
}  
else  
{  
out.print("Sorry, email or password error");  
%>  
<jsp:include page="index.jsp"></jsp:include>  
<%  
}  
%>