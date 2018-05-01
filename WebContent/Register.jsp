<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Create new account </title>
</head>
<body>
	<h3> Get Started with an Account </h3>
	<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	
	<form method = "GET" action = "RegisterServlet">
		Account Number: <input type = "number" name = "userName" value = "">
		<br>
		Password: <input type = "password" name = "password" value = "">
		
		<hr>
		SSN: <input type = "text" name = "SSN" value ="">
		<br>
		Card Number: <input type = "number" name = "cardNumber" value = "">
		
		<hr>
		<h5> Personal Info </h5>
		<br>
		First Name: <input type ="text" name = "firstName" value = "">
		<br>
		Last Name: <input type = "text" name="lastName" value = "">
		<br>
		Gender: <input type="radio" name="gender" value="Male"> Male
		<input type="radio" name="gender" value="Female"> Female
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
		<h5> Tell us more about yourself!!! </h5>
		<br>
		ProfileID: <input type="text" name="profileID" value="">
		<br>
		Age: <input type="number" name="age" value="">
		<br>
		Dating Range Min: <input type="range" name="dRangeMin" min="18" max="55">
		<br>
		Dating Range Max: <input type="range" name="dRangeMax" min="18" max="55">
		<br>
		Geo Range: <input type="number" name="geoRange" value="">
		<br>
		Height: <input type="number" name="height" value="">
		<br>
		Weight: <input type="number" name="weight" value="">
		<br>
		Hair Color: <input type="text" name="hairColor" value="">
		<br>
		Hobbies: <input type="text" name="hobbies" value= "">
		
		<hr>
		<input type="submit" value="Submit">
	</form>
	
	
	</div> 

</body>
</html>