<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<title>MVC Demo</title>
</head>
<body>
<h3>MVC Demo</h3>

	<table border=1>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
		</tr>		
		<c:forEach var="tempStudent" items="${student_list}">
			<tr>
				<td>${tempStudent.firstname}</td> 
				<td>${tempStudent.lastname}</td> 
				<td>${tempStudent.email}</td>
			</tr>			
		</c:forEach>
		
	</table>

</body>
</html>