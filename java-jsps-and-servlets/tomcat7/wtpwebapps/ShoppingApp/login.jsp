<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="vn.neways.enums.Enums"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<%
	    if ("FAILED".equals(session.getAttribute(Enums.STATUS_LOGIN.toString()))) {
	%>
	<p style="color: red;">Login failed. Please check user/pass.</p>
	<p><a href="/ShoppingApp/signup">Signup</a></p>
	<%
	    }
	%>

	<form action="/ShoppingApp/login" method="post">
		<input type="text" name="user" required="required" /> <input
			type="text" name="pass" required="required" /> <input type="submit"
			value="Login" />
	</form>
</body>
</html>