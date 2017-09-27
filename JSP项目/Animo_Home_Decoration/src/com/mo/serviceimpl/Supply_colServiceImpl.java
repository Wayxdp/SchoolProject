package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Supply_col;
import com.mo.bean.Supply_colAndsupply;
import com.mo.dao.Supply_colDAO;
import com.mo.daoimpl.Supply_colDAOImpl;
import com.mo.service.Supply_colService;

public class Supply_colServiceImpl implements Supply_colService{
	private Supply_colDAO supply_colDAO;
	
	public Supply_colServiceImpl(){
		supply_colDAO = new Supply_colDAOImpl();
	}
	@Override
	public List<Supply_col> queryAll() {
		// TODO Auto-generated method stub
		return supply_colDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return supply_colDAO.count();
	}

	@Override
	public List<Supply_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return supply_colDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		supply_colDAO.deleteById(id);
	}
	@Override
	public void add(Supply_col t) {
		// TODO Auto-generated method stub
		supply_colDAO.add(t);
	}
	@Override
	public void update(Supply_col t) {
		// TODO Auto-generated method stub
		supply_colDAO.update(t);
	}
	@Override
	public Supply_col queryById(String id) {
		// TODO Auto-generated method stub
		return supply_colDAO.queryById(id);
	}
	@Override
	public Supply_col queryBycustomerIdBycompanyId(String customerid, String supplyid) {
		// TODO Auto-generated method stub
		return supply_colDAO.queryBycustomerIdBycompanyId(customerid, supplyid);
	}
	@Override
	public int getconn(String customerid) {
		// TODO Auto-generated method stub
		return supply_colDAO.getconn(customerid);
	}
	@Override
	public List<Supply_colAndsupply> queryByCustomerid(int pageNo, int pageSize, String customerid) {
		// TODO Auto-generated method stub
		return supply_colDAO.queryByCustomerid(pageNo, pageSize, customerid);
	}


}
