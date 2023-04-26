package ch01_basic;

import java.util.Scanner;

public class Sec14_SwitchTest1 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("성적이 어떻게 됩니까?");
		int score = sc.nextInt();
		String grade = "";

		if(score > 0 && score <= 100) {
			score /= 10;
			switch(score) {
				case 10:
				case 9: grade = "A"; break;
				case 8: grade = "B"; break;
				case 7: grade = "C"; break;
				case 6: grade = "D"; break;
				default: grade = "F";
			}
			System.out.println("학점은 " + grade + "입니다.");
		}
		else {
			System.out.println("잘못 입력된 값입니다.");
		}

		sc.close();
	}
}
