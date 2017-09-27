<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- saved from url=(0034)http://www.dyrs.com.cn/case/113811 -->
<%
	String path = request.getContextPath();
%>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>建材商品详情</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<meta name="keywords">
<meta name="description">
<script src="<%=path %>/js/ja.js"></script>
<script src="<%=path %>/js/change_view.js"
	type="text/javascript" charset="utf-8"></script>
<link rel="stylesheet" type="text/css"
	href="<%=path %>/css/public.css">
<link rel="stylesheet" type="text/css"
	href="<%=path %>/css/angle.css">
<link rel="stylesheet"
	href="<%=path %>/css/layer.css"
	id="layui_layer_skinlayercss">
<script src="<%=path %>/js/share.js"></script>
<link rel="stylesheet"
	href="<%=path %>/css/share_style0_16.css">
</head>
<body>
	<div class="caseDetail-view w1200">
		<div class="container">
			<div class="clearfix">
				<div class="pull-left" style="width: 900px;">
					<div class="caseDetail-left">
						<div class="caseDetail-left-top relative">
							<h1 class="textcenter casetitle marginbottom20">${requestScope.SupplyAndProducts.productname }</h1>
							<div class="row text-center caseSpeak marginbottom20">
								<div class="col-xs-7 text-right">
									<span class=""></span>
								</div>
								<div class="col-xs-5">
									<div class="pull-left">
										
									</div>
								</div>
							</div>
							<div class="caseDetail-img-nav pull-left" style="height: 180px;">
									<div id="pic-nav"></div>
								</div>
							<p class="caseIdea marginbottom20 ">
								<b>商品名称:${requestScope.SupplyAndProducts.productname } </b>
							</p>
							<p class="caseIdea marginbottom20 ">
								<b>上架时间:${requestScope.SupplyAndProducts.created_time } </b>
							</p>
							<p class="caseIdea marginbottom20">
								<b>现价:${requestScope.SupplyAndProducts.price } </b>
							</p>
							<p class="caseIdea marginbottom20">
								<b>折扣价:${requestScope.SupplyAndProducts.sale_price} </b>
							</p>
							<p class="caseIdea marginbottom20">
								<b>商品描述:${requestScope.SupplyAndProducts.des } </b>
							</p>
							<div class="caseDetail-show clearfix marginbottom20"
								id="caseDetail-show">
								<div class="caseDetail-img-nav pull-left">
									<div id="pic-nav"></div>
								</div>
								<div class="caseDetail-img pull-left">
									<div class="relative" id="p1094267">
										<p>
											<a
												target="_blank"> <img class="lazy"
												data-original=""
												width="100%"
												src="<%=path %>/${requestScope.SupplyAndProducts.image }"
												style="display: block;">
											</a>
										</p>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
				<!--right-->
				<div class="pull-right w280">
					<div class="caseDetail-right pull-right">
						<h3>本案设计师简介</h3>
						<ul class="caseDetail-right-stylist clearfix">
							<li><a class="caseDetail-right-img"><img
									src="<%=path %>/${requestScope.SupplyAndProducts.logo }"
									alt=""></a></li>
							<li class="caseDetail-right-intro">
								<p>公司:${requestScope.SupplyAndProducts.name }</p>

								<p>负责人:${requestScope.SupplyAndProducts.principal }</p>
								<p>固定电话:${requestScope.SupplyAndProducts.tel }</p> <a
								href="<%=path%>/supply/decoration_company?id=${requestScope.SupplyAndProducts.id }"
								class="caseDetail-right-intro-link">查看ta其它商品</a>
							</li>
						</ul>
					</div>
				</div>
			</div>
		</div>
		<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
		<script
			src="<%=path %>/js/jquery-1.9.1.min.js(1)"></script>
		<script src="<%=path %>/js/public.js"></script>
		<script src="<%=path %>/js/sea.js" id="seajsnode"></script>
		<script src="<%=path %>/js/header.js"></script>
		<script src="<%=path %>/js/appoint.js"></script>
		<script src="<%=path %>/js/layer.js"></script>
		<script src="<%=path %>/js/ad_common.js"></script>
	</div>
</body>
</html>