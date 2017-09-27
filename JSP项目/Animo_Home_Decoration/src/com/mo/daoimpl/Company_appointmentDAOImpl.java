package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Appointment;
import com.mo.bean.Company_appointment;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Company_appointementDAO;

public class Company_appointmentDAOImpl extends AbstractBaseDAO implements Company_appointementDAO {

	private Company_appointment getT_Appointment(ResultSet rs)throws SQLException {
        Company_appointment com_appointment = new Company_appointment();
        com_appointment.setId(rs.getString("id"));
        com_appointment.setName(rs.getString("name"));
        com_appointment.setPhone(rs.getString("phone"));
        com_appointment.setCreated_time(rs.getDate("created_time"));
        com_appointment.setUser_id(rs.getString("user_id"));
        com_appointment.setPlot_name(rs.getString("plot_name"));
        com_appointment.setArea(rs.getFloat("area"));
        com_appointment.setBudget(rs.getString("budget"));
        com_appointment.setWay(rs.getString("way"));
        return com_appointment;
    }
	
	@Override
	public List<Appointment> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_appointment");
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
	public List<Appointment> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Appointment t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_appointment(user_id, name, phone, plot_name,area,way, budget, created_time) values(?, ?, ?,?, ?,?,?,?)");
			ps.setString(1, t.getUser_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPhone());
			ps.setString(4, t.getPlot_name());
			ps.setFloat(5, t.getArea());
			ps.setString(6,t.getWay());
			ps.setString(7,t.getBudget());
			ps.setTimestamp(8, DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_company_appointment where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Appointment t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set email=?,company=?,name=?,phone=?,plot_name=?,area=?,way=?,budget=?,created_time=? where id=?");
			ps.setString(1, t.getUser_id());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPhone());
			ps.setString(5, t.getPlot_name());
			ps.setFloat(6, t.getArea());
			ps.setString(7,t.getWay());
			ps.setString(8,t.getBudget());
			ps.setTimestamp(9, DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}
	
	@Override
	public Appointment queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addcompany(Company_appointment t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_appointment(company_id, name, phone, plot_name,area,way, budget, created_time) values(?, ?, ?, ?,?, ?,?,?)");
			ps.setString(1, t.getCompany_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPhone());
			ps.setString(4, t.getPlot_name());
			ps.setFloat(5, t.getArea());
			ps.setString(6,t.getWay());
			ps.setString(7,t.getBudget());
			ps.setTimestamp(8, DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}
	
	@Override
	public int getCount(String company_id) {
		  Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement("" +
	                    "select count(id) from (select * from t_company_appointment where company_id='"+company_id+"')stu");
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
	public List<Company_appointment> queryByPager(int pageNo, int pageSize, String company_id) {
		 Connection conn = getConn();
	        List<Company_appointment> t_company_caseList = new ArrayList<Company_appointment>();
	        try {
	            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from " +
	                    "(select * from t_appointment where designer_id='"+company_id+"')stu where id not" +
	                    " in (select top "+(pageNo-1)*pageSize+
	                    " id from (select * from t_company_appointment where company_id='"+company_id+"')stu) ");
	            ResultSet rs = ps.executeQuery();
	            while (rs.next()){
	            	Company_appointment com_appointment = getT_Appointment(rs);
	                t_company_caseList.add(com_appointment);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return t_company_caseList;
	}

}
