package com.xy.service;

import java.io.Serializable;
import java.util.List;

import com.xy.bean.Company;

public interface BaseDaoService <PK extends Serializable, T>{
	
	public void add(T t);
	
	public void del(PK id);
	
	public List<T> queryAll();
	
	public void update(T t);
	
	public T queryEmialAndPwd(String email, String pwd);
	
	public void updatePwd(T t);
}
