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
<title>所有收藏的设计师</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<script src="<%=path%>/js/appoint.js"></script>
</head>
<body>
	<div class="bg-white elite-list elite-detaile-content mt20">
				<div class="list bg-white">
					<div class="row">
					<c:forEach items="${requestScope.DesignercaseAndDesigners }" var="designers">
						<div class="col-xs-3">
							<div class="item text-center">
								<div class="ico-tag ico-tag-2"></div>
								<div class="box1">
									<a  href="<%=path%>/designer/Home_page_designer_for_details?id=${designers.id}" target="_blank"><img style="width: 100%;height: 100%;"
										src="<%=path%>/${designers.headicon}"></a>
									<p>
									<a href="<%=path %>/customer/deletedesignercollect?id=${designers.id}" class="zixun" style="width: 100%">取消收藏</a>
									</p>

								</div>
								<div class="box2">
									<span class="name">${designers.name }</span> <span class="job">集团评定墅装高级专家</span>
								</div>
								<div class="box3 row">
									<div class="col-xs-6">
										设计风格：<span class="text-red">${designers.style }</span>
									</div>
									<div class="col-xs-6">
										从业经验：<span class="text-red">${designers.experience }</span>年
									</div>
									<div class="col-xs-12">所属店面：${designers.address }</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
			<div class="paging">
			<a href="<%=path %>/customer/designercollect?pageNo=1">首页</a>
			<a href="<%=path %>/customer/designercollect?pageNo=${currPage - 1}">上一页</a> 
			<a href="<%=path %>/customer/designercollect?pageNo=${currPage - 1}">下一页</a> 
			<a href="<%=path %>/customer/designercollect?pageNo=${requestScope.totalPage}">末页</a>
		</div>			
</body>
</html>