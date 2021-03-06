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

<title>所有建材商品</title>
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
	<c:import url="/top_page.jsp"></c:import>
	<!--header end-->
	<div id="caseList" class="caseListindex">
		<div class="w1200">
			<div class="container">
				<ul class="caseDetail-push-list1 clearfix">
					<c:forEach items="${requestScope.SupplyAndProducts }" var="SupplyAndProducts">
					<li>
						<div class="pic">
							<a " target="_blank"><img
								class="lazy" style="width: 100%;height: 100%;"
								src="<%=path %>/${SupplyAndProducts.image}"
								style="display: block;"></a> 
								<a href="<%=path %>/supply/enshrine?id=${SupplyAndProducts.id}"
								class="alllist-list-tab-Ctrl pull-right collect_case"
								case_id="107579"  >收藏</a>
						</div>
						
						<div class="caseDetail-push-imgfont relative">
							<a href="http://www.dyrs.com.cn/designer/1543" target="_blank"
								class="caseDetail-push-head absolute"><img
								src="<%=path %>/${SupplyAndProducts.logo}"
								alt=""></a>
							<p class="caseDetail-push-imgfont-name">
								<a href="http://www.dyrs.com.cn/case/107579"></a>
							</p>
							<p class="caseDetail-push-imgfont-setting">
								<span>商品名称：</span>${SupplyAndProducts.productname}
								<br/><span>商品价格：</span>${SupplyAndProducts.price}&nbsp;&nbsp;
								<span>折扣价格：</span>${SupplyAndProducts.sale_price}
							</p>
							<!--box-->
							<div class="caseDetail-box absolute hide">
								<div class="box relative">
									<span class="caseDetail-bubble absolute"></span>
									<div class="caseDetail-box-intro">
										<ul class="clearfix">
											<li class="caseDetail-box-img "><a
												href="http://www.dyrs.com.cn/designer/1543" target="_blank"><img
													src="<%=path %>/${SupplyAndProducts.logo}"
													width="90" height="90"></a></li>
											<li class="caseDetail-box-img-intro">
												<p>
													<span class="caseDetail-box-label">建材公司：</span><span
														style="color: #f83536;">${SupplyAndProducts.name}</span>
												</p>
												<p>
													<span class="caseDetail-box-label">成立时间：</span><span>${SupplyAndProducts.open_date}</span>
												</p>
												<p>
													<span class="caseDetail-box-label">建材商品：</span><span>6套</span>
												</p>
												<p
													style="word-break: break-all; word-wrap: break-word; display: inline-block; line-height: 15px;">
													<span class="caseDetail-box-label">负责人：</span> ${SupplyAndProducts.principal}
												</p>
											</li>
										</ul>
									</div>
									<div class="textcenter">
										<a class="box-btn box-btn-active"
											href="<%=path %>/supply/decoration_company?id=${SupplyAndProducts.supply_id}"
											target="_blank">看Ta的建材</a> <a href="<%=path %>/designer/userconsult?id=${SupplyAndProducts.id}" 
											class="box-btn" target="_blank">用户咨询</a>
									</div>
								</div>
							</div>
						</div>
					</li>
					</c:forEach>
					
					
				</ul>
			</div>
		</div>
		<div class="paging">
				<a href="<%=path%>/supply/homeallproduct?pageNo=1">首页</a> 
				<a href="<%=path%>/supply/homeallproduct?pageNo=${currPage - 1}">上一页</a>
				<a href="<%=path%>/supply/homeallproduct?pageNo=${currPage + 1}">下一页</a> 
				<a href="<%=path%>/supply/homeallproduct?pageNo=${requestScope.totalPage}">末页</a>
		</div>
	</div>
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/public.js"></script>
	<script src="<%=path %>/js/sea.js" id="seajsnode"></script>
	<script src="<%=path %>/js/header.js"></script>
	<script src="<%=path %>/js/layer.js"></script>
	<script>
			$(function(){
				var obj=$('.filter-bar .alllist-cur'),t=obj.offset().top;
				$(window).scroll(function(){
					if($(window).scrollTop()>=t){
						obj.addClass('JSfixed')	
					}else{
						obj.removeClass('JSfixed')	
					}
				});
				$('#caseList .alllist-sort-ul li .ico').click(function(){
					$(this).parent().toggleClass('current');
				});
				
			})
			$('.caseDetail-push-head').hover(function(){
				$(this).siblings(".caseDetail-box").removeClass("hide");
			},function(){
				$(this).siblings(".caseDetail-box").addClass("hide");
			});
			$('.caseDetail-box').mouseover(function(){
				$(this).removeClass('hide');
			})
			$('.caseDetail-box').mouseleave(function(){
				$(this).addClass('hide');
			})
			$(".collect_case").each(function(){
				$(this).click(function(){
					var case_id = $(this).attr("case_id");
					var arr = getusercookieValue();
					var uid= arr[0];
					$.post("/api/user/subject.php",{'act':'user_add_subject','subject_id':case_id,'userid':uid},function(data){
						if(data.code == '1000'){
							layer.msg('收藏成功', {icon: 1,time: 1000});
						}else if(data.code == '1002'){
							window.location.href='/user/login.php';
						}else if(data.code == '1006'){
							layer.msg('已经收藏过！', {icon: 2,time: 1000});
						}else{
							layer.msg('收藏失败！', {icon: 2,time: 1000});
						}
						console.log(data);
					},'json');
				});
			});
		</script>
		<c:import url="/trailer_page.jsp"></c:import>
	
</body>
</html>