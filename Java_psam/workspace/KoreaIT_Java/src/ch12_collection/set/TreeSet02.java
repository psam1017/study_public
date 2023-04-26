package ch12_collection.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSet02 {
	public static void main(String[] args) {
		
		// MyComparator는 String 타입의 자료를 역순으로 정렬한다.
		Set<String> treeSet = new TreeSet<String>(new MyComparator());
		
		treeSet.add("aaa");
		treeSet.add("bbb");
		treeSet.add("ccc");
		
		System.out.println(treeSet);
	}
}
