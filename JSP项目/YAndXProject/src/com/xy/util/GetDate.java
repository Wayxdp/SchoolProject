package com.xy.util;

import java.util.Calendar;
import java.util.Date;

public class GetDate {
	
	public static java.sql.Date getTime(){
		 Calendar ca = Calendar.getInstance();
		 Date time = ca.getTime();
		 //SimpleDateFormat formatter; 
//		 formatter = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss"); 
//		 String timeStr = formatter.format(time);
//		 return timeStr;
		 return  convert(time);
	}
	
	public static java.sql.Date convert(java.util.Date date) {
		return new java.sql.Date(date.getTime()); 
	}
}
