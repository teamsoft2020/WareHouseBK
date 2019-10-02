package com.tem.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UTCDateTime {

	public static String getCurentTimeAndDate() {
		Date todaysDate = new Date();
		
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String datestr = df.format(todaysDate);
		return datestr;
	}
	
}
