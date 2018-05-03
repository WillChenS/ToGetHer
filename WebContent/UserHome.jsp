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
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">
<h2>Welcome to ToGetHer!</h2>
Your session ID:
<c:out value="${sessionScope.ID}"/>
<div>
<br>
<form action="recordDate.jsp" method= "post">
	<button type= "submit" formaction="SearchProfile.jsp" method="get"> Search Profiles </button><br>
	<hr>
	<button type= "submit" formaction="SeeDateServlet" method="get"> See Dates </button><br>
	<hr>
	<button type= "submit" formaction="GeoServlet" method="get"> Set Up A Geo Date </button><br>
	<hr>
	<button type= "submit" formaction="Like.jsp" method="get"> Like Profile </button><br>
	<hr>
	<button type= "submit" formaction="Refer.jsp" method="get"> Refer Date </button><br>
	<hr>
	<button type= "submit" formaction="StatsServlet" method="get"> See Statistics </button><br>
	<hr>
	<button type= "submit" formaction="MostActiveProfiles" method="get"> See Most Active Profiles </button><br>
	<hr>
	<button type= "submit" formaction="HighRatedProfiles" method="get"> See Most highly rated profilesMost highly rated profiles </button><br>
	<hr>
	<button type= "submit" formaction="PopularGeoDate" method="get"> See Popular geo-date locations </button><br>
	<hr>
	<button type= "submit" formaction="PersonalizedSuggestion" method="get"> See Personalized date suggestion list </button><br>
	<hr>
	</form>
	<h5><c:out value="${sessionScope.errorMsg}"/>	</h5>
</div>	
</body>
</html>