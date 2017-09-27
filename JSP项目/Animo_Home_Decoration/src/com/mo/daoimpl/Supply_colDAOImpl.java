package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Company_col;
import com.mo.bean.Supply_col;
import com.mo.bean.Supply_colAndsupply;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Supply_colDAO;

public class Supply_colDAOImpl extends AbstractBaseDAO implements Supply_colDAO{

	@Override
	public List<Supply_col> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Supply_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_supply_col where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	@Override
	public void add(Supply_col t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply_col(customer_id,supply_id,created_time) values(?,?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getSupply_id());
			ps.setTimestamp(3,  DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Supply_col t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Supply_col queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Supply_col queryBycustomerIdBycompanyId(String customerid, String supplyid) {
		Connection conn =  getConn();
		Supply_col supply_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_supply_col where customer_id=? and supply_id=?");
	            ps.setString(1,customerid);
	            ps.setString(2, supplyid);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	supply_col = new Supply_col();
	            	supply_col.setId(rs.getString("id"));
	            	supply_col.setCustomer_id(rs.getString("customer_id"));
	            	supply_col.setCreated_time(rs.getTimestamp("created_time"));
	            	supply_col.setSupply_id(rs.getString("supply_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return supply_col;
	}

	@Override
	public int getconn(String customerid) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_supply_col where customer_id=?");
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
	public List<Supply_colAndsupply> queryByCustomerid(int pageNo, int pageSize, String customerid) {
		Connection conn = getConn();
		List<Supply_colAndsupply> Supply_colAndsupplys = new ArrayList<Supply_colAndsupply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from t_supply_col a, t_supply b where a.supply_id = b.id  and a.customer_id = '"+customerid+"'  and a.id not in (select top " + (pageNo - 1) * pageSize + " a.id from t_supply_col a, t_supply b where a.supply_id = b.id  and a.customer_id ='"+customerid+"')");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Supply_colAndsupply supply_colAndsupply = new Supply_colAndsupply();
				supply_colAndsupply.setName(rs.getString("name"));
				supply_colAndsupply.setId(rs.getString("id"));
				supply_colAndsupply.setPrincipal(rs.getString("principal"));
				supply_colAndsupply.setLogo(rs.getString("logo"));
				supply_colAndsupply.setAddress(rs.getString("address"));
				supply_colAndsupply.setPhone(rs.getString("phone"));
				supply_colAndsupply.setTel(rs.getString("tel"));
				supply_colAndsupply.setOpen_date(rs.getDate("open_date"));
				supply_colAndsupply.setDes(rs.getString("des"));
				supply_colAndsupply.setCustomer_id(rs.getString("customer_id"));
				supply_colAndsupply.setSupply_id(rs.getString("supply_id"));
				Supply_colAndsupplys.add(supply_colAndsupply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return Supply_colAndsupplys;
	}
	
}
