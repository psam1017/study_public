package ch12_collection.member;

public class Member implements Comparable<Member>{
	
	private int memberID;
	private String memberName;
	
	public Member(int memberID, String memberNamel) {
		this.memberID = memberID;
		this.memberName = memberNamel;
	}
	
	public int getMemberID() {
		return memberID;
	}
	
	public void setMemberID(int memberID) {
		this.memberID = memberID;
	}
	
	public String getMemberName() {
		return memberName;
	}
	
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	@Override
	public String toString() {
		return memberName + " 회원님의 아이디는 " + memberID + "입니다.";
	}

	@Override
	public int hashCode() {
		return memberID;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Member) {
			Member member = (Member)obj;
			if(this.memberID == member.memberID)
				return true;
			else
				return false;
		}
		return false;
	}

	@Override
	public int compareTo(Member member) {
		// memberID를 기준으로 내림차순 정렬
		return (this.memberID - member.memberID) * (-1);
	}
}
