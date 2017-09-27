 // JavaScript Document
 function createXHR() {
	if (typeof XMLHttpRequest != 'undefined') {
		return new XMLHttpRequest();
	} else if (typeof ActiveXObject != 'undefined') {
		var version = [
									'MSXML2.XMLHttp.6.0',
									'MSXML2.XMLHttp.3.0',
									'MSXML2.XMLHttp'
		];
		for (var i = 0; version.length; i ++) {
		  try {
			return new ActiveXObject(version[i]);
		  } catch (e) {
		  }	
		}
	} else {
	  throw new Error('您的系统或浏览器不支持XHR对象！');
	}
 }
 function paramsjoin(data) {
	var arr = [];
	for (var i in data) {
	  arr.push(encodeURIComponent(i) + '=' + encodeURIComponent(data[i]));
	}
	return arr.join('&');
 }
 function ajax(obj) {
	var xhr = createXHR();
	obj.url = obj.url + '/rand/' + Math.random();
	obj.data = paramsjoin(obj.data);
	if (obj.method === 'get') obj.url += obj.url.indexOf('?') == -1 ? '/' + obj.data : '/' + obj.data;
	if (obj.async === true) {
	  xhr.onreadystatechange = function () {
		  if (xhr.readyState == 4) {
			 callback();
		  }
	  };
	}
	xhr.open(obj.method, obj.url, obj.async);
	if (obj.method === 'post') {
	  xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	  xhr.send(obj.data);	
	} else {
	  xhr.send(null);
	}
	if (obj.async === false) {
	  callback();
	}
	function callback() {
	  if (xhr.status == 200) {
		obj.success(xhr.responseText);
	  } else {
	    alert('获取数据错误！错误代号：' + xhr.status + '，错误信息：' + xhr.statusText,'error');
	  }	
	}
 }
 //创建遮罩层
 function cmask(){
   var w = $(document).width();
   var h = $(document).height();
   $("body").append('<div style="width:'+w+'px;height:'+h+'px" class="cscreen" id="vmask"></div>');
 }
 //隐藏遮罩层
 function hide(){
   $("#vmask").hide().remove();
 }
 //滚动及左右切换
 function switch_div(wraper,prev,next,img,speed,or){	
	var wraper = $(wraper);
	var prev   = $(prev);
	var next   = $(next);
	var img    = $(img).find('ul');
	var w      = img.find('li').outerWidth(true);
	var s      = speed;
	next.click(function(){
						 img.animate({'margin-left':-w},function(){
						  	img.find('li').eq(0).appendTo(img);
							img.css({'margin-left':0});
						 });
						});
	prev.click(function(){
						  img.find('li:last').prependTo(img);
						  img.css({'margin-left':-w});
						  img.animate({'margin-left':0});
						});
	if (or == true){
	  ad = setInterval(function() { next.click();},s*1000);
	  wraper.hover(function(){clearInterval(ad);},function(){ad = setInterval(function() { next.click();},s*1000);});
	}
 }
 $(document).ready(function(e) {
	$('.top_div .wpic').hover(function(){
		$('.top_div .wcode').slideDown();
	},function(){
		$('.top_div .wcode').slideUp();
	})
	$('.free_fix').hide();
	$('.sex_m').addClass('check');
	$('.package_div .list_div:eq(1)').css('float','right');//装修套餐	
	$('.step_div .step:eq(0)').css('margin-left','0px');//装修流程	
	$('.assort_div .list:last').css('border-bottom','none');//经典案例	
	$('.renderdiv .ctag a:eq(0)').css('border-left','1px solid #ddd');//经典案例	
	$('.renderdiv .ctag a:even').css('background','#f7f7f7');
	$('.renderdiv .ctag a:even').hover(function(){
		$(this).css('background','#1c62aa');
	},function(){
		$(this).css('background','#f7f7f7');
	})
	//mobile
	$('.m_news .first:last').css('border-bottom','none');
 //右侧悬浮框	
 $(".nt-fixtel").hover(function(e) {
   $(".nt-fixhide").show().stop().animate({"left":"-270px"},500,function(e){
     $(".nt-fixhidetel").show().stop().animate({'opacity':1,'filter':'alpha(opacity=100)',"top":0},200,function(e){
	 });
   });
 },function(e){
   $(".nt-fixhidetel").stop().animate({'opacity':0,'filter':'alpha(opacity=0)',"top":"-52px"},200,function(e){
	 $(".nt-fixhidetel").hide();
	 $(".nt-fixhide").stop().animate({"left":"270px"},500,function(e){
	   $(".nt-fixhide").hide();
	 });
   });
 });
 //
 $(".nt-fixweixin").hover(function(e) {
   $(".nt-fixweixinhide").fadeIn(600);
 },function(e){
   $(".nt-fixweixinhide").fadeOut(300);
 });
 //
 $(".nt-weixin").hover(function(e) {
   $(".nt-hideweixin").fadeIn(600);
 },function(e){
   $(".nt-hideweixin").fadeOut(300);
 });
 //
 $(".nt-phone").hover(function(e) {
   $(".nt-phonehide,.nt-a-b").show();
 },function(e){
   $(".nt-phonehide,.nt-a-b").hide();
 });
 
 $(".nt-fixtop").click(function(e) {
   $('html,php,body').animate({scrollTop: 0,}, 400);   
 });
	
 });
 