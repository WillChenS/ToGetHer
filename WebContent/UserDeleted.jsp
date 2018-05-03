<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Deletiong Landing</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">

${returnStatement}
<br><br>
<form method="get" action="DeleteUser">
    <button type="submit">Delete Another Account</button>
</form>
<form method="get" action="ManagerHome.jsp">
    <button type="submit">Home</button>
</form>

</body>
</html>