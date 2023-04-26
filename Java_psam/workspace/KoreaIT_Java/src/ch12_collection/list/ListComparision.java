package ch12_collection.list;

import java.util.*;

public class ListComparision {
	public static void main(String[] args) {
		
		List<String> array = new ArrayList<String>();
		List<String> link = new LinkedList<String>();
		
		long startTime, endTime;
		
		System.out.println("중간에 추가하는 경우");
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			array.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린 시간  : 0.0000" + (endTime - startTime) / 1000 + "초");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			link.add(0, String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린 시간 : 0.0000" + (endTime - startTime) / 1000 + "초");
		
		System.out.println("마지막에 추가하는 경우");
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			array.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("ArrayList 걸린 시간  : 0.0000" + (endTime - startTime) / 1000 + "초");
		
		startTime = System.nanoTime();
		for(int i = 0; i < 10000; i++) {
			link.add(String.valueOf(i));
		}
		endTime = System.nanoTime();
		System.out.println("LinkedList 걸린 시간 : 0.0000" + (endTime - startTime) / 1000 + "초");
	}
}
