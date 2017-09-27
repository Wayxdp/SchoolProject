<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String path=request.getContextPath(); %>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
<div class="bg-gray usercenter">
	   
<div class="content mt20">
        	<div class="user-info bg-white clearfix">
            	<div class="page-title">
                	<span class="tit">修改密码</span>
                </div>
                
                <div class="info-list mt20">
                <form  method="post" action="<%=path%>/company/updatechange_password"  name="psw_form" id="psw_form">
                <ul>
                	<li>
                        <label><span class="text-red">*</span> 旧密码</label>
                        <input name="pwd1" type="password" class="txt" id="old_password" onblur="check_old_password()" >
                        <span class="error text-red"></span>
                        <span id="msg_old_password">输入原密码</span>
                    </li>
                    <li>
                        <label><span class="text-red">*</span> 新密码</label>
                        <input name="pwd2" type="password" class="txt" id="new_password" onblur="check_new_password()" >
                        <span class="error text-red"></span>
                        <span id="msg_new_password">至少6位以上的数字或字母组合</span><span class="no" style="display:none;">密码格式不正确</span>
                    </li>
                    <li>
                        <label><span class="text-red">*</span> 重复新密码</label>
                        <input name="repassword" type="password" id="repassword" onblur="check_repassword()" class="txt" >
                        <span class="error text-red"></span>
                        <span id="msg_repassword">再次输入密码</span>

                    </li>
                    
                </ul>
                <input type="button" id="button" value="修改" class="btn-red" onclick="check_all()">
                  
                </form>
                </div>
            </div>
           </div>
           </div>
</body>
</html>