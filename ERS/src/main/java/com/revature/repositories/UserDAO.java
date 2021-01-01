package com.revature.repositories;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface UserDAO {
	
	public User findUserByUsernameAndPassword(String username, String password) throws UserNotFoundException;

}
