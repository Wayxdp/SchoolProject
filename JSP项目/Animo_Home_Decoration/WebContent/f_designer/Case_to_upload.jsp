<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传案例</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<script type="text/javascript" src="<%=path%>"></script>
<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form enctype="multipart/form-data" action="<%=path %>/designer/Add_the_ase" method="post" class="col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4" style="padding-top: 60px;">
		<input type="hidden" name="company_id" value="" />
		<div class="form-group">
		  <input type="text" class="form-control" id="name" name="name" placeholder="请输入案例名称">
		<span id="nameerror"></span>
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" id="plot_name" name="plot_name" placeholder="请输入小区名称">
		  <span id="plot_nameerror"></span>
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" id="style1" name="style1" placeholder="装修风格">
		  <span id="style1error"></span>
		</div>	
		<div class="form-group">
		  <input type="text" class="form-control" id="des" name="des" placeholder="请描述该案例">
		   <span id="deserror"></span>
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
</body>
</html>