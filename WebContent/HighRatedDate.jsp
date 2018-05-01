<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of the highest-rated Calendar Dates</title>
</head>
<body>
<h3>List of the highest-rated Calendar Dates</h3>
<table>
	<thead>
		<tr>
		
			<th>Date</th>
			<th>Rating</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="highrateddateentry" items="${HighRatedDate}">
		<tr>
			<td><c:out value = "${highrateddateentry.getDate()}"/></td>
			<td><c:out value = "${highrateddateentry.getrating()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>	