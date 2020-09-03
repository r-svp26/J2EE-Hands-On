package orgs.transaction.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOTransaction {

	
	public static void main(String[] args) {

		Connection conn = null;
		Statement stmt = null;
		String qry1 = "UPDATE ACCOUNT SET BALANCE=BALANCE-2000 WHERE ACCNO=3149001500099210";
		String qry2 = "UPDATE ACCOUNT SET BALANCE=BALANCE+2000 WHERE ACCNO=3149001500091836";

		try {

			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");

			stmt=conn.createStatement();
			
			conn.setAutoCommit(false); // by default true
			stmt.executeUpdate(qry1);
			stmt.executeUpdate(qry2);
			conn.commit();
			System.out.println("Money transfer Successfully");

		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			if (conn != null)
				try {
					conn.rollback();
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
