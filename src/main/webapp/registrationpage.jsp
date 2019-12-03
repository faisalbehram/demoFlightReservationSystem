<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html>
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
 <script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.1/jquery.min.js"></script>
 
 <style type="text/css">
 
 
 
.error {
	color: red
}
</style>
<meta charset="ISO-8859-1">
<title>Register User</title>
</head>
<body>
<h2  class ="p-3 mb-2 bg-info text-white ">User Registration form</h2>
<!-- <form action="registeruser" method="post">

firstName: <input type="text" name="firstName"/> <br>

lastName: <input type="text" name="lastName"/> <br>

Email: <input type="text" name="email"/> <br>

Password: <input type="password" name="password"/> <br>

Confirm Password: <input type="password" name="confirmpassord"/> <br>

<input type="submit" value="Register"/>

</form>
 -->

<div class="container">
        <div class="row centered-form">
        <div class="col-xs-12 col-sm-8 col-md-4 col-sm-offset-2 col-md-offset-4">
        	<div class="panel panel-default">
			 			<div class="panel-body">
			 			
			 			
			    		<form:form  action="registeruser" method="post" modelAttribute="user" >
    								
    								 
    								
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			                <form:input type="text" name="firstName" id="first_name" class="form-control input-sm"  path="firstName"  placeholder="First Name"/>
			                <form:errors path="firstName" cssClass="error"></form:errors>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="text" name="lastName" id="last_name" class="form-control input-sm"  path="lastName" placeholder="Last Name"/>
			    						<form:errors path="lastName" cssClass="error"></form:errors>
			    					</div>
			    				</div>
			    			</div>

							
							
			    			<div class="form-group">
			    				<form:input type="text" name="username" id="username" class="form-control input-sm" placeholder="User Name" path="username"/>
			    				<form:errors path="username" cssClass="error"></form:errors>
			    			</div>
							
								
			    			<div class="form-group">
			    				<form:input type="email" name="email" id="email" class="form-control input-sm" placeholder="Email Address" path="email"/>
			    				<form:errors path="email" cssClass="error"></form:errors>
			    				<h4>${msg}</h4>
			    			</div>
			    			
			    			
			    			<div class="row">
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<form:input type="password" name="password" id="password" class="form-control input-sm" placeholder="Password" path="password"/>
			    						<form:errors path="password" cssClass="error"></form:errors>
			    					</div>
			    				</div>
			    				<div class="col-xs-6 col-sm-6 col-md-6">
			    					<div class="form-group">
			    						<input type="password" name="confirm_password" id="confirm_password" class="form-control input-sm" placeholder="Confirm Password" >
			    						 <span id='message'></span>
			    					</div>
			    				</div>
			    			</div>
			    			
			    			<input type="submit" value="Register" class="btn btn-info btn-block">
			    		
			    		</form:form>
			    		<a href="../">back</a>
			    	</div>
	    		</div>
    		</div>
    	</div>
    </div>
    
<!--     it is jquery for checking run time  password matching
 -->    
    <script type="text/javascript">
$(' #confirm_password').on('keyup', function () {
  if ($('#password').val() == $('#confirm_password').val()) {
    $('#message').html('Matching').css('color', 'green');
  } else 
    $('#message').html('Not Matching').css('color', 'red');
});

</script>

 -->

</body>
</html>