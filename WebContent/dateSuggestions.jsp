<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Date Suggestion List</title>
</head>
<body>

<h1>Date Suggestion Generator</h1>
	<form action="SuggestDates" method= "post">
	<pre>
	<input type = "text" name = "profile" placeholder = "User Profile"/>
	<input type = "submit" value = "Enter"/>
	</pre>
	</form>
	
	<br><br>
	
	Suggestions:
<table>
	<tbody>
		<c:forEach var="suggestion" items="${list}">
		<tr>
			<td><c:out value = "${suggestion}"/></td>
		</tr>
		</c:forEach>
	</tbody>
	
</body>
</html>