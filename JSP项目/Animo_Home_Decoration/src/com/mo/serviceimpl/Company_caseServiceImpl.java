package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.CompanycaseAndCompany;
import com.mo.bean.Designer_case;
import com.mo.dao.Company_caseDAO;
import com.mo.daoimpl.Company_caseDAOImpl;
import com.mo.service.Company_caseService;

public class Company_caseServiceImpl implements Company_caseService{
	
	private Company_caseDAO company_caseDAO;
	
	public Company_caseServiceImpl(){
		company_caseDAO = new Company_caseDAOImpl();
	}
	
	@Override
	public List<Company_case> queryAll() {
		// TODO Auto-generated method stub
		return company_caseDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return company_caseDAO.count();
	}

	@Override
	public List<Company_case> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return company_caseDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		company_caseDAO.deleteById(id);
	}

	@Override
	public void add(Company_case t) {
		// TODO Auto-generated method stub
		company_caseDAO.add(t);
	}

	@Override
	public void update(Company_case t) {
		// TODO Auto-generated method stub
		company_caseDAO.update(t);
	}

	@Override
	public Company_case queryById(String id) {
		// TODO Auto-generated method stub
		return company_caseDAO.queryById(id);
	}

	@Override
	public List<Company_case> queryByPager(int pageNo, int pageSize, String company_id) {
		// TODO Auto-generated method stub
		return company_caseDAO.queryByPager(pageNo, pageSize, company_id);
	}

	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		company_caseDAO.updateStatus(id, status);
	}

	@Override
	public List<Company_case> top3all() {
		// TODO Auto-generated method stub
		return company_caseDAO.top3all();
	}

	@Override
	public int queryCount(String company_id) {
		// TODO Auto-generated method stub
		return company_caseDAO.queryCount(company_id);
	}

	@Override
	public List<CompanycaseAndCompany> queryByPagercase(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return company_caseDAO.queryByPagercase(pageNo, pageSize);
	}


}
