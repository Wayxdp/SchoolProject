package com.mo.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mo.common.WebUtil;

public class indexServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2212192400946928297L;
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mothed = WebUtil.getUriMethod(req);
		if(Mothed.equals("customerlogin")){
			customerlogin(req,resp);
		}else if(Mothed.equals("customerreg")){
			customerreg(req,resp);
		}else if(Mothed.equals("companylogin")){
			companylogin(req,resp);
		}else if(Mothed.equals("companyreg")){
			companyreg(req,resp);
		}else if(Mothed.equals("designerlogin")){
			designerlogin(req,resp);
		}else if(Mothed.equals("designerreg")){
			designerreg(req,resp);
		}else if(Mothed.equals("supplylogin")){
			supplylogin(req,resp);
		}else if(Mothed.equals("supplyreg")){
			supplyreg(req,resp);
		}else if(Mothed.equals("Special_offers")){
			Special_offers(req,resp);
		}
	}
	/**
	 * 优惠活动界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void Special_offers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/sundry/Special_offers.jsp").forward(req, resp);
	}
	/**
	 * 建材商注册界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplyreg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_Supply/supplyreg.jsp").forward(req, resp);
	}
	/**
	 * 建材商登录界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplylogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_Supply/supplylogin.jsp").forward(req, resp);
	}
	/**
	 * 设计师注册界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerreg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_designer/designerreg.jsp").forward(req, resp);
	}
	/**
	 * 设计师登录界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerlogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_designer/designerlogin.jsp").forward(req, resp);
	}
	/**
	 * 装修公司注册界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companyreg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/companyreg.jsp").forward(req, resp);;
	}
	/**
	 * 装修公司登录界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companylogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/companylogin.jsp").forward(req, resp);
	}
	/**
	 * 业主注册界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void customerreg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_user/UserRegister.jsp").forward(req, resp);
	}
	/**
	 * 业主登录界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void customerlogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
	}
}
