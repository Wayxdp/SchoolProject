<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String path = request.getContextPath(); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>上传案例</title>
 <link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet">
<link href="<%=path %>/css/jquery-3.2.0.min.js" rel="stylesheet">
<style>
* {
	margin:0;
	padding:0;
}
.fileImg {
	padding:20px;
	background:#ececec;
	overflow:hidden;
	width:800px;
	margin:20px auto;
}
.fileImg ul li {
	position:relative;
	border:1px solid #c5c5c5;
	width:50px;
	height:50px;
	float:left;
	margin-right:50px;
	list-style-type:none;
	background:#f4f5f7;
	border-radius:5px;
}
.fileImg ul li input {
	position:absolute;
	z-index:3;
	top:0;
	left:0;
	width:100%;
	height:100%;
	opacity:0;
	-webkit-tap-highlight-color:rgba(0,0,0,0);
}
.fileImg ul li:after {
	position:absolute;
	content:' ';
	display:block;
	width:2px;
	height:30px;
	background:#cdcdcd;
	left:50%;
	margin-left:-1px;
	top:50%;
	margin-top:-15px;
	z-index:2;
}
.fileImg ul li:before {
	position:absolute;
	content:' ';
	display:block;
	top:50%;
	margin-top:-1px;
	z-index:2;
	width:30px;
	height:2px;
	background:#cdcdcd;
	left:50%;
	margin-left:-15px;
}
.fileImg ul li span:nth-child(2) {
	display:none;
	width:50px;
	height:50px;
	position:absolute;
	left:0;
	top:0;
	background:#f4f5f7;
	cursor:pointer;
	border-radius:5px;
	overflow:hidden;
	z-index:3;
}
.fileImg ul li span:nth-child(2):after {
	content:'x';
	display:block;
	z-index:4;
	width:20px;
	height:20px;
	line-height:16px;
	color:#fff;
	background:red;
	border-radius:50%;
	position:absolute;
	left:50%;
	top:50%;
	margin-left:-10px;
	margin-top:-10px;
	text-align:center;
}
.fileImg ul li span:nth-child(2) img {
	width:100%;
	position:absolute;
	left:0;
	top:50%;
}
</style>
</head>
<body>
	<form enctype="multipart/form-data" action="<%=path %>/company/Add_the_ase" method="post" class="col-md-6 col-md-offset-3 col-lg-4 col-lg-offset-4" style="padding-top: 60px;">
		<input type="hidden" name="company_id" value="" />
		<div class="form-group">
		  <input type="text" class="form-control" id="name" name="name" placeholder="请输入案例名称">
		<span id="nameerror"></span>
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" id="plot_name" name="plot_name" placeholder="请输入小区名称">
		  <span id="plot_nameerror"></span>
		</div>
		<div class="form-group">
		  <input type="text" class="form-control" id="style1" name="style1" placeholder="装修风格">
		  <span id="style1error"></span>
		</div>	
		<div class="form-group">
		  <input type="text" class="form-control" id="des" name="des" placeholder="请描述该案例">
		   <span id="deserror"></span>
		</div>
		
		<div class="fileImg" id="fileImg" style="background-color: white;">
    <ul>
        <li>
            <input style="width: 100px;height: 100px;" type="file" name="photo1" class="upfile" id="adfadfadsf">
            <span></span>
        </li>
        <li>
            <input type="file" class="upfile" id="photo2" name="photo2">
            <span></span>
        </li>
        <li>
            <input type="file" class="upfile"  id="photo3" name="photo3">
            <span></span>
        </li>
        <li>
            <input type="file" class="upfile"  id="photo4" name="photo4">
            <span></span>
        </li>
        <li>
            <input type="file" class="upfile"  id="photo5" name="photo5">
            <span></span>
        </li>
    </ul>
</div>
		<button class="btn btn-primary" type="submit" onclick="return yanzhen();">提交</button>
		<span id="ok"></span>
	</form>
	<script src="<%=path %>/js/jquery.min.js"></script>
    <script src="<%=path %>/js/bootstrap.min.js"></script>
    <script>
var obj = document.getElementById('fileImg');
var ALi = obj.getElementsByTagName('li');
addFn();

function addFn() {
    for (var i = 0; i < ALi.length; i++) {
        ALi[i].getElementsByTagName('input')[0].index = i;
        ALi[i].getElementsByTagName('span')[0].index = i;
        // 文件域改变后执行
        ALi[i].getElementsByTagName('input')[0].onchange = function() {
            ALi[this.index].getElementsByTagName('span')[0].style.display = 'block'; //删除按钮显示
            var oImg = document.createElement('img'); // 创建img元素
            ALi[this.index].getElementsByTagName('span')[0].appendChild(oImg);
            oImg.src = getFileUrl(this); //地址增加

            setTimeout(function() { //图片高度居中
                oImg.style.marginTop = -oImg.offsetHeight / 2 + 'px';
            }, 100);
        };
        // 删除按钮事件
        ALi[i].getElementsByTagName('span')[0].onclick = function() {
            ALi[this.index].innerHTML = '<input type="file" class="upfile" ><span></span>';
            addFn();
        };
    };
};
// 创建本地地址
function getFileUrl(sourceId) {
    var url;
    if (navigator.userAgent.indexOf("MSIE") >= 1) { // IE 
        url = sourceId.value;
    } else if (navigator.userAgent.indexOf("Firefox") > 0) { // Firefox 
        url = window.URL.createObjectURL(sourceId.files.item(0));
    } else if (navigator.userAgent.indexOf("Chrome") > 0) { // Chrome 
        url = window.URL.createObjectURL(sourceId.files.item(0));
    }
    return url;
};</script>
</body>
</html>