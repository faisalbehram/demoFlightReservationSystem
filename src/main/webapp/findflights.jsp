<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
 <link href="css/bootstrap.min.css" rel="stylesheet">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div class="container">
<h2>find flights</h2>
<form action="findflights" method="post" >
From <input type="text" name="from" class="form-control input-sm"/> 
To<input type="text" name="to" class="form-control input-sm"/>
Departure Date <input type="date" name="departuredate" class="form-control input-sm" id="myDate" min="2013-01-02" />

<input type="submit" value="search" class="btn btn-info btn-block"/>	 
</form>
<a href="../">back</a>
<h3>${findmsg }</h3>
</div>


</body>
</html>