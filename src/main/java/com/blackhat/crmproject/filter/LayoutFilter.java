package com.blackhat.crmproject.filter;

import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;

import com.blackhat.crmproject.util.UrlConst;
import com.opensymphony.sitemesh.webapp.SiteMeshFilter;

@WebFilter(displayName = "sitemesh",urlPatterns = UrlConst.ALL)
public class LayoutFilter  extends SiteMeshFilter{

}
