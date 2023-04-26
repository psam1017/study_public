package ch02_array_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class Sec07_ObjectBinarySearch2 {
	public static void main(String[] args) {
		
		final Comparator<String> STRING_COMPARATOR = new Comparator<String>() {
			
			@Override
			public int compare(String v1, String v2) {
				
				char[] o1 = v1.toCharArray();
				char[] o2 = v2.toCharArray();
				
				char c1, c2;
				
				int length = o1.length > o2.length ? o2.length : o1.length;
				
				if(o1.length != o2.length) {
					for(int i = 0; i < length; i++) {
						c1 = o1[i];
						c2 = o2[i];
						
						if(c1 > c2) {
							return 1;
						}
						else if (c1 < c2){
							return -1;
						}
					}
					if(o1.length > o2.length) {
						return 1;
					}
					else if(o1.length < o2.length) {
						return -1;
					}
				}
				else {
					for(int i = 0; i < length; i++) {
						c1 = o1[i];
						c2 = o2[i];
						
						if(c1 > c2) {
							return 1;
						}
						else if(c1 < c2) {
							return -1;
						}
					}
				}
				return 0;
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
		int index = Arrays.binarySearch(array, name, STRING_COMPARATOR);
		
		if(index >= 0) {
			System.out.println((index + 1) + "번째에서 처음으로 " + array[index] + "을/를 찾았습니다.");
		}
		else {
			System.out.println("배열에 그러한 이름이 없습니다.");
		}
	}
}
