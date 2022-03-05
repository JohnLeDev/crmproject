package com.blackhat.crmproject.filter;

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


import com.blackhat.crmproject.util.UrlConst;
import com.blackhat.crmproject.util.UtilConstant;

@WebFilter(urlPatterns = UrlConst.ALL)
public class LoginFilter implements Filter {

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String path = req.getServletPath();
		System.out.println(path);
		if( !(path.equals(UrlConst.LOGIN)) ) {
			Object user = req.getSession().getAttribute("user");
			if(user == null) {
				resp.sendRedirect(req.getContextPath() + UrlConst.LOGIN);
				return;
			} else {
				chain.doFilter(request, response);
			}
		} else {
		chain.doFilter(request, response);
		}
	}	

}
