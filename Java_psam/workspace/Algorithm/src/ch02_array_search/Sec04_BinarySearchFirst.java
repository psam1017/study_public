package ch02_array_search;

public class Sec04_BinarySearchFirst {
	public static void main(String[] args) {
		
		// 이진 검색에서 여러 개의 값 중 첫 번째 값 찾기
		
		int length = 50;
		int[] array = new int[length];
		int number = 17;
		int count = 0;
		
		for(int i = 0; i < array.length; i++) {
			array[i] = i + 1;
		}
		for(int j = 10; j < 20; j++) {
			array[j] = 17;
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
				while(true) {
					median--;
					if(array[median] != number) {
						median += 2;
						System.out.println(median + "번째가 최초의 " + number + "입니다.");
						break;
					}
				}
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
			System.out.println(count + "회 검색했습니다.");
		}
		else {
			System.out.println(number + "을/를 찾지 못 했습니다.");
		}
	}
}
