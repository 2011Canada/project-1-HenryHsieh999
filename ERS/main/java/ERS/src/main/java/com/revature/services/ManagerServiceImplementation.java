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
	public List<Reimbursement> filterReimbursementStatus(String reimbStatus) throws SQLException {
		return rDAO.getAllReimbursementsByStatus(reimbStatus);
	}

	@Override
	public Reimbursement updateReimbursementStatus(int reimbId, String reimbStatus) throws SQLException {
		return rDAO.updateReimbursementStatus(reimbId, reimbStatus);
	}

}
