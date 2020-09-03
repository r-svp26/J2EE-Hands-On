package org.resultset.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataRetrieval {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ptmt = null;
		ResultSet rs = null;

		String qry = "SELECT * FROM STUDENT";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver registerd and loaded successfully");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			System.out.println("Connection Established!");

			ptmt = conn.prepareStatement(qry);
			System.out.println("Platform created...");

			rs = ptmt.executeQuery();

			System.out.println("-------Student------Information-------");
			while (rs.next()) {
				int id = rs.getInt(1);
				String name = rs.getString(2);
				String loc = rs.getString(3);
				System.out.println(id + " " + name + " " + loc);
			}

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (rs != null)
				try {
					rs.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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
