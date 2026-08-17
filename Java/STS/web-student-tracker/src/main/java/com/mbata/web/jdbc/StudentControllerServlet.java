package com.mbata.web.jdbc;

import java.io.IOException;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	private StudentDBUtil studentDBUtil;

	@Resource(name="jdbc/web_student_tracker")
	private DataSource dataSource;
		
	@Override
	public void init() throws ServletException {
		super.init();
		
		//create instance of db util and pass in connection pool/datasource
		try {
			studentDBUtil = new StudentDBUtil(dataSource);
		}catch(Exception e) {
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//list students in MVC fashion
		try {
			//read the "command" parameter
			String theCommand = request.getParameter("command");
			
			//if "command" parameter is missing, default to list the students
			if(theCommand == null)
				theCommand = "LIST";
			
			//route to the appropriate method
			switch(theCommand) {
			case "LIST":
				listStudents(request,response);
				break;
			case "ADD":
				addStudent(request, response);
				break;
			case "LOAD":
				loadStudent(request,response);
				break;
			case "UPDATE":
				updateStudent(request,response);
				break;
			case "DELETE":
				deleteStudent(request,response);
				break;
			case "SEARCH":
                searchStudents(request, response);
                break;
			default:
				listStudents(request, response);				
			}			
		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

	private void searchStudents(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// read search name from form data
        String theSearchName = request.getParameter("theSearchName");
        
        // search students from db util
        List<Student> students = studentDBUtil.searchStudents(theSearchName);
        
        // add students to the request
        request.setAttribute("STUDENT_LIST", students);
                
        // send to JSP page (view)
        RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
        dispatcher.forward(request, response);
		
	}

	private void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		// read Student id from data
		String studentId = request.getParameter("studentId");

		// get student from db (db util)
		studentDBUtil.deleteStudent(studentId);

		//send back to the main page (the student list)
		listStudents(request,response);

	}

	private void loadStudent(HttpServletRequest request, HttpServletResponse response) throws Exception{
		//read Student id from data
		String studentId = request.getParameter("studentId");
		
		//get student from db (db util)
		Student theStudent = studentDBUtil.getStudent(studentId);
		
		//place student in the request attribute
		request.setAttribute("THE_STUDENT", theStudent);
		
		//send to jsp page (update-student-form.jsp)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/update-student-form.jsp");
		dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read student info from form data
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		//create new student object
		Student newStudent = new Student(firstName,lastName,email);
		
		//add the student to the database
		StudentDBUtil.addStudent(newStudent);
		
		//send back to the main page (the student list)
		listStudents(request,response);
		
	}
	
	private void updateStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//read student info from form data
		int id = Integer.parseInt(request.getParameter("studentId"));
		String firstName = request.getParameter("firstname");
		String lastName = request.getParameter("lastname");
		String email = request.getParameter("email");
		
		//create new student object
		Student theStudent = new Student(id,firstName,lastName,email);
		
		//update the student to the database
		StudentDBUtil.updateStudent(theStudent);
		
		//send back to the main page (the student list)
		listStudents(request,response);
		
	}

	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//get students from db util
		List<Student> students = studentDBUtil.getStudent();
		
		//add the students to request obj
		request.setAttribute("STUDENT_LIST", students);
		
		//send to jsp page (view)
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-students.jsp");
		dispatcher.forward(request, response);
	}
}
