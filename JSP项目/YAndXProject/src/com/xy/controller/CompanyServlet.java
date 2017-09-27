package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xy.bean.Company;
import com.xy.service.ComService;
import com.xy.service.ComServiceImpl;
import com.xy.util.Encrypt;
import com.xy.util.GetPath;

public class CompanyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public ComService com;
	public CompanyServlet() {
		com = new ComServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		System.out.println(path);
		if(path.equals("base")){
			req.getRequestDispatcher("/com_base.jsp").forward(req, resp);
		}else if(path.equals("pwd_edit")){
			req.getRequestDispatcher("/com_pwd_edit.jsp").forward(req, resp);
		}else if(path.equals("noSubmit")){
			req.getRequestDispatcher("/com_base.jsp").forward(req, resp);
		}else if(path.equals("submit")){
			editBase(req, resp);
		}else if(path.equals("pwd_submit")){
			pwdSubmit(req, resp);
		}
	}
	
	private void pwdSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		Company company = (Company)session.getAttribute("company");
		String pwd = company.getPassword();
		String oldPwd = Encrypt.encrypt(req.getParameter("old_pwd").trim());
		String newPwd = req.getParameter("new_pwd").trim();
		String surePwd = req.getParameter("sure_pwd").trim();
		if(!oldPwd.equals(pwd)){
			req.setAttribute("old_pwdCuo", "原始密码错误！");
			req.getRequestDispatcher("/com_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(!surePwd.equals(newPwd)){
			req.setAttribute("oldAndNewCuo", "新密码和确认密码不一致！");
			req.getRequestDispatcher("/com_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(oldPwd.equals("") || oldPwd == null){
			req.setAttribute("old_pwdNull", "原始密码不能为空！");
			req.getRequestDispatcher("/com_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(newPwd.equals("") || newPwd == null){
			req.setAttribute("old_pwdNull", "新密码不能为空！");
			req.getRequestDispatcher("/com_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(surePwd.equals("") || surePwd == null){
			req.setAttribute("sure_pwdNull", "确认密码不能为空！");
			req.getRequestDispatcher("/com_pwd_edit.jsp").forward(req, resp);
			return;
		}
		
		company.setPassword(Encrypt.encrypt(surePwd));
		req.setAttribute("company", company);
		com.updatePwd(company);
		req.getRequestDispatcher("/pwd_editSucceed.jsp").forward(req, resp);
	}
	private void editBase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("name").trim();
		String principal = req.getParameter("principal").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		String tel = req.getParameter("tel").trim();
		String longitude = req.getParameter("longitude");
		String latitude = req.getParameter("latitude");
		String des = req.getParameter("des");
		String cuo = null;
		if(name.equals("") || name == null){
			req.setAttribute("nameCuo", "名字不能为空！");
			cuo = "cuo";
		}
		if(principal.equals("") || principal == null){
			req.setAttribute("principalCuo", "负责人不能为空！");
			cuo = "cuo";
		}
		if(address.equals("") || address == null){
			req.setAttribute("addressCuo", "地址不能为空！");
			cuo = "cuo";
		}
		if(phone.equals("") || phone == null){
			req.setAttribute("phoneCuo", "电话不能为空！");
			cuo = "cuo";
		}
		if(cuo != null){
			req.getRequestDispatcher("/com_base.jsp").forward(req, (ServletResponse) resp);
		}else { 
			HttpSession session = req.getSession();
			Company company = (Company)session.getAttribute("company");
			company.setName(name);
			company.setPrincipal(principal);
			company.setAddress(address);
			company.setPhone(phone);
			company.setTel(tel);
			company.setDes(des);
			company.setLatitude(Float.valueOf(latitude));
			company.setLongitude(Float.valueOf(longitude));
			com.update(company);
			session.setAttribute("company", company);
			req.getRequestDispatcher("/com_base.jsp").forward(req, (ServletResponse) resp);
		}
	}
}
