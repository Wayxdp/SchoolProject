package com.mo.dao;

import java.util.List;

import com.mo.bean.CustomerAndProductAndProduct_col;
import com.mo.bean.Product_col;
/**
 * 建材收藏
 * @author Animo
 *
 */
public interface Product_colDAO extends BaseDAO<String, Product_col>{
	public Product_col queryBycustomerIdBysupplyId(String customerid, String supplyid);
	public int getconn(String customerid);
	public List<CustomerAndProductAndProduct_col> queryByPager(int pageNo, int pageSize, String customer_id);
}
