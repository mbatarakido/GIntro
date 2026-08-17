<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="org.ben.dto.User" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
	<h1>Login Successful!!!</h1>
	<%
	//User user = (User)session.getAttribute("user");
	//User user = (User)request.getAttribute("user");
	
	//equivalent to the JSTL below

	%>
	<jsp:useBean id="user" class="org.ben.dto.User" scope="request">
		<jsp:setProperty property="userName" name="user" value="NewUser" />
	</jsp:useBean>
	
	Hello <jsp:getProperty property="userName" name="user"/>
</body>
</html>