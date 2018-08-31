<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>

<html>
  <head>

  <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style>
body#LoginForm{ background-image:url("https://images.pexels.com/photos/147408/pexels-photo-147408.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=750&w=1260"); background-repeat:no-repeat; background-position:center; background-size:cover; padding:10px;}

.form-heading { color:#fff; font-size:23px;}
.panel h2{ color:#444444; font-size:18px; margin:0 0 8px 0;}
.panel p { color:#777777; font-size:14px; margin-bottom:30px; line-height:24px;}
.login-form .form-control {
  background: #f7f7f7 none repeat scroll 0 0;
  border: 1px solid #d4d4d4;
  border-radius: 4px;
  font-size: 19px;
  height: 100px;
  line-height: 100px;
}
.main-div {
  <!-- background: #ffffff none repeat scroll 0 0; -->
  border-radius: 2px;
  margin: 10px auto 30px;
  max-width: 38%;
  padding: 50px 70px 70px 71px;
}

.login-form .form-group {
  margin-bottom:10px;
}
.login-form{ text-align:center;}
.forgot a {
  color: #777777;
  font-size: 14px;
  text-decoration: underline;
}
.login-form  .btn.btn-primary {
  background: #f0ad4e none repeat scroll 0 0;
  border-color: #f0ad4e;
  color: #ffffff;
  font-size: 14px;
  width: 100%;
  height: 50px;
  line-height: 50px;
  padding: 0;
}
.forgot {
  text-align: left; margin-bottom:30px;
}
.botto-text {
  color: #ffffff;
  font-size: 14px;
  margin: auto;
}
.login {
  color: #ffffff;
  font-size: 14px;
  margin: auto;
}
.login-form .btn.btn-primary.reset {
  background: #ff9900 none repeat scroll 0 0;
}
.back { text-align: left; margin-top:10px;}
.back a {color: #444444; font-size: 13px;text-decoration: none;}

</style>
<!------ Include the above in your HEAD tag ---------->
  </head>
<body id="LoginForm">

<div class="container">
<h1 style="color:#ffb628;" class="form-heading"><strong>Register for Budding Share Market Investor</strong></h1>
<div class="login-form">
<div class="main-div">
    
    <form id="Login" action="process.jsp" method="POST">

        <div class="form-group">


            <input type="text" id="username" name="uname" placeholder="Name" class="input-xlarge">

        </div>

<div class="form-group">


            <input type="text" id="username" name="uemail" placeholder="Email" class="input-xlarge">

        </div>
        <div class="form-group">

            <input type="password" id="password" name="upass" placeholder="Password" class="input-xlarge">

        </div>
       
        <button type="submit" class="btn btn-primary">Register</button>

    </form>
    <div class="login">
<a href="Login.jsp" class="btn btn-primary btn-lg active" role="button" aria-pressed="false">Login</a>
</div>
    </div>

</div></div>


</body>
</html>