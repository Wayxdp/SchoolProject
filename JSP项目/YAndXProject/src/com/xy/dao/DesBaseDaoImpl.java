package com.xy.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.xy.bean.Company;
import com.xy.bean.Designer;
import com.xy.util.Encrypt;

public class DesBaseDaoImpl extends Conn implements DesBaseDao{

	
	@Override
	public void del(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Designer> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(Designer des) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void add(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_designer(email, password, name, address, phone) values(?, ?, ?, ?, ?)");
			ps.setString(1,t.getEmail());
			ps.setString(2,Encrypt.encrypt(t.getPassword()));
			ps.setString(3,t.getName());
			ps.setString(4,t.getAddress());
			ps.setString(5,t.getPhone());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Designer queryEmialAndPwd(String email, String pwd) {
		Connection conn = getConn();
		Designer des = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				des = new Designer();
				des.setId(rs.getString("id"));
				des.setEmail(rs.getString("email"));
				des.setPassword(rs.getString("password"));
				des.setName(rs.getString("name"));
				des.setHeadicon(rs.getString("headicon"));
				des.setPhone(rs.getString("phone"));
				des.setAddress(rs.getString("address"));
				des.setExperience(rs.getString("experience"));
				des.setStyle(rs.getString("style"));
				des.setDes(rs.getString("des"));
				des.setCreated_time(rs.getDate("created_time"));
				des.setChecked_time(rs.getDate("checked_time"));
				des.setLast_login_time(rs.getDate("last_login_time"));
				des.setChecked(rs.getString("checked"));
				des.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return des;
	}

	@Override
	public void updatePwd(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer set password = ? where id = ? ");
			ps.setString(1, Encrypt.encrypt(t.getPassword()));
			ps.setString(2, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	
}
