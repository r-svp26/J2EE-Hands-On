package com.jdbc.batch;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchDAO {
	public static void main(String[] args) {

		try (Connection conn = DriverManager
				.getConnection("jdbc:mysql://localhost:3306/udemy?user=root&password=password");
				Statement st = conn.createStatement();) {

			st.addBatch("insert into account values(1,'Yadav','Khusi',20000)");
			st.addBatch("insert into account values(2,'Yadav','Ritesh',10000)");

			int[] result = st.executeBatch();

			for (int i = 0; i < result.length; i++) {
				System.out.println(+result[i]+ " Data is Inserted");

			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
