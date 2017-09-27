package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Designer_col;
import com.mo.bean.DesignercaseAndDesigner;
import com.mo.dao.Designer_colDAO;
import com.mo.daoimpl.Designer_colDAOImpl;
import com.mo.service.Designer_colService;

public class Designer_colServiceImpl implements Designer_colService{

	private Designer_colDAO designer_colDAO;
	
	public Designer_colServiceImpl(){
		designer_colDAO = new Designer_colDAOImpl();
	}
	@Override
	public List<Designer_col> queryAll() {
		// TODO Auto-generated method stub
		return designer_colDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return designer_colDAO.count();
	}

	@Override
	public List<Designer_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return designer_colDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		designer_colDAO.deleteById(id);
	}

	@Override
	public void add(Designer_col t) {
		// TODO Auto-generated method stub
		designer_colDAO.add(t);
	}
	@Override
	public void update(Designer_col t) {
		// TODO Auto-generated method stub
		designer_colDAO.update(t);
	}
	@Override
	public Designer_col queryById(String id) {
		// TODO Auto-generated method stub
		return designer_colDAO.queryById(id);
	}
	@Override
	public Designer_col queryBycustomerIdBydesignerId(String customerid, String desingerid) {
		// TODO Auto-generated method stub
		return designer_colDAO.queryBycustomerIdBydesignerId(customerid, desingerid);
	}
	@Override
	public List<DesignercaseAndDesigner> queryByCustomerid(int pageNo, int pageSize,String customerid) {
		// TODO Auto-generated method stub
		return designer_colDAO.queryByCustomerid(pageNo,pageSize,customerid);
	}
	@Override
	public int getconn(String customerid) {
		// TODO Auto-generated method stub
		return designer_colDAO.getconn(customerid);
	}

}
