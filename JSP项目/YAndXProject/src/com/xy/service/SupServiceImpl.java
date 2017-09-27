package com.xy.service;

import java.util.List;

import com.xy.bean.Supply;
import com.xy.dao.SupBaseDao;
import com.xy.dao.SupBaseDaoImpl;

public class SupServiceImpl implements SupService{

	SupBaseDao supBaseDao;
	
	public SupServiceImpl() {
		supBaseDao = new SupBaseDaoImpl();
	}
	
	@Override
	public void add(Supply t) {
		supBaseDao.add(t);
	}

	@Override
	public void del(Integer id) {
		supBaseDao.del(id);
	}

	@Override
	public List<Supply> queryAll() {
		return supBaseDao.queryAll();
	}

	@Override
	public void update(Supply sup) {
		supBaseDao.update(sup);
	}

	@Override
	public Supply queryEmialAndPwd(String email, String pwd) {
		return supBaseDao.queryEmialAndPwd(email, pwd);
	}

	@Override
	public void updatePwd(Supply t) {
		supBaseDao.updatePwd(t);
	}


}
