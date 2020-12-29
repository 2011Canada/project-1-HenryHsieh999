package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface ManagerServiceInterface {
	public List<User> managerViewAllTickets();
	
}
