package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class UserServiceImplementation implements UserServiceInterface {
	private UserDAO ud;
	
	public UserServiceImplementation(UserDAO ud) {
		this.ud = ud;
	}

	public User login(String username, String password) throws UserNotFoundException {
		return ud.findUserByUsernameAndPassword(username, password);
	}

}
