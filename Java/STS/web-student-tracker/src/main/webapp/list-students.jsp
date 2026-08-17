<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, com.mbata.web.jdbc.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
	<title>Student Tracker App</title>
	<link type="text/css" rel="stylesheet" href="css/style.css" /s>
</head>

<body>
	
	<div id="wrapper" onclick="window.location.href='StudentControllerServlet';return false;">
		<div id="header">
			<h2 href="StudentControllerServlet">Web Student Tracker</h2>
		</div>
	</div>
	
	<div id="container">
		<div id="content">
		<!--  add a search box -->
        	<form action="StudentControllerServlet" method="GET">       
                <input type="hidden" name="command" value="SEARCH" />           
                Search student: <input type="text" name="theSearchName" />               
                <input type="submit" value="Search" class="add-student-button" />
            </form>
            
            <!-- add student button -->
			<input type="button" value="Add Student" onclick="window.location.href='add-student-form.jsp';return false;" class="add-student-button"/>
			<table border=1>
				<tr>
					<th>No.</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
				<c:forEach var="tempStudent" items="${STUDENT_LIST}">
				
					<!-- set up a update link for each student -->
					<c:url var="loadUpdateLink" value="StudentControllerServlet">
						<c:param name="command" value="LOAD"/>
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					
					<!-- set up delete link for each student -->
					<c:url var="deleteLink" value="StudentControllerServlet">
						<c:param name="command" value="DELETE" />
						<c:param name="studentId" value="${tempStudent.id}" />
					</c:url>
					
					<tr>
						<td>${tempStudent.id}</td> 
						<td>${tempStudent.firstname}</td> 
						<td>${tempStudent.lastname}</td> 
						<td>${tempStudent.email}</td>
						<td>
							<a href="${loadUpdateLink}">Update</a> | 
							<a href="${deleteLink}" onclick="if(!(confirm('Confirm delete?'))) return false">Delete</a> 					
						</td>
					</tr>			
				</c:forEach>		
			</table>
		</div>
	</div>

</body>
</html>










