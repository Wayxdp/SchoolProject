package com.mo.serviceimpl;

import java.util.Date;
import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.Company_case;
import com.mo.bean.CompanycaseAndCompany;
import com.mo.dao.CompanyDAO;
import com.mo.daoimpl.CompanyDAOImpl;
import com.mo.service.CompanyService;

public class CompanyServiceImpl implements CompanyService{
	
	private CompanyDAO companyDAO; 
	
	public CompanyServiceImpl(){
		companyDAO = new CompanyDAOImpl();
	}	
	@Override
	public List<Company> queryAll() {
		// TODO Auto-generated method stub
		return companyDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return companyDAO.count();
	}

	@Override
	public List<Company> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return companyDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		companyDAO.deleteById(id);
	}

	@Override
	public void add(Company t) {
		// TODO Auto-generated method stub
		companyDAO.add(t);
	}
	@Override
	public void update(Company t) {
		// TODO Auto-generated method stub
		companyDAO.update(t);
	}
	@Override
	public Company queryById(String id) {
		// TODO Auto-generated method stub
		return companyDAO.queryById(id);
	}
	@Override
	public Company queryByemail(String email) {
		// TODO Auto-generated method stub
		return companyDAO.queryByemail(email);
	}
	@Override
	public Company queryByNoPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return companyDAO.queryByNoPwd(email, pwd);
	}
	@Override
	public void updatechecked_time(Date checked_time, String id) {
		// TODO Auto-generated method stub
		companyDAO.updatechecked_time(checked_time, id);
	}
	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		// TODO Auto-generated method stub
		companyDAO.updatelast_login_time(last_login_time, id);
	}
	@Override
	public void updatestatus(String status,String checked , String id) {
		// TODO Auto-generated method stub
		companyDAO.updatestatus(status,checked, id);
	}
	@Override
	public void updatepwd(String id, String pwd) {
		// TODO Auto-generated method stub
		companyDAO.updatepwd(id, pwd);
	}
	@Override
	public List<Company> queryByPager1(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return companyDAO.queryByPager1(pageNo, pageSize);
	}
	@Override
	public List<Company> top3all() {
		// TODO Auto-generated method stub
		return companyDAO.top3all();
	}
	@Override
	public CompanycaseAndCompany queryByCompany_idAndCase_id(String caseid, String Company_id) {
		// TODO Auto-generated method stub
		return companyDAO.queryByCompany_idAndCase_id(caseid, Company_id);
	}

}
