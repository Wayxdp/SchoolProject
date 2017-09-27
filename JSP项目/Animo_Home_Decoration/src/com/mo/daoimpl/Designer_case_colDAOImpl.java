package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Admin;
import com.mo.bean.CustomerAndDesignerAndDesigner_case;
import com.mo.bean.Designer_case_col;
import com.mo.bean.Supply_activity;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Designer_case_colDAO;

public class Designer_case_colDAOImpl extends AbstractBaseDAO implements Designer_case_colDAO{

	@Override
	public List<Designer_case_col> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Designer_case_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_designer_case_col where case_id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	@Override
	public void add(Designer_case_col t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_designer_case_col(customer_id,case_id,created_time) values(?,?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getCase_id());
			ps.setTimestamp(3, DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Designer_case_col t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Designer_case_col queryById(String id) {
		 Connection conn =  getConn();
		 Designer_case_col designer_case_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_designer_case_col where case_id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	designer_case_col = new Designer_case_col();
	            	designer_case_col.setId(rs.getString("id"));
	            	designer_case_col.setCase_id(rs.getString("case_id"));
	            	designer_case_col.setCreated_time(rs.getTimestamp("created_time"));
	            	designer_case_col.setCustomer_id(rs.getString("customer_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return designer_case_col;
	}

	@Override
	public List<CustomerAndDesignerAndDesigner_case> queryByPager(int pageNo, int pageSize, String customer_id) {
		Connection conn = getConn();
		List<CustomerAndDesignerAndDesigner_case> CustomerAndDesignerAndDesigner_cases = new ArrayList<CustomerAndDesignerAndDesigner_case>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select top "+pageSize+" * from t_designer_case_col a, t_designer_case b, t_designer c where a.case_id = b.caseid and b.designer_id = c.id and a.customer_id = '"+customer_id+"'  and a.id not in (select top "+(pageNo-1)*pageSize+" a.id from t_designer_case_col a, t_designer_case b, t_designer c  where a.case_id = b.caseid and b.designer_id = c.id and a.customer_id ='"+customer_id+"')");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				CustomerAndDesignerAndDesigner_case customerAndDesignerAndDesigner_case = new CustomerAndDesignerAndDesigner_case();
				customerAndDesignerAndDesigner_case.setAddress(rs.getString("address"));
				customerAndDesignerAndDesigner_case.setCase_id(rs.getString("case_id"));
				customerAndDesignerAndDesigner_case.setCaseid(rs.getString("caseid"));
				customerAndDesignerAndDesigner_case.setCasename("casename");
				customerAndDesignerAndDesigner_case.setChecked(rs.getString("checked"));
				customerAndDesignerAndDesigner_case.setChecked_time(rs.getTimestamp("checked_time"));
				customerAndDesignerAndDesigner_case.setCreated_time(rs.getTimestamp("created_time"));
				customerAndDesignerAndDesigner_case.setCustomer_id(rs.getString("customer_id"));
				customerAndDesignerAndDesigner_case.setDes(rs.getString("des"));
				customerAndDesignerAndDesigner_case.setEmail(rs.getString("email"));
				customerAndDesignerAndDesigner_case.setExperience(rs.getString("experience"));
				customerAndDesignerAndDesigner_case.setHeadicon(rs.getString("headicon"));
				customerAndDesignerAndDesigner_case.setId(rs.getString("id"));
				customerAndDesignerAndDesigner_case.setImage_1(rs.getString("image_1"));
				customerAndDesignerAndDesigner_case.setImage_2(rs.getString("image_2"));
				customerAndDesignerAndDesigner_case.setImage_3(rs.getString("image_3"));
				customerAndDesignerAndDesigner_case.setImage_4(rs.getString("image_4"));
				customerAndDesignerAndDesigner_case.setImage_5(rs.getString("image_5"));
				customerAndDesignerAndDesigner_case.setStyle(rs.getString("style"));
				customerAndDesignerAndDesigner_case.setStatus(rs.getString("status"));
				customerAndDesignerAndDesigner_case.setPlot_name(rs.getString("plot_name"));
				customerAndDesignerAndDesigner_case.setPhone(rs.getString("phone"));
				customerAndDesignerAndDesigner_case.setName(rs.getString("name"));
				customerAndDesignerAndDesigner_case.setLast_login_time(rs.getTimestamp("last_login_time"));
				CustomerAndDesignerAndDesigner_cases.add(customerAndDesignerAndDesigner_case);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return CustomerAndDesignerAndDesigner_cases;
	}

	@Override
	public int getCount(String customer_id) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement("" +
	                    "select count(id) from (select * from t_designer_case_col where customer_id='"+customer_id+"')stu");
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
	public Designer_case_col queryById(String customer, String caseid) {
		 Connection conn =  getConn();
		 Designer_case_col designer_case_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_designer_case_col where customer_id=? and caseid=?");
	            ps.setString(1,customer);
	            ps.setString(2, caseid);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	designer_case_col = new Designer_case_col();
	            	designer_case_col.setId(rs.getString("id"));
	            	designer_case_col.setCase_id(rs.getString("case_id"));
	            	designer_case_col.setCreated_time(rs.getTimestamp("created_time"));
	            	designer_case_col.setCustomer_id(rs.getString("customer_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return designer_case_col;
	}

}
