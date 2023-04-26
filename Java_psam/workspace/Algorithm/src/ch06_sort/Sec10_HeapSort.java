package ch06_sort;

import java.util.Arrays;

public class Sec10_HeapSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		heapSort(array);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void bottomUp(int[] a, int left, int right) {
		
		int temp = a[left];
		int child;
		int parent;
		
		for(parent = left; parent < (right + 1) / 2; parent = child) {
			int cl = parent * 2 + 1;
			int cr = cl + 1;
			child = (cr <= right && a[cr] > a[cl]) ? cr : cl;
			if(temp >= a[child]) {
				break;
			}
			a[parent] = a[child];
		}
		a[parent] = temp;
	}
	
	private static void heapSort(int[] a) {
		
		for(int i = (a.length - 1) / 2; i >= 0; i--) {
			bottomUp(a, i, a.length - 1);
		}
		
		for(int i = a.length - 1; i > 0; i--) {
			swap(a, 0, i);
			bottomUp(a, 0, i - 1);
		}
	}
}
