package com.xy.service;

import java.util.List;

import com.xy.bean.Designer;
import com.xy.dao.DesBaseDao;
import com.xy.dao.DesBaseDaoImpl;

public class DesServiceImpl implements DesService{
	
	DesBaseDao desBaseDao;

	public DesServiceImpl() {
		desBaseDao = new DesBaseDaoImpl();
	}

	@Override
	public void add(Designer t) {
		desBaseDao.add(t);
	}

	@Override
	public void del(Integer id) {
		desBaseDao.del(id);
	}

	@Override
	public List<Designer> queryAll() {
		return desBaseDao.queryAll();
	}

	@Override
	public void update(Designer des) {
		desBaseDao.update(des);
	}

	@Override
	public Designer queryEmialAndPwd(String email, String pwd) {
		return desBaseDao.queryEmialAndPwd(email, pwd);
	}

	@Override
	public void updatePwd(Designer t) {
		desBaseDao.updatePwd(t);
	}



}
