<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String  path = request.getContextPath();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>建材商个人资料查看页</title>
</head>
<body>
	<form action="<%=path %>/sup/submit" method="post">
		<table>
			<tr>
				<td>账号：</td>
				<td><input disabled="disabled" type="email" id="email" name="email" value="${sessionScope.supply.email}" /></td>
			</tr>
			<tr>
				<td>名称：</td>
				<td><input type="text" id="name" name="name"  value="${sessionScope.supply.name }" /></td>
			</tr>
			<tr>
				<td>负责人：</td>
				<td><input type="text" id="principal" name="principal" value="${sessionScope.supply.principal }" /></td>
			</tr>
			<tr>
				<td>地址：</td>
				<td><input type="text" id="address" name="address" value="${sessionScope.supply.address }" /></td>
			</tr>
			<tr>
				<td>手机号：</td>
				<td><input type="text" id="phone" name="phone" value="${sessionScope.supply.phone }" /></td>
			</tr>
			<tr>
				<td>固定电话：</td>
				<td><input type="text" id="tel" name="tel" value="${sessionScope.supply.tel }" /></td>
			</tr>
			<tr>
				<td>经度：</td>
				<td><input type="text" id="longitude" name="longitude" value="${sessionScope.supply.longitude }" /></td>
			</tr>
			<tr>
				<td>纬度：</td>
				<td><input type="text" id="latitude" name="latitude" value="${sessionScope.supply.latitude }" /></td>
			</tr>
			<tr>
				<td>描述：</td>
				<td><input type="text" name="des" id="des" value="${sessionScope.supply.des }" /></td>
			</tr>
			<tr>
				<td>创建时间：</td>
				<td><input type="text" name="created_time" id="created_time" disabled="disabled"  value="${sessionScope.supply.created_time }" /></td>
			</tr>
			<tr>
				<td><a>取消</a></td>
				<td><input  type="submit"  value="保存" /></td>
		    </tr>
		</table>
	</form>
</body>
</html>