package com.mbata;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class AddServlet extends HttpServlet{
	
	//Service method implementation
	/*
	 * public void service(HttpServletRequest req, HttpServletResponse res) throws
	 * IOException {
	 * 
	 * int i = Integer.parseInt(req.getParameter("num1")); int j =
	 * Integer.parseInt(req.getParameter("num2"));
	 * 
	 * int k = i+j;
	 * 
	 * PrintWriter out = res.getWriter();
	 * 
	 * out.println("Add Result = " + k);
	 * 
	 * }
	 */
	
	//HTTP GET method
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
			
		int i = Integer.parseInt(req.getParameter("num1"));
		int j = Integer.parseInt(req.getParameter("num2"));
			
		int k = i+j;
		
		//res.sendRedirect("square?k=" + k); //URL rewriting
		
		//Share data between different Servlets: use Session Management
		/*
		 * HttpSession session = req.getSession(); session.setAttribute("k", k);
		 * 
		 * res.sendRedirect("square");
		 */
		
		
		//req.setAttribute("k", k);
		
		/*
		 * Call Servlet from another Servlet: 
		 * 1. Request Dispatcher 
		 * 2. Redirect
		 */
		/*
		 * RequestDispatcher rd = req.getRequestDispatcher("square"); rd.forward(req,
		 * res);
		 */
		
		// Use Cookies
		Cookie cookie = new Cookie("k", k+"");
		res.addCookie(cookie);			
		
		res.sendRedirect("square");
	}
	
	//HTTP POST method
	/*
	 * public void doPost(HttpServletRequest req, HttpServletResponse res) throws
	 * IOException {
	 * 
	 * int i = Integer.parseInt(req.getParameter("num1")); int j =
	 * Integer.parseInt(req.getParameter("num2"));
	 * 
	 * int k = i+j;
	 * 
	 * PrintWriter out = res.getWriter();
	 * 
	 * out.println("Add Result = " + k);
	 * 
	 * }
	 */
}
