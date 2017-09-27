/*
 * 匹配设备跳转URL
 */
(function(){
	//获取cookie
	function getCookie(c_name) {
		if (document.cookie.length > 0) {
			c_start = document.cookie.indexOf(c_name + "=")
			if (c_start != -1) {
				c_start = c_start + c_name.length + 1
				c_end = document.cookie.indexOf(";", c_start)
				if (c_end == -1) c_end = document.cookie.length
				return unescape(document.cookie.substring(c_start, c_end))
			}
		}
		return ""
	}
	if(getCookie('dyrs_dev_flag')){return}
	//	
	var _host=location.host;
	var url=location.href;
	//正则
	var reg={
		reg_index:/dyrs\.com\.cn\/?$/,
		reg_case:/case\/(si|ht|s|ha)+\d+\/?$/,
		reg_case2:/case\/?$/,
		reg_case3:/case\/\d+\/?$/,
		reg_store1:/store\/?$/,
		reg_store2:/store\/si\d+\/?$/,
		reg_store3:/store\/\d+\/?$/,
		reg_find_designer1:/designer\/?$/,
		reg_find_designer2:/designer\/(ht|s|si)\d+\/?$/,
		reg_find_designer3:/designer\/\d+\/(case|house_analysis|about)\/?$/,
		reg_construction1:/construction\/?$/,
		reg_construction2:/construction\/(c|sta)\d+\/?$/,
		reg_construction3:/construction\/\d+\/?$/,
		reg_photo1:/photo\/?$/,
		reg_photo2:/photo\/(s|sp)\d+\/?$/,
		reg_user1:/user\/register\/?$/,
		reg_user2:/user\/login\/?$/,
		reg_story:/story\/\d+\/\d+\/?$/,
		reg_other:/www\.(ycgj|dyrsbj|dyrsbs)\.(cc|com)\/?$/
	}
	//处理url
	function getUrl(){
		var str='';
		if(url.indexOf('www')>=0){ //如果有www
			str=url.replace(/^(http:\/\/)?(www)(\.dyrs\.com\.cn)(.+)$/gi,'$1m$3$4');
		}else{//如果没有www 有可能是分站有可能就是省略了www
			if(_host.split('.').length===4){//如果是分站
				str=url.replace(/^(http:\/\/)?(.+)(\.dyrs\.com\.cn)(.+)$/gi,'$1m.$2$3$4');
			}else if(location.host.split('.').length===3){//如果是主站
				str=url.replace(/^(http:\/\/)?(dyrs\.com\.cn)(.+)$/gi,'$1m.$2$3');
			}
		}
		return str;
	}
	//设备检测
	function IsPC() {
		var userAgentInfo = navigator.userAgent;
		var Agents = ["Android", "iPhone",
			"SymbianOS", "Windows Phone",
			"iPad",
			"iPod"
		];
		var flag = true;
		for (var v = 0; v < Agents.length; v++) {
			if (userAgentInfo.indexOf(Agents[v]) > 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
	//跳转
	function goto(t){
		window.location.href=t
	}
	//匹配
	if(!IsPC()){
		//首页
		if(reg.reg_index.test(url)){
			goto(getUrl());
		}
		//案例页面
		if(reg.reg_case.test(url)){
			goto(getUrl());
		}
		if(reg.reg_case2.test(url)){
			goto(getUrl());
		}
		if(reg.reg_case3.test(url)){
			goto(getUrl());
		}
		//门店
		if(reg.reg_store2.test(url)||reg.reg_store3.test(url)){
			goto(getUrl());
		}
		if(reg.reg_store1.test(url)){//特殊处理
			goto(getUrl()+'/nearby');
		}
		//找设计师
	    if(reg.reg_find_designer1.test(url)||reg.reg_find_designer2.test(url)||reg.reg_find_designer3.test(url)){
			goto(getUrl());
		}
		//在施工地
		if(reg.reg_construction1.test(url)){//特殊处理
			goto(getUrl()+'/nearby');
		}
		if(reg.reg_construction2.test(url)||reg.reg_construction3.test(url)){
			goto(getUrl());
		}
		//装修图库 
	    if(reg.reg_photo1.test(url)||reg.reg_photo2.test(url)){
			goto(getUrl());
		}
		//用户中心
		if(reg.reg_user1.test(url)||reg.reg_user2.test(url)){
			goto(getUrl());
		}
		//家装指南详情页
		if(reg.reg_story.test(url)||reg.reg_story.test(url)){
			goto(getUrl());
		}
		
		//特殊域名 处理
		if(reg.reg_other.test(url)){
			window.location.href=url.replace('www','m');
		}
	}
})();
