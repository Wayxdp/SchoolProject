package com.xy.dao;

import com.xy.bean.Designer;

public interface DesBaseDao extends BaseDao<Integer, Designer>{
	
	public Designer queryEmialAndPwd(String email, String pwd);
}
