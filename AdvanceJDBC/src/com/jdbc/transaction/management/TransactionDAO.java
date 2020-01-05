package com.jdbc.transaction.management;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TransactionDAO {
	public static void main(String[] args) {
		Connection conn = null;

		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/udemy?user=root&password=password");
			Statement st = conn.createStatement();

			conn.setAutoCommit(false); // by Default true
			st.executeUpdate("update account set bal=bal-500 where accno=2");
			st.executeUpdate("update account set bal=bal+500 where accno=1");
			conn.commit();
			System.out.println("Money transfer Successfully");

		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.close();
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	}

}
