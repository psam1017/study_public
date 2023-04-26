package ch01_array;

import java.util.ArrayList;

public class Sec05_PrimeNumber2 {
	public static void main(String[] args) {
		
		// ������� : � ���� n�� ������ ������ � �Ҽ��ε� ������ �������� ������ �Ҽ��̴�.
		// ����� ���翡���� array�� ����ϰ� ������, �� ���̸� 500���� �ߴ�.
		//     -> ��� 1000���� �߿��� 2�� ����� 500���� �Ҽ��� �ƴϴϱ�.
		
		int count = 0;
		ArrayList<Integer> primeList = new ArrayList<>(); // int[] primeArray = new int[500];
		
		primeList.add(2);
		primeList.add(3);
		
		for(int i = 5; i <= 1000; i += 2) {
			
			// init
			boolean isPrimeNumber = true;
			int j = 1;
			int squareRoot = (int)Math.sqrt(i); // int�� ����ȯ�Ͽ����Ƿ� ������ ���̸�, �� �������� �˻��ؾ� �Ѵ�.
			
			// loop
			for(j = 1; primeList.get(j) <= squareRoot; j++) {
				count++;
				if(i % primeList.get(j) == 0) {
					isPrimeNumber = false;
					break;
				}
			}
			
			// exit
			if(isPrimeNumber) {
				primeList.add(i);
			}
		}
		
		System.out.println("�Ҽ� �� ���� : " + primeList.size());
		System.out.println("�������� ������ Ƚ�� : " + count);
	}
}
