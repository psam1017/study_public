package ch02_array_search;

import java.util.Arrays;
import java.util.Random;

public class Sec02_Sentinel {
	public static void main(String[] args) {
		
		/*
		 * (반복문과 배열 등을 고려하지 않은 상황에서)검색의 종료 조건은 2가지이다.
		 * 
		 * 1. 검색할 값을 발견하지 못하고 자료를 모두 검색한 경우
		 * 2. 검색할 값과 같은 요소를 발견한 경우
		 * 
		 * 이때, 1번의 조건 판단 수행을 적게 하기 위한 기법이 보초법이다.
		 * 보초법에서는 찾고자 하는 값을 가장 마지막에 두는데, 이렇게 하면 배열의 끝에서 무조건 2번을 만족하기 때문에 1번 조건이 필요 없게 된다.
		 * 하지만, 대부분의 고급 언어에서 보초법이 유용할 것 같진 않다.
		 * */
		
		Random random = new Random();
		int num = 10;
		int[] array = new int[num + 1]; // array[num]에는 무조건 찾고자 하는 값이 들어간다.

		int value = 5;
		
		for(int i = 0; i < array.length - 1; i++) {
			array[i] = random.nextInt(10) + 1;
		}
		array[num] = value;
		
		System.out.println(Arrays.toString(array));
		
		int n = 0;
		while(true) {
			if(array[n] == value) { // 가장 마지막에 검색 값이 들어있으므로 무조건 loop를 탈출할 수 있다.
				break;
			}
			n++;
		}
		
		if(n == num) {
			System.out.println("값을 찾지 못 했습니다.");
		}
		else {
			System.out.println(n + "번째에서 5를 찾았습니다.");
		}
	}
}
