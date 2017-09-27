package com.mo.dao;

import java.util.List;

import com.mo.bean.Designer_col;
/**
 * 设计师收藏
 * @author Animo
 *
 */
import com.mo.bean.DesignercaseAndDesigner;
public interface Designer_colDAO extends BaseDAO<String, Designer_col>{
	public Designer_col queryBycustomerIdBydesignerId(String customerid,String desingerid);
	public List<DesignercaseAndDesigner> queryByCustomerid(int pageNo, int pageSize, String customerid);
	public int getconn(String customerid);
}
