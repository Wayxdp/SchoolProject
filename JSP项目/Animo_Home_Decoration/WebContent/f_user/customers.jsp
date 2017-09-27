<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="UTF-8" />
<title>所有业主</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon" />
<link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6"
	rel="stylesheet">
<link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0"
	rel="stylesheet">
<link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=path %>/css/animate.min.css" rel="stylesheet">
<link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body>
<body class="gray-bg">
	<div class="wrapper wrapper-content animated fadeInRight">
		<div class="row">
			<div class="col-sm-12">
				<div class="ibox float-e-margins">
					<div class="ibox-title">
						<h5>所有业主</h5>
						<div class="ibox-tools">
							<a class="collapse-link"> <i class="fa fa-chevron-up"></i>
							</a>
						</div>
					</div>
					<div class="ibox-content">
						<div class="table-responsive">
							<table class="table table-striped">
								<thead>

									<tr>
										<th>序号</th>
										<th>邮箱</th>
										<th>名称</th>
										<th>手机号</th>
										<th>地址</th>
										<th>创建时间</th>
										<th>最近登陆</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${requestScope.customers }" var="customers"
										varStatus="status">
										<tr>
											<td>${status.count }</td>
											<td>${customers.email }</td>
											<td>${customers.name }</td>
											<td>${customers.phone }</td>
											<td>${customers.address }</td>
											<td>${customers.created_time }</td>
											<td>${customers.last_login_time }</td>
											<td><a
												href="<%=path%>/Animo/Bnimo/Cnimo/customeravailable?id=${customers.id}"><i
													class="fa fa-check text-navy">可用</i></a> <a
												href="<%=path%>/Animo/Bnimo/Cnimo/customerforbidden?id=${customers.id}"><i
													class="fa fa-check text-navy">禁用</i></a> <a
												href="<%=path%>/Animo/Bnimo/Cnimo/customerdetails?id=${customers.id}"><i
													class="fa fa-check text-navy">详情</i></a></td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>

					</div>
				</div>
			</div>

		</div>

		<div class="row">
			<div class="col-sm-12">
				<nav aria-label="Page navigation" class="pull-right">
					<ul class="pagination">
						<li><a href="#" aria-label="Previous"> <span
								aria-hidden="true">&laquo;</span>
						</a></li>
						<li><a href="#">1</a></li>
						<li><a href="#">2</a></li>
						<li><a href="#">3</a></li>
						<li><a href="#">4</a></li>
						<li><a href="#">5</a></li>
						<li><a href="#" aria-label="Next"> <span
								aria-hidden="true">&raquo;</span>
						</a></li>
					</ul>
				</nav>
			</div>
		</div>
	</div>
	<script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
	<script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
	<script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
	<script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
	<script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
	<script src="<%=path %>/js/demo/peity-demo.min.js"></script>

</body>
</html>