package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.DAO.DAOEmployee;


@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DAOEmployee dao = new DAOEmployee();
		String email = request.getParameter("email");
		String empName = request.getParameter("empName");

		PrintWriter out = response.getWriter();
		
		out.println("<html>");
		out.println("<head>");
		out.println("<link type='text/css' rel='stylesheet' href='css/style.css'>");
		out.println("</head>");
		out.println("<body>");
		
		if (dao.updateRegistration(email, empName)) {
			out.println("<font color=green> <center> <h2> Employee email with Employee name - " + empName
					+ " has been updated </h2> </center> </font>");
		}
		
		else {
			out.println("<font color=red> <center> <h2> Not Updated </h2> </center> </font> ");
		}
		
		out.println("<font color=dodgerblue> <center> <h2> <a href = 'view.jsp'> Home Page </a>  </h2> </center> </font> ");
		out.println("</body>");
		out.println("</html>");
	}

}
