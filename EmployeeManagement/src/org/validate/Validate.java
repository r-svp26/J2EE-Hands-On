package org.validate;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.jsp.dao.EmployeeDAO;

public class Validate {

	static Connection conn = null;
	static PreparedStatement psmt = null;

	public static boolean checkUser(String name, String pwd) {

		boolean status = false;
		conn = EmployeeDAO.getConnection();
		try {
			psmt = conn.prepareCall("select * from servlet.jspider where loginname=? and password=?");
			psmt.setString(1, name);
			psmt.setString(2, pwd);
			ResultSet rs = psmt.executeQuery();
			status = rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

}
