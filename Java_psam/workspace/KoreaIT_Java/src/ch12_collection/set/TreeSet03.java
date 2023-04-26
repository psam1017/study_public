package ch12_collection.set;

import java.util.TreeSet;

public class TreeSet03 {
	public static void main(String[] args) {
		
		TreeSet<Integer> tree = new TreeSet<>();
		
		tree.add(90);
		tree.add(100);
		tree.add(85);
		tree.add(75);
		tree.add(65);
		tree.add(50);
		
		System.out.println(tree);
		
		Integer value = null;
		value = tree.first(); // 가장 낮은 점수 50
		value = tree.last(); // 가장 높은 점수 100

		value = tree.lower(85); // 인자 값 미만 가장 큰 값 75
		value = tree.floor(85); // 인자 값 이하 가장 큰 값 85
		
		value = tree.higher(85); // 인자 값 초과 가장 작은 값 90
		value = tree.ceiling(85); // 인자 값 이상 가장 작은 값 85
		
		while(!tree.isEmpty()) {
			value = tree.pollLast();
			System.out.println("현재 가장 큰 값 : " + value);
		}
	}
}
