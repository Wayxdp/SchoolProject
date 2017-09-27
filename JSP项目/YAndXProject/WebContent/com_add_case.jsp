<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
    <%
    String path = request.getContextPath();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>装修公司添加案列</title>

	<link href="<%=path %>/css/amazeui.min.css" rel="stylesheet">
	<link href="<%=path %>/css/admin.css" rel="stylesheet">
	
	 <script type="text/javascript" src="<%=path %>/js/amazeui.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/app.js"></script>
	
</head>
<body>


	<form action="<%=path %>/com/submit"  method="post">
		<table style="position:absolute;top:0px;left:450px;">
			<tr>
				<td>案列名称：</td>
				<td><input type="text" id="name" name="name" placeholder="案列名称" /></td>
			</tr>
			
			<tr>
				<td>小区名称：</td>
				<td><input type="text" id="plot" name="plot" placeholder="小区名称" /></td>
			</tr>
			
			<tr>
				<td>装修风格：</td>
				<td><input type="text" id="fg" name="fg" placeholder="装修风格" /></td>
			</tr>
			
			<tr>
				<td>
					<div class="am-form-group am-form-file">
					  <a href="#"><img class="am-thumbnali" src="<%=path %>/images/add1.jpg" /></a>
					  <input type="file" multiple>
					</div>
				</td>
			</tr>
			
			<tr>
				<td><input type="submit" value="确认"/></td>
			</tr>
		</table>
	</form>
</body>
</html>