package com.revature.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.exceptions.UnauthenticatedException;
import com.revature.exceptions.UnauthorizedException;
import com.revature.models.User;
import com.revature.repositories.UserPostgresDAO;
import com.revature.services.UserServiceImplementation;

public class ManagerController {

	private UserServiceImplementation usi = new UserServiceImplementation(new UserPostgresDAO());
	
	private ObjectMapper om = new ObjectMapper();
	

	public void findAllUsers(HttpServletRequest req, HttpServletResponse res) throws IOException {
		
		HttpSession sess = req.getSession();
		
		if(sess.getAttribute("tpe") == null) {
			throw new UnauthenticatedException();
		} else if(sess.getAttribute("tpe").equals("employee")) {
			findUserIDByUsername(req, res);
			System.out.println("employee");
		} else if(sess.getAttribute("tpe").equals("manager")) {
			//go to manager page
			System.out.println("manager");
		}
		List<User> allusers = usi.findAllUsers();
		res.setStatus(200);
		res.getWriter().write(om.writeValueAsString(allusers));	
	}
	
	public void findUserIDByUsername(HttpServletRequest req, HttpServletResponse res) throws IOException{
		HttpSession sess = req.getSession();
//		sess.setAttribute("employee", value);
	}
	
}