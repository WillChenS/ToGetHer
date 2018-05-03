<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sale Report </title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB"> >

<h1>Sale Report </h1>
	<form action="SaleReportServlet" method= "post">
	<pre>
	<input type = "text" name = "profile" placeholder = "Enter a integer for month(1-12)"/>
	<input type = "submit" value = "Enter"/>
	</pre>
	</form>
	
	<br><br>
	
	Sale Report:
<table>
	<thead>
		<tr>
			<th>ProfileID1</th>
			<th>ProfileID2</th>
			<th>CustRep</th>
			<th>DateTime</th>
			<th>Location</th>
			<th>BookingFee</th>
			<th>Comments</th>
			<th>User1Rating</th>
			<th>User2Rating</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="value" items="${salereport}">
		<tr>
			<td><c:out value = "${value.getProfileID1()}"/></td>
			<td><c:out value = "${value.getProfileID2()}"/></td>
			<td><c:out value = "${value.getCustRep()}"/></td>
			<td><c:out value = "${value.getDateTime()}"/></td>
			<td><c:out value = "${value.getLocation()}"/></td>
			<td><c:out value = "${value.getBookingFee()}"/></td>
			<td><c:out value = "${value.getComments()}"/></td>
			<td><c:out value = "${value.getUser1Rating()}"/></td>
			<td><c:out value = "${value.getUser2Rating()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>