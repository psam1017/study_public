package ch01_array;

import java.util.ArrayList;

public class Sec05_PrimeNumber2 {
	public static void main(String[] args) {
		
		// 개선방안 : 어떤 정수 n의 제곱근 이하의 어떤 소수로도 나누어 떨어지지 않으면 소수이다.
		// 참고로 교재에서는 array를 사용하고 있으며, 그 길이를 500으로 했다.
		//     -> 적어도 1000까지 중에서 2의 배수인 500개는 소수가 아니니까.
		
		int count = 0;
		ArrayList<Integer> primeList = new ArrayList<>(); // int[] primeArray = new int[500];
		
		primeList.add(2);
		primeList.add(3);
		
		for(int i = 5; i <= 1000; i += 2) {
			
			// init
			boolean isPrimeNumber = true;
			int j = 1;
			int squareRoot = (int)Math.sqrt(i); // int로 형변환하였으므로 내림한 것이며, 이 값까지도 검사해야 한다.
			
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
		
		System.out.println("소수 총 개수 : " + primeList.size());
		System.out.println("나눗셈을 수행한 횟수 : " + count);
	}
}
