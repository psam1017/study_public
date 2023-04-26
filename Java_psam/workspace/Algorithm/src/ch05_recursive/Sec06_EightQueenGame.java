package ch05_recursive;

import java.util.Scanner;

public class Sec06_EightQueenGame {
	public static void main(String[] args) {
		game();
	}
	
	// int 배열은 초기값이 0이다.
	private static int[][] square = new int[8][8];
	private static final int LENGTH = 8;
	
	private static void game() {
		
		Scanner sc = new Scanner(System.in);
		int row = 0;
		
		// 처음에도 퀸을 놓을 수 있는 공간 보여주기
		showArrangement();
		
		while(row < LENGTH) {
			
			// 게임에 실패한 경우
			boolean isFail = true;
			for(int i = 0; i < LENGTH; i++) {
				if(square[row][i] == 0) {
					isFail = false;
					break;
				}
			}
			
			if(isFail) {
				System.out.println("이런! 더 이상 퀸을 배치할 수 없습니다.");
				System.out.println("당신은 Eight Queen 게임에서 졌습니다.");
				sc.close();
				return;
			}
			
			
			
			// 퀸의 위치 입력 받기
			System.out.println((row + 1) + "행에 퀸을 놓을 차례입니다.");
			System.out.print("어느 열에 퀸을 놓겠습니까?(1~8) ");
			int choice = sc.nextInt() - 1;
			
			// 예외가 발생한 경우
			if(choice < 0 || choice > 7) {
				showArrangement();
				System.out.println("잘못 입력하였습니다.");
				System.out.println("다시 입력하십시오.");
				continue;
			}
			
			
			
			// 컨트롤
			boolean success = false;
			
			if(square[row][choice] == 0) {
				
				// 배치한 행, 열, 대각선에는 배치할 수 없도록.
				// 1. 배치한 칸의 열을 -1로
				for(int i = row + 1; i < LENGTH; i++) {
					square[i][choice] = -1;
				}
				
				// 2. 배치한 행을 다시 선택할 수 없으므로 무시해도 좋음
				// 3-2. 대각선 우하향을 -1로
				int j = choice;
				for(int i = row + 1; i < LENGTH; i++) {
					
					j++;
					if(j == LENGTH) {
						break;
					}
					
					square[i][j] = -1;
				}
				
				// 3-2. 대각선 좌하향을 -1로
				j = choice;
				for(int i = row + 1; i < LENGTH; i++) {
					
					j--;
					if(j == -1) {
						break;
					}
					
					square[i][j] = -1;
				}
				
				// 성공 처리
				success = true;
				square[row][choice] = 1;
				row++;
			}
			
			
			
			// 뷰
			// 퀸을 놓을 수 있는 공간 보여주기
			showArrangement();
			
			// 성공 또는 실패
			if(success) {
				System.out.println(row + "행 " + (choice + 1) + "열에 퀸을 배치했습니다.");
			}
			else {
				System.out.println("그 자리에는 둘 수 없습니다.");
				System.out.println("다시 시도하십시오.");
			}
		}
		
		System.out.println("Eight Queen 게임에서 이겼습니다.");
		sc.close();
	}
	
	private static void showArrangement() {
		for(int i = 0; i < LENGTH; i++) {
			for(int j = 0; j < LENGTH; j++) {
				System.out.print(" " + (square[i][j] == 1 ? "■" : "□") + " ");
			}
			System.out.println();
		}
	}
}
