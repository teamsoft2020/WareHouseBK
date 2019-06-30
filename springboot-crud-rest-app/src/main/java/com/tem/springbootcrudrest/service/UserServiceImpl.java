package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.tem.springbootcrudrest.model.User;
import com.tem.springbootcrudrest.repository.UserRepository;

@Component
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public User createUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public User updateUser(User user) {

		return userRepository.save(user);
	}

	@Override
	public String deleteById(long userId) {
		userRepository.deleteById(userId);
		return "Deleted User Successfully";
	}

	@Override
	public List<User> getUserList() {

	List<User> userList = userRepository.findAll();
		return userList;
	}

}
