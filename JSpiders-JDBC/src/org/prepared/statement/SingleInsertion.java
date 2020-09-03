package org.prepared.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SingleInsertion {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ptmt = null;

		String qry = "INSERT INTO STUDENT VALUES(?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver registered and loaded");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			System.out.println("Connection Established!");

			ptmt = conn.prepareStatement(qry);
			System.out.println("Platform created...");

			/* SET THE VALUE OF PLACEHOLDER BEFORE EXECUTION */
			ptmt.setInt(1, 13);
			ptmt.setString(2, "Maahi");
			ptmt.setString(3, "Bhopal");
			ptmt.executeUpdate();
			System.out.println("Data inserted successfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ptmt != null)
				try {
					ptmt.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
