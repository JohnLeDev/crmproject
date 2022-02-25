package com.blackhat.crmproject.repository;

import com.blackhat.crmproject.model.User;

public interface UserRepository {
	public User findAll();
	public User findByEmail(String email);
}
