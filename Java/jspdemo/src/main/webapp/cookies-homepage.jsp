<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Training Portal</title>
</head>
<body>

<h3>Training Portal</h3>

    <!-- read the fav_lang Cookie -->
    <%
		String favlang = "Java";
    	Cookie[] cookies = request.getCookies();
    	if(cookies != null){
    		for(Cookie tempCookie: cookies){
    			if("myapp.fav_lang".equals(tempCookie.getName())){
    				favlang = tempCookie.getValue();
    				break;
    			}
    		}
    	}
	%>
	
	<!-- Show personalized page based on the favlang -->
	<h4>Latest News for <%=favlang %></h4>
	<ul>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
	</ul>
	<br><br>
	<h4>New books for <%=favlang %></h4>
	<ul>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
	</ul>
	<br><br>
	<h4>Some blogs for <%=favlang %></h4>
	<ul>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
	</ul>
	<br><br>
	<h4>REFs for <%=favlang %></h4>
	<ul>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
		<li>BlahBlahBlah</li>
	</ul>
	<br><br>
	<a href="cookies-personalize-form.html">Personalize your page</a>
</body>
</html>