package com.springmvc.service;

import com.springmvc.domain.User;

public interface UserService {
	void setNewUser(User user);
	boolean loginUser(String id, String password);
	String findBusinessNumber(String id);
	public User findUserById(String id);
	int idcheck(String userId);
}
