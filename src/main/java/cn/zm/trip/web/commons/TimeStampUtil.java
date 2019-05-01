package cn.zm.trip.web.commons;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStampUtil {
	public static String getTimeFormat(){
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String dateTime = dateFormat.format(new Date());
		return dateTime;
	}
}
