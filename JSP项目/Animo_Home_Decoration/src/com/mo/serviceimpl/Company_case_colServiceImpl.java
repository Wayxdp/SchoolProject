package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_case_col;
import com.mo.bean.Compnay_caseAndCustomerAndCompany;
import com.mo.dao.Company_case_colDAO;
import com.mo.daoimpl.Company_case_colDAOImpl;
import com.mo.service.Company_case_colService;

public class Company_case_colServiceImpl implements Company_case_colService{

	private Company_case_colDAO company_case_colDAO ;
	
	public Company_case_colServiceImpl(){
		company_case_colDAO  = new Company_case_colDAOImpl();
	}
	
	@Override
	public List<Company_case_col> queryAll() {
		// TODO Auto-generated method stub
		return company_case_colDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return company_case_colDAO.count();
	}

	@Override
	public List<Company_case_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return company_case_colDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		company_case_colDAO.deleteById(id);
	}


	@Override
	public void add(Company_case_col t) {
		// TODO Auto-generated method stub
		company_case_colDAO.add(t);
	}

	@Override
	public void update(Company_case_col t) {
		// TODO Auto-generated method stub
		company_case_colDAO.update(t);
	}

	@Override
	public Company_case_col queryById(String id) {
		// TODO Auto-generated method stub
		return company_case_colDAO.queryById(id);
	}

	@Override
	public Company_case_col queryById(String customer, String caseid) {
		// TODO Auto-generated method stub
		return company_case_colDAO.queryById(customer, caseid);
	}

	@Override
	public List<Compnay_caseAndCustomerAndCompany> queryByPager(int pageNo, int pageSize, String customer_id) {
		// TODO Auto-generated method stub
		return company_case_colDAO.queryByPager(pageNo, pageSize, customer_id);
	}

	@Override
	public int getCount(String customer_id) {
		// TODO Auto-generated method stub
		return company_case_colDAO.getCount(customer_id);
	}
	
}
