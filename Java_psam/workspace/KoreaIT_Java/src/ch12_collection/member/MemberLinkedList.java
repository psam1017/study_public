package ch12_collection.member;

import java.util.LinkedList;

public class MemberLinkedList {
	
	private LinkedList<Member> linkedList; // 선언만 구현.
	
	public MemberLinkedList() {
		this.linkedList = new LinkedList<Member>(); // 생성자를 사용할 때 객체도 같이 생성.
	}
	
	public void addMember(Member member) {
		linkedList.add(member);
	}
	
	public boolean removeMember(int memberID) {
		for(int i = 0; i < linkedList.size(); i++) {
			Member member = linkedList.get(i);
			if(member.getMemberID() == memberID) {
				linkedList.remove(i);
				return true;
			}
		}
		System.out.println(memberID + "번이 존재하지 않습니다.");
		return false;
	}
	
	public void showAllMember() {
		for(Member member : linkedList)
			System.out.println(member);
		System.out.println();
	}
}
