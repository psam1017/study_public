package ch06_sort;

import java.util.Arrays;
import java.util.Stack;

public class Sec08_BetterQuickSort extends Swap {
	public static void main(String[] args) {
		
		int[] array = {9, 5, 7, 2, 1, 4, 8, 3, 6};
		System.out.println("정렬 전 : " + Arrays.toString(array));
		quickSort(array, 0, array.length - 1);
		System.out.println("정렬 후 : " + Arrays.toString(array));
	}
	
	private static void quickSort(int[] a, int left, int right) {
		
		Stack<Integer> leftStack = new Stack<>();
		Stack<Integer> rightStack = new Stack<>();
		
		leftStack.push(left);
		rightStack.push(right);
		
		while(!leftStack.isEmpty()) {
			int pl = left = leftStack.pop();
			int pr = right = rightStack.pop();
			int md = a[(left + right) / 2];
			
			do {
				while(a[pl] < md) { pl++; }
				while(a[pr] > md) { pr--; }
				if(pl <= pr) {
					swap(a, pl++, pr--);
				}
			} while(pl <= pr);
			
			if(left < pr) {
				leftStack.push(left);
				rightStack.push(pr);
			}
			if(right > pl) {
				leftStack.push(pl);
				rightStack.push(right);
			}
		}
	}
}
