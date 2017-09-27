package com.mo.service;

import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.Designer_case;

public interface Designer_caseService extends BaseService<String, Designer_case>{
	public List<Designer_case> queryByPager(int pageNo, int pageSize,String company_id);
	public void updateStatus(String id, String status);
	public int queryCount(String designer_id);
}
