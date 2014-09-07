<%@ page language="java" contentType="text/html; charset=windows-1255"
    import="il.ac.hit.model.*" pageEncoding="windows-1255"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=windows-1255">
<title>get coupon</title>
</head>
<body>
	<h1>details about specific coupon</h1>

	<%

	Coupon coupon = (Coupon)request.getAttribute("coupon");

	System.out.println("getCoupon.jsp | coupon=" + coupon);

	%>

	<h3>coupon id: <%= coupon.getId() %></h3>
	<h3>coupon business: <%= coupon.getBusiness() %></h3>
	<h3>coupon image: <%= coupon.getImage() %></h3>
	<h3>coupon details: <%= coupon.getDetails() %></h3>
	<h3>coupon category: <%= coupon.getCategory() %></h3>
	<h3>coupon date: <%= coupon.getDate().toString() %></h3>

</body>
</html>