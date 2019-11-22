<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login page</title>
</head>
<body>
<form action="LoginServlet" method="post">
	<%
	if ("FAILED".equals(session.getAttribute("loginStatus"))) {
	%>	
	<p style="color: red;">Login failed. Please login again.</p>	
	<%} %>
	<br>
	Username: <input type="text" name="userId"/> <br>
	Password: <input type="password" name="password" /> <br>
	<input type="submit" value="Login">
</form>



</body>
</html>