package ch12_collection.member;

import java.util.ArrayList;

public class MemberArrayList {
	
	private ArrayList<Member> arrayList; // 선언만 구현.
	
	public MemberArrayList() {
		this.arrayList = new ArrayList<Member>(); // 생성자를 사용할 때 객체도 같이 생성.
	}
	
	public void addMember(Member member) {
		arrayList.add(member);
	}
	
	public boolean removeMember(int memberID) {
		for(int i = 0; i < arrayList.size(); i++) {
			Member member = arrayList.get(i);
			if(member.getMemberID() == memberID) {
				arrayList.remove(i);
				return true;
			}
		}
		System.out.println(memberID + "번이 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : arrayList)
			System.out.println(member);
		System.out.println();
	}
}
