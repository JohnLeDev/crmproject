package com.blackthat.crmproject.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

import com.blackhat.crmproject.util.ServletConstant;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(displayName = "sitemesh",urlPatterns = ServletConstant.ALL)
public class LayoutFilter  extends SiteMeshFilter{

}
