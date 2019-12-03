<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en" xmlns="http://www.w3.org/1999/xhtml"> 
    <head>  
        <title>Reset Password</title>  
    </head>  
    <body>
      
            <h2>Enter new password:</h2>
            <form:form action="/reset-password" modelAttribute="user" method="post">  
            
                <table>  
                    <tr>  
                        <td><label for="emailId">Email</label></td>  
                        <td><input type="text" name="email" readonly value="${user.email}" /></td>  
                    </tr>              
                    <tr>  
                        <td><label for="password">Password</label></td>  
                        <td><input type="password" name="password"/></td>  
                    </tr>  
                    <tr>  
                        <td><input type="reset" value="Clear"/></td>  
                        <td><input type="submit" value="Submit"></input></td>  
                    </tr>  
                </table>  
          </form:form>
     
    </body>  
</html>  