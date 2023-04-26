package ch12_collection.member;

import java.util.HashMap;
import java.util.Iterator;

public class MemberHashMap {

	private HashMap<Integer, Member> hashMap = null;
	
	public MemberHashMap() {
		hashMap = new HashMap<>();
	};
	
	public void addMember(Member member) {
		hashMap.put(member.getMemberID(), member);
	}
	
	public boolean removeMember(int memberId) {
		if(hashMap.containsKey(memberId)) {
			hashMap.remove(memberId);
			return true;
		}
		
		System.out.println(memberId + "가 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		Iterator<Integer> element = hashMap.keySet().iterator();
		while(element.hasNext()) {
			int key = element.next();
			Member member = hashMap.get(key);
			System.out.println(member);
		}
	}
}
