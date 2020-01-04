package com.management.session;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/SourceServlet")
public class SourceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/* To get Session using Cookie */

		System.out.println("Source Servlet Cookie");
		Cookie[] cookies = req.getCookies();
		for (int i = 0; i < cookies.length; i++) {
			System.out.println(cookies[i].getName());
			System.out.println(cookies[i].getValue());
		}

		/* To add Custom Cookie */

		resp.addCookie(new Cookie("Security-Token", "scnt12xy"));

		String userName = req.getParameter("userName");
		HttpSession session = req.getSession();
		session.setAttribute("user", userName);

		resp.setContentType("text/html");
		PrintWriter out = resp.getWriter();
		out.print("<h1> <a href='TargetServlet'>Click Here To Get Userame</a></h1>");

	}

}
