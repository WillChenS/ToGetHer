<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Delete User</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB">

<h1>Delete User</h1>

	<form action="DeleteUserServlet" method="post">
        Select a user to delete:
        <br><br>
        <select name="selectedUser">
            <c:forEach var="person" items="${people}" varStatus="loop">
                <option value="${ssn.get(loop.index)}">${person}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Submit" align="middle"> 
    </form>
    
    <table>
	    <c:forEach var="attribute" items="${attributes}">
	    	<tr><c:out value = "${attribute}"/></tr>
	    </c:forEach>
    </table>

</body>
</html>