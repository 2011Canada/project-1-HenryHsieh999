package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserServiceInterface {
	public User login(String username, String password) throws UserNotFoundException;
	
}
