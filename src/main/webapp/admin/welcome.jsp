<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%@include file="../nav.jsp" %>    
<h2>Welcome to Admin Panel</h2>
<a href="showAllUser"> Show All Registered User</a>
<form action="${pageContext.request.contextPath}/logout"
		method="POST">
		<input type="submit" value="LogOut">
	</form>
</body>
</html>