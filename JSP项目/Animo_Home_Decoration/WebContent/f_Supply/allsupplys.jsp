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
<title>所有建材商</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
</head>
<body>
	<div class="bg-white elite-list elite-detaile-content mt20">
				<h2 class="win-title">
					<span class="tit">相关建材商推荐推荐</span> <a href="<%=path %>/designer/alldesigners" target="_blank ">更多&gt;&gt;</a>
				</h2>
				<div class="list bg-white">
					<div class="row">
					<c:forEach items="${requestScope.supplys }" var="supplys">
						<div class="col-xs-4">
							<div class="item text-center">
								<div class="box1">
									<a  href="<%=path %>/supply/decoration_company?id=${supplys.id}" target="_blank"><img style="width: 100%;height: 100%;"
										src="<%=path%>/${supplys.logo}"></a>
									<p>
										<a style="width: 100%" href="<%=path %>/supply/supplycollect?id=${supplys.id}"
											onclick="doyoo.util.openChat(&#39;g=10059956&#39;);return false;"
											class="zixun" target="_blank">收藏</a>
									</p>

								</div>
								<div class="box3 row">
									<div class="col-xs-6">
										负责人：<span class="text-red">${supplys.principal }</span>
									</div>
									<div class="col-xs-6">公司名称：${supplys.name }</div>
									<div class="col-xs-6">
										成立：<span class="text-red">${supplys.open_date}</span>
									</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
</body>
</html>