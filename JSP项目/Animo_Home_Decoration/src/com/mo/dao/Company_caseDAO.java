package com.mo.dao;

import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.CompanycaseAndCompany;
/**
 * 装修公司案例
 * @author Animo
 *
 */
public interface Company_caseDAO extends BaseDAO<String, Company_case>{
	public List<Company_case> queryByPager(int pageNo, int pageSize,String desinger_id);
	public void updateStatus(String id, String status);
	public List<Company_case> top3all();
	public int queryCount(String company_id);
	public List<CompanycaseAndCompany> queryByPagercase(int pageNo, int pageSize);
}
