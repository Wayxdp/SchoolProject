package com.xy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xy.bean.Supply;
import com.xy.util.Encrypt;
import com.xy.util.GetDate;
public class SupBaseDaoImpl extends Conn implements SupBaseDao{

	@Override
	public void add(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply(email, password, name, principal, address, phone, open_date) values(?, ?, ?, ?, ?, ?, ?)");
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
		
	}


	@Override
	public void update(Supply sup) {
		
	}

	@Override
	public List<Supply> queryAll() {
		return null;
	}

	@Override
	public Supply queryEmialAndPwd(String email, String pwd) {
		Connection conn = getConn();
		Supply sup = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				sup = new Supply();
				sup.setId(rs.getString("id"));
				sup.setEmail(rs.getString("email"));
				sup.setPassword(rs.getString("password"));
				sup.setName(rs.getString("name"));
				sup.setPrincipal(rs.getString("principal"));
				sup.setLogo(rs.getString("logo"));
				sup.setAddress(rs.getString("address"));
				sup.setPhone(rs.getString("phone"));
				sup.setTel(rs.getString("tel"));
				sup.setOpen_date(rs.getDate("open_date"));
				sup.setLongitude(Float.valueOf(rs.getFloat("longitude")));
				sup.setLatitude(Float.valueOf(rs.getFloat("latitude")));
				sup.setStatus(rs.getString("status"));
				sup.setDes(rs.getString("des"));
				sup.setCreated_time(rs.getDate("created_time"));
				sup.setChecked_time(rs.getDate("last_login_time"));
				sup.setLast_login_time(rs.getDate("last_login_time"));
				sup.setChecked(rs.getString("checked"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return sup;
	}

	@Override
	public void updatePwd(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_supply set password = ? where id = ? ");
			ps.setString(1, Encrypt.encrypt(t.getPassword()));
			ps.setString(2, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

}
