package com.mo.bean;

import java.util.Date;
/**
 * 建材收藏表
 * @author CMY
 *
 */

public class Product_col {
	
	private String id;				//id
	private String customer_id;		//顾客id
	private String product_id	;		//建材id
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
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}


}
