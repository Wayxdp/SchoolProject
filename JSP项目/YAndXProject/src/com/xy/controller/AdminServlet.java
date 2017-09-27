package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy.util.GetPath;

public class AdminServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		if(path.equals("reg")){
			reg(req,resp);
		}
	}
	
	private void reg(HttpServletRequest req, HttpServletResponse resp){
		
	}
}
