package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Product;
import com.mo.bean.SupplyAndProduct;
import com.mo.dao.ProductDAO;
import com.mo.daoimpl.ProductDAOImpl;
import com.mo.service.ProductService;

public class ProductServiceImpl implements ProductService{
	private ProductDAO productDAO;
	
	public ProductServiceImpl(){
		productDAO = new ProductDAOImpl();
	}
	@Override
	public List<Product> queryAll() {
		// TODO Auto-generated method stub
		return productDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return productDAO.count();
	}

	@Override
	public List<Product> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return productDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		productDAO.deleteById(id);
	}

	@Override
	public void add(Product t) {
		// TODO Auto-generated method stub
		productDAO.add(t);
	}
	@Override
	public void update(Product t) {
		// TODO Auto-generated method stub
		productDAO.update(t);
	}
	@Override
	public Product queryById(String id) {
		// TODO Auto-generated method stub
		return productDAO.queryById(id);
	}
	@Override
	public List<Product> queryByPager(int pageNo, int pageSize, String supply_id) {
		// TODO Auto-generated method stub
		return productDAO.queryByPager(pageNo, pageSize, supply_id);
	}
	@Override
	public void updateStatus(String id, String status) {
		// TODO Auto-generated method stub
		productDAO.updateStatus(id, status);
	}
	@Override
	public List<Product> top3Allproduct() {
		// TODO Auto-generated method stub
		return productDAO.top3Allproduct();
	}
	@Override
	public int queryCount(String supply_id) {
		// TODO Auto-generated method stub
		return productDAO.queryCount(supply_id);
	}
	@Override
	public List<SupplyAndProduct> queryByPagercase(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return productDAO.queryByPagercase(pageNo, pageSize);
	}
	@Override
	public Product queryBySupply_id(String supply_id) {
		// TODO Auto-generated method stub
		return productDAO.queryBySupply_id(supply_id);
	}

}
