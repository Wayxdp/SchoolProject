<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8" />
<title>审核建材商</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
    <link href="<%=path %>/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css" rel="stylesheet">
</head>
<body>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>建材商审核</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                            <table class="table table-striped">
                                <thead>
                                    <tr>
                                        <th>序号</th>
                                        <th>公司logo</th>
                                        <th>负责人</th>
                                        <th>手机号</th>
                                        <th>成立日期</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.supply }" var="supply" varStatus="status">
                                	<tr>
                                		<td>${status.count }</td>
                                		<td><img class="img-circle"  style="width: 80px;height: 80px;" src="<%=path%>/${supply.logo }"></td>
                                		<td>${supply.principal }</td>
                                		<td>${supply.phone }</td>
                                		<td>${supply.open_date }</td>
                                		<td>
											<a href="<%=path%>/Animo/Bnimo/Cnimo/supplydetails?id=${supply.id}"><i class="fa fa-check text-navy">详情</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/supplyagree?id=${supply.id}"><i class="fa fa-check text-navy">同意</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/supplydecline?id=${supply.id}"><i class="fa fa-check text-navy">拒绝</i></a>
										</td>
                                	</tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>

</body>
</html>