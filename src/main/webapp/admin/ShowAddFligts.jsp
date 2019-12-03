<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
        
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<title>Add Flight</title>

<link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script>
<script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<style type="text/css">



body {
  background: #C5E1A5;
}
form {
  width: 60%;
  margin: 60px auto;
  background: #efefef;
  padding: 60px 120px 80px 120px;
  text-align: center;
  -webkit-box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
  box-shadow: 2px 2px 3px rgba(0,0,0,0.1);
}
label {
  display: block;
  position: relative;
  margin: 40px 0px;
}
.label-txt {
  position: absolute;
  top: -1.6em;
  padding: 10px;
  font-family: sans-serif;
  font-size: .8em;
  letter-spacing: 1px;
  color: rgb(120,120,120);
  transition: ease .3s;
}
.input {
  width: 100%;
  padding: 10px;
  background: transparent;
  border: none;
  outline: none;
}

.line-box {
  position: relative;
  width: 100%;
  height: 2px;
  background: #BCBCBC;
}

.line {
  position: absolute;
  width: 0%;
  height: 2px;
  top: 0px;
  left: 50%;
  transform: translateX(-50%);
  background: #8BC34A;
  transition: ease .6s;
}

.input:focus + .line-box .line {
  width: 100%;
}

.label-active {
  top: -3em;
}

button {
  display: inline-block;
  padding: 12px 24px;
  background: rgb(220,220,220);
  font-weight: bold;
  color: rgb(120,120,120);
  border: none;
  outline: none;
  border-radius: 3px;
  cursor: pointer;
  transition: ease .3s;
}

button:hover {
  background: #8BC34A;
  color: #ffffff;
}
h2{
color: white;
 display: inline-block;
  padding: 12px 24px;
    color: rgb(120,120,120);
}
.error {
	color: red
}


</style>  
</head>
<body>


<c:set var="now" value="<%=new java.util.Date()%>" />
<form:form action="AddedFlights" method="post"  modelAttribute="flight">
  <h2>Adding Flight to DataBase</h2>
  <label>

    <p class="label-txt">Flight No</p>
     <form:input type="text" name="flightNumber" id="flightNumber"  path="flightNumber" class="input" />
			                <form:errors path="flightNumber" cssClass="error"></form:errors>
   
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label><br>
  
  <label>
    <p class="label-txt">Operating AirLine</p>
    <form:input type="text" name="operatingAirlines" id="operatingAirlines"  path="operatingAirlines" class="input" />
			                <form:errors path="operatingAirlines" cssClass="error"></form:errors>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label><br>

  	 <label>
    <p class="label-txt">Arrival City</p>
    <form:input type="text" name="arrivalCity" id="arrivalCity"  path="arrivalCity" class="input" />
			                <form:errors path="arrivalCity" cssClass="error"></form:errors>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label><br>
 

   <label>
    <p class="label-txt">Departure City</p>
    <form:input type="text" name="departureCity" id="departureCity"  path="departureCity" class="input" />
			                <form:errors path="departureCity" cssClass="error"></form:errors>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label><br>
  
  <label>
    <p class="label-txt">Date Of Departure</p>
    <form:input type="date" name="dateOfDeparture" id="dateOfDeparture"  path="dateOfDeparture" class="input" />
			                <form:errors path="dateOfDeparture" cssClass="error"></form:errors>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label><br>
  
  
 

  <button type="submit">submit</button>
</form:form>
<input type="datetime-local">
</body>
</html>

<%-- 
<label>
    <p class="label-txt">Date Of Departure</p>
    <form:input type="datetime" name="estimatedDepartureTime" id="estimatedDepartureTime"  path="estimatedDepartureTime" class="input" />
			                <form:errors path="estimatedDepartureTime" cssClass="error"></form:errors>
      <fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${now}" /></p>
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  <label>
    <p class="label-txt">Date Of Departure</p>
    <form:input type="datetime" name="estimatedDepartureTime" id="estimatedDepartureTime"  path="estimatedDepartureTime"   class="input"  value="${now}" />
			                <form:errors path="estimatedDepartureTime" cssClass="error"></form:errors>
    
    <div class="line-box">
      <div class="line"></div>
    </div>
  </label>
  
   --%>