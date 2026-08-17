<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mbata.web.jdbc.*" %>

<html>
<head>
	<title>Student Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" /s>
</head>

<%
	//not required if using jstl
	//get the students from the request obj (sent by the servlet)
	List<Student> theStudents = (List<Student>) request.getAttribute("STUDENT_LIST");
%>

<body>
	
	<div id="wrapper">
		<div id="header">
			<h2>Web Student Tracker</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
			<table border=1>
				<tr>
					<th>No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
				</tr>
				<% for(Student tempStudent:theStudents){ %>		
					<tr>
						<td><%=tempStudent.getId() %></td>
						<td><%=tempStudent.getFirstname() %></td> 
						<td><%=tempStudent.getLastname() %></td> 
						<td><%=tempStudent.getEmail() %></td>
					</tr>			
				<% } %>		
			</table>
		</div>
	</div>

</body>
</html>