package com.blackhat.crmproject.servlet;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.blackhat.crmproject.dto.UserDto;
import com.blackhat.crmproject.model.User;
import com.blackhat.crmproject.repository.UserRepository;
import com.blackhat.crmproject.service.AuthService;
import com.blackhat.crmproject.service.AuthServiceImp;
import com.blackhat.crmproject.service.StoreService;
import com.blackhat.crmproject.util.JspConst;
import com.blackhat.crmproject.util.UrlConst;

@WebServlet(name = "login", urlPatterns= {
		UrlConst.LOGIN,
		UrlConst.LOGOUT 
})
public class LoginServlet extends HttpServlet {
	
	private List<User> users;
	
	/*
	private AuthService authService;
	
	public LoginServlet() {
		authService = new AuthServiceImp();
	}*/
	
	@Override
	public void init() throws ServletException {
		super.init();
		users = StoreService.users;
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		switch (action) {
		case UrlConst.LOGIN:
			//check cookie
			Cookie[] cookies = req.getCookies();
			String email = null;	
			if(cookies != null) {
				Optional<Cookie> emailCookieOpt = Arrays.asList(cookies)
						.stream()
						.filter(t -> t.getName().equals("email"))
						.findFirst();
				if (emailCookieOpt.isPresent()) {
					email = emailCookieOpt.get().getValue();
				}
			}
			if(email != null) {
				req.setAttribute("lastEmail", email);
			}
			// gui qua jsp xu ly
			req.getRequestDispatcher(JspConst.LOGIN)
				.forward(req, resp);
			break;

		case UrlConst.LOGOUT:
			//gui lai login servlet
			resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
			break;
		default: 
			break;
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		String message;
		//UserDto userDto = authService.login();
		
		// tao cookie
		Cookie emailCookie = new Cookie("email", email);
		resp.addCookie(emailCookie);
		
		//ktra email password
		Optional<User> curUserOpt = users.stream()
				.filter(t -> t.getEmail().equals(email))
				.filter(t -> t.getPassword().equals(password))
				.findFirst();

		if(curUserOpt.isPresent()) {
			HttpSession session = req.getSession();
			session.setAttribute("user", curUserOpt.get());
			session.setMaxInactiveInterval(300);
			User curUser = UserRepository.findByEmail("email");
			//ktra role id de dieu huong
			servNavigator(req, resp, curUser);
		} else {
			message = "Ten dang nhap hoac mat khau khong dung, vui long kiem tra lai";
			req.setAttribute("message", message);
			req.getRequestDispatcher(JspConst.LOGIN)
				.forward(req, resp);
		}
	}

	private void servNavigator(HttpServletRequest req, HttpServletResponse resp, User curUser)
			throws IOException, ServletException {
		String message;
		switch(curUser.getRoleId()) {
		case 1://admin
			resp.sendRedirect(req.getContextPath() + UrlConst.ADMIN);
			break;
		case 2://leader
			resp.sendRedirect(req.getContextPath() + UrlConst.LEADER);
			break;
		case 3://user
			resp.sendRedirect(req.getContextPath() + UrlConst.USER);
			break;
		default:
			message = "Tai khoan loi, khong the dang nhap";
			req.setAttribute("message", message);
			req.getRequestDispatcher(JspConst.LOGIN)
				.forward(req, resp);	
		}
	}
}
