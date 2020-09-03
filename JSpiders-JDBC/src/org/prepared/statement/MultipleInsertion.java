package org.prepared.statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MultipleInsertion {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ptmt = null;

		String qry = "INSERT INTO USER VALUES(?,?,?)";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver registered and loaded");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			System.out.println("Connection Established!");

			ptmt = conn.prepareStatement(qry);
			System.out.println("Platform created...");

			/* SET THE VALUE OF PLACEHOLDER BEFORE EXECUTION */
			ptmt.setString(1, "r-svp26");
			ptmt.setString(2, "Sonali");
			ptmt.setString(3, "r4321");
			ptmt.executeUpdate();

			ptmt.setString(1, "m-hn10");
			ptmt.setString(2, "Rekha");
			ptmt.setString(3, "m1111");
			ptmt.executeUpdate();

			ptmt.setString(1, "sn-12");
			ptmt.setString(2, "Sonam");
			ptmt.setString(3, "s1234");
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
