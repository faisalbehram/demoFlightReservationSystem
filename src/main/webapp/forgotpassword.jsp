<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
      
<!DOCTYPE html>
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
            <form:form modelAttribute="user" action="/forgot-password"  method="post">
                <table>
                    <tr>
                        <td><label for="emailId">Email</label></td>
                        <td><input  type="text" name="email"></input></td>
                    </tr>
                    <tr>
                        <td><input type="reset" value="Clear"/></td>
                        <td><input type="submit" value="Reset Password"></input></td>
                    </tr>
                </table>
           </form:form>
    </body>
</html>