package com.revature.repositories;

import java.sql.SQLException;

import com.revature.models.Reimbursement;
import com.revature.models.User;

public class ReimbursementPostgresDAODebugger {	
	public static void main(String[] args) throws SQLException {
		ReimbursementDAO rd = new ReimbursementPostgresDAO();
		
		Reimbursement r = new Reimbursement(149.54, "travel", 1);
		User u = new User(1);
		
//		System.out.println(rd.addReimbursement(r));
		System.out.println(rd.getAllReimbursementsByUser(u));
	}
}
