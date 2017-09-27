<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<% String path = request.getContextPath(); %>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>业主详情页</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
	<div class="usercenter">

		<div class="content">
			<div class="user-info bg-white clearfix" style="width: 100%">
				<div class="page-title">
					<span class="tit">业主详情</span>
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
							<span class="error text-red">${requestScope.cus.email }</span>
						</li>
						<li>
							<label>名称：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="name"
							name="name"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.cus.name }</span>
						</li>
						<li>
							<label>手机号：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="phone"
							name="phone"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.cus.phone }</span>
						</li>
						 <li>
							<label>小区名称：</label> 
							<p readonly="readonly"
							style="border: none;" type="text" class="txt" id="plot_name"
							name="plot_name"  validate="required"
							value=${requestScope.admindata.email} />
							<span class="error text-red">${requestScope.cus.plot_name }</span>
						</li>
						<li>
							<label>地址：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="address"
							name="address" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.cus.address }</span>
						</li>
						<li>
							<label>创建时间：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="created_time"
							name="created_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.cus.created_time }</span>
						</li>
						<li>
							<label>最近一次登入时间：</label>
							<p readonly="readonly"
							style="border: none;" type="text" id="last_login_time"
							name="last_login_time" class="txt"
							value=${requestScope.admindata.last_login_time} />
							<span class="error text-red">${requestScope.cus.last_login_time }</span>
						</li>
					</ul>
				</form>
			</div>
		</div>
	 </div>
	</div>
</body>
</html>