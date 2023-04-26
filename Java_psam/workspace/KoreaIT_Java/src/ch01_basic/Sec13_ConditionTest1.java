package ch01_basic;

import java.util.Scanner;

public class Sec13_ConditionTest1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("지금은 몇 월입니까?");
		int month = sc.nextInt();
		String season = "";

		if(month > 0 && month <= 12) {
			month /= 3;
			switch(month) {
				case 1: season = "봄"; break;
				case 2: season = "여름"; break;
				case 3: season = "가을"; break;
				default: season = "겨울";
			}
			System.out.println("지금은 " + season + "입니다.");
		}
		else {
			System.out.println("잘못 입력된 값입니다.");
		}

		sc.close();
	}
}
