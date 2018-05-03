<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer generated most total revenue</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB"> >
<h3>Customer generated most total revenue</h3>
<table>
	<thead>
		<tr>
		
			<th>First Name</th>
			<th>Last Name</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="cusentry" items="${BestCus}">
		<tr>
			<td><c:out value = "${cusentry.getFirstName()}"/></td>
			<td><c:out value = "${cusentry.getLastName()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>