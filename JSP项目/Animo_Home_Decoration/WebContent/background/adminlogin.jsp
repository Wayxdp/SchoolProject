<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%String path = request.getContextPath(); %>
<html>	
<head>
<title>管理员登录</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="<%=path %>/css/loginstyle.css" rel='stylesheet' type='text/css' />
<!--webfonts-->
<link href="<%=path%>/css/index1111.css" rel="stylesheet">
<style type="text/css">
a:hover,img:hover{
	cursor:url(<%=path%>/images/link.cur),pointer;
}
</style>
</head>
<body>
<script>$(document).ready(function(c) {
	$('.close').on('click', function(c){
		$('.login-form').fadeOut('slow', function(c){
	  		$('.login-form').remove();
		});
	});	  
});
</script>
<div class="login-form">
	<div class="close"> </div>
		<div class="head-info">
			<label class="lbl-1"> </label>
			<label class="lbl-2"> </label>
			<label class="lbl-3"> </label>
		</div>
			<div class="clear"> </div>
	<div class="avtar">
		<img class="img-responsive logo" src="<%=path%>/images/12312.gif" alt="...">
	</div>
			<form action="<%=path %>/Animo/Bnimo/Cnimo/admin" method="post" >
					<input id="email" name="email" type="text" class="text" >
						<div class="key">
					<input id="pwd" name="pwd" type="password" >
						</div>
						<div class="signin">
		<input type="submit" value="Login" >
	</div>
</form>
</div>

</body>
</html>