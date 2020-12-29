package com.revature.services;

import java.util.List;

import com.revature.models.User;
import com.revature.repositories.UserDAO;
import com.revature.repositories.UserPostgresDAO;

public class ManagerServiceImplementation implements ManagerServiceInterface{
	
	private UserDAO ud;
	
	public ManagerServiceImplementation(UserDAO ud) {
		this.ud = ud;
	}
	
	public List<User> managerViewAllTickets() {
		return ud.managerViewAllTickets();
	}

	public User approveReimbursement(int reimbId) {
		return ud.approveReimbursement(reimbId);
	}

	public User rejectReimbursement(int reimbId) {
		return ud.rejectReimbursement(reimbId);
	}

}
