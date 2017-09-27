package com.mo.service;

import java.util.List;

import com.mo.bean.Company_appointment;
import com.mo.bean.Supply_appointment;

public interface Supply_appointementService extends BaseService<String, Company_appointment>{
	
	public void addsupply(Supply_appointment t);//设计师预约
	public int getCount(String supplyy_id);//查询这个设计师有多少预约的用户数量
	public List<Supply_appointment> queryByPager(int pageNo, int pageSize,String supply_id);//分页查询该设计师有多少预约用户

}
