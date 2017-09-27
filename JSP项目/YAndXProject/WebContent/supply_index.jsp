<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String path = request.getContextPath();
    %> 
<!DOCTYPE html>
<html lang="zh-CN">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>建材商主页</title>
    

    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/index.css" rel="stylesheet" />
    
    <script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/swiper.3.2.0.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/promo_v2.js"></script>
	<script type="text/javascript" src="<%=path %>/js/common.js"></script>

	<link rel="stylesheet" type="text/css" href="<%=path %>/css/swiper.3.2.0.min.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/common.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/inside.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/css/cm_pagination.css">
    

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>
	<nav class="navbar-inverse navbar-fixed">
       <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
           <a class="navbar-brand" href="<%=path %>/index.jsp">主页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="<%=path %>/com_index1.jsp">装修公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="<%=path %>/supply_index.jsp">建材商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="<%=path %>/des_index.jsp">设计师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="#">所有商品地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	       <a class="navbar-brand" href="<%=path %>/login/cus">登入&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </div>
    	</div>   	
    </nav>
    
    
    
    
    
	<nav style="text-align: center">
		<ul class="pagination">
			<li><a href="#">«</a></li>
			<li><a href="#">1</a></li>
			<li><a href="#">2</a></li>
			<li><a href="#">3</a></li>
			<li><a href="#">4</a></li>
			<li><a href="#">5</a></li>
			<li><a href="#">6</a></li>
			<li><a href="#">»</a></li>
		</ul>
	</nav>
    
    
    
    
    
<!-- 版权 -->
<div class="footerdiv">
    <div class="footer">
        <a href="#" target="_blank" class="foot_list foot_logo"></a>
        <dl class="foot_list">
            <dt>关于我们</dt>
            <dd><a href="/raiders/detail/a-7.html">公司简介</a></dd>
            <dd><a href="/raiders/detail/a-8.html">企业文化</a></dd>
            <dd><a href="/raiders/detail/a-9.html">招贤纳士</a></dd>
            <dd><a href="/raiders/detail/a-10.html">联系我们</a></dd>
        </dl>
        <dl class="foot_list">
            <dt>家装资讯</dt>
            <dd><a href="/raiders/c-3.html">公司新闻</a></dd>
            <dd><a href="/raiders/c-4.html">行业动态</a></dd>
            <dd><a href="/raiders/c-2.html">装修攻略</a></dd>
        </dl>
        <dl class="foot_list">
            <dt>服务支持</dt>
            <dd><a href="/raiders/detail/a-11.html">服务范围</a></dd>
            <dd><a href="/raiders/detail/a-12.html">售后政策</a></dd>
            <dd><a href="/raiders/detail/a-13.html">客服服务</a></dd>
            <dd><a href="/raiders/detail/a-14.html">常见问题</a></dd>
        </dl>
        
        <dl class="foot_list" style="width:208px;">
            <dd class="foot-last">服务热线</dd>
            <dd class="foot-ftel">13667007868</dd>
            <dd class="foot-date">全年365天8:30 - 23:00</dd>
            <dd class="foot-kf"><a href="http://wpa.qq.com/msgrd?v=3&uin=289663630&site=qq&menu=yes">在线客服</a></dd>
        </dl>
    </div>
</div>
</body>
</html>