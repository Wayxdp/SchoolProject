<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<!-- saved from url=(0043)http://www.dyrs.com.cn/story/201607/1001491 -->
<html lang="en" class=" doyoo_f_original"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<meta http-equiv="X-UA-Compatible" content="chrome=1,IE=edge">
	<title>活动详情-康泰家居装饰</title>
	<meta name="keywords">
	<meta name="description">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/public.css">
	<link rel="stylesheet" href="<%=path %>/css/jquery.mCustomScrollbar.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/css.css">
	<script src="<%=path %>/js/ja.js.下载"></script><script src="<%=path %>/js/change_view.js.下载" type="text/javascript" charset="utf-8"></script>
<script src="<%=path %>/js/share.js.下载"></script><link rel="stylesheet" href="<%=path %>/css/share_style0_16.css"><link rel="stylesheet" href="<%=path %>/css/share_popup.css"></head>
<body>
	

	<!--头部/e-->
	<div id="caseList" class="bg-gray">
		<div class="alllist w1200">
			<div class="container">
			</div>
			<div class="activity clearfix mt20">
				
				<div class="le_nav fl">
					<div class="link_list">
						<a href="<%=path %>/company/pastcompanyActivity" class="name1 db ">装修公司往期活动<span class="fr">&gt;</span></a>
							<a href="<%=path %>/supply/pastsupplyActivity" class="name1 db ">建材商往期活动<span class="fr">&gt;</span></a>
							<a href="<%=path %>/company/companyActivity" class="name2 db ">装修公司活动<span class="fr">&gt;</span></a>
							<a href="<%=path %>/supply/supplyActivity" class="name db current">建材商活动<span class="fr">&gt;</span></a>
					</div>
					
	                
	                
				</div>
				
				<div class="right_cont fr">
					
					<div class="bg-white guide-detaile-content">
		            	<div class="article">
		                    <h1 class="text-center">${requestScope.supply_activity.name }</h1>
		                    <div class="row text-center info-bar">
		                    	<div class="col-xs-6 text-right">
		                        	<span>发布时间：${requestScope.supply_activity.created_time}</span>
		                        	<!--<span>浏览数：320次</span> <i>|</i>-->
		                        </div>
		                        
		                    </div>
		                    <div class="con">
		                        <p style="margin: 0pt;">
		                        	${requestScope.supply_activity.des }
		                        	<img src="<%=path %>/${requestScope.supply_activity.image}" />
		                        </p>
		                    </div>
		                    
		                    
		                </div>
		            </div>
					
				</div>
				
			</div>
		</div>
	</div>
	<script src="<%=path %>/js/jquery.min.js.下载"></script>
	<script src="<%=path %>/js/jquery-1.9.1.min.js(1).下载"></script> 
	<script src="<%=path %>/js/public.js.下载"></script> 
	<script src="<%=path %>/js/sea.js.下载" id="seajsnode"></script>
	<script src="<%=path %>/js/header.js.下载"></script> 
	<script src="<%=path %>/js/appoint.js.下载"></script>
	<script src="<%=path %>/js/ad_common.js.下载"></script>
	
	</body></html>