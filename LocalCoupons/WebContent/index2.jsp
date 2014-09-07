<%@ page language="java" contentType="text/html; charset=windows-1255"
    import="il.ac.hit.model.*, java.util.*" pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head lang="en">
</head>
<body>
<%
	double lat = Double.parseDouble((String)request.getParameter("latitude"));
	double lon = Double.parseDouble((String)request.getParameter("longitude"));

%>
<h1>lat = <%=lat%></h1>
<h1>lon = <%=lon%></h1>

</body>
</html>