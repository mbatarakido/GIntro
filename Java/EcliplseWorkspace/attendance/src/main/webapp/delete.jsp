<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8" />
        <link rel="stylesheet" href="manager.css" />
        <title>Delete User</title>
    </head>
    <body>
    <%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); //HTTP 1.1
		response.setHeader("Pragma", "no-cache"); //HTTP 1.0
		response.setHeader("Expires", "0"); //Proxies
					
		if(session.getAttribute("user")==null){
		response.sendRedirect("login.jsp");
		}
	%>
        <div class="main_wrapper">
            <header>
                <div class="main_title">
                    <h1>Attendance Monitoring System</h1>
                </div>
                <nav>
                    <ul>
                        <li><a href="welcome.jsp">Home</a></li>
                        <li><a href="add.jsp">Add User</a></li>
                        <li><a href="update.jsp">Update User Info</a></li>
                        <li><a class="active" href="delete.jsp">Remove User</a></li>
                        <li><a href="records.jsp">View Records</a></li>
                    </ul>
                </nav>
            </header>
            <section>
                <div>
                <p>Enter user updated info below</p>
                    <form action="DeleteUser" method="get">
                    	User ID: <input class="box" type="number" name="uid" /><br><br>
                        User Type: <input type="radio" name="user" value="teacher">Teacher
                            <input type="radio" name="user" value="student" checked>Student<br><br>
                        
                        <input class="button" type="submit" value="Delete" /><br><br>
                        
                        <p>No account? <a href="register.html">Register</a></p>
                    </form>
                </div>
            </section>
        </div>
    </body>
</html>