package ch01_backup;

import java.util.Arrays;

public class Lotto {

	public static void main(String[] args) {
		
		// 과제 : 난수 생성, 중복 검사, 정렬
		
		// 배열 6자리로 로또 번호 생성하기
		
		// 1. 로또의 첫 번째 값은 중복이 없으니 바로 대입.
		// 2. 새로운 값인지 아닌지 검사하기 위한 boolean 값 생성
		// 3. 중복검사를 할 대상은 총 5번.
		// 4. 중복검사에 실패할 때마다 새로운 난수 생성
		// 5. 검사대상 이전까지의 값들을 모두 비교
		// 6. 중복이 있을 경우 그 대상을 다시 시도
		// 7. 중복검사를 통과한 경우 그 값을 대입
		
		// 8. Arrays.sort() 메서드를 쓰지 않고 정렬하기
		
		final int L_NUM = 6;
		
		int[] lotto = new int[L_NUM];
		lotto[0] = (int)(Math.random() * 45 + 1); // 1
		boolean isNew = true; // 2
		int count = 0;
		
		for(int i = 1; i < lotto.length; i++) { // 3
			int num = (int)(Math.random() * 45 + 1); // 4
			isNew = true;
			
			for(int j = 0; j < i; j++) { // 5, 6
				if(lotto[j] == num){
					i--;
					count++;
					isNew = false;
					break;
				}
			}
			
			if(isNew) // 7
				lotto[i] = num;
		}
		
		System.out.println("시도횟수 : " + count);
		
		for(int i = 0; i < lotto.length; i++) { // 8. 선택정렬 사용.
			for(int j = i + 1; j < lotto.length; j++) {
				if(lotto[i] > lotto[j]) {
					int temp = lotto[i];
					lotto[i] = lotto[j];
					lotto[j] = temp;
				}
			}
		}
		
		System.out.println(Arrays.toString(lotto));
	}

}
