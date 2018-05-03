<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dated Person Search</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB"> >

<h1>Dated Person Search</h1>
	<form action="DatedServlet" method= "post">
	<pre>
	<input type = "text" name = "profile" placeholder = "Enter ProfileID"/>
	<input type = "submit" value = "Enter"/>
	</pre>
	</form>
	
	
<table>
	<thead>
		<tr>
			<th>Dated Person</th>
		</tr>
	</thead>
	<tbody>
		<c:forEach var="value" items="${Dated}">
		<tr>
			<td><c:out value = "${value.getProfileID1()}"/></td>
		</tr>
		</c:forEach>
	</tbody>
</table>
</body>
</html>