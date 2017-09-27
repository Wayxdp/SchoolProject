<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>设计师个人资料查看页</title>
</head>
<body>
	<form action="" method="post">
		<table>
			<tr>
				<td>账号：</td>
				<td><input disabled="disabled" type="email" id="email" name="email" value="${sessionScope.designer.email }" /></td>
			</tr>
			<tr>
				<td>名称：</td>
				<td><input type="text" id="name" name="name" value="${sessionScope.designer.name }" /></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" id="phone" name="phone" value="${sessionScope.designer.phone }" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" id="address" name="address" value="${sessionScope.designer.address }" /></td>
			</tr>
			<tr>
				<td>工作经验：</td>
				<td><input type="text" id="experience" name="experience" value="${sessionScope.designer.experience }" /></td>
			</tr>
			<tr>
				<td>擅长的风格：</td>
				<td><input type="text" id="style" name="style" value="${sessionScope.designer.style }" /></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="des" id="des" value="${sessionScope.designer.des }" /></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input type="text" id="created_time" name="created_time" disabled="disabled" value="${sessionScope.designer.email }" /></td>
			</tr>
			<tr>
				<td><a>取消</a></td>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>