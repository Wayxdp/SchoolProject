package com.mo.dao;


import java.util.Date;

import com.mo.bean.Admin;
import com.mo.bean.Company;
/**
 * 管理员
 * @author Animo
 *
 */
public interface AdminDAO extends BaseDAO<String, Admin> {
	
	public Admin queryByNoPwd(String email, String pwd); //通过邮箱和密码判断存不存在
	
	public void updatepwd(String t,String id);//旧密码
	
	public void updaterole(String id,String status);//状态修改
	
	public Admin queryByemail(String email);//根据邮箱来查询用户

public void updatelast_login_time(Date last_login_time,String id);//更新最近登录时间
}
