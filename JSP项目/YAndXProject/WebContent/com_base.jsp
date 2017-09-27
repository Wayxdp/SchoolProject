<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
		<form action="<%=path %>/com/submit" method="post">
			<table>
			<tr class="form-group input-group">
				<td>账号：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="email" id="email" type="email" disabled="disabled" value="${sessionScope.company.email }"/></td>
				<td><span id="emailCuo">${requestScope.emailCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>姓名：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="name" id="name" type="text" value="${sessionScope.company.name }"/></td>
				<td><span id="nameCuo">${requestScope.nameCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>负责人：</td>
				<td><input name="principal" id="principal" type="text" value="${sessionScope.company.principal }" /></td>
				<td><span id="principalCuo">${requestScope.principalCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>地址：&nbsp;&nbsp;&nbsp;&nbsp;</td>
				<td><input name="address" id="address" type="text" value="${sessionScope.company.address }"/></td>
				<td><span id="addressCuo">${requestScope.addressCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>手机号：</td>
				<td><input name="phone" id="phone" type="text"  value="${sessionScope.company.phone }"/></td>
				<td><span id="phone"></span></td>
				<td><span id="phoneCuo">${requestScope.phoneCuo }</span></td>
			</tr>
			<tr class="form-group input-group">
				<td>固定电话：</td>
				<td><input name="tel" id="tel" type="text" value="${sessionScope.company.tel }"/></td>
				<td><span id="tel"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td>成立日期：</td>
				<td><input name="open_date" id="open_date" type="text" disabled="disabled" value="${sessionScope.company.open_date }"/></td>
				<td><span id="open_date"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td>经度：</td>
				<td><input name="longitude" id="longitude" type="text" value="${sessionScope.company.longitude }"/></td>
				<td><span id="longitude"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td>纬度：</td>
				<td><input name="latitude" id="latitude" type="text" value="${sessionScope.company.latitude }"/></td>
				<td><span id="latitude"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td>描述：</td>
				<td><input name="des" id="des" type="text" value="${sessionScope.company.des }"/></td>
				<td><span id="des"></span></td>
			</tr>
			<tr class="form-group input-group">
				<td><a href="<%=path %>/com/noSubmit">取消</a></td>
				<td><input type="submit" value="保存" /></td>
			</tr>
		</table>
	</form>
</body>
</html>