package com.mo.bean;

import java.util.Date;

/**
 * 装修公司活动表
 * @author Animo
 *
 */
public class Company_activity {
	private String id;//编号
	private String company_id;//装修公司编号
	private String name;//案例名称
	private String image;//活动图片路径
	private String des;//描述
	private Date created_time;//创建时间
	private String status;//是否可用，Y表示可用，N表示不可用
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getCompany_id() {
		return company_id;
	}
	public void setCompany_id(String company_id) {
		this.company_id = company_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getDes() {
		return des;
	}
	public void setDes(String des) {
		this.des = des;
	}
	public Date getCreated_time() {
		return created_time;
	}
	public void setCreated_time(Date created_time) {
		this.created_time = created_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
