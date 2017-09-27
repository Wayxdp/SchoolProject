<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>所有收藏的装修公司</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<script src="<%=path%>/js/appoint.js"></script>
</head>
<body>
	<div class="bg-white elite-list elite-detaile-content mt20">
				<div class="list bg-white">
					<div class="row">
					<c:forEach items="${requestScope.Companys }" var="Companys">
						<div class="col-xs-4">
							<div class="item text-center">
								<div class="ico-tag ico-tag-2"></div>
								<div class="box1">
									<a  href="<%=path %>/company/decoration_company?id=${Companys.company_id}" target="_blank"><img style="width: 100%;height: 100%;"
										src="<%=path%>/${Companys.logo}"></a>
									<p>
										<a style="width: 100%" href="<%=path %>/customer/deletecompanycollect?id=${Companys.id}"
											onclick="doyoo.util.openChat(&#39;g=10059956&#39;);return false;"
											class="zixun">取消收藏</a>
									</p>

								</div>
								<div class="box3 row">
									<div class="col-xs-6">
										负责人：<span class="text-red">${Companys.principal }</span>
									</div>
									<div class="col-xs-6">公司名称：${Companys.company_name }</div>
									<div class="col-xs-6">
										成立：<span class="text-red">${Companys.open_date}</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
			<div class="paging">
			<a href="<%=path %>/customer/companycollect?pageNo=1">首页</a>
			<a href="<%=path %>/customer/companycollect?pageNo=${currPage - 1}">上一页</a> 
			<a href="<%=path %>/customer/companycollect?pageNo=${currPage - 1}">下一页</a> 
			<a href="<%=path %>/customer/companycollect?pageNo=${requestScope.totalPage}">末页</a>
		</div>		
</body>
</html>