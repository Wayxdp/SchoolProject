package com.xy.service;

import java.util.List;
import com.xy.bean.Customer;
import com.xy.dao.CusBaseDao;
import com.xy.dao.CusBaseDaoImpl;

public class CusServiceImpl implements CusService{
	
	CusBaseDao cus;
	
	public CusServiceImpl() {
		cus = new CusBaseDaoImpl();
	}
	@Override
	public void add(Customer t) {
		cus.add(t);
	}

	@Override
	public void del(Integer id) {
		cus.del(id);
	}

	@Override
	public List<Customer> queryAll() {
		return cus.queryAll();
	}


	@Override
	public Customer queryEmialAndPwd(String email, String pwd) {
		return cus.queryEmialAndPwd(email, pwd);
	}
	
	@Override
	public void update(Customer t) {
		cus.update(t);
	}
	@Override
	public void updatePwd(Customer t) {
		cus.updatePwd(t);
	}
	

}
