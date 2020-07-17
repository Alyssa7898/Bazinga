package com.team.zhihu.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {

	public static String dateToString(Date date, String pattern) {
		 SimpleDateFormat sdf=new SimpleDateFormat(pattern);
	        return sdf.format(date);
	}

}
