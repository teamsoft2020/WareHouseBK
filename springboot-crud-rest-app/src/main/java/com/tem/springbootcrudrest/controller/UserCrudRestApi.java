package com.tem.springbootcrudrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tem.springbootcrudrest.model.User;
import com.tem.springbootcrudrest.model.Vehicle;
import com.tem.springbootcrudrest.service.UserService;
import com.tem.springbootcrudrest.service.VehicleService;

@RestController
@RequestMapping("/api/v1")
public class UserCrudRestApi {


	@Autowired
	UserService userService;
	
	@PostMapping("/createuser")
	public User createUser(@Valid @RequestBody User user) {

		User userresponse = userService.createUser(user);

		return userresponse;
	}

	@PutMapping("/userupdate")
	public User updateUser(@Valid @RequestBody User user) {
		User userresponse = userService.updateUser(user);

		return userresponse;
	}

	

	@DeleteMapping("/user/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable(value = "id") long userId) {
		String response = userService.deleteById(userId);

		return ResponseEntity.ok(response);

	}

	@GetMapping("/userlist")
	public List<User> getUserList() {
		List<User> userList = userService.getUserList();
		return userList;
	}
}
