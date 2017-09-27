package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mo.bean.Admin;
import com.mo.bean.Customer;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.CustomerDAO;

public class CustomerDAOImpl extends AbstractBaseDAO implements CustomerDAO{

	@Override
	public List<Customer> queryAll() {
		Connection conn = getConn();
		List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setPlot_name(rs.getString("plot_name"));
				customer.setAddress(rs.getString("address"));
				customer.setCreated_time(rs.getTimestamp("created_time"));
				customer.setLast_login_time(rs.getTimestamp("last_login_time"));
				customer.setStatus(rs.getString("status"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return customers;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_customer");
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
//分页查询
	@Override
	public List<Customer> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Customer> customers = new ArrayList<Customer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize + " * from t_customer where id not in (select top " + (pageNo - 1) * pageSize + " id from t_customer) ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getString("id"));
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setPlot_name(rs.getString("plot_name"));
				customer.setAddress(rs.getString("address"));
				customer.setCreated_time(rs.getTimestamp("created_time"));
				customer.setLast_login_time(rs.getTimestamp("last_login_time"));
				customer.setStatus(rs.getString("status"));
				customers.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return customers;
	}

//删除用户
	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_customer where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		
	}
//添加用户
	@Override
	public void add(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_customer(email, password, name, phone,created_time,status) values(?, ?, ?,?, ?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPhone());
			ps.setTimestamp(5, DateUtil.convert2(t.getCreated_time()));
			ps.setString(6, t.getStatus());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		
	}
//更新用户数据
	@Override
	public void update(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set  phone=?,name=?,plot_name=?,address=?,email=?,created_time=?,last_login_time=? where id=?");
			ps.setString(1, t.getPhone());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPlot_name());
			ps.setString(4, t.getAddress());
			ps.setString(5, t.getEmail());
			ps.setTimestamp(6, DateUtil.convert2(t.getCreated_time()));
			ps.setTimestamp(7, DateUtil.convert2(t.getLast_login_time()));
			ps.setString(8, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		
	}
//根据id查询用户
	@Override
	public Customer queryById(String id) {
		Connection conn = getConn();
		Customer customer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				customer = new Customer();
				customer.setId(id);
				customer.setEmail(rs.getString("email"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setPlot_name(rs.getString("plot_name"));
				customer.setAddress(rs.getString("address"));
				customer.setCreated_time(rs.getTimestamp("created_time"));
				customer.setLast_login_time(rs.getTimestamp("last_login_time"));
				customer.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return customer;

	}
//根据邮箱查询用户
	@Override
	public Customer queryByemail(String email) {
		Connection conn = getConn();
		Customer customer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				customer = new Customer();
				customer.setEmail(email);
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setPlot_name(rs.getString("plot_name"));
				customer.setAddress(rs.getString("address"));
				customer.setCreated_time(rs.getTimestamp("created_time"));
				customer.setLast_login_time(rs.getTimestamp("last_login_time"));
				customer.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return customer;
	}
//根据账号和密码查询用户
	@Override
	public Customer queryByNoPwd(String email, String pwd) {
		Customer customer = null;
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setEmail(email);
				customer.setPassword(pwd);
				customer.setId(rs.getString("id"));
				customer.setName(rs.getString("name"));
				customer.setPhone(rs.getString("phone"));
				customer.setPlot_name(rs.getString("plot_name"));
				customer.setAddress(rs.getString("address"));
				customer.setCreated_time(rs.getTimestamp("created_time"));
				customer.setLast_login_time(rs.getTimestamp("last_login_time"));
				customer.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return customer;
	}


//更新密码
	@Override
	public void updatepwd(String id, String pwd) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set password=? where id=?");
			ps.setString(1, pwd);
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

//更新审核时间
	@Override
	public void updatechecked_time(Date checked_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set checked_time=? where id=?");
			ps.setTimestamp(1, DateUtil.convert2(checked_time));
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}
//更新最后登录时间
	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set last_login_time=? where id=?");
			ps.setTimestamp(1, DateUtil.convert2(last_login_time));
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}
//更新可用禁用状态
	@Override
	public void updatestatus(String status, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set status=? where id=?");
			ps.setString(1, status);
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

}
