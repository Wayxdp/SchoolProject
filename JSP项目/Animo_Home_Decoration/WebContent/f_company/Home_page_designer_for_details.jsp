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
<title>装修公司个人详情</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<script src="<%=path%>/js/appoint.js"></script>
  <style>
     #map {
     	height:300px;
     }
    </style>
</head>
<body>
<c:import url="/top_page.jsp"></c:import>
	<div class="bg-gray elite-detaile clearfix">
		<div class="elite-detaile-banner"
			style="background: url(<%=path %>/images/img7.jpg) no-repeat center center;">
			<div class="text-center">
				<img class="headPic" src="<%=path %>/${requestScope.company.logo}"
					width="90" height="90">
				<p class="name">${requestScope.company.principal }</p>
				<p class="guanzhu">${requestScope.company.company_name }</p>
				<p class="jingyan">成立时间：${requestScope.company.open_date} | 案例作品：${requestScope.count }套 | 固定电话:${requestScope.company.tel } </p>
			</div>
		</div>
	</div>
	<div class="container content">
		<div class="AreaL">
			<div class="bg-white elite-detaile-content">
				<h2 class="win-title">
					<span class="tit">${requestScope.company.company_name }的案例作品（${requestScope.count }套）</span>
				</h2>
				<div class="row case">
				 <input type="hidden" id="longitude" value="${requestScope.company.longitude }">
                  <input type="hidden" id="latitude" value="${requestScope.company.latitude }">
				<c:if test="${requestScope.count >0}">
				<c:forEach items="${requestScope.company_cases }" var="company_cases"  >
					<div class="col-xs-4">
						<div class="item">
							<a href="<%=path %>/company/homecasedetails?id=${company_cases.id}" class="pic" target="_blank"><img
								src="<%=path%>/${company_cases.image_1}" width="280"
								height="240"></a> <a href="#" class="headPic" target="_blank">
								<c:if test="${company_cases.company_id ==  requestScope.company.id  }">
								<img src="<%=path %>/${requestScope.company.logo }" width="63"
								height="63">
								</c:if>
								</a>
							<div class="info">
								<p class="p1">
									<a href="#" target="_blank">案例名称:${company_cases.name }</a>
								</p>
								<p class="p2">
									设计风格:&nbsp;<span>${company_cases.style }</span>&nbsp;
								</p>
							</div>
						</div>
					</div>
				</c:forEach>
				</c:if>
				</div>
			</div>
			<div class="am-u-sm-12" id="map"></div>
			<div class="bg-white elite-list elite-detaile-content mt20">
				<h2 class="win-title">
					<span class="tit">相关装修公司推荐</span> <a href="<%=path %>/designer/alldesigners" target="_blank ">更多&gt;&gt;</a>
				</h2>
				<div class="list bg-white">
					<div class="row">
					<c:forEach items="${requestScope.topcompany }" var="topcompany">
						<div class="col-xs-4">
							<div class="item text-center">
								<div class="ico-tag ico-tag-2"></div>
								<div class="box1">
									<a  href="<%=path %>/company/decoration_company?id=${topcompany.id}" target="_blank"><img style="width: 100%;height: 100%;"
										src="<%=path%>/${topcompany.logo}"></a>
									<p>
										<a href="<%=path %>/designer/designercollect?id=${topcompany.id}"
											onclick="doyoo.util.openChat(&#39;g=10059956&#39;);return false;"
											class="zixun" target="_blank">收藏</a>
											<a href="<%=path %>/company/userconsult?id=${companys.id}" class="guihua" target="_blank">免费咨询</a>
									</p>
								</div>
								<div class="box3 row">
									<div class="col-xs-6">
										负责人：<span class="text-red">${topcompany.principal }</span>
									</div>
									<div class="col-xs-6">公司名称：${topcompany.company_name }</div>
									<div class="col-xs-6">
										成立：<span class="text-red">${topcompany.open_date}</span>
									</div>
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
					<input name="designer_id" type="hidden" value="${requestScope.company.id }" />
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
	<script src="http://api.map.baidu.com/api?v=2.0&ak=KjEQlPmSO1aM6G9cFGCQd7WL0arGC6zE"></script>
<script type="text/javascript">
	var map = new BMap.Map("map");    // 创建Map实例
	map.centerAndZoom(new BMap.Point($("#longitude").val(),$("#latitude").val()), 13);  // 初始化地图,设置中心点坐标和地图级别
	map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
	map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
</script>
</body>
</html>