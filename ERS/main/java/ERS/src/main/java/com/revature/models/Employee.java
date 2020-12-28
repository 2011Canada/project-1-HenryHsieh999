package com.revature.models;

import java.sql.Timestamp;

public class Employee extends User{

	public Employee(int ersReimbAuthor, int reimbId, double amount, Timestamp reimbSubmitted, Timestamp reimbResolved, String reimbStatus, String reimbType) {
		super(ersReimbAuthor, reimbId, amount, reimbSubmitted, reimbResolved, reimbStatus, reimbType);
	}

}