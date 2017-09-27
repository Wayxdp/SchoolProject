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
    <title>设计师审核</title>
    <link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
    <link href="<%=path %>/css/bootstrap.min14ed.css" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body class="gray-bg">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>设计师审核</h5>
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
                                        <th>头像</th>
                                        <th>名称</th>
                                        <th>手机号</th>
                                        <th>工作经验</th>
                                        <th>设计风格</th>
                                        <th>创建时间</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.designers }" var="designers" varStatus="status">
                                    <tr>
                                        <td>${status.count}</td>
                                        <td><img class="img-circle"  style="width: 80px;height: 80px;" src="<%=path%>/${designers.headicon }"></td>
                                        <td>${designers.name }</td>
                                        <td>${designers.phone}</td>
                                       	<td>${designers.experience }</td>
                                        <td>${designers.style}</td>
                                        <td>${designers.created_time}</td>
                                        <td>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/designerdetails?id=${designers.id}"><i class="fa fa-check text-navy">详情</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/designeragree?id=${designers.id}"><i class="fa fa-check text-navy">同意</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/designerdecline?id=${designers.id}"><i class="fa fa-check text-navy">拒绝</i></a>
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
			<a href="<%=path %>/Animo/Bnimo/Cnimo/allcheckdesigner?pageNo=1">首页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/allcheckdesigner?pageNo=${currPage - 1}">上一页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/allcheckdesigner?pageNo=${currPage + 1}">下一页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/allcheckdesigner?pageNo=${requestScope.totalPage}">尾页</a>
    <script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>
