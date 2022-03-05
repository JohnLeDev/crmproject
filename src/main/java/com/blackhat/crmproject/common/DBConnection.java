package com.blackhat.crmproject.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static final String url = "jdbc:mysql://localhost:3306/crm";
	private static final String username = "root";
	private static final String password = "171197";
	
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		}catch (ClassNotFoundException e) {
			System.out.println("Không tìm thấy driver cơ sở dữ liệu.");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			e.printStackTrace();
		}
		return null;
	}
}
