<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath();%>
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>管理员基本信息</title>
    

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <link href="css/index.css" rel="stylesheet" />
  	<link rel="stylesheet" href="css/xdp.css" />


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	
	<table>
		<caption class="container"> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;超级管理员个人资料修改</caption>
			<tr class="form-group input-group">
				<td>账号：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="email" id="email" type="email" disabled="disabled" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>姓名：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="name" id="name" type="text"  /></td>
			</tr>
			<tr class="form-group input-group">
				<td>手机号：</td>
				<td><input name="phone" id="phone" type="text" /></td>
				<td><span id="phone"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td>角色：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="role" id="role" type="text" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>创建时间：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input disabled="disabled" name="created_time" id="created_time" type="text" /></td>
			</tr>
			<tr class="form-group input-group">
				<td><a>取消</a></td>
				<td><input  type="submit"  value="保存" /></td>
		    </tr>
	</table>
	
</body>
</html>