package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mo.bean.Admin;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.AdminDAO;

public class AdminDAOImpl extends AbstractBaseDAO implements AdminDAO{

	@Override
	public List<Admin> queryAll() {
		
		return null;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_admin");
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
	public List<Admin> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Admin> admins = new ArrayList<Admin>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize + " * from (select * from t_admin where role='管理员')stu where id not in (select top " + (pageNo - 1) * pageSize + " id from (select * from t_admin where role='管理员')stu) ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Admin admin = new Admin();
				admin.setId(rs.getString("id"));
				admin.setEmail(rs.getString("email"));
				admin.setName(rs.getString("name"));
				admin.setPhone(rs.getString("phone"));
				admin.setRole(rs.getString("role"));
				admin.setCreated_time(rs.getTimestamp("created_time"));
				admin.setStatus(rs.getString("status"));
				admins.add(admin);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return admins;
	}

	@Override
	public void add(Admin t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_admin(email, password, name, phone, role,status,created_time) values(?, ?, ?, ?,?, ?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPhone());
			ps.setString(5, t.getRole());
			ps.setString(6, t.getStatus());
			ps.setTimestamp(7, DateUtil.convert2(t.getCreated_time()));
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
			PreparedStatement ps = conn.prepareStatement("delete from t_admin where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Admin t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set name=?,phone=? where id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Admin queryByNoPwd(String email, String password) {
		Admin admin = null;
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_admin where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new Admin();
				admin.setEmail(email);
				admin.setPassword(password);
				admin.setId(rs.getString("id"));
				admin.setName(rs.getString("name"));
				admin.setPhone(rs.getString("phone"));
				admin.setRole(rs.getString("role"));
				admin.setCreated_time(rs.getTimestamp("created_time"));
				admin.setLast_login_time(rs.getTimestamp("last_login_time"));
				admin.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return admin;
	}

	@Override
	public Admin queryById(String id) {
		Connection conn = getConn();
		Admin admin = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_admin where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin= new Admin();
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setPhone(rs.getString("phone"));
				admin.setRole(rs.getString("role"));
				admin.setCreated_time(rs.getTimestamp("created_time"));
				admin.setLast_login_time(rs.getTimestamp("last_login_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return admin;
	}

	@Override
	public void updatepwd(String pwd,String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set password=? where id=?");
			ps.setString(1, pwd);
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void updaterole(String id, String status) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set status=? where id=?");
			ps.setString(1, status);
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_admin set last_login_time=? where id=?");
			ps.setTimestamp(1, DateUtil.convert2(last_login_time));
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Admin queryByemail(String email) {
		Connection conn = getConn();
		Admin admin = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_admin where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				admin= new Admin();
				admin.setEmail(rs.getString("email"));
				admin.setPassword(rs.getString("password"));
				admin.setName(rs.getString("name"));
				admin.setPhone(rs.getString("phone"));
				admin.setRole(rs.getString("role"));
				admin.setCreated_time(rs.getTimestamp("created_time"));
				admin.setLast_login_time(rs.getTimestamp("last_login_time"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return admin;
	}
}
