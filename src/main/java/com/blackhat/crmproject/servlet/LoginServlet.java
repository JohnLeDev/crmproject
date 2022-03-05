package com.blackhat.crmproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackhat.crmproject.dto.UserDto;
import com.blackhat.crmproject.service.AuthService;
import com.blackhat.crmproject.service.AuthServiceImp;
import com.blackhat.crmproject.util.ServletConstant;

@WebServlet(name = "login", urlPatterns= {ServletConstant.LOGIN, ServletConstant.LOGOUT, ServletConstant.REGISTER })
public class LoginServlet extends HttpServlet {
	
	private AuthService authService;
	
	public LoginServlet() {
		authService = new AuthServiceImp();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case ServletConstant.LOGIN:
			req.getRequestDispatcher(ServletConstant.JSPLOGIN).forward(req, resp);
			break;
		case ServletConstant.REGISTER:
			req.getRequestDispatcher(ServletConstant.JSPREGISTER).forward(req, resp);
			break;
		case ServletConstant.LOGOUT:
			break;
		default: 
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pass = req.getParameter("password");
		UserDto userDto = authService.login();
	}
}
