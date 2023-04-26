package ch12_collection.set;

import java.util.TreeSet;

public class TreeSet01 {
	public static void main(String[] args) {
		
		TreeSet<String> treeSet = new TreeSet<String>();
		
		treeSet.add("홍길동");
		treeSet.add("강감찬");
		treeSet.add("이순신");
		treeSet.add("강감찬"); // 강감찬이 중복이므로 저장되지 않는다.
		
		for(String s : treeSet)
			System.out.println(s); // ㄱ - ㅎ의 오름차순으로 정렬한다.
	}
}
