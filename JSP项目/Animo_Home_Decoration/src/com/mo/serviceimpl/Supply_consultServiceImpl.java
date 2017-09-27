package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Supply_consult;
import com.mo.dao.Supply_consultDAO;
import com.mo.daoimpl.Supply_consultDAOImpl;
import com.mo.service.Supply_consultService;

public class Supply_consultServiceImpl implements Supply_consultService{

	private Supply_consultDAO consultDAO;
	
	public Supply_consultServiceImpl() {
		consultDAO = new Supply_consultDAOImpl();
	}
	
	@Override
	public List<Supply_consult> queryAll() {
		// TODO Auto-generated method stub
		return consultDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return consultDAO.count();
	}

	@Override
	public List<Supply_consult> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return consultDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void add(Supply_consult t) {
		// TODO Auto-generated method stub
		consultDAO.add(t);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		consultDAO.deleteById(id);
	}

	@Override
	public void update(Supply_consult t) {
		// TODO Auto-generated method stub
		consultDAO.update(t);
	}

	@Override
	public Supply_consult queryById(String id) {
		// TODO Auto-generated method stub
		return consultDAO.queryById(id);
	}

}
