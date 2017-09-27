package com.mo.dao;

import java.util.Date;
import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.Designer;
import com.mo.bean.DesignerAndCase;
import com.mo.bean.Supply;
import com.mo.bean.SupplyAndProduct;
/**
 * 建材商
 * @author Animo
 *
 */
public interface SupplyDAO extends BaseDAO<String, Supply>{

	

public Supply queryByemail(String email);//根据邮箱来查询用户

public Supply queryByNoPwd(String email,String pwd);//根据邮箱和名称来查询用户

public void updatechecked_time(Date checked_time,String id);//更新审核时间
public void updatelast_login_time(Date last_login_time,String id);//更新最近登录时间

public void updatestatus(String status,String checked ,String id);//更新状态是否可用

public void updatepwd(String id,String pwd);//更新密码

public List<Supply> queryByPager1(int pageNo, int pageSize);

public List<Supply> top3all();

public SupplyAndProduct queryBysupply_idAndproduct_id(String supply_id,String product_id);
}
