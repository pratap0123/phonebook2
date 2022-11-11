<%@page import="com.entity.User"%>
<%@page import="java.sql.Connection"%>
<%@page import="com.conn.Dbconnect"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>PhoneBook</title> 
<%@include  file="component/allCss.jsp"%>
<style>
.back-img{
	background-image:url("img/backgnd.jpg");
	width:100%;
	height:80vh;
	
}
</style>
</head>
<body style="background-color:#234dde;">
	<%@include file="component/navbar.jsp" %>
	
	
	<%
		User us=(User)session.getAttribute("success");
	%>
	<div class="container-fluid back-img text-center text-warning">
		<div>
			<h1><font size="40pt">Welcome To PhoneBook</font></h1>
		</div>
	
	</div>
	<div style="margin-top: 20px">
	<%@include file="component/footer.jsp" %>
	</div>
</body>
</html>