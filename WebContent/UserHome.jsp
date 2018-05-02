<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> ToGetHer Home </title>
</head>
<body>
<h2>Welcome to ToGetHer!</h2>
Your session ID:
<c:out value="${sessionScope.ID}"/>
<div>
<br>
<form action="recordDate.jsp" method= "post">
	<button type= "submit" formaction="SearchProfile.jsp" method="get"> Search Profiles </button><br>
	<hr>
	<button type= "submit" formaction="DateServlet" method="get"> Set Up A Date </button><br>
	<hr>
	<button type= "submit" formaction="GeoServlet" method="get"> Set Up A Geo Date </button><br>
	<hr>
	<button type= "submit" formaction="CnclDateServlet" method="get"> Cancel Date </button><br>
	<hr>
	<button type= "submit" formaction="ReferServlet" method="get"> Refer Date </button><br>
	<hr>
	<button type= "submit" formaction="StatsServlet" method="get"> Set Up A Date </button><br>
	<hr>
	
	
	</form>
</div>	
</body>
</html>