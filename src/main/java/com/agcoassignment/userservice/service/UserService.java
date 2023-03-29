package com.agcoassignment.userservice.service;

import com.agcoassignment.userservice.entity.User;

import java.util.List;

public interface UserService {

	public User createUser(User user);

	public User getUserById(Long userId);

	public List<User> getAllUsers();

	public User updateUser(User user);

	public void deleteUser(Long userId);
}