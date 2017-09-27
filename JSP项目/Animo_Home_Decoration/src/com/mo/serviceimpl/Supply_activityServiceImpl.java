package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Supply_activity;
import com.mo.dao.Supply_activityDAO;
import com.mo.daoimpl.Supply_activityDAOImpl;
import com.mo.service.Supply_activityService;

public class Supply_activityServiceImpl implements Supply_activityService{
	private Supply_activityDAO supply_activityDAO;
	
	public Supply_activityServiceImpl(){
		supply_activityDAO = new Supply_activityDAOImpl();
	}
	@Override
	public List<Supply_activity> queryAll() {
		// TODO Auto-generated method stub
		return supply_activityDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return supply_activityDAO.count();
	}

	@Override
	public List<Supply_activity> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return supply_activityDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		supply_activityDAO.deleteById(id);
	}
	@Override
	public void add(Supply_activity t) {
		// TODO Auto-generated method stub
		supply_activityDAO.add(t);
	}
	@Override
	public void update(Supply_activity t) {
		// TODO Auto-generated method stub
		supply_activityDAO.update(t);
	}
	@Override
	public Supply_activity queryById(String id) {
		// TODO Auto-generated method stub
		return supply_activityDAO.queryById(id);
	}
	@Override
	public List<Supply_activity> queryByPager(int pageNo, int pageSize, String supply_id) {
		// TODO Auto-generated method stub
		return supply_activityDAO.queryByPager(pageNo, pageSize, supply_id);
	}
	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		supply_activityDAO.updateStatus(id, status);
	}
	@Override
	public List<Supply_activity> pastqueryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return supply_activityDAO.pastqueryByPager(pageNo, pageSize);
	}

}
