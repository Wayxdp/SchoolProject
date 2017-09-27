package com.xy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xy.bean.Company;
import com.xy.util.Encrypt;
import com.xy.util.GetDate;

public class SuperBaseDaoImpl extends Conn implements ComBaseDao{

	@Override
	public void add(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company(email, password, name, principal, address, phone, open_date) values(?, ?, ?, ?, ?, ?, ?)");
			ps.setString(1,t.getEmail()); 
			ps.setString(2,Encrypt.encrypt(t.getPassword()));
			ps.setString(3,t.getName());
			ps.setString(4,t.getPrincipal());
			ps.setString(5,t.getAddress());
			ps.setString(6,t.getPhone());
			ps.setDate(7,GetDate.getTime());
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
	public List<Company> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Company com) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set name = ?, principal = ?, address = ?, phone = ?, tel = ?, longitude = ?, latitude = ?, des = ? where id = ?");
			ps.setString(1, com.getName());
			ps.setString(2, com.getPrincipal());
			ps.setString(3, com.getAddress());
			ps.setString(4, com.getPhone());
			ps.setString(5, com.getTel());
			ps.setFloat(6, com.getLatitude());
			ps.setFloat(7, com.getLatitude());
			ps.setString(8, com.getDes());
			ps.setString(9, com.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Company queryEmialAndPwd(String email, String pwd) {
		Connection conn = getConn();
		Company com = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				com = new Company();
				com.setId(rs.getString("id"));
				com.setEmail(rs.getString("email"));
				com.setPassword(rs.getString("password"));
				com.setName(rs.getString("name"));
				com.setPrincipal(rs.getString("principal"));
				com.setLogo(rs.getString("logo"));
				com.setAddress(rs.getString("address"));
				com.setPhone(rs.getString("phone"));
				com.setTel(rs.getString("tel"));
				com.setOpen_date(rs.getDate("open_date"));
				com.setLongitude(rs.getFloat("longitude"));
				com.setLatitude(rs.getFloat("latitude"));
				com.setStatus(rs.getString("status"));
				com.setDes(rs.getString("des"));
				com.setCreated_time(rs.getDate("created_time"));
				com.setChecked_time(rs.getDate("last_login_time"));
				com.setLast_login_time(rs.getDate("last_login_time"));
				com.setChecked(rs.getString("checked"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return com;
	}

	@Override
	public void updatePwd(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set password = ? where id = ? ");
			ps.setString(1, Encrypt.encrypt(t.getPassword()));
			ps.setString(2, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}
}
