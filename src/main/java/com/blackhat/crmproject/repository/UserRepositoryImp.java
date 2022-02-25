package com.blackhat.crmproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.blackhat.crmproject.common.DBConnection;
import com.blackhat.crmproject.model.User;

public class UserRepositoryImp implements UserRepository {

	@Override
	public User findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findByEmail(String email) {
		String query = "SELECT * FROM users WHERE email = ?";
		User entity = null;
		Connection conn = DBConnection.getConnection();
		try {
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, email);
			// Thực thi câu lệnh truy vấn
			ResultSet resultSet = statement.executeQuery();
			// Chuyển dữ liệu qua User entity
			while (resultSet.next()) {
				entity = new User();
				entity.setId(resultSet.getInt("id"));
				entity.setEmail(resultSet.getString("email"));
				entity.setPassword(resultSet.getString("password"));
				entity.setFullname(resultSet.getString("fullname"));
				entity.setRoleId(resultSet.getInt("role_id"));
				break;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return entity;
	}

	

}
