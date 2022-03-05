package com.blackhat.crmproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.jasper.tagplugins.jstl.core.Url;

import com.blackhat.crmproject.dto.UserDto;
import com.blackhat.crmproject.model.User;
import com.blackhat.crmproject.repository.UserRepository;
import com.blackhat.crmproject.util.JspConst;
import com.blackhat.crmproject.util.UrlConst;

@WebServlet(name = "userServlet", urlPatterns = {
		UrlConst.USER,
		UrlConst.USER_UPDATE,
		UrlConst.USER_TASK_UPDATE,
		UrlConst.USER_TASK_VIEW
})
public class UserServlet extends HttpServlet {
	UserDto userDto;
	
	@Override
	public void init() throws ServletException {
		super.init();
		userDto = new UserDto();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		User curUser = (User) req.getSession().getAttribute("user");
		req.setAttribute("curUser", curUser);
		req.getRequestDispatcher(JspConst.USER_DASHBOARD)
			.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = req.getServletPath();
		String email, password, fullname, roleId, address, phone, message;
		switch(path) {
		case UrlConst.USER_TASK_VIEW:
			
			break;
		case UrlConst.USER_TASK_UPDATE:
			
			break;
		case UrlConst.USER_UPDATE:
			req.getRequestDispatcher(JspConst.USER_UPDATE_PROFILE) // user ko dc sua role cua minh
			.forward(req, resp);
			
			userDto.setId(Integer.parseInt(req.getParameter("id")));
			userDto.setEmail(req.getParameter("email"));
			userDto.setFullname(req.getParameter("fullname"));
			userDto.setPassword(req.getParameter("password"));
			userDto.setRoleId(Integer.parseInt(req.getParameter("roleId")));
			userDto.setAddress(req.getParameter("address"));
			userDto.setPhone(req.getParameter("phone"));
			
			int result = UserRepository.update(userDto);
			if(result == -1) {
				message = "Da xay ra loi, khong the sua thong tin.";
				req.setAttribute("message", message);
				req.getRequestDispatcher(JspConst.USER_UPDATE_PROFILE) // user ko dc sua role cua minh
				.forward(req, resp);
			} else {
				req.getRequestDispatcher(JspConst.USER_DASHBOARD)
				.forward(req, resp);
			}
			break;
			
		}
	}

}
