package com.mo.common;

import javax.servlet.http.HttpServletRequest;

public class WebUtil {
	
	public static String getUriMethod(HttpServletRequest request) {
		String uri = request.getRequestURI();//获取到请求的url
		return uri.substring(uri.lastIndexOf("/") + 1);//拼接字符串后面的url
	}

}
