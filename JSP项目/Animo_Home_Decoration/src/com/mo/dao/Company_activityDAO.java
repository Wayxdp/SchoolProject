package com.mo.dao;

import java.util.List;

import com.mo.bean.Company_activity;
/**
 * 装修公司活动表
 * @author Animo
 *
 */
public interface Company_activityDAO extends BaseDAO<String, Company_activity>{
	public void updateStatus(String id, String status);
	 public List<Company_activity> queryByPager(int pageNo, int pageSize, String company_id);
	 public List<Company_activity> pastqueryByPager(int pageNo, int pageSize);
}
