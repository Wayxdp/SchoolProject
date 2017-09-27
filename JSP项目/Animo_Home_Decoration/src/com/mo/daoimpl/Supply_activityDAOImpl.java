package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Supply_activity;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Supply_activityDAO;

public class Supply_activityDAOImpl extends AbstractBaseDAO implements Supply_activityDAO{

	private Supply_activity getT_Supply_Activity(ResultSet rs)throws SQLException{
		Supply_activity t_supply_activity = new Supply_activity();
        t_supply_activity.setId(rs.getString("id"));
        t_supply_activity.setSupply_id(rs.getString("supply_id"));
        t_supply_activity.setName(rs.getString("name"));
        t_supply_activity.setImage(rs.getString("image"));
        t_supply_activity.setDes(rs.getString("des"));
        t_supply_activity.setCreated_time(rs.getDate("created_time"));
        t_supply_activity.setStatus(rs.getString("status"));
        return t_supply_activity;
    }
	
	@Override
	public List<Supply_activity> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
	    Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("" +
                    "select count(id) from  t_supply_activity");
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
	public List<Supply_activity> queryByPager(int pageNo, int pageSize) {
		 Connection conn = getConn();
	        List<Supply_activity> t_supply_activityList = new ArrayList<Supply_activity>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from (select * from t_supply_activity where status='Y')stu where id not in " +
	                    "(select top  "+(pageNo-1)*pageSize+"  id from (select * from t_supply_activity where status='Y')stu)");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	Supply_activity t_supply_activity = getT_Supply_Activity(rs);
	                t_supply_activityList.add(t_supply_activity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_supply_activityList;
	}


	@Override
	public void deleteById(String id) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement("delete from t_supply_activity where id=? ");
	            ps.setString(1,id);
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}


	@Override
	public void add(Supply_activity t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply_activity(supply_id,name,image,des,created_time,status) values(?,?,?,?,?,?)");
			ps.setString(1, t.getSupply_id());
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
	public void update(Supply_activity t) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_supply_activity set name=?," +
	                            "image=?,des=?,status=?" +
	                            "  where id=?");
	            ps.setString(1,t.getName());
	            ps.setString(2,t.getImage());
	            ps.setString(3,t.getDes());
	            ps.setString(4,t.getStatus());
	            ps.setString(5,t.getId());
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public Supply_activity queryById(String id) {
		 Connection conn =  getConn();
	        Supply_activity t_supply_activity=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_supply_activity where id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                t_supply_activity = getT_Supply_Activity(rs);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_supply_activity;
	}

	@Override
	public List<Supply_activity> queryByPager(int pageNo, int pageSize, String supply_id) {
		 Connection conn =  getConn();
	        List<Supply_activity> t_supply_activityList = new ArrayList<Supply_activity>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from " +
	                    "(select * from t_supply_activity where supply_id='"+supply_id+"')stu where id not" +
	                    " in (select top "+(pageNo-1)*pageSize+
	                    " id from (select * from t_supply_activity where supply_id='"+supply_id+"')stu)");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	Supply_activity t_supply_activity = getT_Supply_Activity(rs);
	                t_supply_activityList.add(t_supply_activity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_supply_activityList;
	}

	@Override
	public void updateStatus(String id, String status) {
		   Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_supply_activity set status=?  where id=?");
	            ps.setString(1,status);
	            ps.setString(2,id);
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public List<Supply_activity> pastqueryByPager(int pageNo, int pageSize) {
		 Connection conn = getConn();
	        List<Supply_activity> t_supply_activityList = new ArrayList<Supply_activity>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from (select * from t_supply_activity where status='N')stu where id not in " +
	                    "(select top  "+(pageNo-1)*pageSize+"  id from (select * from t_supply_activity where status='N')stu)");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	Supply_activity t_supply_activity = getT_Supply_Activity(rs);
	                t_supply_activityList.add(t_supply_activity);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_supply_activityList;
	}

}
