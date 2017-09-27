package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Userconsult;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.UserconsultDAO;

public class UserconsultDAOImpl extends AbstractBaseDAO implements UserconsultDAO{


	@Override
	public List<Userconsult> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_userconsult");
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
	public List<Userconsult> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Userconsult> userConsult = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize + " * from t_userconsult where id not in (select top " + (pageNo - 1) * pageSize + " id from t_userconsult)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Userconsult consult = new Userconsult();
				consult.setId(rs.getString("id"));
				consult.setCompany_id(rs.getString("company_id"));
				consult.setSupply_id(rs.getString("supply_id"));
				consult.setDesigner_id(rs.getString("designer_id"));
				consult.setName(rs.getString("name"));
				consult.setPhone(rs.getString("phone"));
				consult.setLeave_word(rs.getString("leave_word"));
				consult.setEmali(rs.getString("email"));
				consult.setQq(rs.getString("qq"));
				consult.setCreated_time(rs.getTimestamp("created_time"));
				userConsult.add(consult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return userConsult;
	}


	@Override
	public void add(Userconsult t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_userconsult(designer_id,name,phone,leave_word,email,qq,created_time,company_id,supply_id)values(?,?,?,?,?,?,?,?,?)");
			ps.setString(1, t.getDesigner_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPhone());
			ps.setString(4, t.getLeave_word());
			ps.setString(5, t.getEmali());
			ps.setString(6, t.getQq());
			ps.setTimestamp(7,DateUtil.convert2(t.getCreated_time()));
			ps.setString(8, t.getCompany_id());
			ps.setString(9, t.getSupply_id());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void update(Userconsult t) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Userconsult queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
