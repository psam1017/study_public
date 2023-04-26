package ch12_collection.set;

import ch12_collection.member.*;

public class HashSetTest01 {
	public static void main(String[] args) {
		
		MemberHashSet memberHashSet = new MemberHashSet();
		
		Member lee = new Member(1001, "이지원");
		Member son = new Member(1002, "손민국");
		Member park = new Member(1003, "박서형");
		
		memberHashSet.addMember(lee);
		memberHashSet.addMember(son);
		memberHashSet.addMember(park);
		memberHashSet.addMember(new Member(1004, "김대한"));
		memberHashSet.showAllMember();
		
		System.out.print("\n\n---------------------------------------\n\n\n");
		
		// 같은 값의 객체는 중복이므로 저장을 할 수 없다.
		memberHashSet.addMember(lee);
		memberHashSet.showAllMember();
		
		System.out.print("\n\n---------------------------------------\n\n\n");
		
		// 단, 멤버 Class의 해시코드는 회원번호이므로, 같은 회원번호를 가진 인스턴스는 추가할 수 없다. 
		memberHashSet.addMember(new Member(1004, "최승현"));
		memberHashSet.showAllMember();
	}
}
