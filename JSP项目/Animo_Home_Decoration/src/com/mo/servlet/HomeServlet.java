package com.mo.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mo.bean.Company;
import com.mo.bean.Company_case;
import com.mo.bean.Designer;
import com.mo.bean.Designer_case;
import com.mo.bean.Product;
import com.mo.bean.Supply;
import com.mo.common.WebUtil;
import com.mo.daoimpl.Designer_caseDAOImpl;
import com.mo.service.CompanyService;
import com.mo.service.Company_caseService;
import com.mo.service.DesignerService;
import com.mo.service.Designer_caseService;
import com.mo.service.ProductService;
import com.mo.service.SupplyService;
import com.mo.serviceimpl.CompanyServiceImpl;
import com.mo.serviceimpl.Company_caseServiceImpl;
import com.mo.serviceimpl.DesignerServiceImpl;
import com.mo.serviceimpl.Designer_caseServiceImpl;
import com.mo.serviceimpl.ProductServiceImpl;
import com.mo.serviceimpl.SupplyServiceImpl;


public class HomeServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5541980450820486613L;
	private DesignerService designerService;
	private Company_caseService company_caseService;
	private CompanyService companyService;
	private ProductService productService;
	private SupplyService SupplyService;
	public HomeServlet(){
		designerService = new DesignerServiceImpl();
		company_caseService = new Company_caseServiceImpl();
		companyService = new CompanyServiceImpl();
		productService = new ProductServiceImpl();
		SupplyService = new SupplyServiceImpl();
	}
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String Mothed = WebUtil.getUriMethod(req);
		if(Mothed.equals("home")){
			home(req,resp);
		}
	}
	
	private void home(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Designer> designers = designerService.queryAll();
		List<Company_case> Company_cases =  company_caseService.top3all();
		List<Company> companys =  companyService.top3all();
		List<Product> products = productService.top3Allproduct();
		List<Supply> supplys = SupplyService.top3all();
		req.setAttribute("supplys", supplys);
		req.setAttribute("companys", companys);
		req.setAttribute("designers", designers);
		req.setAttribute("products", products);
		req.setAttribute("Company_cases", Company_cases);
		req.getRequestDispatcher("indexskip.jsp").forward(req, resp);
	}
}
