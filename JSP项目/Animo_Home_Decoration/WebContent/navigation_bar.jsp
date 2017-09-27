<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path1 = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>康泰家装</title>
 <link rel="icon" href="<%=path1 %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" href="<%=path1%>/css/public.css">
<link rel="stylesheet" href="<%=path1%>/css/style.css">
<link rel="stylesheet" href="<%=path1%>/css/oms.css">
</head>
<body>
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
                    <a href="<%=path1 %>/company/companyActivity" >往期活动</a>
	      			<a href="<%=path1 %>" >装修公司活动</a>
	      			<a href="<%=path1 %>" >建材商活动</a>
                </div>
            </li>
                          <c:choose>
              <c:when test="${sessionScope.customer1 == null }">
	            <li>
	                <a class="nav-menu">登录</a>
	                <div class="sub-menu"> 
	                   	<a href="<%=path1%>/index/customerlogin">业主</a>
						<a href="<%=path1%>/index/designerlogin">设计师</a>
						<a href="<%=path1%>/index/supplylogin">建材商</a>
						<a href="<%=path1%>/index/companylogin">装修公司</a>
	                </div>
	            </li>
	            <li>
	                <a class="nav-menu">注册</a>
	                <div class="sub-menu"> 
	                    <a href="<%=path1%>/index/customerreg">业主</a>
						<a href="<%=path1%>/index/designerreg">设计师</a>
						<a href="<%=path1%>/index/supplyreg">建材商</a>
						<a href="<%=path1%>/index/companyreg">装修公司</a>
	                </div>
	            </li>
	            </c:when>
	                <c:when test="${sessionScope.company1 == null }">
	            <li>
	                <a class="nav-menu">登录</a>
	                <div class="sub-menu"> 
	                   	<a href="<%=path1%>/index/customerlogin">业主</a>
						<a href="<%=path1%>/index/designerlogin">设计师</a>
						<a href="<%=path1%>/index/supplylogin">建材商</a>
						<a href="<%=path1%>/index/companylogin">装修公司</a>
	                </div>
	            </li>
	            <li>
	                <a class="nav-menu">注册</a>
	                <div class="sub-menu"> 
	                    <a href="<%=path1%>/index/customerreg">业主</a>
						<a href="<%=path1%>/index/designerreg">设计师</a>
						<a href="<%=path1%>/index/supplyreg">建材商</a>
						<a href="<%=path1%>/index/companyreg">装修公司</a>
	                </div>
	            </li>
	            </c:when>
	                <c:when test="${sessionScope.supply1 == null }">
	            <li>
	                <a class="nav-menu">登录</a>
	                <div class="sub-menu"> 
	                   	<a href="<%=path1%>/index/customerlogin">业主</a>
						<a href="<%=path1%>/index/designerlogin">设计师</a>
						<a href="<%=path1%>/index/supplylogin">建材商</a>
						<a href="<%=path1%>/index/companylogin">装修公司</a>
	                </div>
	            </li>
	            <li>
	                <a class="nav-menu">注册</a>
	                <div class="sub-menu"> 
	                    <a href="<%=path1%>/index/customerreg">业主</a>
						<a href="<%=path1%>/index/designerreg">设计师</a>
						<a href="<%=path1%>/index/supplyreg">建材商</a>
						<a href="<%=path1%>/index/companyreg">装修公司</a>
	                </div>
	            </li>
	            </c:when>
	                <c:when test="${sessionScope.designer1 == null }">
	            <li>
	                <a class="nav-menu">登录</a>
	                <div class="sub-menu"> 
	                   	<a href="<%=path1%>/index/customerlogin">业主</a>
						<a href="<%=path1%>/index/designerlogin">设计师</a>
						<a href="<%=path1%>/index/supplylogin">建材商</a>
						<a href="<%=path1%>/index/companylogin">装修公司</a>
	                </div>
	            </li>
	            <li>
	                <a class="nav-menu">注册</a>
	                <div class="sub-menu"> 
	                    <a href="<%=path1%>/index/customerreg">业主</a>
						<a href="<%=path1%>/index/designerreg">设计师</a>
						<a href="<%=path1%>/index/supplyreg">建材商</a>
						<a href="<%=path1%>/index/companyreg">装修公司</a>
	                </div>
	            </li>
	            </c:when>
            </c:choose>
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