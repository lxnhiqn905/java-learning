<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
String userName = (String) request.getParameter("user");

//session.setAttribute("userSession", userName);

//application.setAttribute("userApplication", userName);
if (userName != null)
	pageContext.setAttribute("userPageContext", userName, PageContext.APPLICATION_SCOPE);

%>

This is userName in request: <%= userName %> <br>

This is userName in session: <%= session.getAttribute("userPageContext") %> <br>

This is userName in application: <%= application.getAttribute("userPageContext") %> <br>

This is userName in pageContext: <%= pageContext.getAttribute("userPageContext") %> <br>


</body>
</html>