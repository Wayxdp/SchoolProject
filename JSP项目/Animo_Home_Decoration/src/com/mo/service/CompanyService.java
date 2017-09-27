package com.mo.service;

import java.util.Date;
import java.util.List;

import com.mo.bean.Company;
import com.mo.bean.Company_case;
import com.mo.bean.CompanycaseAndCompany;

public interface CompanyService extends BaseService<String, Company>{
	public Company queryByemail(String email);//根据邮箱来查询用户

	public Company queryByNoPwd(String email,String pwd);//根据邮箱和名称来查询用户

	public void updatechecked_time(Date checked_time,String id);//更新审核时间
	public void updatelast_login_time(Date last_login_time,String id);//更新最近登录时间

	public void updatestatus(String status,String checked ,String id);//更新状态是否可用

	public void updatepwd(String id,String pwd);//更新密码
	
	public List<Company> queryByPager1(int pageNo, int pageSize);
	
	public List<Company> top3all();
	
	public CompanycaseAndCompany queryByCompany_idAndCase_id (String caseid,String Company_id);
}
