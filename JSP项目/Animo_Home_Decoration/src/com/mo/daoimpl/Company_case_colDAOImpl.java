package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Company_case_col;
import com.mo.bean.Compnay_caseAndCustomerAndCompany;
import com.mo.bean.CustomerAndDesignerAndDesigner_case;
import com.mo.bean.Designer_case_col;
import com.mo.bean.Product_col;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Company_case_colDAO;

public class Company_case_colDAOImpl extends AbstractBaseDAO implements Company_case_colDAO{

	@Override
	public List<Company_case_col> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public List<Company_case_col> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_company_case_col where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void add(Company_case_col t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_case_col(customer_id,case_id,created_time) values(?,?,?)");
			ps.setString(1, t.getCustomer_id());
			ps.setString(2, t.getCase_id());
			ps.setTimestamp(3,  DateUtil.convert2(t.getCreated_time()));
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Company_case_col t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company_case_col queryById(String id) {
		Connection conn =  getConn();
		Company_case_col company_case_col=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_company_case_col where case_id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	company_case_col = new Company_case_col();
	            	company_case_col.setId(rs.getString("id"));
	            	company_case_col.setCustomer_id(rs.getString("customer_id"));
	            	company_case_col.setCreated_time(rs.getTimestamp("created_time"));
	            	company_case_col.setCase_id(rs.getString("case_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return company_case_col;
	}

	@Override
	public Company_case_col queryById(String customer, String caseid) {
		 Connection conn =  getConn();
		 Company_case_col company_case_colDAO=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_company_case_col where case_id=? ");
	            ps.setString(1,caseid);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	company_case_colDAO = new Company_case_col();
	            	company_case_colDAO.setId(rs.getString("id"));
	            	company_case_colDAO.setCase_id(rs.getString("case_id"));
	            	company_case_colDAO.setCreated_time(rs.getTimestamp("created_time"));
	            	company_case_colDAO.setCustomer_id(rs.getString("customer_id"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return company_case_colDAO;
	}

	@Override
	public List<Compnay_caseAndCustomerAndCompany> queryByPager(int pageNo, int pageSize, String customer_id) {
		Connection conn = getConn();
		List<Compnay_caseAndCustomerAndCompany> Compnay_caseAndCustomerAndCompanys = new ArrayList<Compnay_caseAndCustomerAndCompany>();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"select top "+pageSize+" * from t_company_case_col a, t_company_case b, t_company c where a.case_id = b.id and b.company_id = c.id and a.customer_id = '"+customer_id+"'  and a.id not in (select top "+(pageNo-1)*pageSize+" a.id from t_company_case_col a, t_company_case b, t_company c  where a.case_id = b.id and b.company_id = c.id and a.customer_id ='"+customer_id+"') ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Compnay_caseAndCustomerAndCompany CompnaycaseAndCustomerAndCompany = new Compnay_caseAndCustomerAndCompany();
				CompnaycaseAndCustomerAndCompany.setCompany_id(rs.getString("company_id"));
				CompnaycaseAndCustomerAndCompany.setCreated_time(rs.getDate("created_time"));
				CompnaycaseAndCustomerAndCompany.setDes(rs.getString("des"));
				CompnaycaseAndCustomerAndCompany.setId(rs.getString("id"));
				CompnaycaseAndCustomerAndCompany.setImage_1(rs.getString("image_1"));
				CompnaycaseAndCustomerAndCompany.setImage_2(rs.getString("image_2"));
				CompnaycaseAndCustomerAndCompany.setImage_3(rs.getString("image_3"));
				CompnaycaseAndCustomerAndCompany.setImage_4(rs.getString("image_4"));
				CompnaycaseAndCustomerAndCompany.setImgae_5(rs.getString("image_5"));
				CompnaycaseAndCustomerAndCompany.setLogo(rs.getString("logo"));
				CompnaycaseAndCustomerAndCompany.setName(rs.getString("name"));
				CompnaycaseAndCustomerAndCompany.setStyle(rs.getString("style"));
				CompnaycaseAndCustomerAndCompany.setStatus(rs.getString("status"));
				CompnaycaseAndCustomerAndCompany.setPlot_name(rs.getString("plot_name"));
				Compnay_caseAndCustomerAndCompanys.add(CompnaycaseAndCustomerAndCompany);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return Compnay_caseAndCustomerAndCompanys;
	}

	@Override
	public int getCount(String customer_id) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement("" +
	                    "select count(id) from (select * from t_company_case_col where customer_id='"+customer_id+"')stu");
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


}
