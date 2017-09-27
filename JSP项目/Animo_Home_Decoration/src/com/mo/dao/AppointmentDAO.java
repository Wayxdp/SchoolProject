package com.mo.dao;

import java.util.List;

import com.mo.bean.Appointment;
/**
 * 用户预约
 * @author Animo
 *
 */
public interface AppointmentDAO extends BaseDAO<String, Appointment>{
	public void adddesigner(Appointment t);//设计师预约
	public int getCount(String designer_id);//查询这个设计师有多少预约的用户数量
	public List<Appointment> queryByPager(int pageNo, int pageSize,String designer_id);//分页查询该设计师有多少预约用户
}
