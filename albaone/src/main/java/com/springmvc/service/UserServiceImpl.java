package com.springmvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springmvc.domain.User;
import com.springmvc.repository.UserRepositoryImpl;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepositoryImpl userRepository;

	@Override
	public void setNewUser(User user) {
		userRepository.setNewUser(user);
	}

	@Override
	public boolean loginUser(String id, String password) {
		return userRepository.loginUser(id, password);
	}

	@Override
	public String findBusinessNumber(String id) {
		return userRepository.findBusinessNumber(id);
	}

	@Override
	public User findUserById(String id) {
		return userRepository.finUserById(id);
	}

	@Override
	public int idcheck(String userId) {
		return userRepository.idcheck(userId);
	}

	@Override
	public void updateUser(User user) {
		userRepository.updateUser(user);
	}

	@Override
	public void deleteUser(String id) {
		userRepository.deleteUser(id);
	}

}
