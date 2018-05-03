<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Dates</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">
<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	<h3> Your dates: </h3>
	<%
	int l = (Integer)request.getAttribute("length");
	if(l==0){
		%> You have no dates. <br> <%
	}else{
	for(int i=0; i<l; i++){
		int c = i+1;
		String p1 = (String)request.getAttribute("profile1"+c);
		String p2 = (String)request.getAttribute("profile2"+c);
		String dt = (String)request.getAttribute("dateTime"+c);
		String loc = (String)request.getAttribute("location"+c);
		int bfee = (Integer)request.getAttribute("booking"+c);
		String comments = (String)request.getAttribute("comments"+c);
		int u1r = (Integer)request.getAttribute("u1Rating"+c);
		int u2r = (Integer)request.getAttribute("u2Rating"+c);
		
		String[] splitDt = dt.split(" ");
		%> Profile 1: <%=p1%> <br>
		Profile 2: <%=p2 %> <br>
		Date and Time: <%=dt %> <br>
		Location: <%=loc %>	<br>
		Booking Fee: <%=bfee %> <br>
		User 1 Rating: <%=u1r %> <br> 
		User 2 Rating:  <%=u2r %> <br> 
		
		<form method = "GET" action = "DeleteDateServlet">
		<input type="hidden" value=<%=p1%> name = "profile1">
		<input type="hidden" value=<%=p2%> name = "profile2">
		<input type="hidden" value=<%=splitDt[0]%> name = "date">
		<input type="hidden" value=<%=splitDt[1]%> name = "time">
		<input type="submit" value="Cancel"></button>
		</form>
		<hr>
		<% 
	}};
	%>

	<form action="recordDate.jsp" method= "post">
	<button type= "submit" formaction="recordDate.jsp" method="get"> Set Up New Date </button><br>
	<hr>
	</form>
	
</div>
</body>
</html>