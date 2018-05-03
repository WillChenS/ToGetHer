<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Record a Date</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB"> >
<h1>Record a Date</h1>

<form action="RecordDate" method= "post">
	<pre>
	<% if(request.getSession().getAttribute("Role").toString().equals("Customer")){
		%> Profile: <input type = "text" name = "profile2"/>
	<% }else{
		%>
	Profile1: <input type = "text" name = "profile1"/>
	Profile2: <input type = "text" name = "profile2"/>
	<% } %>
	Date/Time (in <i>YYYY-MM-DD hh:mm:ss</i>): <input type = "text" name = "datetime"/>
	Location: <input type = "text" name = "location"/>
	Booking Fee: <input type = "text" name = "bookingfee"/>
	Comments: <input type = "text" name = "comments"/>
	User 1 Rating: <input type = "text" name = "user1rating"/>
	User 2 Rating: <input type = "text" name = "user2rating"/>
	<input type = "submit" value = "Submit"/>
	</pre>
</form>

<br><br>

Status: <%= request.getAttribute("return") %>.

</body>
</html>