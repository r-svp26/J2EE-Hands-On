package com.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {
	public static void main(String[] args) {

		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/ritesh?user=root&password=admin");
				Statement st = conn.createStatement();) {

			st.addBatch("insert into student values(3,'Khusi','bihar')");
			st.addBatch("insert into student values(4,'Ritesh','bengaluru')");

			int[] result = st.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(+result[i]+ " Data is Inserted");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
