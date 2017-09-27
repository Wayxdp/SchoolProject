<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>所有商品收藏</title>
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

<style type="text/css">
.caseDetail-push-list1 .pic {
	position: relative;
}

#caseList .alllist-list-tab-Ctrl {
	position: absolute;
	right: 10px;
	top: 10px;
	display: none;
}

#caseList li:hover .alllist-list-tab-Ctrl {
	display: block;
}

</style>

<link rel="stylesheet" href="<%=path %>/css/layer.css"
	id="layui_layer_skinlayercss">
</head>
<body>
	<!--header end-->
	<div id="caseList" class="caseListindex">
		<div class="w1200">
			<div class="container">
				<ul class="caseDetail-push-list1 clearfix">
					<c:forEach items="${requestScope.CustomerAndProductAndProduct_cols }" var="CustomerAndProductAndProduct_cols">
					<li>
						<div class="pic">
							<a " target="_blank"><img
								class="lazy" style="width: 100%;height: 100%;"
								src="<%=path %>/${CustomerAndProductAndProduct_cols.image}"
								style="display: block;"></a> 
								<a href="<%=path %>/customer/enshrine?id=${CustomerAndProductAndProduct_cols.id}"
								class="alllist-list-tab-Ctrl pull-right collect_case"
								case_id="107579"  >取消收藏</a>
						</div>
						
						<div class="caseDetail-push-imgfont relative">
							<a href="http://www.dyrs.com.cn/designer/1543" target="_blank"
								class="caseDetail-push-head absolute"><img
								src="<%=path %>/${CustomerAndProductAndProduct_cols.logo}"
								alt=""></a>
							<p class="caseDetail-push-imgfont-name">
								<a href="http://www.dyrs.com.cn/case/107579"></a>
							</p>
							<p class="caseDetail-push-imgfont-setting">
								<span>商品名称：</span>${CustomerAndProductAndProduct_cols.productname}
								<br/><span>商品价格：</span>${CustomerAndProductAndProduct_cols.price}&nbsp;&nbsp;
								<span>折扣价格：</span>${CustomerAndProductAndProduct_cols.sale_price}
							</p>
						</div>
					</li>
					</c:forEach>
					
					
				</ul>
			</div>
		</div>
		<div class="paging">
				<a href="<%=path%>/customer/productcollect?pageNo=1">首页</a> 
				<a href="<%=path%>/customer/productcollect?pageNo=${currPage - 1}">上一页</a>
				<a href="<%=path%>/customer/productcollect?pageNo=${currPage + 1}">下一页</a> 
				<a href="<%=path%>/customer/productcollect?pageNo=${requestScope.totalPage}">末页</a>
		</div>
	</div>
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/public.js"></script>
	<script src="<%=path %>/js/sea.js" id="seajsnode"></script>
	<script src="<%=path %>/js/header.js"></script>
	<script src="<%=path %>/js/layer.js"></script>
</body>
</html>