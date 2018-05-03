<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Form Processing</title>
</head>
<body style="font-size: 12pt; text-align: center" bgcolor="#FBD6CB"> >
  <h3>Successfully Updated Parameter values:</h3>
  <%
    String userName = request.getParameter("userName");
    String password = request.getParameter("password");
    String firstName = request.getParameter("firstName");
    String lastName = request.getParameter("lastName");
    String gender = request.getParameter("gender");
    
    
    String[] addresses = request.getParameterValues("address");      
  
  %>
  
  User Name: <%=userName %> <br>
  Password: <%=password %> <br>
  First Name: <%=firstName %> <br>
  Last Name: <%=lastName %> <br>
  
  Gender: <%=gender %> <br>
  
  <% if (addresses!= null)  {
       for(String address: addresses)  {
      %>
 
     Address: <%=address %> <br>
  
  <% } } %>	
  
  <button type="submit" formaction="RegisterServlet"> Confirm </button>
  
</body>
</html>