package ch02_array_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sec06_ObjectBinarySearch {
	public static void main(String[] args) {
		
		// 1. 문자열의 길이가 같은가?
		// 2. 문자열의 각 자리의 문자가 같은가?
		// 개선 요구 사항 : charAt() 메소드를 호출하는 비용 문제 -> 문자열을 char 배열로 바꾸어 비교 -> Sec07
		
		final Comparator<String> HANGEUL = new Comparator<String>() {
			
			@Override
			public int compare(String o1, String o2) {
				
				char c1, c2;
				
				// 더 짧은 문자열의 길이를 저장. length가 끝날 때까지 일치한다면 긴 쪽이 더 많은 값, 즉 더 큰 값을 가지고 있음.
				int length = o1.length() > o2.length() ? o2.length() : o1.length();
				
				// 문자열의 길이가 다르다면...
				if(o1.length() != o2.length()) {
					for(int i = 0; i < length; i++) {
						c1 = o1.charAt(i);
						c2 = o2.charAt(i);
						
						if(c1 > c2) {
							return 1;
						}
						else if (c1 < c2){
							return -1;
						}
					}
					
					// length만큼의 반복을 마칠 때까지 문자열이 같다면...
					if(o1.length() > o2.length()) {
						return 1;
					}
					else {
						return -1;
					}
				}
				// 문자열의 길이가 같다면...
				else {
					for(int i = 0; i < length; i++) {
						c1 = o1.charAt(i);
						c2 = o2.charAt(i);
						
						if(c1 > c2) {
							return 1;
						}
						else if(c1 < c2) {
							return -1;
						}
					}
					
					// 문자열 길이가 같고, 마지막 문자까지 같다면 같은 문자열로 판단
					return 0;
				}
			}
		};
		
		String[] array = new String[]{
				"강영서", "강영애", "강영지", "김영안", "김영익",
				"김영준", "김익준", "김찬우", "박영범", "박영안",
				"박영후", "박준서", "오예나", "유서범", "이영경",
				"이영우", "이영준", "장경오", "최영오", "최영의",
				"최영의", "최영준", "최영찬", "최영후", "황지안"
		};
		
		String name = array[new Random().nextInt(array.length)];
		System.out.println("찾고자 하는 이름 : " + name);
		
		// 이진 검색을 위해 정렬
		Arrays.sort(array);
		int index = Arrays.binarySearch(array, name, HANGEUL);
		
		if(index >= 0) {
			System.out.println((index + 1) + "번째에서 처음으로 " + array[index] + "을/를 찾았습니다.");
		}
		else {
			System.out.println("배열에 그러한 이름이 없습니다.");
		}
	}
}
