<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
<title>优惠活动_往期活动-康泰家居</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<meta name="keywords">
<meta name="description">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" href="<%=path%>/css/jquery.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/css.css">

<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<!--头部/e-->
	<div id="caseList" class="bg-gray">
		<div class="alllist w1200">
			<div class="activity clearfix mt20">
				<div class="le_nav fl">
					<div class="link_list">
						<a href="#"
							class="name1 db current">往期活动<span class="fr">&gt;</span></a> <a
							href="#" class="name2 db ">装修公司活动<span
							class="fr">&gt;</span></a> <a
							href="#" class="name3 db">建材商活动<span
							class="fr">&gt;</span></a>
					</div>
				</div>

				<div class="right_cont fr">
					<div class="city_name clearfix">
					</div>
					<!--推荐活动-->
					<div class="activity_list">
						<dl class="clearfix">
							<dt class="fl pr">
								<a href="http://www.dyrs.com.cn/activity/201704/17259"
									target="_blank"><img
									src="<%=path %>/img/11.jpg"></a>
								<div class="count pass">
									<i class="ico"></i><span class="countBox"
										data-end="2017-04-08 18:00">活动结束!</span>
								</div>
							</dt>
							<dd class="fr pr">
								<h2>
									<a href="#"
										target="_blank">活动名称</a>
								</h2>
								<div class="txt">活动描述</div>
								<div class="xq">
									<p>
										活动开始：<span>活动时间开始</span>
									</p>
									<p>
										咨询热线：<span class="red">公司固定电话</span>
									</p>
								</div>
								<div class="link pa">
									<a href="javascript:;"
										onclick="doyoo.util.openChat('g=10059956');return false;"
										class="zixun" target="_blank">在线咨询</a><a
										href=""
										class="more">查看活动详情</a>
								</div>
							</dd>
						</dl>
					</div>
					
					
					<div class="paging">
						<a href="http://www.dyrs.com.cn/activity/col1">首页</a> <a
							href="http://www.dyrs.com.cn/activity/col1">&lt;</a> <a
							class="active">1</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p2">2</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p3">3</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p4">4</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p5">5</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p6">6</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p7">7</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p2">&gt;</a> <a
							href="http://www.dyrs.com.cn/activity/col1/p20">末页</a>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="<%=path%>/js/jquery.js"></script>
	<script src="<%=path%>/js/jquery-1.js"></script>
	<script src="<%=path%>/js/public.js"></script>
	<script src="<%=path%>/js/sea.js" id="seajsnode"></script>
	<script src="<%=path%>/js/header.js"></script>
	<script src="<%=path%>/js/appoint.js"></script>
	<script src="<%=path%>/js/ad_common.js"></script>

</body>
</html>