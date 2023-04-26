package ch01_basic;

import java.util.Scanner;

public class Sec22_WhileLoopTest1 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int input = 1;
		int month = 1;

		while(input != 0) {
			if(month == input) {
				System.out.println("지금은 " + month + "월입니다.");
				month++;
				if(month == 13) {
					break;
				}
			}
			else {
				System.out.println("다음 달은" + input + "월이 아닙니다.");
			}

			System.out.print("다음 달은 몇 월입니까? 중지하려면 0을 입력하세요.");
			input = sc.nextInt();
		}

		System.out.println("한 해 동안 고생하셨습니다.");
		sc.close();
	}
}
