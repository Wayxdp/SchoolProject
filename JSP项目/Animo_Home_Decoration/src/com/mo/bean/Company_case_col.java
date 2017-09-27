package com.mo.bean;

import java.util.Date;
/**
 * 装修公司案例收藏表
 * @author CMY
 *
 */
public class Company_case_col {
	
	private String id;				//id
	private String customer_id;		//顾客id
	private String case_id	;		//装修公司案例id
	private Date created_time;		//创建时间
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCustomer_id() {
		return customer_id;
	}
	public void setCustomer_id(String customer_id) {
		this.customer_id = customer_id;
	}
	public String getCase_id() {
		return case_id;
	}
	public void setCase_id(String case_id) {
		this.case_id = case_id;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	

}
