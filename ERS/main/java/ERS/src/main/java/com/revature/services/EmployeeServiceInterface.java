package com.revature.services;

import java.util.List;

import com.revature.models.User;

public interface EmployeeServiceInterface {
	public User addReimbursementRequest(int u, Double amount, String reimbursemntType);
	public List<User> viewPastTickets(int id);
}
