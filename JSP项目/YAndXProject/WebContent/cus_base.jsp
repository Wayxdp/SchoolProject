<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>业主个人资料查看页</title>
</head>
<body>
	<form action="<%=path %>/cus/submit" method="post">
		<table>
			<tr>
				<td>账号：</td>
				<td><input disabled="disabled" type="email" id="email" name="email" value="${sessionScope.customer.email }" /></td>
				
			</tr>
			<tr>
				<td>名称：</td>
				<td><input type="text" id="name" name="name" value="${sessionScope.customer.name }"  /></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" id="phone" name="phone" value="${sessionScope.customer.phone }" /></td>
			</tr>
			<tr>
				<td>小区名称：</td>
				<td><input type="text" id="plot_name" name="plot_name" value="${sessionScope.customer.plot_name }" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" id="address" name="address" value="${sessionScope.customer.address }" /></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input type="text" name="created_time" id="created_time" disabled="disabled" value="${sessionScope.customer.created_time }" /></td>
			</tr>
			<tr>
				<td><a>取消</a></td>
				<td><input  type="submit"  value="保存" /></td>
		    </tr>
		</table>
	</form>
</body>
</html>