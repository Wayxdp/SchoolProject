package com.mo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Calendar;
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

import com.mo.bean.Appointment;
import com.mo.bean.Company;
import com.mo.bean.Company_activity;
import com.mo.bean.Customer;
import com.mo.bean.Designer;
import com.mo.bean.DesignerAndCase;
import com.mo.bean.Designer_case;
import com.mo.bean.Designer_case_col;
import com.mo.bean.Designer_col;
import com.mo.bean.Userconsult;
import com.mo.common.Constants;
import com.mo.common.DataTime;
import com.mo.common.DateUtil;
import com.mo.common.Encrypt;
import com.mo.common.FileInput;
import com.mo.common.WebUtil;
import com.mo.service.AppointmentService;
import com.mo.service.DesignerService;
import com.mo.service.Designer_caseService;
import com.mo.service.Designer_case_colService;
import com.mo.service.Designer_colService;
import com.mo.service.UserconsultService;
import com.mo.serviceimpl.AppointmentServiceImpl;
import com.mo.serviceimpl.DesignerServiceImpl;
import com.mo.serviceimpl.Designer_caseServiceImpl;
import com.mo.serviceimpl.Designer_case_colServiceImpl;
import com.mo.serviceimpl.Designer_colServiceImpl;
import com.mo.serviceimpl.UserconsultServiceImpl;

import javafx.scene.chart.PieChart.Data;

public class DesignerServlet extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -9046537434744343759L;
	private DesignerService designerService;
	private Designer_caseService designer_caseService;
	private HttpSession session=null;
	private AppointmentService appo; 
	private Designer_case_colService designer_case_colService;
	private Designer_colService designer_colService;
	private UserconsultService userconsultService;
	public DesignerServlet() {
		designerService = new DesignerServiceImpl();
		designer_caseService = new Designer_caseServiceImpl();
		appo = new AppointmentServiceImpl();
		designer_case_colService = new Designer_case_colServiceImpl();
		designer_colService = new Designer_colServiceImpl();
		userconsultService = new UserconsultServiceImpl();
	}

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mothed = WebUtil.getUriMethod(req);
		if (Mothed.equals("addreg")) {
			addreg(req, resp);
		} else if (Mothed.equals("yzlogin")) {
			yzlogin(req, resp);
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
		}else if(Mothed.equals("make_an_appointment")){
			make_an_appointment(req,resp);
		}else if(Mothed.equals("Home_page_designer_for_details")){
			Home_page_designer_for_details(req,resp);
		}else if(Mothed.equals("The_owner_to_make_an_appointment")){
			The_owner_to_make_an_appointment(req,resp);
		}else if(Mothed.equals("show_cases")){
			show_cases(req,resp);
		}else if(Mothed.equals("designerdetails")){
			designerdetails(req,resp);
		}else if(Mothed.equals("designerrevamp")){
			designerrevamp(req,resp);
		}else if(Mothed.equals("desingerrecompose")){
			desingerrecompose(req,resp);
		}else if(Mothed.equals("designerforbidden")){
			designerforbidden(req,resp);
		}else if(Mothed.equals("designeravailable")){
			designeravailable(req,resp);
		}else if(Mothed.equals("alldesingercase")){
			alldesingercase(req,resp);
		}else if(Mothed.equals("enshrine")){
			enshrine(req,resp);
		}else if(Mothed.equals("alldesigners")){
			alldesigners(req,resp);
		}else if(Mothed.equals("homecasedetails")){
			homecasedetails(req,resp);
		}else if(Mothed.equals("designercollect")){
			designercollect(req,resp);
		}else if(Mothed.equals("userconsult")){
			userconsult(req,resp);
		}else if(Mothed.equals("usersucceed")){
			usersucceed(req,resp);
		}else if(Mothed.equals("allConsult")){
			allConsult(req,resp);
		}else if(Mothed.equals("log_out_safely")){
			log_out_safely(req,resp);
		}
	}
	/**
	 * 设计师安全退出
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void log_out_safely(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(session.getAttribute("designer1") != null){
			session.removeAttribute("designer1");
			req.getRequestDispatcher("/f_designer/designerlogin.jsp").forward(req, resp);
		}
	}

	/**
	 * 所有咨询的用户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void allConsult(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = userconsultService.count(); // 所有的学生个数
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
			List<Userconsult> userConsult = userconsultService.queryByPager(pageNo, pageSize); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("userConsult", userConsult);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_designer/desConsult.jsp").forward(req, resp);
	}

	/**
	 * 用户咨询成功
	 * @param req
	 * @param resp
	 * @throws IOException
	 * @throws ServletException 
	 */
	private void usersucceed(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("designerid");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String email = req.getParameter("email");
		String qq = req.getParameter("qq");
		String message = req.getParameter("message");
		Userconsult userconsult = new Userconsult();
		userconsult.setDesigner_id(id);
		userconsult.setPhone(phone);
		userconsult.setName(name);
		userconsult.setQq(qq);
		userconsult.setLeave_word(message);
		userconsult.setEmali(email);
		userconsult.setCreated_time(Calendar.getInstance().getTime());
		userconsultService.add(userconsult);
		resp.sendRedirect("userconsult");
	}

	/**
	 * 用户咨询设计师界面
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
	 * 设计师收藏按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designercollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		PrintWriter out = resp.getWriter();
		if(customer!=null){
			String designerid = req.getParameter("id");//设计师id
			String customerid = customer.getId();//用户id
			Designer_col designer = designer_colService.queryBycustomerIdBydesignerId(customerid, designerid);
			if(designer!=null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"1\"}");
				return;
			}
			Designer_col designer_col = new Designer_col();
			designer_col.setCustomer_id(customerid);
			designer_col.setDesigner_id(designerid);
			designer_col.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			designer_colService.add(designer_col);
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"2\"}");
			return;
		}else {
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}
	
	/**
	 * 主页设计师案例详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homecasedetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseid = req.getParameter("caseid");
		Designer_case designer_case = designer_caseService.queryById(caseid);
		String designer_id = designer_case.getDesigner_id();
		DesignerAndCase designerAndCase = designerService.queryByCase_idAndDesigner_id(caseid,designer_id );
		req.setAttribute("designerAndCase", designerAndCase);
		req.getRequestDispatcher("/f_designer/designercasedetails.jsp").forward(req, resp);
	}

	/**
	 *主页所有设计师
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void alldesigners(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = designerService.count(); // 所有设计师案例
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
		List<Designer> designers = designerService.queryByPager1(pageNo, pageSize);
		req.setAttribute("designers", designers);
		req.getRequestDispatcher("/f_designer/alldesigners.jsp").forward(req, resp);
	}

	/**
	 * 收藏按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void enshrine(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("customer1");
		if(object!=null){
			Customer cus = (Customer)object;
			String customer_id = cus.getId();//用户id
			String caseid = req.getParameter("caseid");//设计师案例id
			Designer_case_col case_col = designer_case_colService.queryById(caseid);
			if(case_col!=null){
				System.out.println("不能重复收藏");
				return;
			}
			Designer_case_col designer_case_col = new Designer_case_col();
			designer_case_col.setCase_id(caseid);
			designer_case_col.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			designer_case_col.setCustomer_id(customer_id);
			designer_case_colService.add(designer_case_col);
			resp.sendRedirect("alldesingercase");
		}else {
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}

	/**
	 * 所有设计师案例
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void alldesingercase(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = designer_caseService.count(); // 所有设计师案例
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
			List<DesignerAndCase> designerAndCases = designerService.queryByPagercase(pageNo,pageSize);
			req.setAttribute("designerAndCases", designerAndCases);//查询所有设计师案例
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_designer/allDesigner_case.jsp").forward(req, resp);
	}

	/**
	 * 设计师案例可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designeravailable(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String status = "Y";
		designer_caseService.updateStatus(id, status);
		req.getRequestDispatcher("show_cases").forward(req, resp);
	}

	/**
	 *设计师案例禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerforbidden(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		String status = "N";
		designer_caseService.updateStatus(id, status);
		req.getRequestDispatcher("show_cases").forward(req, resp);
	}

	/**
	 * 设计师案例修改
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void desingerrecompose(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Designer_case designercase=null;
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
							designercase=designer_caseService.queryById(item.getString("utf-8"));
							designercase.setDesigner_id(item.getString("utf-8"));
						}
				}
				for(FileItem item2 : items){
					String name = item2.getFieldName();
					if(item.isFormField()){
						if(name.equals("name")){
							designercase.setCasename(item2.getString("utf-8"));
						}else if(name.equals("plot_name")){
							designercase.setPlot_name(item2.getString("utf-8"));
						}else if(name.equals("style1")){
							designercase.setStyle(item2.getString("utf-8"));
						}else if(name.equals("des")){
							designercase.setDes(item2.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_1("images/"+item.getName());
								}
							}if(name1.equals("photo2")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_2("images/"+item.getName());
								}
							}if(name1.equals("photo3")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_3("images/"+item.getName());
								}
							}if(name1.equals("photo4")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_4("images/"+item.getName());
								}
							}if(name1.equals("photo5")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_5("images/"+item.getName());
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
		designer_caseService.update(designercase);
		resp.sendRedirect("show_cases");
	}

	/**
	 * 设计师案例修改界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerrevamp(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Designer_case designercase = designer_caseService.queryById(id);
		req.setAttribute("designercase", designercase);
		req.getRequestDispatcher("/f_designer/designerrecompose.jsp").forward(req, resp);
	}

	/**
	 * 设计师案例详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void designerdetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String caseid = req.getParameter("id");
		Designer_case cases = designer_caseService.queryById(caseid);
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
		if(cases.getImage_5()==null){
			cases.setImage_5("images/default.png");
		}
		req.setAttribute("cases", cases);
		req.getRequestDispatcher("/f_designer/DesignerSelectCase.jsp").forward(req, resp);
	}

	/**
	 * 业主预约功能
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void The_owner_to_make_an_appointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		String plot_name = req.getParameter("plot_name");
		String area = req.getParameter("area");
		String way = req.getParameter("way");
		String budget = req.getParameter("budget");
		String designer_id = req.getParameter("designer_id");
		Appointment app = new Appointment();
		app.setDesigner_id(designer_id);
		app.setName(name);
		app.setPhone(phone);
		app.setPlot_name(plot_name);
		app.setArea(Float.valueOf(area));
		app.setWay(way);
		app.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
		app.setBudget(budget);
		appo.adddesigner(app);
		req.setAttribute("app", app);
		req.getRequestDispatcher("/index.jsp").forward(req, resp);
	}

	/**
	 * 主页详情设计师界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void Home_page_designer_for_details(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		int total = designer_caseService.queryCount(id); // 所有的学生个数
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
		List<Designer> designertop3 = designerService.top3all();
		Designer designer = designerService.queryById(id);//根据设计师id来查询相对应的设计师
		List<Designer_case> designercase = designer_caseService.queryByPager(pageNo, pageSize, id);
		req.setAttribute("designertop3", designertop3);
		req.setAttribute("designercase", designercase);
		req.setAttribute("designer", designer);
		req.setAttribute("count", total);
		req.getRequestDispatcher("/f_designer/Home_page_designer_for_details.jsp").forward(req, resp);
	}

	/**
	 * 预约用户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void make_an_appointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Object object = session.getAttribute("designer1");
		Designer designer = (Designer)object;
		String id = designer.getId();
		int total = appo.getCount(id);
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
		List<Appointment> Appointments = appo.queryByPager(pageNo, pageSize, id);
		req.setAttribute("Appointments", Appointments);
		req.getRequestDispatcher("/f_designer/make_an_ appointment.jsp").forward(req, resp);
	}

	/**
	 * 所有案例分页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void show_cases(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = designer_caseService.count(); // 所有的学生个数
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
			Object object = session.getAttribute("designer1");
			Designer des = (Designer)object;
			String id = des.getId();
			List<Designer_case> designercases = designer_caseService.queryByPager(pageNo, pageSize,id); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("designercases", designercases);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_designer/show_cases.jsp").forward(req, resp);
	}
	/**
	 * 添加案例方法
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void Add_the_ase(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Designer_case designercase = new Designer_case();
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
							designercase.setCasename(item.getString("utf-8"));
						}else if(name.equals("plot_name")){
							designercase.setPlot_name(item.getString("utf-8"));
						}else if(name.equals("style1")){
							designercase.setStyle(item.getString("utf-8"));
						}else if(name.equals("des")){
							designercase.setDes(item.getString("utf-8"));
						}
					}else{
						String name = item.getFieldName();
							if(name.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_1("images/"+item.getName());
								}
							}if(name.equals("photo2")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_2("images/"+item.getName());
								}
							}if(name.equals("photo3")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_3("images/"+item.getName());
								}
							}if(name.equals("photo4")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_4("images/"+item.getName());
								}
							}if(name.equals("photo5")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designercase.setImage_5("images/"+item.getName());
								}
							}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session = req.getSession();
			Object object = session.getAttribute("designer1");
			Designer designer = (Designer)object;
			designercase.setDesigner_id(designer.getId());
			designercase.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			designercase.setStatus("Y");
			designer_caseService.add(designercase);
			resp.sendRedirect("Case_to_upload");
		}
	}

	/**
	 * 上传案例界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void Case_to_upload(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_designer/Case_to_upload.jsp").forward(req, resp);
	}

	/**
	 * 资料修改成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void updatedatasucceed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		session = req.getSession();
		Object object = session.getAttribute("designer1");
		Designer designer = (Designer)object;
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
							designer.setName(item.getString("utf-8"));
						}else if(name.equals("phone")){
							designer.setPhone(item.getString("utf-8"));
						}else if(name.equals("des")){
							designer.setDes(item.getString("utf-8"));
						}else if(name.equals("experience")){
							designer.setExperience(item.getString("utf-8"));
						}else if(name.equals("style")){
							designer.setStyle(item.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("headicon")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									designer.setHeadicon("images/"+item.getName());
								}
							}
						}
					}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		designerService.update(designer);
		session.setAttribute("designer1", designer);
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
		Object object = session.getAttribute("designer1");
		Designer designer = (Designer)object;
		String pwd = designer.getPassword();
		String id=designer.getId();
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
				designerService.updatepwd(id,Encrypt.encrypt(pwd2));
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
		req.getRequestDispatcher("/f_designer/change_password.jsp").forward(req, resp);
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
		Object object = session.getAttribute("designer1");
		Designer designer1 = (Designer)object;
		String id = designer1.getId();
		Designer designer = designerService.queryById(id);
		req.setAttribute("designer",designer );
		req.getRequestDispatcher("/f_designer/designerdata.jsp").forward(req,resp);
	}

	/**
	 * 个人中心
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void center(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_designer/personal_center.jsp").forward(req, resp);
	}
	/**
	 * 重定向主页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(session.getAttribute("desinger1")!=null){
			session.removeAttribute("designer1");
			resp.sendRedirect(req.getContextPath());
		}else {
			resp.sendRedirect(req.getContextPath());
		}
	}
	/**
	 * 登录验证
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void yzlogin(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd = req.getParameter("password");
		Designer designer = designerService.queryByemail(email);
		PrintWriter out = resp.getWriter();
		if (email != null && !email.trim().equals("") && pwd != null && !pwd.trim().equals("")) {
			if (designer == null) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"email\"}");
				return;
			}
			Designer designer1 = designerService.queryByNoPwd(email, Encrypt.encrypt(pwd));
			if (designer1 == null) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"pwd\"}");
				return;
			}
			if (designer1.getStatus().equals("N")) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"forbidden\"}");
				return;
			}
			if (designer1.getChecked().equals("N")) {
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
			session.setAttribute("designer1", designer1);
			designerService.updatelast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"),designer1.getId());
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"nase\"}");
		} else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
		}
	}

	/**
	 * 添加设计师
	 * 
	 * @param req
	 * @param resp
	 * @throws IOException
	 */
	private void addreg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String email = req.getParameter("email");
		String pwd1 = req.getParameter("pwd1");
		String pwd2 = req.getParameter("pwd2");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		PrintWriter out = resp.getWriter();
		Designer designer = designerService.queryByemail(email);
		if (designer != null) {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"1\"}");
			return;
		}
		if (email != null && !email.trim().equals("") && pwd1 != null && !pwd1.trim().equals("") && pwd2 != null
				&& !pwd2.trim().equals("") && name != null && !name.trim().equals("") && phone != null
				&& !phone.trim().equals("")) {

			if (!email.matches(Constants.EMAIL_CONTENT_TYPE)) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"2\"}");
				return;
			}
			if (pwd1.length() < 6) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"3\"}");
				return;
			}
			if (!pwd1.equals(pwd2)) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"4\"}");
				return;
			}
			if (!phone.matches(Constants.PHONE_CONTENT_TYPE)) {
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"phonespan\":\"5\"}");
				return;
			}
			Designer designer1 = new Designer();
			designer1.setEmail(email);
			designer1.setPassword(Encrypt.encrypt(pwd1));
			designer1.setName(name);
			designer1.setPhone(phone);
			designer1.setAddress("地址");
			designer1.setExperience("工作经验");
			designer1.setStyle("设计风格");
			designer1.setStatus("N");
			designer1.setHeadicon("images/mrtx.jpg");
			designer1.setChecked("N");
			designer1.setDes("描述");
			designer1.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			designer1.setLast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			designer1.setChecked_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			designerService.add(designer1);
			out.write("{\"info\":\"6\"}");
		} else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"7\"}");
		}
	}
}
