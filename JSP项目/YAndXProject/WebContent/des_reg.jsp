<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String path = request.getContextPath();
    %>
    
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>注册页面</title>

    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>

  <body>
	
	<ul id="myTab" class="nav nav-tabs col-xs-12 col-sm-10 col-sm-offset-2 col-md-6 col-md-offset-3 col-lg-8 col-lg-offset-2">
		<li><a href="<%=path %>/reg/cus" >业主申请注册</a></li>
		<li><a href="<%=path %>/reg/com" >装修公司申请入驻</a></li>
		<li><a href="<%=path %>/reg/sup">建材商申请入驻</a></li>
		<li class="active"><a href="<%=path %>/reg/des">设计师申请入驻</a></li>
	</ul>
	
	<div id="myTabContent" class="tab-content col-xs-12 col-sm-10 col-sm-offset-1 col-md-6 col-md-offset-3 col-lg-6 col-lg-offset-3"  style="width: 300px">
	<div class="tab-pane fade in active" id="home">
	<br/><br/>
	<form action="<%=path %>/reg/dess" method="post">
		<table>
			<tr class="form-group input-group">
				<td>账号：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="email" id="email" type="email" placeholder="请输入您的邮箱账号" /></td>
				<td><span id="emailCuo">${requestScope.emailCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>密码：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="pwd" id="pwd" type="password" placeholder="请输入您的邮箱密码" /></td>
				<td><span id="pwdCuo">${requestScope.pwdCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>姓名：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="name" id="name" type="text" placeholder="请输入您的姓名" /></td>
				<td><span id="nameCuo">${requestScope.nameCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>地址：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="address" id="address" type="text" placeholder="请输入公司地址" /></td>
				<td><span id="addressCuo">${requestScope.addressCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>手机号：</td>
				<td><input name="phone" id="phone" type="text" placeholder="请输入手机号码" /></td>
				<td><span id="phoneCuo">${requestScope.phoneCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td><input  type="submit"  value="提交入驻表单" /></td>
			</tr>
		</table>
	</form>
	</div>
</div>
    <script src="js/jquery.min.js"></script>
    <script src="js/bootstrap.min.js"></script>
  </body>
</html>
