package com.mo.service;

import java.util.List;

import com.mo.bean.Supply_col;
import com.mo.bean.Supply_colAndsupply;

public interface Supply_colService extends BaseService<String, Supply_col>{
	public Supply_col queryBycustomerIdBycompanyId(String customerid, String supplyid);
	public int getconn(String customerid);
	public List<Supply_colAndsupply> queryByCustomerid(int pageNo, int pageSize,String customerid);
}
