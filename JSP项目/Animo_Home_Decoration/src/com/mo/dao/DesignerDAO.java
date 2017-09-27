package com.mo.dao;
import java.util.Date;
import java.util.List;

import com.mo.bean.CompanycaseAndCompany;
/**
 * 设计师
 */
import com.mo.bean.Designer;
import com.mo.bean.DesignerAndCase;

public interface DesignerDAO extends BaseDAO<String, Designer>{
	public List<Designer> queryByPager1(int pageNo, int pageSize);//分页查询  传参：页码 --每页显示个数
	

public Designer queryByemail(String email);//根据邮箱来查询用户

public Designer queryByNoPwd(String email,String pwd);//根据邮箱和名称来查询用户

public void update(String id,Date date);//更新审核时间

public void updatelast_login_time(Date last_login_time,String id);//更新最近登录时间

public void updaterole(String status,String checked,String id);//更新状态是否可用

public void updatepwd(String id,String pwd);//更新密码

public List<Designer> top3all();

public List<DesignerAndCase> allDesignerAndCase();

public DesignerAndCase queryByCase_idAndDesigner_id(String Case_id,String Designer_id);

public List<DesignerAndCase> queryByPagercase(int pageNo, int pageSize);

}
