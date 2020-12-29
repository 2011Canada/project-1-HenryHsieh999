package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.User;
import com.revature.models.ViewAllPastTickets;
import com.revature.models.ManagerViewAllTickets;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.ManagerServiceImplementation;

public class ManagerViewAllTicketsController {
	
	private ManagerServiceImplementation msi = new ManagerServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();
	
	public void managerViewAllTickets(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		ManagerViewAllTickets mvat = om.readValue(req.getInputStream(), ManagerViewAllTickets.class);
		System.out.println(mvat);
		List<User> u = msi.managerViewAllTickets();
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
	}
}
