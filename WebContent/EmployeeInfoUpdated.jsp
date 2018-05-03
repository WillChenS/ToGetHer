<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Info Update Landing</title>
</head>
<body>

${returnStatement}
<br><br>
<form method="get" action="SelectEmployeeServlet">
    <button type="submit">Continue Editing</button>
</form>
<form method="get" action="ManagerHome.jsp">
    <button type="submit">Home</button>
</form>

</body>
</html>