<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ToGetHer Customer Representative Home</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">

<h1>Customer Representative Home</h1>
	<form action="recordDate.jsp" method= "post">
		<button type="submit" formaction="recordDate.jsp">Record a Date</button><br>
		<br>
		<button type="submit" formaction="SelectCustomerServlet">Add, Edit, or Delete Customer Info</button><br>
		<br>
		<button type="submit" formaction="MailingList" method="get">Customer Mailing Lists</button><br>
		<br>
		<button type="submit" formaction="dateSuggestions.jsp">Suggested Dates by Profile</button><br>
		<br>
		<button type="submit" formaction="EmployeeInfo" method="get">Employee Directory</button><br>
		<br>
	</form>
	
</body>
</html>
</html>