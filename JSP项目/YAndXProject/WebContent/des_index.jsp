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

    <title>设计师主页</title>
    

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

	<div class="team_div">
		<div class="group_list">
			<a href="/team/detail/des-8.html" class="pic"><img
				src="<%=path %>/img/s1.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				谢旺<span>专家设计师</span>
			</div>
			<div class="intro">设计应有如中医的理念，调和系统以治疗有病的人，而非仅仅针对疾病本身。</div>
			<div class="list">
				<a href="/cases/detail/c-21.html"><img
					src="<%=path %>/img/1.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-16.html"><img
					src="<%=path %>/img/3.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-7.html" class="pic"><img
				src="<%=path %>/img/s2.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				杨长鹏<span>专家设计师</span>
			</div>
			<div class="intro">设计生活才是设计的本身，做切实提升客户生活品质的设计。</div>
			<div class="list">
				<a href="/cases/detail/c-17.html"><img
					src="<%=path %>/img/4.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-15.html"><img
					src="<%=path %>/img/1.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-6.html" class="pic"><img
				src="<%=path %>/img/s3.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				孙慧敏<span>专家设计师</span>
			</div>
			<div class="intro">设计源于生活，细节成就品质。</div>
			<div class="list">
				<a href="/cases/detail/c-24.html"><img
					src="<%=path %>/img/6.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-6.html"><img
					src="<%=path %>/img/2.png" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-5.html" class="pic"><img
				src="<%=path %>/img/s4.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				邱萌<span>专家设计师</span>
			</div>
			<div class="intro">从总体规划到细节设计，为您提供完美服务。作为一名女性设计师，每次做设计都格外的关注储藏和收纳，整洁有序才是正确的打开方式。客户提出的要求会认真领会，随时与客户沟通共同完成双方心中优秀的方案。</div>
			<div class="list">
				<a href="/cases/detail/c-10.html"><img
					src="<%=path %>/img/3.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-9.html"><img
					src="<%=path %>/img/6.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-2.html"><img
					src="<%=path %>/img/9.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-4.html" class="pic"><img
				src="<%=path %>/img/s5.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				张敏<span>专家设计师</span>
			</div>
			<div class="intro">设计来源于生活，回归于生活。而我为你打造的就是简约而不简单的家居设计。</div>
			<div class="list">
				<a href="/cases/detail/c-23.html"><img
					src="<%=path %>/img/10.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-22.html"><img
					src="<%=path %>/img/11.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-11.html"><img
					src="<%=path %>/img/12.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-3.html" class="pic"><img
				src="<%=path %>/img/s5.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				朱雄军<span>专家设计师</span>
			</div>
			<div class="intro">自然品质的物质家园，不是简单地将自然要素引入室内，而是结合地方的自然环境特征进行创造性地营造环境特征进行创造性地营造。</div>
			<div class="list">
				<a href="/cases/detail/c-19.html"><img
					src="<%=path %>/img/13.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-7.html"><img
					src="<%=path %>/img/14.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-4.html"><img
					src="<%=path %>/img/15.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-2.html" class="pic"><img
				src="<%=path %>/img/s6.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				朱永建<span>专家设计师</span>
			</div>
			<div class="intro">专注于室内外空间的设计与表达，擅长处理复杂而多变的功能空间；专注别墅豪宅、样板房设计；设计是取之于人而服务于人，根据人们的不足和所需，提供人于便利和舒适这才是设计的本能……</div>
			<div class="list">
				<a href="/cases/detail/c-27.html"><img
					src="<%=path %>/img/16.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-26.html"><img
					src="<%=path %>/img/17.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-14.html"><img
					src="<%=path %>/img/18.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
		<div class="group_list">
			<a href="/team/detail/des-1.html" class="pic"><img
				src="<%=path %>/img/s7.jpg" width="140"
				height="140" /></a>

			<div class="topic">
				南朝（熊威）<span>设计总监</span>
			</div>
			<div class="intro">设计源于生活却高于生活，我的工作就是为客户实实在在解决问题并为其创造价值及附加值，生活中成为朋友，我每年不定期赴国外学习考察，前后很荣幸能为五百多位业主服务……</div>
			<div class="list">
				<a href="/cases/detail/c-25.html"><img
					src="<%=path %>/img/19.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-20.html"><img
					src="<%=path %>/img/20.jpg" width="75"
					height="60" /></a> <a href="/cases/detail/c-18.html"><img
					src="<%=path %>/img/21.jpg" width="75"
					height="60" /></a>
			</div>
		</div>
	</div>

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