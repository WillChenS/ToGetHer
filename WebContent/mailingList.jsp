<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Mailing List</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">
<h3>Customer Mailing List</h3>
<table>
	<thead>
		<tr>
			<th>Last Name</th>
			<th>First Name</th>
			<th>Email Address</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="mailEntry" items="${MailingList}">
		<tr>
			<td><c:out value = "${mailEntry.getLast()}"/></td>
			<td><c:out value = "${mailEntry.getFirst()}"/></td>
			<td><c:out value = "${mailEntry.address()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>