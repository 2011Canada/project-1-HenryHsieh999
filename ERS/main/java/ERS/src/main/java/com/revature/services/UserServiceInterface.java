package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserServiceInterface {
	public User login(String username, String password) throws UserNotFoundException;
	public User findAccount(int id);
	public User findUserIDByUsername(String username);
	public List<User> findAllUsers();
}
