<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Form</title>
</head>
<body>
	<s:form action="tutorials/search" method="post">
		<s:textfield key="searchKey" />
		<s:submit />
	</s:form>
</body>
</html>