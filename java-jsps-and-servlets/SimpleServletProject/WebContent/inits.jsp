<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<%!

public void jspInit() {
	String user = getServletConfig().getInitParameter("initUser");
	ServletContext context = getServletContext();
	context.setAttribute("contextInitJsp", user);
}

%>

Init paramter is: <%= getServletConfig().getInitParameter("initUser") %>

Init context is: <%= getServletContext().getAttribute("contextInitJsp") %>

</body>
</html>