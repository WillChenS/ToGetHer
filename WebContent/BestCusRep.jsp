<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer representative generated most total revenue</title>
</head>
<body>
<h3>Customer representative generated most total revenue</h3>
<table>
	<thead>
		<tr>
		
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cusrepentry" items="${BestCusRep}">
		<tr>
			<td><c:out value = "${cusrepentry.getFirstName()}"/></td>
			<td><c:out value = "${cusrepentry.getLastName()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>