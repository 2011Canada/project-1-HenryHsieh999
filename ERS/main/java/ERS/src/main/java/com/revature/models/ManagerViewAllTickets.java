package com.revature.models;

import java.util.List;

public class ManagerViewAllTickets {
	private List<String> ManagerViewAllTickets;

	public List<String> getManagerViewAllTickets() {
		return ManagerViewAllTickets;
	}

	public void setManagerViewAllTickets(List<String> managerViewAllTickets) {
		ManagerViewAllTickets = managerViewAllTickets;
	}

	@Override
	public String toString() {
		return "ManagerViewAllTickets [ManagerViewAllTickets=" + ManagerViewAllTickets + "]";
	}
	
}
