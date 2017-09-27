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

<title>所有设计师案例收藏</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<meta name="keywords" >
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
					<c:forEach items="${requestScope.Compnay_caseAndCustomerAndCompanys }" var="Compnay_caseAndCustomerAndCompanys">
					<li>
						<div class="pic">
							<a href="<%=path %>/designer/homecasedetails?caseid=${Compnay_caseAndCustomerAndCompanys.id}" target="_blank"><img
								class="lazy" style="width: 100%;height: 100%;"
								src="<%=path %>/${Compnay_caseAndCustomerAndCompanys.image_1}"
								style="display: block;"></a> 
								<a href="<%=path %>/customer/deletecompnaycase?caseid=${Compnay_caseAndCustomerAndCompanys.id}"
								class="alllist-list-tab-Ctrl pull-right collect_case"
								case_id="107579"  >取消收藏</a>
						</div>
						
						<div class="caseDetail-push-imgfont relative">
							<a href="http://www.dyrs.com.cn/designer/1543" target="_blank"
								class="caseDetail-push-head absolute"><img
								src="<%=path %>/${Compnay_caseAndCustomerAndCompanys.logo}"
								alt=""></a>
							<p class="caseDetail-push-imgfont-name">
								<a href="http://www.dyrs.com.cn/case/107579"></a>
							</p>
							<p class="caseDetail-push-imgfont-setting">
								<span>小区名称：</span>${Compnay_caseAndCustomerAndCompanys.plot_name}
								<br/><span>案例名称：</span>${Compnay_caseAndCustomerAndCompanys.name}
							</p>
						</div>
					</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		</div>
			
		<div class="paging">
			<a href="<%=path %>/customer/companycasecollect?pageNo=1">首页</a>
			<a href="<%=path %>/customer/companycasecollect?pageNo=${currPage - 1}">上一页</a>
			<a href="<%=path %>/customer/companycasecollect?pageNo=${currPage + 1}">下一页</a>
			<a href="<%=path %>/customer/companycasecollect?pageNo=${requestScope.totalPage}">尾页</a>
		</div>
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
	<script src="<%=path %>/js/jquery-1.9.1.min.js"></script>
	<script src="<%=path %>/js/public.js"></script>
	<script src="<%=path %>/js/sea.js" id="seajsnode"></script>
	<script src="<%=path %>/js/header.js"></script>
	<script src="<%=path %>/js/layer.js"></script>
	<script src="<%=path %>/js/ad_common.js"></script>
</body>
</html>