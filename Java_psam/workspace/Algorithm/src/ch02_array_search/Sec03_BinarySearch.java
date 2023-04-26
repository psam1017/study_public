package ch02_array_search;

import java.util.Random;

public class Sec03_BinarySearch {
	public static void main(String[] args) {
		
		/*
		 * 이진 검색
		 * 
		 * 1. 검색값과 중앙값을 비교해서 앞으로, 또는 뒤로 검색하는 기법
		 * 2. (1) 값을 찾거나, (2) 검색 범위가 더 이상 없을 경우 알고리즘이 종료된다.
		 * 3. 자료구조가 정렬되어 있을 때만 사용할 수 있다.
		 * */
		
		int length = 50;
		int[] array = new int[length];
		int number = new Random().nextInt(length);
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i;
		}
		
		System.out.println(number + "을/를 배열에서 이진검색합니다.");
		
		// 맨 앞 index, 맨 끝 index, 중앙값을 매 loop마다 갱신
		int start = 0;
		int end = length - 1;
		boolean isFound = false;
		
		while(start <= end) {
			int median = (start + end) / 2;
			count++;
			System.out.println("현재 중앙값 : " + median);
			if(number == array[median]) {
				isFound = true;
				break;
			}
			else if(number > median) {
				start = median + 1;
			}
			else {
				end = median - 1;
			}
		}
		
		if(isFound) {
			System.out.println(number + "을/를 찾았습니다.");
			System.out.println(count + "회 검색했습니다.");
		}
		else {
			System.out.println(number + "을/를 찾지 못 했습니다.");
		}
	}
}
