package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xy.bean.Company;
import com.xy.bean.Customer;
import com.xy.bean.Designer;
import com.xy.bean.Supply;
import com.xy.service.ComService;
import com.xy.service.ComServiceImpl;
import com.xy.service.CusService;
import com.xy.service.CusServiceImpl;
import com.xy.service.DesService;
import com.xy.service.DesServiceImpl;
import com.xy.service.SupService;
import com.xy.service.SupServiceImpl;
import com.xy.util.Encrypt;
import com.xy.util.GetPath;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 4453465160500226642L;
	
	public ComService com;
	public DesService des;
	public SupService sup;
	public CusService cus;
	
	public LoginServlet() {
		com = new ComServiceImpl();
		des = new DesServiceImpl();
		sup = new SupServiceImpl();
		cus = new CusServiceImpl();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		System.out.println(path);
		if(path.equals("cus")){
			req.getRequestDispatcher("/cus_login.jsp").forward(req, resp);
		}else if(path.equals("com")){
			req.getRequestDispatcher("/com_login.jsp").forward(req, resp);
		}else if(path.equals("des")){
			req.getRequestDispatcher("/des_login.jsp").forward(req, resp);
		}else if(path.equals("sup")){
			req.getRequestDispatcher("/sup_login.jsp").forward(req, resp);
		}else if (path.equals("cuss")){
			cuss(req,resp);
		}else if (path.equals("coms")){
			coms(req,resp);
		}else if (path.equals("dess")){
			dess(req,resp);
		}else if (path.equals("sups")){
			sups(req,resp);
		}else if(path.equals("mangers")){
			
		}else if(path.equals("superMangers")){
			
		}else if(path.equals("customer")){
			req.getRequestDispatcher("/customer.jsp").forward(req, resp);
		}else if(path.equals("company")){
			req.getRequestDispatcher("/company.jsp").forward(req, resp);
		}else if(path.equals("designer")){
			req.getRequestDispatcher("/designer.jsp").forward(req, resp);
		}else if(path.equals("supply")){
			req.getRequestDispatcher("/supply.jsp").forward(req, resp);
		}else if(path.equals("manger")){
			req.getRequestDispatcher("/manger.jsp").forward(req, resp);
		}else if(path.equals("superManger")){
			req.getRequestDispatcher("/superManger.jsp").forward(req, resp);
		}
	}
	
	private void cuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String cuo = null;
		if(email.trim().equals("") || email.trim() == null){
			req.setAttribute("emailCuo", "您输入的邮箱是空的！");
			cuo = "cuo";
		}
		if(pwd.trim().equals("") || pwd.trim() == null){
			req.setAttribute("pwdCuo", "您输入的密码是空的！");
			cuo = "cuo";
		}
		Customer customer = cus.queryEmialAndPwd(email, Encrypt.encrypt(pwd));
		if(customer == null){
			req.setAttribute("loginCuo", "你输入的账号和密码不对");
			cuo = "cuo";
		}
		if(cuo == null && customer != null ){
			HttpSession session = req.getSession();
			session.setAttribute("customer", customer);
			resp.sendRedirect("customer");
		}else {
			req.getRequestDispatcher("/cus_login.jsp").forward(req, resp);
		}
	}
	
	private void coms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String cuo = null;
		if(email.trim().equals("") || email.trim() == null){
			req.setAttribute("emailCuo", "您输入的邮箱是空的！");
			cuo = "cuo";
		}
		if(pwd.trim().equals("") || pwd.trim() == null){
			req.setAttribute("pwdCuo", "您输入的密码是空的！");
			cuo = "cuo";
		}
		Company company = com.queryEmialAndPwd(email, Encrypt.encrypt(pwd));
		if(company == null){
			req.setAttribute("loginCuo", "你输入的账号和密码不对");
			cuo = "cuo";
		}
		if(cuo == null && company != null && company.getChecked().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("company", company);
			resp.sendRedirect("company");
		}else {
			req.getRequestDispatcher("/com_login.jsp").forward(req, resp);
		}
	}
	
	private void dess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String cuo = null;
		if(email.trim().equals("") || email.trim() == null){
			req.setAttribute("emailCuo", "您输入的邮箱是空的！");
			cuo = "cuo";
		}
		if(pwd.trim().equals("") || pwd.trim() == null){
			req.setAttribute("pwdCuo", "您输入的密码是空的！");
			cuo = "cuo";
		}
		Designer designer = des.queryEmialAndPwd(email, Encrypt.encrypt(pwd));
		if(designer == null){
			req.setAttribute("loginCuo", "你输入的账号和密码不对");
			cuo = "cuo";
		}
		if(cuo == null && designer != null && designer.getChecked().equals("Y")){
			System.out.println("SSSSSSSSS");
			HttpSession session = req.getSession();
			session.setAttribute("designer", designer);
			resp.sendRedirect("designer");
		}else {
			req.getRequestDispatcher("/des_login.jsp").forward(req, resp);
		}
	}
	
	private void sups(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String cuo = null;
		if(email.trim().equals("") || email.trim() == null){
			req.setAttribute("emailCuo", "您输入的邮箱是空的！");
			cuo = "cuo";
		}
		if(pwd.trim().equals("") || pwd.trim() == null){
			req.setAttribute("pwdCuo", "您输入的密码是空的！");
			cuo = "cuo";
		}
		Supply supply = sup.queryEmialAndPwd(email, Encrypt.encrypt(pwd));
		System.out.println(supply);
		if(supply == null){
			req.setAttribute("loginCuo", "你输入的账号和密码不对");
			cuo = "cuo";
		}
		if(cuo == null && supply != null && supply.getChecked().equals("Y")){
			HttpSession session = req.getSession();
			session.setAttribute("supply", supply);
			resp.sendRedirect("supply");
		}else {
			req.getRequestDispatcher("/sup_login.jsp").forward(req, resp);
		}
	}
}
