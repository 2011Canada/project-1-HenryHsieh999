package com.revature.services;

import java.sql.SQLException;
import java.util.List;

import com.revature.models.Reimbursement;
import com.revature.repositories.ReimbursementDAO;
import com.revature.repositories.ReimbursementPostgresDAO;

public class ManagerServiceImplementation implements ManagerServiceInterface{

	static private ReimbursementDAO rDAO = new ReimbursementPostgresDAO();

	@Override
	public List<Reimbursement> viewAllTickets() throws SQLException {
		return rDAO.getAllReimbursements();
	}

	@Override
	public Reimbursement approveReimbursementStatus(int reimbId) throws SQLException {
		return rDAO.approveReimbursementStatus(reimbId);
	}
	
	@Override
	public Reimbursement denyReimbursementStatus(int reimbId) throws SQLException {
		return rDAO.denyReimbursementStatus(reimbId);
	}

	@Override
	public List<Reimbursement> viewPending() throws SQLException {
		return rDAO.getAllPendingReimbursements();
	}

	@Override
	public List<Reimbursement> viewApproved() throws SQLException {
		return rDAO.getAllApprovedReimbursements();
	}

	@Override
	public List<Reimbursement> viewDenied() throws SQLException {
		return rDAO.getAllDeniedReimbursements();
	}

}
