<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"  />
<title>康泰家装</title>
 <link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" href="<%=path%>/css/public.css">
<link rel="stylesheet" href="<%=path%>/css/style.css">
<link rel="stylesheet" href="<%=path%>/css/oms.css">
<style type="text/css">
.dropdown:hover {
	background-color: gray;
}
a:hover{
text-decoration:none;
}

</style>
<link href="<%=path%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path%>/css/stylea.css" rel="stylesheet">
</head>
<body>
	<c:import url="top_page.jsp"></c:import>
	<div id="carousel-example-generic" class="carousel slide"
		data-ride="carousel">
		<!-- 轮播图数量 -->
		<ol class="carousel-indicators">
			<li data-target="#carousel-example-generic" data-slide-to="0"
				class="active"></li>
			<li data-target="#carousel-example-generic" data-slide-to="1"></li>
			<li data-target="#carousel-example-generic" data-slide-to="2"></li>
			<li data-target="#carousel-example-generic" data-slide-to="3"></li>
		</ol>
		<!-- 轮播图片 -->
		<div class="carousel-inner" role="listbox">
			<div class="item  active">
				<img class="img-responsive" src="<%=path%>/images/carousel_1.jpg"
					height="100%" width="100%" alt="Responsive image">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img class="img-responsive" src="<%=path%>/images/carousel_2.jpg"
					height="100%" width="100%" alt="Responsive image">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img class="img-responsive" src="<%=path%>/images/carousel_3.jpg"
					height="100%" width="100%" alt="Responsive image">
				<div class="carousel-caption"></div>
			</div>
			<div class="item">
				<img class="img-responsive" src="<%=path%>/images/carousel_4.jpg"
					height="100%" width="100%" alt="Responsive image">
				<div class="carousel-caption"></div>
			</div>
		</div>
		<!-- 轮播图按钮 -->
		<a class="left carousel-control" href="#carousel-example-generic"
			role="button" data-slide="prev"><span
			class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
			class="sr-only">Previous</span> </a> <a class="right carousel-control"
			href="#carousel-example-generic" role="button" data-slide="next"><span
			class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
			<span class="sr-only">Next</span> </a>
	</div>
	
	<div class="container">
		<a href="<%=path %>/company/homeallcompanys" target="_blank"><h2 class="win-title">
				<span class="tit">装修公司</span> <small>[大家信赖的首选，你值得预约]</small>
			</h2></a>
		<div class="brand-ensure">
			<div class="row">
			
			<c:forEach items="${requestScope.companys}" var="companys">
				<div class="item">
					<a href="#" target="_blank"
						class="pic"><img class="lazy"
						data-original="#"
						src="<%=path %>/${companys.logo}" width="290" alt="东易日盛环保材料"
						height="230" style="display: block;"></a>
					<h4>公司负责人:${companys.principal}</h4>
					<p>
						<span class="pull-left">公司名称:${companys.company_name}</span> <a
							href="<%=path %>/company/decoration_company?id=${companys.id}" target="_blank"
							class="pull-right">进入主页&lat;</a>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
	</div>
				
	
	
	<div class="container">
		<a href="<%=path %>/supply/homeallsupply" target="_blank"><h2 class="win-title">
				<span class="tit">建材商</span> <small>[大家信赖的首选，你值得预约]</small>
			</h2></a>
		<div class="brand-ensure">
			<div class="row">
			
			<c:forEach items="${requestScope.supplys}" var="supplys">
				<div class="item">
					<a href="#" target="_blank"
						class="pic"><img class="lazy"
						data-original="#"
						src="<%=path %>/${supplys.logo}" width="290" alt="东易日盛环保材料"
						height="230" style="display: block;"></a>
					<h4>公司负责人:${supplys.principal}</h4>
					<p>
						<span class="pull-left">公司名称:${supplys.name}</span> <a
							href="<%=path %>/supply/decoration_company?id=${supplys.id}" target="_blank"
							class="pull-right">进入主页&lat;</a>
					</p>
				</div>
				</c:forEach>
				
			</div>
		</div>
	</div>
	
	
	
	<div class="container">
		<a href="#" target="_blank"><h2
				class="win-title">
				<span class="tit">装修公司服务案例</span> <small>[优选2千套实景案例，超8万张照片供您赏析]</small>
			</h2></a>
		<div class="row case-show">
		
		
		<c:forEach items="${requestScope.Company_cases }" var="Company_cases">
			<div class="item">
				<img class="lazy"
					data-original="#"
					src="<%=path %>/${Company_cases.image_1}" width="288" 
					height="251" style="display: block;"> <a
					href="#" target="_blank"> <span>${Company_cases.name}</span>
					<small>${Company_cases.style}</small>
				</a>
				<div class="svg">
					<span class="top"></span> <span class="left"></span> <span
						class="bottom"></span> <span class="right"></span>
				</div>
			</div>
			</c:forEach>


			<div class="item">
				<img class="lazy"
					data-original="#"
					src="<%=path %>/images/index-img8.jpg!c" width="288" alt="雅致主义风格装修效果图"
					height="251" style="display: block;"> <a
					href="<%=path %>/company/allcompanycase" target="_blank"> <span>查看更多</span>
					<small>Elegant doctrine</small>
				</a>
				<div class="svg">
					<span class="top"></span> <span class="left"></span> <span
						class="bottom"></span> <span class="right"></span>
				</div>
			</div>
		</div>
		<a href="<%=path %>/company/homeallcompanycases" class="case-more">查看全部案例
			&gt;</a>
	</div>

	<div class="design-Team">
		<div class="container">
			<h2 class="win-title">
				<a href="<%=path %>/designer/alldesigners" target="_blank"
					style="position: relative;"><span class="tit">设计团队</span></a> <small>[汇集了国内外精英设计师]</small>
				<a href="<%=path %>/designer/alldesingercase">more+</a>
			</h2>
			<div class="row">
				<div class="col-xs-5">
					<div class="row">
					<img
							class="lazy"
							data-original="#"
							src="<%=path %>/images/665570c5ab90329b.jpg!m" width="470" height="470"
							style="display: block;">
					</div>
				</div>
				<div class="col-xs-7">
					<div class="row" id="designer_right">
					<c:forEach items="${requestScope.designers }" var="designers" varStatus="status">
						<div class="item">
							<a href="<%=path%>/designer/Home_page_designer_for_details?id=${designers.id}" target="_blank"><img
								class="lazy"
								data-original="#"
								src="<%=path %>/${designers.headicon }" width="225" height="225"
								style="display: block;"></a>
							<div class="design-info">
								<p class="p1">
									<span class="name">${designers.name}</span>[工作经验:${designers.experience }]
								</p>
								<p class="p2">擅长风格:${desingers.style }</p>
							</div>
						</div>
						</c:forEach>
						
						
					</div>
				</div>
			</div>
			<div class="text-center btnBox">
				<a href="<%=path %>/designer/alldesingercase" target="_blank">选择适合我的设计师</a>
			</div>
		</div>
	</div>
	<div class="container">
		<a href="<%=path %>/supply/homeallproduct" target="_blank"><h2 class="win-title">
				<span class="tit">精选建材</span> <small>[产品全球甄选，安全环保，值得信赖]</small>
			</h2></a>
		<div class="brand-ensure">
			<div class="row">
			<c:forEach items="${requestScope.products }" var="products">
				<div class="item">
					<a href="#" target="_blank"
						class="pic"><img class="lazy"
						data-original="#"
						src="<%=path %>/${products.image}" width="290" "
						height="230" style="display: block;"></a>
					<h4>${products.productname}</h4>
					<p>
						<span class="pull-left">商品价格:${products.price}</span> <br/>
						<span class="pull-left">折扣价格:${products.sale_price}</span>
						<a href="#" target="_blank" class="pull-right">详情描述&gt;</a>
					</p>
				</div>
				</c:forEach>
			</div>
		</div>
		<a href="#" target="_blank">
			<h2 class="win-title">
				<span class="tit">无忧售后</span> <small>[7×24小时全天候管家式服务，让您的家装省心，安心，放心！]</small>
			</h2>
		</a>
	</div>
	<div class="service">
		<div class="container">
			<div class="animate ">
				<div class="hline"></div>
				<ul class="point">
					<li class="p-1"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-2"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-3"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-4"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-5"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-6"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-7"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
					<li class="p-8"><span class="circle"></span><span
						class="vline"></span><span class="ico"></span></li>
				</ul>
				<ul class="txt">
					<li class="t-1">1.家装咨询</li>
					<li class="t-2">2.确认设计师</li>
					<li class="t-3">3.签订设计协议</li>
					<li class="t-4">4.设计测量</li>
					<li class="t-5">5.签订装修合同</li>
					<li class="t-6">6.施工，生产</li>
					<li class="t-7">7.验收安装</li>
					<li class="t-8">8.售后保修</li>
				</ul>
			</div>
		</div>
	</div>
	<c:import url="trailer_page.jsp"></c:import>
	<script src="<%=path%>/js/oms.js"></script>
	<script src="<%=path%>/js/change_view.js"></script>
	<script src="<%=path%>/js/ja.js"></script>
	<script src="<%=path%>/js/jquery-3.2.0.min.js"></script>
	<script src="<%=path%>/js/bootstrap.min.js"></script>
	<script src="<%=path%>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path%>/js/main.js"></script>
	<script src="<%=path%>/js/jquery.min.js"></script>
</body>
</html>