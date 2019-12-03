<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>All flights</h1>
<table  class="table table-striped border border-info">
   <tr class ="p-3 mb-2 bg-info text-white ">
      <th>Air Lines</th>
      <th>Departure City</th>
      <th>Arrival city</th>
      <th>Departure Time</th>
      <th>Select Flight </th>
    </tr>
    <c:forEach items="${flights}" var="flights">
<%--     <c:url var = "updatelink" value="/customer/showFormForUpdate">
           <c:param name="customerId" value="${customer.id}"></c:param>
           </c:url>
           <c:url value="/customer/deletebyid" var="deletelink">
           <c:param name="customerId" value="${customer.id}"></c:param>
           </c:url>--%>	
       <tr> 
           <td><c:out value="${flights.operatingAirlines}"/></td>
           <td><c:out value="${flights.departureCity}"/></td>
           <td><c:out value="${flights.arrivalCity}"/></td>
           <td><c:out value="${flights.estimatedDepartureTime}"/></td>
           <td><a href="showcompletereservation?flightId=${flights.id }">Select</a></td>
        </tr>
    </c:forEach>
    
 </table>

	<form:form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="LogOut">
	</form:form>
	<a href="../">back</a>
</body>
</html>