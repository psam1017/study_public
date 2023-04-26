package ch05_recursive;

import java.util.Scanner;

public class Sec06_EightQueenGame {
	public static void main(String[] args) {
		game();
	}
	
	// int �迭�� �ʱⰪ�� 0�̴�.
	private static int[][] square = new int[8][8];
	private static final int LENGTH = 8;
	
	private static void game() {
		
		Scanner sc = new Scanner(System.in);
		int row = 0;
		
		// ó������ ���� ���� �� �ִ� ���� �����ֱ�
		showArrangement();
		
		while(row < LENGTH) {
			
			// ���ӿ� ������ ���
			boolean isFail = true;
			for(int i = 0; i < LENGTH; i++) {
				if(square[row][i] == 0) {
					isFail = false;
					break;
				}
			}
			
			if(isFail) {
				System.out.println("�̷�! �� �̻� ���� ��ġ�� �� �����ϴ�.");
				System.out.println("����� Eight Queen ���ӿ��� �����ϴ�.");
				sc.close();
				return;
			}
			
			
			
			// ���� ��ġ �Է� �ޱ�
			System.out.println((row + 1) + "�࿡ ���� ���� �����Դϴ�.");
			System.out.print("��� ���� ���� ���ڽ��ϱ�?(1~8) ");
			int choice = sc.nextInt() - 1;
			
			// ���ܰ� �߻��� ���
			if(choice < 0 || choice > 7) {
				showArrangement();
				System.out.println("�߸� �Է��Ͽ����ϴ�.");
				System.out.println("�ٽ� �Է��Ͻʽÿ�.");
				continue;
			}
			
			
			
			// ��Ʈ��
			boolean success = false;
			
			if(square[row][choice] == 0) {
				
				// ��ġ�� ��, ��, �밢������ ��ġ�� �� ������.
				// 1. ��ġ�� ĭ�� ���� -1��
				for(int i = row + 1; i < LENGTH; i++) {
					square[i][choice] = -1;
				}
				
				// 2. ��ġ�� ���� �ٽ� ������ �� �����Ƿ� �����ص� ����
				// 3-2. �밢�� �������� -1��
				int j = choice;
				for(int i = row + 1; i < LENGTH; i++) {
					
					j++;
					if(j == LENGTH) {
						break;
					}
					
					square[i][j] = -1;
				}
				
				// 3-2. �밢�� �������� -1��
				j = choice;
				for(int i = row + 1; i < LENGTH; i++) {
					
					j--;
					if(j == -1) {
						break;
					}
					
					square[i][j] = -1;
				}
				
				// ���� ó��
				success = true;
				square[row][choice] = 1;
				row++;
			}
			
			
			
			// ��
			// ���� ���� �� �ִ� ���� �����ֱ�
			showArrangement();
			
			// ���� �Ǵ� ����
			if(success) {
				System.out.println(row + "�� " + (choice + 1) + "���� ���� ��ġ�߽��ϴ�.");
			}
			else {
				System.out.println("�� �ڸ����� �� �� �����ϴ�.");
				System.out.println("�ٽ� �õ��Ͻʽÿ�.");
			}
		}
		
		System.out.println("Eight Queen ���ӿ��� �̰���ϴ�.");
		sc.close();
	}
	
	private static void showArrangement() {
		for(int i = 0; i < LENGTH; i++) {
			for(int j = 0; j < LENGTH; j++) {
				System.out.print(" " + (square[i][j] == 1 ? "��" : "��") + " ");
			}
			System.out.println();
		}
	}
}
