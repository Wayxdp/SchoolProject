package com.mo.bean;

import java.util.Date;

/**
 * 设计师案例表
 * @author Animo
 *
 */
public class Designer_case {
	private String caseid;//编号
	private String designer_id;//设计师编号
	private String casename;//案例名称
	private String plot_name;//小区名称
	private String style;//装修风格
	private String image_1;//图片1路径
	private String image_2;//图片2路径
	private String image_3;//图片3路径
	private String image_4;//图片4路径
	private String image_5;//图片5路径
	private String des;//描述
	private Date created_time;//创建时间
	private String status;//是否可用，Y表示可用，N表示不可用
	
	public String getCaseid() {
		return caseid;
	}
	public void setCaseid(String caseid) {
		this.caseid = caseid;
	}
	public String getDesigner_id() {
		return designer_id;
	}
	public void setDesigner_id(String designer_id) {
		this.designer_id = designer_id;
	}
	public String getCasename() {
		return casename;
	}
	public void setCasename(String name) {
		this.casename = name;
	}
	public String getPlot_name() {
		return plot_name;
	}
	public void setPlot_name(String plot_name) {
		this.plot_name = plot_name;
	}
	public String getStyle() {
		return style;
	}
	public void setStyle(String style) {
		this.style = style;
	}
	public String getImage_1() {
		return image_1;
	}
	public void setImage_1(String image_1) {
		this.image_1 = image_1;
	}
	public String getImage_2() {
		return image_2;
	}
	public void setImage_2(String image_2) {
		this.image_2 = image_2;
	}
	public String getImage_3() {
		return image_3;
	}
	public void setImage_3(String image_3) {
		this.image_3 = image_3;
	}
	public String getImage_4() {
		return image_4;
	}
	public void setImage_4(String image_4) {
		this.image_4 = image_4;
	}
	public String getImage_5() {
		return image_5;
	}
	public void setImage_5(String image_5) {
		this.image_5 = image_5;
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
