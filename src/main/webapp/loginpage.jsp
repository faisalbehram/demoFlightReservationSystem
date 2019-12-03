<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

      
<!DOCTYPE html>
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>


</head>
<body>
<h2  class ="p-3 mb-2 bg-info text-white ">Login page</h2>
<%-- <form action="loginuser" method="post">


Email : <input type="text" name="email"/> <br>

Password: <input type="password" name="password"/> <br>
 
 <input type="submit" value="login"/>

</form>
<h4 style="color: red;font: bold;">${msg }</h4>
 --%>
<div class="container">
<h2>${SPRING_SECURITY_LAST_EXCEPTION.message}</h2>
<form:form action="login" method="post">
  <div class="form-group">
  <c:if test="${param.error != null }"><i>Sorry Invalide email and password password </i></c:if>
    <label   >Email address:</label>
    <input type="text" name="email" class="form-control" id="email">
  </div>
  <div class="form-group">
    <label for="pwd">Password:</label>
    <input  type="password" name="password" class="form-control" id="password" >
    <input type="checkbox" onclick="myFunction()">Show Password<br>
    
    <input type="checkbox" name="remember-me" id="remember-me" /> <label>Remember me</label>
  </div>
  <input type="submit" value="login">
  <br><br>
  <a class = "btn btn-primary" href="/oauth2/authorization/google">Login With Google</a><br><br>
  <a class = "btn btn-primary" href="/oauth2/authorization/facebook">Login With Facebook</a>
  
</form:form>
<a href="/forgot-password">Forgot Password?</a>

<h2>${msgUserRegister}</h2><br>

<h4>If new User then SignUp</h4>
<a href="/showreg">SignUp</a>
 </div>
 
 <script>
function myFunction() {
  var x = document.getElementById("password");
  if (x.type === "password") {
    x.type = "text";
  } else {
    x.type = "password";
  }
  
}
</script>
 
 
<script type="text/javascript">
	$("#password").password('toggle');
</script>
 
 
</body>
</html>