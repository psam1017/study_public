package ch01_basic;

import java.util.Arrays;

public class Sec29_Lotto {
	public static void main(String[] args) {

		int[] lotto = new int[6];
		
		// 논리 : 번호 추출 및 중복검사는 "6번" 실시해야 하며, 중복검사에 실패한 경우 "다시" 시도한다.
		
		// "6번"의 번호 추출 및 중복 검사를 실시.
		for(int i = 0; i < lotto.length; i++) {
			int num = (int)Math.ceil(Math.random() * 45);
			boolean isDup = false;
			
			for(int j = 0; j < i; j++) {
				// 중복이 발생하면 i를 1 빼서 그 값에 대하여 중복 검사를 "다시" 실시.
				if(lotto[j] == num) {
					isDup = true;
					i--;
					break;
				}
			}
			
			if(!isDup) {
				lotto[i] = num;
			}
		}
		
		// Arrays.sort() : 배열의 값들을 오름차순으로 정렬
		// 역순으로 정렬하려면 Collections 클래스가 필요함.
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));
	}
}
