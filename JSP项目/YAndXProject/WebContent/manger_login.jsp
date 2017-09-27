<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>普通管理员页面</title>
</head>
<body>
	<div class="tab-pane fade" id="manager">
		<table>
			<caption class="container"> &nbsp;&nbsp;&nbsp;&nbsp; &nbsp;&nbsp;&nbsp;&nbsp;管理员</caption>
			<tr class="form-group input-group">
				<td>账号：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="email" id="email" type="email" placeholder="请输入您的邮箱账号" /></td>
			</tr>
			<tr class="form-group input-group">
				<td>密码：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="pwd" id="pwd" type="password" placeholder="请输入您的邮箱密码" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="登入"/></td>
			</tr>
		</table>
	</div>
</body>
</html>