package com.xy.service;

import java.util.List;

import com.xy.bean.Company;
import com.xy.dao.ComBaseDao;
import com.xy.dao.ComBaseDaoImpl;

public class ComServiceImpl implements ComService{
	
	ComBaseDao company;
	
	public ComServiceImpl() {
		company = new ComBaseDaoImpl();
	}
	
	@Override
	public void del(Integer id) {
		company.del(id);
	}
	@Override
	public void add(Company t) {
		company.add(t);
	}

	@Override
	public List<Company> queryAll() {
		return company.queryAll();
	}

	@Override
	public void update(Company com) {
		company.update(com);
	}

	@Override
	public Company queryEmialAndPwd(String email, String pwd) {
		return company.queryEmialAndPwd(email, pwd);
	}

	@Override
	public void updatePwd(Company com) {
		company.updatePwd(com);
	}
}
