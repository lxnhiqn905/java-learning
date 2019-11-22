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
	<h1>Cart page</h1>
	<br>
	<a href="/ShoppingApp/logout">Log out</a>
	<br>

	User: <%= session.getAttribute(Enums.USER_LOGIN.toString())%>

	<table>
		<% List<String> productList = (List<String>) session.getAttribute(Enums.CART_USER.toString());%>
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
			<th>Action</th>
		</tr>
		<%
		    for (int i = 0; i < productList.size(); i++) {
		%>
		<tr>
			<th><%=i%></th>
			<th>Product - <%=productList.get(i).toString()%></th>
			<th><a href="/ShoppingApp/cart?productCancleId=<%=productList.get(i).toString()%>">Cancle buy</a></th>
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