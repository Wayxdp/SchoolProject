<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="content-type" content="text/html; charset=UTF-8">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
<title>优惠活动_往期活动-康泰家居</title>
<link rel="icon" href="<%=path%>/images/inco.png" type="image/x-icon" />
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
	<c:import url="/top_page.jsp"></c:import>
	<div id="caseList" class="bg-gray">
		<div class="alllist w1200">
			<div class="activity clearfix mt20">
				<div class="le_nav fl">
					<div class="link_list">
						<a href="<%=path %>/company/pastcompanyActivity" class="name1 db  current">装修公司往期活动<span class="fr">&gt;</span></a>
						<a href="<%=path %>/supply/pastsupplyActivity" class="name1 db ">建材商往期活动<span class="fr">&gt;</span></a>
						<a href="<%=path%>/company/companyActivity" class="name2 db ">装修公司活动<span
							class="fr">&gt;</span></a> <a href="<%=path%>/supply/supplyActivity"
							class="name3 db">建材商活动<span class="fr">&gt;</span></a>
					</div>
				</div>

				<div class="right_cont fr">
					<div class="city_name clearfix"></div>
					<!--推荐活动-->
					<c:forEach items="${requestScope.companyactivity }"
						var="companyactivity">
						<div class="activity_list">
							<dl class="clearfix">
								<dt class="fl pr">
									<a href="http://www.dyrs.com.cn/activity/201704/17259"
										target="_blank"><img style="width: 100%;height: 100%;" src="<%=path %>/${companyactivity.image}"></a>
									<div class="count pass">
										<i class="ico"></i><span class="countBox"
											data-end="2017-04-08 18:00">活动已结束！</span>
									</div>
								</dt>
								<dd class="fr pr">
									<h2>
										<a href="#" target="_blank">${companyactivity.name}</a>
									</h2>
									<div class="txt">${companyactivity.des}</div>
									<div class="xq">
										<p>
											活动开始：<span>${companyactivity.created_time}</span>
										</p>
										<p>
											咨询热线：<span class="red">400-400-400</span>
										</p>
									</div>
									<div class="link pa">
										<a href="<%=path %>/company/pastCompany_activity?id=${companyactivity.id}" class="more">查看活动详情</a>
									</div>
								</dd>
							</dl>
						</div>
					</c:forEach>

					<div class="paging">
						<a href="<%=path%>/company/companyActivity?pageNo=1">首页</a> <a
							href="<%=path %>/company/companyActivity?pageNo=${currPage - 1}">上一页</a><a
							href="<%=path %>/company/companyActivity?pageNo=${currPage + 1}">下一页</a>
						<a
							href="<%=path %>/company/companyActivity?pageNo=${requestScope.totalPage}">末页</a>
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
<c:import url="/trailer_page.jsp"></c:import>
</body>
</html>