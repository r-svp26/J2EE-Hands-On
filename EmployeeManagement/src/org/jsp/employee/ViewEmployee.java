package org.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jsp.dao.EmployeeDAO;
import org.jsp.entity.Employee;


@WebServlet("/ViewEmployee")
public class ViewEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<body bgcolor='#42f5b6'><a href='index.html'>Add New Employee</a>");
		out.println("<h1>JSpiders Employees List</h1>");
		List<Employee> list = EmployeeDAO.getAllEmployees();
		out.print("<table border='1' width='100%'");
		out.print(
				"<tr><th>Id</th><th>UserName</th><th>Password</th><th>LoginName</th><th>Country</th><th>Edit</th><th>Delete</th></tr>");
		for (Employee e : list) {
			out.print("<tr><td>" + e.getId() + "</td><td>" + e.getName() + "</td><td>" + e.getPassword() + "</td><td>"
					+ e.getUsername() + "</td><td>" + e.getCountry() + "</td><td><a href='UpdateEmployee?id=" + e.getId()
					+ "'>edit</a></td><td><a href='RemoveEmployee?id=" + e.getId() + "'>delete</a></td></tr>");
		}
		out.print("</table>");
		out.println("</body>");
		out.close();

	}
}
