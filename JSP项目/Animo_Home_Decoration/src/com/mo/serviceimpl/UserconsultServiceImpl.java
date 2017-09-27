package com.mo.serviceimpl;


import java.util.List;


import com.mo.bean.Userconsult;
import com.mo.dao.UserconsultDAO;
import com.mo.daoimpl.UserconsultDAOImpl;
import com.mo.service.UserconsultService;


public class UserconsultServiceImpl implements UserconsultService{

	private UserconsultDAO userconsultDAO;
	
	public UserconsultServiceImpl(){
		userconsultDAO = new UserconsultDAOImpl();
	}
	@Override
	public List<Userconsult> queryAll() {
		// TODO Auto-generated method stub
		return userconsultDAO.queryAll();
	}


	@Override
	public int count() {
		return userconsultDAO.count();
	}


	@Override
	public List<Userconsult> queryByPager(int pageNo, int pageSize) {
		return userconsultDAO.queryByPager(pageNo, pageSize);
	}


	@Override
	public void add(Userconsult t) {
		userconsultDAO.add(t);
	}


	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		userconsultDAO.deleteById(id);
	}


	@Override
	public void update(Userconsult t) {
		// TODO Auto-generated method stub
		userconsultDAO.update(t);
	}


	@Override
	public Userconsult queryById(String id) {
		// TODO Auto-generated method stub
		return userconsultDAO.queryById(id);
	}
	
}
