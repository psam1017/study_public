package ch08_abstract_interface_innerclass.test;

import java.util.Scanner;

public class MemberInsert extends Member{

	Scanner sc = new Scanner(System.in);
	
	public MemberInsert(String memberID, String password, String name) {
		super(memberID, password, name);
	}
	
	public void updateAddInfo() {
		String isAdd;
		String address;
		String email;
		
		System.out.println("추가 정보를 입력하시겠습니까?");
		System.out.println("추가 정보를 입력하시려면 Y 또는 y");
		isAdd = sc.nextLine();
		if(isAdd.equals("Y") || isAdd.equals("y")) {
			System.out.print("주소 : ");
			address = sc.nextLine();
			setAddress(address);
			System.out.print("이메일 : ");
			email = sc.nextLine();
			setEmail(email);
		}
	}
	
	public void printMemberInfo() {
		System.out.println("회원님의 가입 정보는 아래와 같습니다.");
		System.out.println(toString());;
	}
	
	public void login() {
		String id;
		String password;
		
		while(true) {
			System.out.println("로그인 정보를 입력해주세요.");
			System.out.print("아이디 : ");
			id = sc.nextLine();
			System.out.print("비밀번호 : ");
			password = sc.nextLine();
			
			if(id.equals(getMemberID()) && password.equals(getPassword())) {
				System.out.println("로그인되었습니다.");
				return;
			}
			else {
				System.out.println("로그인 정보가 불일치합니다.");
			}
		}
	}
}
