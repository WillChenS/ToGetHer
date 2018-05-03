<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style = "border:1px solid $D0D0D0;width:400px;padding:10px;" >
	<h3> Refer Two People To Go On A Blind Date </h3s>
	<form method = "GET" action = "ReferServlet">
		<h5> Search for profiles by ProfileID: </h5> <br>
		Profile 1: <input type="string" name="profile1" value = ""> <hr>
		Profile 1: <input type="string" name="profile2" value = ""> <hr>
		
		
		<input type="submit" value="Submit">
	</form>
	<h5><c:out value="${sessionScope.Msg}"/>	</h5>
	</div>
</body>
</html>