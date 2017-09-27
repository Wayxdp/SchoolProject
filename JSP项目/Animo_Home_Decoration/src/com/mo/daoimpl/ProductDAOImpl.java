package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Product;
import com.mo.bean.SupplyAndProduct;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.ProductDAO;

public class ProductDAOImpl extends AbstractBaseDAO implements ProductDAO{

	@Override
	public List<Product> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	 private Product getT_Product(ResultSet rs)throws SQLException{
		 Product t_product = new Product();
	        t_product.setId(rs.getString("id"));
	        t_product.setSupply_id(rs.getString("supply_id"));
	        t_product.setProductname(rs.getString("productname"));
	        t_product.setPrice(rs.getFloat("price"));
	        t_product.setSale_price(rs.getFloat("sale_price"));
	        t_product.setImage(rs.getString("image"));
	        t_product.setDes(rs.getString("des"));
	        t_product.setCreated_time(rs.getDate("created_time"));
	        t_product.setStatus(rs.getString("status"));
	        return t_product;
	    }
	
	@Override
	public int count() {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement("" +
	                    "select count(id) from  t_product");
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
	public List<Product> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void add(Product t) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("insert into t_product(supply_id,productname," +
	                            "price,sale_price,image,des,created_time,status) values(?,?,?,?,?,?,?,?)");
	            ps.setString(1,t.getSupply_id());
	            ps.setString(2,t.getProductname());
	            ps.setFloat(3,t.getPrice());
	            ps.setFloat(4,t.getSale_price());
	            ps.setString(5,t.getImage());
	            ps.setString(6,t.getDes());
	            ps.setTimestamp(7, DateUtil.convert2(t.getCreated_time()));
	            ps.setString(8,t.getStatus());
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public void update(Product t) {
		  Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_product set productname=?," +
	                            "image=?,des=?,price=?,sale_price=?" +
	                            "  where id=?");
	            ps.setString(1,t.getProductname());
	            ps.setString(2,t.getImage());
	            ps.setString(3,t.getDes());
	            ps.setFloat(4,t.getPrice());
	            ps.setFloat(5,t.getSale_price());
	            ps.setString(6,t.getId());
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public Product queryById(String id) {
		Connection conn = getConn();
        Product product=null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from t_product where id=? ");
            ps.setString(1,id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            	product = getT_Product(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
        return product;
	}

	@Override
	public List<Product> queryByPager(int pageNo, int pageSize, String supply_id) {
		 Connection conn = getConn();
	        List<Product> t_productList = new ArrayList<Product>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from " +
	                    "(select * from t_product where supply_id='"+supply_id+"')stu where id not" +
	                    " in (select top "+(pageNo-1)*pageSize+
	                    " id from (select * from t_product where supply_id='"+supply_id+"')stu)");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	Product t_product = getT_Product(rs);
	                t_productList.add(t_product);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_productList;
	}

	@Override
	public void updateStatus(String id, String status) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_product set status=?  where id=?");
	            ps.setString(1,status);
	            ps.setString(2,id);
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public List<Product> top3Allproduct() {
		Connection conn = getConn();
		List<Product> products = new ArrayList<Product>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top 3 * from t_product");
			ResultSet rs = ps.executeQuery();
			 while (rs.next()){
	            	Product t_product = getT_Product(rs);
	            	products.add(t_product);
	            }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  close(conn);
	      return products;
	}

	@Override
	public int queryCount(String supply_id) {
		Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("" +
                    "select count(id) from (select * from t_product where supply_id='"+supply_id+"')stu");
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
	public List<SupplyAndProduct> queryByPagercase(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<SupplyAndProduct> SupplyAndProducts = new ArrayList<SupplyAndProduct>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" b.*,a.des,a.name,a.principal,a.logo,a.address,a.tel,a.open_date from t_supply a, t_product b where a.id = b.supply_id and b.id not in ( select top "+(pageNo-1)*pageSize+" a.id from t_supply a, t_product b where a.id = b.supply_id) ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				SupplyAndProduct supplyAndProduct =new SupplyAndProduct();
				supplyAndProduct.setId(rs.getString("id"));
				supplyAndProduct.setName(rs.getString("name"));
				supplyAndProduct.setPrincipal(rs.getString("principal"));
				supplyAndProduct.setLogo(rs.getString("logo"));
				supplyAndProduct.setAddress(rs.getString("address"));
				supplyAndProduct.setTel(rs.getString("tel"));
				supplyAndProduct.setOpen_date(rs.getDate("open_date"));
				supplyAndProduct.setDes(rs.getString("des"));
				supplyAndProduct.setPrice(rs.getFloat("price"));
				supplyAndProduct.setSale_price(rs.getFloat("sale_price"));
				supplyAndProduct.setImage(rs.getString("image"));
				supplyAndProduct.setProductname(rs.getString("productname"));
				supplyAndProduct.setSupply_id(rs.getString("supply_id"));
				supplyAndProduct.setCreated_time(rs.getDate("created_time"));
				supplyAndProduct.setStatus(rs.getString("status"));
				SupplyAndProducts.add(supplyAndProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return SupplyAndProducts;
	}

	@Override
	public Product queryBySupply_id(String supply_id) {
		Connection conn = getConn();
        Product product=null;
        try {
            PreparedStatement ps = conn.prepareStatement("select * from t_product where supply_id=?");
            ps.setString(1,supply_id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
            	product = getT_Product(rs);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
        return product;
	}
}
