package com.fstg.budgetsManager.model.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static int year() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}
	
	public static final int getMounthsDifference(Date date1, Date date2 ) {
		@SuppressWarnings("deprecation")
		int m1 = date1.getYear()* 12 + date1.getMonth();
		@SuppressWarnings("deprecation")
		int m2 = date2.getYear()* 12 + date2.getMonth();
		
		return  m1-m2+1;
	}
}
