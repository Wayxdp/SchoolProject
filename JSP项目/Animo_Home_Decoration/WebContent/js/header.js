$().ready(function(){
	var arr = getusercookieValue();
    var url=window.location.href;  
    var uid= arr[0];

    if(uid > 0){
        $("#js-head").html('<a href = "/home" class="text-red" target="_blank">欢迎您，'+arr[1]+'</a> | <a href="http://www.dyrs.com.cn/user/loginout.php?backurl='+url+'"  target = "_self"> 退出 </a>');
	}else{
		$("#js-head").html('<a href="/user/register" class="text-red">注册送1000元家装抵用券！</a> <a href="http://www.dyrs.com.cn/user/login_sns.php?source=weibo&backurl='+url+'" class="sion" target="_blank">微博登录</a> <a href="http://www.dyrs.com.cn/user/login_sns.php?source=qq&backurl='+url+'" class="qq" target="_blank">QQ登录</a> <a href="http://www.dyrs.com.cn/user/login_sns.php?source=weixin&backurl='+url+'" class="weixin" target="_blank">微信登录</a> <a href="http://www.dyrs.com.cn/user/register?backurl='+url+'">注册</a> <span class="line">|</span> <a href="http://www.dyrs.com.cn/user/login?backurl='+url+'">登录</a>');
	}
});

	function getusercookieValue(){
		var cookieValue = readck('dyrs_userinfo');
		var cookie_s = base64decode_user(cookieValue);
		var arr = cookie_s.split("\t");
	    return arr;
	}
	function base64decode_user(data) {
	    var b64 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
	    var o1, o2, o3, h1, h2, h3, h4, bits, i = 0, ac = 0, dec = "", tmp_arr = [];
	    if (!data) {
		return data;
	    }
	    data += '';
	     while (i < data.length){ 
		h1 = b64.indexOf(data.charAt(i++));
		h2 = b64.indexOf(data.charAt(i++));
		h3 = b64.indexOf(data.charAt(i++));
		h4 = b64.indexOf(data.charAt(i++));
		bits = h1<<18 | h2<<12 | h3<<6 | h4;
		o1 = bits>>16 & 0xff;
		o2 = bits>>8 & 0xff;
		o3 = bits & 0xff;
		if (h3 == 64) {
		    tmp_arr[ac++] = String.fromCharCode(o1);
		} else if (h4 == 64) {
		    tmp_arr[ac++] = String.fromCharCode(o1, o2);
		} else {
		    tmp_arr[ac++] = String.fromCharCode(o1, o2, o3);
		}
	    }

	   dec = tmp_arr.join('');
	   dec = utf8_decode(dec);
	   return dec;
	}
	function utf8_decode(str_data){
		var tmp_arr = [], i = 0, ac = 0, c1 = 0, c2 = 0, c3 = 0;
		str_data += '';
		while ( i < str_data.length ) {
			c1 = str_data.charCodeAt(i);
			if (c1 < 128) {
				tmp_arr[ac++] = String.fromCharCode(c1);
				i++;
			} else if ((c1 > 191) && (c1 < 224)) {
				c2 = str_data.charCodeAt(i+1);
				tmp_arr[ac++] = String.fromCharCode(((c1 & 31) << 6) | (c2 & 63));
				i += 2;
			} else {
				c2 = str_data.charCodeAt(i+1);
				c3 = str_data.charCodeAt(i+2);
				tmp_arr[ac++] = String.fromCharCode(((c1 & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
				i += 3;
			}
		}
		return tmp_arr.join('');
	}
	function readck(name){
		var cookieValue = "";
		var search_s = name + "=";
		if(document.cookie.length > 0)
		{ 
			offset = document.cookie.indexOf(search_s);
			if (offset != -1)
			{ 
				offset += search_s.length;
				end = document.cookie.indexOf(";", offset);
				if (end == -1) end = document.cookie.length;
				cookieValue = unescape(document.cookie.substring(offset, end))
			}
		}
		return cookieValue;
	}
    function clear_button(){
		document.getElementById("search_input").value = "";
	}
    function search_content(){
        var content = document.getElementById("search_input").value;
        window.location.href="/api/search.php?q="+content;
    }
    function enterevent(){
       var event=arguments.callee.caller.arguments[0]||window.event;//消除浏览器差异  
       if (event.keyCode == 13){
             var content = document.getElementById("search_input").value;
             window.location.href="/api/search.php?q="+content;
       }  
    }

   function clear_notice(){
	   $("#weijihuo").hide();
   }

	var jj_location_p_id = '';
	var jj_location_province = '';
	var jj_location_c_id = '';
	var jj_location_city = '';

	//获取当前用户所在地域信息
	function user_location(){  
	
		jj_location_p_id = readck("jj_location_p_id");
		jj_location_province = readck("jj_location_province");
		jj_location_c_id = readck("jj_location_c_id");
		jj_location_city = readck("jj_location_city");
	 
		//如果没有捕获地域信息，调用php程序获取
		if((jj_location_p_id < 1) || (jj_location_province == "" )){ 
			var local_src = "/api/common/location.php";
			document.write('<img border=0 width=1 height=1 src="'+local_src+'">'); 
		}  
	}

//保存本地地域信息
user_location();
