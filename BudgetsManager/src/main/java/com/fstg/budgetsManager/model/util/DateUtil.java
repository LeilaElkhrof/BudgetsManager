package com.fstg.budgetsManager.model.util;

import java.util.Calendar;
import java.util.Date;

public class DateUtil {
	
	public static int year() {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(new Date());
		return calendar.get(Calendar.YEAR);
	}

}
