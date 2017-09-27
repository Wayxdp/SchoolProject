package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.xy.util.GetPath;

public class IndexServlet extends HttpServlet{

	private static final long serialVersionUID = 3764434477631132783L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		System.out.println(path+"SSSS");
		if(path.equals("reg")){
			req.getRequestDispatcher("/cus_reg.jsp").forward(req, resp);
		}
	}
	
}
