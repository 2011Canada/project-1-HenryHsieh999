package com.revature.models;

import java.util.List;

public class ViewAllPastTickets {
	private int userId;
	private List<String> allPastTickets;
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public List<String> getAllTickets() {
		return allPastTickets;
	}
	public void setAllTickets(List<String> allTickets) {
		this.allPastTickets = allTickets;
	}
	@Override
	public String toString() {
		return "ViewAllPastTickets [userId=" + userId + ", allPastTickets=" + allPastTickets + "]";
	}
	
}
