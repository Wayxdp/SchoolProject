package com.mo.serviceimpl;


import java.util.List;

import com.mo.bean.Designer_consult;
import com.mo.bean.Userconsult;
import com.mo.dao.Designer_consultDAO;
import com.mo.daoimpl.Designer_consultDAOImpl;
import com.mo.service.Designer_consultService;


public class Designer_consultServiceImpl implements Designer_consultService{

	private Designer_consultDAO consultDAO;
	
	public Designer_consultServiceImpl(){
		consultDAO = new Designer_consultDAOImpl();
	}
	@Override
	public List<Designer_consult> queryAll() {
		// TODO Auto-generated method stub
		return consultDAO.queryAll();
	}


	@Override
	public int count() {
		return consultDAO.count();
	}


	@Override
	public List<Designer_consult> queryByPager(int pageNo, int pageSize) {
		return consultDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void add(Designer_consult t) {
		consultDAO.add(t);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		consultDAO.deleteById(id);
	}


	@Override
	public void update(Designer_consult t) {
		// TODO Auto-generated method stub
		consultDAO.update(t);
	}


	@Override
	public Designer_consult queryById(String id) {
		// TODO Auto-generated method stub
		return consultDAO.queryById(id);
	}
	
}
