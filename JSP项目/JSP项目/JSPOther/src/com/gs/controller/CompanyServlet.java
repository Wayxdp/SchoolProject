package com.gs.controller;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.gs.bean.Company;
import com.gs.common.FileUtil;
import com.gs.common.WebUtil;
import com.gs.dao.CompanyDAO;

@WebServlet(name="CompanyServlet", urlPatterns={"/company/*"})
public class CompanyServlet extends HttpServlet {

	private static final long serialVersionUID = 1190502606714414697L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String method = WebUtil.getUriMethod(req);
		if (method.equals("add")) {
			add(req, resp);
		} else if (method.equals("all")) {
			CompanyDAO dao = new CompanyDAO();
			req.setAttribute("cs", dao.queryAll());
			req.getRequestDispatcher("/all.jsp").forward(req, resp);
			
		}
	}
	
	/**
	 * @param req
	 * @param resp
	 */
	private void add(HttpServletRequest req, HttpServletResponse resp) {
		// 判断表单是否有文件上传
		if (ServletFileUpload.isMultipartContent(req)) {
			DiskFileItemFactory factory = new DiskFileItemFactory(); // 文件上传的工厂类，工厂类可以指定文件上传的临时目录
			ServletFileUpload upload = new ServletFileUpload(factory); // ServletFileUpload是用来解析request请求，并把表单域和文件输入获取到
			upload.setHeaderEncoding("utf-8");
			Company company = new Company();
			try {
				List<FileItem> items = upload.parseRequest(req); // 开始解析request请求, 把表单域和文件域的内容都获取到
				for (FileItem item : items) {
					if (item.isFormField()) { // 判断是否为表单域
						String name = item.getFieldName(); // 获取jsp页面中表单域的name值 
						if (name.equals("name")) { // 如果这个表单域是name表单域
							System.out.println(item.getString("utf-8")); // 获取输入的姓名
							company.setName(item.getString("utf-8"));
						} else if (name.equals("address")) {
							System.out.println(item.getString("utf-8")); // 获取输入的地址
						}
					} else { // 文件
						String name = item.getFieldName();
						if (name.equals("file")) {
							System.out.println(item.getName()); // 图片的名称
							FileUtil.save(req, item);
							company.setHeadIcon("uploads/" + item.getName());
							CompanyDAO companyDAO = new CompanyDAO();
							companyDAO.add(company);
						} else if (name.equals("file1")) {
							FileUtil.save(req, item);
						}
					}
				}
			} catch (FileUploadException e) {
				e.printStackTrace();
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} 
		}
	}
}
