<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employee Directory</title>
</head>
<body>
<h3>Employee Directory</h3>
<table>
	<thead>
		<tr>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Email Address</th>
			<th>Telephone</th>
			<th>Role</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="empEntry" items="${EmployeeList}">
		<tr>
			<td><c:out value = "${empEntry.getLast()}"/></td>
			<td><c:out value = "${empEntry.getFirst()}"/></td>
			<td><c:out value = "${empEntry.address()}"/></td>
			<td><c:out value = "${empEntry.telephone()}"/></td>
			<td><c:out value = "${empEntry.role()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>