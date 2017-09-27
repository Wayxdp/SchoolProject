package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mo.bean.Admin;
import com.mo.bean.Company_case;
import com.mo.bean.CompanycaseAndCompany;
import com.mo.bean.Designer;
import com.mo.common.DateUtil;
import com.mo.common.Encrypt;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.Company_caseDAO;

public class Company_caseDAOImpl extends AbstractBaseDAO implements Company_caseDAO{
	
    private Company_case getT_Company_Case(ResultSet rs)throws SQLException{
    	Company_case t_company_case = new Company_case();
        t_company_case.setId(rs.getString("id"));
        t_company_case.setCompany_id(rs.getString("company_id"));
        t_company_case.setName(rs.getString("name"));
        t_company_case.setPlot_name(rs.getString("plot_name"));
        t_company_case.setStyle(rs.getString("style"));
        t_company_case.setImage_1(rs.getString("image_1"));
        t_company_case.setImage_2(rs.getString("image_2"));
        t_company_case.setImage_3(rs.getString("image_3"));
        t_company_case.setImage_4(rs.getString("image_4"));
        t_company_case.setImgae_5(rs.getString("image_5"));
        t_company_case.setDes(rs.getString("des"));
        t_company_case.setCreated_time(rs.getDate("created_time"));
        t_company_case.setStatus(rs.getString("status"));
        return t_company_case;
    }
	
	@Override
	public List<Company_case> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company_case");
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
	public List<Company_case> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Company_case> companycases = new ArrayList<Company_case>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize + " * from t_company_case where id not in (select top " + (pageNo - 1) * pageSize + " id from t_company_case) ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Company_case companycase = new Company_case();
				companycase.setId(rs.getString("id"));
				companycase.setCompany_id(rs.getString("company_id"));
				companycase.setName(rs.getString("name"));
				companycase.setPlot_name(rs.getString("plot_name"));
				companycase.setStyle(rs.getString("style"));
				companycase.setImage_1(rs.getString("image_1"));
				companycase.setImage_2(rs.getString("image_2"));
				companycase.setImage_3(rs.getString("image_3"));
				companycase.setImage_4(rs.getString("image_4"));
				companycase.setImgae_5(rs.getString("image_5"));
				companycase.setDes(rs.getString("des"));
				companycase.setCreated_time(rs.getTimestamp("created_time"));
				companycase.setStatus(rs.getString("status"));
				companycases.add(companycase);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return companycases;
	}


	@Override
	public void deleteById(String id) {
		  Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement("delete from t_company_case where id=? ");
	            ps.setString(1,id);
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	}

	@Override
	public void add(Company_case t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company_case(company_id,name,plot_name,style,image_1,image_2,image_3,image_4,image_5,des,created_time,status) values(?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, t.getCompany_id());
			ps.setString(2, t.getName());
			ps.setString(3, t.getPlot_name());
			ps.setString(4, t.getStyle());
			ps.setString(5, t.getImage_1());
			ps.setString(6, t.getImage_2());
			ps.setString(7, t.getImage_3());
			ps.setString(8, t.getImage_4());
			ps.setString(9, t.getImgae_5());
			ps.setString(10, t.getDes());
			ps.setTimestamp(11, DateUtil.convert2(t.getCreated_time()));
			ps.setString(12, t.getStatus());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Company_case t) {
        Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement
                    ("update  t_company_case set name=?," +
                            "plot_name=?,style=?,image_1=?,image_2=?,image_3=?," +
                            "image_4=?,image_5=?,des=?" +
                            "  where id=?");
            ps.setString(1,t.getName());
            ps.setString(2,t.getPlot_name());
            ps.setString(3,t.getStyle());
            ps.setString(4,t.getImage_1());
            ps.setString(5,t.getImage_2());
            ps.setString(6,t.getImage_3());
            ps.setString(7,t.getImage_4());
            ps.setString(8,t.getImgae_5());
            ps.setString(9,t.getDes());
            ps.setString(10, t.getId());
            ps.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
	}

	@Override
	public Company_case queryById(String id) {
		  Connection conn = getConn();
	        Company_case companycase=null;
	        try {
	            PreparedStatement ps = conn.prepareStatement("select * from t_company_case where id=?");
	            ps.setString(1,id);
	            ResultSet rs = ps.executeQuery();
	            if(rs.next()){
	            	companycase = getT_Company_Case(rs);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	        return companycase;
	}

	@Override
	public List<Company_case> queryByPager(int pageNo, int pageSize, String company_id) {
        Connection conn = getConn();
        List<Company_case> companycases = new ArrayList<Company_case>();
        try {
            PreparedStatement ps = conn.prepareStatement("select top "+pageSize+" * from " +
                    "(select * from t_company_case where company_id='"+company_id+"')stu where id not" +
                    " in (select top "+(pageNo-1)*pageSize+
                    " id from (select * from t_company_case where company_id='"+company_id+"')stu)");
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
            	 Company_case companycase = new Company_case();
            	 companycase.setId(rs.getString("id"));
            	 companycase.setCompany_id(rs.getString("company_id"));
            	 companycase.setName(rs.getString("name"));
            	 companycase.setPlot_name(rs.getString("plot_name"));
            	 companycase.setStyle(rs.getString("style"));
            	 companycase.setImage_1(rs.getString("image_1"));
            	 companycase.setImage_2(rs.getString("image_2"));
            	 companycase.setImage_3(rs.getString("image_3"));
            	 companycase.setImage_4(rs.getString("image_4"));
            	 companycase.setImgae_5(rs.getString("image_5"));
            	 companycase.setDes(rs.getString("des"));
            	 companycase.setCreated_time(rs.getDate("created_time"));
            	 companycase.setStatus(rs.getString("status"));
                 companycases.add(companycase);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        close(conn);
        return companycases;
	}

	@Override
	public void updateStatus(String id, String status) {
		 Connection conn = getConn();
	        try {
	            PreparedStatement ps = conn.prepareStatement
	                    ("update  t_company_case set status=?  where id=?");
	            ps.setString(1,status);
	            ps.setString(2,id);
	            ps.execute();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        close(conn);
	    }

	@Override
	public List<Company_case> top3all() {
		Connection conn = getConn();
		List<Company_case> Company_cases = new ArrayList<Company_case>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top 3  *  from t_company_case ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Company_case company_case = new Company_case();
				company_case = getT_Company_Case(rs);
				Company_cases.add(company_case);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return Company_cases;
	}

	@Override
	public int queryCount(String company_id) {
		Connection conn = getConn();
        try {
            PreparedStatement ps = conn.prepareStatement("" +
                    "select count(id) from (select * from t_company_case where company_id='"+company_id+"')stu");
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
	public List<CompanycaseAndCompany> queryByPagercase(int pageNo, int pageSize){
		Connection conn = getConn();
		List<CompanycaseAndCompany> CompanycaseAndCompanys = new ArrayList<CompanycaseAndCompany>();
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement("select top "+pageSize+" b.*,a.email,a.company_name,a.principal,a.logo,a.address,a.phone,a.tel,a.open_date,a.des from t_company a, t_company_case b where a.id = b.company_id and b.id not in ( select top "+(pageNo-1)*pageSize+" b.id from t_company a, t_company_case b where a.id = b.company_id) ");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CompanycaseAndCompany companycaseAndCompany = new CompanycaseAndCompany();
				companycaseAndCompany.setName(rs.getString("name"));
				companycaseAndCompany.setAddress(rs.getString("address"));
				companycaseAndCompany.setCompany_id(rs.getString("company_id"));
				companycaseAndCompany.setCreated_time(rs.getDate("created_time"));
				companycaseAndCompany.setDes(rs.getString("des"));
				companycaseAndCompany.setId(rs.getString("id"));
				companycaseAndCompany.setImage_1(rs.getString("image_1"));
				companycaseAndCompany.setImage_2(rs.getString("image_2"));
				companycaseAndCompany.setImage_3(rs.getString("image_3"));
				companycaseAndCompany.setImage_4(rs.getString("image_4"));
				companycaseAndCompany.setImgae_5(rs.getString("image_5"));
				companycaseAndCompany.setCompany_name(rs.getString("company_name"));
				companycaseAndCompany.setLogo(rs.getString("logo"));
				companycaseAndCompany.setOpen_date(rs.getDate("open_date"));
				companycaseAndCompany.setPhone(rs.getString("phone"));
				companycaseAndCompany.setPlot_name(rs.getString("plot_name"));
				companycaseAndCompany.setPrincipal(rs.getString("principal"));
				companycaseAndCompany.setStatus(rs.getString("status"));
				companycaseAndCompany.setStyle(rs.getString("style"));
				companycaseAndCompany.setTel(rs.getString("tel"));
				CompanycaseAndCompanys.add(companycaseAndCompany);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return 	CompanycaseAndCompanys;
	}
}
