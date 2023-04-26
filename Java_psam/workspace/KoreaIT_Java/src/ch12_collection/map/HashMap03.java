package ch12_collection.map;

import ch12_collection.member.Member;
import ch12_collection.member.MemberHashMap;

public class HashMap03 {
	public static void main(String[] args) {
		
		MemberHashMap mhm = new MemberHashMap();
		
		Member lee = new Member(1001, "이지원");
		Member son = new Member(1002, "손흥민");
		Member park = new Member(1004, "박서원");
		Member hong = new Member(1003, "홍민구");

		mhm.addMember(hong);
		mhm.addMember(son);
		mhm.addMember(lee);
		mhm.addMember(park);
		
		// 순서를 뒤죽박죽으로 넣으면 입력은 그 순서대로 되는데
		// 가져올 때는 hash 값으로 조회를 하고, 그 다음 hash를 찾는 식으로 가져오기 때문에
		// 출력은 hash를 기준으로 순차적으로 출력된다.
		//     -> Member에서 hashCode 메소드를 memberId를 반환하도록 오버라이딩했기 때문이다.
		mhm.showAllMember();
		System.out.println("========================================");
		
		mhm.removeMember(1004);
		mhm.showAllMember();
	}
}
