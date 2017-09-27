<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>活动修改</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<script type="text/javascript" src="<%=path%>/decorate_company/js/companyAddCase.js"></script>
<link href="<%=path %>/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link rel="stylesheet" href="<%=path%>/css/amazeui.min.css">
<link rel="stylesheet" href="<%=path%>/css/app.css">
    <style>
		body{ font-family: "microsoft yahei";}
	</style>
</head>
<body>
	<form enctype="multipart/form-data" action="<%=path %>/supply/activityrecompose" method="post" class="col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4" style="padding-top: 60px;">
		<input type="hidden" name="id" value="${requestScope.supplyactivity.id }" />
		<div class="form-group">
		  活动名称名称：<input type="text" class="form-control" id="name" name="name" placeholder="请输入案例名称" value="${requestScope.supplyactivity.name }">
		<span id="nameerror"></span>
		</div>
		<div class="form-group">
		  活动描述：<input type="text" class="form-control" id="des" name="des" placeholder="请描述该案例" value="${requestScope.supplyactivity.des }">
		   <span id="deserror"></span>
		</div>
<div class="container col-lg-8 col-lg-offset-2">
	<div data-am-widget="slider" class="am-slider am-slider-default"
		data-am-slider='{&quot;animation&quot;:&quot;slide&quot;,&quot;slideshow&quot;:false}'>
		<ul class="am-slides">
			<li><img src="<%=path%>/${requestScope.supplyactivity.image}">
				<div class="am-slider-desc">活动图片</div></li>
		</ul>
	</div>
</div>
<div class="form-group">
<input type="file" name="photo1" id="photo1" /> 
</div>
		<button class="btn btn-primary" type="submit">修改</button>
		<span id="ok"></span>
</form>
	 <script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>js/bootstrap.min.js"></script>
<script src="<%=path%>/js/jquery.min.js"></script>
<script src="<%=path%>/js/amazeui.min.js"></script>
</body>
</html>