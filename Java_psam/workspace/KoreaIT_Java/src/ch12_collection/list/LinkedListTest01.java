package ch12_collection.list;

import ch12_collection.member.*;

public class LinkedListTest01 {
	public static void main(String[] args) {
		
		MemberLinkedList memberList = new MemberLinkedList();
		
		Member lee = new Member(1001, "이지원");
		Member son = new Member(1002, "손민국");
		Member park = new Member(1003, "박서원");
		Member hong = new Member(1004, "홍길동");
		
		memberList.addMember(lee);
		memberList.addMember(son);
		memberList.addMember(park);
		memberList.addMember(hong);
		memberList.showAllMember();
		
		memberList.removeMember(son.getMemberID());
		memberList.showAllMember();
	}
}
