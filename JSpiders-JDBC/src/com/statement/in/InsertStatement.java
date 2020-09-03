package com.statement.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertStatement {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		String qry = "INSERT INTO STUDENT VALUES(3,'Kappu','Mumbai')";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			stmt = conn.createStatement();
			stmt.executeUpdate(qry);
			System.out.println("Data inserted successfully!");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

		}
	}
}
