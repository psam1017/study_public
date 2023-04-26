package ch11_java_util_package.Calendar_Date_;

import java.util.Calendar;

public class Calendar03 {
	public static void main(String[] args) {
		
		// set() 메소드로 날짜 저장하기
		// 2개의 인수가 필요하며, 첫 번째는 대상, 두 번째는 바꿀 값이다.
		// set(연도, 월, 일) 메소드도 있다.
		
		Calendar today = Calendar.getInstance();
		Calendar endOfYear = Calendar.getInstance();
		Calendar christmas = Calendar.getInstance();
		
		endOfYear.set(Calendar.MONTH, 11); // 11 = 12월.
		endOfYear.set(Calendar.DATE, 31);
		long diff = endOfYear.getTimeInMillis() - today.getTimeInMillis();
		System.out.println("연말까지 남은 날 : " + diff / (24 * 60 * 60 * 1000) + "일");
		
		christmas.set(2022, 11, 25);
		diff = christmas.getTimeInMillis() - today.getTimeInMillis();
		System.out.println("크리스마스까지 남은 날 : " + diff / 24 / 60 / 60 / 1000 + "일");
		
		Calendar valentine = Calendar.getInstance();
		valentine.set(2023, 1, 14);
		diff = valentine.getTimeInMillis() - today.getTimeInMillis();
		System.out.println("발렌타인 데이까지 남은 날 : " + diff / (24 * 60 * 60 * 1000) + "일");
	}
}
