package ch12_collection.set;

import java.util.*;

public class HashSet02 {
	public static void main(String[] args) {
		
		HashSet<String> set = new HashSet<String>();
		
		set.add("Java");
		set.add("Java");
		set.add("Python");
		set.add("C#");
		set.add("Servlet/JSP");
		
		System.out.println("HashSet의 총 객체 수 : " + set.size());
		
		System.out.println("\nforeach 문으로 출력하기");
		for(String s : set) {
			System.out.print(s + " ");
		}
		set.remove("Python");
		
		System.out.println("\n\n반복자(Iterator)로 출력하기");
		Iterator<String> iterator = set.iterator(); // 한 번만 사용할 수 있다.
		while(iterator.hasNext()) {
			String element = iterator.next();
			System.out.print(element + " ");
		}
		set.remove("C#");
		
		System.out.println("\n\nforeach 문으로 출력하기");
		for(String s : set) {
			System.out.print(s + " ");
		}
		
		set.clear();
		if(set.isEmpty())
			System.out.println("\n\nset이 비어있습니다.");
	}
}
