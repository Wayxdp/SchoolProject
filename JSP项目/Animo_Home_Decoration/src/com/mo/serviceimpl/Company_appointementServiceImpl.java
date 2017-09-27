package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_appointment;
import com.mo.dao.Company_appointementDAO;
import com.mo.daoimpl.Company_appointmentDAOImpl;
import com.mo.service.Company_appointmentService;

public class Company_appointementServiceImpl implements Company_appointmentService{

	private Company_appointementDAO com_appointmentDAO;
	
	public Company_appointementServiceImpl() {
		com_appointmentDAO = new Company_appointmentDAOImpl();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return com_appointmentDAO.count();
	}

//	@Override
//	public List<Company_appointment> queryByPager(int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return com_appointmentDAO.queryByPager(pageNo, pageSize);
//	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		com_appointmentDAO.deleteById(id);
	}


	@Override
	public void addcompany(Company_appointment t) {
		// TODO Auto-generated method stub
		com_appointmentDAO.addcompany(t);
	}

	@Override
	public int getCount(String company_id) {
		// TODO Auto-generated method stub
		return com_appointmentDAO.getCount(company_id);
	}

	@Override
	public List<Company_appointment> queryByPager(int pageNo, int pageSize, String company_id) {
		// TODO Auto-generated method stub
		return com_appointmentDAO.queryByPager(pageNo, pageSize, company_id);
	}

//	@Override
//	public List<Company_appointment> queryAll() {
//		// TODO Auto-generated method stub
//		return com_appointmentDAO.queryAll();
//	}

	@Override
	public void add(Company_appointment t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Company_appointment t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company_appointment queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company_appointment> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company_appointment> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
