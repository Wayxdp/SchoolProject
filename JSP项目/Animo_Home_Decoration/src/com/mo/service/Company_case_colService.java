package com.mo.service;

import java.util.List;

import com.mo.bean.Company_case_col;
import com.mo.bean.Compnay_caseAndCustomerAndCompany;

public interface Company_case_colService extends BaseService<String, Company_case_col>{
	public Company_case_col queryById(String customer,String caseid);
	public List<Compnay_caseAndCustomerAndCompany> queryByPager(int pageNo, int pageSize,String customer_id) ;
	public int getCount(String customer_id);
}
