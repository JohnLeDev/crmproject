package com.blackthat.crmproject.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


import com.blackhat.crmproject.util.ServletConstant;
import com.blackhat.crmproject.util.UtilConstant;

@WebFilter(urlPatterns = ServletConstant.ALL)
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String action = req.getServletPath();
		System.out.println(action);
		if(!action.equals("/login") && !action.equals("/register")) {
			HttpSession session = req.getSession();
			session.setAttribute("PROJECT", "project");
			if (session.getAttribute("PROJECT") !=null) {
				req.getRequestDispatcher(ServletConstant.JSPPOJECTS).forward(req, resp);
				return;
			}
			if(session.getAttribute(UtilConstant.USER_LOGIN) == null) {
				resp.sendRedirect(req.getContextPath() + ServletConstant.LOGIN);
				return;
			}
			
		}
		chain.doFilter(request, response);
	}

}
