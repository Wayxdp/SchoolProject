<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String path = request.getContextPath(); %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>设计师资料</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
	<div class="usercenter">
		<div class="content">
			<div class="user-info bg-white clearfix" style="width: 100%">
				<div class="page-title">
					<span class="tit">设计师资料</span>
				</div>
				<form enctype="multipart/form-data"  id="form" class="form-horizontal">
				<input type="hidden" value="user" name="action">
				</form>
			<div class="info-list mt20">
				<form method="post" id="form" action="<%=path%>/Animo/Bnimo/Cnimo/updatedatasucceed">
					<input type="hidden" id="cover" name="cover" value="">
					<ul>
						<li>
							<label>邮箱：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="email"
							name="email"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.desingenr.email }</span>
						</li>
						<li>
							<label>名称：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="name"
							name="email"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.name }</span>
						</li>
						<li>
							<label>头像路径：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="headicon"
							name="email"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.headicon }</span>
						</li>
						<li>
							<label>手机号：</label>
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="phone"
							name="created_time" value=${requestScope.admindata.created_time} />
							<span class="error text-red">${requestScope.phone }</span>
						</li>

						<li>
							<label>地址：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="address"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.desingenr.address }</span>
						</li>
						
						<li>
							<label>工作经验：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="experience"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.desingenr.experience }</span>
						</li>
						
						<li>
							<label>擅长的风格：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="style"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.desingenr.style }</span>
						</li>
						
						<li>
							<label>描述：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="des"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.desingenr.des }</span>
						</li>
						
						<li>
							<label>创建时间：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="created_time"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.desingenr.created_time }</span>
						</li>
						
						<li>
							<label>审核时间：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="checked_time"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.desingenr.checked_time }</span>
						</li>
						
					</ul>
				</form>
			</div>
		</div>
	 </div>
	</div>
</body>
</html>