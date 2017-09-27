package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xy.bean.Company;
import com.xy.bean.Designer;
import com.xy.service.DesService;
import com.xy.service.DesServiceImpl;
import com.xy.util.Encrypt;
import com.xy.util.GetPath;

public class DesignerServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	public DesService des;
	public DesignerServlet() {
		des = new DesServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		if(path.equals("base")){
			req.getRequestDispatcher("/des_base.jsp").forward(req, resp);
		}else if(path.equals("pwd_edit")){
			req.getRequestDispatcher("/des_pwd_edit.jsp").forward(req, resp);
		}else if(path.equals("noSubmit")){
			req.getRequestDispatcher("/des_base.jsp").forward(req, resp);
		}else if(path.equals("submit")){
			submit(req, resp);
		}else if(path.equals("pwd_submit")){
			pwdSubmit(req, resp);
		}
	}
	
	private void pwdSubmit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		HttpSession session = req.getSession();
		Designer designer = (Designer)session.getAttribute("company");
		String pwd = designer.getPassword();
		String oldPwd = Encrypt.encrypt(req.getParameter("old_pwd").trim());
		System.out.println(pwd+"----"+oldPwd);
		String newPwd = req.getParameter("new_pwd").trim();
		String surePwd = req.getParameter("sure_pwd").trim();
		if(!oldPwd.equals(pwd)){
			req.setAttribute("old_pwdCuo", "原始密码错误！");
			req.getRequestDispatcher("/des_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(!surePwd.equals(newPwd)){
			req.setAttribute("oldAndNewCuo", "新密码和确认密码不一致！");
			req.getRequestDispatcher("/des_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(oldPwd.equals("") || oldPwd == null){
			req.setAttribute("old_pwdNull", "原始密码不能为空！");
			req.getRequestDispatcher("/des_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(newPwd.equals("") || newPwd == null){
			req.setAttribute("old_pwdNull", "新密码不能为空！");
			req.getRequestDispatcher("/des_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(surePwd.equals("") || surePwd == null){
			req.setAttribute("sure_pwdNull", "确认密码不能为空！");
			req.getRequestDispatcher("/des_pwd_edit.jsp").forward(req, resp);
			return;
		}
		
		designer.setPassword(surePwd);
		req.setAttribute("company", designer);
		des.updatePwd(designer);
		req.getRequestDispatcher("/pwd_editSucceed.jsp").forward(req, resp);
	}
	private void submit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String name = req.getParameter("name").trim();
		String principal = req.getParameter("principal").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		String tel = req.getParameter("tel").trim();
		String longitude = req.getParameter("longitude").trim();
		String latitude = req.getParameter("latitude").trim();
		String dess = req.getParameter("des").trim();
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
			req.getRequestDispatcher("/des_case.jsp").forward(req, (ServletResponse) resp);
		}else { 
			HttpSession session = req.getSession();
			Designer designer = (Designer)session.getAttribute("company");
			designer.setName(name);
			designer.setAddress(address);
			designer.setPhone(phone);
			designer.setDes(dess);
			des.update(designer);
			session.setAttribute("company", designer);
			req.getRequestDispatcher("/des_base.jsp").forward(req, (ServletResponse) resp);
		}
	}
}
