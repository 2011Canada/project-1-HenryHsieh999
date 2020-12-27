package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface ManagerServiceInterface {
	public User login(String username, String password) throws UserNotFoundException;
	public User findAccount(int id);
	public List<User> findAllUsers();
	
}
