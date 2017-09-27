package com.mo.dao;

import java.util.List;

import com.mo.bean.Appointment;
import com.mo.bean.Supply_appointment;

public interface Supply_appointmentDAO  extends BaseDAO<String, Appointment>{
	
	public void addsupply(Supply_appointment t);//设计师预约
	public int getCount(String supply_id);//查询这个设计师有多少预约的用户数量
	public List<Supply_appointment> queryByPager(int pageNo, int pageSize,String designer_id);//分页查询该设计师有多少预约用户

}
