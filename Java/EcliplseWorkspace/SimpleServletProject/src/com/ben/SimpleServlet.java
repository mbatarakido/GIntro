package com.ben;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SimpleServlet
 */
@WebServlet(description = "This is a simple servlet application demo.", urlPatterns = { "/SimServletPath" }, initParams= {@WebInitParam(name="defaultUser", value="John Doe")})
public class SimpleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");

		//response.getWriter().append("Served at: ").append(request.getContextPath());
				
		PrintWriter writer = response.getWriter();
		String userName = request.getParameter("userName");
		HttpSession session = request.getSession();
		ServletContext context = request.getServletContext();
		
		if(userName != "" && userName != null) {
			session.setAttribute("savedUserName", userName);
			context.setAttribute("savedUserName", userName);
		}
		writer.println("Parameter: " + userName + "<br>");
		writer.println("Session parameter: " + (String)(session.getAttribute("savedUserName")) + "<br>");
		writer.println("Context parameter: " + (String)(context.getAttribute("savedUserName")) + "<br>");
		writer.println("Init parameter: " + getServletConfig().getInitParameter("defaultUser"));

	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
				
		System.out.println("Hello from the POST method!");
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName");
		String fullName = request.getParameter("fullName");
		String prof = request.getParameter("prof");
		String location = request.getParameter("location");
		
		out.println("Hello " + userName + "! Your full name is " + fullName + "<br>");
		out.println("You are " + prof + "<br>");
		out.println("Your location is " + location + "<br>");
	}

}
