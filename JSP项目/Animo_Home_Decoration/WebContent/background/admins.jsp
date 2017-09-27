<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>所有管理员</title>
    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
    <div class="wrapper wrapper-content animated fadeInRight">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>所有管理员</h5>
                        <div class="ibox-tools">
                            <a class="collapse-link">
                                <i class="fa fa-chevron-up"></i>
                            </a>
                        </div>
                    </div>
                    <div class="ibox-content">
                        <div class="table-responsive">
                            <table class="table table-bordered"><!--table table-striped-->
                                <thead>
                                    <tr>
                                   		<th>序号</th>
                                        <th>名称</th>
                                        <th>邮箱</th>
                                        <th>手机号</th>
                                        <th>权限</th>
                                        <th>创建时间</th>
                                        <th>最近登录</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.admins }" var="adm" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td>${adm.name }</td>
                                        <td>${adm.email }</td>
                                        <td>${adm.phone}</td>
                                        <td>
                                        <c:choose>
                                        	<c:when test="${adm.status =='N' }">禁用</c:when>
                                        	<c:when test="${adm.status =='Y' }">可用</c:when>
                                        </c:choose>
                                        </td>
                                        <td>${adm.created_time }</td>
                                        <td>${adm.last_login_time }</td>
                                        <td>
                                        <c:if test="${adm.status =='Y' }">
                                        	<a  class="fa fa-check text-navy" href="<%=path%>/Animo/Bnimo/Cnimo/role?id=${adm.id}">禁用</a>
                                        </c:if>
                                        <c:if test="${adm.status =='N' }">
                                        	<a   class="fa fa-check text-navy" href="<%=path%>/Animo/Bnimo/Cnimo/roles?id=${adm.id}">可用</a>
                                        </c:if>
                                            <a  class="fa fa-check text-navy" href="<%=path%>/Animo/Bnimo/Cnimo/delete?id=${adm.id}">删除</a>
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
			<a href="<%=path %>/Animo/Bnimo/Cnimo/alladmin?pageNo=1">首页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/alladmin?pageNo=${currPage - 1}">上一页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/alladmin?pageNo=${currPage + 1}">下一页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/alladmin?pageNo=${requestScope.totalPage}">尾页</a>
    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>
