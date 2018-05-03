<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Results</title>
</head>
<body>
		<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
		<h4> Your Results: <br></h4>
		<%
		int l = (Integer)request.getAttribute("length");
			if(l==0){
			%> There were no matches. <br> <%
		}else{
		for(int i=0; i<l; i++){
		int c = i+1;
		String pro = (String)request.getAttribute("ProfileID"+c);
		int height = (Integer)request.getAttribute("Height"+c);
		int weight = (Integer)request.getAttribute("Weight"+c);
		String hairColor = (String)request.getAttribute("HairColor"+c);
		int age = (Integer)request.getAttribute("Age"+c);
		%> ProfileId: <%=pro%> <br>
		Height: <%=height %> <br>
		Weight: <%=weight %> <br>
		Hair Color: <%=hairColor %>	<br>
		Age: <%=age %> <br>
		<hr>
		<% 
	}};
		%>
		</div>
</body>
</html>