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


    <title>密码修改</title>

    <link rel="shortcut icon" href="favicon.ico"> <link href="<%=path %>/css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=path %>/css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=path %>/css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=path %>/css/animate.min.css" rel="stylesheet">
    <link href="<%=path %>/css/style.min862f.css?v=4.1.0" rel="stylesheet">

</head>

<body>
    
   <form action="<%=path%>/com/pwd_submit" method="post">
   		 <table>
	    	<tr>
	    		<td>请输入原始密码：</td>
	    		<td><input type="password" id="old_pwd" name="old_pwd" placeholder="请输入原始密码" /></td>
	    		<td><span id="old_pwdCuo">${requestScope.old_pwdCuo }</span></td>
	    		<td><span id="old_pwdNull">${requestScope.old_pwdNull }</span></td>
	    	</tr>
	    	<tr>
	    	<!-- 确认密码 -->
	    		<td>请输入修改密码：</td>
	    		<td><input type="password" id="new_pwd" name="new_pwd" placeholder="请输入新密码" /></td>
	    		<td><span id="new_pwdNull">${requestScope.new_pwdNull }</span></td>
	    	</tr>
	    	<tr>
	    	<!-- 确认密码 -->
	    		<td>请输入确认密码：</td>
	    		<td><input type="password" id="sure_pwd" name="sure_pwd" placeholder="请再次输入确认密码" /></td>
	    		<td><span id="oldAndNewCuo">${requestScope.oldAndNewCuo }</span></td>
	    		<td><span id="sure_pwdNull">${requestScope.sure_pwdNull }</span></td>
	    	
	    	</tr>
	    	<tr>
	    		<td><button type="submit">确认</button></td>
	    	</tr>
    </table>
   </form>

    <script src="<%=path %>/js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=path %>/js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=path %>/js/plugins/peity/jquery.peity.min.js"></script>
    <script src="<%=path %>/js/content.min.js?v=1.0.0"></script>
    <script src="<%=path %>/js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=path %>/js/demo/peity-demo.min.js"></script>
</body>
</html>
