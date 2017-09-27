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
<title>所有装修公司</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
<link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
<link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
<link href="<%=path %>/css/animate.min.css" rel="stylesheet">
<link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">
</head>
<body>
<body class="gray-bg">
        <div class="row">
            <div class="col-sm-12">
                <div class="ibox float-e-margins">
                    <div class="ibox-title">
                        <h5>所有装修公司</h5>
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
                                        <th>电话</th>
                                        <th>成立日期</th>
                                        <th>创建日期</th>
                                        <th>审核时间</th>
                                        <th>最近登陆</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                <c:forEach items="${requestScope.companys }" var="companys" varStatus="status">
                                    <tr>
                                        <td>${status.count }</td>
                                        <td><img class="img-circle"  style="width: 80px;height: 80px;" src="<%=path%>/${companys.logo}"></td>
                                        <td>${companys.principal }</td>
                                        <td>${companys.phone } </td>
                                        <td>${companys.open_date }</td>
                                        <td>${companys.created_time }</td>
                                        <td>${companys.checked_time }</td>
                                        <td>${companys.last_login_time }</td>
                                        <td>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/companyavailable?id=${companys.id}"><i class="fa fa-check text-navy">可用</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/companyforbidden?id=${companys.id}"><i class="fa fa-check text-navy">禁用</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/companydelete?id=${companys.id}"><i class="fa fa-check text-navy">删除</i></a>
                                            <a href="<%=path%>/Animo/Bnimo/Cnimo/companydetails?id=${companys.id}"><i class="fa fa-check text-navy">详情</i></a>
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
			<a href="<%=path %>/Animo/Bnimo/Cnimo/companys?pageNo=1">首页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/companys?pageNo=${currPage - 1}">上一页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/companys?pageNo=${currPage + 1}">下一页</a>
			<a href="<%=path %>/Animo/Bnimo/Cnimo/companys?pageNo=${requestScope.totalPage}">尾页</a>
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>

</body>
</html>