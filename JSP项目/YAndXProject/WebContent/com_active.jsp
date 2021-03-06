<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
    
    <%
    String path = request.getContextPath();
    %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">


    <title>公司列表</title>

    <link rel="shortcut icon" href="<%=path %>/favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
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
                                        <th>名称</th>
                                        <th>地址</th>
                                        <th>联系方式</th>
                                        <th>操作</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <tr>
                                        <td>装修公司1</td>
                                        <td>赣州</td>
                                        <td>110</td>
                                        <td>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看案例</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看活动</i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>装修公司2</td>
                                        <td>赣州</td>
                                        <td>111</td>
                                        <td>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看案例</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看活动</i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>装修公司3</td>
                                        <td>赣州</td>
                                        <td>112</td>
                                        <td>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看案例</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看活动</i></a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td>装修公司4</td>
                                        <td>赣州</td>
                                        <td>113</td>
                                        <td>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看详情</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看案例</i></a>
                                            <a href="<%=path %>/companys.jsp#"><i class="fa fa-check text-navy">查看活动</i></a>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
                        </div>

                    </div>
                </div>
            </div>

        </div>

        <nav style="text-align: center">
			<ul class="pagination">
				<li><a href="#">«</a></li>
				<li><a href="#">1</a></li>
				<li><a href="#">2</a></li>
				<li><a href="#">3</a></li>
				<li><a href="#">4</a></li>
				<li><a href="#">5</a></li>
				<li><a href="#">6</a></li>
				<li><a href="#">»</a></li>
			</ul>
		</nav>
    </div>
    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>
