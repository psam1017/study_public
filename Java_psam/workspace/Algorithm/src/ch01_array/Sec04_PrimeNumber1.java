package ch01_array;

import java.util.ArrayList;

public class Sec04_PrimeNumber1 {
	public static void main(String[] args) {
		
		// ������� : � ���� n�� ������ ������ � �Ҽ��ε� ������ �������� ������ �Ҽ��̴�.
		
		int count = 0;
		int ptr = 0;
		ArrayList<Integer> primeList = new ArrayList<>(); // int[] primeArray = new int[500];
		
		primeList.add(ptr, 2);
		ptr++;
		
		for(int i = 3; i <= 1000; i += 2) {
			
			// init
			int j;
			
			// loop
			for(j = 1; j < ptr; j++) {
				count++;
				if(i % primeList.get(j) == 0) {
					break;
				}
			}
			
			// exit
			if(ptr == j) {
				primeList.add(ptr, i);
				ptr++;
			}
		}
		
		System.out.println("�Ҽ� �� ���� : " + primeList.size());
		System.out.println("�������� ������ Ƚ�� : " + count);
	}
}
