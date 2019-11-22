<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="vn.neways.dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login successfully</title>
</head>
<body>
Login successfully !!! <br>
<%
User userSession = (User) session.getAttribute("userLogin");
%>
Welcome: <%=userSession.getDisplay() %>

</body>
</html>