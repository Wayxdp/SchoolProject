package com.mo.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mo.bean.Customer;

public class CustomerFilter implements Filter{
	private HttpServletRequest req ;
	private HttpServletResponse resp;
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		req = (HttpServletRequest)request;
		resp = (HttpServletResponse)response;
		HttpSession session = req.getSession();
		if(session.getAttribute("customer1") instanceof Customer){
			chain.doFilter(request, response);
		}else {
			req.getRequestDispatcher(req.getContextPath()).forward(req, resp);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
