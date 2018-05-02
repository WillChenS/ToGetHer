<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Dates</title>
</head>
<body>
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
		String gloc = (String)request.getAttribute("geoLoc"+c);
		%> Profile 1: <%=p1%> <br>
		Profile 2: <%=p2 %> <br>
		Date and Time: <%=dt %> <br>
		Location: <%=loc %>	<br>
		Booking Fee: <%=bfee %> <br>
		User 1 Rating: <%=u1r %> <br> 
		User 2 Rating:  <%=u2r %> <br> 
		GeoLocation: <%=gloc %>
		<hr>
		<% 
	}};
	%>

	<form action="recordDate.jsp" method= "post">
	<button type= "submit" formaction="SearchProfile.jsp" method="get"> Set Up New Date </button><br>
	<hr>
	<button type= "submit" formaction="Like.jsp" method="get"> Cancel Date </button><br>
	<hr>
	<button type= "submit" formaction="Like.jsp" method="get"> Cancel Date </button><br>
	<hr>
	</form>
	
</div>
</body>
</html>