package com.revature.repositories;

import com.revature.exceptions.UserNotFoundException;
import com.revature.models.User;

public class UserDAODebugger {
	public static void main(String[] args) throws UserNotFoundException {
		// TODO Auto-generated method stub
		UserDAO ud = new UserPostgresDAO();
		User u = new User(149.54, null, null, "travel", 1);
		
//		System.out.println(ud.findUserByUsernameAndPassword("ender", "truelight9"));
//		System.out.println(ud.findAllCustomer());
//		System.out.println(ud.viewBalance(7));
//		System.out.println(ud.createNewCustomerAccount(u1));
//		System.out.println(ud.createNewBankAccount(u));
//		System.out.println(ud.updateBankAccountBalance(u2));
//		System.out.println(ud.approveCustomerBankAccount(3));
//		System.out.println(ud.rejectCustomerBankAccount(3));
//		System.out.println(ud.findUserByUserId(2));
//		System.out.println(ud.findUserIdByUsername("ender"));
//		System.out.println(u.getUserId());
//		System.out.println(ud.updateBankAccountBalance(u2));
//		System.out.println(ud.findAllLockedUserAccounts());
//		System.out.println(ud.findAllCustomer());
//		System.out.println(ud.findAllBankAccountsUnderSameOwner(6));
//		System.out.println(ud.findAccountId(2));
//		System.out.println(ud.checkUserAccountStatus(6));
//		System.out.println(ud.deleteMoneyTransfer(2));
//		System.out.println(ud.addReimbursementRequest(u));
		System.out.println(ud.viewPastTickets(1));
	}
}
