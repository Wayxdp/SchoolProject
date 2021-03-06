<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>设计师注册</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/index(1).css" rel="stylesheet">
<link href="<%=path%>/css/index(2).css" rel="stylesheet">
</head>
<body>
	<!--主体内容-->
	<div class="body fn-clear" style="background-image: url('../images/Home_page_background.jpg');" >
		<!--主体-->
		<div class="main">
			<div class="wrapper">

				<div class="grid-370 fn-clear">
					<ul class="tab-choose">
						<li class="tab-choose-item"><a
							href="<%=path%>/index/designerlogin">登录</a>
						</li>
						<li class="tab-choose-item selected"><a href="<%=path%>/index/designerreg">注册</a></li>
					</ul>
				</div>

				<div class="grid-370">
					<form class="ui-form ui-form-l ui-form-general" id="form"
						method="post"  data-targeturl="#"
						novalidate="novalidate" data-widget-cid="widget-0">
						<fieldset>
							<legend>注册</legend>
							<input type="hidden" name="targetUrl" value="#">
							<div class="ui-form-item">
							<span id="emailspan" style="color: red;">${requestSope.emailspan }</span>
								<input id="email" type="email" class="ui-input" name="email"
									data-role="mobile" autocomplete="off" placeholder="请输入邮箱"
									 data-widget-cid="widget-1" data-explain=""
									 onblur="checkEmail(this);"
									 >
								<div class="ui-form-explain"></div>
							</div>


							<div class="ui-form-item">
							<span id="pwd1span" style="color: red;">${requestScope.pwd1span }</span>
								<input id=pwd1 type="password" class="ui-input" name="pwd1"
									placeholder="请输入密码" data-widget-cid="widget-3" data-explain=""
									onblur="pwd();"
									>
							</div>
							<div class="ui-form-item">
							<span id="pwd2span" style="color: red;">${requestScope.pwd2span }</span>
								<input id=pwd2 type="password" class="ui-input" name="pwd2"
									placeholder="确认密码" data-widget-cid="widget-3" data-explain=""
									onblur="check();"
									>
							</div>

							<div class="ui-form-item">
								<input id=name type="text" class="ui-input" name="name"
									data-role="mobile" autocomplete="off" placeholder="请输入姓名"
									id="Js_mobile" data-widget-cid="widget-1" data-explain="">
								<div class="ui-form-explain"></div>
							</div>

							<div class="ui-form-item">
							<span id="phonespan"  style="color: red;">${requestScope.phonespan }</span>
								<input type="text" class="ui-input" name="phone"
									data-role="mobile" autocomplete="off" placeholder="请输入手机号"
									id="Js_mobile" data-widget-cid="widget-1" data-explain=""
									onblur="checkMobile(this);"
									>
								<div class="ui-form-explain"></div>
							</div>
							<div class="fn-left">
							<span id="info"  style="color: red;">${requestScope.info}</span>
								<input type="button"
									class="ui-button ui-button-red ui-button-lred " value="申请入驻"
									onclick="reg();"
									>
							</div>
						</fieldset>
					</form>
				</div>
			</div>
		</div>
	</div>
<script type="text/javascript" src="<%=path %>/js/jquery-3.2.0.min.js"></script>
<script type="text/javascript" src="<%=path %>/js/designer.js"></script>
</body>
</html>