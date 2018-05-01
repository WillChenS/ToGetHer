<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List All Users</title>
</head>
<body>
<h3>List All Users</h3>
<table>
	<thead>
		<tr>
			<th>SSN</th>
			<th>Password</th>
			<th>FirstName</th>
			<th>LastName</th>
			<th>Street</th>
			<th>City</th>
			<th>State</th>
			<th>ZipCode</th>
			<th>Email</th>
			<th>Telephone</th>
			
		</tr>
	</thead>
	<tbody>
		<c:forEach var="ListAllUserEntry" items="${ListAllUserList}">
		<tr>
			<td><c:out value = "${ListAllUserEntry.getSSN()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getPassword()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getFirstName()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getLastName()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getStreet()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getCity()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getState()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getZipCode()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getEmail()}"/></td>
			<td><c:out value = "${ListAllUserEntry.getTelephone()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>