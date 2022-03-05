package com.blackhat.crmproject.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.blackhat.crmproject.common.DBConnection;
import com.blackhat.crmproject.dto.UserDto;
import com.blackhat.crmproject.model.User;

public class UserRepositoryImp implements UserRepository {

	public List<User> findAll() {
		List<User> users = null;
		
		try (Connection connection = DBConnection.getConnection()) {
			String query = "SELECT * FROM player";
			
			PreparedStatement statement = connection.prepareStatement(query);
			ResultSet results = statement.executeQuery();
			
			users = new LinkedList<>();
			while (results.next()) {
				User user = new User();
				
				user.setId(results.getInt("id"));
				user.setEmail(results.getString("email"));
				user.setFullname(results.getNString("name"));
				user.setRoleId(results.getInt("role_id"));
				user.setPhone(results.getString("phone"));
				user.setPassword(results.getString("password"));
				user.setAddress(results.getString("address"));
				
				users.add(user);
			}
	
		} catch (SQLException e) {
			System.out.println("Kết nối đến cơ sở dữ liệu thất bại." );
			e.printStackTrace();
		}		
		return users;
	}

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
			System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			e.printStackTrace();
		}
		return entity;
	}

	public int deleteById(int id) {
		int result = -1;
		String query = "DELETE FROM user WHERE id = ?";
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setInt(1, id);
			
			result = statement.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			e.printStackTrace();
		}
		return result;
	}

	public int add(UserDto userDto) {
		int result = -1;
		String query = "INSERT INTO user(email, address, name, phone, role_id, password)"
				+ "VALUES(?,?,?,?,?,?,?)";
		
		Connection connection = DBConnection.getConnection();
		
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(2, userDto.getEmail());
			statement.setString(3, userDto.getAddress());
			statement.setString(4, userDto.getFullname());
			statement.setString(5, userDto.getPhone());
			statement.setLong(6, userDto.getRoleId());
			statement.setString(7, userDto.getPassword());

			result = statement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			e.printStackTrace();
		}
		return result;
		
	}

	public int update(UserDto userDto) {
		int result = -1;
		String query = "UPDATE user SET email = ?, address = ?, name =?, phone =?, role_id =?, password =?";
		Connection connection = DBConnection.getConnection();
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			
			statement.setString(1, userDto.getEmail());
			statement.setString(2, userDto.getAddress());
			statement.setString(3, userDto.getFullname());
			statement.setString(4, userDto.getPhone());
			statement.setLong(5, userDto.getRoleId());
			statement.setString(6, userDto.getPassword());

			result = statement.executeUpdate();
			
		}catch (SQLException e) {
			System.out.println("Không thể kết nối đến cơ sở dữ liệu.");
			e.printStackTrace();
		}
		return result;
		
	}
	
	

	

}
