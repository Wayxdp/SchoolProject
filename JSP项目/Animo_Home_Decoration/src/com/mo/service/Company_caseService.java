package com.mo.service;

import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.CompanycaseAndCompany;
import com.mo.bean.Designer_case;

public interface Company_caseService extends BaseService<String, Company_case>{
	public List<Company_case> queryByPager(int pageNo, int pageSize,String company_id);
	 public void updateStatus(String id, String status);
	 public List<Company_case> top3all();
	 public int queryCount(String company_id);
	 public List<CompanycaseAndCompany> queryByPagercase(int pageNo, int pageSize);
}
