<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="vn.neways.dto.Product"%>
<%@ page import="vn.neways.enums.Enums"%>
<%@ page import="java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Home page</h1>
	<%
	    if (!"LOGON".equals(session.getAttribute(Enums.STATUS_LOGIN.toString()))) {
	%>
	<br>
	<a href="/ShoppingApp/signup">Signup</a>
	<br>
	<a href="/ShoppingApp/login">Login</a>
	<br>
	<%
	    } else {
	%>
	<br>
	<a href="/ShoppingApp/cart">Your cart</a>
	<br>
	<a href="/ShoppingApp/logout">Log out</a>
	<br>
	<%
	    }
	%>
	<table>
		<%
		    List<Product> productList = (List<Product>) application.getAttribute(Enums.PRODUCT_LIST_CANBUY.toString());
		%>
		<%
		    if (productList == null) {
		%>
		<p style="color: red">Product list is empty!</p><br>
		<a href="/ShoppingApp/">Reload product list</a>
		<%
		    } else {
		%>
		Total product :<%=productList.size()%>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<%if (session.getAttribute(Enums.USER_LOGIN.toString()) != null) { %>
			<th>Action</th>
			<% } %>
		</tr>
		<%
		    for (int i = 0; i < productList.size(); i++) {
		%>
		<tr>
			<th><%=i%></th>
			<th><%=productList.get(i).getInfo()%></th>
			<%if (session.getAttribute(Enums.USER_LOGIN.toString()) != null) { %>
			<th><a href="/ShoppingApp/buy?productId=<%=productList.get(i).getId()%>">Buy</a></th>
			<% } %>
		</tr>
		<%
		    }
		%>
		<%
		    }
		%>
	</table>

</body>
</html>