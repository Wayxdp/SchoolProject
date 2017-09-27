package com.mo.serviceimpl;

import java.util.Date;
import java.util.List;

import com.mo.bean.Admin;
import com.mo.dao.AdminDAO;
import com.mo.daoimpl.AdminDAOImpl;
import com.mo.service.AdminService;

public class AdminServiceImpl implements AdminService{
	
	private AdminDAO adminDAO;
	
	public AdminServiceImpl(){
		adminDAO = new AdminDAOImpl();
	}
	
	@Override
	public List<Admin> queryAll() {
		return adminDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return adminDAO.count();
	}

	@Override
	public List<Admin> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return adminDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void add(Admin t) {
		// TODO Auto-generated method stub
		adminDAO.add(t);
	}

	@Override
	public void deleteById(String id) {
		adminDAO.deleteById(id);
	}

	@Override
	public void update(Admin t) {
		// TODO Auto-generated method stub
		adminDAO.update(t);
	}

	@Override
	public Admin queryByNoPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return adminDAO.queryByNoPwd(email, pwd);
	}

	@Override
	public Admin queryById(String id) {
		// TODO Auto-generated method stub
		return adminDAO.queryById(id);
	}

	@Override
	public void updatepwd(String t, String id) {
		// TODO Auto-generated method stub
		adminDAO.updatepwd(t,id);
	}

	@Override
	public void updaterole(String id, String status) {
		// TODO Auto-generated method stub
		adminDAO.updaterole(id, status);
	}

	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		// TODO Auto-generated method stub
		adminDAO.updatelast_login_time(last_login_time, id);
	}

	@Override
	public Admin queryByemail(String email) {
		// TODO Auto-generated method stub
		return adminDAO.queryByemail(email);
	}

}
