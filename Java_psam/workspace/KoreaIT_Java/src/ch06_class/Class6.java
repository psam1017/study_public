package ch06_class;

import java.util.Scanner;

public class Class6 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("�ڵ��� �����͸� �Է��Ͻÿ�.");
		System.out.print("�̸� : "); String name = sc.next();
		System.out.print("�� �ʺ� : "); int width = sc.nextInt();
		System.out.print("�� ���� : "); int height = sc.nextInt();
		System.out.print("�� ���� : "); int length = sc.nextInt();
		System.out.print("���ᷮ : "); double fuel = sc.nextDouble();
		
		CarJ myCar = new CarJ(name, width, height, length, fuel);
		
		while(true) {
			System.out.println("���� ��ġ : " + myCar.getX() + ", " + myCar.getY());
			System.out.println("���� ���� : " + myCar.getFuel());
			System.out.println("�̵��Ͻðڽ��ϱ�?\n[Yes = 1 / No = 0]");
			
			if(sc.nextInt() == 0) {
				System.out.println("�õ��� �����մϴ�.");
				break;
			}
			else if(sc.nextInt() != 1) {
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				continue;
			}
			
			System.out.print("X���� �̵��Ÿ� : "); double dx = sc.nextDouble();
			System.out.print("Y���� �̵��Ÿ� : "); double dy = sc.nextDouble();
			
			if(!myCar.move(dx, dy))
				System.out.println("���ᰡ �����մϴ�.");
		}
		
		sc.close();
	}
}
