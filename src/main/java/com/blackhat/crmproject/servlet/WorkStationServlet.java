package com.blackhat.crmproject.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.blackhat.crmproject.util.ServletConstant;

@WebServlet(urlPatterns = ServletConstant.PROJECTS)
public class WorkStationServlet extends HttpServlet{
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String action = req.getServletPath();
		if( action.equals(ServletConstant.PROJECTS)) {
			req.getRequestDispatcher(ServletConstant.PROJECTS).forward(req, resp);
		}else {
			// TODO
			throw new ArithmeticException("URL- not foud");
		}
	}
}
