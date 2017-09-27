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

    <title>装修公司主页</title>
    

    <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path %>/css/index.css" rel="stylesheet" />
  	<%-- <link rel="stylesheet" href="<%=path %>/css/xdp.css" /> --%>


    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://cdn.bootcss.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://cdn.bootcss.com/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
  </head>
<body>

	<%-- <nav class="navbar navbar-default" role="navigation">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">&nbsp;&nbsp;&nbsp;&nbsp;热线电话&nbsp;:18870798915</a>
				<img src="<%=path %>/images/tel2.jpg" style="position:absolute;top:15px;left:10px" /> 
			</div>
			<div>
				<p class="navbar-text navbar-right"><a href="<%=path %>/reg/cus" style="position:absolute;top:10px;left:1100px;"><strong>登入</strong></a></p>
				<p class="navbar-text navbar-right"><img src="<%=path %>/images/wei.jpg" style="position:absolute;top:10px;left:1150px;"></p>
				<p class="navbar-text navbar-right"><img src="<%=path %>/images/fen.jpg" style="position:absolute;top:10px;left:1200px;"></p>
			</div>
		</div>
	</nav> --%>
	
	<nav class="navbar-inverse navbar-fixed">
       <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">主页&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="#">装修公司&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="#">建材商&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="#">设计师&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
           <a class="navbar-brand" href="#">所有商品地&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
	       <a class="navbar-brand" href="<%=path %>/login/cus">登入&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
        </div>
    	</div>   	
    </nav>

	<div>
		<img src="<%=path %>/images/q.jpg" style="position:absolute;top:55px;left:50px;">
		
		<img class="img-circle" src="<%=path %>/images/zy.jpg" style="position:absolute;top:70px;left:650px;">
		<a href="#" style="position:absolute;top:130px;left:660px;"><strong>首页</strong></a>
		
		<img class="img-circle" src="<%=path %>/images/zy.jpg" style="position:absolute;top:70px;left:750px;">
		<a href="#" style="position:absolute;top:130px;left:760px;"><strong>案列</strong></a>
		
		<img class="img-circle" src="<%=path %>/images/zy.jpg" style="position:absolute;top:70px;left:850px;">
		<a href="#" style="position:absolute;top:130px;left:860px;"><strong>套餐</strong></a>
		
		
		<img class="img-circle" src="<%=path %>/images/zy.jpg" style="position:absolute;top:70px;left:950px;">
		<a href="#" style="position:absolute;top:130px;left:960px;"><strong>预约</strong></a>
		
		<img class="img-circle" src="<%=path %>/images/zy.jpg" style="position:absolute;top:70px;left:1050px;">
		<a href="#" style="position:absolute;top:130px;left:1055px;"><strong>团队</strong></a>
		
		<img class="img-circle" src="<%=path %>/images/zy.jpg" style="position:absolute;top:70px;left:1150px;">
		<a href="#" style="position:absolute;top:130px;left:1155px;"><strong>材料</strong></a>
	</div>
	
	
	<!-- 轮播图 -->
	<div id="carousel-example-generic" class="carousel slide" data-ride="carousel" style="position:absolute;top:200px;">
		  <!-- Indicators -->
		  <ol class="carousel-indicators">
		    <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="1"></li>
		    <li data-target="#carousel-example-generic" data-slide-to="2"></li>
		  </ol>
		
		  <!-- Wrapper for slides -->
		  <div class="carousel-inner" role="listbox" style="ppadding-top: 0px">
		    <div class="item active">
		      <img src="<%=path %>/images/q1.jpg" alt="图片1" />
		    </div>
		    
		    <div class="item">
		      <img src="<%=path %>/images/q2.jpg" alt="图片2" />
		    </div>
		    
		    <div class="item">
		      <img src="<%=path %>/images/q3.jpg" alt="图片3" />
		    </div>
		  </div>
		
		  <!-- Controls -->
		  <a class="left carousel-control" href="#carousel-example-generic" role="button" data-slide="prev">
		    <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
		    <span class="sr-only">Previous</span>
		  </a>
		  <a class="right carousel-control" href="#carousel-example-generic" role="button" data-slide="next">
		    <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
		    <span class="sr-only">Next</span>
		  </a>
	</div>
	
	<div class="container" style="position:absolute;top:650px;left:40px">
		<h2><b>装修流程</b></h2><hr width="280" align="left"/>
	</div>

		<div class="row" style="position:absolute;top:750px;left:80px;">
				<img class="img-circle" src="<%=path%>/images/d1.png" alt="执行流程">
				<strong>////////////////////////////</strong>
				<img class="img-circle" src="<%=path%>/images/d2.png" alt="执行流程">
				<strong>////////////////////////////</strong>
				<img class="img-circle" src="<%=path%>/images/d3.png" alt="执行流程">
				<strong>///////////////////////////</strong>
				<img class="img-circle" src="<%=path%>/images/d4.png" alt="执行流程">
				<strong>//////////////////////////</strong>
				<img class="img-circle" src="<%=path%>/images/d5.png" alt="执行流程">
				<strong>//////////////////////////</strong>
				<img class="img-circle" src="<%=path%>/images/d6.png" alt="执行流程">
				<marquee direction="left" behavior="slide">联系方式：8888888888</marquee>
		</div>



		<script src="<%=path %>/js/jquery.min.js"></script>
		<script src="<%=path %>/js/bootstrap.min.js"></script>
</body>
</html>