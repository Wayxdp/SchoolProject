package com.xy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xy.bean.Customer;
import com.xy.util.Encrypt;

public class CusBaseDaoImpl extends Conn implements CusBaseDao{

	@Override
	public void add(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_customer (email, password, name, phone) values(?, ?, ?, ?)");
			ps.setString(1,t.getEmail());
			ps.setString(2,Encrypt.encrypt(t.getPassword()));
			ps.setString(3,t.getName());
			ps.setString(4,t.getPhone());
			System.out.println(t.getEmail()+"ddd");
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void del(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Customer> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Customer cus) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set name = ?, address = ?, phone = ?, plot_name = ? where id = ?");
			ps.setString(1, cus.getName());
			ps.setString(2, cus.getAddress());
			ps.setString(3, cus.getPhone());
			ps.setString(4, cus.getPlot_name());
			ps.setString(5, cus.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Customer queryEmialAndPwd(String email, String pwd) {
		Connection conn = getConn();
		Customer cus = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_customer where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				cus = new Customer();
				cus.setId(rs.getString("id"));
				cus.setEmail(rs.getString("email"));
				cus.setPassword(rs.getString("password"));
				cus.setName(rs.getString("name"));
				cus.setAddress(rs.getString("address"));
				cus.setPhone(rs.getString("phone"));
				cus.setStatus(rs.getString("status"));
				cus.setLast_login_time(rs.getDate("last_login_time"));
				cus.setPlot_name(rs.getString("plot_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return cus;
	}

	@Override
	public void updatePwd(Customer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_customer set password = ? where id = ? ");
			ps.setString(1, Encrypt.encrypt(t.getPassword()));
			ps.setString(2, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


}
