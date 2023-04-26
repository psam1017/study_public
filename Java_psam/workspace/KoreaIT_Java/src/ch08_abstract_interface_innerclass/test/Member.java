package ch08_abstract_interface_innerclass.test;

public class Member {
	private final String memberID;
	private String password;
	private String name;
	private String address;
	private String email;
	
	public Member(String memberID, String password, String name) {
		this.memberID = memberID;
		this.password = password;
		this.name = name;
	}

	public String getMemberID() {
		return memberID;
	}
	public String getPassword() {
		return password;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		System.out.println("회원가입 정보는 아래와 같습니다.");
		return "아이디 : " + memberID + ", 이름 : " + name + ", 주소 : " + address + ", 이메일 : " + email;
	}
}
