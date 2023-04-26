package ch01_backup;

import java.time.LocalDate;

public class SwitchStudy {
	public static void main(String[] args) {
		
		// 7월까지는 홀수 달이 31일. 8월부터는 짝수 달이 31일.
		// 윤년(4의 배수인 해)에는 2월이 29일. 이외에 2월은 28일.
		
		LocalDate ld = LocalDate.now();
		int month = ld.getMonthValue();
		
		switch(month) {
			case 1: case 3: case 5: case 7: case 8: case 10: case 12:
				System.out.println(month + "월은 31일까지 있습니다.");
				break;
			case 4: case 6: case 9: case 11:
				System.out.println(month + "월은 30일까지 있습니다.");
				break;
			case 2:
				if(ld.isLeapYear()) {
					System.out.println("2월은 29일까지 있습니다.");
					break;
				}
				System.out.println("2월은 28일까지 있습니다.");
				break;
			default :
				System.out.println("날짜 정보가 정확하지 않습니다.");
				// LocalDate를 사용했으므로 default는 unreachable이다.
		}
	}
}
