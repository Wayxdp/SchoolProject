package com.mo.daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.mo.bean.Customer;
import com.mo.bean.Designer;
import com.mo.bean.DesignerAndCase;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.BaseDAO;
import com.mo.dao.DesignerDAO;

public class DesignerDAOImpl extends AbstractBaseDAO implements DesignerDAO {


	@Override
	public List<Designer> queryAll() {
		Connection conn = getConn();
		List<Designer> designers = new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top 6  *  from t_designer ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Designer designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(rs.getString("email"));
				designer.setPassword(rs.getString("password"));
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getDate("last_login_time"));
				designer.setStatus(rs.getString("status"));
				designers.add(designer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return designers;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_designer");
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
	public List<Designer> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Designer> designers = new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize
					+ " * from (select * from t_designer where status='N')stu where id not in (select top "
					+ (pageNo - 1) * pageSize + " id from (select * from t_designer where status='N')stu) ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Designer designer = new Designer();
				designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(rs.getString("email"));
				designer.setPassword(rs.getString("password"));
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getDate("last_login_time"));
				designer.setStatus(rs.getString("status"));
				designers.add(designer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return designers;
	}

	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_designer where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void add(Designer t) {
		Connection conn = getConn();
		try { // created_time,checked_time,last_login_time,
			PreparedStatement ps = conn.prepareStatement(
					"insert into t_designer(email,password,name,headicon,phone,address,experience,style,des,created_time,checked,checked_time,last_login_time,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getHeadicon());
			ps.setString(5, t.getPhone());
			ps.setString(6, t.getAddress());
			ps.setString(7, t.getExperience());
			ps.setString(8, t.getStyle());
			ps.setString(9, t.getDes());
			ps.setTimestamp(10, DateUtil.convert2(t.getCreated_time()));
			ps.setString(11, t.getChecked());
			ps.setTimestamp(12, DateUtil.convert2(t.getChecked_time()));
			ps.setTimestamp(13, DateUtil.convert2(t.getLast_login_time()));
			ps.setString(14, t.getStatus());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void update(Designer t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement(
					"update t_designer set name=?,phone=?,des=?,experience=?,style=?,email=?,created_time=?,last_login_time=?,headicon=? where id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPhone());
			ps.setString(3, t.getDes());
			ps.setString(4, t.getExperience());
			ps.setString(5, t.getStyle());
			ps.setString(6, t.getEmail());
			ps.setTimestamp(7, DateUtil.convert2(t.getCreated_time()));
			ps.setTimestamp(8,DateUtil.convert2(t.getLast_login_time()));
			ps.setString(9,t.getHeadicon());
			ps.setString(10, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Designer queryById(String id) {
		Connection conn = getConn();
		Designer designer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(rs.getString("email"));
				designer.setPassword(rs.getString("password"));
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getTimestamp("last_login_time"));
				designer.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return designer;
	}

	@Override
	public Designer queryByNoPwd(String email, String pwd) {
		Designer designer = null;
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer where email = ? and password = ? ");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(email);
				designer.setPassword(pwd);
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getTimestamp("last_login_time"));
				designer.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return designer;
	}

	@Override
	public void updaterole( String status,String checked ,String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer set status=?,checked=? where id=?");
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
	public List<Designer> queryByPager1(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Designer> designers = new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize
					+ " * from (select * from t_designer where status='Y')stu where id not in (select top "
					+ (pageNo - 1) * pageSize + " id from (select * from t_designer where status='Y')stu) ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Designer designer = new Designer();
				designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(rs.getString("email"));
				designer.setPassword(rs.getString("password"));
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getTimestamp("last_login_time"));
				designer.setStatus(rs.getString("status"));
				designers.add(designer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return designers;
	}

	@Override
	public void update(String id, java.util.Date date) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer set checked_time=? where id=?");
			ps.setTimestamp(1, DateUtil.convert2(date));
			ps.setString(2, id);
			ps.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public Designer queryByemail(String email) {
		Connection conn = getConn();
		Designer designer = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_designer where email=? ");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(email);
				designer.setPassword(rs.getString("password"));
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getTimestamp("last_login_time"));
				designer.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return designer;
	}

	@Override
	public void updatelast_login_time(Date last_login_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer set last_login_time=? where id=?");
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
	public void updatepwd(String id, String pwd) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_designer set password=? where id=?");
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
	public List<Designer> top3all() {
		Connection conn = getConn();
		List<Designer> designers = new ArrayList<Designer>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top 3  *  from t_designer ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Designer designer = new Designer();
				designer.setId(rs.getString("id"));
				designer.setEmail(rs.getString("email"));
				designer.setPassword(rs.getString("password"));
				designer.setName(rs.getString("name"));
				designer.setHeadicon(rs.getString("headicon"));
				designer.setPhone(rs.getString("phone"));
				designer.setAddress(rs.getString("address"));
				designer.setExperience(rs.getString("experience"));
				designer.setStyle(rs.getString("style"));
				designer.setDes(rs.getString("des"));
				designer.setCreated_time(rs.getTimestamp("created_time"));
				designer.setChecked(rs.getString("checked"));
				designer.setChecked_time(rs.getTimestamp("checked_time"));
				designer.setLast_login_time(rs.getDate("last_login_time"));
				designer.setStatus(rs.getString("status"));
				designers.add(designer);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return designers;
	}

	@Override
	public List<DesignerAndCase> allDesignerAndCase() {
		Connection conn = getConn();
		List<DesignerAndCase> designerAndCases = new ArrayList<DesignerAndCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select a.*,b.caseid,b.image_1,b.image_2,b.image_3,b.image_4,b.image_5,b.casename,b.plot_name,b.style,b.des,b.created_time from t_designer a, t_designer_case b where a.id = b.designer_id");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				DesignerAndCase designerAndCase = new DesignerAndCase();
				designerAndCase.setId(rs.getString("id"));
				designerAndCase.setEmail(rs.getString("email"));
				designerAndCase.setPassword(rs.getString("password"));
				designerAndCase.setName(rs.getString("name"));
				designerAndCase.setHeadicon(rs.getString("headicon"));
				designerAndCase.setPhone(rs.getString("phone"));
				designerAndCase.setAddress(rs.getString("address"));
				designerAndCase.setExperience(rs.getString("experience"));
				designerAndCase.setStyle(rs.getString("style"));
				designerAndCase.setChecked(rs.getString("checked"));
				designerAndCase.setChecked_time(rs.getTimestamp("checked_time"));
				designerAndCase.setLast_login_time(rs.getDate("last_login_time"));
				designerAndCase.setStatus(rs.getString("status"));
				designerAndCase.setCasename(rs.getString("casename"));
				designerAndCase.setPlot_name(rs.getString("plot_name"));
				designerAndCase.setImage_1(rs.getString("image_1"));
				designerAndCase.setImage_2(rs.getString("image_2"));
				designerAndCase.setImage_3(rs.getString("image_3"));
				designerAndCase.setImage_4(rs.getString("image_4"));
				designerAndCase.setImage_5(rs.getString("image_5"));
				designerAndCase.setCreated_time(rs.getTimestamp("created_time"));
				designerAndCase.setCaseid(rs.getString("caseid"));
				designerAndCases.add(designerAndCase);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return designerAndCases;
	}

	@Override
	public DesignerAndCase queryByCase_idAndDesigner_id(String Case_id, String Designer_id) {
		Connection conn = getConn();
		DesignerAndCase designerAndCase = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select a.*,b.caseid,b.image_1,b.image_2,b.image_3,b.image_4,b.image_5,b.casename,b.plot_name,b.style,b.des,b.created_time from t_designer a, t_designer_case b where a.id = b.designer_id and b.caseid=? and a.id=? ");
			ps.setString(1, Case_id);
			ps.setString(2, Designer_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				designerAndCase = new DesignerAndCase();
				designerAndCase.setId(rs.getString("id"));
				designerAndCase.setCaseid(rs.getString("caseid"));
				designerAndCase.setDes(rs.getString("des"));
				designerAndCase.setEmail(rs.getString("email"));
				designerAndCase.setPassword(rs.getString("password"));
				designerAndCase.setName(rs.getString("name"));
				designerAndCase.setHeadicon(rs.getString("headicon"));
				designerAndCase.setPhone(rs.getString("phone"));
				designerAndCase.setAddress(rs.getString("address"));
				designerAndCase.setExperience(rs.getString("experience"));
				designerAndCase.setStyle(rs.getString("style"));
				designerAndCase.setChecked(rs.getString("checked"));
				designerAndCase.setChecked_time(rs.getTimestamp("checked_time"));
				designerAndCase.setLast_login_time(rs.getDate("last_login_time"));
				designerAndCase.setStatus(rs.getString("status"));
				designerAndCase.setCasename(rs.getString("casename"));
				designerAndCase.setPlot_name(rs.getString("plot_name"));
				designerAndCase.setImage_1(rs.getString("image_1"));
				designerAndCase.setImage_2(rs.getString("image_2"));
				designerAndCase.setImage_3(rs.getString("image_3"));
				designerAndCase.setImage_4(rs.getString("image_4"));
				designerAndCase.setImage_5(rs.getString("image_5"));
				designerAndCase.setCreated_time(rs.getTimestamp("created_time"));
				designerAndCase.setCaseid(rs.getString("caseid"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return designerAndCase;
	}

	@Override
	public List<DesignerAndCase> queryByPagercase(int pageNo, int pageSize) {
		Connection conn = getConn();
		DesignerAndCase designerAndCase = null;
		List<DesignerAndCase> DesignerAndCases = new ArrayList<DesignerAndCase>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize +" a.*,b.caseid,b.image_1,b.image_2,b.image_3,b.image_4,b.image_5,b.casename,b.plot_name,b.style,b.des,b.created_time from t_designer a, t_designer_case b where a.id = b.designer_id and a.id not in ( select top " + (pageNo - 1) * pageSize + " a.id from t_designer a, t_designer_case b where a.id = b.designer_id) ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				designerAndCase = new DesignerAndCase();
				designerAndCase.setId(rs.getString("id"));
				designerAndCase.setCaseid(rs.getString("caseid"));
				designerAndCase.setDes(rs.getString("des"));
				designerAndCase.setEmail(rs.getString("email"));
				designerAndCase.setPassword(rs.getString("password"));
				designerAndCase.setName(rs.getString("name"));
				designerAndCase.setHeadicon(rs.getString("headicon"));
				designerAndCase.setPhone(rs.getString("phone"));
				designerAndCase.setAddress(rs.getString("address"));
				designerAndCase.setExperience(rs.getString("experience"));
				designerAndCase.setStyle(rs.getString("style"));
				designerAndCase.setChecked(rs.getString("checked"));
				designerAndCase.setChecked_time(rs.getTimestamp("checked_time"));
				designerAndCase.setLast_login_time(rs.getDate("last_login_time"));
				designerAndCase.setStatus(rs.getString("status"));
				designerAndCase.setCasename(rs.getString("casename"));
				designerAndCase.setPlot_name(rs.getString("plot_name"));
				designerAndCase.setImage_1(rs.getString("image_1"));
				designerAndCase.setImage_2(rs.getString("image_2"));
				designerAndCase.setImage_3(rs.getString("image_3"));
				designerAndCase.setImage_4(rs.getString("image_4"));
				designerAndCase.setImage_5(rs.getString("image_5"));
				designerAndCase.setCreated_time(rs.getTimestamp("created_time"));
				designerAndCase.setCaseid(rs.getString("caseid"));
				DesignerAndCases.add(designerAndCase);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return DesignerAndCases;
	}
}
