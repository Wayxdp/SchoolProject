package com.mo.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Designer_case_col;
import com.mo.bean.Designer_col;
import com.mo.bean.DesignercaseAndDesigner;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Designer_colDAO;

public class Designer_colDAOImpl extends AbstractBaseDAO implements Designer_colDAO{

	@Override
	public List<Designer_col> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Designer_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_designer_col where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	@Override
	public void add(Designer_col t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_designer_col(customer_id,designer_id,created_time) values(?,?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getDesigner_id());
			ps.setTimestamp(3,  DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Designer_col t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Designer_col queryById(String id) {
		Connection conn =  getConn();
		 Designer_col designer_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_designer_col where designer_id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	designer_col = new Designer_col();
	            	designer_col.setId(rs.getString("id"));
	            	designer_col.setCustomer_id(rs.getString("customer_id"));
	            	designer_col.setCreated_time(rs.getTimestamp("created_time"));
	            	designer_col.setDesigner_id(rs.getString("designer_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return designer_col;
	}

	@Override
	public Designer_col queryBycustomerIdBydesignerId(String customerid, String desingerid) {
		Connection conn =  getConn();
		 Designer_col designer_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_designer_col where customer_id=? and designer_id=?");
	            ps.setString(1,customerid);
	            ps.setString(2, desingerid);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	designer_col = new Designer_col();
	            	designer_col.setId(rs.getString("id"));
	            	designer_col.setCustomer_id(rs.getString("customer_id"));
	            	designer_col.setCreated_time(rs.getTimestamp("created_time"));
	            	designer_col.setDesigner_id(rs.getString("designer_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return designer_col;
	}

	@Override
	public List<DesignercaseAndDesigner> queryByCustomerid(int pageNo, int pageSize,String customerid) {
		Connection conn = getConn();
		List<DesignercaseAndDesigner> DesignercaseAndDesigners = new ArrayList<DesignercaseAndDesigner>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from t_designer_col a, t_designer b where a.designer_id = b.id  and a.customer_id = '"+customerid+"'  and a.id not in (select top " + (pageNo - 1) * pageSize + " a.id from t_designer_col a, t_designer b where a.designer_id = b.id  and a.customer_id ='"+customerid+"')order by created_time desc");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DesignercaseAndDesigner designercaseAndDesigner = new DesignercaseAndDesigner();
				designercaseAndDesigner.setAddress(rs.getString("address"));
				designercaseAndDesigner.setChecked(rs.getString("checked"));
				designercaseAndDesigner.setChecked_time(rs.getTimestamp("checked_time"));
				designercaseAndDesigner.setCreated_time(rs.getTimestamp("created_time"));
				designercaseAndDesigner.setCustomer_id(rs.getString("customer_id"));
				designercaseAndDesigner.setDes(rs.getString("des"));
				designercaseAndDesigner.setDesigner_id(rs.getString("designer_id"));
				designercaseAndDesigner.setEmail(rs.getString("email"));
				designercaseAndDesigner.setExperience(rs.getString("experience"));
				designercaseAndDesigner.setHeadicon(rs.getString("headicon"));
				designercaseAndDesigner.setId(rs.getString("id"));
				designercaseAndDesigner.setLast_login_time(rs.getTimestamp("last_login_time"));
				designercaseAndDesigner.setName(rs.getString("name"));
				designercaseAndDesigner.setPhone(rs.getString("phone"));
				designercaseAndDesigner.setStatus(rs.getString("status"));
				designercaseAndDesigner.setStyle(rs.getString("style"));
				DesignercaseAndDesigners.add(designercaseAndDesigner);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return DesignercaseAndDesigners;
	}

	@Override
	public int getconn(String customerid) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_designer_col where customer_id=?");
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
}
