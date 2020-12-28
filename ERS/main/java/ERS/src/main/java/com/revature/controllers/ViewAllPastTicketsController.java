package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.AddReimbursementRequest;
import com.revature.models.User;
import com.revature.models.ViewAllPastTickets;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.EmployeeServiceImplementation;


public class ViewAllPastTicketsController extends HttpServlet {
	
	private EmployeeServiceImplementation esi = new EmployeeServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();
	
	public void viewAllPastTickets(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
//		HttpSession sess = req.getSession(false);
		ViewAllPastTickets vat = om.readValue(req.getInputStream(), ViewAllPastTickets.class);
		System.out.println(vat);
		List<User> u = esi.viewPastTickets(vat.getUserId());		
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));	
	}



}
