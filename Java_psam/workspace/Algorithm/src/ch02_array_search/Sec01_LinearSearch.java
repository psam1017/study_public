package ch02_array_search;

import java.util.Arrays;
import java.util.Random;

public final class Sec01_LinearSearch {
	public static void main(String[] args) {
		
		Random random = new Random();
		int[] array = new int[10];
		boolean isSearching = true;
		
		while(isSearching) {
			for(int i = 0; i < array.length; i++) {
				array[i] = random.nextInt(10) + 1;
			}
			
			System.out.println(Arrays.toString(array));
			
			System.out.println("��� 3�� ��ġ�� �˻��մϴ�.");
			
			for(int i = 0; i < array.length; i++) {
				if(array[i] == 3) {
					System.out.println((i + 1) + "��° index���� 3�� �߰��߽��ϴ�.");
					isSearching = false;
				}
			}
			
			if(isSearching) {
				System.out.println("���� 3�� ã�� �� �߽��ϴ�.\n");
			}
		}
	}
}
