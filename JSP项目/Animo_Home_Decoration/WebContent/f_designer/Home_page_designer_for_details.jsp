<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8" />
<title>设计师个人详情</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<script src="<%=path%>/js/appoint.js"></script>
</head>
<body>
<c:import url="/top_page.jsp"></c:import>
	<div class="bg-gray elite-detaile clearfix">
		<div class="elite-detaile-banner"
			style="background: url(<%=path %>/images/img7.jpg) no-repeat center center;">
			<div class="text-center">
				<img class="headPic" src="<%=path %>/${requestScope.designer.headicon }"
					width="90" height="90">
				<p class="name">${requestScope.designer.name }</p>
				<p class="guanzhu">北京 - 墅装首席专家</p>
				<p class="jingyan">从业经验：${requestScope.designer.experience} | 案例作品：${requestScope.count }套 | 擅长风格:${requestScope.designer.style } </p>
			</div>
		</div>
	</div>
	<div class="container content">
		<div class="AreaL">
			<div class="bg-white elite-detaile-content">

				<h2 class="win-title">
					<span class="tit">${requestScope.designer.name }的案例作品（${requestScope.count }套）</span>
				</h2>
				<div class="row case">
				<c:if test="${requestScope.count >0}">
				<c:forEach items="${requestScope.designercase }" var="designercase"  >
					<div class="col-xs-4">
						<div class="item">
							<a href="<%=path %>/designer/homecasedetails?caseid=${designercase.caseid}" class="pic" target="_blank"><img
								src="<%=path%>/${designercase.image_1}" width="280"
								height="240"></a> <a href="#" class="headPic" target="_blank">
								<c:if test="${designercase.designer_id ==  requestScope.designer.id  }">
								<img src="<%=path %>/${requestScope.designer.headicon }" width="63"
								height="63">
								</c:if>
								</a>
							<div class="info">
								<p class="p1">
									<a href="#" target="_blank">案例名称:${designercase.casename }</a>
								</p>
								<p class="p2">
									设计风格:&nbsp;<span>${designercase.style }</span>&nbsp;
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
				</div>
			</div>
			<div class="bg-white elite-list elite-detaile-content mt20">
				<h2 class="win-title">
					<span class="tit">相关设计师推荐</span> <a href="<%=path %>/designer/alldesigners" target="_blank ">更多&gt;&gt;</a>
				</h2>
				<div class="list bg-white">
					<div class="row">
					<c:forEach items="${requestScope.designertop3 }" var="designertop3">
						<div class="col-xs-4">
							<div class="item text-center">
								<div class="ico-tag ico-tag-2"></div>
								<div class="box1">
									<a  href="<%=path%>/designer/Home_page_designer_for_details?id=${designertop3.id}" target="_blank"><img style="width: 100%;height: 100%;"
										src="<%=path%>/${designertop3.headicon}"></a>
									<p>
										<a href="<%=path %>/designer/designercollect?id=${designertop3.id}"
											onclick="doyoo.util.openChat(&#39;g=10059956&#39;);return false;"
											class="zixun" target="_blank">收藏</a><a
											href="<%=path %>/designer/userconsult?id=${designertop3.id}"
											class="guihua" target="_blank">免费咨询</a>
									</p>
								</div>
								<div class="box2">
									<span class="name">${designertop3.name }</span> <span class="job">集团评定墅装高级专家</span>
								</div>
								<div class="box3 row">
									<div class="col-xs-6">
										设计风格：<span class="text-red">${designertop3.style }</span>
									</div>
									<div class="col-xs-6">
										从业经验：<span class="text-red">${designertop3.experience }</span>年
									</div>
									<div class="col-xs-12">所属店面：${designertop3.address }</div>
								</div>
							</div>
						</div>
					</c:forEach>
					</div>
				</div>
			</div>
		</div>
		<div class="AreaR">
			<div class="submit-info bg-white">
				<i class="ico-tag"></i>
				<h4 class="text-center">免费申请户型规划</h4>
				<p class="p1 text-center">提交您的信息专业家装顾问1对1服务</p>
				<form action="<%=path%>/designer/The_owner_to_make_an_appointment"
					method="post" id="submit-info">
					<input name="designer_id" type="hidden" value="${requestScope.designer.id }" />
					<input id="name" class="txt" type="text" placeholder="您的姓名"
						name="name" data-tit="您的姓名"> <input id="plot_name"
						class="txt" type="text" placeholder="小区名称" name="plot_name"
						data-tit="小区名称"> <input class="txt" type="text"
						maxlength="11" placeholder="手机号码" name="phone" data-tit="手机号码">
					<input class="txt" type="text" placeholder="房屋面积" name="area"
						data-tit="房屋面积"> <select class="txt" id="way" name="way"
						data-tit="风格偏好">
						<option value="">请选择您的装修方式</option>
						<option value="whole">全包</option>
						<option value="harf">半包</option>
					</select> <select class="txt" id="js-style-list" name="budget"
						data-tit="风格偏好">
						<option value="">请选择您的装修预算</option>
						<option value="5-8万">5-8万</option>
						<option value="8-10万">8-10万</option>
						<option value="10-15万">10-15万</option>
						<option value="15万以上">15万以上</option>
					</select> <input class="btn btn-red" type="submit" value="提交预约">
				</form>
				<p class="p2 text-center">
					免费电话申请:<span class="text-red">400-6600-598</span><br> 马上提交申请即送<span
						class="text-red">1000元</span>家装抵用券
				</p>
			</div>
		</div>
	</div>
</body>
</html>