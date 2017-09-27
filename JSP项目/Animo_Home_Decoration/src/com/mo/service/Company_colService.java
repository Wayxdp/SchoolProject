package com.mo.service;

import java.util.List;

import com.mo.bean.Company_col;
import com.mo.bean.Company_colAndCompany;

public interface Company_colService extends BaseService<String, Company_col>{
	public Company_col queryBycustomerIdBycompanyId(String customerid, String companyid);
	public int getconn(String customerid);
	public List<Company_colAndCompany> queryByCustomerid(int pageNo, int pageSize,String customerid);
}
