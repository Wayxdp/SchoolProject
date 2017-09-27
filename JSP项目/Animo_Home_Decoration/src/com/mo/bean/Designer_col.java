package com.mo.bean;

import java.util.Date;
/**
 * 设计师收藏表
 * @author CMY
 *
 */
public class Designer_col {
	private String id;				//id
	private String customer_id;		//顾客id
	private String designer_id;		//设计师id
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
	public String getDesigner_id() {
		return designer_id;
	}
	public void setDesigner_id(String designer_id) {
		this.designer_id = designer_id;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}

}
