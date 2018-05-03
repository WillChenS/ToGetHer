<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">
		<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
		<%
		String choose = (String)request.getAttribute("choose");
		if(choose.equals("pending")){
			%> <h4> Pending Dates: <br> </h4> 
			<% }else { %>
			<h4>  Past Dates: <br> </h4>
			<% } 
		int l = (Integer)request.getAttribute("length");
			if(l==0){
			%> There were no matches. <br> <%
		}else{
			
		for(int i=0; i<l; i++){
		int c = i+1;
		String pro1 = (String)request.getAttribute("profile1"+c);
		String pro2 = (String)request.getAttribute("profile2"+c);
		String dateTime = (String)request.getAttribute("dateTime"+c);
		%>
		Profile 1: <%=pro1%> <br>
		Profile 2: <%=pro2 %> <br>
		Date and Time: <%=dateTime %> <hr>
		
		<% 
		}};
		%>
		<form action="UserHome.jsp" method= "post">
		<button type= "submit" formaction="UserHome.jsp" method="get"> Home </button>
		</form>
		<hr>
		</div>

</body>
</html>