package com.springmvc.service;

import com.springmvc.domain.User;

public interface UserService {
	void setNewUser(User user);

	boolean loginUser(String id, String password);

	String findBusinessNumber(String id);

	void updateUser(User user);

	public User findUserById(String id);

	int idcheck(String userId);

	void deleteUser(String id);

	String getUserName(String id);
}
