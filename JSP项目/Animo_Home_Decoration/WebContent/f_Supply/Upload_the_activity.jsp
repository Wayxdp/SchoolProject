<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传活动</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
	<form enctype="multipart/form-data" action="<%=path %>/supply/add_activities" method="post" class="col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4" style="padding-top: 60px;">
		<div class="form-group">
		  <input type="text" class="form-control" id="name" name="name" placeholder="请输入活动名称">
		  <span id="plot_nameerror"></span>
		</div>
		<div class="form-group">
		  <textarea name="des" id="des" class="form-control" rows="3" placeholder="请输入活动描述"></textarea>
		<span id="nameerror"></span>
		</div>
		<div class="form-group">
			<input type="file" name="image" id="image" /> 
		</div>
		<button class="btn btn-primary" type="submit" onclick="return yanzhen();">提交</button>
		<span id="ok"></span>
	</form>
	<script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
</body>
</html>