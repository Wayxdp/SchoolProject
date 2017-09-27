package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Appointment;
import com.mo.dao.AppointmentDAO;
import com.mo.daoimpl.AppointmentDAOImpl;
import com.mo.service.AppointmentService;

public class AppointmentServiceImpl implements AppointmentService{

	private AppointmentDAO appointmentDAO;
	
	public AppointmentServiceImpl(){
		appointmentDAO = new AppointmentDAOImpl();
	}
	
	@Override
	public List<Appointment> queryAll() {
		// TODO Auto-generated method stub
		return appointmentDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return appointmentDAO.count();
	}

	@Override
	public List<Appointment> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return appointmentDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		appointmentDAO.deleteById(id);
	}


	@Override
	public void add(Appointment t) {
		// TODO Auto-generated method stub
		appointmentDAO.add(t);
	}

	@Override
	public void update(Appointment t) {
		// TODO Auto-generated method stub
		appointmentDAO.update(t);
	}

	@Override
	public Appointment queryById(String id) {
		// TODO Auto-generated method stub
		return appointmentDAO.queryById(id);
	}

	@Override
	public void adddesigner(Appointment t) {
		// TODO Auto-generated method stub
		appointmentDAO.adddesigner(t);
	}

	@Override
	public int getCount(String designer_id) {
		// TODO Auto-generated method stub
		return appointmentDAO.getCount(designer_id);
	}

	@Override
	public List<Appointment> queryByPager(int pageNo, int pageSize, String designer_id) {
		// TODO Auto-generated method stub
		return appointmentDAO.queryByPager(pageNo, pageSize, designer_id);
	}

}
