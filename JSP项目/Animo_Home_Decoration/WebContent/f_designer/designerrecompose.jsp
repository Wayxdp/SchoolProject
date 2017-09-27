<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>设计师案例修改</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<script type="text/javascript" src="<%=path%>/decorate_company/js/companyAddCase.js"></script>
<link rel="shortcut icon" href="favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <style>
		body{ font-family: "microsoft yahei";}
	</style>
</head>
<body>
	<form enctype="multipart/form-data" action="<%=path %>/designer/desingerrecompose" method="post" class="col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4" style="padding-top: 60px;">
		<input type="hidden" name="id" value="${requestScope.designercase.id }" />
		<div class="form-group">
		  案例名称：<input type="text" class="form-control" id="name" name="name" placeholder="请输入案例名称" value="${requestScope.designercase.name }">
		<span id="nameerror"></span>
		</div>
		<div class="form-group">
		  小区地址：<input type="text" class="form-control" id="plot_name" name="plot_name" placeholder="请输入小区名称" value="${requestScope.designercase.plot_name }">
		  <span id="plot_nameerror"></span>
		</div>
		<div class="form-group">
		 装修风格： <input type="text" class="form-control" id="style1" name="style1" placeholder="装修风格" value="${requestScope.designercase.style }">
		  <span id="style1error"></span>
		</div>	
		<div class="form-group">
		  案例描述：<input type="text" class="form-control" id="des" name="des" placeholder="请描述该案例" value="${requestScope.designercase.des }">
		   <span id="deserror"></span>
		</div>
<div class="container">
<div class="container col-lg-8 col-lg-offset-2">
	<div data-am-widget="slider" class="am-slider am-slider-default"
		data-am-slider='{&quot;animation&quot;:&quot;slide&quot;,&quot;slideshow&quot;:false}'>
		<ul class="am-slides">
			<li><img src="<%=path%>/${requestScope.designercase.image_1}">
				<div class="am-slider-desc">第一张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.designercase.image_2}">
				<div class="am-slider-desc">第二张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.designercase.image_3}">
				<div class="am-slider-desc">第三张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.designercase.image_4}">
				<div class="am-slider-desc">第四张案例图</div></li>
			<li><img src="<%=path%>/${requestScope.designercase.image_5}">
				<div class="am-slider-desc">第五张案例图</div></li>
		</ul>
	</div>
</div>
</div>
<div class="form-group">
			<input type="file" name="photo1" id="photo1" /> 
		</div>
		<div class="form-group">
			<input type="file" name="photo2" id="photo2" /> 
		</div>
		<div class="form-group">
			<input type="file" name="photo3" id="photo3" /> 
		</div>
		<div class="form-group">
			<input type="file" name="photo4" id="photo4" /> 
		</div>
		<div class="form-group">
			<input type="file" name="photo5" id="photo5" /> 
		</div>
		<button class="btn btn-primary" type="submit" onclick="return yanzhen();">提交</button>
		<span id="ok"></span>
</form>
	 <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>