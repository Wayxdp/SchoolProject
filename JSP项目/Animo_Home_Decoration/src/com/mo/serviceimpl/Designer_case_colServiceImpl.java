package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.CustomerAndDesignerAndDesigner_case;
import com.mo.bean.Designer_case_col;
import com.mo.dao.Designer_case_colDAO;
import com.mo.daoimpl.Designer_case_colDAOImpl;
import com.mo.service.Designer_case_colService;

public class Designer_case_colServiceImpl implements Designer_case_colService{

	
	private Designer_case_colDAO  designer_case_colDAO;
	
	public Designer_case_colServiceImpl(){
		designer_case_colDAO = new Designer_case_colDAOImpl();
	}
	@Override
	public List<Designer_case_col> queryAll() {
		// TODO Auto-generated method stub
		return designer_case_colDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return designer_case_colDAO.count();
	}

	@Override
	public List<Designer_case_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return designer_case_colDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		designer_case_colDAO.deleteById(id);
	}
	@Override
	public void add(Designer_case_col t) {
		// TODO Auto-generated method stub
		designer_case_colDAO.add(t);
	}
	@Override
	public void update(Designer_case_col t) {
		// TODO Auto-generated method stub
		designer_case_colDAO.update(t);
	}
	@Override
	public Designer_case_col queryById(String id) {
		// TODO Auto-generated method stub
		return designer_case_colDAO.queryById(id);
	}
	@Override
	public List<CustomerAndDesignerAndDesigner_case> queryByPager(int pageNo, int pageSize, String customer_id) {
		// TODO Auto-generated method stub
		return designer_case_colDAO.queryByPager(pageNo, pageSize, customer_id);
	}
	@Override
	public int getCount(String customer_id) {
		// TODO Auto-generated method stub
		return designer_case_colDAO.getCount(customer_id);
	}
	@Override
	public Designer_case_col queryById(String customer, String caseid) {
		// TODO Auto-generated method stub
		return designer_case_colDAO.queryById(customer, caseid);
	}

}
