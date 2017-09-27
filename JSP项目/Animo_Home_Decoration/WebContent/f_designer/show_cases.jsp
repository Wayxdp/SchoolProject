<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>所有案例</title>
    <link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
    <link href="<%=path %>/css/bootstrap.min14ed.css" rel="stylesheet">
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
                        <h5>所有案例</h5>
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
                                        <th>案例名称</th>
                                        <th>小区名称</th>
                                        <th>装修风格</th>
                                        <th>创建时间</th>
                                        <th>状态</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.designercases }" var="designercases" varStatus="status">
                                    <tr>
                                      	<td>${status.count }</td>
                                      	<td>${designercases.casename }</td>
                                      	<td>${designercases.plot_name }</td>
                                      	<td>${designercases.style }</td>
                                      	<td>${designercases.created_time }</td>
                                      	<td>
                                      		<c:if test="${designercases.status == 'Y'}">
                                     				可见
                                      		</c:if>
                                      		<c:if test="${designercases.status == 'N'}">
                                     				冻结
                                      		</c:if>
                                      	</td>
                                        <td>
                                            <a href="<%=path%>/designer/designerdetails?id=${designercases.caseid}"><i class="fa fa-check text-navy">详情</i></a>
                                            <a href="<%=path%>/designer/designerrevamp?id=${designercases.caseid}"><i class="fa fa-check text-navy">修改</i></a>
                                            <a href="<%=path%>/designer/designerforbidden?id=${designercases.caseid}"><i class="fa fa-check text-navy">禁用</i></a>
                                            <a href="<%=path%>/designer/designeravailable?id=${designercases.caseid}"><i class="fa fa-check text-navy">可用</i></a>
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
