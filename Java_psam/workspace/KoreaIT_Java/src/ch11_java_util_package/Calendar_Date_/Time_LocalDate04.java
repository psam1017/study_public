package ch11_java_util_package.Calendar_Date_;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class Time_LocalDate04 {
	public static void main(String[] args) {
		
		/*
		LocalDateTime.with() 메소드에 아래의 값들을 넣어 정보를 얻을 수 있다.
		
		TemporalAdjusters의 메소드로 다음 정보를 알 수 있다.
		firstDayOfYear() : 연도의 첫 번째 일자
		lastDayOfYear() : 연도의 마지막 일자
		firstDayOfMonth() : 월의 첫 번째 일자
		lastDayOfMonth() : 월의 마지막 일자
		firstInMonth(DayOfWeek) : 월의 첫 번째 x요일의 일자
		lastInMonth(DayOfWeek) : 월의 마지막 x요일의 일자
		next(DayOfWeek) : 다음 x요일
		nextOrSame(DayOfWeek) : 오늘을 포함한 다음 x요일
		previous(DayOfWeek) : 지난 x요일
		previousOrSame(DayOfWeek) : 오늘을 포함한 지난 x요일
		 */
		
		LocalDateTime ld = LocalDateTime.now();
		System.out.println(ld.with(TemporalAdjusters.firstDayOfMonth()));
		System.out.println(ld.with(TemporalAdjusters.lastDayOfYear()));
		System.out.println(ld.with(TemporalAdjusters.firstInMonth(DayOfWeek.MONDAY)));
		System.out.println(ld.with(TemporalAdjusters.nextOrSame(DayOfWeek.FRIDAY)));
		System.out.println(ld.with(TemporalAdjusters.previous(DayOfWeek.THURSDAY)));
	}
}
