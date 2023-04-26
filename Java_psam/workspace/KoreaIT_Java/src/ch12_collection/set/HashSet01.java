package ch12_collection.set;

import java.util.HashSet;
import ch12_collection.member.*;

public class HashSet01 {
	public static void main(String[] args) {
		
		HashSet<HashMember> set = new HashSet<HashMember>();
		
		set.add(new HashMember("홍길동", 30));
		set.add(new HashMember("홍길동", 30));
		
		// 해시코드와 내부의 값이 같으므로 1을 출력. (ex) String, ...
		System.out.println("총 객체 수 : " + set.size());
	}
}
