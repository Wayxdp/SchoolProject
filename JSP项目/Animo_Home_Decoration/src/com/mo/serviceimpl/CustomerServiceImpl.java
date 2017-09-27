package com.mo.serviceimpl;

import java.util.Date;
import java.util.List;

import com.mo.bean.Customer;
import com.mo.dao.CustomerDAO;
import com.mo.daoimpl.CustomerDAOImpl;
import com.mo.service.CustomerService;

public class CustomerServiceImpl implements CustomerService{
	
	private CustomerDAO customerDAO;
	
	public CustomerServiceImpl(){
		customerDAO = new CustomerDAOImpl();
	}
	
	@Override
	public List<Customer> queryAll() {
		// TODO Auto-generated method stub
		return customerDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return customerDAO.count();
	}

	@Override
	public List<Customer> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return customerDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		customerDAO.deleteById(id);
	}

	@Override
	public void add(Customer t) {
		// TODO Auto-generated method stub
		customerDAO.add(t);
	}

	@Override
	public void update(Customer t) {
		// TODO Auto-generated method stub
		customerDAO.update(t);
	}

	@Override
	public Customer queryById(String id) {
		// TODO Auto-generated method stub
		return customerDAO.queryById(id);
	}

	@Override
	public Customer queryByemail(String email) {
		// TODO Auto-generated method stub
		return customerDAO.queryByemail(email);
	}

	@Override
	public Customer queryByNoPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return customerDAO.queryByNoPwd(email, pwd);
	}


	@Override
	public void updatepwd(String id, String pwd) {
		// TODO Auto-generated method stub
		customerDAO.updatepwd(id, pwd);
	}

	@Override
	public void updatechecked_time(Date checked_time, String id) {
		// TODO Auto-generated method stub
		customerDAO.updatechecked_time(checked_time, id);
	}

	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		// TODO Auto-generated method stub
		customerDAO.updatelast_login_time(last_login_time, id);
	}

	@Override
	public void updatestatus(String status, String id) {
		// TODO Auto-generated method stub
		customerDAO.updatestatus(status, id);
	}

}
