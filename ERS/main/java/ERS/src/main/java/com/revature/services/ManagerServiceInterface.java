package com.revature.services;

import java.util.List;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public interface ManagerServiceInterface {
	public List<User> managerViewAllTickets();
	public User approveReimbursement(int reimbId);
	public User rejectReimbursement(int reimbId);
	public List<User> filterReimbursementStatus(String reimbStatus);
}
