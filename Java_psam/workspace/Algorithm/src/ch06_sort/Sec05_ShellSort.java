package ch06_sort;

import java.util.Arrays;

public class Sec05_ShellSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		shellSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void shellSort(int[] a) {
		
		int h;
		int m = 3; // multipleNumber
		
		for(h = 1; h < a.length; h = h * m + 1) {
			;
		}
		
		for( ; h > 0; h /= m) {
			for(int i = h; i < a.length; i++) {
				int j;
				int temp = a[i];
				for(j = i - h; j >= 0; j -= h) {
					if(a[j] > temp) {
						a[j + h] = a[j];
					}
					else {
						break;
					}
				}
				a[j + h] = temp;
			}
		}
	}
}
