<%@ taglib uri="http://java.sun.com/jsp/jstl/core"   prefix="c" %>

  <%@ taglib prefix="security"
  uri="http://www.springframework.org/security/tags" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html >
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>FRS</title>

</head>
<body>

<div class="container">
<div id= "wrapper">
<div class="p-3 mb-2 bg-info text-white">

<h1>FRS </h1>
</div>
</div>
<%--    <h2>this is ${users.roles.getAuthority()}</h2>
 --%><br><br>

<table  class="table table-striped border border-info">
   <tr class ="p-3 mb-2 bg-info text-white ">
      <th>first name</th>
      <th>Last Name</th>
      <th>Email</th>
      <th>Roles</th>
  
    </tr>
    <c:forEach items="${users}" var="user">
     <c:url var = "updatelink" value="/admin/assignRolepage">
           <c:param name="userId" value="${user.id}"></c:param>
           </c:url>
       <tr>
           <td><c:out value="${user.firstName}"/></td>
           <td><c:out value="${user.lastName}"/></td>
             <td><c:out value="${user.email}"/></td>
            	<td><c:out value = "${user.roles}"/></td>
              <td><a href="${updatelink}" >Assign Role</a></td>

        </tr>
    </c:forEach>
 </table>
  <a href="..">Back</a>
 </div>
</body>
</html>