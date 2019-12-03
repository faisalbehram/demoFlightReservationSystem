<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html >
<head>
  <title>FRS</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
</head>
<body> 

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="/">FRS</a>
    </div>
   <!--
  this is only show to authurized user those who have admin role 
    -->
    <ul class="nav navbar-nav">
 <li><security:authorize access="hasAnyAuthority('USER','ADMIN')">
      <li ><a  href="../findflightpage">Book Flights</a>
      </li></security:authorize>
         <!--  
       <security:authorize access="!isAuthenticated()">
      <li ><a  href="findflightpage">Book Flights</a>
      </li></security:authorize>

     show to admind when login  
      -->
      <li><security:authorize access="hasAnyAuthority('ADMIN')">
      <a href="/allFlights">All Flights</a></security:authorize></li>
      
      <security:authorize access="hasAnyAuthority('ADMIN')">
      <li><a href="/admin/showAllUser">Show All User</a></li>
      <li><a href="/admin/addFlights">Add Flights</a></li>
      
      </security:authorize>
      
        <security:authorize access="!isAuthenticated()">
        <li><a href="/login">UserPanel</a></li></security:authorize>
       <security:authorize access="!isAuthenticated()">
      <li><a href="/admin/welcome">AdminPanel</a></li></security:authorize>
    </ul>
   
   
    <ul class="nav navbar-nav navbar-right">
     
      <li><security:authorize access="isAuthenticated()"><a  href="../logout" style="color: red;"><span class="glyphicon glyphicon-log-out"></span> logout</a></security:authorize></li>
     
     <security:authorize access="!isAuthenticated()">
      <li><a  href="showreg"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
      <li><a  href="login"><span class="glyphicon glyphicon-log-in"></span> Login</a></li></security:authorize>
    </ul>
    
  </div>
</nav>
<security:authorize access="isAuthenticated()">
    Welcome , <security:authentication property="name"/>
 
</security:authorize>
</body>
</html>