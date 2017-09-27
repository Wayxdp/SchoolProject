package com.mo.dao;

import java.io.Serializable;
import java.util.List;


public interface BaseDAO<PK extends Serializable, T> {
	
	public List<T> queryAll();//查询所有用户返回List集合
	
	public int count();//查询数据库表单中的用户数量
	
	public List<T> queryByPager(int pageNo, int pageSize);//分页查询  传参：页码 --每页显示个数

	public void add(T t);//添加用户
	
	public void deleteById(String id);//根据ID来删除用户
	
	public void update(T t);//更新用户
	
	public T queryById(String id);//根据id来查询用户
	
}
