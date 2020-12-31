package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.models.User;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementPostgresDAO;

public class EmployeeServiceImplementation implements EmployeeServiceInterface{

	static private ReimbursementDAO rDAO = new ReimbursementPostgresDAO();
	
	@Override
	public List<Reimbursement> viewPastTickets(User user) throws SQLException {
		return rDAO.getAllReimbursementsByUser(user);
	}

	@Override
	public Reimbursement addReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException {
		return rDAO.addReimbursement(reimbursement);
	}
	

}
