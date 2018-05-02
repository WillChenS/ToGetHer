<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for Profile</title>
</head>
<body>
	<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	<h4> Fill everything out. A match will be returned if at least one of these parameters matches </h4>
	<form method = "GET" action = "SrchProServlet">
		<h3> Search for profiles by: </h3> <br>
		Height: <input type="number" name="height" value = ""> <hr>
		Weight: <input type="number" name="weight" value = ""> <hr>
		Hair color: <input type="text" name= "hairColor" value =""> <hr>
		
		<input type="submit" value="Submit">
	</form>
	</div>

</body>
</html>