package com.mo.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	
	public static final String DEFAULT_PATTERN = "yyyy-MM-dd HH:mm:ss";
	
	/**
	 * 把java.util.Date类型的对象转成java.sql.Date类型的对象
	 * 
	 * @param date
	 * @return
	 */
	public static java.sql.Date convert(java.util.Date date) {
		return new java.sql.Date(date.getTime());
	}
	
	public static java.sql.Timestamp convert2(java.util.Date date) {
		return new java.sql.Timestamp(date.getTime());
	}

	public static Date parseDate(String dateStr, String pattern) {
		SimpleDateFormat df = new SimpleDateFormat(pattern);
		try {
			return df.parse(dateStr); 
		} catch (ParseException e) {
			e.printStackTrace();
		} 
		return null;
	}
	
}
