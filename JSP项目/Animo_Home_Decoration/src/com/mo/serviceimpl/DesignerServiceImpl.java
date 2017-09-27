package com.mo.serviceimpl;

import java.util.List;

import com.mo.bean.Designer;
import com.mo.bean.DesignerAndCase;
import com.mo.dao.DesignerDAO;
import com.mo.daoimpl.DesignerDAOImpl;
import com.mo.service.DesignerService;

public class DesignerServiceImpl implements DesignerService{
	private DesignerDAO designerDAO;
	
	public DesignerServiceImpl(){
		designerDAO = new DesignerDAOImpl();
	}
	@Override
	public List<Designer> queryAll() {
		// TODO Auto-generated method stub
		return designerDAO.queryAll();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return designerDAO.count();
	}

	@Override
	public List<Designer> queryByPager(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return designerDAO.queryByPager(pageNo, pageSize);
	}

	@Override
	public void deleteById(String id) {
		// TODO Auto-generated method stub
		designerDAO.deleteById(id);
	}

	@Override
	public void add(Designer t) {
		// TODO Auto-generated method stub
		designerDAO.add(t);
	}
	@Override
	public void update(Designer t) {
		// TODO Auto-generated method stub
		designerDAO.update(t);
	}
	@Override
	public Designer queryById(String id) {
		// TODO Auto-generated method stub
		return designerDAO.queryById(id);
	}
	@Override
	public void updaterole( String status,String checked ,String id) {
		// TODO Auto-generated method stub
		designerDAO.updaterole( status,checked,id);
	}
	@Override
	public Designer queryByNoPwd(String email, String pwd) {
		// TODO Auto-generated method stub
		return designerDAO.queryByNoPwd(email, pwd);
	}
	@Override
	public List<Designer> queryByPager1(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return designerDAO.queryByPager1(pageNo, pageSize);
	}
	@Override
	public void update(String id, java.util.Date date) {
		// TODO Auto-generated method stub
		designerDAO.update(id, date);
	}
	@Override
	public Designer queryByemail(String email) {
		// TODO Auto-generated method stub
		return designerDAO.queryByemail(email);
	}
	@Override
	public void updatelast_login_time(java.util.Date last_login_time, String id) {
		// TODO Auto-generated method stub
		designerDAO.updatelast_login_time(last_login_time, id);
	}
	@Override
	public void updatepwd(String id, String pwd) {
		// TODO Auto-generated method stub
		designerDAO.updatepwd(id, pwd);
	}
	@Override
	public List<Designer> top3all() {
		// TODO Auto-generated method stub
		return designerDAO.top3all();
	}
	@Override
	public List<DesignerAndCase> allDesignerAndCase() {
		// TODO Auto-generated method stub
		return designerDAO.allDesignerAndCase();
	}
	@Override
	public DesignerAndCase queryByCase_idAndDesigner_id(String Case_id, String Designer_id) {
		// TODO Auto-generated method stub
		return designerDAO.queryByCase_idAndDesigner_id(Case_id, Designer_id);
	}
	@Override
	public List<DesignerAndCase> queryByPagercase(int pageNo, int pageSize) {
		// TODO Auto-generated method stub
		return designerDAO.queryByPagercase(pageNo, pageSize);
	}
	
}
