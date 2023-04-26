package ch01_array;

import java.util.ArrayList;

public class Sec04_PrimeNumber1 {
	public static void main(String[] args) {
		
		// 개선방안 : 어떤 정수 n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않으면 소수이다.
		
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
		
		System.out.println("소수 총 개수 : " + primeList.size());
		System.out.println("나눗셈을 수행한 횟수 : " + count);
	}
}
