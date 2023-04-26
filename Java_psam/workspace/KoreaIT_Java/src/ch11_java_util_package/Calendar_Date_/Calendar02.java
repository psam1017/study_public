package ch11_java_util_package.Calendar_Date_;

import java.util.Calendar;

public class Calendar02 {
	public static void main(String[] args) {
		
		// get() 메소드로 정보 가져오기
		// get() 메소드의 반환 티입은 int이며, 월(Month)만 index가 0부터 시작한다.
		
		Calendar calendar = Calendar.getInstance();
		
		int year = calendar.get(Calendar.YEAR);
		int month = calendar.get(Calendar.MONTH) + 1;
		int date = calendar.get(Calendar.DATE);
		
		System.out.println(year + "년 " + month + "월 " + date + "일");
		
		System.out.println(calendar.get(Calendar.DAY_OF_WEEK)); // 1 = 일, 2 = 월, ... 7 = 토
		System.out.println(getDayToStr(calendar.get(Calendar.DAY_OF_WEEK)));
		
		System.out.println(calendar.get(Calendar.DAY_OF_YEAR)); // 올해의 며칠 째인지
		System.out.println(calendar.getActualMaximum(Calendar.DATE)); // 이번 달의 마지막 날
	}
	
	public static String getDayToStr(int day) {
		String[] days = {"일", "월", "화", "수", "목", "금", "토", "일"};
		return days[day - 1];
	}
}
