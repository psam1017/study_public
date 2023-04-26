package ch01_basic;

import java.util.Scanner;

public class Sec32_PracticeRSP {
	public static void main(String[] args) {
		
		int select = 0;
		int winCount = 0;
		Scanner sc = new Scanner(System.in);
		
		while(winCount < 5) {
			
			System.out.print(winCount + "번 이겼습니다. 가위(1), 바위(2), 보(3) 중 하나를 입력하세요 : ");
			select = Integer.parseInt(sc.nextLine());
			
			int comSelect = (int)Math.ceil(Math.random() * 3);
			int result = select - comSelect;
			
			System.out.println();
			switch(select) {
			case 1:
				System.out.print("당신은 가위를 냈고,");
				break;
			case 2:
				System.out.print("당신은 바위를 냈고,");
				break;
			case 3:
				System.out.print("당신은 보를 냈고,");
				break;
			default:
				System.out.print("당신은 히든카드를 꺼내들었습니다! ");
			}
			
			switch(comSelect) {
			case 1:
				System.out.print("컴퓨터는 가위를 냈고,");
				break;
			case 2:
				System.out.print("컴퓨터는 바위를 냈고,");
				break;
			case 3:
				System.out.print("컴퓨터는 보를 냈고,");
			}

			switch(result) {
			case 1, -2:
				System.out.println("당신이 이겼습니다.");
				winCount++;
				break;
			case 2, -1:
				System.out.println("당신은 졌습니다.");
				break;
			case 0:
				System.out.println("당신은 비겼습니다.");
				break;
			default:
				System.out.println("당신은 게임을 끝내버렸습니다.");
				winCount = 100;
			}
			System.out.println();
		}
		sc.close();
	}
}
