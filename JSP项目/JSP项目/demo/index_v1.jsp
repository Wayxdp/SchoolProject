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

    <title>首页</title>
    

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
		<caption class="container"> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;装修公司个人资料查看</caption>
			<tr class="form-group input-group">
				<td>账号：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="email" id="email" type="email" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>密码：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="pwd" id="pwd" type="password" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>姓名：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="name" id="name" type="text"  /></td>
			</tr>
			<tr class="form-group input-group">
				<td>负责人：</td>
				<td><input name="principal" id="principal" type="text" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>地址：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="address" id="address" type="text" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>手机号：</td>
				<td><input name="phone" id="phone" type="text" value="ss" /></td>
				<td><span id="phone"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td><input type="submit" value="取消" /></td>
				<td><input  type="submit"  value="保存" /></td>
			</tr>
	</table>
	
	
	
	
	
	
</body>
</html>