<%@ page language="java" contentType="text/html; charset=windows-1255"
    pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page isErrorPage="true" %>
<html>
<head lang="en">
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>Error!</title>
<%@ taglib uri="/WEB-INF/tld/agcouponstags.tld" prefix="errorMessage" %>
<link href="css/font-awesome.min.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap-theme.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<style>
.borderless tbody tr td, .borderless thead tr th {
    border: none;
}

body

{
	font-family: "trebuchet ms", sans-serif;
}

h1{
	color: #229022;
}

h4
{
font-size: 20px !important;
line-height: 30% !important; 
color:red;

}

input{
	font-size: 20px !important;
}
</style>
</head>
<body>
<center>
<img src="http://mahshev.herobo.com/img/er1.jpg" border="0"></img>

<%
	String exceptionMsg = "\"" + exception.getMessage() + "\"";
	String errorMsg = "\"" + request.getAttribute("errmsg") + "\"";
%>

<errorMessage:error msg="Hello"></errorMessage:error>
<errorMessage:error msg="Hello"></errorMessage:error>

<a href="index.html"><img src="http://mahshev.herobo.com/img/er2.jpg" border="0"></img></a>
</center>

</body>
</html>