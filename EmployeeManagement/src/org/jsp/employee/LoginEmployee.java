package org.jsp.employee;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.validate.Validate;


@WebServlet("/loginEmployee")
public class LoginEmployee extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();

		String loginname = req.getParameter("nm");
		String password = req.getParameter("pw");

		if (Validate.checkUser(loginname, password)) {
			RequestDispatcher rd = req.getRequestDispatcher("ViewEmployee");
			rd.forward(req, resp);
		} else {
			out.println("Username or Password is incorrect!");
			RequestDispatcher rd = req.getRequestDispatcher("login.html");
			rd.include(req, resp);
		}
	}

}
