package com.mo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mo.bean.Admin;
import com.mo.bean.Company;
import com.mo.bean.Company_colAndCompany;
import com.mo.bean.Compnay_caseAndCustomerAndCompany;
import com.mo.bean.Customer;
import com.mo.bean.CustomerAndDesignerAndDesigner_case;
import com.mo.bean.CustomerAndProductAndProduct_col;
import com.mo.bean.Designer_col;
import com.mo.bean.DesignercaseAndDesigner;
import com.mo.bean.Product_col;
import com.mo.bean.Supply;
import com.mo.bean.Supply_col;
import com.mo.bean.Supply_colAndsupply;
import com.mo.common.Constants;
import com.mo.common.DataTime;
import com.mo.common.DateUtil;
import com.mo.common.Encrypt;
import com.mo.common.WebUtil;
import com.mo.daoimpl.Product_colDAOImpl;
import com.mo.service.Company_case_colService;
import com.mo.service.Company_colService;
import com.mo.service.CustomerService;
import com.mo.service.Designer_case_colService;
import com.mo.service.Designer_colService;
import com.mo.service.Product_colService;
import com.mo.service.SupplyService;
import com.mo.service.Supply_colService;
import com.mo.serviceimpl.Company_case_colServiceImpl;
import com.mo.serviceimpl.Company_colServiceImpl;
import com.mo.serviceimpl.CustomerServiceImpl;
import com.mo.serviceimpl.Designer_case_colServiceImpl;
import com.mo.serviceimpl.Designer_colServiceImpl;
import com.mo.serviceimpl.Product_colServiceImpl;
import com.mo.serviceimpl.SupplyServiceImpl;
import com.mo.serviceimpl.Supply_colServiceImpl;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class CustomerServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4855478080654991672L;
	
	private CustomerService cuss;
	private HttpSession session=null ;
	private Designer_case_colService designer_case_colService;
	private Company_case_colService compnay_case_colService;
	private Designer_colService designer_colService;
	private Company_colService company_colService;
	private Product_colService product_colService;
	private Supply_colService supply_colService;
	public CustomerServlet(){
		cuss = new CustomerServiceImpl();
		designer_case_colService = new Designer_case_colServiceImpl();
		designer_colService = new Designer_colServiceImpl();
		company_colService = new Company_colServiceImpl();
		product_colService = new Product_colServiceImpl();
		supply_colService = new Supply_colServiceImpl();
		compnay_case_colService = new Company_case_colServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mothed = WebUtil.getUriMethod(req);
		if(Mothed.equals("userreg")){
			userreg(req,resp);
		}else if(Mothed.equals("userlogin")){
			userlogin(req,resp);
		}else if(Mothed.equals("delete")){
			delete(req,resp);
		}else if(Mothed.equals("customers")){
			customers(req,resp);
		}else if(Mothed.equals("exit")){
			exit(req,resp);
		}else if(Mothed.equals("center")){
			center(req,resp);
		}else if(Mothed.equals("data")){
			data(req,resp);
		}else if(Mothed.equals("change_password")){
			change_password(req,resp);
		}else if(Mothed.equals("updatechange_password")){
			updatechange_password(req,resp);
		}else if(Mothed.equals("updatedatasucceed")){
			updatedatasucceed(req,resp);
		}else if(Mothed.equals("companycollect")){
			companycollect(req,resp);
		}else if(Mothed.equals("designercasecollect")){
			designercasecollect(req,resp);
		}else if(Mothed.equals("companycasecollect")){
			companycasecollect(req,resp);
		}else if(Mothed.equals("productcollect")){
			productcollect(req,resp);
		}else if(Mothed.equals("designerorder")){
			designerorder(req,resp);
		}else if(Mothed.equals("companyorder")){
			companyorder(req,resp);
		}else if(Mothed.equals("deletedesignercase")){
			deletedesignercase(req,resp);
		}else if(Mothed.equals("designercollect")){
			designercollect(req,resp);
		}else if(Mothed.equals("deletedesignercollect")){
			deletedesignercollect(req,resp);
		}else if(Mothed.equals("deletecompanycollect")){
			deletecompanycollect(req,resp);
		}else if(Mothed.equals("enshrine")){
			enshrine(req,resp);
		}else if(Mothed.equals("supplycollect")){
			supplycollect(req,resp);
		}else if(Mothed.equals("deletesupplycollect")){
			deletesupplycollect(req,resp);
		}else if(Mothed.equals("deletecompnaycase")){
			deletecompnaycase(req,resp);
		}else if(Mothed.equals("log_out_safely")){
			log_out_safely(req,resp);
		}
	}
	/**
	 *业主安全退出
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void log_out_safely(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(session.getAttribute("customer1") !=null){
			session.removeAttribute("customer1");
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}
	/**
	 *业主取消对装修公司案例的收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void deletecompnaycase(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("caseid");
		compnay_case_colService.deleteById(id);
		resp.sendRedirect("companycasecollect");
	}
	/**
	 * 业主取消对建材商的收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void deletesupplycollect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		supply_colService.deleteById(id);
		resp.sendRedirect("supplycollect");
	}
	/**
	 * 后台所有收藏的建材商
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplycollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String customerid = customer.getId();//用户id
		int total = supply_colService.getconn(customerid); // 业主收藏的所有建材商
		int pageSize = 8;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<Supply_colAndsupply> Supply_colAndsupplys = supply_colService.queryByCustomerid(pageNo, pageSize, customerid);
		req.setAttribute("Supply_colAndsupplys", Supply_colAndsupplys);
		req.getRequestDispatcher("/f_user/collectallsupply.jsp").forward(req, resp);
	}
	/**
	 * 业主取消对建材商品的收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void enshrine(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		product_colService.deleteById(id);
		resp.sendRedirect("productcollect");
	}
	/**
	 * 业主删除装修公司
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void deletecompanycollect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		company_colService.deleteById(id);
		resp.sendRedirect("companycollect");
	}
	/**
	 * 业主删除设计师
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void deletedesignercollect(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		designer_colService.deleteById(id);
		resp.sendRedirect("designercollect");
	}
	/**
	 *收藏设计师查看
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designercollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String customerid = customer.getId();
		int total = designer_colService.getconn(customerid); // 所有的学生个数
		int pageSize = 8;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<DesignercaseAndDesigner> DesignercaseAndDesigners = designer_colService.queryByCustomerid(pageNo, pageSize, customerid);
		req.setAttribute("DesignercaseAndDesigners", DesignercaseAndDesigners);
		req.getRequestDispatcher("/f_user/collectalldesigner.jsp").forward(req, resp);
	}
	/**
	 * 业主删除设计师案例
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void deletedesignercase(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String caseid = req.getParameter("caseid");
		designer_case_colService.deleteById(caseid);
		resp.sendRedirect("designercasecollect");
	}
	/**
	 * 装修公司预约
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companyorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/company_subscribe.jsp").forward(req, resp);
	}
	/**
	 * 设计师预约
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerorder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_designer/designer_subscribe.jsp").forward(req, resp);
	}
	/**
	 * 建材商商品收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void productcollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String customer_id = customer.getId();//业主的id
		int total = product_colService.getconn(customer_id);
		int pageSize = 8;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<CustomerAndProductAndProduct_col> CustomerAndProductAndProduct_cols =  product_colService.queryByPager(pageNo, pageSize, customer_id);
		req.setAttribute("CustomerAndProductAndProduct_cols", CustomerAndProductAndProduct_cols);
		req.getRequestDispatcher("/f_Supply/allProduct_col.jsp").forward(req, resp);
	}
	/**
	 *装修公司案例收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companycasecollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String customer_id = customer.getId();//业主的id
		int total = compnay_case_colService.getCount(customer_id); // 所有的学生个数
		int pageSize = 8;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<Compnay_caseAndCustomerAndCompany> Compnay_caseAndCustomerAndCompanys = compnay_case_colService.queryByPager(pageNo, pageSize, customer_id);
		req.setAttribute("Compnay_caseAndCustomerAndCompanys", Compnay_caseAndCustomerAndCompanys);
		req.getRequestDispatcher("/f_company/allcompany_case_col.jsp").forward(req, resp);
	}
	/**
	 * 设计师案例收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designercasecollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String customer_id = customer.getId();//业主的id
		int total = designer_case_colService.getCount(customer_id); // 所有的学生个数
		int pageSize = 8;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<CustomerAndDesignerAndDesigner_case> CustomerAndDesignerAndDesigner_cases = designer_case_colService.queryByPager(pageNo, pageSize, customer_id);
		req.setAttribute("CustomerAndDesignerAndDesigner_cases", CustomerAndDesignerAndDesigner_cases);
		req.getRequestDispatcher("/f_designer/alldesigner_case_col.jsp").forward(req, resp);
	}
	
	/**
	 * 装修公司收藏界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companycollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String customerid = customer.getId();//用户id
		int total = company_colService.getconn(customerid); // 业主收藏的所有装修公司
		int pageSize = 8;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<Company_colAndCompany> Companys = company_colService.queryByCustomerid(pageNo, pageSize, customerid);
		req.setAttribute("Companys", Companys);
		req.getRequestDispatcher("/f_user/collectallcompany.jsp").forward(req, resp);
	}
	
	/**
	 * 资料修改成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void updatedatasucceed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String phone = req.getParameter("phone");
		String name = req.getParameter("name");
		String plot_name = req.getParameter("plot_name");
		String address = req.getParameter("address");
		session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		Customer customer1 = new Customer();
		customer1.setId(customer.getId());
		customer1.setPhone(phone);
		customer1.setName(name);
		customer1.setPlot_name(plot_name);
		customer1.setAddress(address);
		customer1.setEmail(customer.getEmail());
		customer1.setCreated_time(customer.getCreated_time());
		customer1.setLast_login_time(customer.getLast_login_time());
		cuss.update(customer1);
		session.setAttribute("customer1", customer1);
		resp.sendRedirect("data");
	}
	/**
	 *修改密码成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void updatechange_password(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		String pwd = customer.getPassword();
		String id=customer.getId();
		String pwd1 = req.getParameter("pwd1");//旧密码
		String pwd2 = req.getParameter("pwd2");//新密码
		String repassword = req.getParameter("repassword");//重复密码
		PrintWriter out = resp.getWriter();
		if(pwd1!=null && !pwd1.trim().equals("") && !pwd.equals(Encrypt.encrypt(pwd1))){
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"nopwd\"}");
			return;
		}
		if(pwd1!=null && !pwd.equals("") && pwd2!=null && !pwd2.equals("") && repassword!=null && !repassword.equals("")){
			if(pwd2.length()<6){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"pwdlength\"}");
				return;
			}
			if(!pwd2.equals(repassword)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"no\"}");
				return;
			}
				cuss.updatepwd(id,Encrypt.encrypt(pwd2));
				out.write("{\"info\":\"succeed\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
			return;
		}
	}
	/**
	 * 修改密码界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void change_password(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_user/change_password.jsp").forward(req, resp);
	}
	/**
	 * 个人基本信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void data(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer1 = (Customer)object;
		String id = customer1.getId();
		Customer customer = cuss.queryById(id);
		req.setAttribute("customer", customer);
		req.getRequestDispatcher("/f_user/customerdata.jsp").forward(req, resp);
	}
	/**
	 * 个人中心
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void center(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_user/personal_center.jsp").forward(req, resp);
	}
	/**
	 * 重定向主页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(session.getAttribute("customer1")!=null){
			session.removeAttribute("customer1");
			resp.sendRedirect(req.getContextPath());
		}else {
			resp.sendRedirect(req.getContextPath());
		}
	}
	/**
	 * 分页查询用户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void customers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = cuss.count(); // 所有的学生个数
		int pageSize = 10;//每页显示个数
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1;//总页数
		int pageNo = 1;//初始第一页
		String pageNoStr = req.getParameter("pageNo"); // 从页面传递过来的页码
		if (pageNoStr != null) {
			try {
				pageNo = Integer.valueOf(pageNoStr); // 把页面传递过来的页码转成数字，如果转换失败，则使用默认的页码 1
				if (pageNo <= 0) {//如果页码是负数 则页码等于第一页
					pageNo = 1;
				} else if (pageNo > totalPage) {//如果页码大于总页数 则页码等于总页数
					pageNo = totalPage;
				}
			} catch (NumberFormatException e) {
				
			}
		}
		List<Customer> customers = cuss.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
		req.setAttribute("customers", customers);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/f_user/customers.jsp").forward(req, resp);//转发到分页查询界面
	}
	/**
	 * 删除用户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		cuss.deleteById(id);
		resp.sendRedirect("customersy");
	}
	/**
	 * 登录验证
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	@SuppressWarnings("unused")
	private void userlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		Customer customer = cuss.queryByemail(email);
		PrintWriter out = resp.getWriter();
		Customer customer1 ;
		if(email!=null && !email.trim().equals("")
				&&pwd!=null && !pwd.trim().equals("")){
			if(customer==null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"email\"}");
				return;
			}
			if(!email.matches(Constants.EMAIL_CONTENT_TYPE)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"email1\"}");
				return;
			}
			customer1= cuss.queryByNoPwd(email, Encrypt.encrypt(pwd));
			if(customer1==null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"pwd\"}");
				return;
			}
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
			return;
		}
		if(customer.getStatus().equals("Y")){
			cuss.updatelast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"), customer.getId());
			session= req.getSession();
			Object sessioncompany = session.getAttribute("company1");
			Object sessiondesigner = session.getAttribute("designer1");
			Object sessioncustomer = session.getAttribute("customer1");
			Object sessionsupply = session.getAttribute("supply1");
			if(sessioncompany!=null){
				session.removeAttribute("company1");
			}
			if(sessiondesigner!=null){
				session.removeAttribute("designer1");
			}
			if(sessioncustomer!=null){
				session.removeAttribute("customer1");
			}
			if(sessionsupply!=null){
				session.removeAttribute("supply1");
			}
			session.setAttribute("customer1", customer1);
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"nase\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"forbidden\"}");
			return;
		}
		
	}
	/**
	 * 添加业主
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void userreg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		PrintWriter out = resp.getWriter();
		//后台验证开始
		Customer customer1 = cuss.queryByemail(email);
		if(customer1!=null){
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"7\"}");
			return;
		}
		if(email!=null && !email.trim().equals("")
				&&pwd1!=null && !pwd1.trim().equals("") 
				&&pwd2!=null && !pwd2.trim().equals("")
				&&name!=null && !name.trim().equals("")
				&&phone!=null && !phone.trim().equals("")
				){
			if(!email.matches(Constants.EMAIL_CONTENT_TYPE)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"1\"}");
				return;
			}

			if(pwd1.length()<6){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"2\"}");
				return;
			}
			if(!pwd1.equals(pwd2)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"3\"}");
				return;
			}
			if(!phone.matches(Constants.PHONE_CONTENT_TYPE)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"4\"}");
				return;
			}
			Customer customer = new Customer();
			customer.setEmail(email);
			customer.setPassword(Encrypt.encrypt(pwd1));
			customer.setName(name);
			customer.setPhone(phone);
			customer.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			customer.setStatus("Y");
			cuss.add(customer);
			out.write("{\"info\":\"6\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"5\"}");
		}
	}
}
