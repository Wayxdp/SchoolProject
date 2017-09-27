package com.mo.service;

import java.util.List;

import com.mo.bean.Product;
import com.mo.bean.SupplyAndProduct;

public interface ProductService extends BaseService<String, Product>{
	public List<Product> queryByPager(int pageNo, int pageSize, String supply_id);
	public void updateStatus(String id, String status);
	public List<Product> top3Allproduct();
	public int queryCount(String supply_id);
	public List<SupplyAndProduct> queryByPagercase(int pageNo, int pageSize);
	public Product queryBySupply_id(String supply_id);
}
