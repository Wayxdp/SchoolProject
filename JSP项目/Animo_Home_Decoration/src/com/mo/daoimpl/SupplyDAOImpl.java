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
import com.mo.bean.Supply;
import com.mo.bean.SupplyAndProduct;
import com.mo.common.DateUtil;
import com.mo.dao.AbstractBaseDAO;
import com.mo.dao.SupplyDAO;

public class SupplyDAOImpl extends AbstractBaseDAO implements SupplyDAO {

	@Override
	public List<Supply> queryAll() {
		Connection conn = getConn();
		List<Supply> supplys = new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Supply supply = new Supply();
				supply.setId(rs.getString("id"));
				supply.setEmail(rs.getString("email"));
				supply.setPassword(rs.getString("password"));
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getTimestamp("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setLatitude(rs.getFloat("latitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return supplys;
	}

	@Override
	public int count() {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select count(id) from t_supply");
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
	public List<Supply> queryByPager(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Supply> supplys = new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize
					+ " * from (select * from t_supply where status='N')stu where id not in (select top "
					+ (pageNo - 1) * pageSize + " id from (select * from t_supply where status='N')stu)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supply supply = new Supply();
				supply.setId(rs.getString("id"));
				supply.setEmail(rs.getString("email"));
				supply.setPassword(rs.getString("password"));
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getTimestamp("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setLatitude(rs.getFloat("latitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
				supplys.add(supply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return supplys;
	}


	@Override
	public void deleteById(String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("delete from t_supply where id=?");
			ps.setString(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
	}

	@Override
	public void add(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into t_supply(email,password,name,principal,logo,address,phone,tel,open_date,longitude,latitude,des,created_time,checked,checked_time,last_login_time,status)values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, t.getEmail());
			ps.setString(2, t.getPassword());
			ps.setString(3, t.getName());
			ps.setString(4, t.getPrincipal());
			ps.setString(5, t.getLogo());
			ps.setString(6, t.getAddress());
			ps.setString(7, t.getPhone());
			ps.setString(8, t.getTel());
			ps.setTimestamp(9, DateUtil.convert2(t.getOpen_date()));
			ps.setFloat(10, t.getLongitude());
			ps.setFloat(11, t.getLatitude());
			ps.setString(12, t.getDes());
			ps.setTimestamp(13,DateUtil.convert2(t.getCreated_time()));
			ps.setString(14, t.getChecked());
			ps.setTimestamp(15, DateUtil.convert2(t.getChecked_time()));
			ps.setTimestamp(16, DateUtil.convert2(t.getLast_login_time()));
			ps.setString(17, t.getStatus());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		
	}

	@Override
	public void update(Supply t) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_supply set name=?,principal=?,address=?,phone=?,tel=?,longitude=?,latitude=?,des=? where id=?");
			ps.setString(1, t.getName());
			ps.setString(2, t.getPrincipal());
			ps.setString(3, t.getAddress());
			ps.setString(4, t.getPhone());
			ps.setString(5, t.getTel());
			ps.setFloat(6, t.getLongitude());
			ps.setFloat(7, t.getLatitude());
			ps.setString(8, t.getDes());
			ps.setString(9, t.getId());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		
	}

	@Override
	public Supply queryById(String id) {
		Connection conn = getConn();
		Supply supply = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply where id=?");
			ps.setString(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				supply = new Supply();
				supply.setId(id);
				supply.setEmail(rs.getString("email"));
				supply.setPassword(rs.getString("password"));
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getDate("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setLatitude(rs.getFloat("latitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return supply;
	}

	@Override
	public Supply queryByemail(String email) {
		Connection conn = getConn();
		Supply supply = null;
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply where email=?");
			ps.setString(1, email);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				supply = new Supply();
				supply.setId(rs.getString("id"));
				supply.setPassword(rs.getString("password"));
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getTimestamp("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return supply;
	}

	@Override
	public Supply queryByNoPwd(String email, String pwd) {
		Supply supply = null;
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("select * from t_supply where email = ? and password = ?");
			ps.setString(1, email);
			ps.setString(2, pwd);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				supply = new Supply();
				supply.setId(rs.getString("id"));
				supply.setEmail(email);
				supply.setPassword(pwd);
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getTimestamp("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return supply;
	}

	@Override
	public void updatechecked_time(Date checked_time, String id) {
		Connection conn = getConn();
		try {
			PreparedStatement ps = conn.prepareStatement("update t_supply set checked_time=? where id=?");
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
			PreparedStatement ps = conn.prepareStatement("update t_supply set last_login_time=? where id=?");
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
			PreparedStatement ps = conn.prepareStatement("update t_supply set status=?,checked=? where id=?");
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
			PreparedStatement ps = conn.prepareStatement("update t_supply set password=? where id=?");
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
	public List<Supply> queryByPager1(int pageNo, int pageSize) {
		Connection conn = getConn();
		List<Supply> supplys = new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top " + pageSize
					+ " * from (select * from t_supply where status='Y')stu where id not in (select top "
					+ (pageNo - 1) * pageSize + " id from (select * from t_supply where status='Y')stu)");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Supply supply = new Supply();
				supply.setId(rs.getString("id"));
				supply.setEmail(rs.getString("email"));
				supply.setPassword(rs.getString("password"));
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getTimestamp("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setLatitude(rs.getFloat("latitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
				supplys.add(supply);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		close(conn);
		return supplys;
	}

	@Override
	public List<Supply> top3all() {
		Connection conn = getConn();
		List<Supply> supplys = new ArrayList<Supply>();
		try {
			PreparedStatement ps = conn.prepareStatement("select top 3 * from t_supply");
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Supply supply = new Supply();
				supply.setId(rs.getString("id"));
				supply.setEmail(rs.getString("email"));
				supply.setPassword(rs.getString("password"));
				supply.setName(rs.getString("name"));
				supply.setPrincipal(rs.getString("principal"));
				supply.setLogo(rs.getString("logo"));
				supply.setAddress(rs.getString("address"));
				supply.setPhone(rs.getString("phone"));
				supply.setTel(rs.getString("tel"));
				supply.setOpen_date(rs.getTimestamp("open_date"));
				supply.setLongitude(rs.getFloat("longitude"));
				supply.setLatitude(rs.getFloat("latitude"));
				supply.setDes(rs.getString("des"));
				supply.setCreated_time(rs.getTimestamp("created_time"));
				supply.setChecked(rs.getString("checked"));
				supply.setChecked_time(rs.getTimestamp("checked_time"));
				supply.setLast_login_time(rs.getTimestamp("last_login_time"));
				supply.setStatus(rs.getString("status"));
				supplys.add(supply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return supplys;
	}

	@Override
	public SupplyAndProduct queryBysupply_idAndproduct_id(String supply_id, String product_id) {
		Connection conn = getConn();
		SupplyAndProduct supplyAndProduct =null;
		try {
			PreparedStatement ps = conn.prepareStatement("select a.*,b.supply_id,b.productname,b.price,b.sale_price,b.image,b.des  from t_supply a, t_product b where a.id = b.supply_id and b.id=? and a.id=?");
			ps.setString(1, product_id);
			ps.setString(2, supply_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				supplyAndProduct =new SupplyAndProduct();
				supplyAndProduct.setId(rs.getString("id"));
				supplyAndProduct.setName(rs.getString("name"));
				supplyAndProduct.setPrincipal(rs.getString("principal"));
				supplyAndProduct.setLogo(rs.getString("logo"));
				supplyAndProduct.setAddress(rs.getString("address"));
				supplyAndProduct.setTel(rs.getString("tel"));
				supplyAndProduct.setOpen_date(rs.getDate("open_date"));
				supplyAndProduct.setDes(rs.getString("des"));
				supplyAndProduct.setPrice(rs.getFloat("price"));
				supplyAndProduct.setSale_price(rs.getFloat("sale_price"));
				supplyAndProduct.setImage(rs.getString("image"));
				supplyAndProduct.setProductname(rs.getString("productname"));
				supplyAndProduct.setSupply_id(rs.getString("supply_id"));
				supplyAndProduct.setCreated_time(rs.getDate("created_time"));
				supplyAndProduct.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(conn);
		return supplyAndProduct;
	}

}
