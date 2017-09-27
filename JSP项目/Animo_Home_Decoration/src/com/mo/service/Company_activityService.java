package com.mo.service;

import java.util.List;

import com.mo.bean.Company_activity;

public interface Company_activityService extends BaseService<String, Company_activity>{
	public void updateStatus(String id, String status);
	 public List<Company_activity> queryByPager(int pageNo, int pageSize, String company_id);
	 public List<Company_activity> pastqueryByPager(int pageNo, int pageSize);
}
