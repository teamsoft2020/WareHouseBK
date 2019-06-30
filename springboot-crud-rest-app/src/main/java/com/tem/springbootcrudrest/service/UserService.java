package com.tem.springbootcrudrest.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.tem.springbootcrudrest.model.User;

@Service
public interface UserService {

	public User createUser(User product);

	public User updateUser(User product);

	public String deleteById(long userId);

	public List<User> getUserList();
}
