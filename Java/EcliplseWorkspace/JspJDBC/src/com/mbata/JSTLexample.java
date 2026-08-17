package com.mbata;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/JSTLexample")
public class JSTLexample extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name="Mbata";
		
		request.setAttribute("label", name);
		RequestDispatcher rd=request.getRequestDispatcher("profile.jsp");
		rd.forward(request, response);
	}

}
