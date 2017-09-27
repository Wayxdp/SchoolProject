package com.mo.dao;

import java.util.List;

import com.mo.bean.CustomerAndDesignerAndDesigner_case;
import com.mo.bean.Designer_case;
import com.mo.bean.Designer_case_col;
/**
 * 设计师案例收藏
 * @author Animo
 *
 */
public interface Designer_case_colDAO extends BaseDAO<String, Designer_case_col>{
	public List<CustomerAndDesignerAndDesigner_case> queryByPager(int pageNo, int pageSize,String customer_id) ;
	public int getCount(String customer_id);
	public Designer_case_col queryById(String customer,String caseid);
}
