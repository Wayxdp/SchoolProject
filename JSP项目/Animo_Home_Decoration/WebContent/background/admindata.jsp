<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8" />
<title>管理员资料</title>
 <link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
	<div class="usercenter">

		<div class="content">
			<div class="user-info bg-white clearfix" style="width: 100%">
				<div class="page-title">
					<span class="tit">管理员资料</span>
				</div>
					<div class="info-list mt20">
					<form method="post" id="form"
					action="<%=path%>/Animo/Bnimo/Cnimo/updatedatasucceed">
						<input type="hidden" id="cover" name="cover" value="">
						<ul>

							<li><label>邮箱</label> <input readonly="readonly"
								style="border: none;" type="text" class="txt" id="email"
								name="email" validate="required"
								value=${requestScope.admindata.email}> <span
								class="error text-red"></span></li>
							<li><label>姓名</label> <input type="text" class="txt"
								id="name" name="name" value=${requestScope.admindata.name}>
								<span class="error text-red"></span></li>
							<li><label>手机号</label> <input type="text" class="txt"
								id="phone" name="phone" value=${requestScope.admindata.phone}>
								<span class="error text-red"></span></li>
							<li><label>角色</label> <input readonly="readonly"
								style="border: none;" type="text" id="role" name="role"
								class="txt" value=${requestScope.admindata.role}> <span
								class="error text-red"></span></li>
							<li><label>创建时间</label> <input readonly="readonly"
								style="border: none;" type="text" class="txt" id="created_time"
								name="created_time" value=${requestScope.admindata.created_time}>
								<span class="error text-red"></span></li>

							<li><label>最近登录时间</label> <input readonly="readonly"
								style="border: none;" type="text" id="last_login_time"
								name="last_login_time" class="txt"
								value=${requestScope.admindata.last_login_time}> <span
								class="error text-red"></span></li>
						</ul>
						<input type="submit" id="form" value="保存" class="btn-red">
				</form>
			</div>
		</div>
	</div>
	</div>
</body>
</html>