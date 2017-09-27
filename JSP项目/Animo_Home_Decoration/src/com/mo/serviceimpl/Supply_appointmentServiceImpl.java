package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Company_appointment;
import com.mo.bean.Supply_appointment;
import com.mo.dao.Supply_appointmentDAO;
import com.mo.daoimpl.Supply_appointementDAOImpl;
import com.mo.service.Supply_appointementService;

public class Supply_appointmentServiceImpl implements Supply_appointementService{

	private Supply_appointmentDAO supplyAppointement;
	
	public Supply_appointmentServiceImpl(){
		supplyAppointement = new Supply_appointementDAOImpl();
	}
//
//	@Override
//	public List<Supply_appointment> queryAll() {
//		// TODO Auto-generated method stub
//		return supplyAppointement.queryAll();
//	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return supplyAppointement.count();
	}

//	@Override
//	public List<Company_appointment> queryByPager(int pageNo, int pageSize) {
//		// TODO Auto-generated method stub
//		return supplyAppointement.queryByPager(pageNo, pageSize);
//	}

//	@Override
//	public void add(Company_appointment t) {
//		// TODO Auto-generated method stub
//		supplyAppointement.add(t);
//	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		supplyAppointement.deleteById(id);
	}

//	@Override
//	public void update(Company_appointment t) {
//		// TODO Auto-generated method stub
//		supplyAppointement.update(t);
//	}

//	@Override
//	public Company_appointment queryById(String id) {
//		// TODO Auto-generated method stub
//		return null;supplyAppointement.queryById(id);
//	}

	@Override
	public void addsupply(Supply_appointment t) {
		// TODO Auto-generated method stub
		supplyAppointement.addsupply(t);
	}

	@Override
	public int getCount(String supply_id) {
		// TODO Auto-generated method stub
		return supplyAppointement.getCount(supply_id);
	}

	@Override
	public List<Supply_appointment> queryByPager(int pageNo, int pageSize, String supply_id) {
		// TODO Auto-generated method stub
		return supplyAppointement.queryByPager(pageNo, pageSize, supply_id);
	}

	@Override
	public List<Company_appointment> queryAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Company_appointment> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(Company_appointment t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Company_appointment t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Company_appointment queryById(String id) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
