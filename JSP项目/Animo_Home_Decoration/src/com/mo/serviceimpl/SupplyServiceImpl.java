package com.mo.serviceimpl;

import java.util.Date;
import java.util.List;

import com.mo.bean.Supply;
import com.mo.bean.SupplyAndProduct;
import com.mo.dao.SupplyDAO;
import com.mo.daoimpl.SupplyDAOImpl;
import com.mo.service.SupplyService;

public class SupplyServiceImpl implements SupplyService{
	
	private SupplyDAO supplyDAO;
	
	public SupplyServiceImpl(){
		supplyDAO = new SupplyDAOImpl();
	}
	@Override
	public List<Supply> queryAll() {
		// TODO Auto-generated method stub
		return supplyDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return supplyDAO.count();
	}

	@Override
	public List<Supply> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return supplyDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		supplyDAO.deleteById(id);
	}


	@Override
	public void add(Supply t) {
		// TODO Auto-generated method stub
		supplyDAO.add(t);
	}

	@Override
	public void update(Supply t) {
		// TODO Auto-generated method stub
		supplyDAO.update(t);
	}
	@Override
	public Supply queryById(String id) {
		// TODO Auto-generated method stub
		return supplyDAO.queryById(id);
	}
	@Override
	public Supply queryByemail(String email) {
		// TODO Auto-generated method stub
		return supplyDAO.queryByemail(email);
	}
	@Override
	public Supply queryByNoPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return supplyDAO.queryByNoPwd(email, pwd);
	}
	@Override
	public void updatechecked_time(Date checked_time, String id) {
		// TODO Auto-generated method stub
		supplyDAO.updatechecked_time(checked_time, id);
	}
	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		// TODO Auto-generated method stub
		supplyDAO.updatelast_login_time(last_login_time, id);
	}
	@Override
	public void updatestatus(String status,String checked , String id) {
		// TODO Auto-generated method stub
		supplyDAO.updatestatus(status,checked, id);
	}
	@Override
	public void updatepwd(String id, String pwd) {
		// TODO Auto-generated method stub
		supplyDAO.updatepwd(id, pwd);
	}
	@Override
	public List<Supply> queryByPager1(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return supplyDAO.queryByPager1(pageNo, pageSize);
	}
	@Override
	public List<Supply> top3all() {
		// TODO Auto-generated method stub
		return supplyDAO.top3all();
	}
	@Override
	public SupplyAndProduct queryBysupply_idAndproduct_id(String supply_id, String product_id) {
		// TODO Auto-generated method stub
		return supplyDAO.queryBysupply_idAndproduct_id(supply_id, product_id);
	}
	
}
