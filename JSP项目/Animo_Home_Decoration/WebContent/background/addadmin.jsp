<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8" />
<title>添加管理员</title>
 <link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css"
	href="<%=path%>/css/bootstrap.min.css">
	<script type="text/javascript" src="<%=path%>/js/jquery-3.2.0.min.js"></script>
	<script type="text/javascript" src="<%=path%>/js/addadmin.js"></script>
<style type="text/css">
<
style type ="text/css">* {
	margin: 0px;
	padding: 0px;
	font-size: 12px;
	font-family: "微软雅黑";
}

body {
	background: url("<%=path%>/images/a.jpg") no-repeat;
}

.top {
	margin: 0 auto;
	text-align: center;
	background: url("<%=path%>/images/top.jpg");
	margin-top: 5%;
	width: 500px;
	height: 400px;
	border: 2px cyan solid;
	border-radius: 15px;
}

.input-group {
	width: 250px;
	margin-left: 25%;
}

.top:HOVER {
	background: url("<%=path%>/images/b.jpg");
}

.top h1 {
	color: red;
	font-size: 36px;
	font-weight: bold;
	text-shadow: 3px 3px cyan;
}
}
</style>


</head>
<body>

	<div class="top">
		<div id="inp"></div>
		<h1>管理员添加</h1>
		<form id="form" action="<%=path%>/Animo/Bnimo/Cnimo/add"
			method="post">
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">邮箱&nbsp;&nbsp;&nbsp;</span>
				<input id="email" name="email" type="email" class="form-control"
					placeholder="Email" aria-describedby="basic-addon1" onblur="email();'"><span id="emailspan"></span><br>
			</div>
			<span id="emailspan">${requestScope.emailspan }</span><br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">密码&nbsp;&nbsp;&nbsp;</span>
				<input id="pwd1" name="pwd1" type="text" class="form-control"
					placeholder="Password" aria-describedby="basic-addon1" onblur="pwd();"><span id="pwd1span"></span><br>
			</div>
			<span id="pwd1email">${requestScope.pwd1email }</span><br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">确认密码</span> <input
					id="pwd2" name="pwd2" type="text" class="form-control"
					placeholder="Password" aria-describedby="basic-addon1" onblur="check();"><span id="pwd2span"></span><br>
			</div>
			<span id="pwd2span">${requestScope.pwd2span }</span><br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">名称&nbsp;&nbsp;&nbsp;</span>
				<input id="name" name="name" type="text" class="form-control"
					placeholder="Name" aria-describedby="basic-addon1"><br>
			</div>
			<br>
			<div class="input-group">
				<span class="input-group-addon" id="basic-addon1">手机号</span> <input
					id="phone" name="phone" type="text" class="form-control"
					placeholder="Password" aria-describedby="basic-addon1"><br>
			</div>
			<span id="info"></span><br>
			<button type="button" class="btn btn-success btn-lg" onclick="add();">添加addition</button>
		</form>
	</div>
</body>
</html>