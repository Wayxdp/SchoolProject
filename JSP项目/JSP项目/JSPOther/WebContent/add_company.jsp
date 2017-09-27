<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String path = request.getContextPath();
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
<title>Insert title here</title>
</head>
<body>
	<!-- enctype="form-data/multipart" form表单可以支持文件上传 -->
	<form action="<%=path %>/company/add" method="post" enctype="multipart/form-data">
		<input type="text" name="name" /> 
		<input type="text" name="address" />
		<input type="file" name="file" /> 
		<input type="file" name="file1" />
		<input type="submit" />
	</form>
</body>
</html>