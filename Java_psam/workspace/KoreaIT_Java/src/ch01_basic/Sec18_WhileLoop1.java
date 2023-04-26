package ch01_basic;

import java.util.Scanner;

public class Sec18_WhileLoop1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String answer = "Y";
		int count = 0;
		
		while(answer.equals("Y") || answer.equals("y")) {
			System.out.print("음악을 재생합니까?");
			answer = sc.nextLine();
			
			if(answer.equals("Y") || answer.equals("y")) {
				count++;
				System.out.println("음악을 " + count + "번 재생했습니다.");
			}
		}
		System.out.println("재생을 종료합니다.");
		sc.close();
	}
}
