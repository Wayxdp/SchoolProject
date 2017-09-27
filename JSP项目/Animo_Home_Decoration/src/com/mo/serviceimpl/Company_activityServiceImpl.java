package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_activity;
import com.mo.dao.Company_activityDAO;
import com.mo.daoimpl.Company_activityDAOImpl;
import com.mo.service.Company_activityService;


public class Company_activityServiceImpl implements Company_activityService{
	
	private Company_activityDAO company_activityDAO;
	
	public Company_activityServiceImpl(){
		company_activityDAO = new Company_activityDAOImpl();
	}
	
	@Override
	public List<Company_activity> queryAll() {
		// TODO Auto-generated method stub
		return company_activityDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return company_activityDAO.count();
	}

	@Override
	public List<Company_activity> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return company_activityDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		company_activityDAO.deleteById(id);
	}


	@Override
	public void add(Company_activity t) {
		// TODO Auto-generated method stub
		company_activityDAO.add(t);
	}

	@Override
	public void update(Company_activity t) {
		// TODO Auto-generated method stub
		company_activityDAO.update(t);
	}

	@Override
	public Company_activity queryById(String id) {
		// TODO Auto-generated method stub
		return company_activityDAO.queryById(id);
	}

	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		company_activityDAO.updateStatus(id, status);
	}

	@Override
	public List<Company_activity> queryByPager(int pageNo, int pageSize, String company_id) {
		// TODO Auto-generated method stub
		return company_activityDAO.queryByPager(pageNo, pageSize, company_id);
	}

	@Override
	public List<Company_activity> pastqueryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return company_activityDAO.pastqueryByPager(pageNo, pageSize);
	}

}
