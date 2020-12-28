package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;

public class EmployeeServiceImplementation implements EmployeeServiceInterface{
	private UserDAO ud;
	
	public EmployeeServiceImplementation(UserDAO ud) {
		this.ud = ud;
	}
	public User addReimbursementRequest(User id) {
		return ud.addReimbursementRequest(id);
	}

	public List<User> viewPastTickets(int id) {
		return ud.viewPastTickets(id);
	}

}
