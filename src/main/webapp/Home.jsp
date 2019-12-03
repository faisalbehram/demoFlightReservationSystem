<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%> 
    
    <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    
   
<!DOCTYPE html>
<html lang="en">
<head>
   
</head>
<body>
<h1>Flight Reservation System</h1>

<%@include file="nav.jsp" %>                

<h3>${msglogout}</h2><br>
<h3>${addFlightMsg}</h2><br>
<h3>${usernamefound}</h3>

<h4>${message}</h4>

<!-- 
Already User <a href="loginpage">Login</a><br>
New Here SignUp<a href="showreg">SignUp</a><br> -->
 
 <h3 style="color: red;font: bold;">${msgemail}</h3>     
<h4>For Booking Flight Click on User panel and Login and Book your flight</h4>
<p>this flight reservation system in which you book every a reservation for flight <br> this will also send you send email according your emeial address 
about your reservation information  </p>

<sec:csrfInput /> 
</body>
</html>




