    <%@page import="Register.RegisterDao"%>  
    <jsp:useBean id="obj" class="Register.User"/>  
      
    <jsp:setProperty property="*" name="obj"/>  
      
    <%  
    int status=RegisterDao.register(obj);  
    if(status>0)  {
    String redirectURL="http://localhost:8080/LoginPage/Login.jsp";
    response.sendRedirect(redirectURL);  
    }
    %>  
    