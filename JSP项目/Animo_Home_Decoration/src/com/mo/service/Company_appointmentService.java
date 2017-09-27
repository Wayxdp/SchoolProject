package com.mo.service;

import java.util.List;

import com.mo.bean.Company_appointment;

public interface Company_appointmentService extends BaseService<String, Company_appointment>{

	public void addcompany(Company_appointment t);//设计师预约
	public int getCount(String company_id);//查询这个设计师有多少预约的用户数量
	public List<Company_appointment> queryByPager(int pageNo, int pageSize,String company_id);//分页查询该设计师有多少预约用户
	
}
