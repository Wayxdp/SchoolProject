package com.mo.common;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DataTime {
	public static String time(){
	  	Date d = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sdf.format(d);
	}
}
