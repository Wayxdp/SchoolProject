package com.mo.bean;

import java.util.Date;

/**
 * 设计师表
 * @author Animo
 *
 */
public class Designer {
	private String id;//编号
	private String email;//邮箱
	private String password;//密码
	private String name;//名称
	private String headicon;//头像路径
	private String phone;//手机号
	private String address;//地址
	private String experience;//工作经验
	private String style;//擅长的风格
	private String des;//描述
	private Date created_time;//创建时间
	private String checked;//是否审核,Y表示审核通过，N表示未审核
	private Date checked_time;//审核时间
	private Date last_login_time;//最近一次登录时间
	private String status;//是否可用，Y表示可用，N表示不可用
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHeadicon() {
		return headicon;
	}
	public void setHeadicon(String headicon) {
		this.headicon = headicon;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getExperience() {
		return experience;
	}
	public void setExperience(String experience) {
		this.experience = experience;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
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
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	public Date getChecked_time() {
		return checked_time;
	}
	public void setChecked_time(Date checked_time) {
		this.checked_time = checked_time;
	}
	public Date getLast_login_time() {
		return last_login_time;
	}
	public void setLast_login_time(Date last_login_time) {
		this.last_login_time = last_login_time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
}
