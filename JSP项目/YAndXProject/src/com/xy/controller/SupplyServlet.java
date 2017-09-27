package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.xy.bean.Supply;
import com.xy.service.SupService;
import com.xy.service.SupServiceImpl;
import com.xy.util.Encrypt;
import com.xy.util.GetPath;

public class SupplyServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;

	private SupService sup;
	public SupplyServlet() {
		sup = new SupServiceImpl();
	}
	
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String path = GetPath.getPath(req);
		if(path.equals("base")) {
			req.getRequestDispatcher("/sup_base.jsp").forward(req, resp);
		} else if(path.equals("submit")) {
			editBase(req, resp);
		} else if(path.equals("pwdEdit")) {
			req.getRequestDispatcher("/sup_pwd_edit.jsp").forward(req, resp);
		} else if(path.equals("edit")) {
			pwdEdit(req,resp);
		}
	}

	public void editBase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name").trim();
		String principal = req.getParameter("principal").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		String tel = req.getParameter("tel").trim();
		String longitude = req.getParameter("longitude").trim();
		String latitude = req.getParameter("latitude").trim();
		String des = req.getParameter("des").trim();
		String error = null;
		if(name.equals("") || name == null) {
			req.setAttribute("name", "名称不能为空");
			error = "error";
		}
		if(principal.equals("") || principal == null ) {
			req.setAttribute("principal", "负责人不能为空");
			error = "error";
		}
		if(address.equals("") || address == null) {
			req.setAttribute("address", "地址不能为空");
			error = "error";
		}
		if(error != null) {
			req.getRequestDispatcher("/sup_base.jsp").forward(req, resp);
		} else {
			HttpSession session = req.getSession();
			Supply supply = (Supply)session.getAttribute("supply");
			supply.setName(name);
			supply.setPrincipal(principal);
			supply.setAddress(address);
			supply.setTel(tel);
			supply.setPhone(phone);
			supply.setLongitude(Float.valueOf(longitude));
			supply.setLatitude(Float.valueOf(latitude));
			supply.setDes(des);
			sup.update(supply);
			session.setAttribute("supply", supply);
			req.getRequestDispatcher("/sup_base.jsp").forward(req, resp);
		}
	}
	
	public void pwdEdit(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Supply supply = (Supply)session.getAttribute("supply");
		String pwd = supply.getPassword();
		String old_pwd = Encrypt.encrypt(req.getParameter("old_pwd")).trim();
		String newPwd = req.getParameter("newPwd").trim();
		String sure_pwd = req.getParameter("sure_pwd").trim();
		if(!old_pwd.equals(pwd)) {
			req.setAttribute("old_pwd", "原始密码出错");
			req.getRequestDispatcher("/sup_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(!sure_pwd.equals(newPwd)) {
			req.setAttribute("newPwd", "新密码和确认密码不一致");
			req.getRequestDispatcher("/sup_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(old_pwd.equals("") || old_pwd == null) {
			req.setAttribute("null_pwd", "原始密码不能为空！");
			req.getRequestDispatcher("/sup_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(newPwd.equals("") || newPwd == null) {
			req.setAttribute("newNull", "新密码不能为空");
			req.getRequestDispatcher("/sup_pwd_edit.jsp").forward(req, resp);
			return;
		}
		if(sure_pwd.equals("") || sure_pwd == null) {
			req.setAttribute("sureNull", "确认密码不能为空");
			req.getRequestDispatcher("/sup_pwd_edit.jsp").forward(req, resp);
			return;
		}
		supply.setPassword(Encrypt.encrypt(sure_pwd));
		req.setAttribute("supply", supply);
		sup.updatePwd(supply);
		req.getRequestDispatcher("/pwd_editSucceed.jsp").forward(req, resp);
	}
}
