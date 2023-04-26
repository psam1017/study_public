package ch11_java_util_package.Calendar_Date_;

import java.util.Calendar;

public class CalendarTest01 {
	public static void main(String[] args) {
		
		Calendar now = Calendar.getInstance();
		
		int year = 0, month = 0, day = 0, hour = 0, minute = 0, second = 0;
		String strWeek = null, strAmPm = null;
		
		int amPm = now.get(Calendar.AM_PM);
		if(amPm == Calendar.AM) {
			strAmPm = "오전";
		}
		else {
			strAmPm = "오후";
		}
		
		year = now.get(Calendar.YEAR);
		month = now.get(Calendar.MONTH) + 1;
		day = now.get(Calendar.DATE);
		hour = now.get(Calendar.HOUR);
		minute = now.get(Calendar.MINUTE);
		second = now.get(Calendar.SECOND);
		strWeek = getDayToStr(now.get(Calendar.DAY_OF_WEEK));
		
		System.out.print(year + "년 ");
		System.out.print(month + "월 ");
		System.out.print(day + "일 ");
		System.out.print(strWeek + "요일 ");
		System.out.print(strAmPm + " ");
		System.out.print(hour + "시 ");
		System.out.print(minute + "분 ");
		System.out.print(second + "초");
	}
	
	public static String getDayToStr(int day) {
		String[] days = {"일", "월", "화", "수", "목", "금", "토", "일"};
		return days[day - 1];
	}
}
