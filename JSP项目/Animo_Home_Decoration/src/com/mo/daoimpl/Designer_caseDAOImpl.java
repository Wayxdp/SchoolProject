package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Company_case;
import com.mo.bean.Designer_case;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Designer_caseDAO;

public class Designer_caseDAOImpl extends AbstractBaseDAO implements Designer_caseDAO{
	
	  private Designer_case getT_Designer_Case(ResultSet rs)throws SQLException{
		  	Designer_case t_designer_case = new Designer_case();
	        t_designer_case.setCaseid(rs.getString("caseid"));
	        t_designer_case.setDesigner_id(rs.getString("designer_id"));
	        t_designer_case.setCasename(rs.getString("casename"));
	        t_designer_case.setPlot_name(rs.getString("plot_name"));
	        t_designer_case.setStyle(rs.getString("style"));
	        t_designer_case.setImage_1(rs.getString("image_1"));
	        t_designer_case.setImage_2(rs.getString("image_2"));
	        t_designer_case.setImage_3(rs.getString("image_3"));
	        t_designer_case.setImage_4(rs.getString("image_4"));
	        t_designer_case.setImage_5(rs.getString("image_5"));
	        t_designer_case.setDes(rs.getString("des"));
	        t_designer_case.setCreated_time(rs.getDate("created_time"));
	        t_designer_case.setStatus(rs.getString("status"));
	        return t_designer_case;
	    }
	
	@Override
	public List<Designer_case> queryAll() {
		 Connection conn = getConn();
	        List<Designer_case> t_designer_caseList = new ArrayList<Designer_case>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_designer_case");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	Designer_case t_designer_case = getT_Designer_Case(rs);
	                t_designer_caseList.add(t_designer_case);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_designer_caseList;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(caseid) from t_designer_case");
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
	public List<Designer_case> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void add(Designer_case t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_designer_case(designer_id,casename,plot_name,style,image_1,image_2,image_3,image_4,image_5,des,created_time,status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, t.getDesigner_id());
			ps.setString(2, t.getCasename());
			ps.setString(3, t.getPlot_name());
			ps.setString(4, t.getStyle());
			ps.setString(5, t.getImage_1());
			ps.setString(6, t.getImage_2());
			ps.setString(7, t.getImage_3());
			ps.setString(8, t.getImage_4());
			ps.setString(9, t.getImage_5());
			ps.setString(10, t.getDes());
			ps.setTimestamp(11, DateUtil.convert2(t.getCreated_time()));
			ps.setString(12, t.getStatus());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Designer_case t) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_designer_case set casename=?," +
	                            "plot_name=?,style=?,image_1=?,image_2=?,image_3=?," +
	                            "image_4=?,image_5=?,des=?" +
	                            "  where caseid=?");
	            ps.setString(1,t.getCasename());
	            ps.setString(2,t.getPlot_name());
	            ps.setString(3,t.getStyle());
	            ps.setString(4,t.getImage_1());
	            ps.setString(5,t.getImage_2());
	            ps.setString(6,t.getImage_3());
	            ps.setString(7,t.getImage_4());
	            ps.setString(8,t.getImage_5());
	            ps.setString(9,t.getDes());
	            ps.setString(10, t.getCaseid());
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public Designer_case queryById(String id) {
		 Connection conn = getConn();
		 Designer_case t_designer_case=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_designer_case where caseid=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	                t_designer_case = getT_Designer_Case(rs);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_designer_case;
	}

	@Override
	public List<Designer_case> queryByPager(int pageNo, int pageSize, String company_id) {
		 Connection conn = getConn();
	        List<Designer_case> designercases = new ArrayList<Designer_case>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from " +
	                    "(select * from t_designer_case where designer_id='"+company_id+"')stu where caseid not" +
	                    " in (select top "+(pageNo-1)*pageSize+
	                    " caseid from (select * from t_designer_case where designer_id='"+company_id+"')stu)");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	 Designer_case designercase = new Designer_case();
	            	 designercase.setCaseid(rs.getString("caseid"));
	            	 designercase.setDesigner_id(rs.getString("designer_id"));
	            	 designercase.setCasename(rs.getString("casename"));
	            	 designercase.setPlot_name(rs.getString("plot_name"));
	            	 designercase.setStyle(rs.getString("style"));
	            	 designercase.setImage_1(rs.getString("image_1"));
	            	 designercase.setImage_2(rs.getString("image_2"));
	            	 designercase.setImage_3(rs.getString("image_3"));
	            	 designercase.setImage_4(rs.getString("image_4"));
	            	 designercase.setImage_5(rs.getString("image_5"));
	            	 designercase.setDes(rs.getString("des"));
	            	 designercase.setCreated_time(rs.getDate("created_time"));
	            	 designercase.setStatus(rs.getString("status"));
	            	 designercases.add(designercase);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return designercases;
		}

	@Override
	public void updateStatus(String id, String status) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_designer_case set status=?  where id=?");
	            ps.setString(1,status);
	            ps.setString(2,id);
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	    }

	@Override
	public int queryCount(String designer_id) {
		Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("" +
                    "select count(caseid) from (select * from t_designer_case where designer_id='"+designer_id+"')stu");
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
