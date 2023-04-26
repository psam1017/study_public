package ch11_java_util_package.Calendar_Date_;

import java.time.LocalDateTime;

public class Time_LocalDate02 {
	public static void main(String[] args) {
		
		// LocalDateTime 패키지 사용.
		
		// isAfter() : 이전 날짜인지 비교
		// isBefore() : 이후 날짜인지 비교
		// isEqual() : 동일한 날짜인지 비교
		// until() : 날짜나 시간의 차이를 반환
		// between() : 전체 날짜나 시간의 차이를 반환
		
		LocalDateTime ldt1 = LocalDateTime.of(2010, 1, 1, 12, 23, 23, 444); // 연도부터 초의 소수점까지
		System.out.println(ldt1);
		LocalDateTime ldt2 = LocalDateTime.of(2010, 12, 25, 1, 12, 2, 232);
		System.out.println(ldt2);
		
		System.out.println(ldt1.isAfter(ldt2));
		System.out.println(ldt1.isBefore(ldt2));
		System.out.println(ldt1.isEqual(ldt2));
	}
}
