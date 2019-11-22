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
public int add(int a, int b) {
	return a + b;
}
%>

<%
int i =9 ;
int j = 4;
%>

This is: <%= add(i , j) %>

</body>
</html>