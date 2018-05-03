<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search for Profile</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB"> >
	<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	<h4> Fill everything out. A match will be returned if at least one of these parameters matches </h4>
	<form method = "GET" action = "SrchProServlet">
		<h3> Search for profiles by: </h3> <br>
		Height: <input type="number" name="height" value = ""> <hr>
		Weight: <input type="number" name="weight" value = ""> <hr>
		Hair color: <input type="text" name= "hairColor" value =""> <hr>
		Hobbies: <input type="text" name= "hobbies" value =""> <hr>
		
		<input type="submit" value="Submit">
		

	</form>
	</div>

</body>
</html>