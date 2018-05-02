<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add, Edit, or Delete Customer Info</title>
</head>
<body>

<h1>Edit Customer Profile</h1>
    
    <c:forEach var="attribute" items="${attributes}" varStatus = "status">
    	${colNames[status.index]}: 
    	<c:out value = "${attribute}"/>
    	<br>
    </c:forEach>
    
    <br><br>
    
    Select an attribute to change, or check delete to delete the attribute:
    <form action="FinishEditProfileServlet" method="post">
		<input type="hidden" name="profileID" value="${attributes.get(0)}" />
        <select name="selectedCol">
            <c:forEach var="colName" items="${Selectables}">
                <option value="${colName}">${colName}</option>
            </c:forEach>
        </select>
        <input type="text" name="newValue" placeholder="Updated Value">
        <input type="submit" value="Submit" align="middle"> 
        <label></label><input type="checkbox" name="delete" value="DELETE">Delete</label>
    </form>
    

</body>