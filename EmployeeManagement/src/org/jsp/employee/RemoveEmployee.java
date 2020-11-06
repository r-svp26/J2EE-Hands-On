package org.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.jsp.dao.EmployeeDAO;

@WebServlet("/RemoveEmployee")
public class RemoveEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unused")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		int i = EmployeeDAO.delete(id);
		PrintWriter out = response.getWriter();
		out.println("<html><body bgcolor='#42f5b6'> " + "<h1>Record sucessfully deleted<h1> "
				+ "<form action='ViewEmployee' method='post'>"
				+ "<input type='submit' value='back'></body></form></html");
		out.flush();
		out.close();
	}

}
