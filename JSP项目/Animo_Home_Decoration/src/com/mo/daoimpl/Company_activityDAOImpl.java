package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Company_activity;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Company_activityDAO;

public class Company_activityDAOImpl extends AbstractBaseDAO implements Company_activityDAO{
	
	 private Company_activity getT_Company_Activity(ResultSet rs)throws SQLException{
		 Company_activity t_company_activity = new Company_activity();
	        t_company_activity.setId(rs.getString("id"));
	        t_company_activity.setCompany_id(rs.getString("company_id"));
	        t_company_activity.setName(rs.getString("name"));
	        t_company_activity.setImage(rs.getString("image"));
	        t_company_activity.setDes(rs.getString("des"));
	        t_company_activity.setCreated_time(rs.getDate("created_time"));
	        t_company_activity.setStatus(rs.getString("status"));
	        return t_company_activity;
	    }
	
	@Override
	public List<Company_activity> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("" +
                    "select count(id) from  t_company_activity");
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
	public List<Company_activity> queryByPager(int pageNo, int pageSize) {
		  Connection conn = getConn();
	        List<Company_activity> t_company_activityList = new ArrayList<Company_activity>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from (select * from t_company_activity where status='Y')stu where id not in " +
	                    "(select top  "+(pageNo-1)*pageSize+"  id from (select * from t_company_activity where status='Y')stu)");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	                Company_activity t_company_activity = getT_Company_Activity(rs);
	                t_company_activityList.add(t_company_activity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_company_activityList;
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Company_activity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_activity(company_id,name,image,des,created_time,status) values(?,?,?,?,?,?)");
			ps.setString(1, t.getCompany_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getImage());
			ps.setString(4, t.getDes());
			ps.setTimestamp(5, DateUtil.convert2(t.getCreated_time()));
			ps.setString(6, t.getStatus());
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Company_activity t) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_company_activity set name=?," +
	                            "image=?,des=?" +
	                            "  where id=?");
	            ps.setString(1,t.getName());
	            ps.setString(2,t.getImage());
	            ps.setString(3,t.getDes());
	            ps.setString(4,t.getId());
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public Company_activity queryById(String id) {
		 Connection conn = getConn();
		 Company_activity companyactivity=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_company_activity where id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	companyactivity = getT_Company_Activity(rs);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return companyactivity;
	}

	@Override
	public void updateStatus(String id, String status) {
		Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement
                    ("update  t_company_activity set status=?  where id=?");
            ps.setString(1,status);
            ps.setString(2,id);
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
    }

	@Override
	public List<Company_activity> queryByPager(int pageNo, int pageSize, String company_id) {
		Connection conn = getConn();
        List<Company_activity> t_company_activityList = new ArrayList<Company_activity>();
        try {
            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from " +
                    "(select * from t_company_activity where company_id='"+company_id+"')stu where id not" +
                    " in (select top "+(pageNo-1)*pageSize+
                    " id from (select * from t_company_activity where company_id='"+company_id+"')stu)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            	Company_activity t_company_activity = getT_Company_Activity(rs);
                t_company_activityList.add(t_company_activity);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
        return t_company_activityList;
	}

	@Override
	public List<Company_activity> pastqueryByPager(int pageNo, int pageSize) {
		 Connection conn = getConn();
	        List<Company_activity> t_company_activityList = new ArrayList<Company_activity>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from (select * from t_company_activity where status='N')stu where id not in " +
	                    "(select top  "+(pageNo-1)*pageSize+"  id from (select * from t_company_activity where status='N')stu) ");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	                Company_activity t_company_activity = getT_Company_Activity(rs);
	                t_company_activityList.add(t_company_activity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_company_activityList;
	}


}
