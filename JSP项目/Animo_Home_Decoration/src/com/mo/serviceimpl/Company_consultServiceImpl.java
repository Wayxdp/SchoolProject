package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_consult;
import com.mo.dao.Company_consultDAO;
import com.mo.daoimpl.Company_consultDAOImpl;
import com.mo.service.Company_consultService;

public class Company_consultServiceImpl implements Company_consultService{

	private Company_consultDAO consultDAO;
	
	public Company_consultServiceImpl() {
		consultDAO = new Company_consultDAOImpl();
		
	}
	
	
	@Override
	public List<Company_consult> queryAll() {
		// TODO Auto-generated method stub
		return consultDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return consultDAO.count();
	}

	@Override
	public List<Company_consult> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return consultDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void add(Company_consult t) {
		// TODO Auto-generated method stub
		consultDAO.add(t);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		consultDAO.deleteById(id);
	}

	@Override
	public void update(Company_consult t) {
		// TODO Auto-generated method stub
		consultDAO.update(t);
	}

	@Override
	public Company_consult queryById(String id) {
		// TODO Auto-generated method stub
		return consultDAO.queryById(id);
	}

}
