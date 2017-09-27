<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path1 = request.getContextPath();
%>
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8">
<title>康泰家装</title>
 <link rel="icon" href="<%=path1 %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" href="<%=path1%>/css/public.css">
<link rel="stylesheet" href="<%=path1%>/css/style.css">
<link rel="stylesheet" href="<%=path1%>/css/oms.css">
<style type="text/css">
	a:hover{
text-decoration:none;
}
</style>
</head>
<body>
	<!--头部/s-->
	<div class="topbar">
    <div class="container">
        <div class="row">
            <div class="col-xs-7 mission"> 康泰愿景：成为最受尊敬的卓越的家装品牌服务商 </div>
            <div class="col-xs-5 text-right" id="js-head">
            <c:choose>
            	<c:when test="${sessionScope.customer1 != null }">
            		<a href="<%=path1%>/Animo/Bnimo/Cnimo/overall" class="text-red" target="_blank">欢迎您，${sessionScope.customer1.name}</a> | <a href="<%=path1%>/customer/exit" target="_self"> 退出 </a>
				</c:when>
				<c:when test="${sessionScope.company1 != null }">
            		<a href="<%=path1%>/Animo/Bnimo/Cnimo/overall" class="text-red" target="_blank">欢迎您，${sessionScope.company1.company_name}</a> | <a href="<%=path1%>/company/exit" target="_self"> 退出 </a>
				</c:when>
				<c:when test="${sessionScope.designer1 != null }">
            		<a href="<%=path1%>/Animo/Bnimo/Cnimo/overall" class="text-red" target="_blank">欢迎您，${sessionScope.designer1.name}</a> | <a href="<%=path1%>/designer/exit"> 退出 </a>
				</c:when>
				<c:when test="${sessionScope.supply1 != null }">
            		<a href="<%=path1%>/Animo/Bnimo/Cnimo/overall" class="text-red" target="_blank">欢迎您，${sessionScope.supply1.name}</a> | <a href="<%=path1%>/supply/exit" target="_self"> 退出 </a>
				</c:when>
            </c:choose>
            <c:if test="${sessionScope.customer1 ==null && sessionScope.company1 ==null && sessionScope.designer1 ==null && sessionScope.supply1==null}">
            		登录注册
            </c:if>
            </div>
        </div>
    </div>
</div>
<div class="head">
    <div class="container">
        <div class="row">
            <div class="col-xs-4">
                <div class="row">
                    <div class="col-xs-7"> <a href="<%=path1%>"><img src="<%=path1%>/images/logo.png.png"></a> </div>
                    <div class="col-xs-5">
                        <div class="AreaNav">
                            <div class="cityList">
                                <div class="tabLayer">
                                    <div> 
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-5">
            	<form action="http://www.dyrs.com.cn/search" method="get" target="_blank">
                <div class="search clearfix" style="height: 
                40px" id="search">
                    <dl class="pull-left">
                        <dt> <i class="arrow pull-right"></i> <span style="width: 100%;height: 100%;" searchtype="案例">案例</span> </dt>
                        <dd style="">
                            <span searchtype="case">案例</span>
                            <span searchtype="designer">设计师</span>
                            <span searchtype="building">楼盘/小区</span>
                            <span searchtype="photo">图片</span>
                        </dd>
                    </dl>
                    <input type="hidden" name="action" id="searchtype" value="case">
                    <input type="text" name="word" class="pull-left keyword" placeholder="关键词" value="">
                    <input style="height: 100%;" type="submit" class="submit" value="搜索">
                </div>
                </form>
            </div>
            <div class="col-xs-3">
                <div class="HotLine" style="padding-top:0px;"> <i class="ico-phone"></i>
                    <p class="p1">24小时家装咨询：</p>
                    <p class="p2 text-red">400-6600-598</p>
                    <ul class="text-center">
                        <li>家装咨询：<span class="text-red">400-400-400</span></li>
                        <li>投诉建议：<span class="text-red">010-010-010</span></li>
                        <li>媒体合作：<span class="text-red">435-435-435</span></li>
                    </ul>
                </div>
            </div>
        </div>
    </div>
</div>
	<div class="navBar">
    <div class="container">
        <ul class="pull-left">
            <li class="active"><a href="<%=path1 %>" class="nav-menu">首页</a></li>
            <li>
            	<a href="<%=path1 %>/designer/alldesigners" class="nav-menu">设计师</a>
            	<div class="sub-menu"> 
	                <a href="<%=path1 %>/designer/alldesigners" >精英设计师</a>
	      			<a href="<%=path1 %>/designer/alldesingercase" >精选案例</a>
                </div>
            </li>
            <li>
            	<a href="<%=path1 %>/supply/homeallsupply" class="nav-menu">建材商</a>
            	<div class="sub-menu"> 
        			<a href="<%=path1 %>/supply/homeallsupply" >精英建材商</a>
	      			<a href="<%=path1 %>/supply/homeallproduct" >优质建材商品</a>
                </div>
            </li>
            <li>
            	<a href="<%=path1 %>/company/homeallcompanys" target="_blank" class="nav-menu">装修公司</a>
            	<div class="sub-menu"> 
                  	<a href="<%=path1 %>/company/homeallcompanys" >装修公司</a>
	      			<a href="<%=path1 %>/company/homeallcompanycases" >装修公司案例</a>
                </div>
            </li>
            <li>
            	<a class="nav-menu">优惠活动</a>
            	<div class="sub-menu"> 
                    <a href="<%=path1 %>/company/pastcompanyActivity" >装修公司往期活动</a>
                    <a href="<%=path1 %>/supply/pastsupplyActivity" >建材商往期活动</a>
	      			<a href="<%=path1 %>/company/companyActivity" >装修公司活动</a>
	      			<a href="<%=path1 %>/supply/supplyActivity" >建材商活动</a>
                </div>
            </li>
        </ul>
    </div>
</div>
	<script src="<%=path1%>/js/oms.js"></script>
	<script src="<%=path1%>/js/change_view.js"></script>
	<script src="<%=path1%>/js/ja.js"></script>
	<script src="<%=path1%>/js/jquery-3.2.0.min.js"></script>
	<script src="<%=path1%>/js/bootstrap.min.js"></script>
	<script src="<%=path1%>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path1%>/js/main.js"></script>
	<script src="<%=path1%>/js/jquery.min.js"></script>
</body>
</html>