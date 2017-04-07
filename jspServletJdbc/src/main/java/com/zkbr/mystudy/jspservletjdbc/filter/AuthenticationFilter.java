package com.zkbr.mystudy.jspservletjdbc.filter;

import com.zkbr.mystudy.jspservletjdbc.model.User;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebFilter("/manager")
public class AuthenticationFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpServletRequest = (HttpServletRequest) request;
		HttpServletResponse httpServletResponse = (HttpServletResponse) response;
	    HttpSession session = httpServletRequest.getSession();
	    User userInfo = (User) session.getAttribute("userInfo");
	    
	    if(userInfo == null) {
	    	httpServletResponse.sendRedirect(httpServletRequest.getContextPath() + "/login");
	    	return;
	    }
	
	    chain.doFilter(request, response);
	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}
