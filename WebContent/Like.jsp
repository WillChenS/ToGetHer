<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	<h3> Pick someone to like. Enter their Profile ID </h3s>
	<form method = "GET" action = "LikeServlet">
		<h4> Search for profiles by ProfileID: </h4> <br>
		Like: <input type="string" name="likee" value = ""> <hr>
		
		<input type="submit" value="Submit">
	</form>
	<h5><c:out value="${sessionScope.Msg}"/>	</h5>
	</div>
</body>
</html>