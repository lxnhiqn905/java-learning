<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ page import="vn.neways.enums.Enums"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign up Page</title>
</head>
<body>
	<%
	    if ("FAILED".equals(session.getAttribute(Enums.STATUS_SIGNUP.toString()))) {
	%>
	<p style="color: red;">Sign up failed. Please check user/pass.</p>
	<%
	    }
	%>
	<form action="/ShoppingApp/signup" method="post">
		<input type="text" name="user" required="required" /> <input
			type="text" name="pass" required="required" /> <input type="submit"
			value="Signup" />
	</form>
</body>
</html>