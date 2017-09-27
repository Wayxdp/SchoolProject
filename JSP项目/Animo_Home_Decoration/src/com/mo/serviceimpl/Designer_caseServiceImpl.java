package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.Designer_case;
import com.mo.dao.Designer_caseDAO;
import com.mo.daoimpl.Designer_caseDAOImpl;
import com.mo.service.Designer_caseService;

public class Designer_caseServiceImpl implements Designer_caseService{

	
	private Designer_caseDAO designer_caseDAO;
	
	
	public Designer_caseServiceImpl(){
		designer_caseDAO = new Designer_caseDAOImpl();
	}
	@Override
	public List<Designer_case> queryAll() {
		// TODO Auto-generated method stub
		return designer_caseDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return designer_caseDAO.count();
	}

	@Override
	public List<Designer_case> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return designer_caseDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		designer_caseDAO.deleteById(id);
	}

	@Override
	public void add(Designer_case t) {
		// TODO Auto-generated method stub
		designer_caseDAO.add(t);
	}
	@Override
	public void update(Designer_case t) {
		// TODO Auto-generated method stub
		designer_caseDAO.update(t);
	}
	@Override
	public Designer_case queryById(String id) {
		// TODO Auto-generated method stub
		return designer_caseDAO.queryById(id);
	}
	@Override
	public List<Designer_case> queryByPager(int pageNo, int pageSize, String company_id) {
		// TODO Auto-generated method stub
		return designer_caseDAO.queryByPager(pageNo, pageSize, company_id);
	}
	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		designer_caseDAO.updateStatus(id, status);
	}
	@Override
	public int queryCount(String designer_id) {
		// TODO Auto-generated method stub
		return designer_caseDAO.queryCount(designer_id);
	}

}
