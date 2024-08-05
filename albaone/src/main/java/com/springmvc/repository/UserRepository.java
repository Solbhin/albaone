package com.springmvc.repository;

import com.springmvc.domain.User;

public interface UserRepository {
	void setNewUser(User user);
	boolean loginUser(String id, String password);
	String findBusinessNumber(String id);
	void updateUser(User user);
	public User finUserById(String id);
	int idcheck(String userId);
	void deleteUser(String id);
}
