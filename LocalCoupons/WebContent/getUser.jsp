<%@ page language="java" contentType="text/html; charset=windows-1255"
    import="il.ac.hit.model.*" pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>get user</title>
</head>
<body>
	<h1>details about specific user</h1>

	<%
	
	User user = (User)request.getAttribute("user");

	%>

	<h3>Username: <%= user.getUsername() %></h3>
	<h3>Password: <%= user.getPassword() %></h3>
	<h3>Business Name: <%= user.getBusinessName() %></h3>
</body>
</html>