package com.mo.dao;

import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.Designer_case;
/**
 * 设计师案例
 * @author Animo
 *
 */
public interface Designer_caseDAO extends BaseDAO<String, Designer_case>{
	public List<Designer_case> queryByPager(int pageNo, int pageSize,String company_id);
	public void updateStatus(String id, String status);
	public int queryCount(String designer_id);
	
}
