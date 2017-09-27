package com.mo.dao;

import java.util.List;

import com.mo.bean.Supply_col;
import com.mo.bean.Supply_colAndsupply;
/**
 * 建材商收藏
 * @author Animo
 *
 */
public interface Supply_colDAO extends BaseDAO<String, Supply_col>{
	public Supply_col queryBycustomerIdBycompanyId(String customerid, String supplyid);
	public int getconn(String customerid);
	public List<Supply_colAndsupply> queryByCustomerid(int pageNo, int pageSize,String customerid);
}
