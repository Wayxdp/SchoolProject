package com.mo.dao;

import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.Company_col;
import com.mo.bean.Company_colAndCompany;
import com.mo.bean.Designer;
/**
 * 装修公司收藏
 * @author Animo
 *
 */
public interface Company_colDAO extends BaseDAO<String, Company_col>{
	public Company_col queryBycustomerIdBycompanyId(String customerid, String companyid);
	public int getconn(String customerid);
	public List<Company_colAndCompany> queryByCustomerid(int pageNo, int pageSize,String customerid);
}
