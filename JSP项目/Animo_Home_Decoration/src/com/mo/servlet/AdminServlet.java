package com.mo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.digester.ObjectCreateRule;

import com.mo.bean.Admin;
import com.mo.bean.Company;
import com.mo.bean.Customer;
import com.mo.bean.Designer;
import com.mo.bean.Supply;
import com.mo.common.Constants;
import com.mo.common.DataTime;
import com.mo.common.DateUtil;
import com.mo.common.Encrypt;
import com.mo.common.WebUtil;
import com.mo.service.AdminService;
import com.mo.service.CompanyService;
import com.mo.service.CustomerService;
import com.mo.service.DesignerService;
import com.mo.service.SupplyService;
import com.mo.serviceimpl.AdminServiceImpl;
import com.mo.serviceimpl.CompanyServiceImpl;
import com.mo.serviceimpl.CustomerServiceImpl;
import com.mo.serviceimpl.DesignerServiceImpl;
import com.mo.serviceimpl.SupplyServiceImpl;

public class AdminServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3588548033842559801L;
	
	private AdminService adminService;
	private DesignerService designerService;
	private CustomerService customerService;
	private SupplyService supplyService;
	private CompanyService companyService;
	
	public AdminServlet(){
		adminService = new AdminServiceImpl();
		designerService = new DesignerServiceImpl();
		customerService = new CustomerServiceImpl();
		supplyService = new SupplyServiceImpl();
		companyService = new CompanyServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mothed = WebUtil.getUriMethod(req);
		if(Mothed.equals("admin")){
			admin(req,resp);
		}else if(Mothed.equals("logoadmin")){
			logoadmin(req,resp);
		}else if(Mothed.equals("data")){
			data(req,resp);
		}else if(Mothed.equals("addinterface")){
			addinterface(req,resp);
		}else if(Mothed.equals("add")){
			add(req,resp);
		}else if(Mothed.equals("updatedata")){
			updatedata(req,resp);
		}else if(Mothed.equals("update")){
			update(req,resp);
		}else if(Mothed.equals("alladmin")){
			alladmin(req,resp);
		}else if(Mothed.equals("role")){
			role(req,resp);
		}else if(Mothed.equals("roles")){
			roles(req,resp);
		}else if(Mothed.equals("delete")){
			delete(req,resp);
		}else if(Mothed.equals("allcheckdesigner")){
			allcheckdesigner(req,resp);
		}else if(Mothed.equals("desigener")){
			desigener(req,resp);
		}else if(Mothed.equals("desigeners")){
			desigeners(req,resp);
		}else if(Mothed.equals("updatedatasucceed")){
			updatedatasucceed(req,resp);
		}else if(Mothed.equals("checkcompany")){
			checkcompany(req,resp);
		}else if(Mothed.equals("companys")){
			companys(req,resp);
		}else if(Mothed.equals("checksupply")){
			checksupply(req,resp);
		}else if(Mothed.equals("supplys")){
			supplys(req,resp);
		}else if(Mothed.equals("customers")){
			customers(req,resp);
		}else if(Mothed.equals("companyagree")){
			companyagree(req,resp);
		}else if(Mothed.equals("supply")){
			supply(req,resp);
		}else if(Mothed.equals("To_make_an_appointment_the_user")){
			To_make_an_appointment_the_user(req,resp);
		}else if(Mothed.equals("companyavailable")){
			companyavailable(req,resp);
		}else if(Mothed.equals("companyforbidden")){
			companyforbidden(req,resp);
		}else if(Mothed.equals("companydelete")){
			companydelete(req,resp);
		}else if(Mothed.equals("companydetails")){
			companydetails(req,resp);
		}else if(Mothed.equals("companydecline")){
			companydecline(req,resp);
		}else if(Mothed.equals("designeravailable")){
			designeravailable(req,resp);
		}else if(Mothed.equals("designerforbidden")){
			designerforbidden(req,resp);
		}else if(Mothed.equals("designerdelete")){
			designerdelete(req,resp);
		}else if(Mothed.equals("designerdetails")){
			designerdetails(req,resp);
		}else if(Mothed.equals("designeragree")){
			designeragree(req,resp);
		}else if(Mothed.equals("designerdecline")){
			designerdecline(req,resp);
		}else if(Mothed.equals("supplyagree")){
			supplyagree(req,resp);
		}else if(Mothed.equals("supplydecline")){
			supplydecline(req,resp);
		}else if(Mothed.equals("supplydetails")){
			supplydetails(req,resp);
		}else if(Mothed.equals("supplyavailable")){
			supplyavailable(req,resp);
		}else if(Mothed.equals("supplyforbidden")){
			supplyforbidden(req,resp);
		}else if(Mothed.equals("customerdetails")){
			customerdetails(req,resp);
		}else if(Mothed.equals("customeravailable")){
			customeravailable(req,resp);
		}else if(Mothed.equals("customerforbidden")){
			customerforbidden(req,resp);
		}else if(Mothed.equals("overall")){
			overall(req,resp);
		}else if(Mothed.equals("log_out_safely")){
			log_out_safely(req,resp);
		}
	}
	private void log_out_safely(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		session.removeAttribute("admin");
		resp.sendRedirect("logoadmin");
		Cookie cook = new Cookie("a", "10");
		
	}

	/**
	 * 个人中心
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void overall(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		HttpSession session = req.getSession();
		Object company1 = session.getAttribute("company1");
		Object supply1 = session.getAttribute("supply1");
		Object designer1 = session.getAttribute("designer1");
		Object customer1 = session.getAttribute("customer1");
		if(company1==null && supply1==null && designer1==null && customer1==null){
			resp.sendRedirect(req.getContextPath()+"/home");
		}
		if(company1!=null){
			req.getRequestDispatcher("/background/superadmin.jsp").forward(req, resp);
		}
		if(supply1!=null){
			req.getRequestDispatcher("/background/superadmin.jsp").forward(req, resp);
		}
		if(designer1!=null){
			req.getRequestDispatcher("/background/superadmin.jsp").forward(req, resp);
		}
		if(customer1!=null){
			req.getRequestDispatcher("/background/superadmin.jsp").forward(req, resp);
		}
	}

	/**
	 * 用户禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void customerforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		customerService.updatestatus(status, id);
		resp.sendRedirect("customers");
	}
	/**
	 * 用户可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void customeravailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		customerService.updatestatus(status, id);
		resp.sendRedirect("customers");
	}
	/**
	 * 用户详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void customerdetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Customer cus = customerService.queryById(id);
		req.setAttribute("cus", cus);
		req.getRequestDispatcher("/f_user/customerDetails.jsp").forward(req, resp);
	}

	/**
	 * 建材商可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void supplyavailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		String checked = "Y";
		supplyService.updatestatus(status, checked, id);
		resp.sendRedirect("supplys");
	}

	/**
	 * 建材商禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void supplyforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		String checked = "N";
		supplyService.updatestatus(status, checked, id);
		resp.sendRedirect("supplys");
	}

	/**
	 * 建材商详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplydetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply supply = supplyService.queryById(id);
		req.setAttribute("supply", supply);
		req.getRequestDispatcher("/f_Supply/supplyDetails.jsp").forward(req, resp);
	}

	/**
	 * 建材商拒绝
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void supplydecline(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		String checked = "N";
		supplyService.updatestatus(status, checked, id);
		resp.sendRedirect("checksupply");
	}
	/**
	 * 建材商同意
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void supplyagree(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		String checked = "Y";
		supplyService.updatestatus(status, checked, id);
		resp.sendRedirect("checksupply");
	}

	/**
	 * 设计师拒绝
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void designerdecline(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		String checked = "N";
		designerService.updaterole(status, checked, id);
		resp.sendRedirect("allcheckdesigner");
	}

	/**
	 * 设计师同意
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void designeragree(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		String checked = "Y";
		designerService.updaterole(status, checked, id);
		resp.sendRedirect("allcheckdesigner");
	}

	/**
	 * 设计师详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerdetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Designer desingenr = designerService.queryById(id);
		req.setAttribute("desingenr", desingenr);
		req.getRequestDispatcher("/f_designer/designerDetails.jsp").forward(req, resp);
	}
	/**
	 * 设计师删除
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void designerdelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		designerService.deleteById(id);
		resp.sendRedirect("designers");
	}
	/**
	 * 设计师可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void designerforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		String checked = "Y";
		designerService.updaterole(status, checked, id);
		resp.sendRedirect("designers");
	}
	/**
	 * 设计师禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void designeravailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		String checked = "N";
		designerService.updaterole(status, checked, id);
		resp.sendRedirect("designers");
	}

	/**
	 * 装修公司拒绝按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void companydecline(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		String checked = "N";
		companyService.updatestatus(status, checked, id);
		resp.sendRedirect("checkcompany");
	}

	/**
	 * 装修公司详情按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companydetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company com = companyService.queryById(id);
		req.setAttribute("com", com);
		req.getRequestDispatcher("/f_company/companyDetails.jsp").forward(req, resp);
	}

	/**
	 * 装修公司删除按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void companydelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		companyService.deleteById(id);
		resp.sendRedirect("companys");
	}

	/**
	 * 装修公司禁用按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void companyforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		 String id = req.getParameter("id");
		 String status = "N";
		 String checked = "N";
		companyService.updatestatus(status, checked, id);
		resp.sendRedirect("companys");
	}

	/**
	 * 装修公司可用按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void companyavailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		String checked = "Y";
		companyService.updatestatus(status, checked, id);
		resp.sendRedirect("companys");
	}

	/**
	 * 所有业主预约查看
	 * @param req
	 * @param resp
	 */
	private void To_make_an_appointment_the_user(HttpServletRequest req, HttpServletResponse resp) {
		// TODO Auto-generated method stub
		
	}
	/**
	 *建材商审核按钮
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void supply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String status = "Y";
		String checked="Y";
		supplyService.updatestatus(status,checked, id);
		supplyService.updatechecked_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"), id);
		resp.sendRedirect("checksupply");
	}

	/**
	 * 所有用户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void customers(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = customerService.count(); // 所有的学生个数
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
			List<Customer> customers = customerService.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("customers", customers);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_user/customers.jsp").forward(req, resp);
	}

	/**
	 * 所有已审核的建材商
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supplyService.count(); //所有的建材商
		int pageSize = 10; //每页显示10个建材商
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1; //显示总页数
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); //从页面传替过来的页面数
		if(pageNoStr != null) {
			try{
				pageNo = Integer.valueOf(pageNoStr);
				if(pageNo <= 0) {
					pageNo = 1;
				}else if(pageNo > totalPage) {
					pageNo = totalPage;
				}
			}catch(NumberFormatException e) {
				
			}
		}
		List<Supply> supply = supplyService.queryByPager1(pageNo, pageSize);
		req.setAttribute("supply", supply);
		req.setAttribute("totaPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.setAttribute("total", total);
		req.getRequestDispatcher("/f_Supply/supplys.jsp").forward(req, resp);
	}

	/**
	 * 所有审核的建材商
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void checksupply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supplyService.count(); //所有的建材商
		int pageSize = 10; //每页显示10个建材商
		int totalPage = total % pageSize == 0 ? total / pageSize : total / pageSize + 1; //显示总页数
		int pageNo = 1;
		String pageNoStr = req.getParameter("pageNo"); //从页面传替过来的页面数
		if(pageNoStr != null) {
			try{
				pageNo = Integer.valueOf(pageNoStr);
				if(pageNo <= 0) {
					pageNo = 1;
				}else if(pageNo > totalPage) {
					pageNo = totalPage;
				}
			}catch(NumberFormatException e) {
				
			}
		}
		List<Supply> supply = supplyService.queryByPager(pageNo, pageSize);
		req.setAttribute("supply", supply);
		req.setAttribute("totaPage", totalPage);
		req.setAttribute("currPage", pageNo);
		req.setAttribute("total", total);
		req.getRequestDispatcher("/f_Supply/checksupply.jsp").forward(req, resp);

	}

	/**
	 * 所有已审核的装修公司
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = companyService.count(); // 所有的学生个数
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
			List<Company> companys = companyService.queryByPager1(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("companys", companys);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/f_company/companys.jsp").forward(req, resp);
	}

	/**
	 * 所有审核装修公司
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void checkcompany(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = companyService.count(); // 所有的学生个数
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
		List<Company> companys = companyService.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
		req.setAttribute("companys", companys);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.setAttribute("total", total);
		req.getRequestDispatcher("/f_company/checkcompany.jsp").forward(req, resp);
	}

	/**
	 * 修改资料成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void updatedatasucceed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		Admin admin1 = new Admin();
		HttpSession session = req.getSession();
		Object object = session.getAttribute("admin");
		Admin admin = (Admin)object;
		admin1.setId(admin.getId());
		admin1.setName(name);
		admin1.setPhone(phone);
		adminService.update(admin1);
		session.setAttribute("admin", admin1);
		resp.sendRedirect("data");
	}
	
	/**
	 * 查询所有已通过的设计师
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void desigeners(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = designerService.count(); // 所有的学生个数
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
			List<Designer> designers = designerService.queryByPager1(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("designers", designers);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_designer/designers.jsp").forward(req, resp);//转发到分页查询界面
	}

	/**
	 * 审核通过
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void desigener(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status="Y";
		String checked = "Y";
		designerService.updaterole(status,checked,id);
		designerService.update(id,DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
		resp.sendRedirect("allcheckdesigner");
	}

	/**
	 * 审核所有设计师
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void allcheckdesigner(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = designerService.count(); // 所有的学生个数
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
		List<Designer> designers = designerService.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
		req.setAttribute("designers", designers);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.setAttribute("total", total);
		req.getRequestDispatcher("/f_designer/checkdesigner.jsp").forward(req, resp);//转发到分页查询界面
	}
	
	/**
	 *删除管理员 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void delete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		adminService.deleteById(id);
		resp.sendRedirect("alladmin");
	}

	/**
	 * 可用状态
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void roles(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status="Y";
		adminService.updaterole(id, status);
		resp.sendRedirect("alladmin");
	}

	/**
	 * 禁用状态
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void role(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status="N";
		adminService.updaterole(id, status);
		resp.sendRedirect("alladmin");
	}

	/**
	 * 查看所有管理员
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void alladmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = adminService.count(); // 所有的学生个数
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
		List<Admin> admins = adminService.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
		req.setAttribute("admins", admins);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/background/admins.jsp").forward(req, resp);//转发到分页查询界面
	}

	/**
	 * 修改密码
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void update(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("admin");
		Admin admin = (Admin)object;
		String pwd = admin.getPassword();
		String id=admin.getId();
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
				adminService.updatepwd(Encrypt.encrypt(pwd2), id);
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
	private void updatedata(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/background/updatedata.jsp").forward(req, resp);
	}

	/**
	 * 添加管理员界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void addinterface(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/background/addadmin.jsp").forward(req, resp);
	}

	/**
	 * 添加管理员
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		PrintWriter out = resp.getWriter();
		Admin emailadmin = adminService.queryByemail(email);
		if(emailadmin!=null){
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"email\"}");
		}
		if(email!=null && !email.trim().equals("")
				&&pwd1!=null && !pwd1.trim().equals("")
				&&pwd2!=null && !pwd2.trim().equals("")
				&&name!=null && !name.trim().equals("")
				&&phone!=null && !phone.trim().equals("")){
			if(pwd1.equals(pwd2)){
				Admin admin = new Admin();
				admin.setEmail(email);
				admin.setPassword(Encrypt.encrypt(pwd1));
				admin.setName(name);
				admin.setPhone(phone);
				admin.setRole("管理员");
				admin.setStatus("Y");
				admin.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
				adminService.add(admin);
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"succeed\"}");
			}
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
		}
	}
	/**
	 * 审核装修公司的按钮
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException
	 */
	private void companyagree(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
		String id = req.getParameter("id");
		String status="Y";
		String checked="Y";
		companyService.updatestatus(status,checked,id);
		companyService.updatechecked_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"),id);
		resp.sendRedirect("checkcompany");
	}
	/**
	 * 查看个人信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void data(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("admin");
		Admin admin = (Admin)object;
		String id = admin.getId();
		Admin admin1 = adminService.queryById(id);
		req.setAttribute("admindata", admin1);
		req.getRequestDispatcher("/background/admindata.jsp").forward(req, resp);
	}

	private void logoadmin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/background/adminlogin.jsp").forward(req, resp);
	}

	/**
	 * 管理员登录判断
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void admin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("pwd");
		HttpSession session=null;
		if(email!=null && !email.trim().equals("") && pwd!=null && !pwd.trim().equals("")){
			Admin admin= adminService.queryByNoPwd(email,Encrypt.encrypt(pwd));
				if(admin!=null){
					String status = admin.getStatus();
					if(status.equals("Y")){
						session= req.getSession();
						adminService.updatelast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"), admin.getId());
						session.setAttribute("admin", admin);
						int desint = designerService.count();
						int cusint = customerService.count();
						int supint = supplyService.count();
						int comint = companyService.count();
						session.setAttribute("desint", desint);
						session.setAttribute("cusint", cusint);
						session.setAttribute("supint", supint);
						session.setAttribute("comint", comint);
						req.getRequestDispatcher("/background/superadmin.jsp").forward(req, resp);
					}else if(status.equals("N")){
						System.out.println("管理员已被禁用");
					}
				}else{
					resp.sendRedirect("logoadmin");
				}
		}else {
			resp.sendRedirect("logoadmin");
		}
	}
}
