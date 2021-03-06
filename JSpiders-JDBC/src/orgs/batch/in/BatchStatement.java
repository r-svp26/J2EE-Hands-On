package orgs.batch.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BatchStatement {

	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;

		String in_Qry = "INSERT INTO STUDENT VALUES(12,'Meera','Sangam')";
		String del_Qry = "DELETE FROM STUDENT WHERE ID=11";
		String upd_Qry = "UPDATE STUDENT SET NAME='Deepu' WHERE ID=7";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver registered and loaded Successfully");

			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");
			System.out.println("Connection Established");

			/* Platform Created */
			stmt = conn.createStatement();
			System.out.println("Platform Created");

			/* ADD BATCH: DML STATEMENT */
			stmt.addBatch(in_Qry);
			stmt.addBatch(del_Qry);
			stmt.addBatch(upd_Qry);

			int[] batch = stmt.executeBatch();

			for (int info : batch) {
				System.out.println(info + " Data Modified");
			}

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
