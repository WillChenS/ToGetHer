<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of the highest-rated customers</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">
<h3>List of the highest-rated customers</h3>
<table>
	<thead>
		<tr>
		
			<th>First Name</th>
			<th>Last Name</th>
			<th>Rating</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="highratedcusentry" items="${HighRatedCus}">
		<tr>
			<td><c:out value = "${highratedcusentry.getFirstName()}"/></td>
			<td><c:out value = "${highratedcusentry.getLastName()}"/></td>
			<td><c:out value = "${highratedcusentry.getrating()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>	