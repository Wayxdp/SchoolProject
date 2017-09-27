package com.gs.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import com.gs.bean.Company;

public class CompanyDAO {
	
	public void add(Company company) {
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/datasource");
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement("insert into t_supply(name, headicon) values(?, ?)");
			ps.setString(1, company.getName());
			ps.setString(2, company.getHeadIcon());
			ps.execute();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Company> queryAll() {
		List<Company> cs = new ArrayList<Company>();
		try {
			InitialContext context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/datasource");
			Connection conn = ds.getConnection();
			PreparedStatement ps = conn.prepareStatement("select * from t_supply");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Company c = new Company();
				c.setName(rs.getString("name"));
				c.setHeadIcon(rs.getString("headicon"));
				cs.add(c);
			}
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cs;
	}
}
