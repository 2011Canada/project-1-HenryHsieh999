package com.revature.controllers;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.models.Credentials;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.UserServiceImplementation;
import com.revature.servlets.FrontController;

public class AuthController {
	
	private UserServiceImplementation usi = new UserServiceImplementation(new UserPostgresDAO());
	private ObjectMapper om = new ObjectMapper();
	
	//actually do the request
	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException {
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		User u = usi.login(cred.getUsername(), cred.getPassword());
		//use your session to keep track of your user permission level
		HttpSession sess = req.getSession();
		//user.getRole
		if(u.getTpe().equals("employee")) {
			sess.setAttribute("user-role", "employee");
			System.out.println("employee");
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
		}else if(u.getTpe().equals("manager")){
			System.out.println("manager");
			sess.setAttribute("user-role", "manager");
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
		}
//		res.setStatus(200);
//		res.getWriter().write(om.writeValueAsString(u));
	}
	
	
	

}