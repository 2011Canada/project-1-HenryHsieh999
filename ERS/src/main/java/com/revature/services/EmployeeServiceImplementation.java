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
	public Reimbursement addFoodReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException {
		return rDAO.addFoodReimbursement(reimbursement);
	}

	@Override
	public Reimbursement addTravelReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException {
		return rDAO.addTravelReimbursement(reimbursement);
	}

	@Override
	public Reimbursement addLodgingReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException {
		return rDAO.addLodgingReimbursement(reimbursement);
	}

	@Override
	public Reimbursement addOtherReimbursementRequest(User user, Reimbursement reimbursement) throws SQLException {
		return rDAO.addOtherReimbursement(reimbursement);
	}
	

}
