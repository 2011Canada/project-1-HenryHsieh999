package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface EmployeeServiceInterface {
	public User addReimbursementRequest(User id);
	public List<User> viewPastTickets(int id);
}
