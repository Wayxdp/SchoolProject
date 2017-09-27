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
<title>商品详情</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/css/amazeui.min.css">
<link rel="stylesheet" href="<%=path%>/css/app.css">
</head>
<div class="container">
	<div class="col-lg-6 col-lg-offset-3" style="padding-top: 60px;">
		<p>商品名称名称:${requestScope.product.name }</p>
		<p>商品价格:${requestScope.product.price }</p>
		<p>商品折扣后价格:${requestScope.product.sale_price }</p>
		<p>商品描述:${requestScope.product.des }</p>
		<c:if test="${requestScope.product.status=='Y'}"><p>活动状态:可用</p></c:if>
		<c:if test="${requestScope.product.status=='N'}"><p>活动状态:已冻结</p></c:if>
	</div>
</div>
<h1 class="col-lg-8 col-lg-offset-2" style="margin-top: 10px;">|&nbsp;商品详情</h1>
<div class="container col-lg-8 col-lg-offset-2">
	<div data-am-widget="slider" class="am-slider am-slider-default"
		data-am-slider='{&quot;animation&quot;:&quot;slide&quot;,&quot;slideshow&quot;:false}'>
		<ul class="am-slides">
			<li><img src="<%=path%>/${requestScope.product.image}">
				<div class="am-slider-desc">商品图片</div></li>
		</ul>
	</div>
</div>
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/bootstrap.min.js"></script>
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/amazeui.min.js"></script>

</body>
</html>