package com.xy.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.xy.util.GetPath;

public class RegisterServlet extends HttpServlet{

	private static final long serialVersionUID = 4453465160500226642L;
	
	public ComService com;
	public DesService des;
	public SupService sup;
	public CusService cus;
	
	public RegisterServlet() {
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
			req.getRequestDispatcher("/cus_reg.jsp").forward(req, resp);
		}else if(path.equals("com")){
			req.getRequestDispatcher("/com_reg.jsp").forward(req, resp);
		}else if(path.equals("des")){
			req.getRequestDispatcher("/des_reg.jsp").forward(req, resp);
		}else if(path.equals("sup")){
			req.getRequestDispatcher("/sup_reg.jsp").forward(req, resp);
		}else if (path.equals("cuss")){
			cuss(req,resp);
		}else if (path.equals("coms")){
			coms(req,resp);
		}else if (path.equals("dess")){
			dess(req,resp);
		}else if (path.equals("sups")){
			sups(req,resp);
		}
	}
	
	private void cuss(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		System.out.println(email+pwd+name+phone+"$$$");
		String cuo = null;
		if(email.trim().equals("") || email.trim() == null){
			req.setAttribute("emailCuo", "您输入的邮箱是空的！");
			cuo = "cuo";
		}
		if(pwd.trim().equals("") || pwd.trim() == null){
			req.setAttribute("pwdCuo", "您输入的密码是空的！");
			cuo = "cuo";
		}
		if(name.trim().equals("") || name.trim() == null){
			req.setAttribute("nameCuo", "您输入的名称是空的！");
			cuo = "cuo";
		}
		if(phone.trim().equals("") || phone.trim() == null){
			req.setAttribute("phoneCuo",  "您输入的电话是空的！");
			cuo = "cuo";
		}
		if(cuo != null){
			req.getRequestDispatcher("/cus_reg.jsp").forward(req, resp);
		}else {
			Customer customer = new Customer();
			customer.setEmail(email);
			customer.setPassword(pwd);
			customer.setName(name);
			customer.setPhone(phone);
			cus.add(customer);
			req.getRequestDispatcher("/cus_login.jsp").forward(req, resp);
		}
	}
	
	private void coms(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String name = req.getParameter("name").trim();
		String principal = req.getParameter("principal").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		System.out.println(email+pwd+name+principal+address+phone+"");
		String cuo = null;
		if(email.equals("") || email == null){
			req.setAttribute("emailCuo", "您输入的邮箱有误！");
			cuo = "cuo";
		}
		if(pwd.equals("") || pwd == null){
			req.setAttribute("pwdCuo", "您输入的密码有误！");
			cuo = "cuo";
		}
		if(name.equals("") || name == null){
			req.setAttribute("nameCuo", "您输入的名称有误！");
			cuo = "cuo";
		}
		if(principal.equals("") || principal == null){
			req.setAttribute("principalCuo", "您输入的负责人有误！");
			cuo = "cuo";
		}
		if(address.equals("") || address == null){
			req.setAttribute("addressCuo", "您输入的地址有误！");
			cuo = "cuo";
		}
		if(phone.equals("") || phone == null){
			req.setAttribute("phoneCuo", "您输入的电话有误！");
			cuo = "cuo";
		}
		if(cuo != null){
			req.getRequestDispatcher("/com_reg.jsp").forward(req, (ServletResponse) resp);
		}else {
			Company company = new Company();
			company.setEmail(email);
			company.setPassword(pwd);
			company.setName(name);
			company.setPrincipal(principal);
			company.setAddress(address);
			company.setPhone(phone);
			com.add(company);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
	}
	
	private void dess(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String name = req.getParameter("name").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		System.out.println(email+pwd+name+address+phone+"");
		String cuo = null;
		if(email.equals("") || email == null){
			req.setAttribute("emailCuo", "您输入的邮箱有误！");
			cuo = "cuo";
		}
		if(pwd.equals("") || pwd == null){
			req.setAttribute("pwdCuo", "您输入的密码有误！");
			cuo = "cuo";
		}
		if(name.equals("") || name == null){
			req.setAttribute("nameCuo", "您输入的名称有误！");
			cuo = "cuo";
		}
		if(address.equals("") || address == null){
			req.setAttribute("addressCuo", "您输入的地址有误！");
			cuo = "cuo";
		}
		if(phone.equals("") || phone == null){
			req.setAttribute("phoneCuo", "您输入的电话有误！");
			cuo = "cuo";
		}
		if(cuo != null){
			req.getRequestDispatcher("/index.jsp").forward(req, (ServletResponse) resp);
		}else{
			Designer designer = new Designer();
			designer.setEmail(email);
			designer.setPassword(pwd);
			designer.setName(name);
			designer.setAddress(address);
			designer.setPhone(phone);
			des.add(designer);
			req.getRequestDispatcher("/des_login.jsp").forward(req, resp);
		}
	}
	
	private void sups(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
		String email = req.getParameter("email").trim();
		String pwd = req.getParameter("pwd").trim();
		String name = req.getParameter("name").trim();
		String principal = req.getParameter("principal").trim();
		String address = req.getParameter("address").trim();
		String phone = req.getParameter("phone").trim();
		System.out.println(email+pwd+name+principal+address+phone+"");
		String cuo = null;
		if(email.equals("") || email == null){
			req.setAttribute("emailCuo", "您输入的邮箱有误！");
			cuo = "cuo";
		}
		if(pwd.equals("") || pwd == null){
			req.setAttribute("pwdCuo", "您输入的密码有误！");
			cuo = "cuo";
		}
		if(name.equals("") || name == null){
			req.setAttribute("nameCuo", "您输入的名称有误！");
			cuo = "cuo";
		}
		if(principal.equals("") || principal == null){
			req.setAttribute("principalCuo", "您输入的负责人有误！");
			cuo = "cuo";
		}
		if(address.equals("") || address == null){
			req.setAttribute("addressCuo", "您输入的地址有误！");
			cuo = "cuo";
		}
		if(phone.equals("") || phone == null){
			req.setAttribute("phoneCuo", "您输入的电话有误！");
			cuo = "cuo";
		}
		if(cuo != null){
			req.getRequestDispatcher("/sup_reg.jsp").forward(req, (ServletResponse) resp);
		}else {
			Supply supply = new Supply();
			supply.setEmail(email);
			supply.setPassword(pwd);
			supply.setName(name);
			supply.setPrincipal(principal);
			supply.setAddress(address);
			supply.setPhone(phone);
			sup.add(supply);
			req.getRequestDispatcher("/index.jsp").forward(req, resp);
		}
		
	}
}
