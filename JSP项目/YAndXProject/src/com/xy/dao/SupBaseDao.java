package com.xy.dao;

import com.xy.bean.Supply;

public interface SupBaseDao extends BaseDao<Integer, Supply>{
	
	public Supply queryEmialAndPwd(String email, String pwd);
}
