package ch11_java_util_package.Calendar_Date_;

import java.util.Calendar;
import java.util.Date;

public class Date02 {
	public static void main(String[] args) {
		
		// Date와 Calendar를 서로 변환시키기
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		
		System.out.println(date);
		
		// Date -> Calendar
		calendar.setTime(date);
		
		// Calendar -> Date
		long time = calendar.getTimeInMillis();
		System.out.println(time);
		
		// long -> Calendar
		calendar.setTimeInMillis(time);
	}
}
