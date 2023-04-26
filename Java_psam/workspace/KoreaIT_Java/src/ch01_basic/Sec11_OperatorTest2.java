package ch01_basic;

import java.util.Scanner;

public class Sec11_OperatorTest2 {
	public static void main(String[] args) {
		
		// 2개의 정수를 입력 받아 합, 차, 곱, 평균, 큰 정수를 출력하기
		int x, y;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("첫 번째 정수 : ");
		x = sc.nextInt();
		System.out.print("두 번째 정수 : ");
		y = sc.nextInt();
		
		System.out.println("두 수의 합 : " + (x + y));
		System.out.println("두 수의 차 : " + Math.abs(x + y));
		System.out.println("두 수의 곱 : " + (x * y));
		System.out.println("두 수의 평균 : " + (x + y) / 2.0);
		System.out.println("더 큰 정수는 " + (x > y ? x : y) + "입니다.");
		
		sc.close();
	}
}
