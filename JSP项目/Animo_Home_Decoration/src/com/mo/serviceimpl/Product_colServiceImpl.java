package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.CustomerAndProductAndProduct_col;
import com.mo.bean.Designer_col;
import com.mo.bean.Product_col;
import com.mo.dao.Product_colDAO;
import com.mo.daoimpl.Product_colDAOImpl;
import com.mo.service.Product_colService;

public class Product_colServiceImpl implements Product_colService{
	private Product_colDAO product_colDAO;
	
	public Product_colServiceImpl(){
		product_colDAO = new Product_colDAOImpl();
	}
	@Override
	public List<Product_col> queryAll() {
		// TODO Auto-generated method stub
		return product_colDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return product_colDAO.count();
	}

	@Override
	public List<Product_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return product_colDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		product_colDAO.deleteById(id);
	}
	@Override
	public void add(Product_col t) {
		// TODO Auto-generated method stub
		product_colDAO.add(t);
	}
	@Override
	public void update(Product_col t) {
		// TODO Auto-generated method stub
		product_colDAO.update(t);
	}
	@Override
	public Product_col queryById(String id) {
		// TODO Auto-generated method stub
		return product_colDAO.queryById(id);
	}
	@Override
	public Product_col queryBycustomerIdBysupplyId(String customerid, String supplyid) {
		// TODO Auto-generated method stub
		return product_colDAO.queryBycustomerIdBysupplyId(customerid, supplyid);
	}
	@Override
	public int getconn(String customerid) {
		// TODO Auto-generated method stub
		return product_colDAO.getconn(customerid);
	}
	@Override
	public List<CustomerAndProductAndProduct_col> queryByPager(int pageNo, int pageSize, String customer_id) {
		// TODO Auto-generated method stub
		return product_colDAO.queryByPager(pageNo, pageSize, customer_id);
	}

}
