package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.Company_col;
import com.mo.bean.Company_colAndCompany;
import com.mo.bean.Designer;
import com.mo.bean.Designer_col;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Company_colDAO;

public class Company_colDAOImpl extends AbstractBaseDAO implements Company_colDAO{

	@Override
	public List<Company_col> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Company_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_company_col where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void add(Company_col t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_col(customer_id,company_id,created_time) values(?,?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getCompany_id());
			ps.setTimestamp(3,  DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Company_col t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company_col queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Company_col queryBycustomerIdBycompanyId(String customerid, String companyid) {
		Connection conn =  getConn();
		Company_col company_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_company_col where customer_id=? and company_id=? ");
	            ps.setString(1,customerid);
	            ps.setString(2, companyid);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	company_col = new Company_col();
	            	company_col.setId(rs.getString("id"));
	            	company_col.setCustomer_id(rs.getString("customer_id"));
	            	company_col.setCreated_time(rs.getTimestamp("created_time"));
	            	company_col.setCompany_id(rs.getString("company_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return company_col;
	}

	@Override
	public int getconn(String customerid) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_col where customer_id=?");
			ps.setString(1, customerid);
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
	public List<Company_colAndCompany> queryByCustomerid(int pageNo, int pageSize, String customerid) {
		Connection conn = getConn();
		List<Company_colAndCompany> companys = new ArrayList<Company_colAndCompany>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from t_company_col a, t_company b where a.company_id = b.id  and a.customer_id = '"+customerid+"'  and a.id not in (select top " + (pageNo - 1) * pageSize + " a.id from t_company_col a, t_company b where a.company_id = b.id  and a.customer_id ='"+customerid+"') ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Company_colAndCompany CompanycolAndCompany = new Company_colAndCompany();
				CompanycolAndCompany.setId(rs.getString("id"));
				CompanycolAndCompany.setEmail(rs.getString("email"));
				CompanycolAndCompany.setPassword(rs.getString("password"));
				CompanycolAndCompany.setCompany_name(rs.getString("company_name"));
				CompanycolAndCompany.setPrincipal(rs.getString("principal"));
				CompanycolAndCompany.setLogo(rs.getString("logo"));
				CompanycolAndCompany.setAddress(rs.getString("address"));
				CompanycolAndCompany.setPhone(rs.getString("phone"));
				CompanycolAndCompany.setTel(rs.getString("tel"));
				CompanycolAndCompany.setOpen_date(rs.getTimestamp("open_date"));
				CompanycolAndCompany.setLongitude(rs.getFloat("longitude"));
				CompanycolAndCompany.setLatitude(rs.getFloat("latitude"));
				CompanycolAndCompany.setDes(rs.getString("des"));
				CompanycolAndCompany.setCreated_time(rs.getTimestamp("created_time"));
				CompanycolAndCompany.setChecked(rs.getString("checked"));
				CompanycolAndCompany.setChecked_time(rs.getTimestamp("checked_time"));
				CompanycolAndCompany.setLast_login_time(rs.getTimestamp("last_login_time"));
				CompanycolAndCompany.setStatus(rs.getString("status"));
				CompanycolAndCompany.setCompany_id(rs.getString("company_id"));
				CompanycolAndCompany.setCustomer_id(rs.getString("customer_id"));
				companys.add(CompanycolAndCompany);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return companys;
	}


}
