package com.mo.service;

import java.util.List;

import com.mo.bean.Designer_col;
import com.mo.bean.DesignercaseAndDesigner;

public interface Designer_colService extends BaseService<String, Designer_col>{
	public Designer_col queryBycustomerIdBydesignerId(String customerid,String desingerid);
	public List<DesignercaseAndDesigner> queryByCustomerid(int pageNo, int pageSize,String customerid);
	public int getconn(String customerid);
}
