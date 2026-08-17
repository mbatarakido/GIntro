package com.ben.attendance;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ben.dao.LoginDAO;

@WebServlet("/Connectdb")
public class Connectdb extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uname=request.getParameter("username");
		String pass=request.getParameter("password");
		
		LoginDAO login=new LoginDAO();
		
		if(login.check(uname, pass)) {
			
			HttpSession session=request.getSession();
			session.setAttribute("user", uname);
			response.sendRedirect("welcome.jsp");
		}else {
			response.sendRedirect("login.jsp");
		}
		
		
		
		
//		try { 
//            Connection con = DbConnection.initializeDatabase(); 
//            PreparedStatement st = con.prepareStatement("INSERT INTO student(student_id, st_name) VALUES(?, ?)"); 
//  
//            st.setInt(1, Integer.valueOf(request.getParameter("username")));
//            st.setString(2, request.getParameter("password"));
//            st.executeUpdate();
//            st.close(); 
//            con.close(); 
//            
//            PrintWriter out = response.getWriter(); 
//            out.println("<html><body><b>Successfully Inserted" + "</b></body></html>"); 
//        } 
//        catch (Exception e) { 
//            e.printStackTrace(); 
//        } 
	}

}
