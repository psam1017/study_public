package ch11_java_util_package.Calendar_Date_;

import java.time.LocalDate;

public class Time_LocalDate01 {
	public static void main(String[] args) {
		
		// LocalDate 클래스 사용.
		// withYear(), withDayOfMonth(), ... : 연월일, 월의 일을 변경
		LocalDate ld = LocalDate.now();
		LocalDate new_ld = null;
		int count = 0;
		
		for(int i = 1900; i <= 2100; i++) {
			new_ld = ld.withYear(i);
			if(new_ld.isLeapYear()) {
				System.out.println(new_ld + " is Leap Year!");
				count++;
			}
		}
		
		System.out.println("A total count of leap years are " + count);
	}
}
