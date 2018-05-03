<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Register a New Employee </title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">
    <span style="font-family: Arial"><strong><span style="font-size: 20pt">Register a New Employee</span><br />
        <br />

	<h5><c:out value="${sessionScope.Msg}"/>	</h5>
	
	
	<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	
	<form method = "GET" action = "RegisterEmployeeServlet">

		Password: <input type = "password" name = "password" value = "">
		
		<hr>
		SSN: <input type = "text" name = "SSN" value ="">
		<br>

		<hr>
		<h5> Personal Info </h5>
		<br>
		First Name: <input type ="text" name = "firstName" value = "">
		<br>
		Last Name: <input type = "text" name="lastName" value = "">

		<br>
		Address: 
		<br>
		<input type="text" name="address" size="50" value="Street">
		<input type="text" name="address" size="50" value="City">
		<input type="text" name="address" size="50" value="State">
		<input type="number" name="address" size="5" value="Zip">
		<br>
		Email: <input type="email" name="email" value="">
		<br>
		Phone Number: <input type="text" name="phoneNumber" value="">
		<hr>
		<h5> Input employment information </h5>
		<br>
		Role: <input type="text" name="role" value="">
		<br>
		Hourly Rate: <input type="number" name="hourlyrate" value="">
		<br>
		
		<hr>
		<input type="submit" value="Submit">
	</form>
	
	
	</div> 

</body>
</html>