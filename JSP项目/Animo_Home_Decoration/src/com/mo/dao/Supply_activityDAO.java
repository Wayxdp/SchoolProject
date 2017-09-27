package com.mo.dao;

import java.util.List;

import com.mo.bean.Supply_activity;

public interface Supply_activityDAO extends BaseDAO<String , Supply_activity>{
	 public List<Supply_activity> queryByPager(int pageNo, int pageSize, String supply_id);
	 public void updateStatus(String id, String status);
	 public List<Supply_activity> pastqueryByPager(int pageNo, int pageSize);
}
