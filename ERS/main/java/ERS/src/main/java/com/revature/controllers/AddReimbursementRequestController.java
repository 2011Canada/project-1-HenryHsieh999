package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.AddReimbursementRequest;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.EmployeeServiceImplementation;

public class AddReimbursementRequestController {
	
	private EmployeeServiceImplementation esi = new EmployeeServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();
	
	public void addReimbursementRequest(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
//		HttpSession sess = req.getSession(false);
		AddReimbursementRequest arr = om.readValue(req.getInputStream(), AddReimbursementRequest.class);
		System.out.println(arr);
		User u = esi.addReimbursementRequest(arr.getUserId(), arr.getAmount(), arr.getReimbursemntType());
//		System.out.println(u.getUserId());
		
		
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));	
	}
}
