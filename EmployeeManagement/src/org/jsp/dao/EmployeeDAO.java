package org.jsp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jsp.entity.Employee;

public class EmployeeDAO {

	public static Connection getConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306?user=root&password=admin");
			System.out.println("Connection Established Successfully!");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static int save(Employee emp) {
		int status = 0;
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"insert into servlet.jspider(id,loginname,password,username,country) values(?,?,?,?,?)");
			ps.setInt(1, emp.getId());
			ps.setString(2, emp.getName());
			ps.setString(3, emp.getPassword());
			ps.setString(4, emp.getUsername());
			ps.setString(5, emp.getCountry());
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static int update(Employee e) {
		int status = 0;
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement ps = conn.prepareStatement(
					"update servlet.jspider set loginname=?,password=?,username=?,country=? where id=?");
			ps.setString(1, e.getName());
			ps.setString(2, e.getPassword());
			ps.setString(3, e.getUsername());
			ps.setString(4, e.getCountry());
			ps.setInt(5, e.getId());
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return status;
	}

	public static int delete(int id) {
		int status = 0;
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement ps = conn.prepareStatement("delete from servlet.jspider where id=?");
			ps.setInt(1, id);
			status = ps.executeUpdate();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public static Employee getEmployeeById(int id) {
		Employee e = new Employee();
		try {
			Connection conn = EmployeeDAO.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from servlet.jspider where id=?");
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setUsername(rs.getString(4));
				e.setCountry(rs.getString(5));
			}
			conn.close();
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}

	public static List<Employee> getAllEmployees() {
		List<Employee> list = new ArrayList<Employee>();
		try {
			Connection con = EmployeeDAO.getConnection();
			PreparedStatement ps = con.prepareStatement("select * from servlet.jspider");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Employee e = new Employee();
				e.setId(rs.getInt(1));
				e.setName(rs.getString(2));
				e.setPassword(rs.getString(3));
				e.setUsername(rs.getString(4));
				e.setCountry(rs.getString(5));
				list.add(e);
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
