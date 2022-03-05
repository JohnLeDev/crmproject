package com.blackhat.crmproject.service;

import java.util.ArrayList;
import java.util.List;

import com.blackhat.crmproject.model.User;
import com.blackhat.crmproject.repository.UserRepository;

public class StoreService {
	public static final List<User> users = UserRepository.findAll();
}
