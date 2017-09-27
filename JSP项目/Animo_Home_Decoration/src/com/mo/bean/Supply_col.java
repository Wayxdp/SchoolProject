package com.mo.bean;

import java.util.Date;
/**
 * 建材商收藏表
 * @author CMY
 *
 */

public class Supply_col {
	private String id;				//id
	private String customer_id;		//顾客id
	private String supply_id;		//供应商id
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
	public String getSupply_id() {
		return supply_id;
	}
	public void setSupply_id(String supply_id) {
		this.supply_id = supply_id;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	

}
