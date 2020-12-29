package com.revature.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
	public void userLogin(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
		Credentials cred = om.readValue(req.getInputStream(), Credentials.class);
		User u = usi.login(cred.getUsername(), cred.getPassword());
		//use your session to keep track of your user permission level
		HttpSession sess = req.getSession();
		//user.getRole
		
		if(u.getTpe().equals("employee")) {
			System.out.println("employee");
			Integer UID = u.getUserId();
			sess.setAttribute("UserID", UID);
			if(null == sess.getAttribute("UserID")) {
				System.out.println("attribute is null");
			}else {
				System.out.println(UID);
			}
			Cookie ck = new Cookie("UID", UID.toString());
			res.addCookie(ck);
			System.out.println(ck);
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
			
		}else if(u.getTpe().equals("manager")){
			System.out.println("manager");
			Integer UID = u.getUserId();
			sess.setAttribute("UserID", UID);
			if(null == sess.getAttribute("UserID")) {
				System.out.println("attribute is null");
			}else {
				System.out.println(UID);
			}
			Cookie ck = new Cookie("UID", UID.toString());
			res.addCookie(ck);
			System.out.println(ck);
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
		}
//		res.setStatus(200);
//		res.getWriter().write(om.writeValueAsString(u));
	}
	
	
	

}