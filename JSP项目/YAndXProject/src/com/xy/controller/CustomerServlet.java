package com.xy.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xy.bean.Company;
import com.xy.bean.Customer;
import com.xy.service.CusService;
import com.xy.service.CusServiceImpl;
import com.xy.util.Encrypt;
import com.xy.util.GetPath;

public class CustomerServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	public CusService cus;
	public CustomerServlet() {
		cus = new CusServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		System.out.println(path);
		if(path.equals("reg")){
			reg(req,resp);
		}else if(path.equals("cus_reg")){
			req.getRequestDispatcher("/cus_reg.jsp").forward(req, resp);
		}else if(path.equals("base")){
			req.getRequestDispatcher("/cus_base.jsp").forward(req, resp);
		}else if(path.equals("pwd_edit")){
			req.getRequestDispatcher("/cus_pwd_edit.jsp").forward(req, resp);
		}else if(path.equals("submit")){
			submit(req, resp);
		}else if(path.equals("pwd_submit")){
			pwdSubmit(req, resp);
		}
	}
	
	private void pwdSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		Customer customer = (Customer)session.getAttribute("customer");
		String pwd = customer.getPassword();
		String oldPwd = Encrypt.encrypt(req.getParameter("old_pwd").trim());
		String newPwd = req.getParameter("new_pwd").trim();
		String surePwd = req.getParameter("sure_pwd").trim();
		if(!oldPwd.equals(pwd)){
			req.setAttribute("old_pwdCuo", "原始密码错误！");
			req.getRequestDispatcher("/cus_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(!surePwd.equals(newPwd)){
			req.setAttribute("oldAndNewCuo", "新密码和确认密码不一致！");
			req.getRequestDispatcher("/cus_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(oldPwd.equals("") || oldPwd == null){
			req.setAttribute("old_pwdNull", "原始密码不能为空！");
			req.getRequestDispatcher("/cus_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(newPwd.equals("") || newPwd == null){
			req.setAttribute("old_pwdNull", "新密码不能为空！");
			req.getRequestDispatcher("/cus_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(surePwd.equals("") || surePwd == null){
			req.setAttribute("sure_pwdNull", "确认密码不能为空！");
			req.getRequestDispatcher("/cus_pwd_edit.jsp").forward(req, resp);
			return;
		}
		
		customer.setPassword(surePwd);
		req.setAttribute("company", customer);
		cus.updatePwd(customer);
		req.getRequestDispatcher("/pwd_editSucceed.jsp").forward(req, resp);
	}
	
	private void submit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("name").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		String plot_name = req.getParameter("plot_name").trim();
		String cuo = null;
		if(name.equals("") || name == null){
			req.setAttribute("nameCuo", "名字不能为空！");
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
			req.getRequestDispatcher("/cus_case.jsp").forward(req, (ServletResponse) resp);
		}else { 
			HttpSession session = req.getSession();
			Customer customer = (Customer)session.getAttribute("customer");
			customer.setName(name);
			customer.setAddress(address);
			customer.setPhone(phone);
			customer.setPlot_name(plot_name);
			cus.update(customer);
			session.setAttribute("customer", customer);
			req.getRequestDispatcher("/cus_base.jsp").forward(req, (ServletResponse) resp);
		}
	}
	
	private void reg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		System.out.println(email+pwd+name+phone+"$$$");
		List<String> list = new ArrayList<String>();
		if(email.trim().equals("") || email.trim() == null){
			 list.add("您输入的邮箱是空的！");
		}
		if(pwd.trim().equals("") || pwd.trim() == null){
			 list.add("您输入的密码是空的！");
		}
		if(name.trim().equals("") || name.trim() == null){
			 list.add("您输入的名称是空的！");
		}
		if(phone.trim().equals("") || phone.trim() == null){
			 list.add("您输入的邮箱是空的！");
		}
		req.setAttribute("cuo", list);
		if(list!=null){
			req.getRequestDispatcher("/cus_reg.jsp ").forward(req, resp);
		}
	}
}
