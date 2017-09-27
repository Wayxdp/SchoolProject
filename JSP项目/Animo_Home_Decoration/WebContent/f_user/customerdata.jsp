<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8" />
<title>业主个人资料</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
	<div class="usercenter">
		<div class="content">
			<div class="user-info bg-white clearfix">
				<div class="page-title">
					<span class="tit">个人资料</span>
				</div>
					<div class="info-list mt20">
					<form action="<%=path %>/customer/updatedatasucceed" method="post">
							<input type="hidden" id="cover" name="cover" value="">
							<ul>

								<li><label>手机号</label> <input type="text" class="txt"
									id="phone" name="phone"  value=${sessionScope.customer1.phone }> <span
									class="error text-red"></span></li>
								<li><label>姓名</label> <input type="text" class="txt"
									id="name" name="name"  value=${sessionScope.customer1.name }> <span
									class="error text-red"></span></li>
								<li><label>邮箱</label> <input style="border: none;" readonly="readonly" type="text" class="txt"
									id="email" name="email" value=${sessionScope.customer1.email }>
									<span class="error text-red"></span></li>

								<li><label>小区名称</label> <input type="text" id="plot_name" name="plot_name"
									class="txt"  value=${sessionScope.customer1.plot_name }> <span
									class="error text-red"></span></li>
									
								<li><label>地址</label> <input type="text" id="address" name="address"
									class="txt"  value=${sessionScope.customer1.address }> <span
									class="error text-red"></span></li>
								<li><label>创建时间</label> <input style="border: none;" readonly="readonly"
									type="text" id="created_time" name="created_time" class="txt" 
									value=${sessionScope.customer1.created_time }> <span class="error text-red"></span></li>
								<li><label>最后登录时间</label> <input style="border: none;" readonly="readonly"
									type="text" id="last_login_time" name="last_login_time" class="txt" 
									value=${sessionScope.customer1.last_login_time }> <span class="error text-red"></span></li>
							</ul>
							<input type="submit" id="form" value="保存" class="btn-red">
						</form>
					</div>
			</div>

		</div>
	</div>

</body>
</html>