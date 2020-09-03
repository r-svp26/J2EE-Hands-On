package orgs.batch.in;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PreparedBatch {

	public static void main(String[] args) {

		Connection conn = null;
		PreparedStatement ps1 = null;
		PreparedStatement ps2 = null;
		PreparedStatement ps3 = null;

		String in_Qry = "INSERT INTO STUDENT VALUES(17,'Pappu','Bhopal')";
		String del_Qry = "DELETE FROM STUDENT WHERE ID=6";
		String upd_Qry = "UPDATE STUDENT SET NAME='Sonam' WHERE ID=12";

		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet?user=root&password=admin");

			ps1 = conn.prepareStatement(in_Qry);
			ps1.addBatch();

			int[] info1 = ps1.executeBatch();
			for (int batch1 : info1) {
				System.out.println(batch1 + " Data Inserted Successfully");
			}

			ps2 = conn.prepareStatement(del_Qry);
			ps2.addBatch();

			int[] info2 = ps2.executeBatch();
			for (int batch2 : info2) {
				System.out.println(batch2 + " Data Deleted Successfully");
			}

			ps3 = conn.prepareStatement(upd_Qry);
			ps3.addBatch();

			int[] info3 = ps3.executeBatch();
			for (int batch3 : info3) {
				System.out.println(batch3 + " Data Updated Successfully");
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
			if (ps1 != null)
				try {
					ps1.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps2 != null)
				try {
					ps2.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			if (ps3 != null)
				try {
					ps3.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
		}
	}
}
