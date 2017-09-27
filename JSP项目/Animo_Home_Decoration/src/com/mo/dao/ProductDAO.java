package com.mo.dao;

import java.util.List;

import com.mo.bean.Product;
import com.mo.bean.SupplyAndProduct;
/**
 * 建材
 * @author Animo
 *
 */
public interface ProductDAO extends BaseDAO<String, Product>{
	public List<Product> queryByPager(int pageNo, int pageSize, String supply_id);
	public void updateStatus(String id, String status);
	public List<Product> top3Allproduct();
	public int queryCount(String supply_id);
	public List<SupplyAndProduct> queryByPagercase(int pageNo, int pageSize);
	public Product queryBySupply_id(String supply_id);
}
