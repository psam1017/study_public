package myBatis.memberVO;

//CREATE TABLE TABLE_MEMBER(
//		ID VARCHAR2(500) PRIMARY KEY,
//		PW VARCHAR2(500),
//		NAME VARCHAR2(500),
//		AGE NUMBER(3)
//	);

public class MemberVO {
	private String id;
	private String pw;
	private String name;
	private int age;
	
	public MemberVO() {;}
	
	// getter가 있어야지만 member.xml에서 변수를 읽어들일 수 있다.
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}
