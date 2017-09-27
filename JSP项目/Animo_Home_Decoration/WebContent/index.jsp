<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
	String path1 = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"  />
<title>康泰家装</title>
<link rel="icon" href="<%=path1 %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" href="<%=path1%>/css/public.css">
<link rel="stylesheet" href="<%=path1%>/css/style.css">
<link rel="stylesheet" href="<%=path1%>/css/oms.css">
<style type="text/css">
.dropdown:hover {
	background-color: gray;
}
.
AAhead {
	width: 150px;
	height: 55px;
}
</style>
<link href="<%=path1%>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path1%>/css/main.css" rel="stylesheet">
</head>
<body>
	<%
		response.sendRedirect("home");
	%>
	<script src="<%=path1%>/js/oms.js"></script>
	<script src="<%=path1%>/js/change_view.js"></script>
	<script src="<%=path1%>/js/ja.js"></script>
	<script src="<%=path1%>/js/jquery-3.2.0.min.js"></script>
	<script src="<%=path1%>/js/bootstrap.min.js"></script>
	<script src="<%=path1%>/js/jquery-1.11.1.min.js"></script>
	<script src="<%=path1%>/js/main.js"></script>
	<script src="<%=path1%>/js/jquery.min.js"></script>
</body>
</html>