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
<title>用户咨询</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
    <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
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
                        <h5>用户咨询</h5>
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
                                        <th>名称</th>
                                        <th>手机号</th>
                                        <th>留言</th>
                                        <th>账号</th>
                                        <th>QQ</th>
                                        <th>创建时间</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.supplyConsult }" var="supplyConsult">
                                    <tr>
                                        <td>${supplyConsult.name }</td>
                                        <td>${supplyConsult.phone }</td>
                                        <td>${supplyConsult.leave_word }</td>
                                        <td>${supplyConsult.emali }</td>
                                        <td>${supplyConsult.qq }</td>
                                        <td>${supplyConsult.created_time }</td>
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
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>

</body>
</html>