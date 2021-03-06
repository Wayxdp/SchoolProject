package com.xy.bean;

import java.util.Date;

public class Company_col {
	
	private String id;//	unique_identifier	编号	主键，uuid
	private String customer_id;//	unique_identifier	用户编号	外键，关联到t_customer表的id字段
	private String company_id;//	unique_identifier	装修公司编号	外键，关联到t_company表的id字段
	private Date created_time;//	datetime	创建时间	添加时的系统当前时间
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
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	
	
}
