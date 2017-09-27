package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Supply_consult;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Supply_consultDAO;

public class Supply_consultDAOImpl extends AbstractBaseDAO implements Supply_consultDAO{

	@Override
	public List<Supply_consult> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_supply_userconsult");
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
	public List<Supply_consult> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Supply_consult> supply_Consult = new ArrayList<>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize + " * from t_supply_userconsult where id not in (select top " + (pageNo - 1) * pageSize + " id from t_supply_userconsult)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supply_consult consult = new Supply_consult();
				consult.setId(rs.getString("id"));
				consult.setSupply_id(rs.getString("supply_id"));
				consult.setName(rs.getString("name"));
				consult.setPhone(rs.getString("phone"));
				consult.setLeave_word(rs.getString("leave_word"));
				consult.setEmali(rs.getString("email"));
				consult.setQq(rs.getString("qq"));
				consult.setCreated_time(rs.getTimestamp("created_time"));
				supply_Consult.add(consult);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return supply_Consult;
	}


	@Override
	public void add(Supply_consult t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply_userconsult(name,phone,leave_word,email,qq,created_time,supply_id)values(?,?,?,?,?,?,?)");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getLeave_word());
			ps.setString(4, t.getEmali());
			ps.setString(5, t.getQq());
			ps.setTimestamp(6,DateUtil.convert2(t.getCreated_time()));
			ps.setString(7, t.getSupply_id());
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
	public void update(Supply_consult t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Supply_consult queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
