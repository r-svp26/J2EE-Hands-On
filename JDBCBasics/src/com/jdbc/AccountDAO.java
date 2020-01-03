package com.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class AccountDAO {

	public static void main(String[] args) {

		try {
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/udemy", "root", "password");
			System.out.println("Connection Establish!!");

			Statement st = conn.createStatement();

			/*
			 * int result = st.
			 * executeUpdate("insert into account values(314900,'Yadav','Ritesh',10000)"
			 * ); System.out.println(result+ " row/s  got inserted..");
			 */

			/*
			 * int result = st.
			 * executeUpdate("update account set bal=30000 where accno=314900");
			 * System.out.println(result+ " row/s got updated..");
			 */

			/*
			 * int result =
			 * st.executeUpdate("delete from account where accno=314900");
			 * System.out.println(result+ " row/s got deleted..");
			 */

			/* ----------------To read the Data--------------------- */

			ResultSet rs = st.executeQuery("select * from account");
			while (rs.next()) {
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
				System.out.println(rs.getInt(4));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				Connection conn=null;
				if(conn!=null){
				  conn.close();
				  System.out.println("Connection closed!!");
			     }
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

}
