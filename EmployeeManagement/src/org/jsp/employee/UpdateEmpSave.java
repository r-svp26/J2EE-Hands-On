package org.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.EmployeeDAO;
import org.jsp.entity.Employee;

@WebServlet("/save")
public class UpdateEmpSave extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		String loginname = request.getParameter("un");
		String password = request.getParameter("password");
		String username = request.getParameter("name");
		String country = request.getParameter("country");
		Employee e = new Employee();
		e.setId(id);
		e.setName(loginname);
		e.setPassword(password);
		e.setUsername(username);
		e.setCountry(country);
		int status = EmployeeDAO.update(e);
		if (status > 0) {
			RequestDispatcher rd = request.getRequestDispatcher("ViewEmployee");
			rd.forward(request, response);
			// response.sendRedirect("ViewEmployee");
		} else {
			out.println("Sorry! unable to update record");
		}
		out.close();
	}

}
