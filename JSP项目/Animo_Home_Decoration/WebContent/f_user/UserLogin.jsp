<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>业主登录</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path%>/css/index.css" rel="stylesheet">
<link href="<%=path%>/css/index(1).css" rel="stylesheet">
<link href="<%=path%>/css/index(2).css" rel="stylesheet">
<link href="resources/style/style.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="<%=path %>/resources/js/jquery.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/jquery.i18n.properties-1.0.9.js" ></script>
<script type="text/javascript" src="<%=path %>/resources/js/jquery-ui-1.10.3.custom.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/md5.js"></script>
<script type="text/javascript" src="<%=path %>/resources/js/page_regist.js?lang=zh"></script>
</head>
<body>

<!--主体内容-->
<div class="body fn-clear" style="background-image: url('../images/Home_page_background.jpg');">
    <div class="main">
        <div class="wrapper">
            
<div class="grid-370 fn-clear">
    <ul class="tab-choose">
        <li class="tab-choose-item selected">
            <a href="<%=path%>/index/customerlogin">登录</a>
        </li>
        <li class="tab-choose-item">
            <a href="<%=path%>/index/customerreg">注册</a>
        </li>
    </ul>
</div>

				<div class="grid-370">
					<form class="ui-form ui-form-l ui-form-general" id="form"
						method="post" action="#" data-targeturl="#"
						novalidate="novalidate" data-widget-cid="widget-0">
						<fieldset>
							<legend>注册</legend>
							<input type="hidden" name="targetUrl" value="#">
							<div class="ui-form-item">
							<span id="emailspan" style="color: red;">${requestScope.emailspan }</span>
								<input type="email" class="ui-input" name="email"
									data-role="mobile" autocomplete="off" placeholder="请输入邮箱"
									id="emali" data-widget-cid="widget-1" data-explain=""
									onblur="checkEmail1(this);"
									>
								<div class="ui-form-explain"></div>
							</div>


							<div class="ui-form-item">
							<span id="pwdspan"></span>
								<input type="password" class="ui-input" name="password"
									placeholder="请输入密码" data-widget-cid="widget-3" data-explain="">
							</div>
							<div class="fn-left">
							<span id="info"></span>
								<input type="button"
									class="ui-button ui-button-red ui-button-lred " value="立即登录" onclick="login();">
							</div>
						</fieldset>
					</form>
				</div>
			</div>
    </div>
</div>
<script type="text/javascript" src="<%=path%>/js/customer.js"></script>
<script type="text/javascript" src="<%=path %>/js/jquery-3.2.0.min.js"></script>
<script src="js/seajs-config.js"></script>
<script src="js/v.js"></script>
<script src="js/hm.js"></script>
</body>
</html>