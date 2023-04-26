package ch01_basic;

import java.util.Arrays;
import java.util.Scanner;

public class Sec31_PracticeScore {
	public static void main(String[] args) {
		
		boolean run = true;
		int stdNum = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);
		
		while(run) {
			System.out.println("=============================================================");
			System.out.println("1. 학생 수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
			System.out.println("=============================================================");
			System.out.print("선택 : ");
			int selectNo = Integer.parseInt(sc.nextLine());
			
			switch(selectNo) {
			case 2, 3, 4:
				if(scores == null) {
					System.out.println("학생 수부터 입력하십시오.");
					continue;
				}
			}
			
			switch(selectNo) {
			case 1:
				System.out.print("학생은 몇 명입니까?");
				stdNum = Integer.parseInt(sc.nextLine());
				if(stdNum < 0) {
					System.out.println("장난치지 마십시오.");
					break;
				}
				scores = new int[stdNum];
				break;
			case 2:
				try {
					System.out.println("몇 번째 학생의 점수를 입력합니까?");
					int selectStd = Integer.parseInt(sc.nextLine()) - 1;
					System.out.println("점수는 몇 점입니까?");
					int selectScore = Integer.parseInt(sc.nextLine());
					if(selectScore < 0 || selectScore > 100) {
						System.out.println("점수가 잘못 입력되었습니다.");
						break;
					}
					scores[selectStd] = selectScore;
				} catch (Exception e) {
					System.out.println("해당 학생이 존재하지 않거나 점수가 잘못 입력되었습니다.");
					break;
				}
				break;
			case 3:
				System.out.println(Arrays.toString(scores));
				break;
			case 4:
				int sum = 0;
				for(int e : scores) {
					sum += e;
				}
				System.out.println("점수 합계 : " + sum + ", 평균 점수 : " + (sum * 100 / stdNum) / 100.0);
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				sc.close();
				run = false;
				break;
			default:
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
