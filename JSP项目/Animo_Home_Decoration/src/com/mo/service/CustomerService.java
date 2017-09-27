package com.mo.service;

import java.util.Date;

import com.mo.bean.Customer;

public interface CustomerService extends BaseService<String, Customer>{

public Customer queryByemail(String email);//根据邮箱来查询用户

public Customer queryByNoPwd(String email,String pwd);//根据邮箱和名称来查询用户

public void updatechecked_time(Date checked_time,String id);//更新审核时间

public void updatelast_login_time(Date last_login_time,String id);//更新最近登录时间

public void updatestatus(String status,String id);//更新状态是否可用

public void updatepwd(String id,String pwd);//更新密码
}
