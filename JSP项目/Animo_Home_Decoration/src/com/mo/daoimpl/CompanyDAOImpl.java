package com.mo.daoimpl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.CompanycaseAndCompany;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.CompanyDAO;

public class CompanyDAOImpl extends AbstractBaseDAO implements CompanyDAO{

	@Override
	public List<Company> queryAll() {
		Connection conn = getConn();
		List<Company> companys = new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Company company = new Company();
				company.setId(rs.getString("id"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getTimestamp("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setLatitude(rs.getFloat("latitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return companys;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_company");
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
	public List<Company> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Company> companys = new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize
					+ " * from (select * from t_company where status='N')stu where id not in (select top "
					+ (pageNo - 1) * pageSize + " id from (select * from t_company where status='N')stu)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getString("id"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getTimestamp("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setLatitude(rs.getFloat("latitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
				companys.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return companys;
	}


	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_company where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}


	@Override
	public void add(Company t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_company(email,password,company_name,principal,logo,address,tel,open_date,created_time,checked,checked_time,status,phone)values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getCompany_name());
			ps.setString(4, t.getPrincipal());
			ps.setString(5, t.getLogo());
			ps.setString(6, t.getAddress());
			ps.setString(7, t.getTel());
			ps.setTimestamp(8, DateUtil.convert2(t.getOpen_date()));
			ps.setTimestamp(9,DateUtil.convert2(t.getCreated_time()));
			ps.setString(10, t.getChecked());
			ps.setTimestamp(11, DateUtil.convert2(t.getChecked_time()));
			ps.setString(12, t.getStatus());
			ps.setString(13, t.getPhone());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Company t) {
		System.out.println(t);
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set company_name=?,principal=?,address=?,phone=?,tel=?,longitude=?,latitude=?,des=?,logo=? where id=?");
			ps.setString(1, t.getCompany_name());
			ps.setString(2, t.getPrincipal());
			ps.setString(3, t.getAddress());
			ps.setString(4, t.getPhone());
			ps.setString(5, t.getTel());
			ps.setFloat(6, t.getLongitude());
			ps.setFloat(7, t.getLatitude());
			ps.setString(8, t.getDes());
			ps.setString(9, t.getLogo());
			ps.setString(10, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		
	}

	@Override
	public Company queryById(String id) {
		Connection conn = getConn();
		Company company = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				company = new Company();
				company.setId(rs.getString("id"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getDate("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setLatitude(rs.getFloat("latitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return company;
	}

	@Override
	public Company queryByemail(String email) {
		Connection conn = getConn();
		Company company = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				company = new Company();
				company.setId(rs.getString("id"));
				company.setPassword(rs.getString("password"));
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getTimestamp("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return company;
	}

	@Override
	public Company queryByNoPwd(String email, String pwd) {
		Company company = null;
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_company where email = ? and password = ? ");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				company = new Company();
				company.setId(rs.getString("id"));
				company.setEmail(email);
				company.setPassword(pwd);
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getTimestamp("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return company;
	}

	@Override
	public void updatechecked_time(Date checked_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set checked_time=? where id=?");
			ps.setTimestamp(1, DateUtil.convert2(checked_time));
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set last_login_time=? where id=?");
			ps.setTimestamp(1, DateUtil.convert2(last_login_time));
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void updatestatus(String status,String checked , String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set status=?,checked=? where id=?");
			ps.setString(1, status);
			ps.setString(2, checked);
			ps.setString(3, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void updatepwd(String id, String pwd) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_company set password=? where id=?");
			ps.setString(1, pwd);
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public List<Company> queryByPager1(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Company> companys = new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize
					+ " * from (select * from t_company where status='Y')stu where id not in (select top "
					+ (pageNo - 1) * pageSize + " id from (select * from t_company where status='Y')stu)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getString("id"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getTimestamp("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setLatitude(rs.getFloat("latitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
				companys.add(company);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return companys;
	}

	@Override
	public List<Company> top3all() {
		Connection conn = getConn();
		List<Company> companys = new ArrayList<Company>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top 3  *  from t_company");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Company company = new Company();
				company.setId(rs.getString("id"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));
				company.setCompany_name(rs.getString("company_name"));
				company.setPrincipal(rs.getString("principal"));
				company.setLogo(rs.getString("logo"));
				company.setAddress(rs.getString("address"));
				company.setPhone(rs.getString("phone"));
				company.setTel(rs.getString("tel"));
				company.setOpen_date(rs.getDate("open_date"));
				company.setLongitude(rs.getFloat("longitude"));
				company.setLatitude(rs.getFloat("latitude"));
				company.setDes(rs.getString("des"));
				company.setCreated_time(rs.getTimestamp("created_time"));
				company.setChecked(rs.getString("checked"));
				company.setChecked_time(rs.getTimestamp("checked_time"));
				company.setLast_login_time(rs.getTimestamp("last_login_time"));
				company.setStatus(rs.getString("status"));
				companys.add(company);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return companys;
	}

	@Override
	public CompanycaseAndCompany queryByCompany_idAndCase_id(String caseid, String Company_id) {
		Connection conn = getConn();
		CompanycaseAndCompany companycaseAndCompany=null;
		try {
			PreparedStatement ps = conn.prepareStatement("select b.*,a.company_name,a.principal,a.logo,a.address,a.phone,a.tel,a.open_date from t_company a, t_company_case b where a.id = b.company_id and b.id=? and a.id=? ");
			ps.setString(1, caseid);
			ps.setString(2, Company_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				companycaseAndCompany = new CompanycaseAndCompany();
				companycaseAndCompany.setAddress(rs.getString("address"));
				companycaseAndCompany.setCompany_id(rs.getString("company_id"));
				companycaseAndCompany.setCompany_name(rs.getString("company_name"));
				companycaseAndCompany.setCreated_time(rs.getDate("created_time"));
				companycaseAndCompany.setDes(rs.getString("des"));
				companycaseAndCompany.setId(rs.getString("id"));
				companycaseAndCompany.setImage_1(rs.getString("image_1"));
				companycaseAndCompany.setImage_2(rs.getString("image_2"));
				companycaseAndCompany.setImage_3(rs.getString("image_3"));
				companycaseAndCompany.setImage_4(rs.getString("image_4"));
				companycaseAndCompany.setImgae_5(rs.getString("image_5"));
				companycaseAndCompany.setLogo(rs.getString("logo"));
				companycaseAndCompany.setName(rs.getString("name"));
				companycaseAndCompany.setOpen_date(rs.getDate("open_date"));
				companycaseAndCompany.setPhone(rs.getString("phone"));
				companycaseAndCompany.setPlot_name(rs.getString("plot_name"));
				companycaseAndCompany.setPrincipal(rs.getString("principal"));
				companycaseAndCompany.setStyle(rs.getString("style"));
				companycaseAndCompany.setTel(rs.getString("tel"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return companycaseAndCompany;
	}
}
