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

import com.mo.bean.Customer;
import com.mo.bean.Product;
import com.mo.bean.Product_col;
import com.mo.bean.Supply;
import com.mo.bean.SupplyAndProduct;
import com.mo.bean.Supply_activity;
import com.mo.bean.Supply_col;
import com.mo.common.Constants;
import com.mo.common.DataTime;
import com.mo.common.DateUtil;
import com.mo.common.Encrypt;
import com.mo.common.FileInput;
import com.mo.common.WebUtil;
import com.mo.service.ProductService;
import com.mo.service.Product_colService;
import com.mo.service.SupplyService;
import com.mo.service.Supply_activityService;
import com.mo.service.Supply_colService;
import com.mo.serviceimpl.ProductServiceImpl;
import com.mo.serviceimpl.Product_colServiceImpl;
import com.mo.serviceimpl.SupplyServiceImpl;
import com.mo.serviceimpl.Supply_activityServiceImpl;
import com.mo.serviceimpl.Supply_colServiceImpl;

import javafx.scene.chart.PieChart.Data;

public class SupplyServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8096234102759212213L;
	private SupplyService supplyService;
	private HttpSession session=null;
	private Supply_activityService supplyactivityService;
	private ProductService productService;
	private Product_colService ProductcolService;
	private Supply_colService supply_colService;
	public SupplyServlet(){
		supplyService = new SupplyServiceImpl();
		supplyactivityService = new Supply_activityServiceImpl();
		productService = new ProductServiceImpl();
		ProductcolService = new Product_colServiceImpl();
		supply_colService = new Supply_colServiceImpl();
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
		}else if(Mothed.equals("Upload_the_activity")){
			Upload_the_activity(req,resp);
		}else if(Mothed.equals("add_activities")){
			add_activities(req,resp);
		}else if(Mothed.equals("make_an_appointment")){
			make_an_appointment(req,resp);
		}else if(Mothed.equals("show_activiy")){
			show_activiy(req,resp);
		}else if(Mothed.equals("activityforbidden")){
			activityforbidden(req,resp);
		}else if(Mothed.equals("activityavailable")){
			activityavailable(req,resp);
		}else if(Mothed.equals("activitydetails")){
			activitydetails(req,resp);
		}else if(Mothed.equals("activitymodifySituation")){
			activitymodifySituation(req,resp);
		}else if(Mothed.equals("activityrecompose")){
			activityrecompose(req,resp);
		}else if(Mothed.equals("addproduct")){
			addproduct(req,resp);
		}else if(Mothed.equals("Upload_the_goods")){
			Upload_the_goods(req,resp);
		}else if(Mothed.equals("products")){
			products(req,resp);
		}else if(Mothed.equals("productdetails")){
			productdetails(req,resp);
		}else if(Mothed.equals("productmodifySituation")){
			productmodifySituation(req,resp);
		}else if(Mothed.equals("productrecompose")){
			productrecompose(req,resp);
		}else if(Mothed.equals("productforbidden")){
			productforbidden(req,resp);
		}else if(Mothed.equals("productavailable")){
			productavailable(req,resp);
		}else if(Mothed.equals("decoration_company")){
			decoration_company(req,resp);
		}else if(Mothed.equals("homeallproduct")){
			homeallproduct(req,resp);
		}else if(Mothed.equals("enshrine")){
			enshrine(req,resp);
		}else if(Mothed.equals("homeallsupply")){
			homeallsupply(req,resp);
		}else if(Mothed.equals("supplycollect")){
			supplycollect(req,resp);
		}else if(Mothed.equals("supplyActivity")){
			supplyActivity(req,resp);
		}else if(Mothed.equals("pastsupplyActivity")){
			pastsupplyActivity(req,resp);
		}else if(Mothed.equals("log_out_safely")){
			log_out_safely(req,resp);
		}else if(Mothed.equals("homeproductdetails")){
			homeproductdetails(req,resp);
		}else if(Mothed.equals("detail_of_the_activity")){
			detail_of_the_activity(req,resp);
		}else if(Mothed.equals("pastSupply_activity")){
			pastSupply_activity(req,resp);
		}
	}
	
	private void pastSupply_activity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");//建材商活动id
		Supply_activity supply_activity = supplyactivityService.queryById(id);
		req.setAttribute("supply_activity", supply_activity);
		req.getRequestDispatcher("/sundry/pastsupply_activit.jsp").forward(req, resp);
	}
	/**
	 * 建材商活动详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void detail_of_the_activity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id =req.getParameter("id");//建材商活动id
		Supply_activity supply_activity = supplyactivityService.queryById(id);
		req.setAttribute("supply_activity", supply_activity);
		req.getRequestDispatcher("/sundry/supplydetail_of_the_activity.jsp").forward(req, resp);
	}
	/**
	 * 建材商商品详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homeproductdetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");//商品id
		Product product= productService.queryById(id);
		String supply_id = product.getSupply_id();//获取建材商id
		SupplyAndProduct SupplyAndProducts = supplyService.queryBysupply_idAndproduct_id(supply_id,id);
		req.setAttribute("SupplyAndProducts", SupplyAndProducts);
		req.getRequestDispatcher("/f_Supply/supplyproductdetails.jsp").forward(req, resp);
	}
	/**
	 * 建材商安全退出
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void log_out_safely(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if(session.getAttribute("supply1")!=null){
			session.removeAttribute("supply1");
			req.getRequestDispatcher("/f_Supply/supplylogin.jsp").forward(req, resp);
		}
	}
	/**
	 * 主页所有往期建材商活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void pastsupplyActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supplyactivityService.count(); // 所有的活动个数
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
		List<Supply_activity> Supplyactivity = supplyactivityService.pastqueryByPager(pageNo, pageSize) ;// 指定页码的数据，此页上显示指定的个数
		req.setAttribute("Supplyactivity", Supplyactivity);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/sundry/pastSupply_activity.jsp").forward(req, resp);
	}
	/**
	 * 主页所有建材商活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplyActivity(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supplyactivityService.count(); // 所有的活动个数
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
		List<Supply_activity> Supplyactivity = supplyactivityService.queryByPager(pageNo, pageSize) ;// 指定页码的数据，此页上显示指定的个数
		req.setAttribute("Supplyactivity", Supplyactivity);//查询所有学生放入request作用域
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/sundry/Supply_activity.jsp").forward(req, resp);
	}
	
	/**
	 * 建材商收藏按钮
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void supplycollect(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession();
		Object object = session.getAttribute("customer1");
		Customer customer = (Customer)object;
		if(customer!=null){
			String supplyid = req.getParameter("id");//建材商id
			String customerid = customer.getId();//用户id
			Supply_col supply = supply_colService.queryBycustomerIdBycompanyId(customerid, supplyid);
			if(supply!=null){
				System.out.println("不能重复收藏");
				return;
			}
			Supply_col supply_col = new Supply_col();
			supply_col.setCustomer_id(customerid);
			supply_col.setSupply_id(supplyid);
			supply_col.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			supply_colService.add(supply_col);
			resp.sendRedirect("homeallsupply");
		}else {
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}
	/**
	 * 主页查看所有建材商
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homeallsupply(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supplyService.count(); // 所有装修公司
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
		List<Supply> supplys = supplyService.queryByPager1(pageNo, pageSize);
		req.setAttribute("supplys", supplys);
		req.getRequestDispatcher("/f_Supply/homeallsupplys.jsp").forward(req, resp);
	}
	
	/**
	 * 主页收藏建材商按钮
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
			String productid = req.getParameter("id");//建材商id
			String customerid = customer.getId();//用户id
			Product_col Productcol = ProductcolService.queryBycustomerIdBysupplyId(customerid, productid);
			if(Productcol!=null){
				System.out.println("不能重复收藏");
				return;
			}
			Product_col product_col = new Product_col();
			product_col.setCustomer_id(customerid);
			product_col.setProduct_id(productid);
			product_col.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			ProductcolService.add(product_col);
			resp.sendRedirect("homeallproduct");
		}else {
			req.getRequestDispatcher("/f_user/UserLogin.jsp").forward(req, resp);
		}
	}
	/**
	 * 主页所有建材商品
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void homeallproduct(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = productService.count(); // 所有建材商品
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
			List<SupplyAndProduct> SupplyAndProducts = productService.queryByPagercase(pageNo,pageSize);
			req.setAttribute("SupplyAndProducts", SupplyAndProducts);//查询所有设计师案例
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_Supply/allProduct.jsp").forward(req, resp);
	}
	/**
	 * 建材商个人中心主页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void decoration_company(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");//建材商id
		int count = productService.queryCount(id);
		int pageSize = 6;//每页显示个数
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
		Supply supply = supplyService.queryById(id);//查出建材商的资料
		List<Product> Products = productService.queryByPager(pageNo, pageSize, id);//查出这个建材商的所有建材
		List<Supply> supplys = supplyService.top3all();
		req.setAttribute("supplys", supplys);
		req.setAttribute("supply", supply);//把装修公司资料传入主页
		req.setAttribute("Products", Products);
		req.setAttribute("count", count);
		req.setAttribute("totalPage", totalPage);//总页数放入request作用域
		req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
		req.getRequestDispatcher("/f_Supply/Home_page_designer_for_details.jsp").forward(req, resp);
	}
	/**
	 * 商品可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void productavailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		productService.updateStatus(id, status);
		resp.sendRedirect("products");
	}
	/**
	 * 商品禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void productforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		productService.updateStatus(id, status);
		resp.sendRedirect("products");
	}
	/**
	 * 商品修改成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void productrecompose(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Product product=null;
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
							product=productService.queryById(item.getString("utf-8"));
							product.setSupply_id(item.getString("utf-8"));
							
						}
				}
				for(FileItem item2 : items){
					String name = item2.getFieldName();
					if(item.isFormField()){
						if(name.equals("name")){
							product.setProductname(item2.getString("utf-8"));
						}else if(name.equals("des")){
							product.setDes(item2.getString("utf-8"));
						}else if(name.equals("price")){
							product.setPrice(Float.valueOf(item2.getString("utf-8")));
						}else if(name.equals("sale_price")){
							product.setSale_price(Float.valueOf(item2.getString("utf-8")));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									product.setImage("images/"+item.getName());
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
		productService.update(product);
		resp.sendRedirect("products");
	}
	/**
	 * 商品修改界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void productmodifySituation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Product product = productService.queryById(id);
		req.setAttribute("product", product);
		req.getRequestDispatcher("/f_Supply/productrecompose.jsp").forward(req, resp);
	}
	/**
	 * 商品详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void productdetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		Product product = productService.queryById(id);
		if(product.getImage()==null){
			product.setImage("images/default.png");
		}
		req.setAttribute("product", product);
		req.getRequestDispatcher("/f_Supply/productdetails.jsp").forward(req, resp);
	}
	/**
	 * 所有建材商品
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void products(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = productService.count(); // 所有的学生个数
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
			Object object = session.getAttribute("supply1");
			Supply com = (Supply)object;
			String id = com.getId();
			List<Product> products = productService.queryByPager(pageNo, pageSize,id); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("products", products);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_Supply/products.jsp").forward(req, resp);
	}
	/**
	 * 上传建材商 商品界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void Upload_the_goods(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_Supply/Upload_the_goods.jsp").forward(req, resp);
	}
	/**
	 * 建材商 商品添加
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void addproduct(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Product product = new Product();
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
							product.setProductname(item.getString("utf-8"));
						}else if(name.equals("des")){
							product.setDes(item.getString("utf-8"));
						}else if(name.equals("price")){
							product.setPrice(Float.valueOf(item.getString("utf-8")));
						}else if(name.equals("sale_price")){
							product.setSale_price(Float.valueOf(item.getString("utf-8")));
						}
					}else{
						String name = item.getFieldName();
							if(name.equals("image")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									product.setImage("images/"+item.getName());
								}
							}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session = req.getSession();
			Object object = session.getAttribute("supply1");
			Supply supply = (Supply)object;
			product.setSupply_id(supply.getId());
			product.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			product.setStatus("Y");
			productService.add(product);
			resp.sendRedirect("Upload_the_goods");
		}
	}
	/**
	 * 建材商活动修改成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void activityrecompose(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Supply_activity supplyactivity=null;
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
							supplyactivity=supplyactivityService.queryById(item.getString("utf-8"));
							supplyactivity.setSupply_id(item.getString("utf-8"));
							
						}
				}
				for(FileItem item2 : items){
					String name = item2.getFieldName();
					if(item.isFormField()){
						if(name.equals("name")){
							supplyactivity.setName(item2.getString("utf-8"));
						}else if(name.equals("des")){
							supplyactivity.setDes(item2.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("photo1")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									supplyactivity.setImage("images/"+item.getName());
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
		supplyactivityService.update(supplyactivity);
		resp.sendRedirect("show_activiy");
	}
	/**
	 * 建材商活动修改界面
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void activitymodifySituation(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("id");
		Supply_activity supplyactivity = supplyactivityService.queryById(id);
		req.setAttribute("supplyactivity", supplyactivity);
		req.getRequestDispatcher("/f_Supply/supplyactivity.jsp").forward(req, resp);
	}
	/**
	 * 建材商活动详情
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void activitydetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id= req.getParameter("id");
		Supply_activity supplyactivity = supplyactivityService.queryById(id);
		if(supplyactivity.getImage()==null){
			supplyactivity.setImage("images/default.png");
		}
		req.setAttribute("supplyactivity", supplyactivity);
		req.getRequestDispatcher("/f_Supply/activitydetails.jsp").forward(req, resp);
	}
	/**
	 * 建材商活动可用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void activityavailable(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "Y";
		supplyactivityService.updateStatus(id, status);
		resp.sendRedirect("show_activiy");
	}
	/**
	 * 建材商活动禁用
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void activityforbidden(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		String id = req.getParameter("id");
		String status = "N";
		supplyactivityService.updateStatus(id, status);
		resp.sendRedirect("show_activiy");
	}
	/**
	 * 所有建材商活动查看
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void show_activiy(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int total = supplyactivityService.count(); // 所有的学生个数
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
			Object object = session.getAttribute("supply1");
			Supply com = (Supply)object;
			String id = com.getId();
			List<Supply_activity> supplyactivity = supplyactivityService.queryByPager(pageNo, pageSize,id); // 指定页码的数据，此页上显示指定的个数
			req.setAttribute("supplyactivity", supplyactivity);//查询所有学生放入request作用域
			req.setAttribute("totalPage", totalPage);//总页数放入request作用域
			req.setAttribute("currPage",  pageNo);//当前页码放入request作用域
			req.getRequestDispatcher("/f_Supply/show_activity.jsp").forward(req, resp);
	}
	/**
	 * 预约用户
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void make_an_appointment(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_Supply/make_an_ appointment.jsp").forward(req, resp);
	}
	/**
	 * 添加活动
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void add_activities(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Supply_activity supplyactivity = new Supply_activity();
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
							supplyactivity.setName(item.getString("utf-8"));
						}else if(name.equals("des")){
							supplyactivity.setDes(item.getString("utf-8"));
						}
					}else{
						String name = item.getFieldName();
							if(name.equals("image")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									supplyactivity.setImage("images/"+item.getName());
								}
							}
					}
				}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			session = req.getSession();
			Object object = session.getAttribute("supply1");
			Supply supply = (Supply)object;
			supplyactivity.setSupply_id(supply.getId());
			supplyactivity.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			supplyactivity.setStatus("Y");
			supplyactivityService.add(supplyactivity);
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
		req.getRequestDispatcher("/f_Supply/Upload_the_activity.jsp").forward(req, resp);
	}
	/**
	 *修改资料成功
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void updatedatasucceed(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		session = req.getSession();
		Object object = session.getAttribute("supply1");
		Supply supply = (Supply)object;
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
							supply.setName(item.getString("utf-8"));
						}else if(name.equals("principal")){
							supply.setPrincipal(item.getString("utf-8"));
						}else if(name.equals("address")){
							supply.setAddress(item.getString("utf-8"));
						}else if(name.equals("phone")){
							supply.setPhone(item.getString("utf-8"));
						}else if(name.equals("tel")){
							supply.setTel(item.getString("utf-8"));
						}else if(name.equals("longitude")){
							supply.setLongitude(Float.valueOf(item.getString("utf-8")));
						}else if(name.equals("latitude")){
							supply.setLatitude(Float.valueOf(item.getString("utf-8")));
						}else if(name.equals("des")){
							supply.setDes(item.getString("utf-8"));
						}
					}else{
						String name1 = item.getFieldName();
							if(name1.equals("logo")){
								if(!item.getString().equals("") && item.getString() != null){
									FileInput.save(req, item);
									supply.setLogo("images/"+item.getName());
								}
							}
						}
					}
			} catch (FileUploadException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		supplyService.update(supply);
		session.setAttribute("supply1", supply);
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
		Object object = session.getAttribute("supply1");
		Supply supply = (Supply)object;
		String pwd = supply.getPassword();
		String id= supply.getId();
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
				supplyService.updatepwd(id,Encrypt.encrypt(pwd2));
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
		req.getRequestDispatcher("/f_Supply/change_password.jsp").forward(req, resp);
	}
	/**
	 * 查看个人基本信息
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void data(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		session = req.getSession();
		Object object = session.getAttribute("supply1");
		Supply supply1 = (Supply)object;
		String id = supply1.getId();
		Supply supply = supplyService.queryById(id);
		req.setAttribute("supply",supply );
		req.getRequestDispatcher("/f_Supply/supplydata.jsp").forward(req,resp);
	}
	/**
	 * 个人中心
	 * @param req
	 * @param resp
	 * @throws IOException 
	 * @throws ServletException 
	 */
	private void center(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/f_Supply/personal_center.jsp").forward(req, resp);
	}
	/**
	 * 重定向主页
	 * @param req
	 * @param resp
	 * @throws IOException 
	 */
	private void exit(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		if(session.getAttribute("supply")!=null){
			session.removeAttribute("supply1");
			resp.sendRedirect(req.getContextPath());
		}else {
			resp.sendRedirect(req.getContextPath());
		}
	}
	/**
	 * 登录验证
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
			Supply supply = supplyService.queryByemail(email);
			if(supply==null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"noemail\"}");
				return;
			}
			Supply supply1	= supplyService.queryByNoPwd(email, Encrypt.encrypt(pwd));
			if(supply1==null){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"password\"}");
				return;
			}
			if(supply1.getStatus().equals("N")){
				resp.setContentType(Constants.JSON_COnTENT_TYPE);
				out.write("{\"info\":\"forbidden\"}");
				return;
			}
			if(supply1.getChecked().equals("N")){
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
			session.setAttribute("supply1", supply1);
			supplyService.updatelast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"), supply1.getId());
			out.write("{\"info\":\"succeed\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
			return;
		}
	}

	/**
	 * 注册验证
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
		Supply supply = supplyService.queryByemail(email);
		if(supply!=null){
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
			Supply sup = new Supply();
			sup.setEmail(email);
			sup.setPassword(Encrypt.encrypt(pwd1));
			sup.setName(name);
			sup.setPrincipal("负责人");
			sup.setLogo("公司logo图片");
			sup.setAddress("地址");
			sup.setPhone("手机号");
			sup.setTel("固定电话");
			sup.setOpen_date(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			sup.setLongitude(0);
			sup.setLatitude(0);
			sup.setDes("描述");
			sup.setCreated_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			sup.setChecked("N");
			sup.setChecked_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			sup.setLast_login_time(DateUtil.parseDate(DataTime.time(), "yyyy-MM-dd HH:mm:ss"));
			sup.setStatus("N");
			supplyService.add(sup);
			out.write("{\"info\":\"succeed\"}");
		}else {
			resp.setContentType(Constants.JSON_COnTENT_TYPE);
			out.write("{\"info\":\"defeated\"}");
			return;
		}
	}
}
