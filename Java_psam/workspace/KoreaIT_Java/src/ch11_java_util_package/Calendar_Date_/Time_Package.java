package ch11_java_util_package.Calendar_Date_;

import java.time.LocalDate;

public class Time_Package {
	public static void main(String[] args) {
		
		// java.time 패키지 : format, chrono, temporal, zone 등의 API를 포함.
		// immutable 속성이 있기 때문에 날짜나 시간을 변경하게 되면 새로운 객체를 반환하게 된다.
		// 	-> thread 작업 시에 안전하다.
		// LocalDate의 주요 메소드 : plusYears(), minusMonths(), withDayOfYear() 등
		
		LocalDate ld = LocalDate.now();
		System.out.println(ld);
		
		LocalDate ld2 = ld.plusWeeks(2); // 주 단위로 더하고 빼기
		ld = ld.minusYears(2).plusMonths(3).minusDays(10); // 연월일 단위로 더하고 빼기
		
		System.out.println(ld2);
		System.out.println(ld);
	}
}
