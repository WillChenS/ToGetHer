<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Revenue By ProfileID</title>
</head>
<body>

<h1>Search Revenue By ProfileID</h1>
	<form action="RevenueByCusServlet" method= "post">
	<pre>
	<input type = "text" name = "profile" placeholder = "Enter ProfileID"/>
	<input type = "submit" value = "Enter"/>
	</pre>
	</form>
	
	
<table>
	<thead>
		<tr>
			<th>ProfileID1</th>
			<th>ProfileID2</th>
			<th>DateTime</th>
			<th>BookingFee</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="value" items="${RBC}">
		<tr>
			<td><c:out value = "${value.getProfileID1()}"/></td>
			<td><c:out value = "${value.getProfileID2()}"/></td>
			<td><c:out value = "${value.getDateTime()}"/></td>
			<td><c:out value = "${value.getBookingFee()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>