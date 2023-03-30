package com.agcoassignment.userservice.controller;

import com.agcoassignment.userservice.entity.User;
import com.agcoassignment.userservice.service.UserService;
import com.agcoassignment.userservice.util.Constants;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@RestController
@Slf4j
public class UserController {

	@Autowired
	private UserService userService;
	
	 

	@PostMapping(Constants.USER_REQUEST_MAPPING_PATH + "/createUser")
	public ResponseEntity<User> createUser(@RequestBody User user) {
		User createdUser = userService.createUser(user);
		return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
	}

	@GetMapping(Constants.USER_REQUEST_MAPPING_PATH + "/getUserById/{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") Long userId) {
		User user = userService.getUserById(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}

	@GetMapping(Constants.USER_REQUEST_MAPPING_PATH+"/getAllUsers")
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> users = userService.getAllUsers();
		
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@PutMapping(Constants.USER_REQUEST_MAPPING_PATH + "/updateUserData/{id}")
	public ResponseEntity<User> updateUser(@PathVariable("id") Long userId, @RequestBody User user) {
		user.setId(userId);
		User updatedUser = userService.updateUser(user);
		return new ResponseEntity<>(updatedUser, HttpStatus.OK);
	}

	@DeleteMapping(Constants.USER_REQUEST_MAPPING_PATH + "/deleteUserData/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable("id") Long userId) {
		userService.deleteUser(userId);
		return new ResponseEntity<>("User successfully deleted!", HttpStatus.OK);
	}
}
