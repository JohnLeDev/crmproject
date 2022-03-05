package com.blackhat.crmproject.repository;

import java.util.List;

import com.blackhat.crmproject.dto.UserDto;
import com.blackhat.crmproject.model.User;

public interface UserRepository {
	public static List<User> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
	public static User findByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	public int deleteById(int id);
	public int add(UserDto userDto);
	public int update(UserDto userDto);
	
}
