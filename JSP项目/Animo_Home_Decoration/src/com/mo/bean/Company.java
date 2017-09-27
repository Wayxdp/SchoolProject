package com.mo.bean;

import java.util.Date;

/**
 * 装修公司
 * @author Animo
 *
 */
public class Company {
	@Override
	public String toString() {
		return "Company [id=" + id + ", email=" + email + ", password=" + password + ", company_name=" + company_name
				+ ", principal=" + principal + ", logo=" + logo + ", address=" + address + ", phone=" + phone + ", tel="
				+ tel + ", open_date=" + open_date + ", longitude=" + longitude + ", latitude=" + latitude + ", des="
				+ des + ", created_time=" + created_time + ", checked=" + checked + ", checked_time=" + checked_time
				+ ", last_login_time=" + last_login_time + ", status=" + status + "]";
	}
	private String id;//编号
	private String email;//邮箱
	private String password;//密码
	private String company_name;//名称
	private String principal;//负责人
	private String logo;//公司logo图片地址
	private String address;//地址
	private String phone;//手机号码
	private String tel;//固定电话
	private Date open_date;//成立日期
	private float longitude;//经度
	private float latitude;//维度
	private String des;//描述
	private Date created_time;//创建时间
	private String checked;//是否审核,Y表示审核通过，N表示未审核
	private Date checked_time;//审核时间
	private Date last_login_time;//最近一次登录时间
	private String status;//是否可用，Y表示可用，N表示不可用
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
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
	public String getPrincipal() {
		return principal;
	}
	public void setPrincipal(String principal) {
		this.principal = principal;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public Date getOpen_date() {
		return open_date;
	}
	public void setOpen_date(Date open_date) {
		this.open_date = open_date;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLatitude() {
		return latitude;
	}
	public void setLatitude(float latitude) {
		this.latitude = latitude;
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
