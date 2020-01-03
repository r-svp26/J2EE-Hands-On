package com.servlet.intercomm;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName = req.getParameter("userName");
		String password = req.getParameter("password");

		try {

			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/udemy", "root", "password");
			Statement st = conn.createStatement();
			ResultSet rs = st.executeQuery("select * from user where email ='" + userName + "' and password='" + password+"'");
			
			RequestDispatcher rd= req.getRequestDispatcher("HomeServlet");
			if(rs.next()){
				req.setAttribute("message","Welcome to The Inter-Servlet Communication "+userName);
				rd.forward(req, resp);
			}else{
				rd=req.getRequestDispatcher("login.html");
				rd.include(req,resp);
			}

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
