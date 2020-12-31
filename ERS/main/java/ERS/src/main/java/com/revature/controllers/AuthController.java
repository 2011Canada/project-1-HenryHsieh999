package com.revature.controllers;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
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
		
		RequestDispatcher rd = null;
		
		HttpSession sess = req.getSession();
		if(u.getTpe().equals("employee")) {
			System.out.println("employee");
			
			sess.setAttribute("user", u);
			sess.setAttribute("userId", u.getUserId());
			if(null == sess.getAttribute("user")) {
				System.out.println("attribute is null");
			}else {
				System.out.println(sess);
				System.out.println(sess.getAttribute("user"));
				System.out.println(sess.getAttribute("userId"));
			}
//			req.getSession().setAttribute("user", u);
//			req.getSession().setAttribute("userId", u.getUserId());
//          res.sendRedirect("welcomeServlet");
			
			
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
			
		}else if(u.getTpe().equals("manager")){
			System.out.println("manager");
			sess.setAttribute("user", u);
			sess.setAttribute("userId", u.getUserId());
			if(null == sess.getAttribute("user")) {
				System.out.println("attribute is null");
			}else {
				System.out.println(sess);
				System.out.println(sess.getAttribute("user"));
				System.out.println(sess.getAttribute("userId"));
			}
			res.setStatus(200);
			res.getWriter().write(om.writeValueAsString(u));
		}
	}
	
	
	

}