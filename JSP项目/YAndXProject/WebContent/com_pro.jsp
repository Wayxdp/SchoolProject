<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
	<%
		String path = request.getContextPath();
	%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>装修公司添加商品</title>
</head>
<body>
	<form action="<%=path %>/" method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>添加的名称</td>
				<td><input type="text" id="text" name="text" placeholder="请输入添加的名称" /></td>
			</tr>
			<tr>
				<td>添加的小区</td>
				<td><input type="text" id="plot" name="plot" placeholder="请输入添加的小区" /></td>
			</tr>
			<tr>
				<td>添加的风格</td>
				<td><input type="text" id="fg" name="fg" placeholder="请输入添加的风格" /></td>
			</tr>
			<tr>
				<td>描述的信息</td>
				<td><input type="text" id="des" name="des" placeholder="请输入描述信息" /></td>
			</tr>
			<tr>
				<td><input type="file" id="img" name="img" placeholder="请输入描述信息" /></td>
			</tr>
			<tr>
				<td><input type="file" id="img" name="img" placeholder="请输入描述信息" /></td>
			</tr>
			<tr>
				<td><input type="file" id="img" name="img" placeholder="请输入描述信息" /></td>
			</tr>
			<tr>
				<td><input type="file" id="img" name="img" placeholder="请输入描述信息" /></td>
			</tr>
			<tr>
				<td><input type="file" id="img" name="img" placeholder="请输入描述信息" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="提交" /></td>
			</tr>
		</table>
	</form>
</body>
</html>