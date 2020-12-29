package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.ManagerARReimbursement;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.ManagerServiceImplementation;

public class ManagerApproveReimbursementController extends HttpServlet {
	private ManagerServiceImplementation msi = new ManagerServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();
	
	public void managerApproveReimbursement(HttpServletRequest req, HttpServletResponse res) throws JsonParseException, JsonMappingException, IOException {
		ManagerARReimbursement marr = om.readValue(req.getInputStream(), ManagerARReimbursement.class);
		System.out.println(marr);
		User u = msi.approveReimbursement(marr.getReimbId());
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(u));
	}
	

}
