package ch12_collection.list;

import java.util.LinkedList;

public class LinkedList01 {
	public static void main(String[] args) {
		
		LinkedList<String> linkedList = new LinkedList<String>();
		
		linkedList.add("A");
		linkedList.add("B");
		linkedList.add("C"); // A, B, C
		System.out.println(linkedList);
		
		linkedList.add(1, "D"); // A, D, B, C
		linkedList.addFirst("O"); // O, A, D, B, C
		System.out.println(linkedList);
		
		linkedList.removeLast(); // O, A, D, B
		linkedList.remove(2); // O, A, B
		System.out.println(linkedList);
	}
}
