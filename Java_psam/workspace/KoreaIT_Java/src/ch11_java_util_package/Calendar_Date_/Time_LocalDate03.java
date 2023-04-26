package ch11_java_util_package.Calendar_Date_;

import java.time.LocalDateTime;

public class Time_LocalDate03 {
	public static void main(String[] args) {
		
		LocalDateTime ldt = LocalDateTime.now();
		System.out.println("오늘날짜 : " + ldt);
		
		LocalDateTime end_time = LocalDateTime.of(2020, 06, 24, 12, 00);
		System.out.println("유통기한 : " + end_time);
		
		if(ldt.isAfter(end_time))
			System.out.println("유통기한이 지났습니다.");
		else
			System.out.println("유통기한이 아직 지나지 않았습니다.");
	}
}
