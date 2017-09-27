<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String path = request.getContextPath(); %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>建材商详情</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
	<div class="usercenter">

		<div class="content">
			<div class="user-info bg-white clearfix" style="width: 100%">
				<div class="page-title">
					<span class="tit">建材商详情</span>
				</div>
				<form enctype="multipart/form-data"  id="form" class="form-horizontal">
				<input type="hidden" value="user" name="action">
				<!-- <div class="edit-head clearfix">
					<span class="pic"><img
						src="./个人中心_files/designer_cover.png" width="80" height="80"
						class="coverPic"></span>
				</div> -->
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
							<span class="error text-red">${requestScope.supply.email }</span>
						</li>
						<li>
							<label>名称：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="name"
							name="name"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.supply.name }</span>
						</li>
						<li>
							<label>负责人：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="principal"
							name="principal"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.supply.principal }</span>
						</li>
						<li>
							<label>公司Logo图片地址：</label>
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="logo"
							name="logo" value=${requestScope.admindata.created_time} />
							<span class="error text-red">${requestScope.supply.logo }</span>
						</li>

						<li>
							<label>地址：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="address"
							name="address" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.supply.address }</span>
						</li>
						
						<li>
							<label>手机号：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="phone"
							name="phone" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.supply.phone }</span>
						</li>
						
						<li>
							<label>固定电话：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="tel"
							name="tel" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.supply.tel }</span>
						</li>
						
						<li>
							<label>描述：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="des"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.supply.des }</span>
						</li>
						
						<li>
							<label>创建时间：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="created_time"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.supply.created_time }</span>
						</li>
						
						<li>
							<label>审核时间：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="checked_time"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.supply.checked_time }</span>
						</li>
					</ul>
				</form>
			</div>
		</div>
	 </div>
	</div>
</body>
</html>