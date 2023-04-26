package ch06_class;

import java.util.Scanner;

public class Class6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("자동차 데이터를 입력하시오.");
		System.out.print("이름 : "); String name = sc.next();
		System.out.print("차 너비 : "); int width = sc.nextInt();
		System.out.print("차 높이 : "); int height = sc.nextInt();
		System.out.print("차 길이 : "); int length = sc.nextInt();
		System.out.print("연료량 : "); double fuel = sc.nextDouble();
		
		CarJ myCar = new CarJ(name, width, height, length, fuel);
		
		while(true) {
			System.out.println("현재 위치 : " + myCar.getX() + ", " + myCar.getY());
			System.out.println("남은 연료 : " + myCar.getFuel());
			System.out.println("이동하시겠습니까?\n[Yes = 1 / No = 0]");
			
			if(sc.nextInt() == 0) {
				System.out.println("시동을 종료합니다.");
				break;
			}
			else if(sc.nextInt() != 1) {
				System.out.println("잘못 입력하였습니다.");
				continue;
			}
			
			System.out.print("X방향 이동거리 : "); double dx = sc.nextDouble();
			System.out.print("Y방향 이동거리 : "); double dy = sc.nextDouble();
			
			if(!myCar.move(dx, dy))
				System.out.println("연료가 부족합니다.");
		}
		
		sc.close();
	}
}
