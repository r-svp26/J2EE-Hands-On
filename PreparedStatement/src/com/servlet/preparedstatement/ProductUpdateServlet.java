package com.servlet.preparedstatement;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ProductUpdateServlet")
public class ProductUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Connection conn;
	PreparedStatement stmt;

	public void init() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			stmt = conn.prepareStatement("update product set price=? where id=?");

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		int id = Integer.parseInt(req.getParameter("id"));
		int price = Integer.parseInt(req.getParameter("price"));

		try {
			stmt.setInt(1, price);
			stmt.setInt(2, id);

			int result = stmt.executeUpdate();

			resp.setContentType("text/html");
			PrintWriter out = resp.getWriter();
			out.println("<b>" + result + " Product Updated Successfully!! </b> ");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public void destroy() {
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
