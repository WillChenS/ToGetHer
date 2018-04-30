<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Mailing List</title>
</head>
<body>
<h3>Mailing List</h3>
<table>
	<c:forEach items="${FIRSTNAME}" var="firstname" varStatus="loop">
		<c:set var="address" value="${ADDRESS[loop.index]}" />
		<c:set var="lastname" value="${LASTNAME[loop.index]}" />
		<tr>
			<td><c:out value="${lastname}" /></td>
			<td><c:out value="${firstname}"/></td>
			<td><c:out value="${address}"/></td>
		</tr>	
	</c:forEach>
</table>
</body>
</html>