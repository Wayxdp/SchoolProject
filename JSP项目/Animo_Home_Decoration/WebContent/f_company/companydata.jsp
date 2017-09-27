<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
%>
<html>
<head>
<meta charset="UTF-8" />
<title>装修公司资料</title>
<link rel="icon" href="<%=path %>/images/inco.png" type="image/x-icon"/>
<link rel="stylesheet" type="text/css" href="<%=path%>/css/public.css">
<link rel="stylesheet" type="text/css" href="<%=path%>/css/style.css">
</head>
<body>
	<div class="usercenter">
		<div class="content">
			<div class="user-info bg-white clearfix">
				<div class="page-title">
					<span class="tit">装修公司资料</span>
				</div>
				<form enctype="multipart/form-data" method="post" id="form"
					action="<%=path %>/company/updatedatasucceed" class="form-horizontal">
					<input type="hidden" value="user" name="action">
					<div class="edit-head clearfix">
						<span class="pic"><img id="ImgPr" 
							src="<%=path %>/${sessionScope.company1.logo }" width="80" height="80"
							class="coverPic"></span>
						<div class="modify">
							修改公司LOGO<input type="file" name="logo"
								accept="image/*" id="up">
						</div>
					</div>
					<div class="info-list mt20">
							<input type="hidden" id="cover" name="cover" value="">
							<ul>
								<li><label>邮箱</label> <input style="border: none;" readonly="readonly" type="text" class="txt"
									id="email" name="email"  value=${sessionScope.company1.email }> <span
									class="error text-red"></span></li>
								<li><label>公司名称</label> <input type="text" class="txt"
									id="name" name="name"  value=${sessionScope.company1.company_name }> <span
									class="error text-red"></span></li>
								<li><label>负责人</label> <input type="text" class="txt"
									id="principal" name="principal"  value=${sessionScope.company1.principal }>
									<span class="error text-red"></span></li>

								<li><label>地址</label> <input type="text" id="address"
									name="address" class="txt"  value=${sessionScope.company1.address }> <span
									class="error text-red"></span></li>
								<li><label>手机号</label> <input type="text" id="phone"
									name="phone" class="txt"  value=${sessionScope.company1.phone }> <span
									class="error text-red"></span></li>
								<li><label>固定电话</label> <input type="text" id="tel"
									name="tel" class="txt"  value=${sessionScope.company1.tel }> <span
									class="error text-red"></span></li>
								<li><label>成立日期</label> <input type="text" id="open_date" style="border: none;" readonly="readonly"
									name="open_date" class="txt"  value=${sessionScope.company1.open_date }> <span
									class="error text-red"></span></li>
								<li><label>经度</label> <input type="text" id="longitude"
									name="longitude" class="txt"  value=${sessionScope.company1.longitude }> <span
									class="error text-red"></span></li>
										<li><label>纬度</label> <input type="text" id="latitude"
									name="latitude" class="txt"  value=${sessionScope.company1.latitude }> <span
									class="error text-red"></span></li>
								<li><label>描述</label> <input type="text" id="des"
									name="des" class="txt"  value=${sessionScope.company1.des }> <span
									class="error text-red"></span></li>
								<li><label>最近登录时间</label> <input style="border: none;" readonly="readonly"
									type="text" id="last_login_time" name="last_login_time" class="txt" 
									value=${sessionScope.company1.last_login_time }> <span class="error text-red"></span></li>
							</ul>
							<input type="submit" id="form" value="保存" class="btn-red">
						</form>
					</div>
			</div>
		</div>
	</div>
<script src="<%=path %>/js/jquery-3.2.0.min.js"></script>
	<script>
jQuery.fn.extend({
    uploadPreview: function(opts) {
        var _self = this,
            _this = $(this);
        opts = jQuery.extend({
            Img: "ImgPr",
            Width: 100,
            Height: 100,
            ImgType: ["gif", "jpeg", "jpg", "bmp", "png"],
            Callback: function() {}
        }, opts || {});
        _self.getObjectURL = function(file) {
            var url = null;
            if (window.createObjectURL != undefined) {
                url = window.createObjectURL(file)
            } else if (window.URL != undefined) {
                url = window.URL.createObjectURL(file)
            } else if (window.webkitURL != undefined) {
                url = window.webkitURL.createObjectURL(file)
            }
            return url
        };
        _this.change(function() {
            if (this.value) {
                if (!RegExp("\.(" + opts.ImgType.join("|") + ")$", "i").test(this.value.toLowerCase())) {
                    alert("选择文件错误,图片类型必须是" + opts.ImgType.join("，") + "中的一种");
                    this.value = "";
                    return false
                }
                //高版本Jquey使用  if ($.support.leadingWhitespace)
                if ($.support.leadingWhitespace) { //低版本jquery中使用$.browser.msie
                    try {
                        $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                    } catch (e) {
                        var src = "";
                        var obj = $("#" + opts.Img);
                        var div = obj.parent("div")[0];
                        _self.select();
                        if (top != self) {
                            window.parent.document.body.focus()
                        } else {
                            _self.blur()
                        }
                        src = document.selection.createRange().text;
                        document.selection.empty();
                        obj.hide();
                        obj.parent("div").css({
                            'filter': 'progid:DXImageTransform.Microsoft.AlphaImageLoader(sizingMethod=scale)',
                            'width': opts.Width + 'px',
                            'height': opts.Height + 'px'
                        });
                        div.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = src
                    }
                } else {
                    $("#" + opts.Img).attr('src', _self.getObjectURL(this.files[0]))
                }
                opts.Callback()
            }
        })
    }
});
$("#up").uploadPreview({
    Img: "ImgPr"
});</script>
</body>
</html>