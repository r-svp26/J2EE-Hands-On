package com.statement.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteStatement {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		String qry = "DELETE FROM STUDENT WHERE ID=2";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver registered and loaded successfull");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			System.out.println("Connection Established...");

			stmt = conn.createStatement();
			System.out.println("Platform Created");

			stmt.executeUpdate(qry);
			System.out.println("Data deleted successfully!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (stmt != null)
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
