package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.CustomerAndProductAndProduct_col;
import com.mo.bean.Designer_col;
import com.mo.bean.Product_col;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Product_colDAO;

public class Product_colDAOImpl extends AbstractBaseDAO implements Product_colDAO{

	@Override
	public List<Product_col> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Product_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_product_col where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	@Override
	public void add(Product_col t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_product_col(customer_id,product_id,created_time) values(?,?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getProduct_id());
			ps.setTimestamp(3,  DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Product_col t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Product_col queryById(String id) {
		Connection conn =  getConn();
		 Product_col Productcol=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_product_col where product_id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	Productcol = new Product_col();
	            	Productcol.setId(rs.getString("id"));
	            	Productcol.setCustomer_id(rs.getString("customer_id"));
	            	Productcol.setCreated_time(rs.getTimestamp("created_time"));
	            	Productcol.setProduct_id(rs.getString("product_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return Productcol;
	}

	@Override
	public Product_col queryBycustomerIdBysupplyId(String customerid, String supplyid) {
		Connection conn =  getConn();
		 Product_col product_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_product_col where customer_id=? and product_id=?");
	            ps.setString(1,customerid);
	            ps.setString(2, supplyid);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	product_col = new Product_col();
	            	product_col.setId(rs.getString("id"));
	            	product_col.setCustomer_id(rs.getString("customer_id"));
	            	product_col.setCreated_time(rs.getTimestamp("created_time"));
	            	product_col.setProduct_id(rs.getString("product_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return product_col;
	}

	@Override
	public int getconn(String customerid) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_product_col where customer_id=?");
			ps.setString(1, customerid);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return 0;
	}

	@Override
	public List<CustomerAndProductAndProduct_col> queryByPager(int pageNo, int pageSize, String customer_id) {
		Connection conn = getConn();
		 List<CustomerAndProductAndProduct_col> CustomerAndProductAndProduct_cols = new ArrayList<CustomerAndProductAndProduct_col>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from t_product_col a, t_product b, t_supply c where a.product_id = b.id and b.supply_id = c.id and a.customer_id = '"+customer_id+"'  and a.id not in (select top "+(pageNo-1)*pageSize+" a.id from t_designer_case_col a, t_designer_case b, t_designer c  where a.case_id = b.caseid and b.designer_id = c.id and a.customer_id ='"+customer_id+"')order by created_time desc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CustomerAndProductAndProduct_col customerAndProductAndProduct_col = new CustomerAndProductAndProduct_col();
				customerAndProductAndProduct_col.setId(rs.getString("id"));
				customerAndProductAndProduct_col.setSupply_id(rs.getString("supply_id"));
				customerAndProductAndProduct_col.setProductname(rs.getString("productname"));
				customerAndProductAndProduct_col.setPrice(rs.getFloat("price"));
				customerAndProductAndProduct_col.setSale_price(rs.getFloat("sale_price"));
				customerAndProductAndProduct_col.setImage(rs.getString("image"));
				customerAndProductAndProduct_col.setDes(rs.getString("des"));
				customerAndProductAndProduct_col.setCreated_time(rs.getDate("created_time"));
				customerAndProductAndProduct_col.setStatus(rs.getString("status"));
				customerAndProductAndProduct_col.setLogo(rs.getString("logo"));
				CustomerAndProductAndProduct_cols.add(customerAndProductAndProduct_col);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return CustomerAndProductAndProduct_cols;
	}

}
