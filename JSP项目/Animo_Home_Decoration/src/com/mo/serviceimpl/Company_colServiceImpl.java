package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.Company_col;
import com.mo.bean.Company_colAndCompany;
import com.mo.bean.Designer;
import com.mo.bean.Designer_col;
import com.mo.dao.Company_colDAO;
import com.mo.daoimpl.Company_colDAOImpl;
import com.mo.service.Company_colService;

public class Company_colServiceImpl implements Company_colService{
	
	private Company_colDAO company_colDAO;
	
	public Company_colServiceImpl(){
		company_colDAO = new Company_colDAOImpl();
	}
	
	@Override
	public List<Company_col> queryAll() {
		// TODO Auto-generated method stub
		return company_colDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return company_colDAO.count();
	}

	@Override
	public List<Company_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return company_colDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		company_colDAO.deleteById(id);
	}


	@Override
	public void add(Company_col t) {
		// TODO Auto-generated method stub
		company_colDAO.add(t);
	}

	@Override
	public void update(Company_col t) {
		// TODO Auto-generated method stub
		company_colDAO.update(t);
	}

	@Override
	public Company_col queryById(String id) {
		// TODO Auto-generated method stub
		return company_colDAO.queryById(id);
	}

	@Override
	public Company_col queryBycustomerIdBycompanyId(String customerid, String companyid) {
		// TODO Auto-generated method stub
		return company_colDAO.queryBycustomerIdBycompanyId(customerid, companyid);
	}

	@Override
	public int getconn(String customerid) {
		// TODO Auto-generated method stub
		return company_colDAO.getconn(customerid);
	}

	@Override
	public List<Company_colAndCompany> queryByCustomerid(int pageNo, int pageSize, String customerid) {
		// TODO Auto-generated method stub
		return company_colDAO.queryByCustomerid(pageNo, pageSize, customerid);
	}


}
