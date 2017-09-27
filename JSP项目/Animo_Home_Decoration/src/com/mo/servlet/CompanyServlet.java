package com.mo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.mo.bean.Company;
import com.mo.bean.Company_activity;
import com.mo.bean.Company_case;
import com.mo.bean.Company_case_col;
import com.mo.bean.Company_col;
import com.mo.bean.CompanycaseAndCompany;
import com.mo.bean.Customer;
import com.mo.common.Constants;
import com.mo.common.DataTime;
import com.mo.common.DateUtil;
import com.mo.common.Encrypt;
import com.mo.common.FileInput;
import com.mo.common.WebUtil;
import com.mo.service.CompanyService;
import com.mo.service.Company_activityService;
import com.mo.service.Company_caseService;
import com.mo.service.Company_case_colService;
import com.mo.service.Company_colService;
import com.mo.serviceimpl.CompanyServiceImpl;
import com.mo.serviceimpl.Company_activityServiceImpl;
import com.mo.serviceimpl.Company_caseServiceImpl;
import com.mo.serviceimpl.Company_case_colServiceImpl;
import com.mo.serviceimpl.Company_colServiceImpl;

public class CompanyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6801129484030994123L;
	private CompanyService companyService;
	private HttpSession session=null;
	private Company_caseService company_caseService;
	private Company_activityService company_activityService;
	private Company_colService company_colService;
	private Company_case_colService company_case_colService;
	public CompanyServlet(){
		companyService = new CompanyServiceImpl();
		company_caseService = new Company_caseServiceImpl();
		company_activityService = new Company_activityServiceImpl();
		company_colService = new Company_colServiceImpl();
		company_case_colService = new Company_case_colServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mothed =  WebUtil.getUriMethod(req);
		if(Mothed.equals("regverify")){
			regverify(req,resp);
		}else if(Mothed.equals("loginverify")){
			loginverify(req,resp);
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
		}else if(Mothed.equals("Case_to_upload")){
			Case_to_upload(req,resp);
		}else if(Mothed.equals("Add_the_ase")){
			Add_the_ase(req,resp);
		}else if(Mothed.equals("show_cases")){
			show_cases(req,resp);
		}else if(Mothed.equals("Upload_the_activity")){
			Upload_the_activity(req,resp);
		}else if(Mothed.equals("add_activities")){
			add_activities(req,resp);
		}else if(Mothed.equals("make_an_appointment")){
			make_an_appointment(req,resp);
		}else if(Mothed.equals("companydetails")){
			companydetails(req,resp);
		}else if(Mothed.equals("companyrecompose")){
			companyrecompose(req,resp);
		}else if(Mothed.equals("companymodifySituation")){
			companymodifySituation(req,resp);
		}else if(Mothed.equals("companyforbidden")){
			companyforbidden(req,resp);
		}else if(Mothed.equals("companyavailable")){
			companyavailable(req,resp);
		}else if(Mothed.equals("activityinterface")){
			activityinterface(req,resp);
		}else if(Mothed.equals("activitydetails")){
			activitydetails(req,resp);
		}else if(Mothed.equals("activitymodifySituation")){
			activitymodifySituation(req,resp);
		}else if(Mothed.equals("activityforbidden")){
			activityforbidden(req,resp);
		}else if(Mothed.equals("activityavailable")){
			activityavailable(req,resp);
		}else if(Mothed.equals("activrecompose")){
			activrecompose(req,resp);
		}else if(Mothed.equals("allcompanycase")){
			allcompanycase(req,resp);
		}else if(Mothed.equals("decoration_company")){
			decoration_company(req,resp);
		}else if(Mothed.equals("homeallcompanys")){
			homeallcompanys(req,resp);
		}else if(Mothed.equals("companycollect")){
			companycollect(req,resp);
		}else if(Mothed.equals("userconsult")){
			userconsult(req,resp);
		}else if(Mothed.equals("companyActivity")){
			companyActivity(req,resp);
		}else if(Mothed.equals("pastcompanyActivity")){
			pastcompanyActivity(req,resp);
		}else if(Mothed.equals("homeallcompanycases")){
			homeallcompanycases(req,resp);
		}else if(Mothed.equals("enshrine")){
			enshrine(req,resp);
		}else if(Mothed.equals("log_out_safely")){
			log_out_safely(req,resp);
		}else if(Mothed.equals("homecasedetails")){
			homecasedetails(req,resp);
		}else if(Mothed.equals("detail_of_the_activity")){
			detail_of_the_activity(req,resp);
		}else if(Mothed.equals("pastCompany_activity")){
			pastCompany_activity(req,resp);
		}
	}
	
	private void pastCompany_activity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id  = req.getParameter("id");//活动id
		Company_activity company_activity = company_activityService.queryById(id);
		req.setAttribute("company_activity", company_activity);
		req.getRequestDispatcher("/sundry/pastcompany.jsp").forward(req, resp);
	}
	/**
	 * 装修公司活动详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void detail_of_the_activity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id  = req.getParameter("id");//活动id
		Company_activity company_activity = company_activityService.queryById(id);
		req.setAttribute("company_activity", company_activity);
		req.getRequestDispatcher("/sundry/detail_of_the_activity.jsp").forward(req, resp);
	}
	/**
	 * 装修公司案例
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homecasedetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");//装修公司案例id
		Company_case company_case = company_caseService.queryById(id);
		String company_id = company_case.getCompany_id();//装修公司id
		CompanycaseAndCompany companycaseAndCompany = companyService.queryByCompany_idAndCase_id(id, company_id);
		req.setAttribute("companycaseAndCompany", companycaseAndCompany);
		req.getRequestDispatcher("/f_company/companycasedetails.jsp").forward(req, resp);
	}
	/**
	 * 装修公司个人中心退出
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void log_out_safely(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		if(session.getAttribute("company1")!=null){
			session.removeAttribute("company1");
			req.getRequestDispatcher("/f_company/companylogin.jsp").forward(req, resp);
		}
	}
	/**
	 *装修公司案例收藏
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void enshrine(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		if(customer!=null){
			String caseid = req.getParameter("caseid");//装修公司id
			String customerid = customer.getId();//用户id
			Company_case_col company_case_col = company_case_colService.queryById(customerid,caseid);
			if(company_case_col!=null){
				System.out.println("不能重复收藏");
				return;
			}
			Company_case_col companycasecol = new Company_case_col();
			companycasecol.setCustomer_id(customerid);
			companycasecol.setCase_id(caseid);
			companycasecol.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			company_case_colService.add(companycasecol);
			resp.sendRedirect("homeallcompanycases");
		}else {
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}
	/**
	 * 主页装修公司所有案例
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homeallcompanycases(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = company_caseService.count(); // 所有建材商品
		int pageSize = 20;//每页显示个数
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
			List<CompanycaseAndCompany> CompanycaseAndCompanys = company_caseService.queryByPagercase(pageNo,pageSize);
			req.setAttribute("CompanycaseAndCompanys", CompanycaseAndCompanys);//查询所有设计师案例
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_company/allcompanycase.jsp").forward(req, resp);
	}
	/**
	 * 主页装修公司往期活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void pastcompanyActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = company_activityService.count(); // 所有的活动个数
		int pageSize = 5;//每页显示个数
		int totalPage = (total % pageSize == 0 )? (total / pageSize ):( total / pageSize + 1);//总页数
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
		List<Company_activity> companyactivity = company_activityService.pastqueryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
		req.setAttribute("companyactivity", companyactivity);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/sundry/pastCompany_activity.jsp").forward(req, resp);
	}
	/**
	 * 主页所有装修公司活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companyActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = company_activityService.count(); // 所有的活动个数
		int pageSize = 5;//每页显示个数
		int totalPage = (total % pageSize == 0 )? (total / pageSize ):( total / pageSize + 1);//总页数
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
		List<Company_activity> companyactivity = company_activityService.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
		req.setAttribute("companyactivity", companyactivity);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/sundry/Company_activity.jsp").forward(req, resp);
	}
	/**
	 *用户咨询
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void userconsult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		req.setAttribute("id", id);
		req.getRequestDispatcher("/sundry/The_user_consulting.jsp").forward(req, resp);
	}
	/**
	 * 主页装修公司收藏按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companycollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println(1);
		HttpSession session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		PrintWriter out = resp.getWriter();
		if(customer!=null){
			String companyid = req.getParameter("id");//装修公司id
			String customerid = customer.getId();//用户id
			Company_col company = company_colService.queryBycustomerIdBycompanyId(customerid, companyid);
			if(company!=null){
				System.out.println("不能重复收藏");
				return;
			}
			Company_col compan_col = new Company_col();
			compan_col.setCustomer_id(customerid);
			compan_col.setCompany_id(companyid);
			compan_col.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			company_colService.add(compan_col);
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"succeed\"}");
			resp.sendRedirect("homeallcompanys");
		}else {
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}
	/**
	 * 主页所有装修公司
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homeallcompanys(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = companyService.count(); // 所有装修公司
		int pageSize = 20;//每页显示个数
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
		List<Company> companys = companyService.queryByPager1(pageNo, pageSize);
		req.setAttribute("companys", companys);
		req.getRequestDispatcher("/f_company/homeallcompanys.jsp").forward(req, resp);
	}
	/**
	 * 装修公司主页个人中心
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void decoration_company(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");//装修公司id
		int count = company_caseService.queryCount(id);
		int pageSize = 5;//每页显示个数
		int totalPage = count % pageSize == 0 ? count / pageSize : count / pageSize + 1;//总页数
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
		Company company = companyService.queryById(id);
		List<Company_case> company_cases = company_caseService.queryByPager(pageNo, pageSize, id);
		List<Company> topcompany =  companyService.top3all();
		req.setAttribute("topcompany", topcompany);
		req.setAttribute("company", company);//把装修公司资料传入主页
		req.setAttribute("company_cases", company_cases);
		req.setAttribute("count", count);
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/f_company/Home_page_designer_for_details.jsp").forward(req, resp);
	}
	/**
	 * 主页所有装修公司案例显示
	 * @param req
	 * @param resp
	 */
	private void allcompanycase(HttpServletRequest req, HttpServletResponse resp) {
		
	}
	/**
	 * 装修公司活动修改成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void activrecompose(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Company_activity companyactivity=null;
		if(ServletFileUpload.isMultipartContent(req)){
			DiskFileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory); 
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(req);
				for(FileItem item : items){
					if(item.isFormField()){
						String name = item.getFieldName();
						if(name.equals("id")){
							companyactivity=company_activityService.queryById(item.getString("utf-8"));
							companyactivity.setCompany_id(item.getString("utf-8"));
						}
				}
				for(FileItem item2 : items){
					String name = item2.getFieldName();
					if(item.isFormField()){
						if(name.equals("name")){
							companyactivity.setName(item2.getString("utf-8"));
						}else if(name.equals("des")){
							companyactivity.setDes(item2.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companyactivity.setImage("images/"+item.getName());
								}
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		company_activityService.update(companyactivity);
		resp.sendRedirect("activityinterface");
	}
	/**
	 * 装修公司活动可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void activityavailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		company_activityService.updateStatus(id, status);
		resp.sendRedirect("activityinterface");
	}
	/**
	 * 装修公司活动禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void activityforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		company_activityService.updateStatus(id, status);
		resp.sendRedirect("activityinterface");
	}
	/**
	 * 装修公司活动修改界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void activitymodifySituation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Company_activity companyactivity = company_activityService.queryById(id);
		req.setAttribute("companyactivity", companyactivity);
		req.getRequestDispatcher("/f_company/companyactivity.jsp").forward(req, resp);
	}
	/**
	 * 装修公司活动详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void activitydetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		Company_activity companyactivity = company_activityService.queryById(id);
		if(companyactivity.getImage()==null){
			companyactivity.setImage("images/default.png");
		}
		req.setAttribute("companyactivity", companyactivity);
		req.getRequestDispatcher("/f_company/companyselectactivity.jsp").forward(req, resp);
	}
	/**
	 * 装修公司所有活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void activityinterface(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = company_activityService.count(); // 所有的学生个数
		int pageSize = 5;//每页显示个数
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
			session = req.getSession();
			Object object = session.getAttribute("company1");
			Company com = (Company)object;
			String id = com.getId();
			List<Company_activity> companyactivity = company_activityService.queryByPager(pageNo, pageSize,id); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("companyactivity", companyactivity);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_company/show_activity.jsp").forward(req, resp);
	}
	/**
	 * 装修公司案例可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void companyavailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		company_caseService.updateStatus(id, status);
		resp.sendRedirect("show_cases");
	}
	/**
	 * 装修公司案例禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void companyforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		company_caseService.updateStatus(id, status);
		resp.sendRedirect("show_cases");
	}
	/**
	 * 装修公司案例修改详情页
	 * @param req
	 * @param resp
	 * @throws ServletException
	 * @throws IOException
	 */
	private void companymodifySituation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseid = req.getParameter("id");
		Company_case companycase = company_caseService.queryById(caseid);
		req.setAttribute("companycase", companycase);
		req.getRequestDispatcher("/f_company/companyrecompose.jsp").forward(req, resp);
	}
	/**
	 * 装修公司案例修改
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companyrecompose(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Company_case companycaseid=null;
		if(ServletFileUpload.isMultipartContent(req)){
			DiskFileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory); 
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(req);
				for(FileItem item : items){
					if(item.isFormField()){
						String name = item.getFieldName();
						if(name.equals("id")){
							companycaseid=company_caseService.queryById(item.getString("utf-8"));
							companycaseid.setCompany_id(item.getString("utf-8"));
							
						}
				}
				for(FileItem item2 : items){
					String name = item2.getFieldName();
					if(item.isFormField()){
						if(name.equals("name")){
							companycaseid.setName(item2.getString("utf-8"));
						}else if(name.equals("plot_name")){
							companycaseid.setPlot_name(item2.getString("utf-8"));
						}else if(name.equals("style1")){
							companycaseid.setStyle(item2.getString("utf-8"));
						}else if(name.equals("des")){
							companycaseid.setDes(item2.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycaseid.setImage_1("images/"+item.getName());
								}
							}if(name1.equals("photo2")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycaseid.setImage_2("images/"+item.getName());
								}
							}if(name1.equals("photo3")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycaseid.setImage_3("images/"+item.getName());
								}
							}if(name1.equals("photo4")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycaseid.setImage_4("images/"+item.getName());
								}
							}if(name1.equals("photo5")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycaseid.setImgae_5("images/"+item.getName());
								}
							}
						}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		company_caseService.update(companycaseid);
		resp.sendRedirect("show_cases");
	}
	/**
	 * 案例详情查看
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void companydetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseid = req.getParameter("id");
		Company_case cases = company_caseService.queryById(caseid);
		if(cases.getImage_1()==null){
			cases.setImage_1("images/default.png");
		}
		if(cases.getImage_2()==null){
			cases.setImage_2("images/default.png");
		}
		if(cases.getImage_3()==null){
			cases.setImage_3("images/default.png");
		}
		if(cases.getImage_4()==null){
			cases.setImage_4("images/default.png");
		}
		if(cases.getImgae_5()==null){
			cases.setImgae_5("images/default.png");
		}
		req.setAttribute("cases", cases);
		req.getRequestDispatcher("/f_company/CompanySelectCase.jsp").forward(req, resp);
	}
	/**
	 * 预约用户查看
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void make_an_appointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/make_an_ appointment.jsp").forward(req, resp);
	}
	/**
	 * 添加活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void add_activities(HttpServletRequest req, HttpServletResponse resp) throws IOException {
			Company_activity companyactivity = new Company_activity();
			if(ServletFileUpload.isMultipartContent(req)){
				DiskFileItemFactory factory = new DiskFileItemFactory(); 
				ServletFileUpload upload = new ServletFileUpload(factory); 
				upload.setHeaderEncoding("utf-8");
				try {
					List<FileItem> items = upload.parseRequest(req);
					for(FileItem item : items){
						if(item.isFormField()){
							String name = item.getFieldName();
							if(name.equals("name")){
								companyactivity.setName(item.getString("utf-8"));
							}else if(name.equals("des")){
								companyactivity.setDes(item.getString("utf-8"));
							}
						}else{
							String name = item.getFieldName();
								if(name.equals("image")){
									if(!item.getString().equals("") && item.getString() != null){
										FileInput.save(req, item);
										companyactivity.setImage("images/"+item.getName());
									}
								}
						}
					}
				} catch (FileUploadException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				session = req.getSession();
				Object object = session.getAttribute("company1");
				Company company = (Company)object;
				companyactivity.setCompany_id(company.getId());
				companyactivity.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
				companyactivity.setStatus("Y");
				company_activityService.add(companyactivity);
				resp.sendRedirect("Upload_the_activity");
			}
	}
	/**
	 * 上传活动界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void Upload_the_activity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/Upload_the_activity.jsp").forward(req, resp);
	}
	/**
	 * 所有案例分页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void show_cases(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = company_caseService.count(); // 所有的学生个数
		int pageSize = 5;//每页显示个数
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
			session = req.getSession();
			Object object = session.getAttribute("company1");
			Company com = (Company)object;
			String id = com.getId();
			List<Company_case> companycases = company_caseService.queryByPager(pageNo, pageSize,id); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("companycases", companycases);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_company/show_cases.jsp").forward(req, resp);
	}
	/**
	 * 添加案例 
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void Add_the_ase(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Company_case companycase = new Company_case();
		if(ServletFileUpload.isMultipartContent(req)){
			DiskFileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory); 
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(req);
				for(FileItem item : items){
					if(item.isFormField()){
						String name = item.getFieldName();
						if(name.equals("name")){
							companycase.setName(item.getString("utf-8"));
						}else if(name.equals("plot_name")){
							companycase.setPlot_name(item.getString("utf-8"));
						}else if(name.equals("style1")){
							companycase.setStyle(item.getString("utf-8"));
						}else if(name.equals("des")){
							companycase.setDes(item.getString("utf-8"));
						}
					}else{
						String name = item.getFieldName();
							if(name.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycase.setImage_1("images/"+item.getName());
								}
							}if(name.equals("photo2")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycase.setImage_2("images/"+item.getName());
								}
							}if(name.equals("photo3")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycase.setImage_3("images/"+item.getName());
								}
							}if(name.equals("photo4")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycase.setImage_4("images/"+item.getName());
								}
							}if(name.equals("photo5")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									companycase.setImgae_5("images/"+item.getName());
								}
							}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session = req.getSession();
			Object object = session.getAttribute("company1");
			Company company = (Company)object;
			companycase.setCompany_id(company.getId());
			companycase.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			companycase.setStatus("Y");
			company_caseService.add(companycase);
			resp.sendRedirect("Case_to_upload");
		}
	}
	/**
	 * 装修公司上传案例界面
	 * @param req
	 * @param resp
	 */
	private void Case_to_upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/Case_to_upload.jsp").forward(req, resp);
	}
	/**
	 * 资料修改成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	
	private void updatedatasucceed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		session = req.getSession();
		Object object = session.getAttribute("company1");
		Company company = (Company)object;
		if(ServletFileUpload.isMultipartContent(req)){
			DiskFileItemFactory factory = new DiskFileItemFactory(); 
			ServletFileUpload upload = new ServletFileUpload(factory); 
			upload.setHeaderEncoding("utf-8");
			try {
				List<FileItem> items = upload.parseRequest(req);
				for(FileItem item : items){
					String name = item.getFieldName();
					if(item.isFormField()){
						if(name.equals("name")){
							company.setCompany_name(item.getString("utf-8"));
						}else if(name.equals("principal")){
							company.setPrincipal(item.getString("utf-8"));
						}else if(name.equals("address")){
							company.setAddress(item.getString("utf-8"));
						}else if(name.equals("phone")){
							company.setPhone(item.getString("utf-8"));
						}else if(name.equals("tel")){
							company.setTel(item.getString("utf-8"));
						}else if(name.equals("longitude")){
							company.setLongitude(Float.valueOf(item.getString("utf-8")));
						}else if(name.equals("latitude")){
							company.setLatitude(Float.valueOf(item.getString("utf-8")));
						}else if(name.equals("des")){
							company.setDes(item.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("logo")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									company.setLogo("images/"+item.getName());
								}
							}
						}
					}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		companyService.update(company);
		session.setAttribute("company1", company);
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
		Object object = session.getAttribute("company1");
		Company company = (Company)object;
		String pwd = company.getPassword();
		String id=company.getId();
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
				companyService.updatepwd(id,Encrypt.encrypt(pwd2));
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
		req.getRequestDispatcher("/f_company/change_password.jsp").forward(req, resp);
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
		Object object = session.getAttribute("company1");
		Company company1 = (Company)object;
		String id = company1.getId();
		Company company = companyService.queryById(id);
		req.setAttribute("company1", company);
		req.getRequestDispatcher("/f_company/companydata.jsp").forward(req, resp);
	}
	/**
	 * 个人中心
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void center(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_company/personal_center.jsp").forward(req, resp);
	}
	/**
	 * 重定向主页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(session.getAttribute("company1")!=null){
			session.removeAttribute("company1");
			resp.sendRedirect(req.getContextPath());
		}else {
			resp.sendRedirect(req.getContextPath());
		}
	}
	/**
	 * 验证登录
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void loginverify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		PrintWriter out = resp.getWriter();
		if(!email.trim().equals("")&&email!=null
				&&!pwd.trim().equals("")&&pwd!=null){
			Company company = companyService.queryByemail(email);
			if(company==null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"noemail\"}");
				return;
			}
			Company company1 = companyService.queryByNoPwd(email, Encrypt.encrypt(pwd));
			if(company1==null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"password\"}");
				return;
			}
			if(company1.getStatus().equals("N")){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"forbidden\"}");
				return;
			}
			if(company1.getChecked().equals("N")){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"check\"}");
				return;
			}
			session = req.getSession();
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
			session.setAttribute("company1", company1);
			companyService.updatelast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"), company1.getId());
			out.write("{\"info\":\"succeed\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
			return;
		}
	}
	/**
	 * 验证注册
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void regverify(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		PrintWriter out = resp.getWriter();
		Company company= companyService.queryByemail(email);
		if(company!=null){
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"noemail\"}");
			return;
		}
		if(email!=null && !email.trim().equals("")
				&& pwd1!=null && !pwd1.trim().equals("")
				&&pwd2!=null && !pwd2.trim().equals("")
				&& name!=null && !name.trim().equals("")
				&& phone!=null && !phone.trim().equals("")){
			if(!email.matches(Constants.EMAIL_CONTENT_TYPE)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"email\"}");
				return;
			}
			if(pwd1.length()<6){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"lengthpassword\"}");
				return;
			}
			if(!pwd1.equals(pwd2)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"password\"}");
				return;
			}
			if(!phone.matches(Constants.PHONE_CONTENT_TYPE)){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"phone\"}");
				return;
			}
			Company com = new Company();
			com.setEmail(email);
			com.setPassword(Encrypt.encrypt(pwd1));
			com.setCompany_name(name);
			com.setPrincipal("负责人");
			com.setLogo("images/mrlogo.jpg");
			com.setAddress("地址");
			com.setPhone("手机号");
			com.setTel("固定电话");
			com.setOpen_date(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			com.setLongitude(0);
			com.setLatitude(0);
			com.setDes("描述");
			com.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			com.setChecked("N");
			com.setChecked_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			com.setStatus("N");
			companyService.add(com);
			out.write("{\"info\":\"succeed\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
			return;
		}
	}
}
