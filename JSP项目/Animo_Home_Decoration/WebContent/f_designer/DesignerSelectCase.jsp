<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设计师案例详情</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/css/amazeui.min.css">
<link rel="stylesheet" href="<%=path%>/css/app.css">
</head>
<div class="container">
	<div class="col-lg-6 col-lg-offset-3" style="padding-top: 60px;">
		<p>案例名称:${requestScope.cases.casename }</p>
		<p>小区地址:${requestScope.cases.plot_name }</p>
		<p>装修风格:${requestScope.cases.style }</p>
		<p>案例描述:${requestScope.cases.des }</p>
		<c:if test="${requestScope.cases.status=='Y'}"><p>案例状态:可用</p></c:if>
		<c:if test="${requestScope.cases.status=='N'}"><p>案例状态:已冻结</p></c:if>
	</div>
</div>
<h1 class="col-lg-8 col-lg-offset-2" style="margin-top: 10px;">|&nbsp;装修案例</h1>
<div class="container col-lg-8 col-lg-offset-2">
	<div data-am-widget="slider" class="am-slider am-slider-default"
		data-am-slider='{&quot;animation&quot;:&quot;slide&quot;,&quot;slideshow&quot;:false}'>
		<ul class="am-slides">
			<li><img src="<%=path%>/${requestScope.cases.image_1}">
				<div class="am-slider-desc">第一张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.cases.image_2}">
				<div class="am-slider-desc">第二张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.cases.image_3}">
				<div class="am-slider-desc">第三张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.cases.image_4}">
				<div class="am-slider-desc">第四张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.cases.image_5}">
				<div class="am-slider-desc">第五张案例图</div></li>
		</ul>
	</div>
</div>
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/amazeui.min.js"></script>
</body>
</html>