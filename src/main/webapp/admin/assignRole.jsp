<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>We have to Give the Role</h1>

<form:form action="updateRole" modelAttribute="user" method="POST">

			<!-- need to associate this data with customer id -->
			<form:hidden path="id" />
					<form:hidden path="password" name = "password" />	
			<table>
				<tbody>
					<tr>
						<td><label>First name:</label></td>
						<td><form:input path="firstName" name = "firstName" /></td>
					</tr>
				
					<tr>
						<td><label>Last name:</label></td>
						<td><form:input path="lastName"  name = "lastName"  /></td>
					</tr>

					<tr>
						<td><label>Email:</label></td>
						<td><form:input path="email"  name = "email" /></td>
					</tr>
					 <tr>
						<td><input type="radio" name="role" value="ADMIN" /> Admin</td>
  						<td><input type="radio" name="role" value="USER" /> User</td>
					</tr>
					
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="Save" class="save" /></td>
					</tr>

				
				</tbody>
			</table>
		
		
		</form:form>


</body>
</html>