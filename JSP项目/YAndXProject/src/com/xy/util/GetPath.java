package com.xy.util;

import javax.servlet.http.HttpServletRequest;

public class GetPath {
	
	public static String getPath(HttpServletRequest req){
		String path = req.getRequestURI();
		return path.substring(path.lastIndexOf("/")+1);
	}
}
