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
<title>所有装修公司</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<script src="<%=path%>/js/appoint.js"></script>
</head>
<body>
	<c:import url="/top_page.jsp"></c:import>
	<div class="bg-white elite-list elite-detaile-content mt20">
				<div class="list bg-white">
					<div class="row">
					<c:forEach items="${requestScope.companys }" var="companys">
						<div class="col-xs-3">
							<div class="item text-center">
								<div class="ico-tag ico-tag-2"></div>
								<div class="box1">
									<a  href="<%=path %>/company/decoration_company?id=${companys.id}" target="_blank"><img style="width: 100%;height: 100%;"
										src="<%=path%>/${companys.logo}"></a>
									<p>
									<span id="info"></span>
										<a href="<%=path %>/company/companycollect?id=${companys.id}"
											class="zixun">收藏</a>
											<a href="<%=path %>/company/userconsult?id=${companys.id}" class="guihua" target="_blank">免费咨询</a>
									</p>
								</div>
								<div class="box3 row">
									<div class="col-xs-6">
										负责人：<span class="text-red">${companys.principal }</span>
									</div>
									<div class="col-xs-6">公司名称：${companys.company_name }</div>
									<div class="col-xs-6">
										成立：<span class="text-red">${companys.open_date}</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
			<div class="paging">
			<a href="<%=path %>/company/homeallcompanys?pageNo=1">首页</a>
			<a href="<%=path %>/designer/homeallcompanys?pageNo=${currPage - 1}">上一页</a> 
			<a href="<%=path %>/designer/homeallcompanys?pageNo=${currPage - 1}">下一页</a> 
			<a href="<%=path %>/designer/homeallcompanys?pageNo=${requestScope.totalPage}">末页</a>
		</div>		
			<c:import url="/trailer_page.jsp"></c:import>
</body>
</html>