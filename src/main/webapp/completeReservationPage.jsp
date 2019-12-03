<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
    <%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Complete your Reservation</title>
</head>
<body>
<div class="container">
<h2>Complete your Reservation</h2>

 AirLines : ${flight.get().getOperatingAirlines() }<br><br>
 
 Departure City : ${flight.get().getDepartureCity() }<br><br>
 
 Arrival City : ${flight.get().getArrivalCity() }<br><br>

 <form action="completeTheReservation" method="post" enctype="multipart/form-data">
<div class="row">
  <div class="col">
 <h2>Passenger Details</h2><br>
 

  <div class="form-group"> 
 First Name:  <input class="form-control"  type="text" name="passengerFirstName">
 
 Last Name: <input  class="form-control"  type="text" name="passengerLastName">
 
Email: <input class="form-control"  type="text" name="PassengerEmail">

 Phone Number: <input class="form-control"   type="text" name="passengerPhone">
 
 Photo: <input type="file" name="photo" class="form-control">
 
 </div></div>
  <div class="col">
 <h2>Card Details</h2>
 <br>
 <div class="form-group"> 
 
 Name on the Card: <input  class="form-control"  type="text" name="nameOnTheCard">
 Card No: <input  class="form-control"  type="text" name="cardNumber">
 Expairy Date:<input  class="form-control"  type="text" name="expirationDate">
 Three digit:<input  class="form-control"  type="text" name="securityCode">
</div> </div></div>
 <input type="hidden" name="flightId" value=" ${flight.get().getId() }"> 
<input type="submit" value="confirm"  class="btn btn-info btn-block">

 </form>
 <a href="allFlights">Show All Flights</a>
 <br>
  <a href="findflightpage">Back</a>
 </div>

<hr>
${flight}
</body>
</html>